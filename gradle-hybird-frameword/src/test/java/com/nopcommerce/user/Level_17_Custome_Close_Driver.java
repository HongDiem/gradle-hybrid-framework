package com.nopcommerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_17_Custome_Close_Driver extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;  
	private String emailAddress, lastName, fisrtName, password;	
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage =  PageGeneratorManager.getUserHomePage(driver);
		
		fisrtName = "Automation"; 
		lastName = "FC";
		password = "123456";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.com";
	}
	
	@Test
	public void User_01_Register() {
		log.info("Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.openRegisterLink();
		
		log.info("Register - Step 02: Enter to Firstname textbox with value is '" + fisrtName + "'");
		registerPage.inputToFirstnameTextbox(fisrtName);
		
		log.info("Register - Step 03: Enter to LastName textbox with value is '" + lastName + "'");
		registerPage.inputToLastnameTextbox(lastName);
		
		log.info("Register - Step 04: Enter to EmailAddress textbox with value is '" + emailAddress + "'");
		registerPage.inputToEmailTextbox(emailAddress);
		
		log.info("Register - Step 05: Enter to Password textbox with value is '" + password + "'");
		registerPage.inputToPasswordTextbox(password);
		
		log.info("Register - Step 06: Enter to ConfirmPassword textbox with value is '" + password + "'");
		registerPage.inputToConfirmPasswordTextbox(password);
		
		log.info("Register - Step 07: Click to 'Register' button");
		registerPage.clickToRegisterButton();
		
		log.info("Register - Step 08: Verify register success message is displayed");
		verifyEquals(registerPage.getRegisterSucessMessage(), "Your registration completed..");
		
		log.info("Register - Step 09: Click to Logout Link");
		homePage = registerPage.clickToLogoutLinkAtUserPage(driver);
				
	}
	
	@Test
	public void User_02_Login() {
		log.info("Login - Step 01: Navigate to Login page");
		loginPage = homePage.openLoginPage();		
		
		log.info("Login - Step 02: Enter to Email textbox with value is '" + emailAddress + "'");
		loginPage.inputToEmailTextbox(emailAddress);
		
		log.info("Login - Step 03: Enter to Password textbox with value is '" + password + "'");
		loginPage.inputToPasswordTextbox(password);
		
		log.info("Login - Step 04: Click to Login button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Login - Step 05: Verify 'My Account' link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
	
		log.info("Login - Step 06: Navigate to 'My Account' page");
		customerInforPage = homePage.openMyAccountPage();
		
		log.info("Login - Step 07: Verify 'Customer Infor' page is displayed");
		verifyFalse(customerInforPage.isCustomerInforPageDisplayed());
		
	}
	
	
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
	
	
}