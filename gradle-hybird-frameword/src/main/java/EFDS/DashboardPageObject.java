package EFDS;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class DashboardPageObject extends BasePage{
	private WebDriver driver;

	public DashboardPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public RegionalPageObject clickToRegionalLabel() {
		waitForElementClickable(driver, DashboardUI.REGIONAL_LABEL);
		clickToElement(driver, DashboardUI.REGIONAL_LABEL);
		return PageGeneratorManager.getRegionalPage(driver);
	}

	public void clickToDetailLink() {
		waitForElementClickable(driver, DashboardUI.DETAIL_LINK);
		clickToElement(driver, DashboardUI.DETAIL_LINK);
	}
	
	

}
