package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBase;
import utility.ReadData;

public class LoginPage extends TestBase {
	
	//object repository
	@FindBy(xpath="//input[@id='user-name']")private WebElement  UserNameTextBox;
	@FindBy(xpath="//input[@id='password']")private WebElement PasswordField;
	@FindBy(xpath="//input[@id='login-button']")private WebElement LoginBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String loginToApplication() throws IOException {
		Logger=report.createTest("Login to the saucelab");
		UserNameTextBox.sendKeys(ReadData.ReadPropertyFile("UserName"));
		Logger.log(Status.INFO, "Username is entered");
		PasswordField.sendKeys(ReadData.ReadPropertyFile("Password"));
		Logger.log(Status.INFO, "Password is entered");
		LoginBtn.click();
		Logger.log(Status.INFO, "Login button is clicked");
		Logger.log(Status.INFO, "Login is successful");
		return driver.getCurrentUrl();
		
	}
	
	
	public String VerifyURLOfApplication() {
		return driver.getCurrentUrl();
		
	}
	
	public String VerifyTitleOfApplication() {
		return driver.getTitle();
		
	}
	
	public String MultipleloginToApplication(String UserName, String Password) throws IOException {
		UserNameTextBox.sendKeys(UserName);
		PasswordField.sendKeys(Password);
		LoginBtn.click();
		return driver.getCurrentUrl();
		
	}
	
	

}
