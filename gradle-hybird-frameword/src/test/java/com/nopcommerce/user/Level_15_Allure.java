package com.nopcommerce.user;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import commons.BaseTest;
import commons.PageGeneratorManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import reportConfig.AllureTestListener;

@Listeners(AllureTestListener.class)
public class Level_15_Allure extends BaseTest {
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
	
	@Description("Register to system")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void User_01_Register() {
		registerPage = homePage.openRegisterLink();
		
		registerPage.inputToFirstnameTextbox(fisrtName);
		
		registerPage.inputToLastnameTextbox(lastName);
		
		registerPage.inputToEmailTextbox(emailAddress);
		
		registerPage.inputToPasswordTextbox(validPassword);
		
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getRegisterSucessMessage(), "Your registration completed");
	}
	
	@Description("Login to system")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void User_02_Login() {
		loginPage = homePage.openLoginPage();		
		
		loginPage.inputToEmailTextbox(emailAddress);
				
		loginPage.inputToPasswordTextbox(validPassword);
				
		homePage = loginPage.clickToLoginButton();
				
		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
		
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	
}