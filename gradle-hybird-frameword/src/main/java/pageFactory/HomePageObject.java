package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import pageUI.nopCommerce.user.HomePageUI;

public class HomePageObject extends BasePageFactory {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Page UI
	@FindBy(how = How.XPATH, using = "//a[@class='ico-register']")
	private WebElement registerLink;
	
	@FindBy(xpath = "//a[@class='ico-login']")
	private WebElement loginLink;
	
	@FindBy(css = "a[@class='ico-account']")
	private WebDriver myAccountLink;
	
	//Page Object/Action
	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, registerLink);
		clickToElement(driver, registerLink);
		return new RegisterPageObject(driver);
	}
	
	public LoginPageObject clickLoginLink() {
		waitForElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);	
		return new LoginPageObject(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, loginLink);
		return isElementDisplayed(driver, loginLink);
	}
}
