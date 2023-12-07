package com.davi.application;

import com.davi.Transaction.Transaction;
import lombok.Getter;
import lombok.Setter;
import java.util.InputMismatchException;
import java.util.Scanner;

@Getter
@Setter
public class Application {
    Scanner scanner = new Scanner(System.in);

    int escolha;
    String NOME;
    int balance;
    public void app() {
        try {
            while (getEscolha() != 5) {
                System.out.println(
                        "\nAccount Options:" +
                                " \n1 - View Balance" +
                                " \n2 - Deposit" +
                                " \n3 - Withdraw" +
                                " \n4 - List transactions " +
                                " \n5 - Close application\n" +
                                "\nPlease select an option to continue: ");
                setEscolha(scanner.nextInt());
                Case();
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            scanner.next();
            app();
        }
    }

    Transaction transaction = new Transaction();

    public void Case() {
        switch (getEscolha()) {
            case 1:
                transaction.viewBalance();
                break;
            case 2:
                transaction.deposit();
                break;
            case 3:
                transaction.withdraw();
                break;
            case 4:
                transaction.listTransactions();
                break;
            case 5:
                break;
            default:
                System.out.println("Invalid option '" + getEscolha() + "'");
        }
    }

}


