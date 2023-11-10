package EFDS;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class SensorPageObject extends BasePage{
	private WebDriver Driver;

	public SensorPageObject(WebDriver driver) {
		super();
		Driver = driver;
	}

	public void enterToSensorID(String sensorId) {
		waitForElementClickable(Driver, SensorPageUI.SENSOR_ID_TEXTBOX);
		sendkeyToElement(Driver, SensorPageUI.SENSOR_ID_TEXTBOX, sensorId);
	}

	public void enterToSensorName(String sensorName) {
		waitForElementClickable(Driver, SensorPageUI.SENSOR_NAME_TEXTBOX);
		sendkeyToElement(Driver, SensorPageUI.SENSOR_NAME_TEXTBOX, sensorName);
	}

	public void enterToSensorType(Keys key, String sensorType) {
		waitForElementClickable(Driver, SensorPageUI.SENSOR_TYPE_NAME_LINK);
		sendkeyToElement(Driver, SensorPageUI.SENSOR_TYPE_NAME_LINK, sensorType);
		pressKeyToElement(Driver, SensorPageUI.SENSOR_TYPE_NAME_LINK, key, sensorType);
	}

	public void enterToSensorArea(String sensorArea) {
		waitForElementClickable(Driver, SensorPageUI.SENSOR_AREA);
		sendkeyToElement(Driver, SensorPageUI.SENSOR_AREA, sensorArea);
	}	
	
	public void enterToSensorLocation(String sensorLocation) {
		waitForElementClickable(Driver, SensorPageUI.SENSOR_LOCATION);
		sendkeyToElement(Driver, SensorPageUI.SENSOR_LOCATION, sensorLocation);
	}

	public void enterToRegionName(Keys key, String regionalName) {
		waitForElementClickable(Driver, SensorPageUI.REGION_NAME_AUTOCOMPLETE);
		sendkeyToElement(Driver, SensorPageUI.REGION_NAME_AUTOCOMPLETE, regionalName);
		pressKeyToElement(Driver, SensorPageUI.REGION_NAME_AUTOCOMPLETE, key, regionalName);
	}

	public void enterToPropertyName(Keys key, String propertyName) {
		waitForElementClickable(Driver, SensorPageUI.PROPERTY_NAME_AUTOCOMPLETE);
		sendkeyToElement(Driver, SensorPageUI.PROPERTY_NAME_AUTOCOMPLETE, propertyName);
		pressKeyToElement(Driver,SensorPageUI.PROPERTY_NAME_AUTOCOMPLETE, key, propertyName);
	}

	public void enterToGatewayName(Keys key, String gatewayName) {
		waitForElementClickable(Driver, SensorPageUI.GATEWAY_NAME_TEXTBOX);
		sendkeyToElement(Driver, SensorPageUI.GATEWAY_NAME_TEXTBOX, gatewayName);
		pressKeyToElement(Driver, SensorPageUI.GATEWAY_NAME_VALUE, key, gatewayName);
	}

	public void clickToAddNewSensor() {
		waitForElementClickable(Driver, SensorPageUI.ADD_SENSOR_BUTTON);
		clickToElement(Driver, SensorPageUI.ADD_SENSOR_BUTTON);
	}

	public boolean isConfirmPopupIsDisplayed() {
		waitForAllElementVisible(Driver, SensorPageUI.CONFIUM_POPUP);
		return isElementDisplayed(Driver, SensorPageUI.CONFIUM_POPUP);
	}

	public void clickToConfirmPopup() {
		waitForElementClickable(Driver, SensorPageUI.OK_CONFIRM_BUTTON);
		clickToElement(Driver, SensorPageUI.OK_CONFIRM_BUTTON);
	}

	public boolean isSuccessPopupIsDisplayed() {
		waitForElementClickable(Driver, SensorPageUI.SUCCESS_POPUP);
		return isElementDisplayed(Driver, SensorPageUI.SUCCESS_POPUP);
	}

	public void clickToSuccessPopup() {
		waitForElementClickable(Driver, SensorPageUI.OK_SUCCESS_BUTTON);
		clickToElement(Driver, SensorPageUI.OK_SUCCESS_BUTTON);
	}

	public boolean isErrorMessagePopupIsDisplayed() {
		waitForElementVisible(Driver, SensorPageUI.POPUP_ERROR_EXIST);
		return isElementDisplayed(Driver, SensorPageUI.POPUP_ERROR_EXIST);
	}

	public void clickToSOKButtonInPopupErrorExist() {
		waitForElementClickable(Driver, SensorPageUI.OK_BUTTON_ERROR_EXIST);
		clickToElement(Driver, SensorPageUI.OK_BUTTON_ERROR_EXIST);
	}

	public void clickToSort() {
		waitForElementClickable(Driver, SensorPageUI.ICON_SORT);
		clickToElement(Driver, SensorPageUI.ICON_SORT);
	}

	public boolean isPopupSortAndFilterIsDisplay() {
		waitForElementVisible(Driver, SensorPageUI.POPUP_SORT_AND_FILTER);
		return isElementDisplayed(Driver, SensorPageUI.POPUP_SORT_AND_FILTER);
	}

	public void enterToFilterSensor(Keys key, String sensorId) {
		waitForElementClickable(Driver, SensorPageUI.FILTER_SENSOR_ID_TEXTBOX);
		sendkeyToElement(Driver, SensorPageUI.FILTER_SENSOR_ID_TEXTBOX, sensorId);
		pressKeyToElement(Driver,SensorPageUI.FILTER_SENSOR_ID_TEXTBOX, key, sensorId);
		
	}

	public void clickToOKFilter() {
		waitForElementClickable(Driver, SensorPageUI.OK_BUTTON_IN_FILTER);
		clickToElement(Driver, SensorPageUI.OK_BUTTON_IN_FILTER);
	}

	public void clickToClearSensor() {
		waitForElementClickable(Driver, SensorPageUI.CLEAR_BUTTON);
		clickToElement(Driver, SensorPageUI.CLEAR_BUTTON);
	}

	public void clickToUpdateSensor() {
		waitForElementClickable(Driver, SensorPageUI.UPDATE_BUTTON);
		clickToElement(Driver, SensorPageUI.UPDATE_BUTTON);
	}

	public void clickToSensorWantUpdate(String sensorId) {
		waitForElementClickable(Driver, SensorPageUI.LINE_SENSOR_FOCUS, sensorId);
		clickToElement(Driver, SensorPageUI.LINE_SENSOR_FOCUS, sensorId);
	}

	public boolean isClearSensorSuccess() {
		waitForElementVisible(Driver, SensorPageUI.CLEAR_SENSOR_SUCCESS);
		return isElementDisplayed(Driver, SensorPageUI.CLEAR_SENSOR_SUCCESS);
	}

	public void clickToDeleteSensor() {
		waitForElementClickable(Driver, SensorPageUI.DELETE_BUTTON);
		clickToElement(Driver, SensorPageUI.DELETE_BUTTON);
	}

	public boolean isDeletePopupIsDisplayed() {
		waitForElementVisible(Driver, SensorPageUI.POPUP_DELETE);
		return isElementDisplayed(Driver, SensorPageUI.POPUP_DELETE);
	}

	public void clickToDeleteConfirmPopup() {
		waitForElementClickable(Driver, SensorPageUI.OK_BUTTON_IN_DELETE_POPUP);
		clickToElement(Driver, SensorPageUI.OK_BUTTON_IN_DELETE_POPUP);
	}

	public boolean isDeleteSuccessPopupIsDisplayed() {
		waitForElementVisible(Driver, SensorPageUI.SUCCESS_DELETE_POPUP);
		return isElementDisplayed(Driver, SensorPageUI.SUCCESS_DELETE_POPUP);
	}

	public void clickToOKDeleteSuccessPopup() {
		waitForElementClickable(Driver, SensorPageUI.OK_BUTTON_IN_SUCCESS_DELETE_POPUP);
		clickToElement(Driver, SensorPageUI.OK_BUTTON_IN_SUCCESS_DELETE_POPUP);
	}

	public void clickToCancelButtonFilter() {
		waitForElementClickable(Driver, SensorPageUI.CANCEL_IN_FILTER);
		clickToElement(Driver, SensorPageUI.CANCEL_IN_FILTER);
	}

	public boolean isNullDataIsDisplay() {
		waitForElementVisible(Driver, SensorPageUI.NULL_DATA);
		return isElementDisplayed(Driver, SensorPageUI.NULL_DATA);
	}

	public boolean isLineOfSensorUpdateIsDisplay(String sensorNameUpdate) {
		waitForElementVisible(Driver,SensorPageUI.LINE_SENSOR_FOCUS, sensorNameUpdate);
		return isElementDisplayed(Driver, SensorPageUI.LINE_SENSOR_FOCUS, sensorNameUpdate);
	}

	public PropertyPageObject clickToPropertyLink() {
		waitForElementClickable(Driver, SensorPageUI.PROPERTY_LINK);
		clickToElement(Driver, SensorPageUI.PROPERTY_LINK);
		return PageGeneratorManager.getPropertyPage(Driver);
	}
	
	

}
