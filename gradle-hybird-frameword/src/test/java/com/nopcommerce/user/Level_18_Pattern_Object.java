package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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


public class Level_18_Pattern_Object extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	
	
	
	private String emailAddress, lastName, fisrtName, validPassword;
	private String date, month, year;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage =  PageGeneratorManager.getUserHomePage(driver);
		
		fisrtName = "Automation"; 
		lastName = "FC";
		validPassword = "123456";
		date = "10";
		month = "August";
		year = "1995";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.com";
	}
	
	@Test
	public void User_01_Register() {
		log.info("Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.openRegisterLink();
		
		registerPage.clickToRadioButtonByLabel(driver, "Female");
		
		log.info("Register - Step 02: Enter to Firstname textbox with value is '" + fisrtName + "'");
		registerPage.inputToTextboxByID(driver, "FirstName", fisrtName);
		
		log.info("Register - Step 03: Enter to LastName textbox with value is '" + lastName + "'");
		registerPage.inputToTextboxByID(driver, "LastName", lastName);
		
		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", date);
		
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", month);
	
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", year);
		
		log.info("Register - Step 04: Enter to EmailAddress textbox with value is '" + emailAddress + "'");
		registerPage.inputToTextboxByID(driver, "Email", emailAddress);
		
		registerPage.clickToCheckboxByLabel(driver, "Newsletter");
		
		log.info("Register - Step 05: Enter to Password textbox with value is '" + validPassword + "'");
		registerPage.inputToTextboxByID(driver, "Password", validPassword);
		
		log.info("Register - Step 06: Enter to ConfirmPassword textbox with value is '" + validPassword + "'");
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", validPassword);
		
		log.info("Register - Step 07: Click to 'Register' button");
		registerPage.clickToButtonByText(driver, "Register");
		
		log.info("Register - Step 08: Verify register success message is displayed");
		verifyEquals(registerPage.getRegisterSucessMessage(), "Your registration completed");
		
	}
	
	@Test
	public void User_02_Login() {
		log.info("Login - Step 01: Navigate to Login page");
		loginPage = homePage.openLoginPage();		
		
		log.info("Login - Step 02: Enter to Email textbox with value is '" + emailAddress + "'");
		loginPage.inputToTextboxByID(driver, "Email", emailAddress);
		
		log.info("Login - Step 03: Enter to Password textbox with value is '" + validPassword + "'");
		loginPage.inputToTextboxByID(driver, "Password", validPassword);
		
		log.info("Login - Step 04: Click to Login button");
		loginPage.clickToButtonByText(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Login - Step 05: Verify 'My Account' link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());		
	}
	
	@Test
	public void User_03_My_Acount() {
		log.info("My Account - Step 01: Navigate to 'My Account' page");
		customerInforPage = homePage.openMyAccountPage();
		
		log.info("My Account - Step 02: Verify 'Customer Infor' page is displayed");
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());
		
		log.info("My Account - Step 03: Verify 'FirstName' value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxValueById(driver,"FirstName"), fisrtName);
		
//		log.info("My Account - Step 04: Verify 'LastName' value is correctly");
//		Assert.assertEquals(customerInforPage.getTextboxValueById(driver,"LastName"), fisrtName);
//		
//		log.info("My Account - Step 05: Verify 'Email' value is correctly");
	}

	
	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
	
	
}