package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resusable_utility.Utility;

public class OrderPage extends Utility {


	WebDriver driver;
	
	public OrderPage(WebDriver driver)
	{ 
		super(driver);
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
		
	}	
	
	
	
	

	@FindBy(css=".totalRow button")
	WebElement checkoutele;
	
	@FindBy(css="tr td:nth-child(3)")
	private List<WebElement>productNames;
	
	public Boolean VerifyOrderDispay(String productName)
	{
		
		boolean match=productNames.stream().anyMatch(Product->Product.getText().equalsIgnoreCase(productName));
		return match;
	}	
	
	
	
	
	
	
	
	
	
	
}
