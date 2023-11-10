package demoGuru99;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import demoGuru99UI.NewCustomerPageUI;
import io.qameta.allure.Step;

public class NewCustomerPageObject extends BasePage {
	private WebDriver driver;

	public NewCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterTabToNameTextbox(Keys key, String textOfTextbox) {
		waitForElementVisible(driver, NewCustomerPageUI.TEXTBOX, textOfTextbox);
		pressKeyToElement(driver, NewCustomerPageUI.TEXTBOX, key, textOfTextbox);
	}

	public String getErrorMessage(WebDriver driver, String textOfMessage) {
		waitForElementVisible(driver, NewCustomerPageUI.ERROR_MESSAGE, textOfMessage);
		return getElementText(driver, NewCustomerPageUI.ERROR_MESSAGE, textOfMessage);
	}

	
	@Step("Enter to name textbox with Number is {0} and {1} and {2}")
	public void enterToNameTextboxWithNumber(WebDriver driver, String customerNumber, String textOfTextbox) {
		waitForElementVisible(driver, NewCustomerPageUI.TEXTBOX, textOfTextbox);
		sendkeyToElement(driver, NewCustomerPageUI.TEXTBOX, customerNumber, textOfTextbox);
	}

	public void enterTabToAddressTextArea(Keys key, String textOfTextArea) {
		waitForElementVisible(driver, NewCustomerPageUI.TEXT_AREA, textOfTextArea);
		pressKeyToElement(driver, NewCustomerPageUI.TEXT_AREA, key, textOfTextArea);
	}

	public void enterTabToAddressTextAreaWithBlank(WebDriver driver, String addressBlank, String textOfTextArea) {
		waitForElementVisible(driver, NewCustomerPageUI.TEXT_AREA, textOfTextArea);
		sendkeyToElement(driver, NewCustomerPageUI.TEXT_AREA, addressBlank, textOfTextArea);
	}

	public void clickToSubmitButton(WebDriver driver, String buttonType) {
		waitForElementVisible(driver, NewCustomerPageUI.BUTON_TYPE ,buttonType );
		clickToElement(driver, NewCustomerPageUI.BUTON_TYPE, buttonType );
	}

}
