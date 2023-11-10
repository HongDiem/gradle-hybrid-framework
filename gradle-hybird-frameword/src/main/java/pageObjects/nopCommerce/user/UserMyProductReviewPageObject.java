package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUI.nopCommerce.user.HomePageUI;


public class UserMyProductReviewPageObject extends BasePage {
	private WebDriver driver;
	
	public UserMyProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}
		
	 
	public UserRegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);	
//		return new RegisterPageObject(driver);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}


	public UserLoginPageObject clickLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);	
		//2
//		return new LoginPageObject(driver);
		
		//3
		return PageGeneratorManager.getUserLoginPage(driver);
	}



	

	public boolean isMyAccountLinkDisplayed() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
	}


	public UserCustomerInforPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInforPage(driver);
	}


	
	

	

}
