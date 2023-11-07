package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pages.LoginPage;
import utility.CaptureScreenShot;

public class VerifyMultipleCredentialsTest extends TestBase
{
	LoginPage login;
	@BeforeMethod
	public void setUp() throws Exception
	{
		initialization();
	    login=new LoginPage();	
	}
	@Test(dataProvider= "credentials")
	public void LoginToApplicationWithMultipleDataTest(String un,String pass) throws IOException
	{
		SoftAssert s=new SoftAssert();
		String expURL="https://www.saucedemo.com/inventory.html";  
		String actURL=login.LoginToApplicationWithMultipleData(un, pass);
		AssertJUnit.assertEquals(expURL, actURL);
		s.assertAll();
	}
	@DataProvider(name="credentials")
	public Object[][] getData()//[][] becoz we have username and password so to store value
	{
		return new Object[][]
				{
			    {"standard_user","secret_sauce"},
		     	{"problem_user","secret_sauce"},
		     	{"performance_glitch_user","secret_sauce"},
		     	{"error_user","secret_sauce"},
		     	{"visual_user","secret_sauce"}
				};	
	}
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE == it.getStatus())
		{
			CaptureScreenShot.screenShot(it.getName());
		}
		report.flush();
		driver.close();
	}
}
