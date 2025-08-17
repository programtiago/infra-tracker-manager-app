package com.dev.tiago.infra_tracker_manager_app.backend.utils.mapper;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.Building;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.Operation;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.OperationBuilding;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.OperationBuildingDto;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.BuildingRepository;
import com.dev.tiago.infra_tracker_manager_app.backend.repository.OperationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OperationBuildingMapper {

    private final BuildingRepository buildingRepository;
    private final OperationRepository operationRepository;

    public OperationBuildingDto toDto(OperationBuilding operationBuilding){
        if (operationBuilding == null) return null;

        return new OperationBuildingDto(
                operationBuilding.getId(),
                operationBuilding.getOperation().getId(),
                operationBuilding.getBuilding().getId(),
                operationBuilding.getAssignedAt()
        );
    }

    public OperationBuilding toEntity(OperationBuildingDto operationBuildingDto){
        OperationBuilding operationBuilding = new OperationBuilding();

        if (operationBuildingDto.id() != null){
            operationBuilding.setId(operationBuildingDto.id());
        }

        Building building = buildingRepository.findById(operationBuildingDto.buildingId())
                        .orElseThrow(() -> new IllegalArgumentException("Building not found."));

        Operation operation = operationRepository.findById(operationBuildingDto.operationId())
                .orElseThrow(() -> new IllegalArgumentException("Operation not found."));

        operationBuilding.setBuilding(building);
        operationBuilding.setOperation(operation);
        operationBuilding.setAssignedAt(operationBuildingDto.assignedAt());

        return operationBuilding;
    }

    public List<OperationBuildingDto> toListDto(List<OperationBuilding> operationBuildings){
        return operationBuildings.stream()
                .map(this::toDto)
                .toList();
    }

    public List<OperationBuilding> toListEntity(List<OperationBuildingDto> operationBuildingDtos){
        return operationBuildingDtos.stream()
                .map(this::toEntity)
                .toList();
    }
}
