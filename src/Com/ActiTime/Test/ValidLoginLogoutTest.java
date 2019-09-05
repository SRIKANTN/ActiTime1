package Com.ActiTime.Test;

import org.testng.annotations.Test;

import Com.ActiTime.Generic.BaseTest;
import Com.ActiTime.Generic.ExcelData;
import Com.ActiTime.Pages.actiTIMEEnterTimeTrackPage;
import Com.ActiTime.Pages.actiTIMELoginPage;

public class ValidLoginLogoutTest extends BaseTest
{
	@Test(priority=1)
	public void ValidLoginLogout()
	{
		String un = ExcelData.getData(file_path, "TC01", 1, 0);
		String pw = ExcelData.getData(file_path, "TC01", 1, 1);
		String lgtitle = ExcelData.getData(file_path, "TC01", 1, 2);
		String hptitle = ExcelData.getData(file_path, "TC01", 1, 3);
		
		actiTIMELoginPage lp = new actiTIMELoginPage(driver);
		actiTIMEEnterTimeTrackPage ep = new actiTIMEEnterTimeTrackPage(driver);
		//verify login page title
		lp.VerifyTitle(lgtitle);
		// entering user name
		lp.EnterUserName(un);
		//entering password
		lp.EnterPassword(pw);
		//click on login button
		lp.ClickOnLogin();
		//verify home page title
		lp.VerifyTitle(hptitle);
		//click on logout button
		ep.ClickOnLogout();
		// verify login page title
		lp.VerifyTitle(lgtitle);
		
	}

}
