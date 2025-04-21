package com.example.carrental.controller;
import com.example.carrental.dtos.DriverDTO;
import com.example.carrental.model.Driver;
import com.example.carrental.repository.DriverRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.carrental.service.DriverServiceImpl;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/driver")
public class DriverController {
    private DriverServiceImpl driverService;

    public DriverController(DriverServiceImpl driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<DriverDTO>> getAllDrivers(){
        return new ResponseEntity<>(driverService.getAllDriver(), HttpStatus.OK);
    }

    @GetMapping(value = "/get/{id}", produces = "application/json")
    public ResponseEntity<DriverDTO> getDriver(@PathVariable Long id) {
        if (id == null || id == 0) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(driverService.getDriverById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<DriverDTO> addDriver(@RequestBody DriverDTO driverDTO) {
        return new ResponseEntity<>(driverService.createDriver(driverDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DriverDTO> updateDriver(@PathVariable Long id, @RequestBody DriverDTO driverDTO) {
        if (id == null || id == 0 || driverDTO == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(driverService.updateDriver(id, driverDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Driver> deleteDriver(@PathVariable Long id) {
        if (id == null || id == 0) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        driverService.deleteDriver(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
