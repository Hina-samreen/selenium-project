package de.ecom.testfaelle;

import static org.testng.Assert.assertTrue;


import org.testng.annotations.Test;

import de.ecom.hilfsprog.ExcelDataProvider;
import de.ecom.testbasis.TestBasis;


public class Tf05_KontoErstellenUndTeilenTest extends TestBasis  {
	
	@Test(dataProvider="Test05Data" , dataProviderClass = ExcelDataProvider.class)
	public void kontoErstellenUndTeilen(String FirstName, String LastName, String EmailAddress , String Password,String ConfirmPassword,String successMessage1,String EmailAddress2, String Message,String sucessMessage2) {
		
		String actualSuccessRegMessage;
		String actualSuccessShareMessage;
		
		//clicking on Account --> My Account --> Create an Account
		mainpage.accountBtnClick();
		mainpage.accountLinkClick();
		loginpage.clickCreateAccountBtn();
		
		
		//Entering values in the mandatory fields
		registerpage.enterFirstName(FirstName);
		registerpage.enterLastName(LastName);
		registerpage.enterEmailAddress(EmailAddress);
		registerpage.enterPassword(Password);
		registerpage.enterConfirmPasssowrd(ConfirmPassword);
		
		//clicking on the register button
		registerpage.clickRegisterBtn();
		
		//verifying the successful registration
		actualSuccessRegMessage=homepage.getTextOfSuccessMsg();
		System.out.println(actualSuccessRegMessage);
		assertTrue(successMessage1.equalsIgnoreCase(actualSuccessRegMessage),"The registration was not a success");
		
		//clicking on TV menu
		homepage.clickTVBtn_HomePage();
		
		//clicking on Add to wish list link 
		tvpage.clickAddToWishlistFirstLink();
		
		//clicking on share wishlist button
		mywishlistpage.clickShareWishlistBtn();
		
		//entering email address, a message and clicking on share wishlist
		mywishlistpage.enterEmailAddressForWishlistShare(EmailAddress2);
		mywishlistpage.enterMessageForWishlistShare(Message);
		mywishlistpage.clickShareWishlistBtn();
		
		//verifying the success message after sharing wishlist
		actualSuccessShareMessage=mywishlistpage.getTextOfWishlistShareSuccess();
		System.out.println(actualSuccessShareMessage);
		assertTrue(actualSuccessShareMessage.equalsIgnoreCase(sucessMessage2),"The wishlist was not shared");
		
	}
	
	
}
