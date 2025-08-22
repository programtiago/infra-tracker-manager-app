package com.dev.tiago.infra_tracker_manager_app.backend.service;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.Employee;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.LocationEmployee;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.OperationBuilding;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.*;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.EmployeeBuildingRepository;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.EmployeeRepository;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.LocationEmployeeRepository;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.OperationBuildingRepository;
import com.dev.tiago.infra_tracker_manager_app.backend.utils.mapper.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeBuildingRepository employeeBuildingRepository;
    private final LocationEmployeeRepository locationEmployeeRepository;
    private final OperationBuildingRepository operationBuildingRepository;


    private final EmployeeMapper employeeMapper;
    private final BuildingMapper buildingMapper;
    private final LocationMapper locationMapper;
    private final EmployeeBuildingMapper employeeBuildingMapper;
    private final LocationEmployeeMapper locationEmployeeMapper;
    private final EquipmentLocationMapper equipmentLocationMapper;
    private final OperationBuildingMapper operationBuildingMapper;


    public List<EmployeeDto> findAll(){
        return employeeMapper.toListDto(employeeRepository.findAll());
    }

    public EmployeeDto findById(UUID id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id " + id));

        return employeeMapper.toDto(employee);
    }
}
