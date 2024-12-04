package org.ies.bank.model;

import java.util.Objects;

public class Account {
    private String iban;
    private double salary;
    private Customer customer;

    public Account(String iban, double salary, Customer customer) {
        this.iban = iban;
        this.salary = salary;
        this.customer = customer;
    }

    public void showInfo () {
        System.out.println("IBAN: " + iban + "Saldo: " + salary + "Cliente: " + customer);
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(salary, account.salary) == 0 && Objects.equals(iban, account.iban) && Objects.equals(customer, account.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, salary, customer);
    }

    @Override
    public String toString() {
        return "Account{" +
                "iban='" + iban + '\'' +
                ", salary=" + salary +
                ", customer=" + customer +
                '}';
    }
    public void desposit(double amount) {
        salary += amount;
    }
}
