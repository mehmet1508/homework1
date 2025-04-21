package com.example.carrental.service;

import com.example.carrental.dtos.CarDTO;

import java.util.List;

public interface CarService {
    public List<CarDTO> getAllCars();
    public CarDTO getCarById(Long id);
    public CarDTO createCar(CarDTO carDTO);
    public CarDTO updateCar(Long id, CarDTO carDTO);
    public void deleteCar(Long id);
}
