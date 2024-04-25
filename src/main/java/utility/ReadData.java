package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadData {
	
	public static String ReadPropertyFile(String value) throws IOException {
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("A:\\java\\WebAuto\\TestData\\config.properties");
		prop.load(fis);
		return prop.getProperty(value);
		
	}

}
 