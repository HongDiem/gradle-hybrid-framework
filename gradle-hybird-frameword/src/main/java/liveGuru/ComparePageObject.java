package liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import liveGuruUI.ComparePageUI;

public class ComparePageObject extends BasePage{
	private WebDriver driver;

	public ComparePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDisplayedFirstProduct() {
		waitForAllElementVisible(driver, ComparePageUI.FIRST_PRODUCT_DISPLAYED);
		return isElementDisplayed(driver, ComparePageUI.FIRST_PRODUCT_DISPLAYED);
	}

	public boolean isDisplayedSecondProduct() {
		waitForAllElementVisible(driver, ComparePageUI.SECOND_PRODUCT_DISPLAYED);
		return isElementDisplayed(driver, ComparePageUI.SECOND_PRODUCT_DISPLAYED);
	}

	public void clickToClose() {
		waitForElementVisible(driver, ComparePageUI.CLOSE_BUTTON);
		clickToElement(driver, ComparePageUI.CLOSE_BUTTON);
	}

	public void scrollToCloseButton() {
		waitForElementVisible(driver, ComparePageUI.CLOSE_BUTTON);
		scrollToElement(driver, ComparePageUI.CLOSE_BUTTON);
	}

	

	
	
	
	

}
