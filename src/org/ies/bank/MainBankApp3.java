package org.ies.bank;

import org.ies.bank.components.BankReader;
import org.ies.bank.model.Bank;

public class MainBankApp3 {
    private final BankReader bankReader;

    public MainBankApp3(BankReader bankReader) {
        this.bankReader = bankReader;
    }
    public void run() {
        Bank bank = bankReader.read();

        bank.showAccount();

        var account = bank.findAccount("ES0003");
        if (account != null) {
            account.deposit(-50);
        } else {
            System.out.println("No existe la cuenta");
        }

        bank.showCustomerAccount("000X");

        var account2 = bank.findAccount("ES0004");
        if(account2 != null) {
            account.deposit(300);
        } else {
            System.out.println("No existe la cuenta");
        }

        var account3 = bank.findAccount("ES0001");
        if(account3 != null) {
            account3.getCustomer().showInfo();
        } else {
            System.out.println("No existe la cuenta");
        }
    }
}
