package tests;

import java.util.Properties;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CricbuzzHomePage;
import utilities.TestUtility;

public class RunnerCricbuzz 
{
	//global properties
	public RemoteWebDriver driver;
	public Properties pro;
	public CricbuzzHomePage cbp;
	public TestUtility tu;
	public WebDriverWait w;
	
	@BeforeMethod()
	public void method1() throws Exception
	{
		tu=new TestUtility();
		pro=tu.accessProperties();
		driver=tu.openBrowser("chrome");
		tu.launchSite(pro.getProperty("url"));
		cbp=new CricbuzzHomePage(driver);
	}
	@Test()
	public void method2()
	{
		String secs=pro.getProperty("maxwait");
		int wait=Integer.parseInt(secs);
		w=new WebDriverWait(driver,wait);
		w.until(ExpectedConditions.visibilityOf(cbp.matches)).click();
		if(cbp.sa.isDisplayed())
		{
			Reporter.log("Test passed");
			Assert.assertTrue(true);
		}
		else
		{
			Reporter.log("Test failed");
			Assert.assertTrue(false);
		}
		
	}
	
	@AfterMethod()
	public void method3()
	{
		tu.closeSite();
	}
	
	
}
