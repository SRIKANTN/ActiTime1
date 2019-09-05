package Com.ActiTime.Generic;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData 
{
	public static String getData(String filePath, String sheetname, int rn, int cn)
	{
		try 
		{
			FileInputStream file = new FileInputStream(new File(filePath));
			String data = WorkbookFactory.create(file).getSheet(sheetname).getRow(rn).getCell(cn).toString();
			return data;
		}
		catch (Exception e) 
		{
			return "";
		}
	}
	
	public static int getRowCount(String filePath,String sheetName) 
	{
		try 
		{
			FileInputStream file = new FileInputStream(new File(filePath));
			int rc = WorkbookFactory.create(file).getSheet(sheetName).getLastRowNum();
			return rc;
		} 
		catch (Exception e)
		{
			return 0;
		}
	}
	
	public static int getCellCount(String filePath,String sheetName, int rn)
	{
		try 
		{
			FileInputStream file = new FileInputStream(new File(filePath));
			int cc = WorkbookFactory.create(file).getSheet(sheetName).getRow(rn).getLastCellNum();
			return cc;
		}
		catch (Exception e) 
		{
			return 0;
		}
	}
}
