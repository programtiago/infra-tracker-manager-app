package com.dev.tiago.infra_tracker_manager_app.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TB_OPERATION")
public class Operation {

    @Id
    @GeneratedValue
    @NotNull
    private UUID id;
    private String description;
    private boolean isActive;
}
