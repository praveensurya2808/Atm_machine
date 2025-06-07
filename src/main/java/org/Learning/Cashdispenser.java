package org.Learning;

public class Cashdispenser {
    private int cashAvailable;

    public Cashdispenser(int cashAvailable){
        this.cashAvailable = cashAvailable;
    }

    public synchronized  void  dispensecash(int amount){
        if(amount>cashAvailable){
            throw new IllegalArgumentException("Insufficient Balnce in the ATM ");
        }
        else{
            cashAvailable-=amount;
            System.out.println("The amount is dispnesed"+amount);
        }

    }
}
