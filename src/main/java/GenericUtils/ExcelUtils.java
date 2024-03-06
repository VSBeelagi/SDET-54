package GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtils {

	/**
	 * This method is used to read data from excel
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcelFile(String sheetName, int row, int cell) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		String value = wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		
		return value;
	}
	
	/**
	 * This method is used to get Last row count
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	
	public int getLastRowNo(String sheetName) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		
		return rowCount;
	}

	/**
	 * This method is used to write data into excel
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @param value
	 * @throws Throwable
	 */

	public void writeDataIntoExcel(String sheetName, int row, int cell, String value) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		wb.getSheet(sheetName).getRow(row).createCell(cell).setCellValue(value);
		
		FileOutputStream fout = new FileOutputStream(IpathConstants.ExcelPath);
		wb.write(fout);
		wb.close();
	}
	
	/**
	 * This method is used to read data from excel by using Hashmap
	 * @author Vijayalaxmi
	 * @param sheetName
	 * @param cell
	 * @param driver
	 * @return
	 * @throws Throwable
	 */
	public HashMap<String,String> readMultipleData(String sheetName, int cell) throws Throwable
	{
	
		FileInputStream fi = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		
		HashMap<String, String> map = new HashMap<String, String>();     //empty
		
		for(int i=0; i<=rowCount; i++)
		{
			String key = sh.getRow(i).getCell(cell).getStringCellValue();
			String value = sh.getRow(i).getCell(cell+1).getStringCellValue();
			
			map.put(key, value);
		}
		
		return map;
		
	}
	
	
	public Object[][] dataProvider(String sheetName) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum()+1;
		int lastCell = sh.getRow(0).getLastCellNum();
		
		
		Object[][] obj = new Object[lastRow][lastCell];
		
		for(int i=0; i<lastRow; i++)
		{
			for (int j = 0; j < lastCell; j++) 
			{
				obj [i][j] = sh.getRow(i).getCell(j).getStringCellValue();
				
			}
		}
		return obj;
	}
	
	
	
	
	
	

}






