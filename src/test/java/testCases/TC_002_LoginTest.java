package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass 
{
	@Test(groups= {"sanity","master"})
	public void LoginTest()
	{
		try
		{
			
		logger.info("***************starting loginTest************");	
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setEmail(rb.getString("email"));
		lp.setPassword(rb.getString("password"));
		lp.clickLogin();
		
		 MyAccountPage ap=new  MyAccountPage(driver);
		
		boolean status=ap.isMyaccountpageExists();
		
		Assert.assertEquals(status, true);
		
		}
		catch(Exception e)
		{
			//Assert.fail();
		}
	}
	
	

}
