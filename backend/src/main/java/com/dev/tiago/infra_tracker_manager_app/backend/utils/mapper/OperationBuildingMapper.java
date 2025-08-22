package com.dev.tiago.infra_tracker_manager_app.backend.utils.mapper;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.Building;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.Operation;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.OperationBuilding;
import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.OperationBuildingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OperationBuildingMapper {

    public OperationBuildingDto toDto(OperationBuilding operationBuilding){
        if (operationBuilding == null) return null;

        return new OperationBuildingDto(
                operationBuilding.getId(),
                operationBuilding.getOperation().getId(),
                operationBuilding.getBuilding().getId(),
                operationBuilding.getAssignedAt()
        );
    }

    public OperationBuilding toEntity(OperationBuildingDto operationBuildingDto,
                                      Building building,
                                      Operation operation){
        OperationBuilding operationBuilding = new OperationBuilding();

        if (operationBuildingDto.id() != null){
            operationBuilding.setId(operationBuildingDto.id());
        }

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
}
