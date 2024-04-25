package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.InventryPage;
import pages.LoginPage;

public class InventryPageTest extends TestBase {
	LoginPage login;
	InventryPage inventry;

	@BeforeMethod
	public void setup() throws InterruptedException, IOException {
		initialization();
		login=new LoginPage();
		login.loginToApplication();
		inventry=new InventryPage();
		
	}
	
	@Test
	public void VerifyPageTitleTest() {
		String Expected="Products";
		String Actual=inventry.VerifyPageTitle();
		Assert.assertEquals(Actual, Expected);
		Reporter.log("Title of the page is="+Actual);
		
	}
	
	@Test
	public void VerifyTwitterLogoTest() {
		
		Boolean Actual=inventry.VerifyTwitterLogo();
		Assert.assertEquals(Actual, true);
		Reporter.log("Twitter logo is present="+Actual);
	}
	
	@Test
	public void  VerifyFacebookLogoTest() {
		Boolean Actual=inventry.VerifyFacebookLogo();
		Assert.assertEquals(Actual, true);
		Reporter.log("Facebook logo is present="+Actual);
	}
	
	@Test
	public void  VerifyLinkedinLogoTest() {
		Boolean Actual=inventry.VerifyLinkedinLogo();
		Assert.assertEquals(Actual, true);
		Reporter.log("Linkedin logo is present="+Actual);
	}
	
	@Test
	public void AddSixProductsTest() {
		String ExpectedCount="6";
		String ActualCount=inventry.AddSixProducts();
		Assert.assertEquals(ActualCount, ExpectedCount);
		Reporter.log("Total products added in cart= "+ActualCount);
	}
	
	@Test
	public void VerifyMainPageLogoTest(){
		Boolean Actual=inventry.VerifyMainPageLogo();
		Assert.assertEquals(Actual, true);
		Reporter.log("Main Page logo is present="+Actual);
		
	}
	
	@Test
	public void VerifyCopyrightTextTest(){
		String Expected="© 2024 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
		String Actual=inventry.VerifyCopyrightText();
		Assert.assertEquals(Actual, Expected);
		Reporter.log("Copyright Text is="+Actual);
	}
	
	@Test
	public void RemoveSixProductsTest() {
		String Expected="0";
		String Actual=inventry.RemoveSixProducts();
		Assert.assertEquals(Actual, Expected);
		Reporter.log("Cart count is="+Actual);
		
	}
	
	@AfterMethod
	public void CloseApplicationBrowser() {
		CloseBrowser();
	}
	

}
