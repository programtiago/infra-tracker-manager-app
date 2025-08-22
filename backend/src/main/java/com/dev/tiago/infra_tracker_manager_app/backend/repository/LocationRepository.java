package com.dev.tiago.infra_tracker_manager_app.backend.repository;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LocationRepository extends JpaRepository<Location, UUID> {

    List<Location> findAllByIsAvailableTrue();
}
