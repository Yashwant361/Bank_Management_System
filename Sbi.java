package Services;

import Exception.InsufficientBalanceException;
import Exception.InvalidAmountException;
import POJO.AccountDetails;

public class Sbi implements BankAccount{
    private long accountNum;

    private String userName;

    private double balance;
    @Override
    public void init(AccountDetails accountDetails) {
        this.accountNum = accountDetails.getAccountNum();
        this.userName = accountDetails.getUserName();
        this.balance = accountDetails.getBalance();
        System.out.println("SBI object initialized");

    }

    @Override
    public void deposit(double amount) throws InvalidAmountException {
        if (amount<=0){
            throw new InvalidAmountException("Enter amount greater than Zero");

        }
        balance = balance+amount;
        System.out.println("Amount deposited in SBI");

    }

    @Override
    public void withdraw(double amount) throws InvalidAmountException, InsufficientBalanceException {
        if (amount<=0){
            throw new InvalidAmountException("Enter amount greater than Zero");

        }
        if (amount>balance){
            throw new InsufficientBalanceException("Entered amount is greater than Balance");
        }

        balance = balance - amount ;
        System.out.println("Amount has been Debited from SBI");

    }

    @Override
    public void balanceEnquiry() {
        System.out.println("Your Account Balance is: " +balance);
        System.out.println("Operation done on SBI");
    }

    @Override
    public void moneyTransfer(long account, double amount) throws InvalidAmountException, InsufficientBalanceException{
        this.withdraw(amount);
        deposit(amount);
        System.out.println("Operation done on SBI");
    }
}