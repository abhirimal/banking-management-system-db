import controller.DisplayCustomerDetails;
import controller.DisplayTransactionDetails;
import controller.Registration;
import controller.Transactions;

import java.sql.SQLException;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) throws SQLException {


        Registration registration = new Registration();
        DisplayCustomerDetails customerDetails = new DisplayCustomerDetails();
        Transactions transactions=new Transactions();
        DisplayTransactionDetails transactionDetails= new DisplayTransactionDetails();

        int option;
        boolean flag=true;

        do{
            Scanner input = new Scanner(System.in);
            System.out.println("\n !!!! Welcome to Abhiyan Development Bank !!!!\n" +
                    "1. View account details. \n" +
                    "2. Create new Account \n" +
                    "3. Make transactions \n" +
                    "4. View transactions \n" +
                    "5. Exit");
            option = input.nextInt();



            switch (option) {

                case 1:
                    customerDetails.display();
                    break;

                case 2:
                    registration.customerRegistration();
                    break;

                case 3:
                    System.out.println("1. Make Deposit. \n" +
                            "2. Make Withdraw. ");
                    int insideOption = input.nextInt();

                    // nested switch statement
                    switch (insideOption) {
                        case 1:
                            transactions.makeDeposit();
                            break;
                        case 2:
                            transactions.makeWithdraw();
                            break;
                        default:
                            System.out.println("Error. Please try again");
                            break;

                    }
                    break;

                case 4:
                    transactionDetails.displayTransaction();
                    break;

                case 5:
                    System.out.println("Thank you for using our platform. ");
                    flag=false;
                    break;

                default:
                    System.out.println("Invalid");
                    break;
            }


        } while(flag);
    }
}
