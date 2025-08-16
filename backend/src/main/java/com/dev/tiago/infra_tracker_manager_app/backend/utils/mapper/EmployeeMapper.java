package com.dev.tiago.infra_tracker_manager_app.backend.utils.mapper;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.*;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.BuildingDto;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.EmployeeDto;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.EquipmentDto;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.NewEquipmentRequestDto;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.EquipmentTypeRepository;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.StatusEquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class EmployeeMapper {

    public final BuildingMapper buildingMapper;

    public EmployeeDto toDto(Employee employee){
        if (employee == null) return null;

        BuildingDto buildingDto = buildingMapper.toDto(employee.getBuilding());

        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getWorkerNo(),
                employee.getBirthdayDate(),
                employee.getPhoneNumber(),
                employee.getFunction(),
                employee.getCreatedAt(),
                buildingDto

        );
    }

    public Employee toEntity(EmployeeDto employeeDto){
        Employee employee = new Employee();

        if (employeeDto.id() != null){
            employee.setId(employeeDto.id());
        }

        Building building = buildingMapper.toEntity(employeeDto.building());

        employee.setFirstName(employee.getFirstName());
        employee.setLastName(employeeDto.lastName());
        employee.setEmail(employeeDto.email());
        employee.setWorkerNo(employeeDto.workerNo());
        employee.setBirthdayDate(employeeDto.birthdayDate());
        employee.setPhoneNumber(employeeDto.phoneNumber());
        employee.setCreatedAt(employeeDto.createdAt());
        employee.setBuilding(building);

        return employee;
    }

    public List<EmployeeDto> toListDto(List<Employee> employees){
        return employees.stream()
                .map(this::toDto)
                .toList();
    }

    public List<Employee> toListEntity(List<EmployeeDto> employeesDto) {
        return employeesDto.stream()
                .map(this::toEntity)
                .toList();
    }

    public static BuildingDto toDto(Building building) {
        return new BuildingDto(
                building.getId(),
                building.getName(),
                building.getAddress(),
                building.isActive()
        );
    }
}
