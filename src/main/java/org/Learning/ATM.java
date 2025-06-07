package org.Learning;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;

public class ATM {
    private final BankingService bankingService;
    private final Cashdispenser cashdispenser;
    private final AtomicLong trabsactionCounter = new AtomicLong(0);

    public ATM(BankingService bankingService , Cashdispenser cashdispenser){
        this.bankingService = bankingService;
        this.cashdispenser = cashdispenser;
    }

    public void authenticateuser(Card card){
        boolean isAuthenticated = bankingService.authenticate(card.getcardNumber(), card.getPin());
        if(isAuthenticated){
            System.out.println("Authentication Successfull");
        }
        else {
            System.out.println("Authentication failed");
        }
    }

    public double checkBalnce(String accountNumber){
        Account account = bankingService.getaccount(accountNumber);
        return  account.getBalance();
    }

    public void withdrawCash(String accountNumber ,double amount){
        Account account = bankingService.getaccount(accountNumber);
        if(account!=null && amount>account.getBalance()){
            System.out.println("Error:Insufficient balance");
            return;
        }
        Transaction transaction = new WithdrawlTransaction(account,amount);
        bankingService.processTransaction(transaction);
        cashdispenser.dispensecash((int)amount);

    }

    public void depoistcash(String accountnumber,double amount){
        Account account = bankingService.getaccount(accountnumber);
        Transaction transaction = new DepoistTransaction(account,amount);
        bankingService.processTransaction(transaction);
    }




}
