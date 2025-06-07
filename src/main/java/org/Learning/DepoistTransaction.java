package org.Learning;

public class DepoistTransaction extends  Transaction{
    public DepoistTransaction(Account account, double amount) {
        super(account, amount);
    }

    @Override
    public void execute() {
        account.credit(amount);

    }
}
