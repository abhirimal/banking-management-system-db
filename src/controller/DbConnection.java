package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    Connection conn = null;

    public Connection connection(String dbname, String user, String pass) {

        try {

            if (conn != null) {
                return conn;
//                System.out.println("Connection Successful. ");
            } else {

                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbname, user, pass);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }
}
