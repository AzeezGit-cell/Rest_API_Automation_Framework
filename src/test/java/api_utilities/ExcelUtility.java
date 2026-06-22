package api_utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

    public FileInputStream fi;
    public FileOutputStream fo;
    public XSSFWorkbook wb;
    public XSSFSheet ws;
    public XSSFRow row;
    public XSSFCell cell;

    String path;

    public ExcelUtility(String path) {
        this.path = path;
    }

    // Get total rows
    public int getRowCount(String sheetName) throws IOException {

        fi = new FileInputStream(path);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheetName);

        int rowCount = ws.getLastRowNum();

        wb.close();
        fi.close();

        return rowCount;
    }

    // Get total cells
    public int getCellCount(String sheetName, int rowNum) throws IOException {

        fi = new FileInputStream(path);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheetName);
        row = ws.getRow(rowNum);

        int cellCount = row.getLastCellNum();

        wb.close();
        fi.close();

        return cellCount;
    }

    // Read data
    public String getCellData(String sheetName,
                              int rowNum,
                              int colNum) throws IOException {

        fi = new FileInputStream(path);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheetName);

        row = ws.getRow(rowNum);
        cell = row.getCell(colNum);

        String data;

        try {
            data = cell.toString();
        } catch (Exception e) {
            data = "";
        }

        wb.close();
        fi.close();

        return data;
    }

    // Write data
    public void setCellData(String sheetName,
                            int rowNum,
                            int colNum,
                            String data) throws IOException {

        fi = new FileInputStream(path);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheetName);

        row = ws.getRow(rowNum);

        if (row == null)
            row = ws.createRow(rowNum);

        cell = row.getCell(colNum);

        if (cell == null)
            cell = row.createCell(colNum);

        cell.setCellValue(data);

        fo = new FileOutputStream(path);
        wb.write(fo);

        wb.close();
        fi.close();
        fo.close();
    }
}