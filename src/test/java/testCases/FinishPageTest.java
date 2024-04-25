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
import pages.FinishPage;
import pages.InventryPage;
import pages.LoginPage;
import utility.Screenshot;

public class FinishPageTest extends TestBase {
	
	LoginPage login;
	InventryPage inventry;
	CartPage cart;
	CheckoutPage ch;
	CheckoutPageTwo ChekoutTwo;
	FinishPage finishPage;
	
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
		ChekoutTwo.VerifyFinishBtn();
		finishPage=new FinishPage();
		
	}
	
	@Test
	public void VerifyPageTitleTest() {
		String Expected="Checkout: Complete!";
		String Actual=finishPage.VerifyPageTitle();
		Assert.assertEquals(Actual, Expected);
		Reporter.log("Actual page title+"+Actual);
	}
	
	@Test
	public void VerifySuccessLogoTest() {
		
		boolean result=finishPage.VerifySuccessLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Success Logo is present "+result);
	}
	
	@Test
	public void VerifySuccessTextTest() {
		String Expected="Thank you for your order!";
		String Actual=finishPage.VerifySuccessText();
		Assert.assertEquals(Actual, Expected);
		Reporter.log("Actual Success text "+Actual);
	}
	
	@Test
	public void VerifySuccessSubTextTest() {
		String Expected="Your order has been dispatched, and will arrive just as fast as the pony can get there!";
		String Actual=finishPage.VerifySuccessSubText();
		Assert.assertEquals(Actual, Expected);
		Reporter.log("Actual Success subtext "+Actual);
	}
	
	@Test
	public void VerifyBackbtnTest() {
		String Expected="https://www.saucedemo.com/inventory.html";
		String Actual=finishPage.VerifyBackbtn();
		Assert.assertEquals(Actual, Expected);
		Reporter.log("Actual Page URL "+Actual);
	}
	

	@AfterMethod
	public void CloseApplicationBrowser(ITestResult It) throws IOException {
		if(It.FAILURE==It.getStatus()) {
			Screenshot.ScreenshotOfPage(It.getName());
		}
		CloseBrowser();
	}
	
	
	

}
