package com.dev.tiago.infra_tracker_manager_app.backend.controller;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.NewEquipmentRequestDto;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.EquipmentDto;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.UpdateEquipmentRequestDto;
import com.dev.tiago.infra_tracker_manager_app.backend.service.EquipmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/equipments")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;

    @GetMapping
    public List<EquipmentDto> findAll(){
        return equipmentService.findAll();
    }

    @PostMapping("/new")
    public EquipmentDto create(@RequestBody @Valid NewEquipmentRequestDto requestDto){
        return equipmentService.createNew(requestDto);
    }

    @PutMapping("/{equipmentId}/status/{statusId}")
    public EquipmentDto updateStatus(@PathVariable UUID equipmentId, @PathVariable UUID statusId){
        return equipmentService.updateStatus(equipmentId, statusId);
    }

    @PutMapping("/{id}")
    public EquipmentDto updateData(@PathVariable UUID id, @RequestBody UpdateEquipmentRequestDto requestDto){
        return equipmentService.updateData(id, requestDto);
    }

    @GetMapping("/{id}")
    public EquipmentDto findById(@PathVariable UUID id){
        return equipmentService.findById(id);
    }
}
