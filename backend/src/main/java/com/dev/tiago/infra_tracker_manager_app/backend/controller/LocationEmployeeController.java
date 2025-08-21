package com.dev.tiago.infra_tracker_manager_app.backend.controller;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.LocationEmployeeDto;
import com.dev.tiago.infra_tracker_manager_app.backend.service.LocationEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/location-employees")
@RequiredArgsConstructor
public class LocationEmployeeController {

    private final LocationEmployeeService locationEmployeeService;

    @GetMapping
    public List<LocationEmployeeDto> findAll(){
        return locationEmployeeService.findAll();
    }
}
