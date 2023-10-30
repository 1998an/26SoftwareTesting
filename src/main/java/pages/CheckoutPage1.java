package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckoutPage1 extends TestBase
{
//object repository
	@FindBy(xpath="//span[text()='Checkout: Your Information']") private WebElement checkOutPage1Title;
	@FindBy(xpath="//input[@id='first-name']") private WebElement firstNameTextBox;
	@FindBy(xpath="//input[@id='last-name']") private WebElement lastNameTextBox;
	@FindBy(xpath="//input[@id='postal-code']") private WebElement postalCodeTextBox;
	@FindBy(xpath="//input[@id='continue']") private WebElement continueBtn;
	@FindBy(xpath="//button[@id='cancel']") private WebElement cancelBtn;
	//constructor
	public CheckoutPage1()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyUrlOfCheckoutPage1()
	{
		return driver.getCurrentUrl();
	}
	public String verifycheckOutPage1Title()
	{
		return checkOutPage1Title.getText();	
	}
	public void verifyFirstNameTextBox()
	{
		firstNameTextBox.isEnabled();
	}
	public void verifyLastNameTextBox()
	{
		lastNameTextBox.isEnabled();
	}
	public void verifyPostalCodeTextBox()
	{
		postalCodeTextBox.isEnabled();
	}
	public String clickContinueBtn()
	{
		firstNameTextBox.sendKeys("Harry");
		lastNameTextBox.sendKeys("Potter");
		postalCodeTextBox.sendKeys("410501");
		continueBtn.click();
		return driver.getCurrentUrl();
	}
	public String clickCancelBtn()
	{
		cancelBtn.click();
		return driver.getCurrentUrl();
	}
}
