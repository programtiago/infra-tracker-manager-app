package com.dev.tiago.infra_tracker_manager_app.backend.utils.mapper;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.Building;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.BuildingDto;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.FullBuildingDto;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.LocationDto;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.OperationBuildingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BuildingMapper {

    private final LocationMapper locationMapper;
    private final OperationBuildingMapper operationBuildingMapper;

    public BuildingDto toDto(Building building){
        if (building == null) return null;

        List<LocationDto> locationDtos = locationMapper.toListDto(building.getLocations());
        List<OperationBuildingDto> operationBuildingDtos = operationBuildingMapper.toListDto(building.getOperationBuildings());

        return new BuildingDto(
                building.getId(),
                building.getName(),
                building.getAddress(),
                building.isActive(),
                locationDtos,
                operationBuildingDtos
        );
    }

    public FullBuildingDto toFullDto(Building building,
                                     List<LocationDto> locationDtos,
                                     List<OperationBuildingDto> operationBuildingDtos){
        if (building == null) return null;

        return new FullBuildingDto(
                building.getId(),
                building.getName(),
                building.getAddress(),
                building.isActive(),
                locationDtos,
                operationBuildingDtos
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

    public List<BuildingDto> toListDto(List<Building> buildings){
        return buildings.stream()
                .map(this::toDto)
                .toList();
    }


}
