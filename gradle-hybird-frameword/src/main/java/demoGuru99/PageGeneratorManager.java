package demoGuru99;

import org.openqa.selenium.WebDriver;



public class PageGeneratorManager {
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static NewCustomerPageObject getNewCustomPage(WebDriver driver) {
		return new NewCustomerPageObject(driver);
	}
	
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	
	
}
