package com.cars24.services;

import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.req.UpdateCustomerReq;
import com.cars24.data.res.CustomerProfileRes;

public interface CustomerService {
    String registerCustomer(AddCustomerReq addCustomerReq);
    CustomerProfileRes getCustomerProfile(CustomerProfileReq customerProfileReq);
    String deleteCustomer(CustomerProfileReq customerProfileReq);
    String updateCustomerProfile(UpdateCustomerReq updateCustomerReq);
}
