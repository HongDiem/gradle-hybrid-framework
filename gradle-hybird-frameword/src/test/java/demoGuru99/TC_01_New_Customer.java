package demoGuru99;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;


public class TC_01_New_Customer extends BaseTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private NewCustomerPageObject newCustomPage;
	private String userID, Password, customerNumber, customerSpecial, customerBlank, addressBlank, cityNumber, citySpecial, cityBlank,
	PINText, PINBlank, PIN6Digits, emailFormat, emailSpace, customerName, Address, City, State, PIN, Mobile, Email, passCus;

	Keys key = null;
	
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		Password = "adugUvy";
		userID = "mngr512120";
		customerNumber = "1254";
		customerSpecial = "#$%@";
		customerBlank = " 234";
		addressBlank = "  125";
		cityNumber = "123";
		citySpecial = "@#$";
		cityBlank = " 123";
		key = Keys.TAB;
		PINText = "sdg";
		PINBlank = "123 76";
		PIN6Digits = "123";
		emailFormat = "123gmail";
		emailSpace = "234 46gmail";
		
		customerName = "Hong Diem";
		Address = "145 Hoang Quoc Viet";
		City = "Ha Noi";
		State = "Nam Tu Liem"; 
		PIN ="157894"; 
		Mobile = "0324789745"; 
		Email = "automation123@gmail.com";
		passCus = "123654";
		
		loginPage.inputToUserIDTextbox(userID);
		loginPage.inputToPasswordTextbox(Password);
		
		homePage = loginPage.clickToLoginButton();
		verifyFalse(homePage.isNewCustomerDisplayed());
		
		newCustomPage = homePage.clickToNewCustomerLink();
	}
	
	@Test
	public void TC_01_Name_Cannot_Empty() {
		newCustomPage.enterTabToNameTextbox(key, "Customer Name");
		verifyEquals(newCustomPage.getErrorMessage(driver, "Customer Name"), "Customer name must not be blank");		
	}
	
	@Test
	public void TC_02_Name_Cannot_Numeric() {
		newCustomPage.enterToNameTextboxWithNumber(driver, customerNumber, "Customer Name");
		verifyEquals(newCustomPage.getErrorMessage(driver, "Customer Name"), "Numbers are not allowed");		
	}
	
	@Test
	public void TC_03_Name_Cannot_Has_Special_Characters() {
		newCustomPage.enterToNameTextboxWithNumber(driver, customerSpecial, "Customer Name");
		verifyEquals(newCustomPage.getErrorMessage(driver, "Customer Name"), "Special characters are not allowed");		
	}
	
	@Test
	public void TC_04_Name_Cannot_Has_First_Blank() {
		newCustomPage.enterToNameTextboxWithNumber(driver, customerBlank, "Customer Name");
		verifyEquals(newCustomPage.getErrorMessage(driver, "Customer Name"), "First character can not have space");		
	}
	
	@Test
	public void TC_05_Address_Cannot_Empty() {
		newCustomPage.enterTabToAddressTextArea(key, "Address");
		verifyEquals(newCustomPage.getErrorMessage(driver, "Address"), "Address Field must not be blank");
	}
	
	@Test
	public void TC_06_Address_Has_First_Blank() {
		newCustomPage.enterTabToAddressTextAreaWithBlank(driver, addressBlank, "Address");
		verifyEquals(newCustomPage.getErrorMessage(driver, "Address"), "First character can not have space");
	}
	
	@Test
	public void TC_07_City_Cannot_Empty() {
		newCustomPage.enterTabToNameTextbox(key, "City");
		verifyEquals(newCustomPage.getErrorMessage(driver, "City"), "City Field must not be blank");	
	}
	
	@Test
	public void TC_08_City_Cannot_Numeric() {
		newCustomPage.enterToNameTextboxWithNumber(driver, cityNumber, "City");
		verifyEquals(newCustomPage.getErrorMessage(driver, "City"), "Numbers are not allowed");
	}
	
	@Test
	public void TC_09_City_Cannot_Special() {
		newCustomPage.enterToNameTextboxWithNumber(driver, citySpecial, "City");
		verifyEquals(newCustomPage.getErrorMessage(driver, "City"), "Special characters are not allowed");
	}
	
	@Test
	public void TC_10_City_Cannot_Blank() {
		newCustomPage.enterToNameTextboxWithNumber(driver, cityBlank, "City");
		verifyEquals(newCustomPage.getErrorMessage(driver, "City"), "First character can not have space");
	}
	
	@Test
	public void TC_11_State_Cannot_Empty() {
		newCustomPage.enterTabToNameTextbox(key, "State");
		verifyEquals(newCustomPage.getErrorMessage(driver, "State"), "State must not be blank");	
	}
	
	@Test
	public void TC_12_State_Cannot_Numeric() {
		newCustomPage.enterToNameTextboxWithNumber(driver, cityNumber, "State");
		verifyEquals(newCustomPage.getErrorMessage(driver, "State"), "Numbers are not allowed");
	}
	
	@Test
	public void TC_13_State_Cannot_Special() {
		newCustomPage.enterToNameTextboxWithNumber(driver, citySpecial, "State");
		verifyEquals(newCustomPage.getErrorMessage(driver, "State"), "Special characters are not allowed");
	}
	
	@Test
	public void TC_14_State_Cannot_Blank() {
		newCustomPage.enterToNameTextboxWithNumber(driver, cityBlank, "State");
		verifyEquals(newCustomPage.getErrorMessage(driver, "State"), "First character can not have space");
	}
	
	@Test
	public void TC_15_PIN_Cannot_Empty() {
		newCustomPage.enterTabToNameTextbox(key, "PIN");
		verifyEquals(newCustomPage.getErrorMessage(driver, "PIN"), "PIN Code must not be blank");	
	}
	
	@Test
	public void TC_16_PIN_Cannot_Text() {
		newCustomPage.enterToNameTextboxWithNumber(driver, PINText, "PIN");
		verifyEquals(newCustomPage.getErrorMessage(driver, "PIN"), "Characters are not allowed");
	}
	
	@Test
	public void TC_17_PIN_Cannot_Special() {
		newCustomPage.enterToNameTextboxWithNumber(driver, citySpecial, "PIN");
		verifyEquals(newCustomPage.getErrorMessage(driver, "PIN"), "Special characters are not allowed");
	}
	
	@Test
	public void TC_18_PIN_Lest_6_Digits() {
		newCustomPage.enterToNameTextboxWithNumber(driver, PIN6Digits, "PIN");
		verifyEquals(newCustomPage.getErrorMessage(driver, "PIN"), "PIN Code must have 6 Digits");
	}
	
	@Test
	public void TC_19_PIN_Cannot_First_Blank() {
		newCustomPage.enterToNameTextboxWithNumber(driver, cityBlank, "PIN");
		verifyEquals(newCustomPage.getErrorMessage(driver, "PIN"), "First character can not have space");
	}
	
	@Test
	public void TC_20_PIN_Cannot_Blank() {
		newCustomPage.enterToNameTextboxWithNumber(driver, PINBlank, "PIN");
		verifyEquals(newCustomPage.getErrorMessage(driver, "PIN"), "Characters are not allowed");
	}

	@Test
	public void TC_21_Mobile_Cannot_Text() {
		newCustomPage.enterToNameTextboxWithNumber(driver, PINText, "Mobile Number");
		verifyEquals(newCustomPage.getErrorMessage(driver, "Mobile Number"), "Characters are not allowed");
	}
	
	@Test
	public void TC_22_Mobile_Cannot_Special() {
		newCustomPage.enterToNameTextboxWithNumber(driver, citySpecial, "Mobile Number");
		verifyEquals(newCustomPage.getErrorMessage(driver, "Mobile Number"), "Special characters are not allowed");
	}
	
	@Test
	public void TC_24_Mobile_Cannot_First_Blank() {
		newCustomPage.enterToNameTextboxWithNumber(driver, cityBlank, "Mobile Number");
		verifyEquals(newCustomPage.getErrorMessage(driver, "Mobile Number"), "First character can not have space");
	}
	
	@Test
	public void TC_25_Mobile_Cannot_Blank() {
		newCustomPage.enterToNameTextboxWithNumber(driver, PINBlank, "Mobile Number");
		verifyEquals(newCustomPage.getErrorMessage(driver, "Mobile Number"), "Characters are not allowed");
	}
	
	@Test
	public void TC_27_Email_Cannot_Empty() {
		newCustomPage.enterTabToNameTextbox(key, "E-mail");
		verifyEquals(newCustomPage.getErrorMessage(driver, "E-mail"), "Email-ID must not be blank");	
	}
	
	@Test
	public void TC_28_Email_Not_Format() {
		newCustomPage.enterToNameTextboxWithNumber(driver, emailFormat, "E-mail");
		verifyEquals(newCustomPage.getErrorMessage(driver, "E-mail"), "Email-ID is not valid");	
	}
	
	@Test
	public void TC_29_Email_Not_Space() {
		newCustomPage.enterToNameTextboxWithNumber(driver, emailSpace, "E-mail");
		verifyEquals(newCustomPage.getErrorMessage(driver, "E-mail"), "Email-ID is not valid");	
	}
	
	@Test
	public void TC_30_Success_Add_Customer() {
		newCustomPage.enterToNameTextboxWithNumber(driver, customerName, "Customer Name");
		newCustomPage.enterTabToAddressTextAreaWithBlank(driver, Address, "Address");
		newCustomPage.enterToNameTextboxWithNumber(driver, City, "City");
		newCustomPage.enterToNameTextboxWithNumber(driver, State, "State");
		newCustomPage.enterToNameTextboxWithNumber(driver, PIN, "PIN");
		newCustomPage.enterToNameTextboxWithNumber(driver, Mobile, "Mobile Number");
		newCustomPage.enterToNameTextboxWithNumber(driver, Email, "E-mail");
		newCustomPage.enterToNameTextboxWithNumber(driver, passCus, "Password");
		newCustomPage.clickToSubmitButton(driver, "submit");
		
	}
	

	

	
	
	
	
	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
	
	
