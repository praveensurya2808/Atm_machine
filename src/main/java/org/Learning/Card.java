package org.Learning;

public class Card {
    private final String cardNumber;
    private final String pin;

    public Card(String cardNumber , String pin){
        this.cardNumber = cardNumber;
        this.pin = pin;
    }

    public String getcardNumber(){
        return cardNumber;
    }

    public String getPin(){
        return pin;
    }
}
