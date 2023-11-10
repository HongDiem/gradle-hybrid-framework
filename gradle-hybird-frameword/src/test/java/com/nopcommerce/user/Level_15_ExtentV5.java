package com.nopcommerce.user;

import java.lang.reflect.Method;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import reportConfig.ExtentTestManager;

public class Level_15_ExtentV5 extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	
	
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
	public void User_01_Register(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register to system with valid Email and Password");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.openRegisterLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Enter to Firstname textbox with value is '" + fisrtName + "'");
		registerPage.inputToFirstnameTextbox(fisrtName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Enter to Lastname textbox with value is '" + lastName + "'");
		registerPage.inputToLastnameTextbox(lastName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Enter to Email textbox with value is '" + emailAddress + "'");
		registerPage.inputToEmailTextbox(emailAddress);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Enter to Password textbox with value is '" + validPassword + "'");		
		registerPage.inputToPasswordTextbox(validPassword);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Enter to ConfirmPassword textbox with value is '" + validPassword + "'");
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Click to 'Register' button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 08: Verify register success message is displayed");
		Assert.assertEquals(registerPage.getRegisterSucessMessage(), "Your registration completed");
	}
	
	@Test
	public void User_02_Login(Method method) {
		loginPage = homePage.openLoginPage();		
		ExtentTestManager.startTest(method.getName(), "Login to system successfully");
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Navigate to Login page");
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Enter to Email textbox with value is '" + emailAddress + "'");
		loginPage.inputToEmailTextbox(emailAddress);
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Enter to Password textbox with value is '" + validPassword + "'");
		loginPage.inputToPasswordTextbox(validPassword);
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click to Login button");
		homePage = loginPage.clickToLoginButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Verify 'My Account' link is displayed");
		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
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