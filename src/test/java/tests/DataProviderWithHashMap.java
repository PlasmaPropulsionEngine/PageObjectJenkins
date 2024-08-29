package tests;

import java.util.HashMap;
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

public class DataProviderWithHashMap extends BaseTest {

	
String productName="ZARA COAT 3";
	
@Test(dataProvider = "dataset")	
public void StandAlone_Test(HashMap<String,String>input)
{

ProductCatlog productCatlog = loginPage.Login(input.get("email"),input.get("pass"));
	
List<WebElement> productList = productCatlog.getProductList();
	
	
	productCatlog.addProductToCart(input.get("product"));
	
	CartPage cartPage = productCatlog.goToCartPage();
	
	boolean verifyProductDisplay = cartPage.VerifyProductDisplay(input.get("product"));
	
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

	HashMap<String,String>map=new HashMap<String, String>();
	map.put("email","theboys@12gmail.com");
	map.put("pass","Karan@11");
	map.put("product","ZARA COAT 3");
	
	
	HashMap<String,String>map1=new HashMap<String, String>();
	
	map1.put("email","spider@gmail.com");
	map1.put("pass","Karan@12");
	map1.put("product","ADIDAS ORIGINAL");

	return new Object[][] {{map},{map1}};
	
	
}
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
