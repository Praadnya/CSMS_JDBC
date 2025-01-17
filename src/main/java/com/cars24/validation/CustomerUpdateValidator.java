package com.cars24.validation;

import com.cars24.data.req.UpdateCustomerReq;

public class CustomerUpdateValidator {
    public static void validateUpdateCustomerReq(UpdateCustomerReq updateCustomerReq) {
        if (updateCustomerReq.getCurrentEmail() == null && updateCustomerReq.getCurrentPhone() == null) {
            throw new NullPointerException("No valid identifier (email or phone) provided to update the customer!");
        }
        if (updateCustomerReq.getUpdatedName() == null &&
                updateCustomerReq.getUpdatedPhone() == null &&
                updateCustomerReq.getUpdatedEmail() == null &&
                updateCustomerReq.getUpdatedAddress() == null) {
            throw new IllegalArgumentException("No fields to update!");
        }

        if (updateCustomerReq.getCurrentEmail() != null) {
            validateEmail(updateCustomerReq.getCurrentEmail());
        }

        if (updateCustomerReq.getCurrentPhone() != null){
            validatePhone(updateCustomerReq.getCurrentPhone());
        }

        if (updateCustomerReq.getUpdatedName() != null) {
            validateName(updateCustomerReq.getUpdatedName());
        }

        if (updateCustomerReq.getUpdatedPhone() != null) {
            validatePhone(updateCustomerReq.getUpdatedPhone());
        }

        if (updateCustomerReq.getUpdatedEmail() != null) {
            validateEmail(updateCustomerReq.getUpdatedEmail());
        }

        if (updateCustomerReq.getUpdatedAddress() != null) {
            validateAddress(updateCustomerReq.getUpdatedAddress());
        }

    }

    private static void validateName(String name){
        if(name.length() < 3 || name.length() > 100 ) {
            throw new IllegalArgumentException("Name should be 3 to 100 characters only!!");
        }
    }

    private static void validatePhone(String phone) {
        if (phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Phone number must be 10 digits only!");
        }
    }

    private static void validateEmail(String email) {
        if (email.length() < 6 || email.length() > 75) {
            throw new IllegalArgumentException("Email ID should be between 6 and 75 characters!");
        }
    }

    private static void validateAddress(String address){
        if(address.length() < 3 || address.length() > 75) {
            throw new IllegalArgumentException("Address should be 5 to 75 characters only!!");
        }
    }
}
