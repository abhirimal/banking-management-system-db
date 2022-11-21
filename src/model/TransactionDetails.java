package model;

public class TransactionDetails {

    private String accountNumber;

    private String type;

    private int amount;

    private String timeStamp;

    public String getAccountNumber(){
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type=type;
    }

    public String getTimeStamp(){
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp){
        this.timeStamp=timeStamp;
    }

    public int getAmount(){
        return amount;
    }

    public void setAmount(int amount){
        this.amount=amount;
    }


}