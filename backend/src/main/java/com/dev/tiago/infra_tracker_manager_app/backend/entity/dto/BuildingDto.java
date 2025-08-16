package com.dev.tiago.infra_tracker_manager_app.backend.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.List;
import java.util.UUID;

public record BuildingDto(
        UUID id,
        @NotBlank(message = "The field 'name' is mandatory.")
        @Length(min = 10, max = 50, message = "The field 'name' must be between 10 and 50 characters")
        String name,
        @NotBlank(message = "The field 'address' is mandatory.")
        @Length(min = 10, max = 200, message = "The field 'description' must be between 10 and 50 characters")
        String address,
        @NotNull(message = "The field 'is_active' is mandatory.")
        boolean isActive,
        List<LocationDto> locations,
        List<OperationBuildingDto> operationsBuilding
) {
}
