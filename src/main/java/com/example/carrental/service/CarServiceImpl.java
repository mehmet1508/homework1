package com.example.carrental.service;

import com.example.carrental.dtos.CarDTO;
import com.example.carrental.exception.ErrorMessages;
import com.example.carrental.exception.ResourceAlreadyExistsException;
import com.example.carrental.exception.ResourceNotFoundException;
import com.example.carrental.model.Car;
import com.example.carrental.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public CarDTO getCarById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorMessages.ERROR_CAR_NOT_FOUND + ": " + id)).viewAsCarDTO();
    }

    public List<CarDTO> getAllCars() {
        return carRepository.findAll().stream().map(Car::viewAsCarDTO).toList();
    }

    public CarDTO createCar(CarDTO carDTO) {

        Car car = new Car(carDTO.getId(), carDTO.getBrand(), carDTO.getModel(), carDTO.getType(),carDTO.getColor());
        return carRepository.save(car).viewAsCarDTO();
    }

    public CarDTO updateCar(Long id, CarDTO carDTO) {
        Car existingCar = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car not found with id: " + id));


        existingCar.setBrand(carDTO.getBrand());
        existingCar.setModel(carDTO.getModel());
        existingCar.setType(carDTO.getType());
        existingCar.setColor(carDTO.getColor());

        return carRepository.save(existingCar).viewAsCarDTO();
    }


    public void deleteCar(Long id) {
        carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorMessages.ERROR_CAR_NOT_FOUND + ": " + id));
        carRepository.deleteById(id);
    }


}
