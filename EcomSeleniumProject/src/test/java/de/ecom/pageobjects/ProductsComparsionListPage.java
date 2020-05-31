package de.ecom.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsComparsionListPage extends Base {

	public ProductsComparsionListPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//*[@class='product-name']")
	private List<WebElement> allProductsaddedTocompare;
	
	
	
	//getting text of elements added to compare in mobile page
	public String[] getTextOfElementsAddedToCompare_ComparePage() {
		return getTextOfElements(allProductsaddedTocompare, 4);
			
		}

	
}
