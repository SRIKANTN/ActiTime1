package Com.ActiTime.Generic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public abstract class BaseTest implements Autoconstant
{
	
	public WebDriver driver;
	@BeforeMethod
	@Parameters({"nodeurl","browser","appurl"})
	public void Precondition(String nodeurl, String browser, String appurl) throws MalformedURLException
	{
			URL url = new URL(nodeurl);
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName(browser);
		    driver = new RemoteWebDriver(url, dc);
		    driver.get(appurl);
	}
	
	@AfterMethod
	public void Postcondition(ITestResult res)
	{
		int status = res.getStatus();
		if(status==2)
		{
			String name = res.getMethod().getMethodName();
			GenericUtlis.getScreenShot(driver, name);
		}
		driver.close();
	}
}
