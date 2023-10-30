package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.TestBase;
import utility.HandleDropdown;

public class InventoryPage extends TestBase
{
	//object repository--we can write our xpath here
	@FindBy(xpath="//span[@class='title']") private WebElement productTitleText;
	@FindBy(xpath="//a[text()='Twitter']") private WebElement twitterLogo;
	@FindBy(xpath="//a[text()='Facebook']") private WebElement facebookLogo;
	@FindBy(xpath="//a[text()='LinkedIn']") private WebElement linkedInLogo;
	@FindBy(xpath="//div[text()='Swag Labs']") private WebElement swagLabsTitleText;
	@FindBy(xpath="//div[text()='Swag Labs']") private WebElement swagLabsAppLogo;
	@FindBy(xpath="(//button[text()='Add to cart'])[1]") private WebElement addToCartBtn1;
	@FindBy(xpath="(//button[text()='Add to cart'])[2]") private WebElement addToCartBtn2;
	@FindBy(xpath="(//button[text()='Add to cart'])[3]") private WebElement addToCartBtn3;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement addToCartBtn4;
	@FindBy(xpath="(//button[text()='Add to cart'])[5]") private WebElement addToCartBtn5;
	@FindBy(xpath="(//button[text()='Add to cart'])[6]") private WebElement addToCartBtn6;
	@FindBy(xpath="//select[@class='product_sort_container']") private WebElement productSortBtn;
	@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement productCartlink;
	@FindBy(xpath="//div[@class='footer_copy']") private WebElement footer;
	@FindBy(xpath="//button[@id='react-burger-menu-btn']") private WebElement burgerMenuBtn;
	//use for count in shopping cart
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement backPackProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement bikeLightProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement boltTshirtProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement fleeceJacketProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement oneSideProduct;
	@FindBy(xpath="//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement redTshirtProduct;
	@FindBy(xpath="//select[@class='product_sort_container']") private WebElement productSortDropDown;
	@FindBy(xpath="//span[@class='shopping_cart_badge']") private WebElement CartCount;
	//remove product from cart
	@FindBy(xpath="//button[@id='remove-sauce-labs-backpack']") private WebElement removeBackPackProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bike-light']") private WebElement removebikeLightProduct;
	public InventoryPage()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyinventoryPageUrl()
	{
		return driver.getCurrentUrl();
		
	}
	public String verifyProductLable()   // string for text
	{
		return productTitleText.getText();
	}
	public boolean verifyTwitterLogo()
	{
		return twitterLogo.isDisplayed();	
	}
	public boolean verifyfacebookLogo()  //boolean for logo img
	{
		return facebookLogo.isDisplayed();	
	}
	public boolean verifylinkedInLogo()
	{
		return linkedInLogo.isDisplayed();	
	}
	public String verifySwagLabLableText()
	{
		return swagLabsTitleText.getText();
	}
	public boolean verifyAppLogo()
	{
		return swagLabsAppLogo.isDisplayed();	
	}
	public void verifyAddToCartBtn1()
	{
		addToCartBtn1.click();
	}
	public void verifyAddToCartBtn2()
	{
		addToCartBtn2.click();
	}
	public void verifyAddToCartBtn3()
	{
		addToCartBtn3.click();
	}
	public void verifyAddToCartBtn4()
	{
		addToCartBtn4.click();
	}
	public void verifyAddToCartBtn5()
	{
		 addToCartBtn5.click();
	}
	public void verifyAddToCartBtn6()
	{
		addToCartBtn6.click();
	}
	public void verifyProductSortBtn()
	{
		productSortBtn.click();
	}
	public void vedrifyProductCartLink()
	{
		productCartlink.click();	
	}
	public void verifyFooter()
	{
		footer.click();
	}
	public void  burgerMenuBtn()
	{
		burgerMenuBtn.click();
	}
	//use for count in shopping cart
	public String add6Product()
	{
		HandleDropdown.handleSelectClass(productSortDropDown, "Price (low to high)");  //from HandleDropdown for select class
		backPackProduct.click();
		bikeLightProduct.click();
		boltTshirtProduct.click();
		fleeceJacketProduct.click();
		oneSideProduct.click();
		redTshirtProduct.click();
		return CartCount.getText();	
	}
	public String remove2Product() throws InterruptedException
	{
		add6Product();
		removeBackPackProduct.click();
		removebikeLightProduct.click();
		Thread.sleep(4000);
		return CartCount.getText();
	}
	public void clickCartCount()
	{
		CartCount.click();
	}
}
