package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import pageUI.nopCommerce.user.LoginPageUI;

public class LoginPageObject extends BasePageFactory {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="Email")
	private WebElement emailTextbox;
	
	@FindBy(id="Password")
	private WebElement passwordTextbox;
	
	@FindBy(xpath = "//button[contains(@class,'login-button')]")
	private WebElement loginButton;
	
	@FindBy(xpath = "//span[@id='Email-error']")
	private WebElement emailErrorMessage;
	
	@FindBy(xpath = "//div[contains(@class,'validation-summary-errors')]")
	private WebElement unsuccessErrorMessage;
	
	public void clickToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementClickable(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public void inputToEmailTextbox(String invalidEmail) {
		waitForElementClickable(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, invalidEmail);
	}

	public String getErrorMassageUnsuccessful() {
		waitForElementClickable(driver, unsuccessErrorMessage);
		return getElementText(driver, unsuccessErrorMessage);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementClickable(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);
		
	}
}
