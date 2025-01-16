package com.cars24.runner;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("Application starts");

        Scanner scanner  = new Scanner(System.in);
        boolean exit = false;
        while (!exit){
            System.out.println("Enter choice: ");
            System.out.println("0. Exit \n1. Add Customer \n2. GetCustomerProfile");
            Integer choice = null;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue; // Skip this iteration and prompt again
            }

            switch (choice){
                case 1:
                    //
                    Ui.addCustomer();
                    break;
                case 2:
                    Ui.getCustomer();
                    break;
                case 0:
                    exit = true;
            }
        }

//        AddCustomerReq addCustomerReq = new AddCustomerReq();
//        addCustomerReq.setName("John1");
//        addCustomerReq.setPhone("9384738291");
//        addCustomerReq.setEmail("john@example.com");
//        addCustomerReq.setAddress("Mumbai");
//
//        CustomerProfileReq customerProfileReq = new CustomerProfileReq();
//        customerProfileReq.setEmail("jane.doe@example.com");
//        customerProfileReq.setPhone("7894455555");
//
//        CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
//
////        String RETURN_MESSAGE = customerServiceImpl.registerCustomer(addCustomerReq);
////        System.out.println(RETURN_MESSAGE);
//
//        CustomerProfileRes customerProfileRes = customerServiceImpl.getCustomerProfile(customerProfileReq);
//        System.out.println(customerProfileRes);
////        System.out.println(customerProfileRes.getName());
////        System.out.println(customerProfileRes.getPhone());
////        System.out.println(customerProfileRes.getEmail());
////        System.out.println(customerProfileRes.getAddress());

        System.out.println("Application stops");
    }
}

