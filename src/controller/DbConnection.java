package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

    public Connection connection(String dbname, String user, String pass) {
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbname, user, pass);
            if (conn != null) {
//                System.out.println("Connection Successful. ");
            } else {
                System.out.println("Connection failed. Please try again ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }
}
