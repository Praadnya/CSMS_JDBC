package com.cars24.validation;

import com.cars24.data.req.CustomerProfileReq;

public class CustomerProfileValidator {
    public static void validateCustomerProfileReq(CustomerProfileReq customerProfileReq){
        if(customerProfileReq.getEmail() == null && customerProfileReq.getPhone() == null){
            throw new NullPointerException("No Search params given!");
        }
        else if(customerProfileReq.getEmail() != null){
            validateCustomerEmail(customerProfileReq.getEmail());
        }
        else if(customerProfileReq.getPhone() != null){
            validateCustomerPhone(customerProfileReq.getPhone());
        }
    }

    private static void validateCustomerPhone(String phone){
        if(phone.length() != 10) {
            throw new IllegalArgumentException("Phone Number must be 10 digits only!!");
        }
    }

    private static void validateCustomerEmail(String email){
        if(email.length() < 6 || email.length() > 75) {
            throw new IllegalArgumentException("Email ID should be 10 to 75 characters only!!");
        }
    }
}
