package com.dev.tiago.infra_tracker_manager_app.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TB_EQUIPMENT_BUILDING", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"equipment_id", "building_id"})
})
public class EquipmentBuilding {

    @Id
    @GeneratedValue
    @NotNull(message = "The field 'id' is mandatory.")
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    @ManyToOne(optional = false)
    @JoinColumn(name = "building_id")
    private Building building;

    @Column(nullable = false)
    private LocalDateTime assignedAt;
}
