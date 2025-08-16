package com.dev.tiago.infra_tracker_manager_app.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "TB_EQUIPMENT_LOCATION", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"equipment_id", "location_id"})
})
public class EquipmentLocation {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    @ManyToOne(optional = false)
    @JoinColumn(name = "location_id")
    private Location location;

    @Column(name = "assigned_at", nullable = false)
    private LocalDateTime assignedAt;
}
