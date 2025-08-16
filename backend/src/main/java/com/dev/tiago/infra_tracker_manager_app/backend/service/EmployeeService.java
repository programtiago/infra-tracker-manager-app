package com.dev.tiago.infra_tracker_manager_app.backend.service;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.Employee;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.EmployeeDto;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.EmployeeRepository;
import com.dev.tiago.infra_tracker_manager_app.backend.utils.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public List<EmployeeDto> findAll(){
        return employeeMapper.toListDto(employeeRepository.findAll());
    }
}
