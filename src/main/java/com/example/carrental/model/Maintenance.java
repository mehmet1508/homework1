package com.example.carrental.model;

import com.example.carrental.dtos.MaintenanceDTO;
import jakarta.persistence.*;
import com.example.carrental.dtos.CarDTO;
import com.example.carrental.dtos.DriverDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime purchaseDate;
    private LocalDateTime deliveryDate;
    private boolean checked;


    @ManyToOne
    @JoinColumn(name="Driver_id",nullable = false)
    private Driver driver;

    @ManyToOne
    @JoinColumn(name="Car_id",nullable = false)
    private Car car;

    public Maintenance(Long id, LocalDateTime purchaseDate, LocalDateTime deliveryDate, boolean checked) {
    }



    public MaintenanceDTO viewAsMaintenanceDTO() {
        MaintenanceDTO dto = new MaintenanceDTO(this.getId(), this.getPurchaseDate(), this.getDeliveryDate(), this.isChecked());

        if (this.getDriver() != null) {
            dto.setDriverDTO(new DriverDTO(
                    this.getDriver().getId(),
                    this.getDriver().getName(),
                    this.getDriver().getAddress(),
                    this.getDriver().getPhone()
            ));
        }

        if (this.getCar() != null) {
            dto.setCarDTO(new CarDTO(
                    this.getCar().getId(),
                    this.getCar().getBrand(),
                    this.getCar().getModel(),
                    this.getCar().getType(),
                    this.getCar().getColor()
            ));
        }

        return dto;
    }



    public Maintenance() {

    }
    public Maintenance(LocalDateTime purchaseDate, LocalDateTime deliveryDate, boolean checked, Driver driver, Car car) {
        this.purchaseDate = purchaseDate;
        this.deliveryDate = deliveryDate;
        this.checked = checked;
        this.driver = driver;
        this.car = car;

    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }
    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }
    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    public boolean isChecked() {
        return checked;
    }
    public void setChecked(boolean checked) {
        this.checked = checked;
    }
    public Driver getDriver() {
        return driver;
    }
    public void setDriver(Driver driver) {
        this.driver = driver;
    }
    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Maintenance [id=" + id + ", purchaseDate=" + purchaseDate + ", deliveryDate=" + deliveryDate+ ", checked=" + checked + ", driver=" + driver + ", car=" + car +"]";
    }
}