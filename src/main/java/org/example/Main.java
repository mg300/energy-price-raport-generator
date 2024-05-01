package org.example;

public class Main {
    public static void main(String[] args){
        ManagerIO manager = new FileHandler("data.ods");
        Calculator calculator = new Calculator(manager);
        for(int i=3; i<=6; i++){
            System.out.println(manager.readTariffName(i));
            System.out.printf("%.6f%n", calculator.getTotalPrice(i));
        }

    }
}