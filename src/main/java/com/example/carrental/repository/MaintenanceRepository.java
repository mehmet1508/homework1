package com.example.carrental.repository;
import com.example.carrental.model.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {
}
