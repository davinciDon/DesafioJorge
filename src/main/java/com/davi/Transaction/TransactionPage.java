package com.davi.Transaction;

import com.davi.Support.Register;
import lombok.Getter;
import lombok.Setter;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public class TransactionPage {
    private static final int ITEMS = 5;
    private List<Register> registerList;
    private int currentPage;
    private int escolha;
    private int maxPage;
    Scanner scanner = new Scanner(System.in);

    public TransactionPage(List<Register> registerList) {
        this.registerList = registerList;
        this.setCurrentPage(0);
    }

    private void printCurrentPage() {
        int start = getCurrentPage() * ITEMS;
        int end = Math.min(start + ITEMS, registerList.size());
        List<Register> pageItems = registerList.subList(start, end);
        for (Register r : pageItems) {
            System.out.println(r);
        }
    }

    private boolean hasPreviousPage() {
        return getCurrentPage() > 0;

    }

    private boolean hasNextPage() {
        return (getCurrentPage() + 1) * ITEMS < registerList.size();
    }

    private void previousPage() {
        if (hasPreviousPage()) {
            setCurrentPage(getCurrentPage() - 1);
        } else {
            System.out.println("\nVocê está na primeira página.");
        }
    }

    private void nextPage() {
        if (hasNextPage()) {
            setCurrentPage(getCurrentPage() + 1);
        } else {
            System.out.println("\nVocê está na última página.");
        }
    }

    public void list() {
        try {
            while (getEscolha() != 3) {
                setMaxPage(Math.max((registerList.size() / ITEMS), 1));
                System.out.println("Your Transactions " +
                        "[" + (getCurrentPage() + 1) + "/" + getMaxPage() + "]\n");
                printCurrentPage();
                System.out.println("\n'1' - Next Page\n" +
                        "'2' - Previous Page\n" +
                        "'3' - Back to Main Menu\n");
                option();
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            scanner.next();
        }

    }

    private void option() {
        setEscolha(scanner.nextInt());
        switch (getEscolha()) {
            case 1:
                nextPage();
                break;
            case 2:
                previousPage();
                break;
            default:
        }
    }
}
