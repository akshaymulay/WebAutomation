package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CartPage extends TestBase {
	
	//object
	@FindBy(xpath="//button[@id='continue-shopping']")private WebElement ContinueShoppingBtn;
	@FindBy(xpath="//button[@id='checkout']")private WebElement CheckoutBtn;
	@FindBy(xpath="//a[@class='shopping_cart_link']")private WebElement CartIcon;
	@FindBy(xpath="/span[@class='shopping_cart_badge']")private WebElement CartCount;
	@FindBy(xpath="//span[@class='title']")private WebElement PageTitle;
	
	//constructor
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	//method
	public String VerifyCartPageURL() {
		return driver.getCurrentUrl();
		
	}
	
	public String VerifyChecoutBtn() {
		CheckoutBtn.click();
		return driver.getCurrentUrl();
	}
	
	public String VerifyCartCount() {
		return CartCount.getText();
	}
	
	public String VerifyPageTitle() {
		return PageTitle.getText();
	}
	
	public String VerifyContinueShopBtn() {
		ContinueShoppingBtn.click();
		return driver.getCurrentUrl();
		
	}
	
	public void GotoCheckOutPage() {
		CheckoutBtn.click();
	}
	
	

}
