package extras;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Exampe1 
{
	@BeforeMethod
	public void method()
	{
		System.out.println("start common");
	}
	@Test(priority=1)
	public void method1()
	{
		System.out.println("hai im first one");
	}
	@Test(priority=2)
	public void method2()
	{
		System.out.println("hai im second one");
	}
	@Test(priority=3)
	public void method3()
	{
		System.out.println("hai im third one");
	}
	@AfterMethod
	public void methodn()
	{
		System.out.println("end common");
	}
	

}
