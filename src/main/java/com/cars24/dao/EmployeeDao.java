package com.cars24.dao;

import com.cars24.data.entities.EmployeesEntity;

import java.util.List;

public interface EmployeeDao {
    public void createEmployee();
    public boolean deleteEmployee();
    public EmployeesEntity selectEmployeeById();
    public boolean updateEmployeeById();
    public List<EmployeesEntity> selectEmployees();
}
