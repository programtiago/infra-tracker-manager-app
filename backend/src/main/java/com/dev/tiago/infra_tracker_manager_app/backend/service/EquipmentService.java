package com.dev.tiago.infra_tracker_manager_app.backend.service;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.Equipment;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.EquipmentType;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.StatusEquipment;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.NewEquipmentRequestDto;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.EquipmentDto;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.UpdateEquipmentRequestDto;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.EquipmentRepository;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.EquipmentTypeRepository;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.StatusEquipmentRepository;
import com.dev.tiago.infra_tracker_manager_app.backend.utils.mapper.EquipmentMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

        boolean snExists = equipmentRepository.existsBySn(requestDto.sn());



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

    public EquipmentDto updateStatus(UUID equipmentId, UUID statusId){
        Equipment equipment = equipmentRepository.findById(equipmentId)
                .orElseThrow(() -> new IllegalArgumentException("Equipment not found."));

        StatusEquipment status = statusEquipmentRepository.findById(statusId)
                .orElseThrow(() -> new IllegalArgumentException("Status not found."));

        if (equipment.getStatus().getId().equals(statusId)){
            throw new RuntimeException("The equipment already got the status " + status.getDescription());
        }else{
            equipment.setStatus(status);

            if (equipment.getStatus().getDescription().equals("Damanged") || equipment.getStatus().getDescription().equals("For Warranty") ||
                equipment.getStatus().getDescription().equals("For Scrapping")){
                equipment.setActive(false);
                equipment.setUpdatedAt(LocalDateTime.now());
            }

            equipmentRepository.save(equipment);
        }

        return equipmentMapper.toDto(equipment);
    }

    public EquipmentDto updateData(UUID equipmentId, UpdateEquipmentRequestDto requestDto){
        Equipment equipment = equipmentRepository.findById(equipmentId)
                .orElseThrow(() -> new EntityNotFoundException("Equipament not found"));

        EquipmentType category = equipmentTypeRepository.findById(requestDto.equipment_category_id())
                        .orElseThrow(() -> new EntityNotFoundException("Category not found"));

        equipment.setDescription(requestDto.description());
        equipment.setSn(requestDto.sn());
        equipment.setBrand(requestDto.brand());
        equipment.setModel(requestDto.model());
        equipment.setEquipmentType(category);
        equipment.setUpdatedAt(LocalDateTime.now());

        Equipment updated = equipmentRepository.save(equipment);

        return equipmentMapper.toDto(updated);
    }

    public EquipmentDto findById(UUID id){
        Optional<Equipment> optEq = equipmentRepository.findById(id);

        return optEq.map(equipmentMapper::toDto).orElse(null);
    }
}
