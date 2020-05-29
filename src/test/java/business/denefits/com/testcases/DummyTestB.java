package business.denefits.com.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import business.denefits.com.base.BaseTest;
import business.denefits.com.util.DataUtil;
import business.denefits.com.util.Xls_Reader;



public class DummyTestB extends BaseTest
{
	String testCaseName = "TestB";
	Xls_Reader xls = null;
	SoftAssert softAssert = new SoftAssert();
	@Test(dataProvider = "getData")
	public void B1(Hashtable<String, String> data) throws InterruptedException
	{
		test = rep.startTest("Dummy Test B");
		
		test.log(LogStatus.INFO, "Starting Dummy Test B");
		
		if(!DataUtil.isRunnable(testCaseName, xls) || data.get("Runmode").equalsIgnoreCase("N"))
		{
			test.log(LogStatus.SKIP, "Skipping the testcase as Runmode is N");
			throw new SkipException("Skipping the testcase as Rumode is N");
		}
		
		openBrowser("browser");
		test.log(LogStatus.INFO, "Opened the browser");
		navigate("siteURL");
		
		/*softAssert.assertTrue(false, "Err - 1");
		softAssert.assertTrue(true, "Err - 2");
		softAssert.assertTrue(false, "Err - 3"); */
		
		Thread.sleep(8000);
		
		type("signin_username_name", "testdoc1jan@mailinator.com");
		type("signin_password_xpath", "tester1234");
		//click("signinButton_xpath");
		
		test.log(LogStatus.PASS, "Test Dummy B Passed");
		
		takeScreenShot();
		
	}
	
	@AfterMethod
	public void quit()
	{
		try {
			
			softAssert.assertAll();
		}
		catch(Error e)
		{
			test.log(LogStatus.FAIL, e.getMessage());
		}
		rep.endTest(test);
		rep.flush();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		xls = new Xls_Reader(System.getProperty("user.dir") + "//data.xlsx");
		
		return DataUtil.getTestData(xls, "TestB");
		
	}
}
