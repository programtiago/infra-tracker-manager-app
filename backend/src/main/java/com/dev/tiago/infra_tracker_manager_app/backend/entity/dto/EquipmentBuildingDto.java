package com.dev.tiago.infra_tracker_manager_app.backend.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record EquipmentBuildingDto (
        UUID id,
        @NotNull(message = "equipmentId is mandatory")
        UUID equipmentId,
        @NotNull(message = "buildingId is mandatory")
        UUID buildingId,
        @NotNull(message = "buildingId is mandatory")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime assignedAt
) { }
