package com.dev.tiago.infra_tracker_manager_app.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "equipment_location", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"equipment_id", "location_id"})
})
public class EquipmentLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    @ManyToOne(optional = false)
    @JoinColumn(name = "location_id")
    private Location location;

    @Column(name = "assigned_at", nullable = false)
    private LocalDateTime assignedAt;
}
