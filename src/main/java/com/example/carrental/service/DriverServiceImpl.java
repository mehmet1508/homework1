package com.example.carrental.service;

import com.example.carrental.dtos.DriverDTO;
import com.example.carrental.exception.ResourceAlreadyExistsException;
import com.example.carrental.exception.ResourceNotFoundException;
import com.example.carrental.model.Driver;
import com.example.carrental.exception.ErrorMessages;
import com.example.carrental.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl  implements DriverService {
    private final   DriverRepository driverRepository;

    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public DriverDTO getDriverById(Long id) {
        return driverRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorMessages.ERROR_DRIVER_NOT_FOUND + ": " + id)).viewAsDriverDTO();
    }

    public List<DriverDTO> getAllDriver() {
        return driverRepository.findAll().stream().map(Driver::viewAsDriverDTO).toList();
    }

    public DriverDTO createDriver(DriverDTO driverDTO) {

        Driver driver = new Driver(driverDTO.getId(), driverDTO.getName(), driverDTO.getAddress(),driverDTO.getPhone());
        return driverRepository.save(driver).viewAsDriverDTO();
    }

    public DriverDTO updateDriver(Long id, DriverDTO driverDTO) {
        Driver existingDriver = driverRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car not found with id: " + id));

        existingDriver.setName(driverDTO.getName());
        existingDriver.setAddress(driverDTO.getAddress());
        existingDriver.setPhone(driverDTO.getPhone());


        return driverRepository.save(existingDriver).viewAsDriverDTO();
    }


    public void deleteDriver(Long id) {
        driverRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorMessages.ERROR_DRIVER_NOT_FOUND + ": " + id));
        driverRepository.deleteById(id);
    }

}
