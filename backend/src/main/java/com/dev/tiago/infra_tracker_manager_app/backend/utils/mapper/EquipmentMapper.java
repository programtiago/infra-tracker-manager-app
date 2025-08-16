package com.dev.tiago.infra_tracker_manager_app.backend.utils.mapper;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.Equipment;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.EquipmentType;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.StatusEquipment;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.EquipmentBuildingDto;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.EquipmentLocationDto;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.NewEquipmentRequestDto;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.EquipmentDto;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.EquipmentTypeRepository;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.StatusEquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class EquipmentMapper {

    private final StatusEquipmentRepository statusEquipmentRepository;
    private final EquipmentTypeRepository equipmentTypeRepository;

    private final EquipmentBuildingMapper equipmentBuildingMapper;
    private final EquipmentLocationMapper equipmentLocationMapper;

    public EquipmentDto toDto(Equipment equipment){
        if (equipment == null) return null;

        UUID statusId = Optional.ofNullable(equipment.getStatus())
                .map(StatusEquipment::getId)
                .orElse(null);

        UUID categoryId = Optional.ofNullable(equipment.getEquipmentType())
                .map(EquipmentType::getId)
                .orElse(null);

        List<EquipmentBuildingDto> buildingDtos = equipmentBuildingMapper.toListDto(equipment.getEquipmentBuildings());

        List<EquipmentLocationDto> equipmentLocationDtos = equipmentLocationMapper.toListDto(equipment.getEquipmentLocations());

        return new EquipmentDto(
                equipment.getId(),
                equipment.getDescription(),
                equipment.getBrand(),
                equipment.getModel(),
                equipment.getSn(),
                equipment.isActive(),
                equipment.getCreatedAt(),
                statusId,
                categoryId,
                equipment.getUpdatedAt(),
                buildingDtos,
                equipmentLocationDtos
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
                requestDto.status_id(),
                requestDto.equipment_category_id(),
                requestDto.updatedAt(),
                null,
                null
        );
    }

    public Equipment toEntity(NewEquipmentRequestDto requestDto){
        StatusEquipment status = statusEquipmentRepository.findById(requestDto.status_id())
                .orElseThrow(() -> new IllegalArgumentException("Status not found."));

        EquipmentType category = equipmentTypeRepository.findById(requestDto.equipment_category_id())
                .orElseThrow(() -> new IllegalArgumentException("Category not found."));

        return new Equipment(
                requestDto.id(),
                requestDto.description(),
                requestDto.brand(),
                requestDto.model(),
                requestDto.sn(),
                requestDto.isActive(),
                requestDto.createdAt(),
                status,
                category,
                requestDto.updatedAt(),
                null,
                null
        );
    }
}
