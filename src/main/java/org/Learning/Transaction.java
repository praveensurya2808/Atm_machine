package org.Learning;

import java.util.UUID;

public abstract  class Transaction {
    protected final  String id ;
    protected final Account account;
    protected final double amount;


    public Transaction(Account account , double amount){
        this.id = UUID.randomUUID().toString();
        this.account = account;
        this.amount = amount;
    }
    public abstract void execute();
}
