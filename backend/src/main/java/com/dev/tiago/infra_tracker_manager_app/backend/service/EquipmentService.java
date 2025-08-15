package com.dev.tiago.infra_tracker_manager_app.backend.service;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.Equipment;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.EquipmentDto;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.EquipmentRepository;
import com.dev.tiago.infra_tracker_manager_app.backend.utils.mapper.EquipmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;
    private final EquipmentMapper equipmentMapper;

    public List<EquipmentDto> findAll(){
        return equipmentMapper.toListDto(equipmentRepository.findAll());
    }
}
