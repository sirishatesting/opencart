package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
 
 
  public AccountRegistrationPage(WebDriver driver)
   {
	   super(driver);
   }
  
  @FindBy(xpath="//input[@id='input-firstname']")
  WebElement chkFirstName;
  
  @FindBy(xpath="//input[@id='input-lastname']")
  WebElement  chkLastName;
	
  @FindBy(xpath="//input[@id='input-email']")
     WebElement chkEmail;
  
  @FindBy(xpath="//input[@id='input-telephone']")
  WebElement chkTelePhone;
  
  @FindBy(xpath="//input[@id='input-password']")
  WebElement chkPwd;
  
  @FindBy(xpath="//input[@id='input-confirm']")
  WebElement chkconpwd;
  
  @FindBy(xpath="//input[@name='agree']")
  WebElement btnPrivacypolicy;
  
  @FindBy(xpath="//input[@value='Continue']")
  WebElement btnContinue;
  
  @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
  WebElement getmsgConfirmation;
 
  public void setFirstname(String Fname)
  {
	  chkFirstName.sendKeys(Fname); 
  }
  
  public void setLastname(String Lname)
  {
	  chkLastName.sendKeys(Lname);
  }
  
  public void setEmail(String Email)
  {
	  chkEmail.sendKeys(Email);
  }
  
  public void setTelephoneNo(String phoneno)
  {
	  chkTelePhone.sendKeys(phoneno);
  }
  
  public void setpwd(String pwd)
  {
	  chkPwd.sendKeys(pwd);
  }
  
  public void setConfirmpwd(String conpwd)
  {
	  chkconpwd.sendKeys(conpwd);
  }
  
  public void clickpolicy()
  
  {
	  btnPrivacypolicy.click();
  }
  
  public void clickContinue()
  {
	  btnContinue.click();
  }
  
  public String getConfirmationMessage()
  {
	  try
	  {
	  return(getmsgConfirmation.getText());
	  }
	  catch(Exception e)
	  {
		  return(e.getMessage());
	  }
  }
  
  
  
  
  
}
