package com.dev.tiago.infra_tracker_manager_app.backend.utils.mapper;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.Equipment;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.EquipmentLocation;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.Location;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.EquipmentLocationDto;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.EquipmentRepository;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EquipmentLocationMapper {

    private final EquipmentRepository equipmentRepository;
    private final LocationRepository locationRepository;

    public EquipmentLocationDto toDto(EquipmentLocation equipmentLocation){
        if (equipmentLocation == null) return null;

        return new EquipmentLocationDto(
                equipmentLocation.getId(),
                equipmentLocation.getEquipment().getId(),
                equipmentLocation.getLocation().getId(),
                equipmentLocation.getAssignedAt()
        );
    }

    public EquipmentLocation toEntity(EquipmentLocationDto equipmentLocationDto){
        EquipmentLocation equipmentLocation = new EquipmentLocation();

        if (equipmentLocationDto.id() != null){
            equipmentLocation.setId(equipmentLocationDto.id());
        }

        Equipment equipment = equipmentRepository.findById(equipmentLocationDto.equipmentId())
                        .orElseThrow(() -> new IllegalArgumentException("Equipment not found."));

        Location location = locationRepository.findById(equipmentLocationDto.locationId())
                .orElseThrow(() -> new IllegalArgumentException("Location not found."));

        equipmentLocation.setEquipment(equipment);
        equipmentLocation.setLocation(location);
        equipmentLocation.setAssignedAt(equipmentLocationDto.assignedAt());

        return equipmentLocation;
    }

    public List<EquipmentLocationDto> toListDto(List<EquipmentLocation> equipmentLocations){
        return equipmentLocations.stream()
                .map(this::toDto)
                .toList();
    }

    public List<EquipmentLocation> toEntityList(List<EquipmentLocationDto> equipmentLocationDtos){
        return equipmentLocationDtos.stream()
                .map(this::toEntity)
                .toList();
    }
}
