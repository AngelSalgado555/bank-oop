package org.ies.bank.model;

import java.util.Arrays;
import java.util.Objects;

public class Bank {
    private String name;
    private Account[] accounts;

    public Bank(String name, Account[] accounts) {
        this.name = name;
        this.accounts = accounts;
    }

    public void showAccountCustomer (String iban) {
        var account = findAccount(iban);
        if (account == null) {
            System.out.println("La cuenta no existe");
        } else {
            account.getCustomer().showInfo();
        }
    }
    public void showAccount() {
        for (var account : accounts) {
            account.showInfo();
        }
    }


    public void showInfoAccounts (String iban) {
        for (var account : accounts) {
            if(account.getIban().equals(iban)) {
                account.showInfo();
            }
        }
    }

    public void showCustomerAccount(String nif) {
        for (var account : accounts) {
            if (account.getCustomer().getNif().equals(nif)) {
                account.showInfo();
            }
        }
    }

    public void deposit(String iban, double amount) {
        var account = findAccount(iban);

        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Cuenta no encontrada");
        }
    }

    public Account findAccount(String iban) {
        for (var account: accounts) {
            if(account.getIban().equals(iban)) {
                return account;
            }
        }
        return null;
    }

    public void takeout (String iban , double amount) {
        var account = findAccount(iban);

        if(account != null) {
            if (account.getSalary() >= amount) {
                account.deposit(-amount);
            } else {
                System.out.println("No hay suficiente saldo");
            }
        } else {
            System.out.println("Cuenta no encotrada");
        }
    }

    public int returnAccounts(String nif) {
        int count = 0;
        for (var account : accounts) {
            if(account.getCustomer().getNif().equals(nif)) {
                count++;
            }
        }
        return count;
    }

    public Customer returnDataAccount(String iban) {
        var account = findAccount(iban);
            if (account != null) {
                account.getCustomer();
            }
        return null;
    }

    public boolean transfer (String iban , double salary , double amount ) {
        System.out.println("Introduzca el IBAN de la cuenta remitente: ");
        var originAccount = findAccount(iban);
        System.out.println("Introduzca el IBAN de la cuenta receptora: ");
        var finalAccount = findAccount(iban);

        if (originAccount == null || finalAccount == null) {
            System.out.println("Una de las cuentas no existe.");
            return false ;
        } else {
            originAccount.takeOut(amount);
            finalAccount.deposit(amount);
            return true;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(name, bank.name) && Objects.deepEquals(accounts, bank.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Arrays.hashCode(accounts));
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", accounts=" + Arrays.toString(accounts) +
                '}';
    }
}
