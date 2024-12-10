package org.ies.bank;

import org.ies.bank.components.BankReader;
import org.ies.bank.model.Bank;

public class MainBankApp4 {
    private final BankReader bankReader;

    public MainBankApp4(BankReader bankReader) {
        this.bankReader = bankReader;
    }

    public void run() {
        Bank bank = bankReader.read();

        bank.showAccount();

        var account = bank.findAccount("ES0001");
        if (account == null) {
            System.out.println("La cuenta no existe");
        } else {
            bank.showAccountCustomer("ES0001");
        }

        account.getSalary();
        bank.transfer("ES0001", account.getSalary());

        bank.showAccount();
    }
}
