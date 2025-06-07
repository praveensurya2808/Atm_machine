package org.Learning;

public class WithdrawlTransaction extends  Transaction{
    public WithdrawlTransaction(Account account, double amount) {
        super(account, amount);
    }

    @Override
    public void execute() {
        account.debit(amount);
    }
}
