package com.automation.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.automation.Pages.BaseClass;

public class ExcelDataProvider extends BaseClass{
	XSSFWorkbook workbook = null;

	public ExcelDataProvider() {

		File src = new File("./testData/testData.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception e) {

			System.out.println("File not found" + e.getMessage());
			e.printStackTrace();
		}

	}

	public String getStringData(String sheetName, int row, int column) {
		return workbook.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}

	public String getStringData(int sheetIndex, int row, int column) {
		return workbook.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}

	public double getNumericData(int sheetIndex, int row, int column) {
		return workbook.getSheetAt(sheetIndex).getRow(row).getCell(column).getNumericCellValue();

	}

}
