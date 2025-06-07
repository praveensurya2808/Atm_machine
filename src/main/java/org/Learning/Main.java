package org.Learning;

public class Main {
    public static void main(String[] args) {
        BankingService bankingService = new BankingService();
        Cashdispenser cashdispenser = new Cashdispenser(10000000);
        ATM atm = new ATM(bankingService,cashdispenser);

        //create sample accounts
        Account account = new Account("123212",100000000.09);
        Account account1 = new Account("1232122222",10000000000.09);

        bankingService.createAccont(account.getAccountnumber(),account.getBalance());
        bankingService.createAccont(account1.getAccountnumber(),account1.getBalance());

        bankingService.getaccount(account.getAccountnumber());
        bankingService.getaccount(account1.getAccountnumber());


        Card card = new Card("345675387","28028");
        atm.authenticateuser(card);

        double balance = atm.checkBalnce("123212");
        System.out.println("your balnce is : "+balance);

        atm.withdrawCash("123212",5000);
        atm.depoistcash("1232122222",70000);




        double updatedbalance = atm.checkBalnce("123212");
        System.out.println("your balnce is : "+updatedbalance);

    }
}