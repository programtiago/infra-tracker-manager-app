package com.dev.tiago.infra_tracker_manager_app.backend.utils.mapper;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.*;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.BuildingDto;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.EmployeeDto;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.LocationDto;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.OperationBuildingDto;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeeMapper {

    private final BuildingMapper buildingMapper;
    private final OperationBuildingMapper operationBuildingMapper;
    private final LocationMapper locationMapper;
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

    public BuildingDto toDto(Building building) {
        List<OperationBuildingDto> operationBuildingDtos = operationBuildingMapper.toListDto(building.getOperationBuildings());
        List<LocationDto> locationDtos = locationMapper.toListDto(building.getLocations());

        return new BuildingDto(
                building.getId(),
                building.getName(),
                building.getAddress(),
                building.isActive(),
                locationDtos,
                operationBuildingDtos
        );
    }
}
