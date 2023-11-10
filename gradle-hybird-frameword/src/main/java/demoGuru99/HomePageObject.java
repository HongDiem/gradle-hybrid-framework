package demoGuru99;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import demoGuru99UI.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isNewCustomerDisplayed() {
		waitForElementVisible(driver, HomePageUI.NEW_CUSTOMER_LINK);
		return isElementDisplayed(driver, HomePageUI.NEW_CUSTOMER_LINK);
	}

	public NewCustomerPageObject clickToNewCustomerLink() {
		waitForElementClickable(driver, HomePageUI.NEW_CUSTOMER_LINK);
		clickToElement(driver, HomePageUI.NEW_CUSTOMER_LINK);
		return PageGeneratorManager.getNewCustomPage(driver);
	}

	

}
