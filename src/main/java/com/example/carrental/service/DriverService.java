package com.example.carrental.service;

import com.example.carrental.dtos.DriverDTO;


import java.util.List;

public interface DriverService {
    public List<DriverDTO> getAllDriver();
    public DriverDTO getDriverById(Long id);
    public DriverDTO createDriver(DriverDTO driverDTO);
    public DriverDTO updateDriver(Long id, DriverDTO driverDTO);
    public void deleteDriver(Long id);
}