package Com.ActiTime.Test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Com.ActiTime.Generic.BaseTest;
import Com.ActiTime.Generic.ExcelData;
import Com.ActiTime.Pages.actiTIMELoginPage;

public class InvalidLoginTest extends BaseTest
{
	@Test(priority=2)
	public void InvalidLogin() throws InterruptedException
	{
		String title = ExcelData.getData(file_path, "TC01", 1, 2);
		actiTIMELoginPage lp = new actiTIMELoginPage(driver);
		lp.VerifyTitle(title);
		int rc = ExcelData.getRowCount(file_path, "TC02");
		for(int i=1; i<=rc; i++)
		{
			String un = ExcelData.getData(file_path, "TC02", i, 0);
			String pw = ExcelData.getData(file_path, "TC02", i, 1);
			Reporter.log("user name "+un,true);
			lp.EnterUserName(un);
			Reporter.log("Password "+pw,true);
			lp.EnterPassword(pw);
			lp.ClickOnLogin();
			String aerrormsg = lp.verifyErrorMsg();
			String eerrormsg = ExcelData.getData(file_path, "TC02", 1, 2);
			Assert.assertEquals(aerrormsg, eerrormsg);
			Reporter.log("========================================",true);
			Thread.sleep(2000);
			
		}
		
	}

}
