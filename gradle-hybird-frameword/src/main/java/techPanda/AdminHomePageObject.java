package techPanda;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObjectjQuery.dataType.HomePageUI;
import pageUI.nopCommerce.admin.AdminLoginPageUI;

public class AdminHomePageObject extends BasePage{
	private WebDriver driver;

	public AdminHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToClosePopup() {
		waitForElementVisible(driver, AdminHomePageUI.POPUP_CLOSE);
		clickToElement(driver, AdminHomePageUI.POPUP_CLOSE);
	}

//	public void enterToTextboxAtRowNumberByColumnName(String columnName, String rowNumber, String valueToEnter) {
//		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
//		waitForElementVisible(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
//		sendkeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, valueToEnter, rowNumber, String.valueOf(columnIndex));
//	}

	public void clickToSearchButton() {
		waitForElementVisible(driver, AdminHomePageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminHomePageUI.SEARCH_BUTTON);
		
	}

	public void enterToTextboxAtRowNumberByColumnName(String columnName, String emailAddress) {
		int columnIndex = getElementSize(driver, AdminHomePageUI.COLUMN_INDEX_BY_NAME, columnName) +1;
		waitForElementVisible(driver, AdminHomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, String.valueOf(columnIndex));
		sendkeyToElement(driver, AdminHomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, emailAddress, String.valueOf(columnIndex));
	}

	public boolean isDisplayedValue(String fisrtName, String emailAddress) {
//		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
//		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
		waitForElementClickable(driver, AdminHomePageUI.VALUE_BY_COLUMN_INDEX, fisrtName, emailAddress);
		return isElementDisplayed(driver, AdminHomePageUI.VALUE_BY_COLUMN_INDEX, fisrtName, emailAddress);
	}

	
	
}
