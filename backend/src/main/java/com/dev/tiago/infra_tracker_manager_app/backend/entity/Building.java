package com.dev.tiago.infra_tracker_manager_app.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TB_BUILDING")
public class Building {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue
    @NotNull(message = "The field 'id' is mandatory.")
    private UUID id;
    @NotBlank(message = "The field 'name' is mandatory.")
    @Length(min = 10, max = 50, message = "The field 'name' must be between 10 and 50 characters")
    @Column(name = "name", nullable = false)
    private String name;
    @NotBlank(message = "The field 'address' is mandatory.")
    @Length(min = 10, max = 200, message = "The field 'description' must be between 10 and 50 characters")
    @Column(name = "address", nullable = false)
    private String address;
    @NotNull(message = "The field 'is_active' is mandatory.")
    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL)
    private List<Location> locations = new ArrayList<>();

    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL)
    private List<OperationBuilding> operationBuildings = new ArrayList<>();
}
