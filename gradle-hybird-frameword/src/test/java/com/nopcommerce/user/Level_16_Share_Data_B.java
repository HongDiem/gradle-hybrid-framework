package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;


public class Level_16_Share_Data_B extends BaseTest {
	

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);		
		
		fisrtName = "Automation"; 
		lastName = "FC";
		validPassword = "123456";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.com";
		
		log.info("Pre-Conditon - Step 01: Navigate to 'Register' page");
		registerPage = homePage.openRegisterLink();
		
		log.info("Pre-Conditon - Step 02: Enter to Firstname textbox with value is '" + fisrtName + "'");
		registerPage.inputToFirstnameTextbox(fisrtName);
		
		log.info("Pre-Conditon - Step 03: Enter to LastName textbox with value is '" + lastName + "'");
		registerPage.inputToLastnameTextbox(lastName);
		
		log.info("Pre-Conditon - Step 04: Enter to EmailAddress textbox with value is '" + emailAddress + "'");
		registerPage.inputToEmailTextbox(emailAddress);
		
		log.info("Pre-Conditon - Step 05: Enter to Password textbox with value is '" + validPassword + "'");
		registerPage.inputToPasswordTextbox(validPassword);
		
		log.info("Pre-Conditon - Step 06: Enter to ConfirmPassword textbox with value is '" + validPassword + "'");
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		
		log.info("Pre-Conditon - Step 07: Click to 'Register' button");
		registerPage.clickToRegisterButton();
		
		verifyEquals(registerPage.getRegisterSucessMessage(), "Your registration completed.");

		loginPage = homePage.openLoginPage();		
		
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(validPassword);
		
		homePage = loginPage.clickToLoginButton();
		verifyFalse(homePage.isMyAccountLinkDisplayed());
		
	}

	@Test
	public void Search_01_Empty_Data() {
		
	}

	@Test
	public void Search_02_Relative_Product_Name() {
		
	}


	@Test
	public void Search_03_Absolute_Product_Name() {
		
	}
	
	@Test
	public void Search_04_Parent_Category() {
		
	}
	
	@Test
	public void Search_05_Incorrect_Manufactorer() {
		
	}
	
	@Test
	public void Search_05_Correct_Manufactorer() {
		
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	private String emailAddress, lastName, fisrtName, validPassword;
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;

}