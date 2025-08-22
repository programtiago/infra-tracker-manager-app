package com.dev.tiago.infra_tracker_manager_app.backend.service;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.LocationDto;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.LocationRepository;
import com.dev.tiago.infra_tracker_manager_app.backend.utils.mapper.LocationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    public List<LocationDto> findAll(){
        return locationMapper.toListDto(locationRepository.findAll());
    }

    public List<LocationDto> findAllActive(){
        return locationMapper.toListDto(locationRepository.findAllByIsAvailableTrue());
    }
}
