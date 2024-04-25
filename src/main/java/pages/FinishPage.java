package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class FinishPage extends TestBase {
	
	//object repository
	
	@FindBy(xpath="//span[@class='title']")private WebElement PageTitle;
	@FindBy(xpath="//img[@class='pony_express']")private WebElement SuccessLogo;
	@FindBy(xpath="//h2[@class='complete-header']")private WebElement SuccessText;
	@FindBy(xpath="//div[@class='complete-text']")private WebElement SuccessSubText;
	@FindBy(xpath="//button[@id='back-to-products']")private WebElement BackBtn;
	
	
	//constructor
	public FinishPage() {
		PageFactory.initElements(driver, this);
	}
	
 public String VerifyPageTitle() {
	 return PageTitle.getText();
 }
	
 public boolean VerifySuccessLogo() {
	 return PageTitle.isDisplayed();
 }
 
 public String VerifySuccessText() {
	 
	 return SuccessText.getText();
 }
 
public String VerifySuccessSubText() {
	 
	 return SuccessSubText.getText();
 }
 
public String VerifyBackbtn() {
	BackBtn.click();
	return driver.getCurrentUrl();
}
	
}
