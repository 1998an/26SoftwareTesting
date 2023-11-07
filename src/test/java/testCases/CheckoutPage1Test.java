package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.ITestResult;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import base.TestBase;
import pages.CartPage;
import pages.CheckoutPage1;
import pages.InventoryPage;
import pages.LoginPage;
import utility.CaptureScreenShot;
import utility.ReadData;

public class CheckoutPage1Test extends TestBase
{
	LoginPage login;
	InventoryPage invent;
	CartPage cart;
	CheckoutPage1 check1;
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception
	{
		initialization();
		login=new LoginPage();
		invent=new InventoryPage();
		cart=new CartPage();
		check1=new CheckoutPage1();
		login.LoginToApplication();
		invent.add6Product();
		invent.clickCartCount();
		cart.clickCheckOutBtn();
	}    
	@Test
	public void verifyUrlOfCheckOutPage1() throws EncryptedDocumentException, IOException
	{
		String expUrl=ReadData.readExcel_check1(0,0); //https://www.saucedemo.com/checkout-step-one.html
		String actUrl=check1.verifyUrlOfCheckoutPage1();
		AssertJUnit.assertEquals(expUrl, actUrl);
		Reporter.log("Url Of checkout page 1="+actUrl);
	}
	@Test
	public void verifycheckOutPage1TitleTest() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExcel_check1(0, 1); //Checkout: Your Information
		String actTitle=check1.verifycheckOutPage1Title();
		AssertJUnit.assertEquals(expTitle, actTitle);
		Reporter.log("title of checkout page 1  ="+actTitle);
	}
	@Test
	public void verifyFirstNameTextBoxTest()
	{
		check1.verifyFirstNameTextBox();
	}
	@Test
	public void verifyLastNameTextBoxTest()
	{
		check1.verifyLastNameTextBox();;
	}
	@Test
	public void verifyPostalCodeTextBoxTest()
	{
		check1.verifyPostalCodeTextBox();
	}
	@Test
	public void clickContinueBtnTest() throws EncryptedDocumentException, IOException
	{
		String expUrl=ReadData.readExcel_check1(0, 2); //https://www.saucedemo.com/checkout-step-two.html
		String actUrl=check1.clickContinueBtn();
		AssertJUnit.assertEquals(expUrl, actUrl);
		Reporter.log("Url of checkout page 2="+actUrl);
	}
	@Test
	public void clickCancelBtnTest() throws EncryptedDocumentException, IOException
	{
		String expUrl=ReadData.readExcel_check1(0,3); //https://www.saucedemo.com/cart.html
		String actUrl=check1.clickCancelBtn();
		AssertJUnit.assertEquals(expUrl, actUrl);
		Reporter.log("url after cancel="+actUrl);
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
