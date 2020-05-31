package de.ecom.pageobjects;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class MobilePage extends Base{

	public MobilePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//select[@title='Sort By']")
	private WebElement sortByElement;
	
	@FindAll(@FindBy(xpath="//li[@class='item last']//a[@class='product-image']"))
	private List<WebElement> mobileElements;
	
	@FindBy(xpath="//a[contains(@href,'http://live.demoguru99.com/index.php/catalog/product_compare/add/product/1/uenc/')]")
	private WebElement compareLinkMobile1;
	
	@FindBy(xpath="//a[contains(@href,'http://live.demoguru99.com/index.php/catalog/product_compare/add/product/3/uenc/')]")
	private WebElement compareLinkMobile2;

	@FindBy(xpath="//button[@title='Compare']")
	private WebElement compareButtonElement;
	
	@FindBy(xpath="//div[@class='category-products']//ul[contains(@class,'products-grid')]//li[1]//div[@class='product-info']//div[@class='actions']//button[@title='Add to Cart']")
	private WebElement addToCartFirstProductButtonElement;
	
	@FindAll(@FindBy(xpath="//p[@class='product-name']"))
	private List<WebElement> allElementsAddedToCompare;
	
	@FindAll(@FindBy(xpath="//div[@class='price-box']//span[@class='price']"))
	private List<WebElement> costsOfMobileElements;
	
	@FindBy(xpath="//a[@title='Xperia']")
	private WebElement xperiaMobileIconElement;
	
	//selecting a value from sort by drop down
	public void selectValueSortBy(String VisibleText) {
		
		selectFromDropdown(4, sortByElement, VisibleText);
		
	}
	
	//getting texts(costs) of mobileElements
	public String[] getCostsOfMobiles() {
		
		return getTextOfElements(costsOfMobileElements, 3);
	}
	
	//getting attribute title for mobileElements
	public String[] getTitleOfMobileElements() {
		
		return getAttributeOfElements(mobileElements, "title", 6);
	}
	
	//clicking on compare link of mobile1
	public void clickCompareLinkMobile1() {
		
		click(compareLinkMobile1, 6);
	}
	
	//clicking on compare link of mobile2
	public void clickCompareLinkMobile2() {
			
		click(compareLinkMobile2, 6);
	}
	
	//clicking on compare link of mobile2
	public void clickcompareButton() {
				
		click(compareButtonElement, 6);
	}
	
	//clicking on compare link of mobile2
	public void clickAddToCartFirstProductButton() {
					
		click(addToCartFirstProductButtonElement, 6);
	}
	
	//clicking on sony xperia icon/image
	public void clickXperiaIcon() {
		
		click(xperiaMobileIconElement, 4);
	}
	
	//getting text of elements added to compare in mobile page
	public String[] getTextOfElementsAddedToCompare_MobilePage() {
		
		return getTextOfElements(allElementsAddedToCompare, 4);

	}
}
