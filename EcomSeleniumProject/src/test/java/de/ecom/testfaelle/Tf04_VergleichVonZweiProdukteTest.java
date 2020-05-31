package de.ecom.testfaelle;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import de.ecom.hilfsprog.BasicUtility;
import de.ecom.hilfsprog.Screenshot;
import de.ecom.testbasis.TestBasis;

public class Tf04_VergleichVonZweiProdukteTest extends TestBasis {
	
	@Test
	public void VergleichZweiProdukteTest() throws InterruptedException {
		
		//click on mobile menu
		mainpage.mobileBtnClick();
		
		//click on compare link for two Mobile
		mobilepage.clickCompareLinkMobile1();
		mobilepage.clickCompareLinkMobile2();
		
		//storing the values of the mobile names that we have added to be compared
		String[] addedProducts = mobilepage.getTextOfElementsAddedToCompare_MobilePage();
		
		for(int k=0;k<addedProducts.length;k++) {
			
			System.out.println(addedProducts[k]);
		}
		
		
		//click on "compare" button
		mobilepage.clickcompareButton();
		
		//verify the new window and check that the products are reflected in it
		BasicUtility.windowSwitch();
	            
	    System.out.println("Title of the new window: " + mainpage.getTitle());
	            
	    //taking screenshot of the comparison window
	    try {
	    	 Screenshot.screenshot("comparsion1.jpg");
	    	} catch (IOException e) {
	    			
	    		System.out.println(e.getMessage());
	    		e.printStackTrace();
	    	}
	            
	      //checking the product names
	    String[] comparedProducts = productscomparsionpage.getTextOfElementsAddedToCompare_ComparePage();
	    for(int i=0;i<comparedProducts.length;i++) {
	    			
	    	System.out.println(comparedProducts[i]);
	    	assertTrue(addedProducts[i].equalsIgnoreCase(comparedProducts[i]), "The products added to compare do no match for index" +i);
	    }
	            
	           
	
		//switch to parent window
	    BasicUtility.windowSwitchToParentHandle();
		
		
		
	}

}
