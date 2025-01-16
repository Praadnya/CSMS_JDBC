package com.cars24.dao;

import com.cars24.data.entities.CustomersEntity;
import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.res.CustomerProfileRes;

import java.util.List;

public interface CustomerDao {
//    public String createCustomer(String name, String phone, String email, String address);
    public String createCustomer(AddCustomerReq addCustomerReq);
//    public boolean deleteCustomer();
    public CustomerProfileRes getCustomer(CustomerProfileReq customerProfileReq);
//    public boolean updateCustomerById();
//    public List<CustomersEntity> getCustomers();
}
