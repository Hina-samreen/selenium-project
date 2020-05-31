package de.ecom.testfaelle;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.Test;

import de.ecom.hilfsprog.BasicUtility;
import de.ecom.hilfsprog.Screenshot;
import de.ecom.testbasis.TestBasis;

public class Tf01_SortierungNachNamenTest extends TestBasis{
	
	@Test
	public void sortVerificationTest() {
		
		//verify title of the page
		
		String ActualText=mainpage.getMainTitle();
		assertEquals(ActualText, "THIS IS DEMO SITE FOR   ");

		
		//click on mobile menu
		mainpage.mobileBtnClick();
		
		// verify title of the page - it should be mobile
		assertEquals(mobilepage.getTitle(),"Mobile");
		
		//getting the mobile elements before performing sorting
		String[] beforeSortElements=mobilepage.getTitleOfMobileElements();
		
		//checking that the above elements are not sorted . They should not be sorted before sorting is performed
		assertFalse(BasicUtility.issorted(beforeSortElements, beforeSortElements.length), "Error:The elements are sorted before sorting is performed");
		
		
		//taking a screenshot before and after sort to verify if all products are sorted by name
		
		//before sorting screenshot
		try {
			Screenshot.screenshot("BeforeSorting.jpg");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//sorting by name
		mobilepage.selectValueSortBy("Name");
		
		//Getting the mobile elements after the sorting is performed
		String[] afterSortElements= mobilepage.getTitleOfMobileElements();
		
		//checking if they are sorted or not. They should be sorted
		assertTrue(BasicUtility.issorted(afterSortElements, afterSortElements.length),"The mobile elements are not sorted");
			
		//after sorting screenshot
		try {
			Screenshot.screenshot("aftersortbyName.jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
