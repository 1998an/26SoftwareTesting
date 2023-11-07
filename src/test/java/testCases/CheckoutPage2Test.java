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
import pages.CartPage;
import pages.CheckoutPage1;
import pages.CheckoutPage2;
import pages.InventoryPage;
import pages.LoginPage;
import utility.CaptureScreenShot;
import utility.ReadData;

public class CheckoutPage2Test extends TestBase
{
	LoginPage login;
	InventoryPage invent;
	CartPage cart;
	CheckoutPage1 check1;
	CheckoutPage2 check2;
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception
	{
		initialization();
		login=new LoginPage();
		invent=new InventoryPage();
		cart=new CartPage();
		check1=new CheckoutPage1();
		check2=new CheckoutPage2();
		login.LoginToApplication();
		invent.add6Product();
		invent.clickCartCount();
		cart.clickCheckOutBtn();
		check1.clickContinueBtn(); //this is check1.inputInfo();
	}
	@Test
	public void verifyUrlofCheckoutPage2Test() throws EncryptedDocumentException, IOException
	{
		String expUrl=ReadData.readExcel_check2(0,0); //https://www.saucedemo.com/checkout-step-t.html
		String actUrl=check2.verifyUrlofCheckoutPage2();
		AssertJUnit.assertEquals(expUrl, actUrl);
		Reporter.log("Url Of checkout page 2="+actUrl);
	}
	@Test
	public void verifycheckOutPage1TitleTest() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExcel_check2(0, 1); //Checkout: Overview
		String actTitle=check2.verifycheckoutPage2Tiitle();
		AssertJUnit.assertEquals(expTitle, actTitle);
		Reporter.log("title of checkout page 2 ="+actTitle);
	}
	@Test
	public void verifypaymentInformationTextTest() throws EncryptedDocumentException, IOException
	{
		String extText=ReadData.readExcel_check2(0, 2); //Payment Information
		String actText=check2.verifypaymentInformationText();
		AssertJUnit.assertEquals(extText, actText);
		Reporter.log("Payment information text ="+actText);
	}
	@Test
	public void verifyshoppingInformationTextTest() throws EncryptedDocumentException, IOException
	{
		String extText=ReadData.readExcel_check2(0, 3);  //Shipping Information
		String actText=check2.verifyshippingInformationText();
		AssertJUnit.assertEquals(extText, actText);
		Reporter.log("Shipping Information text ="+actText);
	}
	@Test
	public void verifypriceTotalTextTest() throws EncryptedDocumentException, IOException
	{
		String extText=ReadData.readExcel_check2(0, 4);  //Price Total
		String actText=check2.verifypriceTotalText();
		AssertJUnit.assertEquals(extText, actText);
		Reporter.log("Price Total text ="+actText);
	}
	@Test
	public void clickfinishBtnTest() throws EncryptedDocumentException, IOException
	{
		String extUrl=ReadData.readExcel_check2(0, 5);  //https://www.saucedemo.com/checkout-complete.html
		String actUrl=check2.clickfinishBtn();
		AssertJUnit.assertEquals(extUrl, actUrl);
		Reporter.log("url after click finish ="+actUrl);
	}
	@Test
	public void clickcancelBtnTest() throws EncryptedDocumentException, IOException
	{
		String extUrl=ReadData.readExcel_check2(0, 6);  //https://www.saucedemo.com/inventory.html
		String actUrl=check2.clickcancelBtn();
		AssertJUnit.assertEquals(extUrl, actUrl);
		Reporter.log("url after click cancel ="+actUrl);
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
