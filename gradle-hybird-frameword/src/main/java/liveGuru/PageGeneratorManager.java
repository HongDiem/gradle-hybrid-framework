package liveGuru;

import org.openqa.selenium.WebDriver;



public class PageGeneratorManager {
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static ProductPageObject getProductPage(WebDriver driver) {
		return new ProductPageObject(driver);
	}
	
	public static ComparePageObject getComparePage(WebDriver driver) {
		return new ComparePageObject(driver);
	}
	
	
}
