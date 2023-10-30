package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData 
{
	public static String readPropertyFile(String value) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream("C:\\Users\\ankit\\eclipse-workspace\\SeleniumFramework26\\TestData\\Config.Properties");//config.properties location
		prop.load(file);//load the file
		return prop.getProperty(value);	  //fileinputstream read the file
	}
	//for login page
	public static String readExcel_login(int rowNum,int colNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\ankit\\eclipse-workspace\\SeleniumFramework26\\TestData\\Book1.xlsx");
		Sheet excel = WorkbookFactory.create(file).getSheet("Sheet1");
		String value = excel.getRow(rowNum).getCell(colNum).getStringCellValue();
		return value;
		
	}
	//for inventory page
	public static String readExcel_inventory(int rowNum,int colNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\ankit\\eclipse-workspace\\SeleniumFramework26\\TestData\\Book1.xlsx");
		Sheet excel = WorkbookFactory.create(file).getSheet("Sheet2");
		String value = excel.getRow(rowNum).getCell(colNum).getStringCellValue();
		return value;	
	}
	//for cart page
	public static String readExce_cart(int rowNum,int colNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\ankit\\eclipse-workspace\\SeleniumFramework26\\TestData\\Book1.xlsx");
		Sheet excel = WorkbookFactory.create(file).getSheet("Sheet3");
		String value = excel.getRow(rowNum).getCell(colNum).getStringCellValue();
		return value;	
	}
	//for checkout 1 page
	public static String readExcel_check1(int rowNum,int colNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\ankit\\eclipse-workspace\\SeleniumFramework26\\TestData\\Book1.xlsx");
		Sheet excel = WorkbookFactory.create(file).getSheet("Sheet4");
		String value = excel.getRow(rowNum).getCell(colNum).getStringCellValue();
		return value;	
	}
	//for checkout 2 page
	public static String readExcel_check2(int rowNum,int colNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\ankit\\eclipse-workspace\\SeleniumFramework26\\TestData\\Book1.xlsx");
		Sheet excel = WorkbookFactory.create(file).getSheet("Sheet5");
		String value = excel.getRow(rowNum).getCell(colNum).getStringCellValue();
		return value;	
	}
	//for checkout complete page
	public static String readExcel_checkcom(int rowNum,int colNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\ankit\\eclipse-workspace\\SeleniumFramework26\\TestData\\Book1.xlsx");
		Sheet excel = WorkbookFactory.create(file).getSheet("Sheet6");
		String value = excel.getRow(rowNum).getCell(colNum).getStringCellValue();
		return value;	
	}	
}
