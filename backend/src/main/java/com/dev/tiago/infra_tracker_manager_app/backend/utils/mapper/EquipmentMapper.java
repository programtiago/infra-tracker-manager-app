package com.dev.tiago.infra_tracker_manager_app.backend.utils.mapper;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.Equipment;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.StatusEquipment;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.NewEquipmentRequestDto;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.EquipmentDto;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.StatusEquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EquipmentMapper {

    private final StatusEquipmentRepository statusEquipmentRepository;

    public EquipmentDto toDto(Equipment equipment){
        if (equipment == null) return null;

        return new EquipmentDto(
                equipment.getId(),
                equipment.getDescription(),
                equipment.getBrand(),
                equipment.getModel(),
                equipment.getSn(),
                equipment.isActive(),
                equipment.getCreatedAt(),
                equipment.getStatus().getId()
        );
    }

    public Equipment toEntity(EquipmentDto equipmentDto){
        Equipment equipment = new Equipment();

        if (equipmentDto.id() != null){
            equipment.setId(equipmentDto.id());
        }

        equipment.setDescription(equipmentDto.description());
        equipment.setBrand(equipmentDto.brand());
        equipment.setModel(equipmentDto.model());
        equipment.setSn(equipmentDto.sn());
        equipment.setActive(equipmentDto.isActive());
        equipment.setCreatedAt(equipmentDto.createdAt());

        return equipment;
    }

    public List<EquipmentDto> toListDto(List<Equipment> equipments){
        return equipments.stream()
                .map(this::toDto)
                .toList();
    }

    public List<Equipment> toListEntity(List<EquipmentDto> equipmentsDto){
        return equipmentsDto.stream()
                .map(this::toEntity)
                .toList();
    }

    public EquipmentDto toDto(NewEquipmentRequestDto requestDto){
        return new EquipmentDto(
                requestDto.id(),
                requestDto.description(),
                requestDto.brand(),
                requestDto.model(),
                requestDto.sn(),
                requestDto.isActive(),
                requestDto.createdAt(),
                requestDto.status_id()
        );
    }

    public Equipment toEntity(NewEquipmentRequestDto requestDto){
        StatusEquipment status = statusEquipmentRepository.findById(requestDto.status_id())
                .orElseThrow(() -> new IllegalArgumentException("Status not found."));

        return new Equipment(
                requestDto.id(),
                requestDto.description(),
                requestDto.brand(),
                requestDto.model(),
                requestDto.sn(),
                requestDto.isActive(),
                requestDto.createdAt(),
                status
        );
    }
}
