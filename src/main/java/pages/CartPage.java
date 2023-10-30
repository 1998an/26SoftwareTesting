package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CartPage extends TestBase
{
	//object repository
	@FindBy(xpath="//span[text()='Your Cart']") private WebElement titleOfCartPage;
	@FindBy(xpath="//div[text()='QTY']") private WebElement qtyText;
	@FindBy(xpath="//div[text()='Description']") private WebElement descriptionText;
	@FindBy(xpath="//button[text()='Checkout']") private WebElement checkOutBtn;
	@FindBy(xpath="//button[@class='btn btn_secondary back btn_medium']") private WebElement continueShoppingBtn;
	//constructor
	public CartPage()
	{
		PageFactory.initElements(driver,this);
	}
	public String verifyURLofCartpage()
	{
		return driver.getCurrentUrl();	
	}
	public String verifytitleOfCartPage()
	{
		return titleOfCartPage.getText();
	}
	public String verifyQtyText()
	{
		return qtyText.getText();
	}
	public String verifyDescriptionText()
	{
		return descriptionText.getText();	
	}
	public String clickCheckOutBtn()
	{
		checkOutBtn.click();
		return driver.getCurrentUrl();
	}
	public String clickContinueShoppingBtn()
	{
		continueShoppingBtn.click();
		return driver.getCurrentUrl();
	}
}
