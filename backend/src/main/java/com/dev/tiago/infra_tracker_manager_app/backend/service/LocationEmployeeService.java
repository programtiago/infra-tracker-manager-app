package com.dev.tiago.infra_tracker_manager_app.backend.service;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.*;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.*;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.EmployeeRepository;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.LocationEmployeeRepository;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.LocationRepository;
import com.dev.tiago.infra_tracker_manager_app.backend.utils.mapper.*;
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

    public List<LocationEmployeeDto> findAll(){
        return locationEmployeeMapper.toListDto(locationEmployeeRepository.findAll());
    }

    public LocationEmployeeDto assignEmployeeToLocation(UUID employeeId, UUID locationId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found."));

        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new EntityNotFoundException("Location not found."));

        if (!location.isAvailable()) {
            throw new IllegalArgumentException("The location that you are trying to assign, isn't available.");
        }

        if (!employee.getLocationEmployees().isEmpty()) {
            throw new IllegalArgumentException("The employee " + employee.getFirstName() + " " + employee.getLastName() + " " +
                    "already assigned to a location.");
        }

        if (employee.getEmployeeBuildings().isEmpty()){
            throw new IllegalArgumentException("The employee " + employee.getFirstName() + " " + employee.getLastName() + " " +
                    "doesn't have a building assigned.");
        }

        LocationEmployee locationEmployee = new LocationEmployee();
        locationEmployee.setEmployee(employee);
        locationEmployee.setLocation(location);
        locationEmployee.setAssignedAt(LocalDateTime.now());

        LocationEmployee saved = locationEmployeeRepository.save(locationEmployee);

        employee.getLocationEmployees().add(saved);
        location.getEmployeeAssignments().add(saved);

        return locationEmployeeMapper.toDto(saved);

    }
}
