package de.ecom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BackEndPage extends Base {

	public BackEndPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name="login[username]")
	private WebElement userNameBackendElement;
	
	@FindBy(name="login[password]")
	private WebElement passwordBackendElement;
	
	@FindBy(xpath="//*[@title='Login']")
	private WebElement loginBtnBackendElement;
	
	@FindBy(xpath="//*[@title='close']")
	private WebElement closePopUpBackendElement;
	
	@FindBy(xpath="//*[contains(text(),'Sales')]")
	private WebElement salesMenuElement;

	@FindBy(xpath="//*[contains(text(),'Orders')]")
	private WebElement ordersMenuElement;

	@FindBy(id="sales_order_grid_export")
	private WebElement exportDropdownSelectionElement;

	@FindBy(xpath="//button[@title='Export']")
	private WebElement exportButtonElement;
	
	//entering user name in backend page
	public void enterUserNameBackend(String UserName) {
		
		enterText(userNameBackendElement, 4, UserName);
	}
	
	//entering password in backend page
	public void enterPasswordBackend(String Password) {
			
		enterText(passwordBackendElement, 4, Password);
	}
		
	//clicking on login
	public void clickLoginBtnBackend() {
			
		click(loginBtnBackendElement, 4);
	}
	
	//clicking on close popup
	public void clickClosePopupBtnBackend() {
				
		click(closePopUpBackendElement, 4);
	}
		
	//clicking on sales menu
	public void clickSalesMenuBackend() {
				
		click(salesMenuElement, 4);
	}
	
	//clicking on orders menu
	public void clickOrdersMenuBackend() {
					
		click(ordersMenuElement, 4);
	}
	
	//select from export drodown menu
	public void selectFromExportMenu(String exportOption) {
		
		selectFromDropdown(4, exportDropdownSelectionElement, exportOption);
	}
	
	//clicking on export button
	public void clickExportBtnBackend() {
						
		click(exportButtonElement, 4);
	}

}
