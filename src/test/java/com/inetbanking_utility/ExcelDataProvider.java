package com.inetbanking_utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	FileInputStream fins;
	XSSFWorkbook workbook;

	public ExcelDataProvider(String fileName) {
		try {
			File fs = new File("./TestData/" + fileName + ".xlsx");
			fins = new FileInputStream(fs);
			workbook = new XSSFWorkbook(fins);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int rowCount(String sheetname) {
		return workbook.getSheet(sheetname).getLastRowNum();
	}

	public int rowCount(int index) {
		return workbook.getSheetAt(index).getLastRowNum();
	}

	public int colCount(String sheetname, int row) {
		return workbook.getSheet(sheetname).getRow(row).getLastCellNum();
	}

	public int colCount(int index, int row) {
		return workbook.getSheetAt(index).getRow(row).getLastCellNum();
	}

	public String fetchStringCellValue(String sheetname, int row, int col) {
		return workbook.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
	}

	public String fetchStringCellValue(int index, int row, int col) {
		return workbook.getSheetAt(index).getRow(row).getCell(col).getStringCellValue();
	}

	public int fetchNumericCellValue(String sheetname, int row, int col) {
		return (int) workbook.getSheet(sheetname).getRow(row).getCell(col).getNumericCellValue();
	}

	public int fetchNumericCellValue(int index, int row, int col) {
		return (int) workbook.getSheetAt(index).getRow(row).getCell(col).getNumericCellValue();
	}

}
