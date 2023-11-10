package efds;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import EFDS.DashboardPageObject;
import EFDS.LoginPageObject;
import EFDS.PropertyPageObject;
import EFDS.RegionalPageObject;
import EFDS.SensorPageObject;
import commons.BaseTest;

public class Level_01_New_Regional extends BaseTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private RegionalPageObject regionalPage;
	private DashboardPageObject dashboardPage;
	private SensorPageObject sensorPage;
	private PropertyPageObject propertyPage;
	private String userId, userIdLess4digits, userInvalid, userSpace, valueNull, Password, 
 	regionalText, sensorId, sensorName, sensorArea, sensorLocation, 
	sensorType, gatewayName, regionalName, propertyName, regionalTextUpdate,
	sensorNameUpdate, sensorAreaUpdate, sensorLocationUpdate;
	
	Keys key = null;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		valueNull = "";
		userInvalid = "admin12";
		userId = "admin";
		Password = "12345678";
		userIdLess4digits = "12";
		regionalText = "Test" + + generateFakeNumber();
		regionalTextUpdate = regionalText + "update";
		sensorId = "LL" + + generateFakeNumber();
		sensorName = sensorId + "_name";
		sensorType = "地震計";
		sensorArea = "Area" + + generateFakeNumber() + "_Area";
		sensorLocation = "Location" + + generateFakeNumber();
		regionalName = "16102023";
		propertyName = "16102023";
		gatewayName = "GW002";
		userSpace = "     ";
		sensorNameUpdate = sensorName + "Up";
		sensorAreaUpdate = sensorArea + "Up";
		sensorLocationUpdate = sensorLocation + "Up";
		key = Keys.ENTER;
		
		loginPage = EFDS.PageGeneratorManager.getLoginPage(driver);
	}
	
	@Test
	public void TC_01_Login_ID_Cannot_Empty() {
		loginPage.enterToIDTextbox(valueNull);
		verifyEquals(loginPage.getErrorMessageIDUserName(), "ユーザーIDが必須です。");
	}
	
	@Test
	public void TC_02_Login_Password_Cannot_Empty() {
		loginPage.enterToIDTextbox(userId);
		loginPage.enterToPasswordTextbox(valueNull);
		verifyEquals(loginPage.getErrorMessagePassword(), "パスワードが必須です。");
	}
	
	@Test
	public void TC_03_Login_ID_Less_4_Digits() {
		loginPage.enterToIDTextbox(userIdLess4digits);
		verifyEquals(loginPage.getErrorMessageIDUserName(), "最小長4桁。");
	}
	
	@Test
	public void TC_04_Login_Password_Less_4_Digits() {
		loginPage.enterToIDTextbox(userId);
		loginPage.enterToPasswordTextbox(userIdLess4digits);
		verifyEquals(loginPage.getErrorMessagePassword(), "最小長8桁。");
	}
	
	@Test
	public void TC_05_Login_ID_User_Space_Null() {
		loginPage.enterToIDTextbox(userSpace);
		loginPage.enterToPasswordTextbox(Password);
		loginPage.clickToLoginButton();
		verifyTrue(loginPage.isPopupErrorIsDisplay());
		loginPage.clickToOKButtonInPopUpError();
	}	
	
	@Test
	public void TC_06_Login_With_ID_User_Or_Password_Invalid() {
		loginPage.enterToIDTextbox(userInvalid);
		loginPage.enterToPasswordTextbox(Password);
		loginPage.clickToLoginButton();
		verifyTrue(loginPage.isPopupErrorIDOrPasswordInvalidIsDisplay());
		loginPage.clickToOKButtonInPopUpErrorIdOrPasswordInvalid();
	}	
	
	@Test
	public void TC_07_Login_Success() {
		loginPage.enterToIDTextbox(userId);
		loginPage.enterToPasswordTextbox(Password);
		loginPage.clickToLoginButton();
		dashboardPage = loginPage.clickToLoginButton();
		dashboardPage.clickToDetailLink();
		regionalPage = dashboardPage.clickToRegionalLabel();
		verifyTrue(regionalPage.isRegionalTitleisplayed());
	}	
	
	@Test
	public void TC_08_New_Regional_Success() {
		regionalPage.enterToRegionalTextbox(regionalText);
		regionalPage.clickToAddRegionalButton();
		
		verifyTrue(regionalPage.isConfirmPopupIsDisplay());
		regionalPage.clickToOK();
		
		verifyTrue(regionalPage.isSuccessPopUpIsDisplay());
		regionalPage.clickOKButonAddSuccess();		
	}

	@Test
	public void TC_09_New_Regional_Already_Exist() {
		regionalPage.enterToRegionalTextbox(regionalText);
		regionalPage.clickToAddRegionalButton();
		
		verifyTrue(regionalPage.isConfirmPopupIsDisplay());
		regionalPage.clickToOK();
		
		verifyTrue(regionalPage.isPopupErrorMessageIsDisplay());
		regionalPage.clickOKButtonInPopupErrorRegionalExist();
	}
	
	@Test
	public void TC_10_Update_Regional() {
		regionalPage.clickToSort();
		verifyTrue(regionalPage.isPopUpSortAndFilterIsDisplay());
		regionalPage.enterRegionalNameToFilterTextbox(key,regionalText);
		regionalPage.clickToOKButtonINPoupSortAndFilter();
		regionalPage.clickToOneRegional(regionalText);
		regionalPage.enterToRegionalTextbox(regionalTextUpdate);
		regionalPage.clickToUpdateButton();
		verifyTrue(regionalPage.isPopupUpdateRegionalIsDisplay());
		regionalPage.clickToOKButtonInPopupConfirmUpdate();
		verifyTrue(regionalPage.isPopupUpdateRegionalSuccessIsDisplay());
		regionalPage.clickToOKButtonInPopupUpdateSuccess();
		//Check sau khi update thanh cong
		regionalPage.clickToSort();
		verifyTrue(regionalPage.isPopUpSortAndFilterIsDisplay());
		regionalPage.enterRegionalNameToFilterTextbox(key,regionalTextUpdate);
		regionalPage.clickToOKButtonINPoupSortAndFilter();
		verifyTrue(regionalPage.isLineOfRegionalUpdateIsDisplay(regionalTextUpdate));		
	}
	
	@Test
	public void TC_11_Clear_Regional() {		
		regionalPage.clickToSort();
		verifyTrue(regionalPage.isPopUpSortAndFilterIsDisplay());
		regionalPage.enterRegionalNameToFilterTextbox(key,regionalTextUpdate);
		regionalPage.clickToOKButtonINPoupSortAndFilter();
		regionalPage.clickToOneRegional(regionalTextUpdate);
		regionalPage.enterToRegionalTextbox(regionalTextUpdate);
		regionalPage.clickToClearButton();
		verifyTrue(regionalPage.isClearDataSuccess());		
	}
	
	@Test
	public void TC_12_Delete_Regional() {
		regionalPage.clickToSort();
		verifyTrue(regionalPage.isPopUpSortAndFilterIsDisplay());
		regionalPage.enterRegionalNameToFilterTextbox(key,regionalTextUpdate);
		regionalPage.clickToOKButtonINPoupSortAndFilter();
		regionalPage.clickToOneRegional(regionalTextUpdate);
		regionalPage.enterToRegionalTextbox(regionalTextUpdate);
		regionalPage.clickToDeleteButton();
		
		verifyTrue(regionalPage.isPopupDeleteRegionalIsDisplay());
		regionalPage.clickToOKButtonInPopupConfirmDelete();
		verifyTrue(regionalPage.isPopupDeleteRegionalSuccessIsDisplay());
		regionalPage.clickToOKButtonInPopupDeleteSuccess();	
		//Check sau khi xoa thanh cong
		regionalPage.clickToSort();
		verifyTrue(regionalPage.isPopUpSortAndFilterIsDisplay());
		regionalPage.enterRegionalNameToFilterTextbox(key,regionalTextUpdate);
		verifyTrue(regionalPage.isNullDataRegionalDeletedIsDisplay());	
		regionalPage.clickToCancelInPopupSortAndFilter();
	}

	@Test
	public void TC_13_New_Sensor() {
		sensorPage = regionalPage.clickToSensorLink();
		sensorPage.enterToSensorID(sensorId);
		sensorPage.enterToSensorName(sensorName);
		sensorPage.enterToSensorType(key,sensorType);
		sensorPage.enterToRegionName(key,regionalName);
		
		sensorPage.enterToPropertyName(key,propertyName);
		sensorPage.enterToGatewayName(key,gatewayName);
		sensorPage.enterToSensorArea(sensorArea);
		sensorPage.enterToSensorLocation(sensorLocation);
		
		sensorPage.clickToAddNewSensor();
		verifyTrue(sensorPage.isConfirmPopupIsDisplayed());
		sensorPage.clickToConfirmPopup();
		
		verifyTrue(sensorPage.isSuccessPopupIsDisplayed());
		sensorPage.clickToSuccessPopup();
	}
	
	@Test
	public void TC_14_Sensor_Already_Exist() {
		sensorPage.enterToSensorID(sensorId);
		sensorPage.enterToSensorName(sensorName);
		sensorPage.enterToSensorType(key,sensorType);
		sensorPage.enterToRegionName(key,regionalName);
		
		sensorPage.enterToPropertyName(key,propertyName);
		sensorPage.enterToGatewayName(key,gatewayName);
		sensorPage.enterToSensorArea(sensorArea);
		sensorPage.enterToSensorLocation(sensorLocation);
		
		sensorPage.clickToAddNewSensor();
		verifyTrue(sensorPage.isConfirmPopupIsDisplayed());
		sensorPage.clickToConfirmPopup();
		
		verifyTrue(sensorPage.isErrorMessagePopupIsDisplayed());
		sensorPage.clickToSOKButtonInPopupErrorExist();
		sensorPage.clickToClearSensor();
	}
	
	@Test
	public void TC_15_Update_Sensor() {
		sensorPage.clickToSort();
		verifyTrue(sensorPage.isPopupSortAndFilterIsDisplay());
		sensorPage.enterToFilterSensor(key,sensorId);
		sensorPage.clickToOKFilter();
		sensorPage.clickToSensorWantUpdate(sensorId);
		
		sensorPage.enterToSensorName(sensorNameUpdate);
		sensorPage.enterToSensorArea(sensorAreaUpdate);
		sensorPage.enterToSensorLocation(sensorLocationUpdate);
		
		sensorPage.clickToUpdateSensor();
		verifyTrue(sensorPage.isConfirmPopupIsDisplayed());
		sensorPage.clickToConfirmPopup();
		
		verifyTrue(sensorPage.isSuccessPopupIsDisplayed());
		sensorPage.clickToSuccessPopup();
		
		sensorPage.clickToSort();
		verifyTrue(sensorPage.isPopupSortAndFilterIsDisplay());
		sensorPage.enterToFilterSensor(key,sensorId);
		sensorPage.clickToOKFilter();
		verifyTrue(sensorPage.isLineOfSensorUpdateIsDisplay(sensorNameUpdate));
	}
	
	@Test
	public void TC_16_Clear_Sensor() {
		sensorPage.clickToSort();
		verifyTrue(sensorPage.isPopupSortAndFilterIsDisplay());
		sensorPage.enterToFilterSensor(key,sensorId);
		sensorPage.clickToOKFilter();
		sensorPage.clickToSensorWantUpdate(sensorId);
		
		sensorPage.clickToClearSensor();
		verifyTrue(sensorPage.isClearSensorSuccess());
	}
	
	@Test
	public void TC_17_Delete_Sensor() {
		sensorPage.clickToSort();
		verifyTrue(sensorPage.isPopupSortAndFilterIsDisplay());
		sensorPage.enterToFilterSensor(key,sensorId);
		sensorPage.clickToOKFilter();
		sensorPage.clickToSensorWantUpdate(sensorId);
		
		sensorPage.clickToDeleteSensor();
		verifyTrue(sensorPage.isDeletePopupIsDisplayed());
		sensorPage.clickToDeleteConfirmPopup();
		
		verifyTrue(sensorPage.isDeleteSuccessPopupIsDisplayed());
		sensorPage.clickToOKDeleteSuccessPopup();
		
		sensorPage.clickToSort();
		verifyTrue(sensorPage.isPopupSortAndFilterIsDisplay());
		sensorPage.enterToFilterSensor(key,sensorId);
		verifyTrue(sensorPage.isNullDataIsDisplay());
		sensorPage.clickToCancelButtonFilter();
	}
	
	@Test
	public void TC_18_Property_Already_Exist() {
		propertyPage = sensorPage.clickToPropertyLink();
		
	}
	 
	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
