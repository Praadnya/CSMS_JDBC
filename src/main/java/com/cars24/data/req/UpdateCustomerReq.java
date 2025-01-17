package com.cars24.data.req;

public class UpdateCustomerReq {
    String currentPhone;
    String currentEmail;
    String updatedName;
    String updatedPhone;
    String updatedEmail;
    String updatedAddress;

    public String getCurrentPhone() {
        return currentPhone;
    }

    public void setCurrentPhone(String currentPhone) {
        this.currentPhone = currentPhone;
    }

    public String getCurrentEmail() {
        return currentEmail;
    }

    public void setCurrentEmail(String currentEmail) {
        this.currentEmail = currentEmail;
    }

    public String getUpdatedName() {
        return updatedName;
    }

    public void setUpdatedName(String updatedName) {
        this.updatedName = updatedName;
    }

    public String getUpdatedPhone() {
        return updatedPhone;
    }

    public void setUpdatedPhone(String updatedPhone) {
        this.updatedPhone = updatedPhone;
    }

    public String getUpdatedEmail() {
        return updatedEmail;
    }

    public void setUpdatedEmail(String updatedEmail) {
        this.updatedEmail = updatedEmail;
    }

    public String getUpdatedAddress() {
        return updatedAddress;
    }

    public void setUpdatedAddress(String updatedAddress) {
        this.updatedAddress = updatedAddress;
    }
}
