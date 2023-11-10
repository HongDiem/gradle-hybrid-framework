package EFDS;

import org.openqa.selenium.WebDriver;

import commons.BasePage;


public class LoginPageObject extends BasePage{
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToIDTextbox(String userId) {
		waitForElementClickable(driver, LoginPageUI.ID_USER_TEXT);
		sendkeyToElement(driver, LoginPageUI.ID_USER_TEXT, userId);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementClickable(driver,LoginPageUI.PASSWORD_TEXT);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXT, password);
	}

	public DashboardPageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return EFDS.PageGeneratorManager.getDashboardPage(driver);
	}

	public String getErrorMessageIDUserName() {
		waitForElementVisible(driver, LoginPageUI.ERROR_ID_USER_NAME);
		return getElementText(driver, LoginPageUI.ERROR_ID_USER_NAME);
	}

	public String getErrorMessagePassword() {
		waitForElementVisible(driver, LoginPageUI.ERROR_PASSWORD);
		return getElementText(driver, LoginPageUI.ERROR_PASSWORD);
	}

	public boolean isPopupErrorIsDisplay() {
		waitForElementVisible(driver, LoginPageUI.POPUP_ERROR);
		return isElementDisplayed(driver, LoginPageUI.POPUP_ERROR);
	}

	public void clickToOKButtonInPopUpError() {
		waitForElementClickable(driver, LoginPageUI.OK_BUTTON_POPUP_ERROR);
		clickToElement(driver, LoginPageUI.OK_BUTTON_POPUP_ERROR);
	}

	public boolean isPopupErrorIDOrPasswordInvalidIsDisplay() {
		waitForElementVisible(driver, LoginPageUI.POPUP_ERROR_ID_OR_PASSWORD_INVALID);
		return isElementDisplayed(driver, LoginPageUI.POPUP_ERROR_ID_OR_PASSWORD_INVALID);
	}

	public void clickToOKButtonInPopUpErrorIdOrPasswordInvalid() {
		waitForElementClickable(driver, LoginPageUI.OK_BUTTON_POPUP_ERROR_ID_OR_PASSWOD_INVALID);
		clickToElement(driver, LoginPageUI.OK_BUTTON_POPUP_ERROR_ID_OR_PASSWOD_INVALID);
	}

	
	

	
	

}
