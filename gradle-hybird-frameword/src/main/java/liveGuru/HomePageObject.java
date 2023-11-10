package liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import liveGuruUI.HomePageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAccLink() {
		waitForElementClickable(driver, HomePageUI.ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.ACCOUNT_LINK);
	}

	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public ProductPageObject clickToMobileLink() {
		waitForElementClickable(driver, HomePageUI.MOBILE_LINK);
		clickToElement(driver, HomePageUI.MOBILE_LINK);
		return PageGeneratorManager.getProductPage(driver);
	}

	public ProductPageObject clickToTVLink() {
		waitForElementVisible(driver, HomePageUI.TV_LINK);
		clickToElement(driver, HomePageUI.TV_LINK);
		return PageGeneratorManager.getProductPage(driver);
	}

	public ProductPageObject clickToAdvanceSearchLink() {
		waitForElementVisible(driver, HomePageUI.ADVANCED_SEARCH_LINK);
		clickToElement(driver, HomePageUI.ADVANCED_SEARCH_LINK);
		return PageGeneratorManager.getProductPage(driver);
	}

	
	
	
	

}
