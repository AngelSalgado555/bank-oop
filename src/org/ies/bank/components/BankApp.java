package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;
import org.ies.bank.model.Customer;

import java.util.Scanner;

public class BankApp {
    private final Scanner scanner;
    private final BankReader bankReader;

    public BankApp(Scanner scanner, BankReader bankReader) {
        this.scanner = scanner;
        this.bankReader = bankReader;
    }
    public void run () {
        Bank bank = bankReader.read();
        int option;
        do {
            System.out.println("¿Qué quieres hacer? ");
            System.out.println("1. Mostrar las cuentas de banco ");
            System.out.println("2. Mostrar los datos de la cuentas ");
            System.out.println("3. Mostrar los datos de la cuenta de un cliente ");
            System.out.println("4. Ingresar dinero en la cuenta ");
            System.out.println("5. Sacar dinero de la cuenta ");
            option = scanner.nextInt();

            if(option == 1) {
                System.out.println("Introduzca un IBAN ");
                String num = scanner.nextLine();
                bank.showAccount(num);

            }
        }
    }
}
