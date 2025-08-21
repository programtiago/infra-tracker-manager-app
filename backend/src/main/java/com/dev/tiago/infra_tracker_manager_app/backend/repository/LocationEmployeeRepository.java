package com.dev.tiago.infra_tracker_manager_app.backend.repository;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.LocationEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LocationEmployeeRepository extends JpaRepository<LocationEmployee, UUID> {
}
