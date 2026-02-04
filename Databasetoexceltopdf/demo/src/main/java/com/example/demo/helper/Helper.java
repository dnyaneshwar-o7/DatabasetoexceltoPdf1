package com.example.demo.helper;

import com.example.demo.model.Category; // Ensure this matches your package/class name exactly
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class Helper { // Class names should be Capitalized

    public static String[] HEADERS = {
            "ID",
            "Title",
            "Description",
            "Cover Image"
    };

    public static String SHEET_NAME = "category_data";

    public static ByteArrayInputStream dataToExcel(List<Category> list) {

        // Use try-with-resources for automatic closing of workbook and stream
        try (Workbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            Sheet sheet = workbook.createSheet(SHEET_NAME);

            // Create Header Row
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < HEADERS.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(HEADERS[i]);
            }

            // Create Data Rows
            int rowIndex = 1;
            for (Category c : list) {
                Row dataRow = sheet.createRow(rowIndex++);

                dataRow.createCell(0).setCellValue(c.getCategoryId());
                dataRow.createCell(1).setCellValue(c.getTitle());
                dataRow.createCell(2).setCellValue(c.getDescrition()); // Fixed: was duplicate Title
                dataRow.createCell(3).setCellValue(c.getCoverimage());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());

        } catch (IOException e) {
            throw new RuntimeException("Fail to export data to Excel: " + e.getMessage());
        }
    }
}