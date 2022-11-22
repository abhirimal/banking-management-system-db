package controller;

import model.DateAndTime;
import model.TransactionDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Transactions {

    public void makeDeposit() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your account number. ");
        String accountNumber = input.nextLine();

        System.out.println("Please enter the amount you want to deposit.");
        int deposit = input.nextInt();

        DbConnection db = new DbConnection();
        Connection conn = db.connection("ams","root","aceraspire5");

        String query = "update account set amount=amount+? where account_number=?;";

        PreparedStatement stmt = conn.prepareStatement(query);

        stmt.setInt(1,deposit);
        stmt.setString(2,accountNumber);

        stmt.execute();
        conn.close();

        System.out.println("You have deposited successfully. Thank you");

        TransactionDetails transactionDetails = new TransactionDetails();
        DateAndTime dateAndTime = new DateAndTime();
        transactionDetails.setAccountNumber(accountNumber);
        transactionDetails.setAmount(deposit);
        transactionDetails.setType("Deposit");
        transactionDetails.setTimeStamp(dateAndTime.TimeStamp());
        saveTransactionDetail(transactionDetails);


    }

    public void makeWithdraw() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your account number. ");
        String accountNumber = input.nextLine();

        System.out.println("Please enter the amount you want to withdraw.");
        int withdraw = input.nextInt();

        DbConnection db = new DbConnection();
        Connection conn = db.connection("ams","root","aceraspire5");

        String query1 = "SELECT * from account where account_number=?";

        PreparedStatement stmt1 = conn.prepareStatement(query1);

        stmt1.setString(1,accountNumber);

        ResultSet rs=stmt1.executeQuery();

        int bankAmount = 0;
        int flag=0;
        while(rs.next()){
            bankAmount=rs.getInt("amount");

        }

        if(bankAmount>=withdraw){
            String query2 = "update account set amount=amount-? where account_number=?;";

            PreparedStatement stmt2 = conn.prepareStatement(query2);

            stmt2.setInt(1,withdraw);
            stmt2.setString(2,accountNumber);

            stmt2.execute();
            conn.close();

            TransactionDetails transactionDetails = new TransactionDetails();
            DateAndTime dateAndTime = new DateAndTime();
            transactionDetails.setAccountNumber(accountNumber);
            transactionDetails.setAmount(withdraw);
            transactionDetails.setType("Withdraw");
            transactionDetails.setTimeStamp(dateAndTime.TimeStamp());
            saveTransactionDetail(transactionDetails);

        }

        else{
            System.out.println("You don't have enough amount in your account.");
            flag++;
        }

        if(flag==0){
            System.out.println("Please collect your cash.");
        }



    }

    public void saveTransactionDetail(TransactionDetails transactionDetails) throws SQLException {
        DbConnection db = new DbConnection();
        Connection conn = db.connection("ams","root","aceraspire5");

        String query = "insert into transactions(account_number,type,amount,transaction_date) \n" +
                "values(?,?,?,?);";

        PreparedStatement stmt = conn.prepareStatement(query);

        stmt.setString(1,transactionDetails.getAccountNumber());
        stmt.setString(2,transactionDetails.getType());
        stmt.setInt(3,transactionDetails.getAmount());
        stmt.setString(4,transactionDetails.getTimeStamp());

        stmt.execute();
        conn.close();
    }
}
