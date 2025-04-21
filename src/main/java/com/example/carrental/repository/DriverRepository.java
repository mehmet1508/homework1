package com.example.carrental.repository;
import com.example.carrental.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
public interface DriverRepository  extends JpaRepository<Driver, Long> {
}
