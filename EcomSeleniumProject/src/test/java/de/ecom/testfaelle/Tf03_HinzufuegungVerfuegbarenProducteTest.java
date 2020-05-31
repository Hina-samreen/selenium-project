package de.ecom.testfaelle;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import de.ecom.testbasis.TestBasis;

public class Tf03_HinzufuegungVerfuegbarenProducteTest extends TestBasis {
	
	@Test
	public void hinzufuegungVerfuegbarenProducteTest() throws InterruptedException {
		
		//click on mobile menu
		mainpage.mobileBtnClick();
		
		//click on Add to cart for 1st product
		mobilepage.clickAddToCartFirstProductButton();
		
		//updating the qty value to more than 500
		shoppingcartpage.updateQuantity("520");
		
		//Clicking on Update button
		shoppingcartpage.clickUpdateQtyBtn();
		
		//validating the error message
		String actualErrorMessage=shoppingcartpage.getTextOfErrorMessage();
		System.out.println(actualErrorMessage);
		assertTrue(actualErrorMessage.equalsIgnoreCase("The requested quantity for Sony Xperia is not available."),"The error message displayed is incorrect");
		
	}	
			
		
	
}
