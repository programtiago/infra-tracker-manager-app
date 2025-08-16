package com.dev.tiago.infra_tracker_manager_app.backend.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.UUID;

public record LocationDto (
        UUID id,
        String name,
        boolean isActive,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime createdAt,
        UUID buildingId
){ }
