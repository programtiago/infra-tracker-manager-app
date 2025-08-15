package com.dev.tiago.infra_tracker_manager_app.backend.entity.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

public record UpdateEquipmentRequestDto(
        @NotBlank(message = "The field 'description' its mandatory.")
        @Length(min = 10, max = 150, message = "The field 'description' must be between 10 and 150 characters")
        String description,
        @NotBlank(message = "The field 'brand' its mandatory.")
        @Length(min = 4, max = 50, message = "The field 'brand' must be between 4 and 50 characters")
        String brand,
        @NotBlank(message = "The field 'model' its mandatory.")
        @Length(min = 5, max = 50, message = "The field 'model' must be between 10 and 50 characters")
        String model,
        @Length(min = 4, max = 30, message = "The field 'sn' must be between 4 and 30 characters")
        String sn,
        UUID status_id,
        UUID equipment_category_id

) { }
