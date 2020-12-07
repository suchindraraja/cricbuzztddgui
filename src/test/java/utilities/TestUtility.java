package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestUtility 
{
	//global objects
	public RemoteWebDriver driver;
	
	public TestUtility()
	{
		driver=null;
	}
	
	//reusable methods 
	public RemoteWebDriver openBrowser(String bn)
	{
		if(bn.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(bn.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(bn.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(bn.equalsIgnoreCase("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		else
		{
			System.out.println("enter correct browser name");
			System.exit(0);
		}
		return driver;
	}
	
	public void launchSite(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public void closeSite()
	{
		driver.close();
	}
	
	public Properties accessProperties() throws Exception
	{
		File f=new File("C:\\Users\\sukumar raja\\eclipse-workspace\\tddframework\\src\\test\\resources\\properties\\config.properties");
		FileInputStream fi=new FileInputStream(f);
		Properties p=new Properties();
		p.load(fi);
		return p;
	}
	
	public String screenshot() throws Exception
	{
		SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
		Date dt=new Date();
		String fn=sf.format(dt)+".png";
		File src=driver.getScreenshotAs(OutputType.FILE);
		File dest=new File(fn);
		FileHandler.copy(src, dest);
		String path=dest.getAbsolutePath();
		return path;
	}

}
