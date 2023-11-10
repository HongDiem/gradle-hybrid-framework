package techPanda;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.nopCommerce.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage{
	private WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToUsernameTexbox(String emailAdmin) {
		waitForAllElementVisible(driver, techPanda.AdminLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, techPanda.AdminLoginPageUI.EMAIL_TEXTBOX, emailAdmin);
	}

	public void inputToPasswordTexbox(String passwordAdmin) {
		waitForAllElementVisible(driver, techPanda.AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, techPanda.AdminLoginPageUI.PASSWORD_TEXTBOX, passwordAdmin);
		
	}

	public void clickToLoginButton() {
		waitForElementVisible(driver, techPanda.AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, techPanda.AdminLoginPageUI.LOGIN_BUTTON);
	}
	
}
