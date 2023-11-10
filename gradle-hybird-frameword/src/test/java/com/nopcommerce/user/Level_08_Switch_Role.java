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
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;


public class Level_08_Switch_Role extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private AdminLoginPageObject adminLoginPage;  
	private UserLoginPageObject userloginPage;
	private UserCustomerInforPageObject userCustomerInforPage;
	private AdminDashboardPageObject adminDashboardPage;
	private String userEmailAddress, userPassword, adminEmailAddress, adminPassword;	
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		userHomePage =  PageGeneratorManager.getUserHomePage(driver);
		
		userPassword = "123456";
		userEmailAddress = "diem123@gmail.com";
		adminEmailAddress = "admin@yourstore.com";
		adminPassword = "admin";
	}
	
	@Test
	public void Role_01_User_To_Admin() {
		userloginPage = userHomePage.openLoginPage();		
		// Login as User role
		userHomePage = userloginPage.loginAsUser(userEmailAddress,userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
		// Home Page -> Customer Infor
		userCustomerInforPage = userHomePage.openMyAccountPage();
		//Customer Infor click Logout -> Home Page
		userHomePage = userCustomerInforPage.clickToLogoutLinkAtUserPage(driver);
		//User Home Page -> Open Admin page -> Login Page Admin
		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
	    adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
		Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplay());
		
		//Dashboard Page -> Click log out -> Login Page Admin
		
		adminDashboardPage.clickToLogoutLinkAtADminPage(driver);
	}
	
	@Test
	public void Role_02_Admin_To_User() {
		//Login Page ADmin -> Open User URL -> Home Page (User)
		adminLoginPage.openPageUrl(driver, GlobalConstants.PORTAL_PAGE_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		
		userloginPage = userHomePage.openLoginPage();
		
		userHomePage = userloginPage.loginAsUser(userEmailAddress,userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
	}
	
		
	@Test
	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	
}