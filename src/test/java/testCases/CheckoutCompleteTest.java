package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.ITestResult;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import base.TestBase;
import pages.CartPage;
import pages.CheckoutComplete;
import pages.CheckoutPage1;
import pages.CheckoutPage2;
import pages.InventoryPage;
import pages.LoginPage;
import utility.CaptureScreenShot;
import utility.ReadData;

public class CheckoutCompleteTest extends TestBase
{
	LoginPage login;
	InventoryPage invent;
	CartPage cart;
	CheckoutPage1 check1;
	CheckoutPage2 check2;
	CheckoutComplete checkcom;
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception
	{
		initialization();
		login=new LoginPage();
		invent=new InventoryPage();
		cart=new CartPage();
		check1=new CheckoutPage1();
		check2=new CheckoutPage2();
		checkcom=new CheckoutComplete();
		login.LoginToApplication();
		invent.add6Product();
		invent.clickCartCount();
		cart.clickCheckOutBtn();
		check1.clickContinueBtn();
		check2.clickfinishBtn();
	}
	@Test
	public void verifyURLofcheckoutCompletePageTest() throws EncryptedDocumentException, IOException
	{
		String extUrl=ReadData.readExcel_checkcom(0, 0);  //https://www.saucedemo.com/checkout-complete.html
		String actUrl=checkcom.verifyURLofcheckoutCompletePage();
		AssertJUnit.assertEquals(extUrl, actUrl);
		Reporter.log("url after click finish ="+actUrl);
	}
	@Test
	public void verifycheckoutCompletePageTitle() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExcel_checkcom(0,1); //Checkout: Complete!
		String actTitle=checkcom.verifycheckoutCompletePageTitle();
		AssertJUnit.assertEquals(expTitle, actTitle);
		Reporter.log("title of checkout complete ="+actTitle);
	}
	@Test
	public void verifythankYouMsgTextTest() throws EncryptedDocumentException, IOException
	{
		String extText=ReadData.readExcel_checkcom(0, 2);  //Thank you for your order!
		String actText=checkcom.verifythankYouMsgText();
		AssertJUnit.assertEquals(extText, actText);
		Reporter.log("Thank You msg text ="+actText);
	}
	@Test
	public void verifyorderDispatchedTextTest() throws EncryptedDocumentException, IOException
	{
		String extText=ReadData.readExcel_checkcom(0, 3);  //order place text
		String actText=checkcom.verifyorderDispatchedText();
		AssertJUnit.assertEquals(extText, actText);
		Reporter.log("Order dispatched msg text ="+actText);
	}
	@Test
	public void verifyconfirmImgTest()
	{
		boolean result = checkcom.verifyconfirmImg();
		AssertJUnit.assertEquals(result, true);
		Reporter.log("Visiability of confirm Image ="+result);
	}
	@Test
	public void clickbackHomeBtnTest() throws EncryptedDocumentException, IOException
	{
		String extUrl=ReadData.readExcel_checkcom(0, 4);  //https://www.saucedemo.com/inventory.html
		String actUrl=checkcom.clickbackHomeBtn();
		AssertJUnit.assertEquals(extUrl, actUrl);
		Reporter.log("url after click back to home ="+actUrl);
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
