package com.techpanda;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import techPanda.AdminHomePageObject;
import techPanda.RegisterPageObject;


public class Level_10_DataTable_DataGrid extends BaseTest {
	private WebDriver driver;
	private RegisterPageObject registerPage;
	private AdminHomePageObject adminHomePage;
	private techPanda.AdminLoginPageObject adminloginPage;
	private String fisrtName, lastName, emailAddress, password, emailAdmin, passwordAdmin;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://live.techpanda.org/index.php/customer/account/create/");
		registerPage =  techPanda.PageGeneratorManager.getRegisterPage(driver);
		
		fisrtName = "Automation"; 
		lastName = "FC";
		password = "123456";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.com";
		emailAdmin = "user01";
		passwordAdmin = "guru99com";
		
	}
	
	@Test
	public void Role_01_User_To_Admin() {
		//Register Account
		registerPage.inputToFirstnameTextbox(fisrtName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSucessMessage(), "Thank you for registering with Main Website Store.");
		
		
		//User Home Page -> Open Admin page -> Login Page Admin
		registerPage.openPageUrl(driver, techPanda.GlobalConstants.ADMIN_PAGE_URL);
		adminloginPage = techPanda.PageGeneratorManager.getAdminLoginPage(driver);

	    adminloginPage.inputToUsernameTexbox(emailAdmin);
		adminloginPage.inputToPasswordTexbox(passwordAdmin);
		adminloginPage.clickToLoginButton();
		adminloginPage.sleepInSecond(3);
		
		adminHomePage = techPanda.PageGeneratorManager.getAdminHomePage(driver);
		adminHomePage.clickToClosePopup();
		//Verify
		adminHomePage.enterToTextboxAtRowNumberByColumnName("Email", emailAddress);
		adminHomePage.clickToSearchButton();
		
		Assert.assertTrue(adminHomePage.isDisplayedValue(fisrtName, emailAddress));
	}
	

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}
	
	
}