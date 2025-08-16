package com.dev.tiago.infra_tracker_manager_app.backend.utils.mapper;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.Building;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.Equipment;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.EquipmentBuilding;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.EquipmentBuildingDto;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.BuildingRepository;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.EquipmentBuildingRepository;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.EquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class EquipmentBuildingMapper {

    private final EquipmentBuildingRepository equipmentBuildingRepository;
    private final BuildingRepository buildingRepository;
    private final EquipmentRepository  equipmentRepository;
    public EquipmentBuildingDto toDto(EquipmentBuilding equipmentBuilding){
        if (equipmentBuilding == null ) return null;

        return new EquipmentBuildingDto(
                equipmentBuilding.getId(),
                equipmentBuilding.getEquipment().getId(),
                equipmentBuilding.getBuilding().getId(),
                equipmentBuilding.getAssignedAt()
        );
    }

    public EquipmentBuilding toEntity(EquipmentBuildingDto equipmentBuildingDto){
        EquipmentBuilding equipmentBuilding = new EquipmentBuilding();

        if (equipmentBuildingDto.id() != null){
            equipmentBuilding.setId(equipmentBuildingDto.id());
        }

        if (equipmentBuildingDto.buildingId() == null){
            throw new IllegalArgumentException("Building cannot be null");
        }

        if (equipmentBuildingDto.equipmentId() == null){
            throw new IllegalArgumentException("Equipment cannot be null.");
        }

        Building building = buildingRepository.findById(equipmentBuildingDto.buildingId())
                .orElseThrow(() -> new IllegalArgumentException("Building not found."));

        Equipment equipment = equipmentRepository.findById(equipmentBuildingDto.equipmentId())
                .orElseThrow(() -> new IllegalArgumentException("Equipment not found."));

        equipmentBuilding.setBuilding(building);
        equipmentBuilding.setEquipment(equipment);
        equipmentBuilding.setAssignedAt(equipmentBuildingDto.assignedAt());

        return equipmentBuilding;
    }

    public List<EquipmentBuildingDto> toListDto(List<EquipmentBuilding> equipmentBuildings){
        return equipmentBuildings.stream()
                .map(this::toDto)
                .toList();
    }

    public List<EquipmentBuilding> toListEntity(List<EquipmentBuildingDto> equipmentBuildingDtos){
        return equipmentBuildingDtos.stream()
                .map(this::toEntity)
                .toList();
    }
}
