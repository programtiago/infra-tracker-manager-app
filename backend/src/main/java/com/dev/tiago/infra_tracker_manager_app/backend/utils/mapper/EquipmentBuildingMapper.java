package com.dev.tiago.infra_tracker_manager_app.backend.utils.mapper;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.Building;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.Equipment;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.EquipmentBuilding;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.EquipmentBuildingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EquipmentBuildingMapper {

    public EquipmentBuildingDto toDto(EquipmentBuilding equipmentBuilding){
        if (equipmentBuilding == null ) return null;

        return new EquipmentBuildingDto(
                equipmentBuilding.getId(),
                equipmentBuilding.getEquipment().getId(),
                equipmentBuilding.getBuilding().getId(),
                equipmentBuilding.getAssignedAt()
        );
    }

    public EquipmentBuilding toEntity(EquipmentBuildingDto equipmentBuildingDto,
                                      Equipment equipment,
                                      Building building){
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
}
