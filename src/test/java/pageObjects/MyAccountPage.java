package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	WebDriver driver;

	public MyAccountPage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	@FindBy (xpath="//h2[text()='My Account']")
	WebElement Acclink;
	
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Logout']")
	WebElement lnklogout;
	
	public  boolean isMyaccountpageExists()
	{    
		try
		{
		 return Acclink.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
    
	public void clickLogout()
	{
		lnklogout.click();
	}
	
	

}
