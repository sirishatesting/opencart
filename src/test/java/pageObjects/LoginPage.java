package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
    WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	
	@FindBy (xpath="//input[@id='input-email']")
	WebElement chkEmail;
	
	@FindBy (xpath="//input[@id='input-password']")
	WebElement chkpassword;
	
	@FindBy (xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	
	public void setEmail(String Email)
	{
		chkEmail.sendKeys(Email);
	}

	public void setPassword(String pwd)
	{
		chkpassword.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		btnLogin.click();	
	}
}
