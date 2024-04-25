package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class InventryPage extends TestBase {
	
	//object repository
	@FindBy(xpath="//span[text()='Products']")private WebElement PageTitle;
	@FindBy(xpath="//a[@class='shopping_cart_link']")private WebElement CartIcon;
	@FindBy(xpath="//span[@class='shopping_cart_badge']")private WebElement CartCount;
	@FindBy(xpath="//select[@class='product_sort_container']")private WebElement Filter;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")private WebElement BtnForBackpack;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']")private WebElement BtnForBikeLight;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")private WebElement BtnForBoltTshirt;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']")private WebElement BtnForJacket;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement BtnOnesie;
	@FindBy(xpath="//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement RedTshirt;
	@FindBy(xpath="//a[text()='Twitter']")private WebElement TwitterLogo;
	@FindBy(xpath="//a[text()='Facebook']")private WebElement FacebookLogo;
	@FindBy(xpath="//a[text()='LinkedIn']")private WebElement LinkedinLogo;
	@FindBy(xpath="//div[@class='footer_copy']")private WebElement CopyrightTxt;
	@FindBy(xpath="//div[@class='app_logo']")private WebElement MainLogo;
	
	@FindBy(xpath="//button[@id='remove-sauce-labs-backpack']")private WebElement RemoveBtnForBackpack;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bike-light']")private WebElement RemoveBtnForBikeLight;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bolt-t-shirt']")private WebElement RemoveBtnForBoltTshirt;
	@FindBy(xpath="//button[@id='remove-sauce-labs-fleece-jacket']")private WebElement RemoveBtnForJacket;
	@FindBy(xpath="//button[@id='remove-sauce-labs-onesie']") private WebElement RemoveBtnOnesie;
	@FindBy(xpath="//button[@id='remove-test.allthethings()-t-shirt-(red)']") private WebElement RemoveRedTshirt;
	
	
	
	
	//constructor
	public InventryPage() {
		PageFactory.initElements(driver, this);
	}
	
	//methods
	public String VerifyPageTitle() {
		return PageTitle.getText();
		
	}
	
	public boolean VerifyTwitterLogo() {
		return TwitterLogo.isDisplayed();
		
	}
	
	public boolean VerifyFacebookLogo() {
		return FacebookLogo.isDisplayed();
	}

	public boolean VerifyLinkedinLogo() {
		return LinkedinLogo.isDisplayed();
	}
	
	public String AddSixProducts() {
		Select s=new Select(Filter);
		s.selectByVisibleText("Price (low to high)");
		BtnForBackpack.click();
		BtnForBikeLight.click();
		BtnForBoltTshirt.click();
		BtnForJacket.click();
		BtnOnesie.click();
		RedTshirt.click();
		return CartCount.getText();
		
	}
	public boolean VerifyMainPageLogo() {
		return MainLogo.isDisplayed();
	}
	
	public String VerifyCopyrightText() { 
		return CopyrightTxt.getText();
	}
	
	public String RemoveSixProducts() {
		AddSixProducts();
		RemoveBtnForBackpack.click();
		RemoveBtnForBikeLight.click();
		RemoveBtnForBoltTshirt.click();
		RemoveBtnForJacket.click();
		RemoveBtnOnesie.click();
		RemoveRedTshirt.click();
		return CartCount.getText();
		
	}
	
	public void ClickOnCartIcon() throws InterruptedException {
		Thread.sleep(3000);
		CartIcon.click();
		Thread.sleep(3000);
		
	}
	
	public void AddSixProductsToCart() {
		Select s=new Select(Filter);
		s.selectByVisibleText("Price (low to high)");
		BtnForBackpack.click();
		BtnForBikeLight.click();
		BtnForBoltTshirt.click();
		BtnForJacket.click();
		BtnOnesie.click();
		RedTshirt.click();
}
}
