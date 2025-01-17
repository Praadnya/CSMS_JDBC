package com.cars24.dao.impl;

import com.cars24.dao.CustomerDao;
import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.req.UpdateCustomerReq;
import com.cars24.data.res.CustomerProfileRes;
import com.cars24.util.DbUtil;

import java.sql.*;

public class CustomerDaoImpl implements CustomerDao {
    private static final String INSERT_SUCCESS_MESSAGE = "Customer added successfully!";
    private static final String INSERT_ERROR_MESSAGE = "Error while adding Customer!!";
    private static final String SELECT_ERROR_MESSAGE = "Error while getting Customer profile!!";
    private static final String DELETE_SUCCESS_MESSAGE = "Customer deleted successfully!";
    private static final String DELETE_ERROR_MESSAGE = "Error while deleting Customer profile!!";
    private static final String UPDATE_SUCCESS_MESSAGE = "Customer profile updated successfully!";
    private static final String UPDATE_ERROR_MESSAGE = "Error while updating Customer profile!!";

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
            preparedStatement.executeUpdate();
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
            preparedStatement.executeUpdate();
            return DELETE_SUCCESS_MESSAGE;

        }catch(SQLException e){
            return DELETE_ERROR_MESSAGE;
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
            System.out.println(SELECT_ERROR_MESSAGE);
        }
        return null;
    }

    @Override
    public String updateCustomer(UpdateCustomerReq updateCustomerReq) {
        StringBuilder updateSQL = getUpdateQuery(updateCustomerReq);

        Connection connection = DbUtil.getDbConnection();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(updateSQL.toString());
            int parameterIndex = 1;

            if (updateCustomerReq.getUpdatedName() != null) {
                preparedStatement.setString(parameterIndex++, updateCustomerReq.getUpdatedName());
            }
            if (updateCustomerReq.getUpdatedPhone() != null) {
                preparedStatement.setString(parameterIndex++, updateCustomerReq.getUpdatedPhone());
            }
            if (updateCustomerReq.getUpdatedEmail() != null) {
                preparedStatement.setString(parameterIndex++, updateCustomerReq.getUpdatedEmail());
            }
            if (updateCustomerReq.getUpdatedAddress() != null) {
                preparedStatement.setString(parameterIndex++, updateCustomerReq.getUpdatedAddress());
            }

            preparedStatement.setString(parameterIndex++, updateCustomerReq.getCurrentEmail());
            preparedStatement.setString(parameterIndex, updateCustomerReq.getCurrentPhone());

            preparedStatement.executeUpdate();
            return UPDATE_SUCCESS_MESSAGE;
        }catch (SQLException e){
            return UPDATE_ERROR_MESSAGE;
        }

    }

    private static StringBuilder getUpdateQuery(UpdateCustomerReq updateCustomerReq) {
        StringBuilder updateSQL = new StringBuilder("UPDATE customers SET ");
        if(updateCustomerReq.getUpdatedName() != null){
            updateSQL.append("name = ?, ");
        }
        if(updateCustomerReq.getUpdatedPhone() != null){
            updateSQL.append("phone = ?, ");
        }
        if(updateCustomerReq.getUpdatedEmail() != null){
            updateSQL.append("email = ?, ");
        }
        if(updateCustomerReq.getUpdatedAddress() != null){
            updateSQL.append("address = ?, ");
        }
        updateSQL.setLength(updateSQL.length() - 2);
        updateSQL.append(" WHERE email = ? OR phone = ?");
        return updateSQL;
    }

}
