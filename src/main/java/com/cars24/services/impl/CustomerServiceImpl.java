package com.cars24.services.impl;

import com.cars24.dao.impl.CustomerDaoImpl;
import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.res.CustomerProfileRes;
import com.cars24.services.CustomerService;
import com.cars24.validation.CustomerProfileValidator;
import com.cars24.validation.CustomerValidator;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
    @Override
    public String registerCustomer(AddCustomerReq addCustomerReq) {
        try {
            CustomerValidator.validateAddCustomerReq(addCustomerReq);
            return customerDaoImpl.createCustomer(addCustomerReq);
        }catch (IllegalArgumentException e){
            return e.getMessage();
        }
    }

    @Override
    public CustomerProfileRes getCustomerProfile(CustomerProfileReq customerProfileReq) {
        try{
            CustomerProfileValidator.validateCustomerProfileReq(customerProfileReq);
            return customerDaoImpl.getCustomer(customerProfileReq);
        }catch (IllegalArgumentException | NullPointerException e){
            System.out.println(e.getMessage());
            return null;
        }

    }
}
