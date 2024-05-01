package org.example;

public class Calculator {
    final InputManager managerIO;
    int colKWh = 2;
    public Calculator(InputManager managerIO) {
        this.managerIO = managerIO;
    }
    public double getTotalPrice(int col){
        int rowCount = managerIO.getCountOfRowsWithData(col);
        int rowStart = managerIO.getNumOfFirstRowWithData(col);
        int rowCountQuantity = managerIO.getCountOfRowsWithData(colKWh);
        int rowStartQuantity = managerIO.getNumOfFirstRowWithData(colKWh);
        if(rowStartQuantity!= rowStart || rowCountQuantity!=rowCount){
            System.out.println("Arkusz nie jest poprawnie wypełniony");
            return 0;
        }
        double total = 0;
        for(int row=rowStart; row<rowCount+rowStart;row++){
            double quantity = managerIO.readCell(colKWh,row);
            double price = managerIO.readCell(col,row);
            total+=price/1000*quantity;
        }
        return total;
    }
    public double getTotalKWhQuantity(){
        int rowCountQuantity = managerIO.getCountOfRowsWithData(colKWh);
        int rowStartQuantity = managerIO.getNumOfFirstRowWithData(colKWh);
        double total=0;
        for(int row=rowStartQuantity; row<rowCountQuantity+rowStartQuantity; row++){
            total+=managerIO.readCell(colKWh,row);
        }
        return total;
    }
    public double calcAVG(int col){
        double totalKWh = getTotalKWhQuantity();
        double totalPrice = getTotalPrice(col);
        return totalPrice/totalKWh;
    }
}
