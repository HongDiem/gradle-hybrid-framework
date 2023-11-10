package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy(id="FirstName")
	private WebElement firstNameTextbox;
	
	@FindBy(id="LastName")
	private WebElement lastNameTextbox;
	
	@FindBy(id="Email")
	private WebElement emailAddressTextbox;
	
	@FindBy(id="Password")
	private WebElement passwordTextbox;
	
	@FindBy(id="ConfirmPassword")
	private WebElement confirmPasswordTextbox;
	
	@FindBy(id = "register-button")
	private WebElement registerButton;
	
	@FindBy(xpath = "//span[@id='FirstName-error']")
	private WebElement firstNameErrorMessage;
	
	@FindBy(xpath = "//span[@id='LastName-error']")
	private WebElement lastNameErrorMessage;
	
	@FindBy(xpath = "//span[@id='Email-error']")
	private WebElement emailErrorMessage;
	
	@FindBy(xpath = "//span[@id='Password-error']")
	private WebElement passwordErrorMessage;
	
	@FindBy(xpath = "//span[@id='ConfirmPassword-error']")
	private WebElement confirmPasswordErrorMessage;
	
	@FindBy(xpath = "//div[@class='result']")
	private WebElement registerSuccessMessage;
	
	@FindBy(xpath = "//div[contains(@class,'message-error')]//li")
	private WebElement existingEmailErrorMessage;
	
	@FindBy(xpath = "//a[@class='ico-logout']")
	private WebElement logoutLink;
	
	
	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}
	
	public void inputToFirstnameTextbox(String firstName) {
		waitForAllElementVisible(driver, firstNameTextbox);
		sendkeyToElement(driver, firstNameTextbox, firstName);
		
	}

	public void inputToLastnameTextbox(String lastName) {
		waitForAllElementVisible(driver, lastNameTextbox);
		sendkeyToElement(driver, lastNameTextbox, lastName);
		
	}
	
	public void inputToEmailTextbox(String emailAddress) {
		waitForAllElementVisible(driver, emailAddressTextbox);
		sendkeyToElement(driver, emailAddressTextbox, emailAddress);
		
	}
	
	public void inputToPasswordTextbox(String password) {
		waitForAllElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);
		
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForAllElementVisible(driver, confirmPasswordTextbox);
		sendkeyToElement(driver, confirmPasswordTextbox, confirmPassword);
		
	}
	
	public String getErrorMessageAtFirstnameTextbox() {
		waitForElementClickable(driver, firstNameErrorMessage);
		return getElementText(driver, firstNameErrorMessage);
	}

	public String getErrorMessageAtLastnameTextbox() {
		waitForElementClickable(driver, lastNameErrorMessage);
		return getElementText(driver, lastNameErrorMessage);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementClickable(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}
	
	public String getErrorMessageAtPasswordTextbox() {
		waitForElementClickable(driver, passwordErrorMessage);
		return getElementText(driver, passwordErrorMessage);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementClickable(driver, confirmPasswordErrorMessage);
		return getElementText(driver, confirmPasswordErrorMessage);
	}
	

	public String getRegisterSucessMessage() {
		waitForElementClickable(driver, registerSuccessMessage);
		return getElementText(driver, registerSuccessMessage);
	}

	
	public String getErrorExistingEmailMessage() {
		waitForElementClickable(driver, existingEmailErrorMessage);
		return getElementText(driver, existingEmailErrorMessage);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);
	}
}
