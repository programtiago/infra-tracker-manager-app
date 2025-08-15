package com.dev.tiago.infra_tracker_manager_app.backend.utils.mapper;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.Equipment;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.NewEquipmentRequestDto;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.EquipmentDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EquipmentMapper {

    public EquipmentDto toDto(Equipment equipment){
        if (equipment == null) return null;

        return new EquipmentDto(
                equipment.getId(),
                equipment.getDescription(),
                equipment.getBrand(),
                equipment.getModel(),
                equipment.getSn(),
                equipment.isActive(),
                equipment.getCreatedAt()
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
                requestDto.createdAt()
        );
    }

    public Equipment toEntity(NewEquipmentRequestDto requestDto){
        return new Equipment(
                requestDto.id(),
                requestDto.description(),
                requestDto.brand(),
                requestDto.model(),
                requestDto.sn(),
                requestDto.isActive(),
                requestDto.createdAt()
        );
    }
}
