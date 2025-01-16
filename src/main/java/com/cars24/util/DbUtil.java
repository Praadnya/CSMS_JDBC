package com.cars24.util;

import com.cars24.config.DbConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    private static Connection dbConnection;
    public static Connection getDbConnection(){
        try {
            dbConnection = DriverManager.getConnection(DbConfig.HOST, DbConfig.USERNAME, DbConfig.PASSWORD);
            System.out.println("Connection successful");

        } catch (SQLException e) {
            System.out.println("Error connecting with the database");
            e.printStackTrace();
        }
        return dbConnection;
    }
}
