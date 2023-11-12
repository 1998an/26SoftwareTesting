package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBase;
import utility.ReadData;

public class LoginPage extends TestBase
{
	//object repository--we can write our xpath here
	@FindBy(xpath="//input[contains(@name,'user-name')]") private WebElement userNameTextBox;
	@FindBy(xpath="//input[contains(@name,'password')]") private WebElement passwordTextBox;
	@FindBy(xpath="//input[contains(@name,'login-button')]") private WebElement loginBtn;
	//constructor to initialize the web element(current class)
	public LoginPage()
	{
		PageFactory.initElements(driver, this);//this referes current class object 
	}
	//method login in application
	public String LoginToApplication() throws IOException
	{
		logger=report.createTest("Login to sause lab application");
		userNameTextBox.sendKeys(ReadData.readPropertyFile("UserName"));//from config.properties
		logger.log(Status.INFO, "UserName is entered");
		passwordTextBox.sendKeys(ReadData.readPropertyFile("PassWord"));
		logger.log(Status.INFO, "Password is entered");
		loginBtn.click();
		logger.log(Status.PASS, "Login is Successfull");
		return driver.getCurrentUrl();
	}
	public String verifyTitleOfApplication()
	{
		return driver.getTitle();	
	}
	public String verifyURLofApplication()
	{
		return driver.getCurrentUrl();	
	}
}
