package de.ecom.listener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import de.ecom.hilfsprog.Screenshot;

public class Listener implements ITestListener {

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		//hey i am done
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		//
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//screenshot

		try {
			
			Screenshot.screenshot(result.getName() + ".jpg");
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
