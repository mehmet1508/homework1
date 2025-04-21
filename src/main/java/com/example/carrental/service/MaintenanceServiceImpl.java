package com.example.carrental.service;


import com.example.carrental.dtos.CarDTO;
import com.example.carrental.dtos.DriverDTO;
import com.example.carrental.dtos.MaintenanceDTO;
import com.example.carrental.exception.ResourceAlreadyExistsException;
import com.example.carrental.exception.ResourceNotFoundException;
import com.example.carrental.model.Car;
import com.example.carrental.model.Driver;
import com.example.carrental.model.Maintenance;
import com.example.carrental.exception.ErrorMessages;
import com.example.carrental.repository.DriverRepository;
import com.example.carrental.repository.MaintenanceRepository;
import com.example.carrental.repository.CarRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {
    private final MaintenanceRepository MaintenanceRepository;
    private final CarRepository carRepository;
    private final DriverRepository driverRepository;


    public MaintenanceServiceImpl(MaintenanceRepository MaintenanceRepository, CarRepository carRepository, DriverRepository driverRepository) {
        this.MaintenanceRepository = MaintenanceRepository;
        this.carRepository = carRepository;
        this.driverRepository = driverRepository;
    }

    public MaintenanceDTO getMaintenanceById(Long id) {
       Maintenance r = MaintenanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorMessages.ERROR_MAINTENANCE_NOT_FOUND + ": " + id));
        MaintenanceDTO maintenanceDTO = new MaintenanceDTO(r.getId(), r.getPurchaseDate(), r.getDeliveryDate(), r.isChecked());
        DriverDTO DriverDTO = new DriverDTO(r.getDriver().getId(), r.getDriver().getName(), r.getDriver().getAddress(),r.getDriver().getPhone());
        maintenanceDTO.setDriverDTO(DriverDTO);
        CarDTO carDTO = new CarDTO(r.getCar().getId(), r.getCar().getColor(), r.getCar().getModel(), r.getCar().getType(),r.getCar().getColor());
        maintenanceDTO.setCarDTO(carDTO);
        return maintenanceDTO;
    }

    public List<MaintenanceDTO> getAllMaintenance() {
            return MaintenanceRepository.findAll().stream().map(Maintenance::viewAsMaintenanceDTO).toList();
    }

    public MaintenanceDTO createMaintenance(MaintenanceDTO maintenanceDTO) {
        Maintenance maintenance = new Maintenance();
        maintenance.setPurchaseDate(maintenanceDTO.getPurchaseDate());
        maintenance.setDeliveryDate(maintenanceDTO.getDeliveryDate());
        maintenance.setChecked(maintenanceDTO.isChecked());

        Car car = carRepository.findById(maintenanceDTO.getCarDTO().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Car not found with id: " + maintenanceDTO.getCarDTO().getId()));

        Driver driver = driverRepository.findById(maintenanceDTO.getDriverDTO().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Driver not found with id: " + maintenanceDTO.getDriverDTO().getId()));


        maintenance.setCar(car);
        maintenance.setDriver(driver);


        return MaintenanceRepository.save(maintenance).viewAsMaintenanceDTO();
    }


    public MaintenanceDTO updateMaintenance(Long id, MaintenanceDTO MaintenanceDTO) {
        MaintenanceDTO existingMaintenance = getMaintenanceById(id);
        Maintenance Maintenance = new Maintenance(MaintenanceDTO.getId(), MaintenanceDTO.getPurchaseDate(), MaintenanceDTO.getDeliveryDate(), MaintenanceDTO.isChecked());
        return MaintenanceRepository.save(Maintenance).viewAsMaintenanceDTO();
    }

    public void deleteMaintenance(Long id) {
        MaintenanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorMessages.ERROR_MAINTENANCE_NOT_FOUND + ": " + id));
        MaintenanceRepository.deleteById(id);
    }
}
