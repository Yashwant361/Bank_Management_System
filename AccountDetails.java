package POJO;

public class AccountDetails {
    private long accountNum;

    private String userName;

    private double balance;

    public void setAccountNum(long accountNum) {
        this.accountNum = accountNum;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getAccountNum() {
        return accountNum;
    }

    public double getBalance() {
        return balance;
    }

    public String getUserName() {
        return userName;
    }

    public String toString(){
        return "Account Details: \n Account Number:"+this.accountNum+"\n UserName :";
    }
}