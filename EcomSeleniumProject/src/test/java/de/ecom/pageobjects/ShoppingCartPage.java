package de.ecom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends Base {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@title='Qty']")
	private WebElement cartQuantityElement;
	
	@FindBy(xpath="//button[@type='submit' and @title='Update']")
	private WebElement updateCartBtnElement;
	
	@FindBy(xpath="//li[@class='error-msg']")
	private WebElement productAvailabilityErrorMsgElement;
	
	@FindBy(id="region_id")
	private WebElement regionOfShippingEstimateElement;
	
	@FindBy(id="postcode")
	private WebElement zipCodeOfShippingEstimateElement;
	
	@FindBy(xpath="//button[@title='Estimate']")
	private WebElement shippingEstimateButtonElement;
	
	@FindBy(xpath="//input[@name='estimate_method']")
	private WebElement shippingEstimateRadioBtnElement;
	
	@FindBy(xpath="//button[@title='Update Total']")
	private WebElement shippingUpdateTotalBtnElement;
	
	@FindBy(xpath="(//button[@title='Proceed to Checkout'])[2]")
	private WebElement proceedToCheckoutBtnElement;
	
	//updating the qty value 
	public void updateQuantity(String quantity) {
		
		enterText(cartQuantityElement, 4, quantity);
	}
	
	
	//click on update cart button
	public void clickUpdateQtyBtn() {
		
		click(updateCartBtnElement, 4);
	}
	
	//getting the text of the error message
	public String getTextOfErrorMessage() {
		
		return getElementText(productAvailabilityErrorMsgElement, 4);
	}

	//selecting region from state dropdown
	public void selectRegionShippingEstimate(String region) {
		
		selectFromDropdown(5, regionOfShippingEstimateElement, region);
	}
	
	//entering zip code
	public void enterZipCodeShippingEstimate(String zipCode) {
		
		enterText(zipCodeOfShippingEstimateElement, 4, zipCode);
	}
	
	//click on shipping estimate button
	public void clickEstimateBtn() {
			
		click(shippingEstimateButtonElement, 4);
	}
		
	//clicking on estimated shipping radio button
	public void clickEstimatedShippingRadio() {
		
		click(shippingEstimateRadioBtnElement, 5);
	}
	
	//clicking on update total btn
	public void clickUpdateTotalBtn() {
			
		click(shippingUpdateTotalBtnElement, 5);
	}
		
	//clicking on proceed to checkout button
	public void clickProceedToCheckoutBtn() {
			
		click(proceedToCheckoutBtnElement, 5);
	}
}
