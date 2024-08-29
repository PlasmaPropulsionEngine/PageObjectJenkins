package test_Components;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;

public class BaseTest {

	
public WebDriver driver;

public LoginPage loginPage;
	
	
public WebDriver initilizationWebDriver() throws IOException
{
	
	Properties pro=new Properties();
	
	FileInputStream fin=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//resources//globalData.properties");
	
	pro.load(fin);
	
	//String browserName = pro.getProperty("browser");
	//get maven patameter form cmd
	String browserName=System.getProperty("browser")!=null ? System.getProperty("browser") : pro.getProperty("browser");
	
	String options=System.getProperty("chromeoption")!=null ? System.getProperty("chromeoption") :"visible";
	
	if(browserName.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions option=new ChromeOptions();
		if(options.equalsIgnoreCase("headless"))
		{
			option.addArguments("headless");
		}
		option.addArguments("--disable-notifications");
		driver=new ChromeDriver(option);
		driver.manage().window().setSize(new Dimension(1440,900));
	}
	else if(browserName.equalsIgnoreCase("firefox"))
	{			
		//firefox	
	}
	else if(browserName.equalsIgnoreCase("edge"))
	{	
		
		WebDriverManager.edgedriver().setup();
		EdgeOptions option=new EdgeOptions();
		if(options.equalsIgnoreCase("headless"))
		{
			option.addArguments("headless");
		}
		option.addArguments("--disable-notifications");
		driver=new EdgeDriver(option);
		
		//System.setProperty("webdriver.edge.driver","C:\\Program Files\\Selenium_webdriver\\msedgedriver.exe");
		driver.manage().window().setSize(new Dimension(1440,900));		
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	driver.manage().window().maximize();
	return driver;
}
	

@BeforeMethod(alwaysRun = true)
public LoginPage Start() throws IOException
{
	 driver = initilizationWebDriver();
	loginPage =new LoginPage(driver);
	loginPage.goToUrl();
	return loginPage;
}

@AfterMethod(alwaysRun = true)
public void browserClose()
{
	
	driver.close();
	
}
	
///Json File
public List<HashMap<String,String>> getJsonDataToMap(String filepath) throws IOException 
{
		
	//read json to string
	
	String jsoncontent = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
	
	// To convert String to HashMap we need Jackson Databind
	
	ObjectMapper mapper=new ObjectMapper(); 
	
	
	List<HashMap<String,String>>data=mapper.readValue(jsoncontent,new TypeReference<List<HashMap<String,String>>>(){});
	
	return data;  //return list of hashmap
	
}
	
//screenshot code

public String getScreenShot(String testcaseName,WebDriver driver) throws IOException
{
	
TakesScreenshot	ts=(TakesScreenshot)driver;
	
File file = ts.getScreenshotAs(OutputType.FILE);	

File source=new File(System.getProperty("user.dir")+"//reports//"+testcaseName+".png");

FileUtils.copyFile(file,source);

return System.getProperty("user.dir")+"//reports//"+testcaseName+".png";
	
	
}
	
	
	
	
	
}
