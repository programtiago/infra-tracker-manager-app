package com.dev.tiago.infra_tracker_manager_app.backend.service;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.Equipment;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.EquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;

    public List<Equipment> findAll(){
        return equipmentRepository.findAll();
    }
}
