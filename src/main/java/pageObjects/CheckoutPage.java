package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import resusable_utility.Utility;

public class CheckoutPage extends Utility 
{
	
	WebDriver driver;
	public CheckoutPage(WebDriver driver) 
	{
		super(driver);

		this.driver=driver;
		
		PageFactory.initElements(driver,this);
	}

	@FindBy(css="input[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement selectindia;
	
	@FindBy(css="a.btnn")
	WebElement submit;

	By results=By.cssSelector("section.ta-results");
	
	
	
	public void selectCountry(String countryName)
	{
		Actions a=new Actions(driver);
		a.sendKeys(country,countryName).build().perform();
		
		///wait for options 
		waitForWebElementToAppear(results);
		
		//click on india which is on second place OR also use css .ta-item:nth-of-type(2)
		selectindia.click();
		
	}
	
	
	public ConformationPage submitOrder()
	{
		
		submit.click();
	return	new ConformationPage(driver); 
		
	}
	
	
	
	
	
	
	
	
	
	
}
