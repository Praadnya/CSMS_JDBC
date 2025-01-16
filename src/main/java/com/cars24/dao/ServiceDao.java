package com.cars24.dao;

import com.cars24.data.entities.ServicesEntity;

import java.util.List;

public interface ServiceDao {
    public void createService();
    public boolean deleteService();
    public ServicesEntity selectServiceById();
    public boolean updateServiceById();
    public List<ServicesEntity> selectServices();
}
