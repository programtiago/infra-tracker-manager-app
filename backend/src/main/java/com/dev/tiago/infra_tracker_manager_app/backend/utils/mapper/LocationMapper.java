package com.dev.tiago.infra_tracker_manager_app.backend.utils.mapper;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.Building;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.EquipmentLocation;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.Location;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.LocationEmployee;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.EquipmentLocationDto;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.LocationDto;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.LocationEmployeeDto;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.BuildingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LocationMapper {

    private final BuildingRepository buildingRepository;

    private final LocationEmployeeMapper locationEmployeeMapper;
    private final EquipmentLocationMapper equipmentLocationMapper;


    public LocationDto toDto(Location location){
        if (location == null) return null;

        List<LocationEmployeeDto> locationEmployeeDtos = locationEmployeeMapper.toListDto(location.getEmployeeAssignments());
        List<EquipmentLocationDto> equipmentLocationDtos = equipmentLocationMapper.toListDto(location.getEquipmentLocations());

        return new LocationDto(
                location.getId(),
                location.getName(),
                location.isActive(),
                location.getCreatedAt(),
                location.isAvailable(),
                location.getBuilding().getId(),
                locationEmployeeDtos,
                equipmentLocationDtos
        );
    }

    public Location toEntity(LocationDto locationDto,
                             Building building,
                             List<LocationEmployee> locationEmployees,
                             List<EquipmentLocation> equipmentLocations){
        Location location = new Location();

        if (locationDto.id() != null){
            location.setId(locationDto.id());
        }

        location.setBuilding(building);
        location.setEquipmentLocations(equipmentLocations);
        location.setName(locationDto.name());
        location.setActive(locationDto.isActive());
        location.setEmployeeAssignments(locationEmployees);
        location.setCreatedAt(locationDto.createdAt());

        return location;
    }

    public List<LocationDto> toListDto(List<Location> locations){
        return locations.stream()
                .map(this::toDto)
                .toList();
    }
}
