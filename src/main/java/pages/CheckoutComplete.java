package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckoutComplete extends TestBase
{
	@FindBy(xpath="//span[text()='Checkout: Complete!']") private WebElement checkoutCompletePageTitle;
	@FindBy(xpath="//h2[text()='Thank you for your order!']") private WebElement thankYouMsgText;
	@FindBy(xpath="//div[@class='complete-text']") private WebElement orderDispatchedText;
	@FindBy(xpath="//img[@class='pony_express']") private WebElement confirmImg;
	@FindBy(xpath="//button[@class='btn btn_primary btn_small']") private WebElement backHomeBtn;
	
	public CheckoutComplete()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyURLofcheckoutCompletePage()
	{
		return driver.getCurrentUrl();	
	}
	public String verifycheckoutCompletePageTitle()
	{
		return checkoutCompletePageTitle.getText();	
	}
	public String verifythankYouMsgText()
	{
		return thankYouMsgText.getText();	
	}
	public String verifyorderDispatchedText()
	{
		return orderDispatchedText.getText();
	}
	public boolean verifyconfirmImg()
	{
		return confirmImg.isDisplayed();
	}
	public String clickbackHomeBtn()
	{
		backHomeBtn.click();
		return driver.getCurrentUrl();
		
	}
}
