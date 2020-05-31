package de.ecom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Base {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//*[@title='Create an Account']")
	private WebElement createAnAccountBtnElement;
	
	@FindBy(id="email")
	private WebElement emailElement;
	
	@FindBy(id="pass")
	private WebElement passwordElement;
	
	@FindBy(id="send2")
	private WebElement loginBtnElement;
	
	//clicking on create an account button
	public void clickCreateAccountBtn() {
		
		click(createAnAccountBtnElement, 4);
	}

	//entering email at login
	public void enterEmailLogin(String EmailAddress) {
		
		enterText(emailElement, 4, EmailAddress);
	}

	//entering password at login
	public void enterPasswordLogin(String Password) {
			
		enterText(passwordElement, 4, Password);
	}

	//clicking on login button
	public void clickLoginBtn() {
		
		click(loginBtnElement, 4);
	}

}
