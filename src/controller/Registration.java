package controller;

import model.Account;
import service.GenerateAccount;

import java.sql.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Registration {

    public void customerRegistration() throws SQLException {


        Account account = new Account();
        Scanner sc = new Scanner(System.in);

        // for name
        String fullName;
        do{
            System.out.println("Please enter your full name with correct format.");
            fullName = sc.nextLine();
            account.setFullName(fullName);
        } while(!(Pattern.matches("[a-zA-Z+]+[ ]+[a-zA-Z]{1,30}", fullName)));

        // for account number
        GenerateAccount accountId = new GenerateAccount();
        String id = accountId.generateToken();
        account.setAccountNumber(id);

        String email;
        do{
            System.out.println("Please enter your email with correct format.");
            email = sc.nextLine();
            account.setEmail(email);
        }
        while(!(Pattern.matches("[a-zA-Z0-9+_.-]+@[a-z]+[.][a-z]{3}", email)));

        //for phone
        String phone;
        do {
            System.out.println("Please enter your phone number with correct format.");
            phone = sc.nextLine();
            account.setPhone(phone);
        } while(!(Pattern.matches("[0-9]{10}", phone)));

        //for address

        String address;
        do {
            System.out.println("Please enter your address.");
            address = sc.nextLine();
            account.setAddress(address);
        } while ((Pattern.matches("[a-zA-Z]{1,100}", address)));

        account.setBalance(0);

        DbConnection db = new DbConnection();
        Connection conn = db.connection("ams","root","aceraspire5");

        String query = "INSERT  into account(full_name,account_number,amount,email,phone,location) values (?,?,?,?,?,?);";

        PreparedStatement stmt = conn.prepareStatement(query);

        stmt.setString(1,account.getFullName());
        stmt.setString(2,account.getAccountNumber());
        stmt.setInt(3,account.getBalance());
        stmt.setString(4,account.getEmail());
        stmt.setString(5,account.getPhone());
        stmt.setString(6,account.getAddress());

        stmt.execute();
        conn.close();

        System.out.println("Your account has been created. Thank You");

    }

}