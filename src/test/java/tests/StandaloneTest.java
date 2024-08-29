package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.ConformationPage;
import pageObjects.LoginPage;
import pageObjects.ProductCatlog;
import test_Components.BaseTest;


public class StandaloneTest extends BaseTest 
{

	String productName="ZARA COAT 3";
	
@Test(retryAnalyzer = test_Components.Retry.class)	
public void StandAlone_Test()
{

ProductCatlog productCatlog = loginPage.Login("theboys@12gmail.com","Karan@11");
	
List<WebElement> productList = productCatlog.getProductList();
	
	
	productCatlog.addProductToCart(productName);
	
	CartPage cartPage = productCatlog.goToCartPage();
	
	boolean verifyProductDisplay = cartPage.VerifyProductDisplay(productName);
	
	Assert.assertTrue(verifyProductDisplay);

	CheckoutPage checkoutPage = cartPage.goToCheckout();
	
	checkoutPage.selectCountry("india");
	
	ConformationPage conformationPage = checkoutPage.submitOrder();
	
	String message = conformationPage.Verifyconformationmessage();
	
	
	Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	
	
}	


}

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

