package com.dev.tiago.infra_tracker_manager_app.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private UUID id;
    private String description;
    private String address;
    @Column(name = "is_active", nullable = false)
    private boolean isActive;
}
