package resusable_utility;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import pageObjects.OrderPage;

public class Utility {

	
WebDriver driver;


public Utility(WebDriver driver) 
{
	this.driver=driver;
	
	PageFactory.initElements(driver,this);
}
	
@FindBy(xpath="//ul/li[4]/button")
WebElement cartHeader;
//css [routerlink*='cart']

@FindBy(css="[routerlink*='cart']")
WebElement orderHeader;	

public void WaitforAllitemLoads(WebElement itemWait)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfAllElements(itemWait));
	
	
}



public void waitForWebElementToAppear(By tostMessage)
{
	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(7));
	wait.until(ExpectedConditions.visibilityOfElementLocated((tostMessage)));
	
	
}
	

public void waitForElementToDisappear(WebElement ele) 
{   

	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.invisibilityOf(ele));
	
	
}
	
	
public pageObjects.CartPage goToCartPage()
{
	
	cartHeader.click();
	pageObjects.CartPage cartpage=new pageObjects.CartPage(driver);
	return cartpage;
}	
	
public OrderPage goToOrdersPage()
{
	
	orderHeader.click();
	OrderPage orderpage=new OrderPage(driver);
	return orderpage;
}	
	
	
	
	
	
	
	
	
}
