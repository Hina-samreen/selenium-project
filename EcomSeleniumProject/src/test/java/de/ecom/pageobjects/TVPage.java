package de.ecom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TVPage extends Base {

	public TVPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[contains(@href,'http://live.demoguru99.com/index.php/wishlist/index/add/product/4/form_key')]")
	private WebElement wishlistLinkFirstTVElement;
	
	//clicking on the add to wishlist link for first tv product
	public void clickAddToWishlistFirstLink() {
		
		click(wishlistLinkFirstTVElement, 4);
	}

}
