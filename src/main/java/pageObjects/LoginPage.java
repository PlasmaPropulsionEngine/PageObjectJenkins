package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
WebDriver driver;
	
	
public LoginPage(WebDriver driver) 
{
	this.driver=driver;

	PageFactory.initElements(driver,this);
}	
	
	
	@FindBy (id="userEmail")
	WebElement UserEmail;
	
	@FindBy (id="userPassword")
	WebElement Password;
	
	@FindBy(id="login")
	WebElement loginBtn;
	
	
	public ProductCatlog Login(String email,String pass)
	{
		UserEmail.sendKeys(email);
		Password.sendKeys(pass);
		loginBtn.click();
		
		ProductCatlog productCataloue=new ProductCatlog(driver);
		return productCataloue;
	}
	
	
	public void  goToUrl()
	{
		driver.get("https://rahulshettyacademy.com/client");
		
		
	}
	
	
	
	
	
}
