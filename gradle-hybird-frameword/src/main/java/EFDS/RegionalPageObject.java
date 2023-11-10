package EFDS;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class RegionalPageObject extends BasePage{
	private WebDriver Driver;

	public RegionalPageObject(WebDriver driver) {
		super();
		Driver = driver;
	}

	public boolean isRegionalTitleisplayed() {
		waitForElementVisible(Driver, RegionalPageUI.REGIONAL_TITLE);
		return isElementDisplayed(Driver, RegionalPageUI.REGIONAL_TITLE);
	}

	public void enterToRegionalTextbox(String regionalText) {
		waitForElementClickable(Driver, RegionalPageUI.REGIONAL_TEXTBOX);
		sendkeyToElement(Driver, RegionalPageUI.REGIONAL_TEXTBOX, regionalText);
	}

	public void clickToAddRegionalButton() {
		waitForElementClickable(Driver, RegionalPageUI.ADD_REGIONAL_BUTTON);
		clickToElement(Driver, RegionalPageUI.ADD_REGIONAL_BUTTON);
	}

	public boolean isPopupConfirmisplayed() {
		waitForAllElementVisible(Driver, RegionalPageUI.POPUP_CONFIRM_ADD_REGIONAL);
		return isElementDisplayed(Driver, RegionalPageUI.POPUP_CONFIRM_ADD_REGIONAL);
	}

	public void clickToOK() {
		waitForElementClickable(Driver, RegionalPageUI.OK_BUTTON_CONFIRM);
		clickToElement(Driver, RegionalPageUI.OK_BUTTON_CONFIRM);
	}

	public boolean isPopupConfirmSuccessIsplayed() {
		waitForAllElementVisible(Driver, RegionalPageUI.CONFIRM_POPUP_ADD_SUCCESS);
		return isElementDisplayed(Driver, RegionalPageUI.CONFIRM_POPUP_ADD_SUCCESS);
	}

	public void clickOKButonAddSuccess() {
		waitForElementClickable(Driver, RegionalPageUI.OK_BUTTON_ADD_SUCCESS);
		clickToElement(Driver, RegionalPageUI.OK_BUTTON_ADD_SUCCESS);
	}

	public SensorPageObject clickToSensorLink() {
		waitForElementClickable(Driver, RegionalPageUI.SENSOR_LINK);
		clickToElement(Driver, RegionalPageUI.SENSOR_LINK);
		return PageGeneratorManager.getSensorPage(Driver);
	}

	public boolean isConfirmPopupIsDisplay() {
		waitForAllElementVisible(Driver, RegionalPageUI.POPUP_CONFIRM_ADD_REGIONAL);
		return isElementDisplayed(Driver, RegionalPageUI.POPUP_CONFIRM_ADD_REGIONAL);
	}

	public boolean isSuccessPopUpIsDisplay() {
		waitForAllElementVisible(Driver, RegionalPageUI.CONFIRM_POPUP_ADD_SUCCESS);
		return isElementDisplayed(Driver, RegionalPageUI.CONFIRM_POPUP_ADD_SUCCESS);
	}

	public void clickToOneRegional(String regionalText) {
		waitForElementClickable(Driver, RegionalPageUI.REGIONAL_UPDATE, regionalText);
		clickToElement(Driver, RegionalPageUI.REGIONAL_UPDATE, regionalText);
	}

	public void clickToSort() {
		waitForElementClickable(Driver, RegionalPageUI.ICON_SORT);
		clickToElement(Driver, RegionalPageUI.ICON_SORT);
	}

	public boolean isPopUpSortAndFilterIsDisplay() {
		waitForAllElementVisible(Driver, RegionalPageUI.POPUP_SORT_AND_FILTER);
		return isElementDisplayed(Driver, RegionalPageUI.POPUP_SORT_AND_FILTER);
	}

	public void enterRegionalNameToFilterTextbox(Keys key, String regionalText) {
		waitForElementClickable(Driver, RegionalPageUI.FILTER_TEXTBOX);
		sendkeyToElement(Driver, RegionalPageUI.FILTER_TEXTBOX, regionalText);
		pressKeyToElement(Driver, RegionalPageUI.FILTER_TEXTBOX, key, regionalText);
	}

	public void clickToOKButtonINPoupSortAndFilter() {
		waitForElementClickable(Driver, RegionalPageUI.OK_BUTTON_IN_POPUP_SORT_AND_FILTER);
		clickToElement(Driver, RegionalPageUI.OK_BUTTON_IN_POPUP_SORT_AND_FILTER);
	}

	public void clickToUpdateButton() {
		waitForElementClickable(Driver, RegionalPageUI.UPDATE_REGINATIONAL_BUTTON);
		clickToElement(Driver, RegionalPageUI.UPDATE_REGINATIONAL_BUTTON);
	}

	public boolean isPopupUpdateRegionalIsDisplay() {
		waitForElementVisible(Driver, RegionalPageUI.TITLE_POPUP_UPDATE_REGIONAL);
		return isElementDisplayed(Driver, RegionalPageUI.TITLE_POPUP_UPDATE_REGIONAL);
	}

	public void clickToOKButtonInPopupConfirmUpdate() {
		waitForElementClickable(Driver, RegionalPageUI.OK_BUTTON_IN_POPUP_UPDATE_REGIONAL);
		clickToElement(Driver, RegionalPageUI.OK_BUTTON_IN_POPUP_UPDATE_REGIONAL);
	}

	public boolean isPopupUpdateRegionalSuccessIsDisplay() {
		waitForElementVisible(Driver, RegionalPageUI.TITLE_POPUP_UPDATE_SUCCESS);
		return isElementDisplayed(Driver, RegionalPageUI.TITLE_POPUP_UPDATE_SUCCESS);
	}

	public void clickToOKButtonInPopupUpdateSuccess() {
		waitForElementClickable(Driver, RegionalPageUI.OK_BUTTON_IN_POPUP_UPDATE_SUCCESS);
		clickToElement(Driver, RegionalPageUI.OK_BUTTON_IN_POPUP_UPDATE_SUCCESS);
	}

	public boolean isLineOfRegionalUpdateIsDisplay(String regionalTextUpdate) {
		waitForElementVisible(Driver, RegionalPageUI.REGIONAL_UPDATE, regionalTextUpdate);
		return isElementDisplayed(Driver, RegionalPageUI.REGIONAL_UPDATE, regionalTextUpdate);
	}

	public void clickOKButtonInPopupErrorRegionalExist() {
		waitForElementClickable(Driver, RegionalPageUI.OK_BUTTON_IN_POPIP_ERROR_REGIONAL_ALREADY_EXIST);
		clickToElement(Driver, RegionalPageUI.OK_BUTTON_IN_POPIP_ERROR_REGIONAL_ALREADY_EXIST);
	}

	public boolean isPopupErrorMessageIsDisplay() {
		waitForElementVisible(Driver, RegionalPageUI.ERROR_REGIONAL_ALREADY_EXIST);
		return isElementDisplayed(Driver, RegionalPageUI.ERROR_REGIONAL_ALREADY_EXIST);
	}

	public void clickToDeleteButton() {
		waitForElementClickable(Driver, RegionalPageUI.DELETE_REGINATIONAL_BUTTON);
		clickToElement(Driver, RegionalPageUI.DELETE_REGINATIONAL_BUTTON);
	}

	public boolean isPopupDeleteRegionalIsDisplay() {
		waitForElementClickable(Driver, RegionalPageUI.TITLE_POPUP_DELETE_REGIONAL);
		return isElementDisplayed(Driver, RegionalPageUI.TITLE_POPUP_DELETE_REGIONAL);
	}

	public void clickToOKButtonInPopupConfirmDelete() {
		waitForElementVisible(Driver, RegionalPageUI.OK_BUTTON_IN_POPUP_DELETE_REGIONAL);
		clickToElement(Driver, RegionalPageUI.OK_BUTTON_IN_POPUP_DELETE_REGIONAL);
	}

	public boolean isPopupDeleteRegionalSuccessIsDisplay() {
		waitForElementVisible(Driver, RegionalPageUI.TITLE_POPUP_DELETE_SUCCESS);
		return isElementDisplayed(Driver, RegionalPageUI.TITLE_POPUP_DELETE_SUCCESS);
	}

	public void clickToOKButtonInPopupDeleteSuccess() {
		waitForElementVisible(Driver, RegionalPageUI.OK_BUTTON_IN_POPUP_DELETE_SUCCESS);
		clickToElement(Driver, RegionalPageUI.OK_BUTTON_IN_POPUP_DELETE_SUCCESS);
	}

	public boolean isNullDataRegionalDeletedIsDisplay() {
		waitForElementVisible(Driver, RegionalPageUI.NULL_DATE_AFTER_DELETED);
		return isElementDisplayed(Driver, RegionalPageUI.NULL_DATE_AFTER_DELETED);
	}

	public void clickToClearButton() {
		waitForElementVisible(Driver, RegionalPageUI.CLEAR_BUTTON);
		clickToElement(Driver, RegionalPageUI.CLEAR_BUTTON);
	}

	public boolean isClearDataSuccess() {
		waitForElementVisible(Driver, RegionalPageUI.CLEAR_DATA_SUCCESS);
		return isElementDisplayed(Driver, RegionalPageUI.CLEAR_DATA_SUCCESS);
	}

	public void clickToCancelInPopupSortAndFilter() {
		waitForElementClickable(Driver, RegionalPageUI.CANCEL_BUTTON_IN_SORT_AND_FILTER);
		clickToElement(Driver, RegionalPageUI.CANCEL_BUTTON_IN_SORT_AND_FILTER);
	}

		
	
	

}

