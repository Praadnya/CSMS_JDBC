package com.cars24.dao;

import com.cars24.data.entities.AppointmentsEntity;

import java.util.List;

public interface AppointmentDao {
    public void createAppointment();
    public boolean deleteAppointment();
    public AppointmentsEntity selectAppointmentById();
    public boolean updateAppointmentById();
    public List<AppointmentsEntity> selectAppointments();

}
