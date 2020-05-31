package de.ecom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyWishlistPage extends Base{

	public MyWishlistPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//*[@title='Share Wishlist']")
	private WebElement shareWishlistBtnElement;
	
	@FindBy(xpath="//*[@class='success-msg']")
	private WebElement wishlistShareSuccessMsgElement;
	
	@FindBy(id="email_address")
	private WebElement emailAddressShareWishlistElement;
	
	@FindBy(id="message")
	private WebElement messageShareWishlistElement;
	
	@FindBy(xpath="//button[@title='Add to Cart']")
	private WebElement addToCartBtnElement;
	
	//clicking on share wishlist btn
	public void clickShareWishlistBtn() {
		
		click(shareWishlistBtnElement, 4);
	}
	
	//getting the text once the wishlist has been sucessfully shared
	public String getTextOfWishlistShareSuccess() {
		
		return getElementText(wishlistShareSuccessMsgElement, 4);
	}
	
	//entering the email address to share the wishlist with
	public void enterEmailAddressForWishlistShare(String EmailAdress) {
		
		enterText(emailAddressShareWishlistElement, 4, EmailAdress);
	}
	
	//entering the message with the wishlist sharing
	public void enterMessageForWishlistShare(String message) {
		
		enterText(messageShareWishlistElement,4,message);
	}
	
	//clicking on add to cart button
	public void clickAddToCartBtn() {
		click(addToCartBtnElement, 4);
	}
}
