package com.dev.tiago.infra_tracker_manager_app.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "operation_building", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"operation_id", "building_id"})
})
public class OperationBuilding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "operation_id")
    private Operation operation;

    @ManyToOne(optional = false)
    @JoinColumn(name = "building_id")
    private Building building;

    @Column(name = "assigned_at", nullable = false)
    private LocalDateTime assignedAt;
}
