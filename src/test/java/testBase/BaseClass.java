package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;//for logger
import org.apache.logging.log4j.Logger;//for logger
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

 public class BaseClass {

 static  public WebDriver driver;//making web driver variable as static then only takes screen shot will access at run time
 public Logger logger; //logger variable 

 public ResourceBundle rb;
 
    @BeforeClass(groups= {"sanity","regression","master"})
	@Parameters("browser") //getting browser parameter from testng.xml
  public void setup(String br)
	{
    	rb=ResourceBundle.getBundle("config");
    	
		logger=LogManager.getLogger(this.getClass());//for logging
		
		//launch browser based on parameter "browser"
		if(br.equals("chrome")|| br.equals(""))
		{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		/*else if(br.equals("firefox"))
		{
             WebDriverManager.firefoxdriver().setup();
             driver=new FirefoxDriver();
		}*/
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
	}
    
	@AfterClass(groups= {"sanity","regression","master"})
	public void teardown()
	{
		driver.quit();
	}
	
	
	public String randomString()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
	    return generatedstring;
	}
	
	public String randomNumber()
	{
		String generatedNumString=RandomStringUtils.randomNumeric(10);
	    return  generatedNumString;
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMdd-hh-mm-ss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;
	}
	
}
