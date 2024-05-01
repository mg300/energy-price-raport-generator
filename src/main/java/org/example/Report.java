package org.example;

import java.util.Collections;
import java.util.List;

public class Report {
    final private String path;
    final private String title;
    final private String place;

    private int precision = 2;

    private final OutputManager outputManager;

    final private List<String> names;
    final private List<Double> totalPrices;
    final private List<Double> avgPrices;

    public Report(String path,String title, String place, int precision, OutputManager outputManager, List<String> names, List<Double> totalPrices, List<Double> avgPrices) {
        this.path=path;
        this.title = title;
        this.place = place;
        this.precision = precision;
        this.outputManager = outputManager;
        this.names = names;
        this.totalPrices = totalPrices;
        this.avgPrices = avgPrices;
    }


    private int getMaxIndex(){
        Double maxValue = Collections.max(totalPrices);
        return totalPrices.indexOf(maxValue);
    }
    public void generateReport(){
        outputManager.writeCell(1,1,title);
        outputManager.writeCell(1,2,"Baza");
        outputManager.writeCell(2,2,place);
        outputManager.writeCell(1,3,"Licznik:");
        outputManager.writeCell(1,4,"Całkowita cena:");
        outputManager.writeCell(1,5,"Średnia cena:");
        int rowNum=3;
        int colNum=2;
        for(int i=0; i<names.size(); i++){
            outputManager.writeCell(colNum,rowNum,names.get(i));
            outputManager.writeCell(colNum,rowNum+1,String.format("%."+precision+"f",totalPrices.get(i)));
            outputManager.writeCell(colNum,rowNum+2,String.format("%."+precision+"f",avgPrices.get(i)));
            colNum++;
        }
        int maxValueIndex = getMaxIndex();
        outputManager.writeCell(1,7,"Największa wartość:");
        outputManager.writeCell(1,8,"Licznik");
        outputManager.writeCell(1,9,"Całkowita cena");
        outputManager.writeCell(1,10,"Średnia cena");
        outputManager.writeCell(2,8,names.get(maxValueIndex));
        outputManager.writeCell(2,9,String.format("%."+precision+"f",totalPrices.get(maxValueIndex)));
        outputManager.writeCell(2,10,String.format("%."+precision+"f",avgPrices.get(maxValueIndex)));
        outputManager.saveSheet(path);
    }
    static class Builder{
        private String path;
        private String title;
        private String place;

        private int precision = 2;

        private List<String> names;
        private List<Double> totalPrices;
        private List<Double> avgPrices;
        private OutputManager outputManager;
        Builder(){}
        Builder setPath(String path) {
            this.path = path;
            return this;
        }

        Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        Builder setPlace(String place) {
            this.place = place;
            return this;

        }

        Builder setPrecision(int precision) {
            this.precision = precision;
            return this;

        }
        Builder setOutputManager(OutputManager outputManager) {
            this.outputManager = outputManager;
            return this;

        }


        Builder setNames(List<String> names) {
            this.names = names;
            return this;

        }

        Builder setTotalPrices(List<Double> totalPrices) {
            this.totalPrices = totalPrices;
            return this;

        }

        Builder setAvgPrices(List<Double> avgPrices) {
            this.avgPrices = avgPrices;
            return this;

        }
        Report build(){
            return new Report( path, title, place, precision, outputManager, names, totalPrices, avgPrices);
        }
    }
}
