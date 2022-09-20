package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDatadrivenTest extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void LoginDatadriven(String email,String pwd,String expresult)
	{
		try
		{
		logger.info("***************starting TC_003_LoginDatadrivenTest************");
		
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		hp.clickLogin();

		LoginPage lp=new LoginPage(driver);
		
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		MyAccountPage mapage=new MyAccountPage(driver);
		
		boolean targetpage=mapage.isMyaccountpageExists();//myAccountPage class method
		
		if(expresult.equals("valid"))
		{
			if(targetpage==true)
			{
				mapage.clickLogout();
				Assert.assertTrue(true);
			}
			else   //here targetpage=false
			{
				Assert.assertTrue(false);
			}
		}
		
		if(expresult.equals("invalid"))
		{
			if(targetpage==true)
			{
				mapage.clickLogout();//MyAccountPage obj
				Assert.assertTrue(false);
			}
			else //here taegetpage=flase
			{
				Assert.assertTrue(true);
			}
		}
		logger.info("******** FinishedTC_003_LoginDatadrivenTest**********");
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}

}
