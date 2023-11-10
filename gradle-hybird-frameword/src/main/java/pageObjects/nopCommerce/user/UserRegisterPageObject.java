package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUI.nopCommerce.user.RegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	private WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Click to Register Button")
	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}
	
	@Step("Enter to Firstname textbox with value is {0}")
	public void inputToFirstnameTextbox(String firstName) {
		waitForAllElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	@Step("Enter to Lastname textbox with value is {0}")
	public void inputToLastnameTextbox(String lastName) {
		waitForAllElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
	}
	
	@Step("Enter to Email textbox with value is {0}")
	public void inputToEmailTextbox(String emailAddress) {
		waitForAllElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
	}
	
	@Step("Enter to Password textbox with value is {0}")
	public void inputToPasswordTextbox(String password) {
		waitForAllElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	@Step("Enter to ConfirmPassword textbox with value is {0}")
	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForAllElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}	
	
	public String getErrorMessageAtFirstnameTextbox() {
		waitForElementClickable(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtLastnameTextbox() {
		waitForElementClickable(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementClickable(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}
	
	public String getErrorMessageAtPasswordTextbox() {
		waitForElementClickable(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementClickable(driver, RegisterPageUI.CONFIRM_PASSWOR_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWOR_ERROR_MESSAGE);
	}
	
	@Step("Verify register success message is displayed")
	public String getRegisterSucessMessage() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_SUCCESS_MASSAGE);
		return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MASSAGE);
	}

	
	public String getErrorExistingEmailMessage() {
		waitForElementClickable(driver, RegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
	}

	public UserMyProductReviewPageObject openMyProductReview() {
		return null;
	}
	

}