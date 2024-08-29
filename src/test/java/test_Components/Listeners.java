package test_Components;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import extentReportConfig.ExtentReportConfiguration;

public class Listeners extends BaseTest implements ITestListener{

	ExtentTest test;	
	ExtentReports extentReports=ExtentReportConfiguration.getExtentReportObject();
	ThreadLocal<ExtentTest>extentTest=new ThreadLocal<ExtentTest>();
//we have to make thread safe for ExtentTest object
	@Override
	public void onTestStart(ITestResult result) {
	
	 test = extentReports.createTest(result.getMethod().getMethodName());	
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		 extentTest.get().log(Status.PASS,"Test Passed..!");
		
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
	
      extentTest.get().fail(result.getThrowable());
	
		try
		{
		driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} 	
		catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	

		String screenShotPath =null;
		try 	
		{
			screenShotPath = getScreenShot(result.getMethod().getMethodName(),driver);
			} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		
		extentTest.get().addScreenCaptureFromPath(screenShotPath,result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extentReports.flush();
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
