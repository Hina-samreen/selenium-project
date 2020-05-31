package de.ecom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends Base {

	public MainPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[@href='http://live.demoguru99.com/index.php/mobile.html']")
	private WebElement mobileBtnElement;
	
	@FindBy(xpath="//*[@href='http://live.demoguru99.com/index.php/customer/account/']")
	private WebElement accountButtonElement;
	
	@FindBy(linkText="My Account")
	private WebElement accountLinkElement;
	
	@FindBy(xpath="//h2[contains(text(),'This is demo site for')]")
	private WebElement mainTitleElement;
	
	//getting text of the main title
	public String getMainTitle() {
		return getElementText(mainTitleElement, 4);
	}
	//clicking on mobile Button in main page
	public void mobileBtnClick() {
		
		click(mobileBtnElement, 4);
	}
	
	//clicking on Account button on main page
	public void accountBtnClick() {
		
		click(accountButtonElement, 4);
	}
	
	//clicking on Account link on main page
	public void accountLinkClick() {
		
		click(accountLinkElement, 4);
	}
	
	
}
