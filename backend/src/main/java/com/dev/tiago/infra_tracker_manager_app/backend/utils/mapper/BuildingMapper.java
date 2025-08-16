package com.dev.tiago.infra_tracker_manager_app.backend.utils.mapper;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.Building;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.BuildingDto;
import org.springframework.stereotype.Component;

@Component
public class BuildingMapper {

    public BuildingDto toDto(Building building){
        if (building == null) return null;

        return new BuildingDto(
                building.getId(),
                building.getName(),
                building.getAddress(),
                building.isActive()
        );
    }

    public Building toEntity(BuildingDto dto){
        Building building = new Building();

        if (dto.id() != null){
            building.setId(dto.id());
        }

        building.setName(dto.name());
        building.setAddress(dto.address());
        building.setActive(dto.isActive());

        return building;

    }


}
