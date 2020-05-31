package de.ecom.testfaelle;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import de.ecom.hilfsprog.ExcelDataProvider;
import de.ecom.testbasis.TestBasis;

public class Tf06_KaufDesProduktsMitRegistriertenEMailTest extends TestBasis{
	
	@Test(dataProvider="Test06Data" , dataProviderClass=ExcelDataProvider.class)
	public void kaufDesProduktsMitRegistriertenEMailTest(String EmailAddress,String Password, String RegionShipping, 
			String ZipCode,String Street, String City, String State,String Country,String Telephone) throws InterruptedException {
		
		//click on Account-->my account link
		mainpage.accountBtnClick();
		mainpage.accountLinkClick();
		
		//login into application using previously registered account details
		loginpage.enterEmailLogin(EmailAddress);
		loginpage.enterPasswordLogin(Password);
		loginpage.clickLoginBtn();
		
		//click on My wishlist link
		homepage.clickMyWishlist_HomePage();
		
		//click Add to cart
		mywishlistpage.clickAddToCartBtn();
		
		//Selecting the region and entering ZIP code for generating shipping cost
		shoppingcartpage.selectRegionShippingEstimate(RegionShipping);
		shoppingcartpage.enterZipCodeShippingEstimate(ZipCode);
				
		//clicking on estimate button
		shoppingcartpage.clickEstimateBtn();
				
		//selecting the fixed shipping radio and clicking on update total
		shoppingcartpage.clickEstimatedShippingRadio();
		shoppingcartpage.clickUpdateTotalBtn();
			
		//click proceed to checkout
		shoppingcartpage.clickProceedToCheckoutBtn();
		
		//Enter shipping information
		checkoutpage.enterBillingStreet(Street);
		checkoutpage.enterBillingCity(City);
		checkoutpage.selectBillingRegion(State);
		checkoutpage.enterBillingZipCode(ZipCode);
		checkoutpage.selectBillingCountry(Country);
		checkoutpage.enterBillingTelephone(Telephone);
		checkoutpage.clickBillingContinueBtn();
		
		//clicking on Continue
		checkoutpage.clickShippingContinueBtn();
		
		//selecting check/money order radio button
		checkoutpage.clickPaymentMoneyOrderRadioBtn();
		
		//clicking on continue and then on place order
		checkoutpage.clickPaymentMethodContinueBtn();
		checkoutpage.clickPlaceOrderBtn();
		
		//verifying if order is received
		String pageTitle=homepage.getOrderReceivedMessage();
		System.out.println(pageTitle);
		assertTrue(pageTitle.equalsIgnoreCase("Your order has been received."),"The order has not been placed");
		
		//Printing the order number
		String orderNumber= homepage.getOrderNumberText();
		System.out.println("The generated order number is " +orderNumber);
				
	}

}
