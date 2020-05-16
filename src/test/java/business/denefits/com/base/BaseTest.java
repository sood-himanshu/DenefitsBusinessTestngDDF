package business.denefits.com.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;



public class BaseTest {
	
	public WebDriver driver;
	public Properties prop;
	
	public void openBrowser(String bType)
	{
		prop = new Properties();
		try
		{
			FileInputStream fn = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\business\\denefits\\com\\resources\\projectConfig.properties");
		    prop.load(fn);
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if((prop.getProperty(bType)).equalsIgnoreCase("mozilla"))
		{
			//System.setProperty("webdriver.gecko.driver", "D:\\New folder (2)\\Practise\\Jars\\jars\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if((prop.getProperty(bType)).equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	public void navigate(String url)
	{
		driver.get(prop.getProperty(url));
		
	}
	
	public void click()
	{
		
	}
	
	public void type()
	{
		
	}
	
	public WebElement getElement(String locatorkey)
	{
		WebElement e = null;
		try
		{
			if(locatorkey.endsWith("_id"))
			{
				e = driver.findElement(By.id(prop.getProperty(locatorkey)));
			}
			else if(locatorkey.endsWith("_xpath"))
			{
				e = driver.findElement(By.id(prop.getProperty(locatorkey)));
			}
			else if(locatorkey.endsWith("_name"))
			{
				e = driver.findElement(By.id(prop.getProperty(locatorkey)));
			}
			else
			{
				reportFailure("Locator not found" + locatorkey);
			}
		}
		catch(Exception ex)
		{
			reportFailure(ex.getMessage());
			ex.printStackTrace();
			Assert.fail("Failed the test "+ ex.getMessage());
		}
		
		return e;
	}
	
	/*************Validation**********************************************************/
	
	public boolean verifyTitle()
	{
		return false;
	}
	
	public boolean verifyText()
	{
		return false;
	}
	
	public boolean isElementPresent()
	{
		return false;
	}
	
	/**************Reporting Function********************************************************************/

	public void reportPass(String msg)
	{
		
	}
	
	public void reportFailure(String msg)
	{
		
	}
	
	public void takeScreensot()
	{
		
	}
}
