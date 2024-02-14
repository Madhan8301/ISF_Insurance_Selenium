package com.kgisl.stepDefinition;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TestDataReader {

    public static List<Map<String, Object>> readTestDataFromExcel(String filePath, String sheetName) throws IOException {
        List<Map<String, Object>> testDataList = new ArrayList<>();

        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet(sheetName);

        Row headerRow = sheet.getRow(0); // Assuming the first row contains headers

        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next(); // Skip header row

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Map<String, Object> rowData = new HashMap<>();

            for (int i = 0; i < headerRow.getPhysicalNumberOfCells(); i++) {
                Cell cell = row.getCell(i);
                CellType cellType = cell.getCellType();
                String columnName = headerRow.getCell(i).getStringCellValue();

                switch (cellType) {
                    case STRING:
                        rowData.put(columnName, cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        rowData.put(columnName, cell.getNumericCellValue());
                        break;
                    // Add more cases for other cell types as needed
                }
            }

            testDataList.add(rowData);
        }

        workbook.close();
        fileInputStream.close();

        return testDataList;
    }
}
