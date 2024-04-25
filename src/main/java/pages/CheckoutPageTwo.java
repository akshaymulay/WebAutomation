package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckoutPageTwo extends TestBase {

	//object repository
	@FindBy(xpath="//span[@class='title']")private WebElement PageTitle;
	@FindBy(xpath="//div[text()='SauceCard #31337']")private WebElement PaymentInfo;
	@FindBy(xpath="//div[text()='Free Pony Express Delivery!']")private WebElement ShippingInfo;
	@FindBy(xpath="//div[@class='summary_total_label']")private WebElement TotalPrice;
	@FindBy(xpath="//button[@id='cancel']")private WebElement CancelBtn;
	@FindBy(xpath="//button[@id='finish']")private WebElement FinishBtn;
	
	//constructor
	public CheckoutPageTwo() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String VerifyTotal() {
		String Price=TotalPrice.getText();
	String FinalPrice[]=Price.split(":");
	return FinalPrice[1].trim();
	}
	
	
	public String VerifyPaymentInfo() {
		return PaymentInfo.getText();
	}
	
	public String VerifyShippingInfo() {
		return ShippingInfo.getText();
	}
	
	public String VerifyPageTitle() {
		return PageTitle.getText();
	}
	
	public String VerifyCancelButton() {
		CancelBtn.click();
		return driver.getCurrentUrl();
	}
	
	public String VerifyFinishBtn() {
		FinishBtn.click();
		return driver.getCurrentUrl();
	}
	
}
