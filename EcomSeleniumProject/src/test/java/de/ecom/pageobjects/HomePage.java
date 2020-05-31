package de.ecom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Base{

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//*[@class='success-msg']")
	private WebElement registerationSuccessMsgElement;
	
	@FindBy(xpath="//*[@href='http://live.demoguru99.com/index.php/tv.html']")
	private WebElement tvBtnElement;
	
	@FindBy(xpath="//*[@href='http://live.demoguru99.com/index.php/wishlist/']")
	private WebElement myWishlistLinkElement;
	
	@FindBy(xpath="//h1[contains(text(),'Your order has been received')]")
	private WebElement orderReceivedMessageElement;
	
	@FindBy(xpath="//*[contains(@href,'http://live.demoguru99.com/index.php/sales/order/view/order_id/')]")
	private WebElement orderNumberElement;
	
	//getting text of the success message
	public String getTextOfSuccessMsg() {
		
		return getElementText(registerationSuccessMsgElement, 4);
	}

	//clicking on tv button in homepage
	public void clickTVBtn_HomePage() {
		
		click(tvBtnElement, 4);
	}
	
	//clicking on my wishlist link in homepage
	public void clickMyWishlist_HomePage() {
			
		clickJavaScript(myWishlistLinkElement, 20);
	}
	
	//getting the text of order received message
	public String getOrderReceivedMessage() {
		
		return getElementText(orderReceivedMessageElement, 4);
		
	}
	
	//getting the order number text
	public String getOrderNumberText() {
		
		return getElementText(orderNumberElement, 4);
	}
}
