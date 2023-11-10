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
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_04_Multiple_Browser extends BaseTest{
	private WebDriver driverTestClass;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage; 
	
	
	private String emailAddress, lastName, fisrtName, password;	
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driverTestClass = getBrowserDriver(browserName);
		driverTestClass.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driverTestClass.get("https://demo.nopcommerce.com/");
		homePage =  new UserHomePageObject(driverTestClass);
		
		fisrtName = "Automation"; 
		lastName = "FC";
		password = "123456";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.com";
		
		
	}
	
	@Test
	public void TC_01_Register_Empty_Data() {
		System.out.println("Register_01 - Step 01:Click to Register link");
		homePage.openRegisterLink();
		registerPage = new UserRegisterPageObject(driverTestClass);
		
		System.out.println("Register_01 - Step 02: Click to Register button");
		registerPage.clickToRegisterButton();
		registerPage = new UserRegisterPageObject(driverTestClass);
		
		System.out.println("Register Page - Step 03: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTextbox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastnameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(),"Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");	
	}
	
	@Test
	public void TC_02_Register_Invalid_Email() {
		System.out.println("Register_02 - Step 01:Click to Register link");
		homePage.openRegisterLink();
		
		registerPage = new UserRegisterPageObject(driverTestClass);
		
		System.out.println("Register_02 -Step 02: Input to requied fields");
		registerPage.inputToFirstnameTextbox(fisrtName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox("1254");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		
		System.out.println("Register_02 -Step 03: Click to Register button");
		registerPage.clickToRegisterButton();
		
		
		System.out.println("Register_02 - Step 04: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}
	
	@Test
	public void TC_03_Register_Success() {
		System.out.println("Register_03 - Step 01:Click to Register link");
		homePage.openRegisterLink();
		
		registerPage = new UserRegisterPageObject(driverTestClass);
				
		System.out.println("Register_03 -Step 02: Input to requied fields");
		
		registerPage.inputToFirstnameTextbox(fisrtName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		
		System.out.println("Register_03 -Step 03: Click to Register button");
		registerPage.clickToRegisterButton();
		
		
		System.out.println("Register_03 - Step 04: Verify error message displayed");
		registerPage.getRegisterSucessMessage();
		Assert.assertEquals(registerPage.getRegisterSucessMessage(), "Your registration completed");		
	}
	
	@Test
	public void TC_04_Register_Existing_Email() {
		System.out.println("Register_04 - Step 01:Click to Register link");
		homePage.openRegisterLink();
		
		registerPage = new UserRegisterPageObject(driverTestClass);
		
		System.out.println("Register Page -Step 02: Input to requied fields");
		registerPage.inputToFirstnameTextbox(fisrtName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		
		System.out.println("Register_04 -Step 03: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_04 - Step 04: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");
	}
	
	@Test
	public void TC_05_Register_Password_Less_Than_6_Chars() {		
		System.out.println("Register_05 - Step 01:Click to Register link");
		homePage.openRegisterLink();
		
		registerPage = new UserRegisterPageObject(driverTestClass);
		
		System.out.println("Register_05 -Step 02: Input to requied fields");
		
		registerPage.inputToFirstnameTextbox(fisrtName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox("123");
		registerPage.inputToConfirmPasswordTextbox(password);
		
		System.out.println("Register_05 -Step 03: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_05 - Step 04: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");
		
	}
	
	@Test
	public void TC_06_Register_Invalid_Confirm_Password() {		
		System.out.println("Register_06 - Step 01:Click to Register link");
		homePage.openRegisterLink();
		
		registerPage = new UserRegisterPageObject(driverTestClass);
		
		System.out.println("Register_06 -Step 02: Input to requied fields");
		registerPage.inputToFirstnameTextbox(fisrtName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox("123045");
		

		
		System.out.println("Register_06 -Step 03: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_06 - Step 04: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(),"The password and confirmation password do not match.");
	}
	
	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
	
	@AfterClass
	public void afterClass() {
		driverTestClass.quit();
	}
	
	
}