package com.dev.tiago.infra_tracker_manager_app.backend.entity.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record EmployeeBuildingDto(
        UUID id,
        UUID employeeId,
        UUID buildingId,
        LocalDateTime assignedAt
) { }
