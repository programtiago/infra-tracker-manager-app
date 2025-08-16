package com.dev.tiago.infra_tracker_manager_app.backend.entity.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record LocationDto (
        UUID id,
        String name,
        boolean isActive,
        LocalDateTime createdAt,
        UUID buildingId
){ }
