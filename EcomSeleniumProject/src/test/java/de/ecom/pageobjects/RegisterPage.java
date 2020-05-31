package de.ecom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Base {

	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="firstname")
	private WebElement firstnameElement ;
	
	@FindBy(id="lastname")
	private WebElement lastnameElement;
	
	@FindBy(id="email_address")
	private WebElement email_addressElement ;
	
	@FindBy(id="password")
	private WebElement passwordElement ;
	
	@FindBy(id="confirmation")
	private WebElement confirmPasswordElement ;
	
	@FindBy(xpath="//button[@title='Register']")
	private WebElement registerBtnElement ;
	
	//entering firstname
	public void enterFirstName(String FirstName) {
		
		enterText(firstnameElement, 4, FirstName);
	}
	
	//entering lastname
	public void enterLastName(String LastName) {
			
		enterText(lastnameElement, 4, LastName);
	}
		
	//entering emailaddress
	public void enterEmailAddress(String EmailAddress) {
			
		enterText(email_addressElement, 4, EmailAddress);
	}
		
	//entering password
	public void enterPassword(String Password) {
			
		enterText(passwordElement, 4, Password);
	}
	
	//entering confirm password
	public void enterConfirmPasssowrd(String Password) {
			
		enterText(confirmPasswordElement, 4, Password);
	}
	
	//clicking on register button
	public void clickRegisterBtn() {
		click(registerBtnElement, 3);
	}

}
