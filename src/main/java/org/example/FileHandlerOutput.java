package org.example;

import org.jopendocument.dom.spreadsheet.Column;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

import java.io.File;

public class FileHandlerOutput implements OutputManager {
    Sheet sheet;
    SpreadSheet spreadSheet;
    public FileHandlerOutput() {
            spreadSheet = SpreadSheet.create(1, 1, 1);
            sheet = spreadSheet.getSheet(0);
            sheet.setRowCount(100);
            sheet.setColumnCount(100);
            setColumnWidth();

    }
    public void writeCell(int col, int row, String value) {
        col--;
        row--;
        sheet.getCellAt(col,row).setValue(value);
    }
    private void setColumnWidth(){
        for(int i=0; i<100; i++){
            Column<SpreadSheet> column = sheet.getColumn(i);
            column.setWidth(50);
        }
    }
    public void saveSheet(String path) {
        try{
            spreadSheet.saveAs(new File(path));
            System.out.println("Nowy arkusz został utworzony i zapisany jako: " + path);
        } catch (Exception e) {
            System.out.println("Coś poszło nie tak z zapisem pliku");
        }
    }
}
