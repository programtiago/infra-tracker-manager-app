package com.dev.tiago.infra_tracker_manager_app.backend.service;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.Equipment;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.EquipmentType;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.StatusEquipment;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.NewEquipmentRequestDto;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.EquipmentDto;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.EquipmentRepository;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.EquipmentTypeRepository;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.StatusEquipmentRepository;
import com.dev.tiago.infra_tracker_manager_app.backend.utils.mapper.EquipmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;
    private final StatusEquipmentRepository statusEquipmentRepository;
    private final EquipmentTypeRepository equipmentTypeRepository;

    private final EquipmentMapper equipmentMapper;

    public List<EquipmentDto> findAll(){
        return equipmentMapper.toListDto(equipmentRepository.findAll());
    }

    public EquipmentDto createNew(NewEquipmentRequestDto requestDto){
       StatusEquipment defaultStatus = statusEquipmentRepository.findByDescription("Available")
               .orElseThrow(() -> new IllegalArgumentException("Status 'Available' not found."));

        EquipmentType category = equipmentTypeRepository.findById(requestDto.equipment_category_id())
                .orElseThrow(() -> new IllegalArgumentException("Category not found."));

       Equipment equipment = new Equipment(
               requestDto.description(),
               requestDto.brand(),
               requestDto.model(),
               requestDto.sn(),
               requestDto.isActive(),
               requestDto.createdAt(),
               defaultStatus,
               category
       );

       equipment.setCreatedAt(LocalDateTime.now());
       equipment.setActive(true);

       Equipment savedEquipment = equipmentRepository.save(equipment);

       return equipmentMapper.toDto(savedEquipment);
    }
}
