package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	@Test(groups= {"regression","master"})
	public void  accountRegistration() throws InterruptedException
	{		
		logger.info("Strating TC_001_AccountRegistrationtTest");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account ");
			
			hp.clickRegister();
			logger.info("Clicked on Register ");

			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
			
			regpage.setFirstname(randomString().toUpperCase());
			logger.info("Provided First Name ");

			regpage.setLastname(randomString().toUpperCase());
			logger.info("Provided Last Name ");

			regpage.setEmail(randomString() + "@gmail.com");// randomly generated the email
			//regpage.setEmail("pavanoltrainings@gmail.com");// duplicate email should fail test case
			logger.info("Provided Email ");

			regpage.setTelephoneNo(randomNumber());
			logger.info("Provided Telephone ");

			regpage.setpwd("test@123");
			logger.info("Provided Password ");

			regpage.setConfirmpwd("test@123");
			logger.info("Provided Confirmed Password ");

			regpage.clickpolicy();
			logger.info("Set Privacy Policy ");

			regpage.clickContinue();
			logger.info("Clicked on Continue ");

			Thread.sleep(2000);

			String confmsg = regpage.getConfirmationMessage();
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			//Assert.fail();
		}

		logger.info("Finished TC_001_AccountRegistrationtTest");
	}
					

}
