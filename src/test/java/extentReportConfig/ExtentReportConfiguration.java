package extentReportConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportConfiguration {

	
	
public static ExtentReports getExtentReportObject()
{
	
	String path=System.getProperty("user.dir")+"//reports//index.html";
	
	ExtentSparkReporter sparkReporter=new ExtentSparkReporter(path);
	
	sparkReporter.config().setDocumentTitle("TEST RESULTS");
	sparkReporter.config().setReportName("Web Automation Tests");
	sparkReporter.config().setTheme(Theme.DARK);
	
	ExtentReports extentReports=new ExtentReports();
	
	extentReports.attachReporter(sparkReporter);
	
	extentReports.setSystemInfo("Tester Name","Karan");
	
	return extentReports;
	
		
}
		
}
