package com.dev.tiago.infra_tracker_manager_app.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TB_EMPLOYEE_BUILDING", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"employee_id", "building_id"})
})
public class EmployeeBuilding {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(optional = false)
    @JoinColumn(name = "building_id")
    private Building building;

    @Column(name = "assigned_at", nullable = false)
    @NotNull(message = "The field 'assigned_At' is mandatory.")
    private LocalDateTime assignedAt;
}
