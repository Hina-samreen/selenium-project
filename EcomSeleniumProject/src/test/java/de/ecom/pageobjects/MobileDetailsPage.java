package de.ecom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobileDetailsPage extends Base {

	public MobileDetailsPage(WebDriver driver) {
		super(driver);

	}
	
	@FindBy(css="span#product-price-1.regular-price")
	private WebElement xperiaPriceElement;
	
	//getting text(price) of sony xperia mobile
	public String getPriceXperia() {
		
		return getElementText(xperiaPriceElement, 6);
	}
	

}
