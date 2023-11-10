package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.LoginPageObject;
import pageObjects.facebook.PageGeneratorManager;



public class Level_13_Element_Undisplayed extends BaseTest {
	private LoginPageObject loginPage;
		
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
	}
	
	@Test
	public void TC_01_Verify_Element_Display() {
		loginPage.clickToCreateNewAccountButton();
		verifyTrue(loginPage.isEmailAddressTextboxDisplayed());
	}
	
	@Test
	public void TC_02_Verify_Element_Undisplay_In_DOM() {
		//Verify True - mong đợi Comfirm Email displayed (true)
		loginPage.enterToEmailAddressTextbox("automation@gmail.com");
		loginPage.sleepInSecond(2);
		verifyTrue(loginPage.isConfirmEmailAddressTextboxDisplayed());
		
		//Verify False - mong đợi Confirm Email Undisplayed (False)
		loginPage.enterToEmailAddressTextbox("");
		loginPage.sleepInSecond(3);
//		verifyFalse(loginPage.isConfirmEmailAddressTextboxDisplayed());
		verifyTrue(loginPage.isConfirmEmailAddressTextboxUnDisplayed());
		
	}
	
	@Test
	public void TC_03_Verify_Element_Undisplay_Not_In_DOM() {
		loginPage.clickToCloseIconAtRegisterForm();
		loginPage.sleepInSecond(3);
		verifyTrue(loginPage.isConfirmEmailAddressTextboxUnDisplayed());
	}
	
	
	
		
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	private WebDriver driver;
	
	
}
