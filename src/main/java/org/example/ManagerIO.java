package org.example;

public interface ManagerIO {
        float readCell(int indexCol, int indexRow);
        void writeCell(String cell, String value);
        int getCountOfRowsWithData(int indexCol);
        int getNumOfFirstRowWithData(int indexCol);
        String readTariffName(int indexCol);
}
