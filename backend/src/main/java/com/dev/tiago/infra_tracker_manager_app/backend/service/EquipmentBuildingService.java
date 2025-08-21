package com.dev.tiago.infra_tracker_manager_app.backend.service;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.EquipmentBuildingDto;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.EquipmentBuildingRepository;
import com.dev.tiago.infra_tracker_manager_app.backend.utils.mapper.EquipmentBuildingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EquipmentBuildingService {

    private final EquipmentBuildingRepository equipmentBuildingRepository;
    private final EquipmentBuildingMapper equipmentBuildingMapper;

    public List<EquipmentBuildingDto> findAll(){
        return equipmentBuildingMapper.toListDto(equipmentBuildingRepository.findAll());
    }
}
