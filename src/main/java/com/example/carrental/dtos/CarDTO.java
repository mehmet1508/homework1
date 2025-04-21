package com.example.carrental.dtos;

public class CarDTO {
    private Long id;
    private String brand;
    private String model;
    private String color;
    private String type;

    public CarDTO(Long id, String brand, String model, String color, String type) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.type = type;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

