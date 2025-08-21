package com.dev.tiago.infra_tracker_manager_app.backend.controller;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.EquipmentBuildingDto;
import com.dev.tiago.infra_tracker_manager_app.backend.service.EquipmentBuildingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/equipment-buildings")
@RequiredArgsConstructor
public class EquipmentBuildingController {

    private final EquipmentBuildingService equipmentBuildingService;

    @GetMapping
    public List<EquipmentBuildingDto> findAll(){
        return equipmentBuildingService.findAll();
    }
}
