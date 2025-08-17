package com.dev.tiago.infra_tracker_manager_app.backend.service;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.Building;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.BuildingDto;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.BuildingRepository;
import com.dev.tiago.infra_tracker_manager_app.backend.utils.mapper.BuildingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BuildingService {

    private final BuildingRepository buildingRepository;
    private final BuildingMapper buildingMapper;

    public List<BuildingDto> findAll(){
        return buildingMapper.toListDto(buildingRepository.findAll());
    }
}
