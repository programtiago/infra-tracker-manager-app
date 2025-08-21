package com.dev.tiago.infra_tracker_manager_app.backend.controller;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.EmployeeBuildingDto;
import com.dev.tiago.infra_tracker_manager_app.backend.service.EmployeeBuildingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee-buildings")
@RequiredArgsConstructor
public class EmployeeBuildingController {

    private final EmployeeBuildingService employeeBuildingService;
    @GetMapping
    public List<EmployeeBuildingDto> findAll(){
        return employeeBuildingService.findAll();
    }
}
