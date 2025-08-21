package com.dev.tiago.infra_tracker_manager_app.backend.utils.mapper;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.Building;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.Employee;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.EmployeeBuilding;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.EmployeeBuildingDto;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.BuildingRepository;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeeBuildingMapper {

    private final BuildingRepository buildingRepository;
    private final EmployeeRepository employeeRepository;

    public EmployeeBuildingDto toDto(EmployeeBuilding employeeBuilding){
        if (employeeBuilding == null) return null;

        return new EmployeeBuildingDto(
                employeeBuilding.getId(),
                employeeBuilding.getEmployee().getId(),
                employeeBuilding.getBuilding().getId(),
                employeeBuilding.getAssignedAt()
        );
    }

    public EmployeeBuilding toEntity(EmployeeBuildingDto employeeBuildingDto){
        EmployeeBuilding employeeBuilding = new EmployeeBuilding();
        if (employeeBuildingDto.id() != null){
            employeeBuilding.setId(employeeBuildingDto.id());
        }

        Building building = buildingRepository.findById(employeeBuildingDto.buildingId())
                .orElseThrow(() -> new EntityNotFoundException("Building not found."));

        Employee employee = employeeRepository.findById(employeeBuildingDto.employeeId())
                        .orElseThrow(() -> new EntityNotFoundException("Employee not found."));

        employeeBuilding.setBuilding(building);
        employeeBuilding.setEmployee(employee);
        employeeBuilding.setAssignedAt(employeeBuildingDto.assignedAt());

        return employeeBuilding;
    }

    public List<EmployeeBuildingDto> toListDto(List<EmployeeBuilding> employeeBuildings){
        return employeeBuildings.stream()
                .map(this::toDto)
                .toList();
    }

    public List<EmployeeBuilding> toEntityList(List<EmployeeBuildingDto> employeeBuildingDtos){
        return employeeBuildingDtos.stream()
                .map(this::toEntity)
                .toList();
    }
}
