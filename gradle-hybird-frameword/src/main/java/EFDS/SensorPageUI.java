package EFDS;

public class SensorPageUI {
	public static final String SENSOR_ID_TEXTBOX = "xpath=//input[@autocomplete='sensor_id']";
	public static final String SENSOR_NAME_TEXTBOX = "xpath=//input[@autocomplete='sensor_name']";
	public static final String SENSOR_TYPE_NAME_LINK = "xpath=//input[@formcontrolname='sensor_type_name']";
	public static final String REGION_NAME_AUTOCOMPLETE = "xpath=//input[@formcontrolname='region_name']";
	public static final String PROPERTY_NAME_AUTOCOMPLETE = "xpath=//input[@formcontrolname='property_name']";
	public static final String GATEWAY_NAME_TEXTBOX = "xpath=//input[@formcontrolname='gateway_name']";
	public static final String GATEWAY_NAME_VALUE = "xpath=//span[text()=' GW002 ']/.."; 
	public static final String SENSOR_AREA = "xpath=//input[@autocomplete='sensor_area']";
	public static final String SENSOR_LOCATION = "xpath=//input[@autocomplete='sensor_location']";
	public static final String ADD_SENSOR_BUTTON = "xpath=//span[text()=' 登録 ']/..";
	public static final String CONFIUM_POPUP = "xpath=//div[text()='データベースに登録します？']";
	public static final String OK_CONFIRM_BUTTON = "xpath=//div[text()='データベースに登録します？']/../..//span[text()=' OK ']/..";
	public static final String SUCCESS_POPUP = "xpath=//div[text()='データは正常に保存されました。']";
	public static final String OK_SUCCESS_BUTTON = "xpath=//div[text()='データは正常に保存されました。']/../..//span[text()=' OK ']/..";
	public static final String POPUP_ERROR_EXIST = "xpath=//h1[text()='エラー']/..";
	public static final String OK_BUTTON_ERROR_EXIST = "xpath=//h1[text()='エラー']/..//span[text()=' OK ']/..";
	public static final String ICON_SORT = "xpath=//mat-header-cell[text()=' センサーID ']//i";
	public static final String POPUP_SORT_AND_FILTER = "xpath=//h1[text()=' ソート／フィルターについて ']/..";
	public static final String FILTER_SENSOR_ID_TEXTBOX = "xpath=//input[@aria-label='フィルターについて']";
	public static final String OK_BUTTON_IN_FILTER = "xpath=//h1[text()=' ソート／フィルターについて ']/..//span[text()=' OK ']/..";
	public static final String LINE_SENSOR_FOCUS = "xpath=//div[text()=' %s ']/../..";
	public static final String CLEAR_BUTTON = "xpath=//span[text()=' クリア ']/..";
	public static final String UPDATE_BUTTON = "xpath=//span[text()=' 変更 ']/..";
	public static final String CLEAR_SENSOR_SUCCESS = "xpath=//mat-label[text()='センサー名']";
	public static final String DELETE_BUTTON = "xpath=//span[text()=' 削除 ']/..";
	public static final String POPUP_DELETE = "xpath=//div[text()='センサーを削除します？']/..";
	public static final String OK_BUTTON_IN_DELETE_POPUP = "xpath=//div[text()='センサーを削除します？']/..//span[text()=' OK ']/..";
	public static final String SUCCESS_DELETE_POPUP = "xpath=//div[text()='データは正常に削除されました。']/..";
	public static final String OK_BUTTON_IN_SUCCESS_DELETE_POPUP = "xpath=//div[text()='データは正常に削除されました。']/..//span[text()=' OK ']/..";
	public static final String NULL_DATA = "xpath=//div[text()='データなし']";
	public static final String CANCEL_IN_FILTER = "xpath=//span[text()=' キャンセル ']/..";
	public static final String PROPERTY_LINK = "xpath=//span[text()=' 物件登録 ']/..";
	
}
