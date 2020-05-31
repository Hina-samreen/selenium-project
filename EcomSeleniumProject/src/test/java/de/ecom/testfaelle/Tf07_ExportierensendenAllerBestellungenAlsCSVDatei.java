package de.ecom.testfaelle;

import java.io.IOException;

import javax.mail.MessagingException;

import org.testng.annotations.Test;
import de.ecom.hilfsprog.CSVFileUtility;
import de.ecom.hilfsprog.EmailUtility;
import de.ecom.hilfsprog.ExcelDataProvider;
import de.ecom.testbasis.TestBasis;

public class Tf07_ExportierensendenAllerBestellungenAlsCSVDatei extends TestBasis {
	
	String FilePath= System.getProperty("user.dir")+ "\\src\\test\\resources\\de\\ecom\\testDaten\\orders.csv";
	
	@Test(dataProvider="Test07Data" , dataProviderClass=ExcelDataProvider.class)
	public void exportierenUndSenden(String backendUserName, String backendPassword, String exportDropdownSelection) {
		//login with id = "user01" , pass = "guru99com"
		backendpage.enterUserNameBackend(backendUserName);
		backendpage.enterPasswordBackend(backendPassword);
		backendpage.clickLoginBtnBackend();

		//close the pop up window
		backendpage.clickClosePopupBtnBackend();
				
		//click on sales--> orders
		backendpage.clickSalesMenuBackend();
		backendpage.clickOrdersMenuBackend();
				
		//select csv from export dropdown
		backendpage.selectFromExportMenu(exportDropdownSelection);
				
		//click on the export button
		backendpage.clickExportBtnBackend();
		
		//read from the above exported file and print on console
		try {
			CSVFileUtility.CSVFileRead(FilePath);
		} catch (IOException e) {
		
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		//before starting this test please enter email address and password in config file
		try {
			EmailUtility.emailUtil(FilePath);
			//Mail.mail(filePath);
		} catch (MessagingException e1) {
			System.out.println(e1.getMessage());
			System.out.println("If you get this message, "
					+ "probably the username and address are not set in config file, please do it for EmailUtility to work");
			e1.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("If you get this message, "
					+ "probably the username and address are not set in config file, please do it for EmailUtility to work");
			e.printStackTrace(); 
		}
	}
	
}
