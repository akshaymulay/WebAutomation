package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckoutPage extends TestBase {

	//object repository
	@FindBy(xpath="//button[@id='cancel']")private WebElement CancelBtn;
	@FindBy(xpath="//input[@id='continue']")private WebElement ContinueBtn;
	@FindBy(xpath="//span[@class='title']")private WebElement PageTitle;
	@FindBy(xpath="//input[@id='first-name']")private WebElement FirstNameTxtbox;
	@FindBy(xpath="//input[@id='last-name']")private WebElement LastNameTxtbox;
	@FindBy(xpath="//input[@id='postal-code']")private WebElement ZipTxtbox;
	
	
	//constructor
	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String InputInfo() {
		FirstNameTxtbox.sendKeys("Akshay");
		LastNameTxtbox.sendKeys("Mulay");
		ZipTxtbox.sendKeys("Test");
		ContinueBtn.click();
		return driver.getCurrentUrl();
		
	}
	public String VerifyPageTitle() {
		return PageTitle.getText();
	}
	
	
	public String VerifyCancelBtn() {
		CancelBtn.click();
		return driver.getCurrentUrl();
	}
	
	public String VerifyContinueBtn() {
		FirstNameTxtbox.sendKeys("Akshay");
		LastNameTxtbox.sendKeys("Mulay");
		ZipTxtbox.sendKeys("Test");
		ContinueBtn.click();
		return driver.getCurrentUrl();
	}
	
	//public void sendInputInfo() {
		//FirstNameTxtbox.sendKeys("Akshay");
		//LastNameTxtbox.sendKeys("Mulay");
		//ZipTxtbox.sendKeys("Test");
	//}
	
	
}
