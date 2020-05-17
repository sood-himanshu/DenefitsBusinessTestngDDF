package business.denefits.com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import business.denefits.com.base.BaseTest;


public class DummyTestB extends BaseTest
{
	@Test(priority = 1)
	public void B1()
	{
		test = rep.startTest("Dummy Test B");
		
		test.log(LogStatus.INFO, "Starting Dummy Test B");
		
		openBrowser("browser");
		test.log(LogStatus.INFO, "Opened the browser");
		navigate("siteURL");
		
		
		test.log(LogStatus.PASS, "Test Dummy B Passed");
		
		takeScreenShot();
		
	}
	
	@AfterMethod
	public void quit()
	{
		rep.endTest(test);
		rep.flush();
	}

}
