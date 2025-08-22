package com.dev.tiago.infra_tracker_manager_app.backend.controller;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.LocationDto;
import com.dev.tiago.infra_tracker_manager_app.backend.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/locations")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @GetMapping
    public List<LocationDto> findAll(){
        return locationService.findAll();
    }

    @GetMapping("/active")
    public List<LocationDto> findAllActive(){
        return locationService.findAllActive();
    }
}
