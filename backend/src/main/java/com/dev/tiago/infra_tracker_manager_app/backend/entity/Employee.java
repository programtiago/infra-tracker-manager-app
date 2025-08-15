package com.dev.tiago.infra_tracker_manager_app.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "TB_EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue
    @NotNull
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String birthdayDate;
    private String phoneNumber;
    private String operation;
    private String function;
    private LocalDateTime createdAt;
}
