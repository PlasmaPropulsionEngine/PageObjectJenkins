package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import resusable_utility.Utility;

public class CartPage extends Utility {

	
WebDriver driver;

public CartPage(WebDriver driver) {
	
	super(driver);
	this.driver=driver;
	
	PageFactory.initElements( driver,this);
	
}
	
@FindBy(css=".totalRow button")
WebElement checkoutele;


@FindBy(css = "div.cartSection h3")
List<WebElement>CartProducts;	
	
	
public boolean VerifyProductDisplay(String productName)
{
	boolean match=CartProducts.stream().anyMatch(Product->Product.getText().equalsIgnoreCase(productName));
	return match;
	
}
	

public CheckoutPage goToCheckout()
{
	
	checkoutele.click();
	return new CheckoutPage(driver);
	
}	
	
	
	
	
	
	
	
	
	
}
