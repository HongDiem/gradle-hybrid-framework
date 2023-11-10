package techPanda;

import org.openqa.selenium.WebDriver;

import pageObjectjQuery.dataType.HomePageObject;

public class PageGeneratorManager {
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}

	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new AdminLoginPageObject(driver);
	}
	
	public static AdminHomePageObject getAdminHomePage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new AdminHomePageObject(driver);
	}
	
}
