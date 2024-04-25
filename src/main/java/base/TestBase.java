 package base;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ExtentReportManager;
import utility.ReadData;

public class TestBase {
	
	public ExtentReports report=ExtentReportManager.getReport();
	public ExtentTest Logger;
	
public static WebDriver driver;
	
	public void initialization() throws InterruptedException, IOException {
		
		String Browser=ReadData.ReadPropertyFile("Browser");
		
		if(Browser.equals("Chrome")){
		
		WebDriverManager.chromedriver().browserVersion(ReadData.ReadPropertyFile("ChromeBrowserVersion")).setup();
		 driver=new ChromeDriver();
		}
		
		else if(Browser.equals("IE")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			
		}
		
		else if(Browser.equals("Firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Thread.sleep(2000);
		driver.get(ReadData.ReadPropertyFile("URL"));
	
		
	}
	
	public void CloseBrowser() {
		driver.close();
	}
	
	
}
