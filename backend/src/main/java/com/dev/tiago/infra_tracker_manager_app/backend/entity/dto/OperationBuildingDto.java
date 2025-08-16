package com.dev.tiago.infra_tracker_manager_app.backend.entity.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record OperationBuildingDto(
        UUID id,
        UUID operationId,
        UUID buildingId,
        LocalDateTime assignedAt
) {
}
