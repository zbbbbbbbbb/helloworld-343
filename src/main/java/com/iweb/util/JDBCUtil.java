package com.iweb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCUtil {
    private final static  String URL="jdbc:mysql://localhost:3306/tmall?characterEncoding=utf8";
    private final static String username="root";
    private final static String password="123456";
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public static Connection getConnect() throws SQLException {
        return DriverManager.getConnection(URL,username,password);
    }
}
