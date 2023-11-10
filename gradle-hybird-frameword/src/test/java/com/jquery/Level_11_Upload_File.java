package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



import commons.BaseTest;
import pageObjects.jQuery.uploadFile.HomePageObject;
import pageObjects.jQuery.uploadFile.PageGeneratorManager;



public class Level_11_Upload_File extends BaseTest {	
	private WebDriver driver;
	HomePageObject homePage;
	String oneFileName = "1.png";
	String twoFileName = "2.png";
	String threeFileName = "3.png";
	String[] multipleFileName = {oneFileName, twoFileName, threeFileName};
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomPage(driver);
	}
	
	@Test
	public void Upload_01_One_File_Per_Time() {
		homePage.uploadMultipleFiles(driver, oneFileName);
		Assert.assertTrue(homePage.isFileLoadedByName(oneFileName));
		
		homePage.clickToStartButton();
		
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(oneFileName));
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(oneFileName));
	}
	
	@Test
	public void Upload_02_Multiple_File_Per_Time() {
		homePage.refreshToPage(driver);
		homePage.uploadMultipleFiles(driver, multipleFileName);		
		Assert.assertTrue(homePage.isFileLoadedByName(oneFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(twoFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(threeFileName));
		
		homePage.clickToStartButton();
		
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(oneFileName));
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(oneFileName));
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(twoFileName));
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(twoFileName));
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(threeFileName));
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(threeFileName));
	}
	

	
	
		
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	
}
