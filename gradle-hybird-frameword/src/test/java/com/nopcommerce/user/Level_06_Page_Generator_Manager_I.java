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
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_06_Page_Generator_Manager_I extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	
	private String existingEmail, notFoundEmail, invalidEmail, lastName, fisrtName, validPassword, invalidPassword;	
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage =  new UserHomePageObject(driver);
		
		fisrtName = "Automation"; 
		lastName = "FC";
		validPassword = "123456";
		invalidPassword = "654278";
		existingEmail = "afc" + generateFakeNumber() + "@gmail.com";
		notFoundEmail = "afc" + generateFakeNumber() + "@mail.com";
		invalidEmail = "afc125@gmail.com@.vn";
		
		
		System.out.println("Pre-Conditon - Step 01: Click to Register link");
		homePage.openRegisterLink();
		registerPage = new UserRegisterPageObject(driver);
		
		System.out.println("Pre-Condition - Step 01: Input to requird fields");
		registerPage.inputToFirstnameTextbox(fisrtName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(existingEmail);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		
		System.out.println("Register_03 -Step 03: Click to Register button");
		registerPage.clickToRegisterButton();
		
		
		System.out.println("Register_03 - Step 04: Verify error message displayed");
		registerPage.getRegisterSucessMessage();
		Assert.assertEquals(registerPage.getRegisterSucessMessage(), "Your registration completed");
		
//		System.out.println("Pre-Conditon - Step 05: Click to Logout link");
//		registerPage.clickToLogoutLink();
//		
//		//Click Logout thì nó sẽ quay về trang HomePage
//		homePage = new HomePageObject(driver);
	}
	
	@Test
	public void Login_01_Empty_Data() {
		homePage.clickLoginLink();
		
		//Từ trang Hom - Click Login Link -> Qa trang Login
		loginPage = new UserLoginPageObject(driver);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}
	
	@Test
	public void Login_02_Invalid_Email() {
		homePage.clickLoginLink();
		
		//Từ trang Hom - Click Login Link -> Qa trang Login
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailTextbox(invalidEmail);
		
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
		
	}
	
	@Test
	public void Login_03_Email_Not_Found() {
		homePage.clickLoginLink();
		
		//Từ trang Hom - Click Login Link -> Qa trang Login
		loginPage.inputToEmailTextbox(notFoundEmail);
		
		loginPage.clickToLoginButton();	
		
		Assert.assertEquals(loginPage.getErrorMassageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}
	
	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		homePage.clickLoginLink();
		
		//Từ trang Hom - Click Login Link -> Qa trang Login
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox("");
		
		loginPage.clickToLoginButton();	
		
		Assert.assertEquals(loginPage.getErrorMassageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	
	@Test
	public void Login_05_Existing_Empty_Incorrect_Password() {	
		homePage.clickLoginLink();
		
		//Từ trang Hom - Click Login Link -> Qa trang Login
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(invalidPassword);
		
		loginPage.clickToLoginButton();	

		Assert.assertEquals(loginPage.getErrorMassageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
		
	}
	
	@Test
	public void Login_06_Valid_Email_Password() {
		homePage.clickLoginLink();
		
		//Từ trang Hom - Click Login Link -> Qa trang Login
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(validPassword);
		
		loginPage.clickToLoginButton();
		
		//Login thành công -> HomePage
		homePage = new UserHomePageObject(driver);
		
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
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