package com.dev.tiago.infra_tracker_manager_app.backend.utils.mapper;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.LocationEmployee;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.LocationEmployeeDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LocationEmployeeMapper {

    public LocationEmployeeDto toDto(LocationEmployee locationEmployee){
        if (locationEmployee == null) return null;

        return new LocationEmployeeDto(
                locationEmployee.getId(),
                locationEmployee.getEmployee().getId(),
                locationEmployee.getLocation().getId(),
                locationEmployee.getAssignedAt()
        );
    }

    public LocationEmployee toEntity(LocationEmployeeDto locationEmployeeDto){
        LocationEmployee locationEmployee = new LocationEmployee();

        if (locationEmployeeDto.id() != null){
            locationEmployee.setId(locationEmployeeDto.id());
        }

        locationEmployee.setEmployee(locationEmployee.getEmployee());
        locationEmployee.setLocation(locationEmployee.getLocation());
        locationEmployee.setAssignedAt(locationEmployeeDto.assignedAt());

        return locationEmployee;
    }

    public List<LocationEmployeeDto> toListDto(List<LocationEmployee> locationEmployees){
        return locationEmployees.stream()
                .map(this::toDto)
                .toList();
    }

    public List<LocationEmployee> toListEntity(List<LocationEmployeeDto> locationEmployeeDtos){
        return locationEmployeeDtos.stream()
                .map(this::toEntity)
                .toList();
    }
}
