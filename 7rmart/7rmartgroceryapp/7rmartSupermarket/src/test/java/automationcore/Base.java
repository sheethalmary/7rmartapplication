package automationcore;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constants;
import utilities.ScreenshotUtility;
import utilities.WaitUtility;

public class Base
{
	  WaitUtility wait=new WaitUtility();
	  
Properties prop;
FileInputStream file;
	public WebDriver driver;

	@BeforeMethod
	@Parameters("browser")
	public void initializeBrowser( String browser) throws Exception {
		
		prop=new Properties();
		file=new FileInputStream(Constants.CONFIGFILE);
		prop.load(file);
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver= new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		else
			{
			   throw new Exception("invalid browser");
			}
		
		
		
		driver.get(prop.getProperty("baseurl"));
		
		driver.manage().window().maximize();
      
        wait.implicitlyWait(driver);
        
        		
	}

	@AfterMethod
	public void driverquit(ITestResult itestresult) throws IOException

	{
		if (itestresult.getStatus() == ITestResult.FAILURE)//I TEST RESULT STATUS FAIL OR NOT
		{
			ScreenshotUtility screenshot = new ScreenshotUtility();
			screenshot.getScreenshot(driver, itestresult.getName());
		}
		 driver.quit();

	}

}