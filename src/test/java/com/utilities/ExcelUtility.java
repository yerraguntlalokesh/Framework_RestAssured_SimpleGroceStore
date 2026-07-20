package com.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.configuration.PropertyReader;

/**
 * Enterprise Excel Utility.
 *
 * <p>Responsibilities:
 * <ul>
 *     <li>Read cell data</li>
 *     <li>Write cell data</li>
 *     <li>Return sheet data for TestNG DataProvider</li>
 *     <li>Return row and column counts</li>
 * </ul>
 *
 * <p>Configuration:
 * qa.properties
 * excel.path=src/test/resources/excel/TestData.xlsx
 */
public final class ExcelUtility {

    private ExcelUtility() {
    }

    private static String getExcelPath() {
        return PropertyReader.getProperty("excel.path");
    }

    private static Workbook getWorkbook() {
        try {
            return WorkbookFactory.create(new FileInputStream(getExcelPath()));
        } catch (Exception e) {
            throw new RuntimeException("Unable to open Excel file : " + getExcelPath(), e);
        }
    }

    private static Sheet getSheet(Workbook workbook, String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            throw new RuntimeException("Sheet not found : " + sheetName);
        }
        return sheet;
    }

    public static int getRowCount(String sheetName) {
        try (Workbook workbook = getWorkbook()) {
            return getSheet(workbook, sheetName).getLastRowNum();
        } catch (IOException e) {
            throw new RuntimeException("Unable to get row count.", e);
        }
    }

    public static int getColumnCount(String sheetName) {
        try (Workbook workbook = getWorkbook()) {
            Sheet sheet = getSheet(workbook, sheetName);
            Row row = sheet.getRow(0);
            return row == null ? 0 : row.getLastCellNum();
        } catch (IOException e) {
            throw new RuntimeException("Unable to get column count.", e);
        }
    }

    public static String getCellData(String sheetName, int rowNumber, int columnNumber) {

        try (Workbook workbook = getWorkbook()) {

            Sheet sheet = getSheet(workbook, sheetName);
            Row row = sheet.getRow(rowNumber);

            if (row == null) {
                return "";
            }

            Cell cell = row.getCell(columnNumber);

            if (cell == null) {
                return "";
            }

            return new DataFormatter().formatCellValue(cell);

        } catch (IOException e) {
            throw new RuntimeException("Unable to read Excel data.", e);
        }
    }

    public static void setCellData(String sheetName,
                                   int rowNumber,
                                   int columnNumber,
                                   String value) {

        Workbook workbook = getWorkbook();

        try {

            Sheet sheet = getSheet(workbook, sheetName);

            Row row = sheet.getRow(rowNumber);

            if (row == null) {
                row = sheet.createRow(rowNumber);
            }

            Cell cell = row.getCell(columnNumber);

            if (cell == null) {
                cell = row.createCell(columnNumber);
            }

            cell.setCellValue(value);

            try (FileOutputStream outputStream =
                         new FileOutputStream(getExcelPath())) {

                workbook.write(outputStream);
            }

        } catch (Exception e) {
            throw new RuntimeException("Unable to write Excel data.", e);
        } finally {
            try {
                workbook.close();
            } catch (IOException ignored) {
            }
        }
    }

    public static Object[][] getSheetData(String sheetName) {

        try (Workbook workbook = getWorkbook()) {

            Sheet sheet = getSheet(workbook, sheetName);

            int rowCount = sheet.getLastRowNum();

            Row headerRow = sheet.getRow(0);

            if (headerRow == null) {
                throw new RuntimeException("Header row is missing in sheet : " + sheetName);
            }

            int columnCount = headerRow.getLastCellNum();

            Object[][] data = new Object[rowCount][columnCount];

            DataFormatter formatter = new DataFormatter();

            for (int rowIndex = 1; rowIndex <= rowCount; rowIndex++) {

                Row row = sheet.getRow(rowIndex);

                for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {

                    String cellValue = "";

                    if (row != null) {

                        Cell cell = row.getCell(columnIndex);

                        if (cell != null) {
                            cellValue = formatter.formatCellValue(cell);
                        }
                    }

                    data[rowIndex - 1][columnIndex] = cellValue;
                }
            }

            return data;

        } catch (IOException exception) {
            throw new RuntimeException("Unable to read data from sheet : " + sheetName, exception);
        }
    }
   }

