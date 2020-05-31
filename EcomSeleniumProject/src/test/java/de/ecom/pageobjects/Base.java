package de.ecom.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Base {
	
	Duration timeout;
	int time;
	Duration timeduration;
	WebDriver driver;
	
	//constructor
	public Base(WebDriver driver) {
		
		this.driver=driver;
		//Initialising the page factory elements 
		PageFactory.initElements(driver, this);
	}
	
	//Invoking the URL
	public void visit(String URL) {
		
		try {
			
			driver.get(URL);
			
		}catch(WebDriverException wde){
			
			System.out.println(wde);
			
		}
	}
	
	//Getting the duration in seconds
	public Duration getDuration(int time) {
		
		return Duration.ofSeconds(time);
	}
	
	//Entering text in the input text elements
	public void enterText(WebElement element, int time, String inputText) {
		
		try {
			
			new WebDriverWait(driver, getDuration(time)).until(ExpectedConditions.elementToBeClickable(element)).clear();
			new WebDriverWait(driver, getDuration(time)).until(ExpectedConditions.elementToBeClickable(element)).sendKeys(inputText); 
			}catch(WebDriverException wde){
				
				System.out.println(wde);
				
				
			}
	}
	
	//Clicking on the WebElements
	public void click(WebElement element,int time) {
		
		try {
			new WebDriverWait(driver, getDuration(time)).until(ExpectedConditions.elementToBeClickable(element)).click();
			
			}catch(WebDriverException wde){
				
				System.out.println(wde);
				
				
			}
		
	}
	
	//Waiting until the Webelement is visible
	public void waitUntilElementVisible(WebElement element,int time) {
		
		try {
			
			new WebDriverWait(driver,getDuration(time)).until(ExpectedConditions.visibilityOf(element));
			
		}catch(WebDriverException wde){
			
			System.out.println(wde);
			
			
		}
	}
	
	//Waiting until the many Webelements are visible
	public void waitUntilElementsVisible(List<WebElement> elements,int time) {
			
		try {
				
			new WebDriverWait(driver,getDuration(time)).until(ExpectedConditions.visibilityOfAllElements(elements));
				
		}catch(WebDriverException wde){
				
			System.out.println(wde);
			
		}
	}
	
	
	//Selecting from a drop down with the help of a visible text 
	public void selectFromDropdown(int time,WebElement element, String visibleText) {
		
		waitUntilElementVisible(element, time);
		Select select= new Select(element);
		try {
			
			select.selectByVisibleText(visibleText);
		}
		catch(WebDriverException wde){
			
			System.out.println(wde);
			
			
			
		}
		
	}
	
	//Checking of a WebElement is displayed or not
	public boolean elementIsDisplayed(WebElement element, int time) {
		waitUntilElementVisible(element, time);
		boolean value=false;
		try {
			
			if(element.isDisplayed()) {
				
				value=true;
			}
			
		}catch(WebDriverException wde) {
			
			System.out.println(wde);
			
			
		}
		return value;
	}
	
	//Getting a text() attribute of a WebElement
	public String getElementText(WebElement element, int time) {
		
		waitUntilElementVisible(element, time);
		String text="";
		
		try {
			
		  text= element.getText();
			
		}catch(WebDriverException wde) {
			
			System.out.println(wde);
			
		}
		return text;
	}
		
	//Getting size of list of webelements
	public int getElementsSize(List<WebElement> elements, int time) {
		
		waitUntilElementsVisible(elements, time);
		int size=0;
		try {
			
			size=elements.size();
			
		}catch(WebDriverException wde) {
			
			System.out.println(wde);
			
		}
		return size;
		
	}
	
	//Getting title of a page
	public String getTitle() {
		
		String title="";
		try {
			
			title=driver.getTitle();
			
		}catch(WebDriverException wde) {
			
			System.out.println(wde);
			
		}
		
		return title;
		
	}
	
	//Getting the texts of webelements and storing them in an array
	public String[] getTextOfElements(List<WebElement> elements, int time) {
		
		waitUntilElementsVisible(elements, time);
		int sizeOfElements= getElementsSize(elements,time);
		String[] textsOfElements= new String[sizeOfElements];
		for(int j=0;j<sizeOfElements;j++) {
			
			textsOfElements[j]= elements.get(j).getText();
		
		}
		
		return textsOfElements;
		
	}
	
	//Getting a particular attribute for a list of webelements
	public String[] getAttributeOfElements(List<WebElement> elements,String attribute, int time) {
		
		waitUntilElementsVisible(elements, time);
		int sizeOfElements= getElementsSize(elements,time);
		String[] textsOfElements= new String[sizeOfElements];
		for(int j=0;j<sizeOfElements;j++) {
			
			textsOfElements[j]= elements.get(j).getAttribute(attribute);
		
		}
		
		return textsOfElements;
		
	}
	
	//Clicking on a web element with the help of java script(sometimes its necessary to do so) because normal click doesnt work
	public void clickJavaScript(WebElement element,int time) {
		waitUntilElementVisible(element, time);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			js.executeScript("arguments[0].click();", element);
		}catch(WebDriverException wde) {
			System.out.println(wde);
			
		}
	}

}
