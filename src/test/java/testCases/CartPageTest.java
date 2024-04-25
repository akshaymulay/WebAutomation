package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.InventryPage;
import pages.LoginPage;
import utility.Screenshot;

public class CartPageTest extends TestBase{
	
	LoginPage login;
	InventryPage inventry;
	CartPage cart;

	@BeforeMethod
	public void setup() throws InterruptedException, IOException {
		initialization();
		login=new LoginPage();
		login.loginToApplication();
		inventry=new InventryPage();
		inventry.AddSixProductsToCart();
		inventry.ClickOnCartIcon();
		cart=new CartPage();
		
	}
	
	@Test
	public void VerifyCartPageURLTest() {
		String Expected="https://www.saucedemo.com/cart.html";
		String Actual=cart.VerifyCartPageURL();
		Assert.assertEquals(Actual, Expected);
		Reporter.log("Actual URL of cart page"+Actual);
	}
	
	@Test
	public void VerifyChecoutBtnTest(){
		String ExpectedURL="https://www.saucedemo.com/checkout-step-one.html";
		String ActualURL=cart.VerifyChecoutBtn();
		Assert.assertEquals(ExpectedURL, ActualURL);
		Reporter.log("Actual URL of checkout page"+ActualURL);
				
		 
	}
	
	//@Test
	//public void VerifyCartCount() {
		//String Expected="6";
		//String Actual=cart.VerifyCartCount();
		//Assert.assertEquals(Actual, Expected);
		//Reporter.log("Actual Count in cart"+Actual);
	//}
	
	@Test
	public void VerifyPageTitleTest() {
		String ExpectedTitle="Your Cart";
		String ActualTitle=cart.VerifyPageTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		Reporter.log("Actual title of cart page"+ActualTitle);
		
	}
	
	@Test
	public void VerifyContinueShopBtnTest() {
		String ExpectedURL="https://www.saucedemo.com/inventory.html";
		String ActualURL=cart.VerifyContinueShopBtn();
		Assert.assertEquals(ActualURL, ExpectedURL);
		Reporter.log("Actual URL of Home page"+ActualURL);
		
	}
	
	
	
	@AfterMethod
	public void CloseApplicationBrowser(ITestResult It) throws IOException {
		if(It.FAILURE==It.getStatus()) {
			Screenshot.ScreenshotOfPage(It.getName());
		}
		CloseBrowser();
	}
	

}
