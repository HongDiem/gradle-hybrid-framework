package techPanda;

public class AdminHomePageUI {
	public static final String POPUP_CLOSE = "xpath=//div[@id='message-popup-window']//span[text()='close']";
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr[@class='headings']//span[text()='%s']/../../../preceding-sibling::th";
	public static final String TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tr[@class='filter']/th[%s]//input";
	public static final String SEARCH_BUTTON = "xpath=//span[text()='Search']";
	public static final String VALUE_BY_COLUMN_INDEX = "xpath=//td[contains(text(),'%s')]/following-sibling::td[contains(text(),'%s')]";
}
