package pageObjects.jQuery.uploadFile;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isFileLoadedByName(String fileName) {
		waitForElementVisible(driver, pageUIs.jQuert.uploadFile.HomePageUI.FILE_NAME_LOADED, fileName);
		return isElementDisplayed(driver, pageUIs.jQuert.uploadFile.HomePageUI.FILE_NAME_LOADED, fileName);
	}

	public void clickToStartButton() {
		List<WebElement> startButtons =  getListWebElement(driver, pageUIs.jQuert.uploadFile.HomePageUI.START_BUTTON);
			for (WebElement startButton : startButtons) {
				startButton.click();
				sleepInSecond(2);
			}
		}

	public boolean isFileLinkUpLoadedByName(String fileName) {
		waitForElementVisible(driver, pageUIs.jQuert.uploadFile.HomePageUI.FILE_NAME_UPLOADED_LINK, fileName);
		return isElementDisplayed(driver, pageUIs.jQuert.uploadFile.HomePageUI.FILE_NAME_UPLOADED_LINK, fileName);
	}

	

	public boolean isFileImageUpLoadedByName(String fileName) {
		waitForElementVisible(driver, pageUIs.jQuert.uploadFile.HomePageUI.FILE_NAME_UPLOADED_IMAGE, fileName);
		return isImageLoaded(driver, pageUIs.jQuert.uploadFile.HomePageUI.FILE_NAME_UPLOADED_IMAGE, fileName);
	}
	
}
