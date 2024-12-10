package org.ies.bank;

import org.ies.bank.components.BankReader;
import org.ies.bank.model.Bank;

public class MainBankApp2 {
    private final BankReader bankReader;

    public MainBankApp2(BankReader bankReader) {
        this.bankReader = bankReader;
    }

    public void run() {
        Bank bank = bankReader.read();

        var account = bank.findAccount("ES0001");
        if (account != null) {
            account.deposit(500);
        } else {
            System.out.println("No existe la cuenta");
        }
        var account2 = bank.findAccount("ES0002");
        if (account2 != null) {
            account2.deposit(-30);
        } else {
            System.out.println("No existe la cuenta");
        }

        account.showInfo();
        account2.showInfo();

        bank.transfer("ES0001", 500);

    }
}
