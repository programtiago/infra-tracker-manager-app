package com.dev.tiago.infra_tracker_manager_app.backend.repository;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.EmployeeBuilding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EmployeeBuildingRepository extends JpaRepository<EmployeeBuilding, UUID> {

    List<EmployeeBuilding> findAllByEmployeeId(UUID id);
}
