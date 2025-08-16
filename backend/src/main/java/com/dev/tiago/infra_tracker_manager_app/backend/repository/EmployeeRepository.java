package com.dev.tiago.infra_tracker_manager_app.backend.repository;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
}
