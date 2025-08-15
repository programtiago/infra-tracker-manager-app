package com.dev.tiago.infra_tracker_manager_app.backend.controller;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.Equipment;
import com.dev.tiago.infra_tracker_manager_app.backend.service.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/equipments")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;

    @GetMapping
    public List<Equipment> findAll(){
        return equipmentService.findAll();
    }
}
