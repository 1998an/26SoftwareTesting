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
	public void setUp() throws Exception
	{
		initialization();
		login=new LoginPage();
		invent=new InventoryPage();
		login.LoginToApplication();
	} 
	@Test
	public void verifyinventoryPageUrlTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel_inventory(0,3);  //https://www.saucedemo.com/inventory.html
		String actURL=invent.verifyinventoryPageUrl();
		AssertJUnit.assertEquals(expURL, actURL);
		Reporter.log("url of inventory page"+actURL);
	}
	@Test
	public void verifyProductLableTest() throws EncryptedDocumentException, IOException
	{
		String expLable=ReadData.readExcel_inventory(0,0);  //Products(0,0)
		String actLable=invent.verifyProductLable();
		AssertJUnit.assertEquals(expLable, actLable);
		Reporter.log("Application Lable =" +actLable);
	}
	@Test
	public void verifyTwitterLogoTest()
	{
		boolean result=invent.verifyTwitterLogo();
		AssertJUnit.assertEquals(result, true);
		Reporter.log("Visibility of Twitter LOgo =" +result);
	}
	@Test
	public void verifyfacebookLogoTest()
	{
		boolean result=invent.verifyfacebookLogo();
		AssertJUnit.assertEquals(result,true);
		Reporter.log("Visibility of Facebook logo =" +result);
	}
	@Test
	public void verifylinkedInLogoTest()
	{
		boolean result=invent.verifylinkedInLogo();
		AssertJUnit.assertEquals(result,true);
		Reporter.log("Visibility of linkedin logo =" +result);
	}
	@Test
	public void verifyAppLogoTest()
	{
		boolean result = invent.verifyAppLogo();
		AssertJUnit.assertEquals(result, true);
		Reporter.log("Visiability of app logo ="+result);
	}
	@Test
	public void verifyAddToCartBtn1Test()
	{
		 invent.verifyAddToCartBtn1();
	}
	@Test
	public void verifyAddToCartBtn2Test()
	{
		invent.verifyAddToCartBtn2();
	}
	@Test
	public void verifyAddToCartBtn3Test()
	{
		invent.verifyAddToCartBtn3();	
	}
	@Test
	public void verifyAddToCartBtn4Test()
	{
		invent.verifyAddToCartBtn4();	
	}
	@Test
	public void verifyAddToCartBtn5Test()
	{
		invent.verifyAddToCartBtn5();
	}
	@Test
	public void verifyAddToCartBtn6Test()
	{
		invent.verifyAddToCartBtn6();
	}
	@Test
	public void verifyProductSortBtnTest()
	{
		invent.verifyProductSortBtn();
	}
	@Test
	public void vedrifyProductCartLinkTest()
	{
		invent.vedrifyProductCartLink();
	}
	@Test
	public void verifyFooterTest()
	{
		invent.verifyFooter();
	}
	@Test
	public void burgerMenuBtnTest()
	{
		invent.burgerMenuBtn();
	}
	//use for add and count in shopping cart
	@Test
	public void add6ProductTest() throws EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExcel_inventory(0,1);  //6
		String actCount=invent.add6Product();
		AssertJUnit.assertEquals(expCount, actCount);
		Reporter.log("Total Product added in Shopping Cart= "+actCount);
	}
	//use for remove and count in shopping cart
	@Test
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
	
