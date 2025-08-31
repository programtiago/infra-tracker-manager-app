package com.dev.tiago.infra_tracker_manager_app.backend.service;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.StatusEquipment;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.StatusEquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class StatusEquipmentService {

    private final StatusEquipmentRepository statusEquipmentRepository;

    public StatusEquipment findById(UUID id){
        return statusEquipmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No status found with id " + id));
    }
}
