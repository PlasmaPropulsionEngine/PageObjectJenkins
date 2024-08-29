package tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.ConformationPage;
import pageObjects.ProductCatlog;
import test_Components.BaseTest;

public class DataProviderTest extends BaseTest{

	

	String productName="ZARA COAT 3";
	
@Test(dataProvider = "dataset")	
public void StandAlone_Test(String email,String pass,String productN)
{

ProductCatlog productCatlog = loginPage.Login(email,pass);
	
List<WebElement> productList = productCatlog.getProductList();
	
	
	productCatlog.addProductToCart(productN);
	
	CartPage cartPage = productCatlog.goToCartPage();
	
	boolean verifyProductDisplay = cartPage.VerifyProductDisplay(productN);
	
	Assert.assertTrue(verifyProductDisplay);

	CheckoutPage checkoutPage = cartPage.goToCheckout();
	
	checkoutPage.selectCountry("india");
	
	ConformationPage conformationPage = checkoutPage.submitOrder();
	
	String message = conformationPage.Verifyconformationmessage();
	
	
	Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	
	
}		
	
	
@DataProvider	
public Object[][] dataset()
{
	

return new Object[][] {{"theboys@12gmail.com","Karan@11","ZARA COAT 3"},{"spider@gmail.com","Karan@12","ADIDAS ORIGINAL"}};	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
