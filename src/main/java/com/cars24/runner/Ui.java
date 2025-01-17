package com.cars24.runner;

import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.req.UpdateCustomerReq;
import com.cars24.data.res.CustomerProfileRes;
import com.cars24.services.impl.CustomerServiceImpl;

import java.util.Scanner;

public class Ui {
    private static final CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    private static final Scanner scanner  = new Scanner(System.in);
    public static void addCustomer()
    {
        System.out.println("Enter customer details");
        AddCustomerReq addCustomerReq = new AddCustomerReq();

        System.out.print("Enter Name  : ");
        addCustomerReq.setName(scanner.next());
        System.out.print("Enter Phone  : ");
        addCustomerReq.setPhone(scanner.next());
        System.out.print("Enter Email  : ");
        addCustomerReq.setEmail(scanner.next());
        System.out.print("Enter Address  : ");
        addCustomerReq.setAddress(scanner.next());

        String RETURN_MESSAGE = customerServiceImpl.registerCustomer(addCustomerReq);
        System.out.println(RETURN_MESSAGE);
    }

    public static void getCustomer()
    {
        System.out.println("Search customer details");
        CustomerProfileReq customerProfileReq = new CustomerProfileReq();
        System.out.print("Enter Email  : ");
        scanner.nextLine();
        String emailInput = scanner.nextLine();
        customerProfileReq.setEmail(emailInput.isEmpty() ? null : emailInput);
        System.out.print("Enter Phone  : ");
        String phoneInput = scanner.nextLine();
        customerProfileReq.setPhone(phoneInput.isEmpty() ? null : phoneInput);

        CustomerProfileRes customerProfileRes = customerServiceImpl.getCustomerProfile(customerProfileReq);
        System.out.println(customerProfileRes);

    }

    public static void deleteCustomer(){
        System.out.println("To be deleted customer details");
        CustomerProfileReq customerProfileReq = new CustomerProfileReq();
        System.out.print("Enter Email  : ");
        scanner.nextLine();
        String emailInput = scanner.nextLine();
        customerProfileReq.setEmail(emailInput.isEmpty() ? null : emailInput);
        System.out.print("Enter Phone  : ");
        String phoneInput = scanner.nextLine();
        customerProfileReq.setPhone(phoneInput.isEmpty() ? null : phoneInput);

        String RETURN_MESSAGE = customerServiceImpl.deleteCustomer(customerProfileReq);
        System.out.println(RETURN_MESSAGE);
    }

    public static void updateCustomer(){
        System.out.println("Customer profile to be updated details: ");
        UpdateCustomerReq updateCustomerReq = new UpdateCustomerReq();

        // Input current customer details for identification
        System.out.print("Enter Current Email (Press Enter to skip): ");
        String emailInput = scanner.nextLine();
        updateCustomerReq.setCurrentEmail(emailInput.isEmpty() ? null : emailInput);

        System.out.print("Enter Current Phone (Press Enter to skip): ");
        String phoneInput = scanner.nextLine();
        updateCustomerReq.setCurrentPhone(phoneInput.isEmpty() ? null : phoneInput);

        System.out.println("\nEnter updated fields of customer details (Press Enter to skip any field):");

        // Input updated customer details
        System.out.print("Enter Updated Name: ");
        String updatedName = scanner.nextLine();
        updateCustomerReq.setUpdatedName(updatedName.isEmpty() ? null : updatedName);

        System.out.print("Enter Updated Phone: ");
        String updatedPhone = scanner.nextLine();
        updateCustomerReq.setUpdatedPhone(updatedPhone.isEmpty() ? null : updatedPhone);

        System.out.print("Enter Updated Email: ");
        String updatedEmail = scanner.nextLine();
        updateCustomerReq.setUpdatedEmail(updatedEmail.isEmpty() ? null : updatedEmail);

        System.out.print("Enter Updated Address: ");
        String updatedAddress = scanner.nextLine();
        updateCustomerReq.setUpdatedAddress(updatedAddress.isEmpty() ? null : updatedAddress);

        String RETURN_MESSAGE = customerServiceImpl.updateCustomerProfile(updateCustomerReq);
        System.out.println("\n"+RETURN_MESSAGE);
    }

}
