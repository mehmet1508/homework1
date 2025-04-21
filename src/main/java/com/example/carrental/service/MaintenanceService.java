package com.example.carrental.service;



import com.example.carrental.dtos.MaintenanceDTO;


import java.util.List;

public interface MaintenanceService {
    public List<MaintenanceDTO> getAllMaintenance();
    public MaintenanceDTO getMaintenanceById(Long id);
    public MaintenanceDTO createMaintenance(MaintenanceDTO MaintenanceDTO);
    public MaintenanceDTO updateMaintenance(Long id, MaintenanceDTO maintenanceDTO);
    public void deleteMaintenance(Long id);
}
