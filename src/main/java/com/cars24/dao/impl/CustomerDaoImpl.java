package com.cars24.dao.impl;

import com.cars24.dao.CustomerDao;
import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.res.CustomerProfileRes;
import com.cars24.util.DbUtil;

import java.sql.*;

public class CustomerDaoImpl implements CustomerDao {
    private static final String INSERT_SUCCESS_MESSAGE = "Customer added successfully!";
    private static final String INSERT_ERROR_MESSAGE = "Error while adding Customer!!";
//    @Override
//    public String createCustomer(String name, String phone, String email, String address) {
//        String insertSQL = "INSERT INTO customers (customer_id, name, phone, email, address) VALUES("
//                +0+","
//                +"'"+name+"',"
//                +"'"+phone+"',"
//                +"'"+email+"',"
//                +"'"+address+"');";
//
//        Connection connection = DbUtil.getDbConnection();
//
//        try(Statement statement = connection.createStatement()){
//            int rowsInserted = statement.executeUpdate(insertSQL);
//            return INSERT_SUCCESS_MESSAGE;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return INSERT_ERROR_MESSAGE;
//        }
//    }

    @Override
    public String createCustomer(AddCustomerReq addCustomerReq) {
        String insertSQL = "INSERT INTO customers (customer_id, name, phone, email, address) VALUES(?,?,?,?,?)";

        Connection connection = DbUtil.getDbConnection();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setInt(1,0);
            preparedStatement.setString(2,addCustomerReq.getName());
            preparedStatement.setString(3,addCustomerReq.getPhone());
            preparedStatement.setString(4,addCustomerReq.getEmail());
            preparedStatement.setString(5,addCustomerReq.getAddress());
            int rowsInserted = preparedStatement.executeUpdate();
            return INSERT_SUCCESS_MESSAGE;
        } catch (SQLException e) {
            return INSERT_ERROR_MESSAGE;
        }
    }

    @Override
    public String deleteCustomer(CustomerProfileReq customerProfileReq) {
        String deleteSQL = "DELETE FROM customers WHERE email = ? OR phone = ?";
        Connection connection = DbUtil.getDbConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setString(1, customerProfileReq.getEmail());
            preparedStatement.setString(2, customerProfileReq.getPhone());
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                return "Customer deleted successfully!";
            } else {
                return "Customer not found!";
            }
        }catch(SQLException e){
            return "An error occurred while deleting the customer!";
        }
    }

    @Override
    public CustomerProfileRes getCustomer(CustomerProfileReq customerProfileReq) {
        String selectSQL = "SELECT name, phone, email, address FROM customers WHERE email = ? OR phone = ?";
        Connection connection = DbUtil.getDbConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1,customerProfileReq.getEmail());
            preparedStatement.setString(2,customerProfileReq.getPhone());
            CustomerProfileRes customerProfileRes = new CustomerProfileRes();

            ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()){
                        customerProfileRes.setName(resultSet.getString("name"));
                        customerProfileRes.setPhone(resultSet.getString("phone"));
                        customerProfileRes.setEmail(resultSet.getString("email"));
                        customerProfileRes.setAddress(resultSet.getString("address"));
                    }
                    return customerProfileRes;
        }catch(SQLException e){
            System.out.println("Data NOT FOUND");
        }
        return null;
    }

}
