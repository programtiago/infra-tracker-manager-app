package com.dev.tiago.infra_tracker_manager_app.backend.service;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.EmployeeBuildingDto;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.EmployeeBuildingRepository;
import com.dev.tiago.infra_tracker_manager_app.backend.utils.mapper.EmployeeBuildingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeeBuildingService {

    private final EmployeeBuildingRepository employeeBuildingRepository;
    private final EmployeeBuildingMapper employeeBuildingMapper;

    public List<EmployeeBuildingDto> findAll(){
        return employeeBuildingMapper.toListDto(employeeBuildingRepository.findAll());
    }
}
