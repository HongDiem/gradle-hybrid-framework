package pageObjectjQuery.dataType;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static HomePageObject getHomPage(WebDriver driver) {
		return new HomePageObject(driver);
	}
}