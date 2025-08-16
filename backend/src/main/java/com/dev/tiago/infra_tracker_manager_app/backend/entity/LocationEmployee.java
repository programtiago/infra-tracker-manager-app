package com.dev.tiago.infra_tracker_manager_app.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TB_LOCATION_EMPLOYEE")
public class LocationEmployee {

    @Id
    @GeneratedValue
    @NotNull(message = "The field 'id' is mandatory.")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @Column(name = "assigned_date", nullable = false)
    private LocalDate assignedDate;
}
