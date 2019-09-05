package Com.ActiTime.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.ActiTime.Generic.BasePage;

public class actiTIMELoginPage extends BasePage
{
	//declaration
	@FindBy(id="username")
	private WebElement unTB;
	
	@FindBy(name="pwd")
	private WebElement pwTB;
	
	@FindBy(xpath="//div[text()='Login ']")
	private WebElement lgBT;
	
	@FindBy(xpath="//span[text()='Username or Password is invalid. Please try again.']")
	private WebElement errmsg;
	
	@FindBy(xpath="//nobr[contains(text(),'actiTIME')]")
	private WebElement version;
	//intilization
	public actiTIMELoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	//utilization
	public void EnterUserName(String un)
	{
		unTB.sendKeys(un);
	}
	
	public void EnterPassword(String pw)
	{
		pwTB.sendKeys(pw);	
		
	}
	
	public void ClickOnLogin()
	{
		lgBT.click();
	}
	
	public String verifyErrorMsg()
	{
		verifyElement(errmsg);
		String aerrormsg = errmsg.getText();
		return aerrormsg;
	}
	
	public String verifyVersion()
	{
		verifyElement(version);
		String aversion = version.getText();
		return aversion;
	}
}
