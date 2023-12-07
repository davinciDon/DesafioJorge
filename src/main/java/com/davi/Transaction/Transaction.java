package com.davi.Transaction;
import com.davi.Support.Register;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

@Getter
@Setter
public class Transaction {
    Scanner scanner = new Scanner(System.in);
    private double balance;
    private double valueDeposit;
    private double valueWithdraw;

    ArrayList<Register> paginatedList = new ArrayList<>();


    public void viewBalance() {
        System.out.println();
        System.out.println("Your balance: R$ " + getBalance());
    }

    public void deposit() {
        System.out.println("Please input amount to deposit: ");
        try {
            setValueDeposit(scanner.nextDouble());
            if (getValueDeposit() > 0) {
                setBalance(getBalance() + getValueDeposit());
                Register register = new Register("Deposit" , getValueDeposit());
                ResgisterTransactions(register);
            }
            System.out.println(getValueDeposit() > 0 ? "Successfully deposited R$" +
                    getValueDeposit() + " to your account." : "Invalid amount.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            scanner.next();
        }
    }

    public void withdraw() {
        System.out.println("Please input amount to withdraw: ");
        try {
            setValueWithdraw(scanner.nextDouble());
            if (getBalance() <= 0) {
                System.out.println("You don't have any amount to withdraw.");
            } else if ((getValueWithdraw() <= getBalance()) & (getValueWithdraw() >= 0)) {
                setBalance(getBalance() - getValueWithdraw());
                Register register = new Register("Withdraw", getValueWithdraw());
                ResgisterTransactions(register);
                System.out.println("Successfully withdraw R$ " + getValueWithdraw()
                        + " to your account.");
            } else System.out.println("Invalid amount.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            scanner.next();
        }
    }
    public void ResgisterTransactions(Register register) {
        paginatedList.add(register);
    }
    public void listTransactions() {
        TransactionPage transactionPage = new TransactionPage(paginatedList);
        transactionPage.list();
    }

}
