package liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import liveGuruUI.RegisterPageUI;

public class RegisterPageObject extends BasePage{
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToFirstnameTextbox(String fisrtName) {
		waitForAllElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, fisrtName);
	}

	public void inputToLastnameTextbox(String lastName) {
		waitForAllElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
		
	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForAllElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);		
	}

	public void inputToPasswordTextbox(String password) {
		waitForAllElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);	
	}

	public void inputToConfirmPasswordTextbox(String password) {
		waitForAllElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);			
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public String getRegisterSucessMessage() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public String getValueOfEmail() {
		waitForElementVisible(driver, RegisterPageUI.VALUE_OF_EMAIL);
		return getElementText(driver, RegisterPageUI.VALUE_OF_EMAIL);
	}

	public String getTextWelcomeSuccess() {
		waitForElementVisible(driver, RegisterPageUI.TEXT_WELCOME_SUCCESS);
		return getElementText(driver, RegisterPageUI.TEXT_WELCOME_SUCCESS);
	}
	
	
	

}
