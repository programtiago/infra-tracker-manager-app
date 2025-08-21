package com.dev.tiago.infra_tracker_manager_app.backend.service;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.LocationEmployeeDto;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.LocationEmployeeRepository;
import com.dev.tiago.infra_tracker_manager_app.backend.utils.mapper.LocationEmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LocationEmployeeService {

    private final LocationEmployeeRepository locationEmployeeRepository;
    private final LocationEmployeeMapper locationEmployeeMapper;

    public List<LocationEmployeeDto> findAll(){
        return locationEmployeeMapper.toListDto(locationEmployeeRepository.findAll());
    }

}
