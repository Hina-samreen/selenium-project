package de.ecom.hilfsprog;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtility(String excelPath, String sheetName) {
		
		
		try {
			
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
			
		} catch (IOException e) {
			
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public int getRowCount() {
		
		int rowCount=sheet.getPhysicalNumberOfRows();
		//System.out.println(rowCount);
		return rowCount;
	}
	
	public int getColCount() {
		
		int colCount=sheet.getRow(0).getPhysicalNumberOfCells();
		return colCount;
		
		
	}
	
	
	public String getStringCellData(int rowNum, int colNum) {
		
		
		String data=sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		return data;
		
	}
	
	public double getNumericCellData(int rowNum, int colNum) {
		
		double data=sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		return data;
		
	}
	

}
