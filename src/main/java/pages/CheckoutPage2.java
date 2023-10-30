package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckoutPage2 extends TestBase
{
	@FindBy(xpath="//span[text()='Checkout: Overview']") private WebElement checkoutPage2Tiitle;
	@FindBy(xpath="//div[text()='Payment Information']") private WebElement paymentInformationText;
	@FindBy(xpath="//div[text()='Shipping Information']") private WebElement shippingInformationText;
	@FindBy(xpath="//div[text()='Price Total']") private WebElement priceTotalText;
	@FindBy(xpath="//div[@class='summary_info_label summary_total_label']") private WebElement totalText;
	@FindBy(xpath="//button[@id='cancel']") private WebElement cancelBtn;
	@FindBy(xpath="//button[@id='finish']") private WebElement finishBtn;
	public CheckoutPage2()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyUrlofCheckoutPage2()
	{
		return driver.getCurrentUrl();	
	}
	public String verifycheckoutPage2Tiitle()
	{
		return checkoutPage2Tiitle.getText();	
	}
	public String verifypaymentInformationText()
	{
		return paymentInformationText.getText();
	}
	public String verifyshippingInformationText()
	{
		return shippingInformationText.getText();
	}
	public String verifypriceTotalText()
	{
		return priceTotalText.getText();
	}
	public String clickfinishBtn()
	{
		finishBtn.click();
		return driver.getCurrentUrl();
	}
	public String clickcancelBtn()
	{
		cancelBtn.click();
		return driver.getCurrentUrl();
		
	}
}
