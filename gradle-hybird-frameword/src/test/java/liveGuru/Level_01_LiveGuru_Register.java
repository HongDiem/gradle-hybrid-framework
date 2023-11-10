package liveGuru;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;



public class Level_01_LiveGuru_Register extends BaseTest {
	private WebDriver driver;
	private RegisterPageObject registerPage;
	private HomePageObject homePage;
	private ProductPageObject productPage;
	private ComparePageObject comparePage;
	private String emailAddress, lastName, fisrtName, Password, yourthoughts, review, fromPrice, toPrice;
	
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		
		homePage = liveGuru.PageGeneratorManager.getHomePage(driver);
		fisrtName = "Automation"; 
		lastName = "FC";
		Password = "123456";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.com";
		yourthoughts = "Test ngày 28062023";
		review = "Sản phẩm tốt, giá thành hợp lý, bền đẹp";
		fromPrice = "0";
		toPrice = "150";
	}
	
	@Test
	public void User_01_Register_Login() {
		homePage.clickToAccLink();
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.inputToFirstnameTextbox(fisrtName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(Password);
		registerPage.inputToConfirmPasswordTextbox(Password);
		registerPage.clickToRegisterButton();
		verifyEquals(registerPage.getRegisterSucessMessage(), "Thank you for registering with Main Website Store.");
		
		verifyEquals(registerPage.getTextWelcomeSuccess(), "Hello, "  + fisrtName + " " + lastName + "!" );
		
	}
	
//	@Test
	public void User_02_Cost_Of_Product() {
		productPage = homePage.clickToMobileLink();
		verifyEquals(productPage.getElementText(), "$100.00");		
		
		productPage.clickToDetailProduct();
		productPage.getElementTextDetail();
		verifyEquals(productPage.getElementTextDetail(), "$100.00");		
	}

//	@Test
	public void User_03_Add_More_500_Items() {
		productPage = homePage.clickToMobileLink();
		productPage.clickToAddToCart();	
		productPage.enterToQTYOfProduct("501");
		productPage.clickToUpdateButtonQTY();
		verifyEquals(productPage.getErrorMessageAddMore500Items(),"Some of the products cannot be ordered in requested quantity.");
		
		verifyEquals(productPage.getErrorMessageForProduct(),"* The maximum quantity allowed for purchase is 500.");
		productPage.clickToEmptyCartLink();
		
		Assert.assertEquals(productPage.getEmptyCartMessage(),"You have no items in your shopping cart.\nClick here to continue shopping.");
	}
	
//	@Test
	public void User_04_Compare_Two_Product() {
		productPage = homePage.clickToMobileLink();
		
		productPage.clickToCompareFirstProduct();
		verifyEquals(productPage.getCompareFirstProductSucessMessage(),"The product Sony Xperia has been added to comparison list.");
		
		productPage.clickToCompareSecondProduct();
		verifyEquals(productPage.getCompareFirstProductSucessMessage(),"The product IPhone has been added to comparison list.");
		
		productPage.clickToCompareButton();
		
		comparePage = productPage.switchToWindowByPageTitle("Products Comparison List - Magento Commerce");		
		comparePage.clickToClose();
	}
	
//	@Test
	public void User_05_Wishlist() {
		productPage = homePage.clickToTVLink();
		
		productPage.clickToWishlistProduct();
		verifyEquals(productPage.getWishListSucessMessage(),"LG LCD has been added to your wishlist. Click here to continue shopping.");
		
		productPage.clickToSharedWishListButton();
		
		productPage.enterToEmailTextArea(emailAddress);
		
		productPage.clickToSharedWishListButton();
		
		verifyEquals(productPage.getWishListSucessMessage(),"Your Wishlist has been shared.");
		verifyTrue(productPage.isWishListDisplayed());
	}
	
//	@Test
	public void User_06_Add_Your_Review() {
		productPage = homePage.clickToTVLink();
		
		productPage.clickToDetailProductSamSung();
		
		productPage.clickToAddYourReview();
		
		productPage.clickToQualityLevel4();
		
		productPage.enterToYourThoughts(yourthoughts);
		
		productPage.enterToYourReview(review);
		
		productPage.clickToSubmitReview();
		
		verifyEquals(productPage.getWishListSucessMessage(),"Your review has been accepted for moderation.");

	}
	
	@Test
	public void User_07_Advanced_Search() {
		productPage = homePage.clickToAdvanceSearchLink();
		
		productPage.enterToPriceFrom(fromPrice);
		
		productPage.enterToPriceTo(toPrice);
		
		productPage.clickToSearchButton();
		
		verifyEquals(productPage.getPriceSearch(),"Price: " +  fromPrice + " - " + toPrice);
		
	}
	
	
	
	
	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
	
	
