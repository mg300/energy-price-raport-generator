package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        InputManager inputManager = new FileHandlerInput("data.ods");
        OutputManager outputManager = new FileHandlerOutput();
        Calculator calculator = new Calculator(inputManager);

        List<String> names = new ArrayList<>();
        List<Double> totalPrices=new ArrayList<>();
        List<Double> avgPrices=new ArrayList<>();

        for(int i=3; i<=6; i++){
            names.add(inputManager.readTariffName(i));
            totalPrices.add(calculator.getTotalPrice(i));
            avgPrices.add(calculator.calcAVG(i));
        }

        Report report = new Report.Builder()
                .setPath("./report")
                .setTitle(inputManager.readTitle())
                .setPlace(inputManager.readPlace())
                .setPrecision(2)
                .setNames(names)
                .setTotalPrices(totalPrices)
                .setAvgPrices(avgPrices)
                .setOutputManager(outputManager)
                .build();

        report.generateReport();
    }
}