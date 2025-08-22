package com.dev.tiago.infra_tracker_manager_app.backend.service;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.EmployeeBuilding;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.BuildingDto;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.EmployeeBuildingDto;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.EmployeeDto;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.BuildingRepository;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.EmployeeBuildingRepository;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.EmployeeRepository;
import com.dev.tiago.infra_tracker_manager_app.backend.utils.mapper.BuildingMapper;
import com.dev.tiago.infra_tracker_manager_app.backend.utils.mapper.EmployeeBuildingMapper;
import com.dev.tiago.infra_tracker_manager_app.backend.utils.mapper.EmployeeMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class EmployeeBuildingService {

    private final EmployeeBuildingRepository employeeBuildingRepository;
    private final EmployeeRepository employeeRepository;
    private final BuildingRepository buildingRepository;

    private final EmployeeBuildingMapper employeeBuildingMapper;
    private final EmployeeMapper employeeMapper;
    private final BuildingMapper buildingMapper;

    public List<EmployeeBuildingDto> findAll(){
        return employeeBuildingMapper.toListDto(employeeBuildingRepository.findAll());
    }

    public EmployeeBuildingDto assignEmployeeToBuilding(UUID employeeId, UUID buildingId){
        EmployeeDto employeeDto = employeeMapper.toDto(employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found.")));

        BuildingDto buildingDto = buildingMapper.toDto(buildingRepository.findById(buildingId)
                .orElseThrow(() -> new EntityNotFoundException("Building not found.")));

        EmployeeBuilding employeeBuilding = new EmployeeBuilding();

        employeeBuilding.setEmployee(employeeMapper.toEntity(employeeDto));
        employeeBuilding.setBuilding(buildingMapper.toEntity(buildingDto));
        employeeBuilding.setAssignedAt(LocalDateTime.now());

        employeeBuildingRepository.save(employeeBuilding);

        return employeeBuildingMapper.toDto(employeeBuilding);
    }
}
