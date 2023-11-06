package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import base.TestBase;
import pages.InventoryPage;
import pages.LoginPage;
import utility.CaptureScreenShot;
import utility.ReadData;

public class InventoryPageTest extends TestBase
{
	LoginPage login;
	InventoryPage invent;
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
		invent=new InventoryPage();
		login.LoginToApplication();
	} 
	@Test(enabled = true,priority = 0,groups= {"retest","sanity"})
	public void verifyinventoryPageUrlTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel_inventory(0,3);  //https://www.saucedemo.com/inventory.html
		String actURL=invent.verifyinventoryPageUrl();
		AssertJUnit.assertEquals(expURL, actURL);
		Reporter.log("url of inventory page"+actURL);
	}
	@Test(enabled = true,priority = 3,dependsOnMethods = "verifyinventoryPageUrlTest",groups= {"retest","sanity"})
	public void verifyProductLableTest() throws EncryptedDocumentException, IOException
	{
		String expLable=ReadData.readExcel_inventory(0,0);  //Products(0,0)
		String actLable=invent.verifyProductLable();
		AssertJUnit.assertEquals(expLable, actLable);
		Reporter.log("Application Lable =" +actLable);
	}
	@Test(enabled = false,priority = 4,dependsOnMethods = "verifyinventoryPageUrlTest",groups= {"retest","sanity"})
	public void verifyTwitterLogoTest()
	{
		boolean result=invent.verifyTwitterLogo();
		AssertJUnit.assertEquals(result, true);
		Reporter.log("Visibility of Twitter LOgo =" +result);
	}
	@Test(enabled = true,priority = 5,dependsOnMethods = "verifyinventoryPageUrlTest",groups= {"retest","sanity"})
	public void verifyfacebookLogoTest()
	{
		boolean result=invent.verifyfacebookLogo();
		AssertJUnit.assertEquals(result,true);
		Reporter.log("Visibility of Facebook logo =" +result);
	}
	@Test(enabled = true,priority = 6,dependsOnMethods = "verifyinventoryPageUrlTest",groups = {"sanity","regression"})
	public void verifylinkedInLogoTest()
	{
		boolean result=invent.verifylinkedInLogo();
		AssertJUnit.assertEquals(result,true);
		Reporter.log("Visibility of linkedin logo =" +result);
	}
	@Test(enabled = false,priority = 7,dependsOnMethods = "verifyinventoryPageUrlTest",groups = {"sanity","regression"})
	public void verifyAppLogoTest()
	{
		boolean result = invent.verifyAppLogo();
		AssertJUnit.assertEquals(result, true);
		Reporter.log("Visiability of app logo ="+result);
	}
	@Test(enabled = true,priority = 8,dependsOnMethods = "verifyinventoryPageUrlTest",groups = {"sanity","regression"})
	public void verifyAddToCartBtn1Test()
	{
		 invent.verifyAddToCartBtn1();
	}
	@Test(enabled = false,priority = 9,dependsOnMethods = "verifyinventoryPageUrlTest",groups = {"sanity","regression"})
	public void verifyAddToCartBtn2Test()
	{
		invent.verifyAddToCartBtn2();
	}
	@Test(enabled = false,priority = 10,dependsOnMethods = "verifyinventoryPageUrlTest",groups = {"sanity","regression"})
	public void verifyAddToCartBtn3Test()
	{
		invent.verifyAddToCartBtn3();	
	}
	@Test(enabled = false,priority = 11,dependsOnMethods = "verifyinventoryPageUrlTest",groups = {"sanity","regression"})
	public void verifyAddToCartBtn4Test()
	{
		invent.verifyAddToCartBtn4();	
	}
	@Test(enabled = false,priority = 12,dependsOnMethods = "verifyinventoryPageUrlTest",groups = {"sanity","regression"})
	public void verifyAddToCartBtn5Test()
	{
		invent.verifyAddToCartBtn5();
	}
	@Test(enabled = false,priority = 13,dependsOnMethods = "verifyinventoryPageUrlTest",groups = {"sanity"})
	public void verifyAddToCartBtn6Test()
	{
		invent.verifyAddToCartBtn6();
	}
	@Test(enabled = false,priority = 14,dependsOnMethods = "verifyinventoryPageUrlTest",groups = {"sanity"})
	public void verifyProductSortBtnTest()
	{
		invent.verifyProductSortBtn();
	}
	@Test(enabled = true,priority = 15,dependsOnMethods = "verifyinventoryPageUrlTest",groups = {"sanity"})
	public void vedrifyProductCartLinkTest()
	{
		invent.vedrifyProductCartLink();
	}
	@Test(enabled = true,priority = 16,dependsOnMethods = "verifyinventoryPageUrlTest",groups = {"sanity"})
	public void verifyFooterTest()
	{
		invent.verifyFooter();
	}
	@Test(enabled = true,priority = 17,dependsOnMethods = "verifyinventoryPageUrlTest",groups = {"sanity"})
	public void burgerMenuBtnTest()
	{
		invent.burgerMenuBtn();
	}
	//use for add and count in shopping cart
	@Test(enabled = true,priority = 18,dependsOnMethods = "verifyinventoryPageUrlTest",groups = {"sanity"})
	public void add6ProductTest() throws EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExcel_inventory(0,1);  //6
		String actCount=invent.add6Product();
		AssertJUnit.assertEquals(expCount, actCount);
		Reporter.log("Total Product added in Shopping Cart= "+actCount);
	}
	//use for remove and count in shopping cart
	@Test(enabled = true,priority = 2,dependsOnMethods = "verifyinventoryPageUrlTest",groups = {"sanity"})
	public void remove2ProductTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExcel_inventory(0,2);  //4
		String actCount=invent.remove2Product();
		AssertJUnit.assertEquals(expCount, actCount);
		Reporter.log("Total count in cart after removing 2 product ="+actCount);
	}
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE == it.getStatus())
		{
			CaptureScreenShot.screenShot(it.getName());
		}
		driver.close();
	}
		
}
	
