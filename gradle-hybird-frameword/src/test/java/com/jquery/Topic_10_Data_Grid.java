package com.jquery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



import commons.BaseTest;
import pageObjectjQuery.dataType.HomePageObject;
import pageObjectjQuery.dataType.PageGeneratorManager;


public class Topic_10_Data_Grid extends BaseTest {	
	private WebDriver driver;
	HomePageObject homePage;
	List<String> actualAllCountryValues;
	List<String> expectedAllCountryValues;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomPage(driver);
	}
	
//	@Test
	public void Table_01_Paging() {
		homePage.openPaginByPageNumber("10");
		homePage.sleepInSecond(3);
		Assert.assertTrue(homePage.isPageNumberActived("10"));
		
		
		homePage.openPaginByPageNumber("20");
		homePage.sleepInSecond(3);
		Assert.assertTrue(homePage.isPageNumberActived("20"));
		
		homePage.openPaginByPageNumber("7");
		homePage.sleepInSecond(3);
		Assert.assertTrue(homePage.isPageNumberActived("7"));
	}
	
//	@Test
	public void Table_02_Enter_To_Header() {
		homePage.refreshToPage(driver);
		homePage.enterToTextboxByLabel("Country", "Argentina");
		homePage.enterToTextboxByLabel("Females", "338282");
		homePage.enterToTextboxByLabel("Males", "349238");
		homePage.enterToTextboxByLabel("Total", "687522");
		homePage.sleepInSecond(3);
		
		homePage.enterToTextboxByLabel("Country", "Lesotho");
		homePage.enterToTextboxByLabel("Females", "24633");
		homePage.enterToTextboxByLabel("Males", "25096");
		homePage.enterToTextboxByLabel("Total", "49728");
		homePage.sleepInSecond(3);
	}
	
//	@Test
	public void Table_03_Enter_To_Header() {
//		actualAllCountryValues = homePage.getValueEachRowAtAllPage();
//		Assert.assertEquals(actualAllCountryValues, expectedAllCountryValues);
		homePage.getValueEachRowAtAllPage();
	}
	
	@Test
	public void Table_04_Enter_To_Textbox_At_Any_Row() {	
		homePage.clickToLoadButton();
		homePage.sleepInSecond(3);
		homePage.enterToTextboxAtRowNumberByColumnName("Company","1","JITDemo");
//		homePage.enterToTextboxAtRowNumberByColumnName("Contact Person","2","JITDemo_Test");
//		homePage.enterToTextboxAtRowNumberByColumnName("Order Placed","1","15");
//		homePage.selectDropdownByColumnNameAtRowNumber("Country","5","Japan");
//		
//		homePage.enterToTextboxAtRowNumberByColumnName("Company","3","JITDemo");
//		homePage.enterToTextboxAtRowNumberByColumnName("Contact Person","2","JITDemo_Test");
//		homePage.enterToTextboxAtRowNumberByColumnName("Order Placed","4","15");
//		homePage.selectDropdownByColumnNameAtRowNumber("Country","6","Japan");
//		
//		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?","2");
//		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?","6");
//		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?","7");
//		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?","8");
//		
//		
//		
//		homePage.unCheckToCheckboxByColumnNameAtRowNumber("NPO?","1");
//		homePage.unCheckToCheckboxByColumnNameAtRowNumber("NPO?","4");
//		homePage.unCheckToCheckboxByColumnNameAtRowNumber("NPO?","5");
		
		homePage.clickToIconByRowNumber("1","Remove Current Row");
		homePage.sleepInSecond(3);
		homePage.clickToIconByRowNumber("1","Insert Row Above");
		homePage.sleepInSecond(3);
		homePage.clickToIconByRowNumber("3","Move Up");
		homePage.sleepInSecond(3);
		homePage.clickToIconByRowNumber("1","Remove Current Row");
		
		
	}
		
	@AfterClass
	public void afterClass() {
//		driver.quit();
	}
	
	
}
