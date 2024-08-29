package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Reports {

	ExtentReports extentReport;
	@BeforeMethod
	public void Config()
	{
		String path=System.getProperty("user.dir")+"\\Extenteports\\te.html";
		
		
		ExtentSparkReporter sparkreporter=new ExtentSparkReporter(path);
		
		sparkreporter.config().setReportName("test reports");
		sparkreporter.config().setDocumentTitle("web test");
		
		sparkreporter.config().setProtocol(Protocol.HTTP);
		sparkreporter.config().setTheme(Theme.DARK);
			
		extentReport=new ExtentReports();
		
		extentReport.attachReporter(sparkreporter);
		extentReport.setSystemInfo("Tester Name","karan");
		
	}
	
	
@Test	
public void test()
{
	
	ExtentTest Test = extentReport.createTest("tests");
	
	WebDriverManager.chromedriver().setup();
	
	WebDriver driver =new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	driver.get("https://www.google.com/");
	driver.manage().window().maximize();
	extentReport.flush();
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
