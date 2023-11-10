package com.nopcommerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserDesktopPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;

public class Test_Order_18102023 extends BaseTest{
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserDesktopPageObject desktopPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage =  PageGeneratorManager.getUserHomePage(driver);
	}
	
	@Test
	public void User_01_Add_Order() {
		desktopPage = homePage.openDesktopPage();
		
		desktopPage.clickToBuildyourownLink();	
		
		desktopPage.selectHDDValue();
		
		desktopPage.selectItemInDropdown("2 GB");
		
		desktopPage.clickToAddToCart();
				
		Assert.assertEquals(desktopPage.getOrderSucessMessage(), "The product has been added to your shopping cart");
		
		desktopPage.clickToClose();
	}
	
	@Test
	public void User_02_Edit_Order() {
		desktopPage.clickToCart();	   
		
		desktopPage.clickToEdit();
		
		desktopPage.selectItemInProcessor("2.2 GHz Intel Pentium Dual-Core E2200");
		
		desktopPage.selectItemInDropdown("4GB [+$20.00]");
		
		desktopPage.selectOSValue();
		
		desktopPage.clickToUpdate();
		
		Assert.assertEquals(desktopPage.getOrderSucessMessage(), "The product has been added to your shopping cart");
		
		desktopPage.clickToClose();
	}
	
	
	
}
