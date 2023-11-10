package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Level_09_Dynamic_Locator extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;  
	private UserAddressPageObject addressPage;
	private UserRewardPointPageObject rewardPointPage;
	private UserMyProductReviewPageObject myProductReviewPage;
	
	private String emailAddress, lastName, fisrtName, validPassword;	
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage =  PageGeneratorManager.getUserHomePage(driver);
		
		fisrtName = "Automation"; 
		lastName = "FC";
		validPassword = "123456";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.com";
	}
	
	@Test
	public void User_01_Register_Login() {
		registerPage = homePage.openRegisterLink();
		registerPage.inputToFirstnameTextbox(fisrtName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSucessMessage(), "Your registration completed");

		loginPage = homePage.openLoginPage();		
		
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(validPassword);
		
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	
		customerInforPage = homePage.openMyAccountPage();
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());
		
	}
	
	@Test
	public void User_02_Dynamic_Page() {
		//Customer Infor -> Address
		addressPage = customerInforPage.openAddressPage(driver);
		
		//Address -> My Product Review
		myProductReviewPage = addressPage.openMyProductReviewPage(driver);
		
		//My Product Review -> Reward Point
		rewardPointPage = myProductReviewPage.openRewardPointPage(driver);
		
		//Reward Point -> Address
		addressPage = rewardPointPage.openAddressPage(driver);
		
		//Address -> Reward Point
		rewardPointPage = addressPage.openRewardPointPage(driver);
		
		//Reward Point -> My Product Review
		myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);
	}
	
	@Test
	public void User_03_Dynamic_Page_01() {
		//My Product Review -> Reward Point
		rewardPointPage = (UserRewardPointPageObject) myProductReviewPage.openPageAtMyAccountByName(driver, "Reward points");
		
		//Reward Point -> Address
		addressPage = (UserAddressPageObject) rewardPointPage.openPageAtMyAccountByName(driver, "Addresses");
		
		//Address -> Reward Point
		rewardPointPage = (UserRewardPointPageObject) addressPage.openPageAtMyAccountByName(driver, "Reward points");
		
		//Reward Point -> My Product Review
		myProductReviewPage = (UserMyProductReviewPageObject) rewardPointPage.openPageAtMyAccountByName(driver, "My product reviews");
		
		//My Product Review -> Address
		addressPage = (UserAddressPageObject) myProductReviewPage.openPageAtMyAccountByName(driver, "Addresses");
		
		customerInforPage = (UserCustomerInforPageObject) addressPage.openPageAtMyAccountByName(driver, "Customer info");
	}
	
	@Test
	public void User_03_Dynamic_Page_02() {
		customerInforPage.openPageAtMyAccountByPageName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);
		
		//My Product Review -> Reward Point
		myProductReviewPage.openPageAtMyAccountByPageName(driver, "Reward points");
		rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);
		
		//Reward Point -> Address
		rewardPointPage.openPageAtMyAccountByPageName(driver, "Addresses");
		addressPage = PageGeneratorManager.getUserAddressPage(driver);
		
		//Address -> Reward Point
		addressPage.openPageAtMyAccountByPageName(driver, "Reward points");
		rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);
		
		
	}
	
		
	
	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	
}