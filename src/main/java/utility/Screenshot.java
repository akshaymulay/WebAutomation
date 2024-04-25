package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import base.TestBase;

public class Screenshot extends TestBase {
	
	public static String GetDate() {
		return new SimpleDateFormat("dd-MM-YYYY HH-mm-ss").format(new Date());
		
	}
	
	public static void ScreenshotOfPage(String NameOfMethod) throws IOException {
		File Src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File Dest=new File("A:\\java\\WebAuto\\Screenshots\\"+NameOfMethod+"--"+GetDate()+".jpeg");
		FileHandler.copy(Src, Dest);
	}
	

}
