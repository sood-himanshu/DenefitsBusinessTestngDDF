package business.denefits.com.testcases;

import org.testng.annotations.Test;

import business.denefits.com.base.BaseTest;

public class DummyTestB extends BaseTest{
	
	@Test(priority = 1)
	public void B1()
	{
		openBrowser("browser");
		navigate("siteURL");
		
	}

}
