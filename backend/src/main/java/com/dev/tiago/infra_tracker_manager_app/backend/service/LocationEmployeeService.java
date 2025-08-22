package com.dev.tiago.infra_tracker_manager_app.backend.service;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.*;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.BuildingDto;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.EmployeeDto;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.LocationDto;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.LocationEmployeeDto;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.EmployeeRepository;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.LocationEmployeeRepository;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.LocationRepository;
import com.dev.tiago.infra_tracker_manager_app.backend.utils.mapper.BuildingMapper;
import com.dev.tiago.infra_tracker_manager_app.backend.utils.mapper.EmployeeMapper;
import com.dev.tiago.infra_tracker_manager_app.backend.utils.mapper.LocationEmployeeMapper;
import com.dev.tiago.infra_tracker_manager_app.backend.utils.mapper.LocationMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class LocationEmployeeService {

    private final LocationEmployeeRepository locationEmployeeRepository;
    private final LocationEmployeeMapper locationEmployeeMapper;
    private final LocationRepository locationRepository;
    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;
    private final LocationMapper locationMapper;
    private final BuildingMapper buildingMapper;

    public List<LocationEmployeeDto> findAll(){
        return locationEmployeeMapper.toListDto(locationEmployeeRepository.findAll());
    }

    public LocationEmployeeDto assignEmployeeToLocation(UUID employeeId, UUID locationId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found."));

        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new EntityNotFoundException("Location not found."));

        LocationEmployee locationEmployee = new LocationEmployee();

        if (!location.isAvailable()){
            throw new IllegalArgumentException("The location that you are trying to assign, isn't available.");
        }

        if (!employee.getLocationEmployees().isEmpty()){
            throw new IllegalArgumentException("The employee " + employee.getFirstName() + " " + employee.getLastName() + " " +
                    "already assigned to a location.");
        }

        locationEmployee.setEmployee(employee);
        locationEmployee.setLocation(location);
        locationEmployee.setAssignedAt(LocalDateTime.now());

        LocationEmployee saved = locationEmployeeRepository.save(locationEmployee);

        return locationEmployeeMapper.toDto(saved);
    }
}
