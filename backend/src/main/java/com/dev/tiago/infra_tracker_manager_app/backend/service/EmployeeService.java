package com.dev.tiago.infra_tracker_manager_app.backend.service;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.Employee;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }
}
