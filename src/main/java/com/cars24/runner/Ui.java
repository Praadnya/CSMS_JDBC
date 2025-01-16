package com.cars24.runner;

import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.res.CustomerProfileRes;
import com.cars24.services.impl.CustomerServiceImpl;

import java.util.Scanner;

public class Ui {
    private static CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    private static Scanner scanner  = new Scanner(System.in);
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

}
