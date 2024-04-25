package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProductFilter {
	public static void ProductDropdown(WebElement e,String OptionType) {
		Select s=new Select(e);
		s.selectByVisibleText(OptionType);
	}
	

}
