package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pages.LoginPage;
import utility.CaptureScreenShot;
import utility.ReadData;

public class verifyMultipleCredentialsTest extends TestBase
{
	LoginPage login;
	

	@BeforeMethod
	public void setUp()throws Exception
	{
		initialization();
		login=new LoginPage();
	}
	@Test(dataProvider="credentials")
	public void loginToApplicationWithMultipleDataTest(String un,String pass) throws Exception
	{
		//String expURL=ReadData.readExcelLogin(1,2);//(1,2)
		SoftAssert s=new SoftAssert();
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL=login.LoginToApplicationWithMultipleData(un, pass);
		Assert.assertEquals(expURL, actURL);
		s.assertAll();
		Reporter.log("Url after Login "+ actURL);
	}
	@DataProvider(name="credentials")
	public Object[][] getData()
	{
		return new Object[][]
				{
			{"standard_user","secret_sauce"},
			//{"locked_out_user","secret_sauce"},
			{"problem_user","secret_sauce"},
			{"performance_glitch_user","secret_sauce"},
			{"error_user","secret_sauce"},
			{"visual_user","secret_sauce"},
				};
		
	}
	@AfterMethod
	public void closeBrowser(ITestResult it)throws Exception
	{
		if(it.FAILURE==it.getStatus())
		{
			CaptureScreenShot.screenShot(it.getName());
		}
		report.flush();
		driver.close();
		
	}

}