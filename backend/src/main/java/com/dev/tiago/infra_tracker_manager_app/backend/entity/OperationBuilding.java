package com.dev.tiago.infra_tracker_manager_app.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TB_OPERATION_BUILDING", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"operation_id", "building_id"})
})
public class OperationBuilding {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "operation_id")
    private Operation operation;

    @ManyToOne(optional = false)
    @JoinColumn(name = "building_id")
    private Building building;

    @Column(name = "assigned_at", nullable = false)
    private LocalDateTime assignedAt;
}
