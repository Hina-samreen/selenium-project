package de.ecom.testbasis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import de.ecom.pageobjects.BackEndPage;
import de.ecom.pageobjects.CheckoutPage;
import de.ecom.pageobjects.HomePage;
import de.ecom.pageobjects.LoginPage;
import de.ecom.pageobjects.MainPage;
import de.ecom.pageobjects.MobileDetailsPage;
import de.ecom.pageobjects.MobilePage;
import de.ecom.pageobjects.MyWishlistPage;
import de.ecom.pageobjects.ProductsComparsionListPage;
import de.ecom.pageobjects.RegisterPage;
import de.ecom.pageobjects.ShoppingCartPage;
import de.ecom.pageobjects.TVPage;


public class TestBasis {
	
	//System.out.println(System.getProperty("user.dir"));
	public static WebDriver driver;
	public static Properties config = new Properties();
	public Properties locator = new Properties();
	public FileInputStream fis;
	public MainPage mainpage;
	public MobilePage mobilepage;
	public ProductsComparsionListPage productscomparsionpage;
	public MobileDetailsPage mobileDetailsPage;
	public ShoppingCartPage shoppingcartpage;
	public LoginPage loginpage;
	public RegisterPage registerpage;
	public HomePage homepage;
	public TVPage tvpage;
	public MyWishlistPage mywishlistpage;
	public CheckoutPage checkoutpage;
	public BackEndPage backendpage;
	
	
	
	@Parameters({ "optional-value" })
	@BeforeMethod
	public void setUp(@Optional("optional value") String value) {
		
		
		//loading the config file
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\de\\ecom\\properties\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			config.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//loading the locator file
		try {
			fis= new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\de\\ecom\\properties\\locator.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			locator.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//setting the webdrivers
		if(config.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\de\\ecom\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(config.getProperty("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\de\\ecom\\executables\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		
	
		//invoking the website
		if(value.equalsIgnoreCase("optional value")) {
		driver.get(config.getProperty("url"));
		System.out.println("if only no parameter for URL is passed then i execute " + driver.getCurrentUrl());
		}
		else {
			driver.get(value);
			System.out.println("else i execute " + driver.getCurrentUrl());
		}
		
		//instantiating the page objects
		mainpage=new MainPage(driver);
		mobilepage=new MobilePage(driver);
		productscomparsionpage=new ProductsComparsionListPage(driver);
		mobileDetailsPage=new MobileDetailsPage(driver);
		shoppingcartpage=new ShoppingCartPage(driver);
		loginpage=new LoginPage(driver);
		registerpage=new RegisterPage(driver);
		homepage= new HomePage(driver);
		tvpage=new TVPage(driver);
		mywishlistpage=new MyWishlistPage(driver);
		checkoutpage=new CheckoutPage(driver);
		backendpage=new BackEndPage(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}

}
