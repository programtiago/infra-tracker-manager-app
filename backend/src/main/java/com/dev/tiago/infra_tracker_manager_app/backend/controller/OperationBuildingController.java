package com.dev.tiago.infra_tracker_manager_app.backend.controller;

import com.dev.tiago.infra_tracker_manager_app.backend.entity.dto.OperationBuildingDto;
import com.dev.tiago.infra_tracker_manager_app.backend.service.OperationBuildingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/operation-buildings")
@RequiredArgsConstructor
public class OperationBuildingController {

    private final OperationBuildingService operationBuildingService;

    @GetMapping
    public List<OperationBuildingDto> findAll(){
        return operationBuildingService.findAll();
    }
}
