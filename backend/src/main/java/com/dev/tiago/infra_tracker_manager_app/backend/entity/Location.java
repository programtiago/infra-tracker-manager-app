package com.dev.tiago.infra_tracker_manager_app.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "TB_LOCATION")
public class Location {

    @Id
    @GeneratedValue
    @NotNull(message = "The field 'id' is mandatory.")
    private UUID id;
    @NotBlank(message = "The field 'name' is mandatory.")
    @Length(min = 10, max = 50, message = "The field 'name' must be between 10 and 50 characters.")
    private String name;
    @NotNull(message = "The field 'is_active' is mandatory.")
    @Column(name = "is_active", nullable = false)
    private boolean isActive;
    @NotNull(message = "The field 'created_at' is mandatory.")
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(optional = false)
    private Building building;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<LocationEmployee> employeeAssignments;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EquipmentLocation> equipmentLocations = new ArrayList<>();
}
