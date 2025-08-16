package com.dev.tiago.infra_tracker_manager_app.backend.entity.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

public record EmployeeDto (
        UUID id,
        @NotBlank(message = "The field 'first_name' its mandatory.")
        @Length(min = 3, max = 20, message = "The field 'first_name' must be between 3 and 20 characters")
        @Column(name = "first_name", nullable = false)
        String firstName,
        @NotBlank(message = "The field 'first_name' its mandatory.")
        @Length(min = 3, max = 20, message = "The field 'last_name' must be between 3 and 20 characters")
        @Column(name = "last_name", nullable = false)
        String lastName,
        @Email
        @Length(min = 20, max = 100, message = "The field 'email' must be between 20 and 100 characters")
        String email,
        @NotBlank(message = "The field 'worker_no' its mandatory.")
        @Column(name = "worker_no", nullable = false)
        String workerNo,
        @NotBlank(message = "The field 'birthday_date' its mandatory.")
        @Length(min = 10, max = 10, message = "The field 'email' must have 10 characters")
        @Column(name = "birthday_date", nullable = false)
        String birthdayDate,
        @Length(min = 10, max = 20, message = "The field 'phone_number' must be between 9 and 20 digits")
        String phoneNumber,
        @NotBlank(message = "The field 'function' its mandatory.")
        @Length(min = 5, max = 20, message = "The field 'function' must be between 5 and 20 characters")
        String function, @NotNull(message = "The field 'function' its mandatory.")
        LocalDateTime createdAt
) { }
