package controller;

import java.sql.*;
import java.util.Scanner;

public class DisplayCustomerDetails {

    public void display() throws SQLException {

        System.out.println("Enter your account number. ");
        Scanner input = new Scanner(System.in);
        String accountNumber = input.nextLine();

        DbConnection db = new DbConnection();

        Connection conn = db.connection("ams","root","aceraspire5");

        String query = "SELECT * from account where account_number=?";

        PreparedStatement stmt = conn.prepareStatement(query);

        stmt.setString(1,accountNumber);

        ResultSet rs=stmt.executeQuery();

        while(rs.next()){
            String fullName=rs.getString("full_name");
            String customerAccountNumber=rs.getString("account_number");
            int amount=rs.getInt("amount");
            String email=rs.getString("email");
            String phone=rs.getString("phone");
            String location=rs.getString("location");

            System.out.println(" Full Name=" + fullName +
                    "\n Account Number= " + customerAccountNumber +
                    "\n Balance= " + amount +
                    "\n Email= " + email +
                    "\n Phone Number = " + phone +
                    "\n Address  = " + location);
        }

        conn.close();

        }




    }