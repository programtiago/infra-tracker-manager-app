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
@Table(name = "TB_OPERATION")
public class Operation {

    @Id
    @GeneratedValue
    @NotNull(message = "The field 'id' is mandatory.")
    private UUID id;
    @NotBlank(message = "The field 'name' is mandatory.")
    @Length(min = 10, max = 30, message = "The field 'name' must be between 10 and 30 characters")
    private String name;
    @NotNull(message = "The field 'is_active' is mandatory.")
    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @OneToMany(mappedBy = "operation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OperationBuilding> operationBuildings = new ArrayList<>();
}
