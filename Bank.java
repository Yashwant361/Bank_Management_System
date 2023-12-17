
package Controller;
import Exception.InsufficientBalanceException;
import Exception.InvalidAmountException;
import POJO.AccountDetails;
import Services.BankAccount;
import Services.Pnb;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Bank {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println(" Enter Bank Name");
            String bankaccount = sc.next(); //SBI
            try{


                Class<?> cla = Class.forName("Services."+bankaccount);
                Object obj = cla.getDeclaredConstructor().newInstance();
//                String a1 = (String) obj;
//                System.out.println(a1);
                BankAccount bankaccount1 = (BankAccount) obj;
                AccountDetails accountDetails = new AccountDetails();

                System.out.println("Enter Account Number");
                accountDetails.setAccountNum(sc.nextLong());

                System.out.println("Enter your username");
                accountDetails.setUserName(sc.next());

                System.out.println("Enter your Account balance");
                accountDetails.setBalance(sc.nextLong());

                bankaccount1.init(accountDetails);

                System.out.println("WELCOME, You can Start your transaction");

                while (true){
                    System.out.println("Choose Options");
                    System.out.println(" 1.Deposit \n 2.Withdraw \n 3.Balance Enquiry \n 4.Money Transfer ");
                    int a = Integer.parseInt(sc.next());
                    switch (a){
                        case 1:
                            System.out.println("Enter amount to deposit");
                            bankaccount1.deposit(sc.nextDouble());
                            break;
                        case 2:
                            System.out.println("Enter amount to withdraw");
                            bankaccount1.withdraw(sc.nextDouble());
                            break;
                        case 3:
                            bankaccount1.balanceEnquiry();
                            break;
                        case 4:
                            System.out.println("Enter amount to transfer");
                            double amt = sc.nextDouble();
                            System.out.println("Enter The account number in which you want to transfer");
                            long acT = sc.nextLong();
                            bankaccount1.moneyTransfer(acT,amt);
                            break;
                        default:
                            System.out.println("TRY AGAIN");
                            break;
                    }
                }


            }
            catch (ClassNotFoundException e){
                System.out.println(bankaccount+" .class file not available");
            } catch (InstantiationException ex)
            {
                throw new RuntimeException(ex);
            } catch (IllegalAccessException ey)
            {
                throw new RuntimeException(ey);
            }
            catch (InvalidAmountException ez)
            {
                throw new RuntimeException(ez);
            }
            catch (InsufficientBalanceException f)
            {
                throw new RuntimeException(f);
            }
            catch (InvocationTargetException e)
            {
                throw new RuntimeException(e);
            }
            catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }


        }
    }
}