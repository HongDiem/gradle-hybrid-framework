package EFDS;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static EFDS.LoginPageObject getLoginPage(WebDriver driver) {
		return new EFDS.LoginPageObject(driver);
	}
	
	public static RegionalPageObject getRegionalPage(WebDriver driver) {
		return new RegionalPageObject(driver);
	}
	
	public static PropertyPageObject getPropertyPage(WebDriver driver) {
		return new PropertyPageObject(driver);
	}
	
	public static SensorPageObject getSensorPage(WebDriver driver) {
		return new SensorPageObject(driver);
	}

	public static DashboardPageObject getDashboardPage(WebDriver driver) {
		return new DashboardPageObject(driver);
	}
}
