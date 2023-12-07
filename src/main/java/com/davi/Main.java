package com.davi;

import com.davi.application.Application;
public class Main {
    public static void main(String[] args) {
        System.out.println("\nStarting application...");
        Application application = new Application();
        application.app();
        System.out.println("\n" + "Closing application...");

    }
}