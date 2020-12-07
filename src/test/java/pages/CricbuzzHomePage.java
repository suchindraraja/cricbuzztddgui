package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CricbuzzHomePage 
{
	//global properties
	public RemoteWebDriver driver;
	
	@FindBy(how=How.XPATH, using="//a[text()='MATCHES']")
	public WebElement matches;
	
	@FindBy(how=How.XPATH, using="//a[text()='Series Archive']")
	public WebElement sa;
	
	//constuctor method
	public CricbuzzHomePage(RemoteWebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

}
