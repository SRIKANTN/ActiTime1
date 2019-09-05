package Com.ActiTime.Generic;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GenericUtlis 
{
	/***
	 * @author APM-SYSTEM
	 * @param driver
	 * @param name
	 */
	public static void getScreenShot(WebDriver driver,String name)
	{
		TakesScreenshot ts =(TakesScreenshot) driver;
		File src =ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShot/"+name+".png");
		try 
		{
			FileUtils.copyFile(src, dest);
		} 
		catch (IOException e)
		{
			
		}
	}
	
	public static void selectByIndexs(WebElement element,int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	public static void selectByvalues(WebElement element,String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	public static void selectByVisibleText(WebElement element,String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public static void JavaScriptAlertPopup(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}

	public static void JavaScriptConfirmationPopup(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public static void JavaScriptPromptPopup(WebDriver driver,String text)
	{
		Alert a = driver.switchTo().alert();
		a.sendKeys(text);
		a.accept();
	}
	public static void FileUploadPopup(String filePath)
	{
		StringSelection file = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);
		
		try 
		{
			Robot r = new Robot();
			int control = KeyEvent.VK_CONTROL;
			int v = KeyEvent.VK_V;
			int enter = KeyEvent.VK_ENTER;
			r.keyPress(control);
			r.keyPress(v);
			Thread.sleep(1000);
			r.keyRelease(v);
			r.keyRelease(control);
			Thread.sleep(3000);
			r.keyPress(enter);
			Thread.sleep(1000);
			r.keyRelease(enter);
		}
		catch (Exception e) 
		{
		}
	}
	
	public static void WindowPopup(String filePath)
	{
		try {
			Runtime.getRuntime().exec(filePath);
		} catch (IOException e) {
		}
	}
}
