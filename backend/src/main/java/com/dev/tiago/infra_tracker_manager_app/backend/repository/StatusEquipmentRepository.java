package com.dev.tiago.infra_tracker_manager_app.backend.repository;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.StatusEquipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StatusEquipmentRepository extends JpaRepository<StatusEquipment, UUID> {

    Optional<StatusEquipment> findByDescription(String description);
}
