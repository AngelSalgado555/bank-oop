package org.ies.bank.components;

import org.ies.bank.model.Bank;

import java.util.Scanner;

public class BankApp {
    private final Scanner scanner;
    private final BankReader bankReader;

    public BankApp(Scanner scanner, BankReader bankReader) {
        this.scanner = scanner;
        this.bankReader = bankReader;
    }

    public void run() {
        Bank bank = bankReader.read();
        int option;
        do {
            option = chooseOption();
            if (option == 1) {
                bank.showAccount();
            } else if (option == 2) {
                System.out.println("Introduzca el IBAN de la cuenta que desea interactuar");
                System.out.println("IBAN:");
                String iban = scanner.nextLine();
                bank.showInfoAccounts(iban);
            } else if (option == 3) {
                System.out.println("Introduce un NIF: ");
                String nif = scanner.nextLine();
                bank.showCustomerAccount(nif);
            } else if (option == 4) {
                System.out.println("Introduzca el IBAN de la cuenta a la que quiere realizar el ingreso: ");
                String iban = scanner.nextLine();
                System.out.println("Ingrese la cantidad que quiere ingresar: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                bank.deposit(iban, amount);
            } else if (option == 5) {
                System.out.println("Introduce el IBAN de la cuenta: ");
                String iban = scanner.nextLine();
                System.out.println("¿Cuanto dinero quieres retirar? ");
                double remove = scanner.nextDouble();
                bank.takeout(iban, remove);
            } else if (option == 6 ){
                System.out.println("Introduce le NIF  del cliente:");
                String nif = scanner.nextLine();

                int customerAccountsNumber = bank.returnAccounts(nif);
                System.out.println("El cliente tiene " + customerAccountsNumber + " cuentas.");
            } else if (option == 7) {
                System.out.println("Introduce el IBAN: ");
                String iban = scanner.nextLine();

                bank.showAccountCustomer(iban);
            }
        } while (option != 8);
    }

    private int chooseOption() {
        int option;
        do {
            System.out.println("¿Qué quieres hacer? ");
            System.out.println("1. Mostrar las cuentas de banco ");
            System.out.println("2. Mostrar los datos de la cuentas ");
            System.out.println("3. Mostrar los datos de la cuenta de un cliente ");
            System.out.println("4. Ingresar dinero en la cuenta ");
            System.out.println("5. Sacar dinero de la cuenta ");
            System.out.println("6. Contar cuentas del cliente ");
            System.out.println("7. Mostrar titular de cuenta");
            System.out.println("8. Salir");
            option = scanner.nextInt();
            scanner.nextLine();

        } while (option < 1 || option > 8);
        return option;
    }

}
