package org.Learning;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BankingService {
    private final Map<String , Account>accounts = new ConcurrentHashMap<>();
    private final Map<String,Card>cards = new ConcurrentHashMap<>();

    public void createAccont(String accountNumber, double initialBalance){
        accounts.put(accountNumber,new Account(accountNumber,initialBalance));
    }

    public Account getaccount(String accountNumber){
        if(accounts.containsKey(accountNumber)){
            System.out.println(accountNumber);

        }
        else{
            System.out.println("No account found for this number" + accountNumber);
        }
        return accounts.get(accountNumber);

    }

    public void processTransaction(Transaction transaction){
        transaction.execute();
    }

    public void linkcardtoaccountnumber(String accountnumber ,String pin, String cardNumber){
        if(accounts.containsKey(accountnumber)){
            cards.put(cardNumber,new Card(cardNumber,pin));
        }
        else{
            System.out.println("No account found for this"+ accountnumber);
        }
    }

    public Card getcard(String cardNumber){
        return cards.get(cardNumber);
    }

    public boolean authenticate(String cardNumber , String pin){
        Card card = cards.get(cardNumber);
        return card!=null && card.getPin().equals(pin);
    }

}
