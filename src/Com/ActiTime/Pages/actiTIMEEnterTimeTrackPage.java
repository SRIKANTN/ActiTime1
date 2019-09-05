package Com.ActiTime.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.ActiTime.Generic.BasePage;

public class actiTIMEEnterTimeTrackPage extends BasePage
{
	//Declaration
	@FindBy(id="logoutLink")
	private WebElement logout;
	//intlization
	public actiTIMEEnterTimeTrackPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	//utilization
	public void ClickOnLogout()
	{
		logout.click();
	}

}
