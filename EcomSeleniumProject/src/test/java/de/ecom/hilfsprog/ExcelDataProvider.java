package de.ecom.hilfsprog;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
	
	final static String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\de\\ecom\\testDaten\\TestData.xlsx";
	
	@DataProvider(name= "Test05Data")
	public static Object[][] getData() {
		
		
		Object data[][] = TestData(excelPath,"TestData05");
		return data;
		
	}
	
	@DataProvider(name="Test06Data")
	public static Object[][] getData1(){
		
		Object data[][] = TestData(excelPath,"TestData06");
		return data;
	}
	
	@DataProvider(name="Test07Data")
	public static Object[][] getData2(){
		
		Object data[][] = TestData(excelPath,"TestData07");
		return data;
		
	}
	
	public static Object[][] TestData(String excelPath, String sheetName) {
		
		
		ExcelUtility excel = new ExcelUtility(excelPath,sheetName);
		int rowCount=excel.getRowCount();
		System.out.println(rowCount);
		int colCount=excel.getColCount();
		System.out.println(colCount);
		Object[][] data= new Object[rowCount-1][colCount-1];
		for(int i=1;i<rowCount;i++) {
			
	
			for(int j=1;j<colCount;j++) {
				
				try {
					
				data[i-1][j-1]=excel.getStringCellData(i, j);
				
				}catch(Exception e) {
					
					System.out.println(e.getMessage());
					
				}
				
			}
			
		}
		return data;
		
	}

}
