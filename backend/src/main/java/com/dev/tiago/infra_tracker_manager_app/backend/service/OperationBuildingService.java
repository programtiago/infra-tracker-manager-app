package com.dev.tiago.infra_tracker_manager_app.backend.service;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.OperationBuildingDto;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.OperationBuildingRepository;
import com.dev.tiago.infra_tracker_manager_app.backend.utils.mapper.OperationBuildingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OperationBuildingService {

    private final OperationBuildingRepository operationBuildingRepository;
    private final OperationBuildingMapper operationBuildingMapper;

    public List<OperationBuildingDto> findAll(){
        return operationBuildingMapper.toListDto(operationBuildingRepository.findAll());
    }
}
