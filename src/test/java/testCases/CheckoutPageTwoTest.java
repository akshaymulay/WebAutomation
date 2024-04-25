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
import pages.CheckoutPageTwo;
import pages.InventryPage;
import pages.LoginPage;
import utility.Screenshot;

public class CheckoutPageTwoTest extends TestBase {
	
	LoginPage login;
	InventryPage inventry;
	CartPage cart;
	CheckoutPage ch;
	CheckoutPageTwo ChekoutTwo;
	
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
		ch.VerifyContinueBtn();
		ChekoutTwo=new CheckoutPageTwo();
	}

	@Test
	public void VerifyTotalTest() {
		String Expected="$140.34";
		String Actual=ChekoutTwo.VerifyTotal();
		Assert.assertEquals(Actual, Expected);
		Reporter.log("Actual Total price in doller is"+Actual);
	}
	
	@Test
	public void VerifyPaymentInfoTest() {
		String Expected="SauceCard #31337";
		String Actual=ChekoutTwo.VerifyPaymentInfo();
		Assert.assertEquals(Actual, Expected);
		Reporter.log("Actual Payment Info"+Actual);
	}
	
	@Test
	public void VerifyShippingInfoTest() {
		String Expected="Free Pony Express Delivery!";
		String Actual=ChekoutTwo.VerifyShippingInfo();
		Assert.assertEquals(Actual, Expected);
		Reporter.log("Actua shipping info"+Actual);
	}
	
	@Test
	public void VerifyPageTitleTest() {
		String Expected="Checkout: Overview";
		String Actual=ChekoutTwo.VerifyPageTitle();
		Assert.assertEquals(Expected, Actual);
		Reporter.log("Actual Page Title"+Actual);
	}
	
	@Test
	public void VerifyCancelButtonTest() {
		String Expected="https://www.saucedemo.com/inventory.html";
		String Actual=ChekoutTwo.VerifyCancelButton();
		Assert.assertEquals(Actual, Expected);
		Reporter.log("Actual URL"+Actual);
	}
	
	@Test
	public void VerifyFinishBtnTest() {
		String Expected="https://www.saucedemo.com/checkout-complete.html";
		String Actual=ChekoutTwo.VerifyFinishBtn();
		Assert.assertEquals(Actual, Expected);
		Reporter.log("Actual URL"+Actual);
	}
	
	@AfterMethod
	public void CloseApplicationBrowser(ITestResult It) throws IOException {
		if(It.FAILURE==It.getStatus()) {
			Screenshot.ScreenshotOfPage(It.getName());
		}
		CloseBrowser();
	}
	
	
}
