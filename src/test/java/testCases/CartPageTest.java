package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import base.TestBase;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import utility.CaptureScreenShot;
import utility.ReadData;

public class CartPageTest extends TestBase
{
	LoginPage login;
	InventoryPage invent;
	CartPage cart;
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
		invent=new InventoryPage();
		cart=new CartPage();
		login.LoginToApplication();
		invent.add6Product();
		invent.clickCartCount();
	}    
	@Test(enabled = true,priority = 0,groups = {"sanity"})
	public void verifyURLofCartPageTest() throws EncryptedDocumentException, IOException
	{
		String expUrl=ReadData.readExce_cart(0,0); //https://www.saucedemo.com/cart.html
		String actUrl=cart.verifyURLofCartpage();
		AssertJUnit.assertEquals(expUrl, actUrl);
		Reporter.log("URL of cart page ="+actUrl);
	}
	@Test(enabled = true,priority = 1,dependsOnMethods = "verifyURLofCartPageTest",groups = {"sanity"})
	public void verifytitleOfCartPageTest() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExce_cart(0,1); //Your Cart
		String actTitle=cart.verifytitleOfCartPage();
		AssertJUnit.assertEquals(expTitle, actTitle);
		Reporter.log("Title of cart page ="+actTitle);
	}
	@Test(enabled = false,priority = 2,dependsOnMethods = "verifyURLofCartPageTest",groups = {"sanity"})
	public void verifyQtyTextTest() throws EncryptedDocumentException, IOException
	{
		String expText=ReadData.readExce_cart(0,2); //QTY
		String actText=cart.verifyQtyText();
		AssertJUnit.assertEquals(expText, actText);
		Reporter.log("Text of qty ="+actText);
	}
	@Test(enabled = false,priority = 3,dependsOnMethods = "verifyURLofCartPageTest",groups = {"sanity","regression"})
	public void verifyDescriptionTextTest() throws EncryptedDocumentException, IOException
	{
		String expText=ReadData.readExce_cart(0,3); //Description
		String actText=cart.verifyDescriptionText();
		AssertJUnit.assertEquals(expText, actText);
		Reporter.log("Text of Description ="+actText);
	}
	@Test(enabled = true,priority = 4,dependsOnMethods = "verifyURLofCartPageTest",groups = {"sanity","regression"})
	public void clickCheckOutBtnTest() throws EncryptedDocumentException, IOException
	{
		String expURl=ReadData.readExce_cart(0,4); //https://www.saucedemo.com/checkout-step-one.html
		String actUrl=cart.clickCheckOutBtn();
		AssertJUnit.assertEquals(expURl, actUrl);
		Reporter.log("Url after click on checkout button="+actUrl);
	}
	@Test(enabled = true,priority = 5,dependsOnMethods = "verifyURLofCartPageTest",groups = {"sanity","regression"})
	public void clickContinueShoppingBtnTest() throws EncryptedDocumentException, IOException
	{
		String expURl=ReadData.readExce_cart(0,5); //https://www.saucedemo.com/inventory.html
		String actUrl=cart.clickContinueShoppingBtn();
		AssertJUnit.assertEquals(expURl, actUrl);
		Reporter.log("Url after click on continue shopping button="+actUrl);
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
