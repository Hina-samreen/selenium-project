package de.ecom.hilfsprog;

import java.util.Set;

import de.ecom.testbasis.TestBasis;

public class BasicUtility extends TestBasis {
	
	//checking if an array is sorted or not
	public static boolean issorted(String[] arr, int num_of_items) {
		for (int i = 0; i < num_of_items - 1; ++i) {
			if (arr[i].compareTo(arr[i + 1]) > 0)
            return false;
		}
		return true;
	}
	
	//switching to other windows
	public static void windowSwitch() throws InterruptedException {
		String parentWinHandle = driver.getWindowHandle(); // Store your parent window

		Set<String> winHandles = driver.getWindowHandles(); // get all window handles
	
		for(String handle: winHandles){
            if(!handle.equals(parentWinHandle)){
            driver.switchTo().window(handle);
            Thread.sleep(1000);
            
           }
		}
	}
	
	//switching back to parent window
	
	public static void windowSwitchToParentHandle() throws InterruptedException {
		
		String parentWinHandle = driver.getWindowHandle(); // Store your parent window
		driver.switchTo().window(parentWinHandle);
            
	}

}
