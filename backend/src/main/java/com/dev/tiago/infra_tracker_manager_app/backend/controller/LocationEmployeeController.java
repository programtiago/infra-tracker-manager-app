package com.dev.tiago.infra_tracker_manager_app.backend.controller;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.EmployeeBuildingDto;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.LocationEmployeeDto;
import com.dev.tiago.infra_tracker_manager_app.backend.service.LocationEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/location-employees")
@RequiredArgsConstructor
public class LocationEmployeeController {

    private final LocationEmployeeService locationEmployeeService;

    @GetMapping
    public List<LocationEmployeeDto> findAll(){
        return locationEmployeeService.findAll();
    }

    @PostMapping("/new-assignment")
    public LocationEmployeeDto assignEmployeeToLocation(@RequestParam("employeeId") UUID employeeId, @RequestParam("locationId") UUID locationId){
        return locationEmployeeService.assignEmployeeToLocation(employeeId, locationId);
    }
}
