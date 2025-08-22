package com.dev.tiago.infra_tracker_manager_app.backend.controller;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.EmployeeBuildingDto;
import com.dev.tiago.infra_tracker_manager_app.backend.service.EmployeeBuildingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employee-buildings")
@RequiredArgsConstructor
public class EmployeeBuildingController {

    private final EmployeeBuildingService employeeBuildingService;
    @GetMapping
    public List<EmployeeBuildingDto> findAll(){
        return employeeBuildingService.findAll();
    }

    @PostMapping("/new-assignment")
    public EmployeeBuildingDto assignEmployeeToBuilding(@RequestParam("employeeId") UUID employeeId, @RequestParam("buildingId") UUID buildingId){
        return employeeBuildingService.assignEmployeeToBuilding(employeeId, buildingId);
    }
}
