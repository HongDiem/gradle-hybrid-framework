package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.nopCommerce.user.DesktopPageUI;


public class UserDesktopPageObject extends BasePage{
	WebDriver driver;

	public UserDesktopPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToBuildyourownLink() {
		waitForElementClickable(driver, DesktopPageUI.BUILD_YOUR_OWN_COMPUTER);
		clickToElement(driver, DesktopPageUI.BUILD_YOUR_OWN_COMPUTER);
	}

	public void clickToAddToCart() {
		waitForElementClickable(driver, DesktopPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, DesktopPageUI.ADD_TO_CART_BUTTON);
	}

	public void selectItemInDropdown(String nameItem) {
		waitForElementClickable(driver, DesktopPageUI.RAM_VALUE);
		selectItemInDefaultDropdown(driver, DesktopPageUI.RAM_VALUE, nameItem);
		
	}

	public void selectHDDValue() {
		waitForElementClickable(driver, DesktopPageUI.HDD_VALUE);
		clickToElement(driver, DesktopPageUI.HDD_VALUE);
	}

	public String getOrderSucessMessage() {
		waitForElementClickable(driver, DesktopPageUI.ORDER_SUCCESS);
		return getElementText(driver, DesktopPageUI.ORDER_SUCCESS);
	}

	public void clickToClose() {
		waitForElementClickable(driver, DesktopPageUI.CLOSE_ICON);
		clickToElement(driver, DesktopPageUI.CLOSE_ICON);
	}

	public void hoverMouseToElementCart() {
		waitForElementClickable(driver, DesktopPageUI.CART_ICON);
		hoverMouseToElement(driver, DesktopPageUI.CART_ICON);
	}

	public String getOrderCartSucessMessage() {
		waitForElementClickable(driver, DesktopPageUI.ORDER_CART_SUCCESS);
		return getElementText(driver, DesktopPageUI.ORDER_CART_SUCCESS);
	}

	public void clickToCart() {
		waitForElementClickable(driver, DesktopPageUI.CART_ICON);
		clickToElement(driver, DesktopPageUI.CART_ICON);
	}

	public void clickToEdit() {
		waitForElementClickable(driver, DesktopPageUI.EDIT_LINK);
		clickToElement(driver, DesktopPageUI.EDIT_LINK);
	}

	public void selectItemInProcessor(String value) {
		waitForElementClickable(driver, DesktopPageUI.PROCESSOR);
		selectItemInDefaultDropdown(driver, DesktopPageUI.PROCESSOR, value);		
	}

	public void selectOSValue() {
		waitForElementClickable(driver, DesktopPageUI.OS_VALUE);
		clickToElement(driver, DesktopPageUI.OS_VALUE);
	}

	public void clickToUpdate() {
		waitForElementClickable(driver, DesktopPageUI.UPDATE_BUTTON);
		clickToElement(driver, DesktopPageUI.UPDATE_BUTTON);
	}
	
}
