package com.example.carrental.model;
import com.example.carrental.dtos.CarDTO;
import jakarta.persistence.*;


import java.util.List;


@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 32)
    private String brand;
    @Column(length = 32)
    private String model;
    @Column(length = 32)
    private String type;
    @Column(length = 32)
    private String color;



    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Maintenance> maintenances;

    public CarDTO viewAsCarDTO() {
        return new CarDTO(id, brand, model, type,color);
    }

    public Car() {
    }

    public Car(Long id, String brand, String model,String type,String color) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.type=type;
        this.color=color;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public List<Maintenance> getMaintenances() {
        return maintenances;
    }
    public void setMaintenances(List<Maintenance> maintenances) {
        this.maintenances = maintenances;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", type=" + type +
                '}';
    }
}