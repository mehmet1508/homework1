package com.example.carrental.dtos;

import java.time.LocalDateTime;

public class MaintenanceDTO {
    private Long id;
    private LocalDateTime purchaseDate;
    private LocalDateTime deliveryDate;
    private boolean checked;
    private DriverDTO DriverDTO;
    private CarDTO carDTO;

    public MaintenanceDTO() {
    }

    public MaintenanceDTO(Long id, LocalDateTime purchaseDate, LocalDateTime deliveryDate, boolean checked) {
        this.id = id;
        this.purchaseDate = purchaseDate;
        this.deliveryDate = deliveryDate;
        this.checked = checked;
    }

    public MaintenanceDTO(Long id, LocalDateTime purchaseDate, LocalDateTime deliveryDate, boolean checked, DriverDTO DriverDTO, CarDTO carDTO) {
        this.id = id;
        this.purchaseDate = purchaseDate;
        this.deliveryDate = deliveryDate;
        this.checked = checked;
        this.DriverDTO = DriverDTO;
        this.carDTO = carDTO;
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
    public DriverDTO getDriverDTO() {
        return DriverDTO;
    }

    public void setDriverDTO(DriverDTO DriverDTO) {
        this.DriverDTO = DriverDTO;
    }

    public CarDTO getCarDTO() {
        return carDTO;
    }

    public void setCarDTO(CarDTO carDTO) {
        this.carDTO = carDTO;
    }
}