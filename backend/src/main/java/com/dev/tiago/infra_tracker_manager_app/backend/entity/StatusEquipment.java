package com.dev.tiago.infra_tracker_manager_app.backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TB_STATUS_EQUIPMENT")
public class StatusEquipment {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    @NotNull
    private UUID id;
    @NotBlank(message = "The field 'description' its mandatory.")
    @Length(min = 5, max = 20, message = "The field 'description' must be between 5 and 20 characters")
    @Column(name = "description", nullable = false)
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "The field 'created_at' its mandatory.")
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @NotNull(message = "The field 'is_active' its mandatory.")
    @Column(name = "is_active", nullable = false)
    private boolean isActive;

}
