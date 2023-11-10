package com.saurcelab.sort;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.sauceLab.LoginPageObject;
import pageObjects.sauceLab.PageGeneratorManager;
import pageObjects.sauceLab.ProductPageObject;



public class Level_19_Sort_Asc_Desc extends BaseTest {
	
	@Parameters({"browser","appUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String saucelabUrl) {
		driver = getBrowserDriver(browserName, saucelabUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		loginPage.enterToUserNameTextbox("standard_user");
		loginPage.enterToPasswordTextbox("secret_sauce");
		productPage = loginPage.clickToLoginButton();
	}
	
	@Test
	public void Sort_01_Name() {
		//Ascending
		productPage.selectItemInProductSortDropdown("Name (A to Z)");
		productPage.sleepInSecond(3);
		
		Assert.assertTrue(productPage.isProductSortByAscending());
		//Descending
		productPage.selectItemInProductSortDropdown("Name (Z to A)");
		productPage.sleepInSecond(3);
		Assert.assertTrue(productPage.isProductSortByDescending());
	}
	
	@Test
	public void Sort_02_Price() {
		//Ascending
		productPage.selectItemInProductSortDropdown("Price (low to high)");
		Assert.assertTrue(productPage.isPriceSortByAscending());
				
		//Descending
		productPage.selectItemInProductSortDropdown("Price (high to low)");
		Assert.assertTrue(productPage.isPriceSortByDescending());
	}
	
	

	
	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
	
	WebDriver driver;
	LoginPageObject loginPage;
	ProductPageObject productPage;
	
}