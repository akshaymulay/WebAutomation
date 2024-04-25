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
import pages.CheckoutPage;
import pages.InventryPage;
import pages.LoginPage;
import utility.Screenshot;

public class CheckoutPageTest extends TestBase {
	
	LoginPage login;
	InventryPage inventry;
	CartPage cart;
	CheckoutPage ch;
	
	@BeforeMethod
	public void setup() throws InterruptedException, IOException {
		initialization();
		login=new LoginPage();
		login.loginToApplication();
		inventry=new InventryPage();
		inventry.AddSixProductsToCart();
		inventry.ClickOnCartIcon();
		cart=new CartPage();
		cart.GotoCheckOutPage();
		ch=new CheckoutPage();
		
	}
	
	@Test
	public void InputInfoTest() {
		String ExpectedURL="https://www.saucedemo.com/checkout-step-two.html";
		String ActualURL=ch.InputInfo();
		Assert.assertEquals(ActualURL, ExpectedURL);
		Reporter.log("Checkout Overview Page URL"+ActualURL);
	}
	
	
	@Test
	public void VerifyPageTitleTest() {
		String Expected="Checkout: Your Information";
		String Actual=ch.VerifyPageTitle();
		Assert.assertEquals(Actual, Expected);
		Reporter.log("Actual title of the page is"+Actual);
		
		
	}
	
	@Test
	public void VerifyCancelBtnTest() {
		String Expected="https://www.saucedemo.com/cart.html";
		String Actual=ch.VerifyCancelBtn();
		Assert.assertEquals(Actual, Expected);
		Reporter.log("Actual URL of the page is"+Actual);
	}
	
	@Test
	public void VerifyContinueBtnTest() {
		//ch.sendInputInfo();
		String Expected="https://www.saucedemo.com/checkout-step-two.html";
		String Actual=ch.VerifyContinueBtn();
		Assert.assertEquals(Actual, Expected);
		Reporter.log("Actual URL of the page is"+Actual);
	}
	
	
	@AfterMethod
	public void CloseApplicationBrowser(ITestResult It) throws IOException {
		if(It.FAILURE==It.getStatus()) {
			Screenshot.ScreenshotOfPage(It.getName());
		}
		CloseBrowser();
	}

}
