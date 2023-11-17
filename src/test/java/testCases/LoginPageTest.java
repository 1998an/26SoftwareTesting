package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import utility.CaptureScreenShot;
import utility.ReadData;

public class LoginPageTest extends TestBase
{
	LoginPage login;  //instance variable decleration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
	
	@BeforeMethod(alwaysRun = true)
	public void setup() throws Exception
	{
		initialization();
	    login=new LoginPage();	
	}
	@Test(enabled = true)
	public void verifyURLofApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel_login(0,0);  //https://www.saucedemo.com/
		String actURL=login.verifyURLofApplication();
		Assert.assertEquals(expURL, actURL);
	}
	@Test(enabled = true)
	public void verifyTitleOfApplication() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExcel_login(0,1);  //Swag Labs(0,1)
		String actTitle=login.verifyTitleOfApplication();
		Assert.assertEquals(expTitle, actTitle);
	}
	@Test(enabled = true)
	public void LoginToApplicationTest() throws IOException
	{
		String expURL=ReadData.readExcel_login(0, 2);  //https://www.saucedemo.com/inventory.html
		String actURL=login.LoginToApplication();
		Assert.assertEquals(expURL, actURL);
	}
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE == it.getStatus())
		{
			CaptureScreenShot.screenShot(it.getName());
		}
		report.flush();  //erase any previous data on a releavent report and create a whole ew report
		driver.close();
	}
}
