package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resusable_utility.Utility;

public class ConformationPage  extends Utility{

	WebDriver driver;
	
public ConformationPage(WebDriver driver) 
{
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver,this);	
}
	

@FindBy(css="h1.hero-primary")
WebElement conformationmessage;

public String Verifyconformationmessage()
{
	
	return conformationmessage.getText();
	
	
	
}
	
	
	
	
	
}
