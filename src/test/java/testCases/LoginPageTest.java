package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pages.LoginPage;
import utility.ReadDataFromExcel;
import utility.Screenshot;

public class LoginPageTest extends TestBase{
	
	LoginPage login;
	
	@BeforeMethod
	public void setup() throws InterruptedException, IOException {
		initialization();
		login=new LoginPage();
	}
	@Test
	public void VerifyURLOfApplicationTest() throws EncryptedDocumentException, IOException {
		String ExpectedURL=ReadDataFromExcel.ReadExcel(0, 0);              //https://www.saucedemo.com/(0,0)
		String ActualURL=login.VerifyURLOfApplication();
		Assert.assertEquals(ActualURL, ExpectedURL);
	}
	
	@Test
	
	public void VerifyTitleOfApplicationTest() throws EncryptedDocumentException, IOException {
		String ExpectedTitle=ReadDataFromExcel.ReadExcel(1, 0); //Swag Labs(1,0)
		String ActualTitle=login.VerifyTitleOfApplication();
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
	
	@Test
	public void loginToApplicationTest() throws IOException {
		String ExpectedURL="https://www.saucedemo.com/inventory.html";
		String ActualURL=login.loginToApplication();
		Assert.assertEquals(ActualURL, ExpectedURL);
	}
	
	@DataProvider(name="LoginCredentials")
	public Object[][] getData(){
		return new Object[][] {
			{"test","test"},
			
		};
	}
	@Test(dataProvider="LoginCredentials")
	public void MultipleloginToApplicationTest(String UserName,String Password) throws IOException{
		String Expected="https://www.saucedemo.com/inventory.html";
		String Actual=login.MultipleloginToApplication(UserName, Password);
		SoftAssert a=new SoftAssert();
		a.assertEquals(Actual, Expected);
		a.assertAll();
	}
	
	@AfterMethod
	public void CloseApplicationBrowser(ITestResult It) throws IOException {
		if(It.FAILURE==It.getStatus()) {
			Screenshot.ScreenshotOfPage(It.getName());
		}
		report.flush();
		CloseBrowser();
	}
	
	

}
