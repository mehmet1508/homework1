package com.example.carrental.controller;
import com.example.carrental.dtos.MaintenanceDTO;
import com.example.carrental.model.Maintenance;
import com.example.carrental.repository.MaintenanceRepository;
import com.example.carrental.service.DriverService;
import com.example.carrental.service.MaintenanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.carrental.service.MaintenanceServiceImpl;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MaintenanceController.class);
    private final MaintenanceService maintenanceService;
    private final DriverService driverService;

    public MaintenanceController(MaintenanceService maintenanceService, DriverService driverService) {
        this.maintenanceService = maintenanceService;
        this.driverService = driverService;
    }

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<MaintenanceDTO>> getMaintenances() {
        return new ResponseEntity<>(maintenanceService.getAllMaintenance(), HttpStatus.OK);
    }

    @GetMapping(value = "/get/{id}", produces = "application/json")
    public ResponseEntity<MaintenanceDTO> getMaintenance(@PathVariable Long id) {
        if (id == null || id == 0) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(maintenanceService.getMaintenanceById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<MaintenanceDTO> addMaintenance(@RequestBody MaintenanceDTO maintenanceDTO) {
        return new ResponseEntity<>(maintenanceService.createMaintenance(maintenanceDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MaintenanceDTO> updateMaintenance(@PathVariable Long id, @RequestBody MaintenanceDTO maintenanceDTO) {
        if (id == null || id == 0 || maintenanceDTO == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(maintenanceService.updateMaintenance(id, maintenanceDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Maintenance> deleteMaintenance(@PathVariable Long id) {
        if (id == null || id == 0) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        maintenanceService.deleteMaintenance(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
