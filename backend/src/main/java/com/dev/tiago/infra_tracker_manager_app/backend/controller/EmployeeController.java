package com.dev.tiago.infra_tracker_manager_app.backend.controller;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.Employee;
import com.dev.tiago.infra_tracker_manager_app.backend.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> findAll(){
        return employeeService.findAll();
    }
}
