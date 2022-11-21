package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DisplayTransactionDetails {

    public void displayTransaction() throws SQLException {

        System.out.println("Enter your account number. ");
        Scanner input = new Scanner(System.in);
        String accountNumber = input.nextLine();

        DbConnection db = new DbConnection();

        Connection conn = db.connection("ams","root","aceraspire5");

        String query = "SELECT * from transactions where account_number=?";

        PreparedStatement stmt = conn.prepareStatement(query);

        stmt.setString(1,accountNumber);

        ResultSet rs=stmt.executeQuery();

        while(rs.next()){
            String account=rs.getString("account_number");
            String transactionType=rs.getString("type");
            int amount=rs.getInt("amount");
            String time=rs.getString("transaction_date");

            System.out.println(" Account =" + account +
                    "\n Trsancation Type= " + transactionType +
                    "\n Amount = " + amount +
                    "\n Time= " + time+
                    "\n");
        }

        conn.close();

    }
    }
