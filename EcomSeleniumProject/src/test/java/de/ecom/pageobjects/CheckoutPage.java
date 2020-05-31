package de.ecom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends Base {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="billing:street1")
	private WebElement billingStreetElement ;
	
	@FindBy(id="billing:city")
	private WebElement billingCityElement ;
	
	@FindBy(id="billing:region_id")
	private WebElement billingRegionElement;
	
	@FindBy(id="billing:postcode")
	private WebElement billingZipCodeElement ;
	
	@FindBy(id="billing:country_id")
	private WebElement billingCountryElement ;
	
	@FindBy(id="billing:telephone")
	private WebElement billingTelephoneElement;
	
	@FindBy(xpath="//*[@id='billing-buttons-container']/button")
	private WebElement billingContinueButtonElement;
	
	@FindBy(xpath="//*[@id='shipping-method-buttons-container']/button[@onclick='shippingMethod.save()']")
	private WebElement shippingContinueButtonElement;
	
	@FindBy(xpath="//div[@id='checkout-step-payment']//form//div//dt[@id='dt_method_checkmo']//input")
	private WebElement paymentMoneyOrderRadioButtonElement;
	
	@FindBy(xpath="//button[@onclick='payment.save()']")
	private WebElement paymentMethodContinueButtonElement;
	
	@FindBy(xpath="//button[@title='Place Order']")
	private WebElement placeOrderButtonElement;
	
	//entering the billing street
	public void enterBillingStreet(String billingStreet) {
		
		enterText(billingStreetElement, 4, billingStreet);
		
		
	}
	
	//entering the billing city
	public void enterBillingCity(String billingCity) {
			
		enterText(billingCityElement, 4, billingCity);
			
			
	}
		
	//entering the billing region
	public void selectBillingRegion(String billingRegion) {
			
		selectFromDropdown(4, billingRegionElement, billingRegion);
			
			
	}
		
	//entering the billing zip code
	public void enterBillingZipCode(String billingZipCode) {
			
		enterText(billingZipCodeElement, 4, billingZipCode);
			
			
	}
		
	//entering the billing country
	public void selectBillingCountry(String billingCountry) {
			
		selectFromDropdown(4, billingCountryElement, billingCountry);
			
			
	}
	
	//entering the billing telephone
	public void enterBillingTelephone(String billingTelephone) {
				
		enterText(billingTelephoneElement, 4, billingTelephone);
				
	}
	
	//clicking on billing continue button
	public void clickBillingContinueBtn() {
		
		clickJavaScript(billingContinueButtonElement, 4);
	}
	
	//clicking on shipping continue button
	public void clickShippingContinueBtn() {
			
		click(shippingContinueButtonElement, 4);
	}
		
	//clicking on payment Method RadioButton
	public void clickPaymentMoneyOrderRadioBtn() {
			
		click(paymentMoneyOrderRadioButtonElement, 4);
	}
		
	//clicking on payment method continue button
	public void clickPaymentMethodContinueBtn() {
			
		click(paymentMethodContinueButtonElement, 4);
	}
		
	//clicking on place order button
	public void clickPlaceOrderBtn() {
			
		click(placeOrderButtonElement, 4);
	}
}
