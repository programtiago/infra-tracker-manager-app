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
@Table(name = "TB_EQUIPMENT")
public class Equipment {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    @NotNull(message = "The field 'id' is mandatory.")
    private UUID id;
    @NotBlank(message = "The field 'description' its mandatory.")
    @Length(min = 10, max = 150, message = "The field 'description' must be between 10 and 150 characters")
    @Column(name = "description", nullable = false)
    private String description;
    @NotBlank(message = "The field 'brand' its mandatory.")
    @Length(min = 4, max = 50, message = "The field 'brand' must be between 4 and 50 characters")
    @Column(name = "brand", nullable = false)
    private String brand;
    @NotBlank(message = "The field 'model' its mandatory.")
    @Length(min = 5, max = 50, message = "The field 'model' must be between 5 and 50 characters")
    @Column(name = "model", nullable = false)
    private String model;
    @Length(min = 4, max = 30, message = "The field 'sn' must be between 4 and 30 characters")
    private String sn;
    @NotNull(message = "The field 'is_active' its mandatory.")
    @Column(name = "is_active", nullable = false)
    private boolean isActive;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "The field 'created_at' its mandatory.")
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private StatusEquipment status;

    @ManyToOne
    @JoinColumn(name = "equipment_category_id")
    private EquipmentType equipmentType;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public Equipment(String description, String brand, String model, String sn, boolean isActive,
                     LocalDateTime createdAt, StatusEquipment status, EquipmentType equipmentType) {
        this.description = description;
        this.brand = brand;
        this.model = model;
        this.sn = sn;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.status = status;
        this.equipmentType = equipmentType;
    }
}
