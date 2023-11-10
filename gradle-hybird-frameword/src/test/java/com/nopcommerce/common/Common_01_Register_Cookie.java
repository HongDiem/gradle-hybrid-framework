package com.nopcommerce.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Common_01_Register_Cookie extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private String lastName, fisrtName, emailAddress, password;	
	
		
	@Parameters("browser")
	@BeforeTest(description = "Create new Common User for all Classes Test")
	public void User_01_Register(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		fisrtName = "Automation"; 
		lastName = "FC";
		password = "123456";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.com";
		
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
		
		verifyEquals(registerPage.getRegisterSucessMessage(), "Your registration completed.");
		
		driver.quit();
	}
	
	
		
	
			
	
	
	
}