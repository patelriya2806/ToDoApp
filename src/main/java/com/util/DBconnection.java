package com.util;

import java.sql.*;

public class DBconnection {
    private static String URL = "jdbc:mysql://localhost:3306/todoApp";
    private static String user = "root";
    private static String password = "Riy@2806";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL,user,password);
    }
}
