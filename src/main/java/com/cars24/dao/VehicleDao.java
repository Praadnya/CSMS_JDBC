package com.cars24.dao;

import com.cars24.data.entities.VehiclesEntity;

import java.util.List;

public interface VehicleDao {
    public void createVehicle();
    public boolean deleteVehicle();
    public VehiclesEntity selectVehicleById();
    public boolean updateVehicleById();
    public List<VehiclesEntity> selectVehicles();
}
