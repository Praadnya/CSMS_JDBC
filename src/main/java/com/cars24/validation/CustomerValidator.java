package com.cars24.validation;

import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;

public class CustomerValidator {
    public static void validateAddCustomerReq(AddCustomerReq addCustomerReq) {
        validateCustomerName(addCustomerReq.getName());
        validateCustomerPhone(addCustomerReq.getPhone());
        validateCustomerEmail(addCustomerReq.getEmail());
        validateCustomerAddress(addCustomerReq.getAddress());
    }

    private static void validateCustomerName(String name){
        if(name == null){
            throw new IllegalArgumentException("Name cannot be EMPTY!!");
        }
        if(name.length() < 3 || name.length() > 100 ) {
            throw new IllegalArgumentException("Name should be 3 to 100 characters only!!");
        }
    }

    private static void validateCustomerPhone(String phone){
        if(phone == null){
            throw new IllegalArgumentException("Phone Number cannot be EMPTY!!");
        }
        if(phone.length() != 10) {
            throw new IllegalArgumentException("Phone Number must be 10 digits only!!");
        }
    }

    private static void validateCustomerEmail(String email){
        if(email == null){
            throw new IllegalArgumentException("Email ID cannot be EMPTY!!");
        }
        if(email.length() < 6 || email.length() > 75) {
            throw new IllegalArgumentException("Email ID should be 10 to 75 characters only!!");
        }
    }

    private static void validateCustomerAddress(String address){
        if(address == null){
            throw new IllegalArgumentException("Address cannot be EMPTY!!");
        }
        if(address.length() < 3 || address.length() > 75) {
            throw new IllegalArgumentException("Address should be 5 to 75 characters only!!");
        }
    }
}
