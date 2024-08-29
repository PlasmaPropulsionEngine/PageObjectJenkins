package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resusable_utility.Utility;

public class ProductCatlog extends Utility {

	WebDriver driver;
	public ProductCatlog(WebDriver driver)
	{	
		super(driver);
		this.driver=driver;
		
		PageFactory.initElements(driver,this);	
	}

	
	@FindBy(css = ".mb-3")
	List<WebElement>items;
	
	@FindBy (css=".mb-3")
	WebElement itemWait;
	
	@FindBy(css=".ng-animating")
	WebElement spiner;
	
	By productBy=By.cssSelector(".mb-3"); // collecting locator in by variable which is feature of page factory 
	By addToCart=By.cssSelector("div.card button:last-of-type"); // click on add to cart button
	By tostMessage=By.cssSelector("div#toast-container");
	

	
	public List<WebElement> getProductList()
	{
		
		//wait for all items loaded on page after login
		WaitforAllitemLoads(itemWait);
		return items;
		
	}
	
	
	public WebElement getProductByName(String productName)
	{
		
		WebElement prod=getProductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);	
		
		return prod;
	}
	
	public void addProductToCart(String productName) 
	{
		
		
		// why it is done on prod because scope of driver is under the zara coat section and scope of search will be on second add to cart button only
		WebElement prod=getProductByName(productName);
		prod.findElement(addToCart).click();  // click on add to cart button
		waitForWebElementToAppear(tostMessage);  	//wait till product gets added into cart to visible
		waitForElementToDisappear(spiner);           
		
	}


	
	
	
	
	
}
