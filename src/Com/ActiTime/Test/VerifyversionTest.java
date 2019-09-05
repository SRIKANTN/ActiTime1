package Com.ActiTime.Test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Com.ActiTime.Generic.BaseTest;
import Com.ActiTime.Generic.ExcelData;
import Com.ActiTime.Pages.actiTIMELoginPage;

public class VerifyversionTest extends BaseTest
{
	@Test(priority=3)
	public void Verifyversion()
	{
		String title = ExcelData.getData(file_path, "TC01", 1, 2);
		actiTIMELoginPage lp = new actiTIMELoginPage(driver);
		lp.VerifyTitle(title);
		String aversion = lp.verifyVersion();
		String eversion = ExcelData.getData(file_path, "TC03", 1, 0);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(aversion, eversion);
		sa.assertAll();
				
	}

}
