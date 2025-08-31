package com.dev.tiago.infra_tracker_manager_app.backend.controller;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.StatusEquipment;
import com.dev.tiago.infra_tracker_manager_app.backend.service.StatusEquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/status")
@RequiredArgsConstructor
public class StatusEquipmentController {

    private final StatusEquipmentService statusEquipmentService;

    @GetMapping("/{id}")
    public StatusEquipment findById(@PathVariable UUID id){
        return statusEquipmentService.findById(id);
    }
}
