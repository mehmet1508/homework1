package com.example.carrental.model;
import com.example.carrental.dtos.DriverDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.print.Book;
import java.util.List;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String name;
    @Column(length = 100)
    private String address;
    @Column (length=11)
    private String phone;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Maintenance> maintenances;

    public DriverDTO viewAsDriverDTO() {
        return new DriverDTO(id, name, address,phone);
    }

    public Driver() {
    }

    public Driver(Long id, String name, String address,String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone=phone;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public List<Maintenance> getMaintenances() {
        return maintenances;
    }
    public void setMaintenances(List<Maintenance> maintenances) {
        this.maintenances = maintenances;
}

}
