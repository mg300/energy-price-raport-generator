package org.example;

public interface OutputManager {
    void writeCell(int col, int row, String value);
    void saveSheet(String path);

}
