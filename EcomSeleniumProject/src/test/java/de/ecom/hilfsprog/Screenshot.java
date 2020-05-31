package de.ecom.hilfsprog;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import de.ecom.testbasis.TestBasis;
import org.apache.commons.io.FileUtils;

public class Screenshot extends TestBasis {
	
	public static void screenshot(String screenShotName) throws IOException {
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	String Path = System.getProperty("user.dir") + "\\src\\test\\resources\\de\\ecom\\report\\";
	File file= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(file, new File(Path + screenShotName));
	
	}
	

}
