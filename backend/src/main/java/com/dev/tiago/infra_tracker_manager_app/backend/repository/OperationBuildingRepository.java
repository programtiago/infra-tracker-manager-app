package com.dev.tiago.infra_tracker_manager_app.backend.repository;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.OperationBuilding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OperationBuildingRepository extends JpaRepository<OperationBuilding, UUID> {
}
