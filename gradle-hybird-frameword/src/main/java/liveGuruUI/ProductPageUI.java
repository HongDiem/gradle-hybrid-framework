package liveGuruUI;

public class ProductPageUI {
	public static final String COST_OF_PRODUCT = "xpath=//a[@title='Sony Xperia']/../following-sibling::div//span[@class='price']";
	public static final String DETAIL_PRODUCT_LINK = "xpath=//a[@title='Sony Xperia']";
	public static final String COST_OF_PRODUCT_DETAIL = "xpath=//div[@class='price-info']";
	public static final String ADD_TO_CART = "xpath=//li[@class='item last']//a[@title='Xperia']/..//span[text()='Add to Cart']/../..";
	public static final String QTY_OF_PRODUCT = "xpath=//td[@data-rwd-label='Qty']//input";
	public static final String UPDATE_BUTTON_QTY = "xpath=//button[@title='Update']";
	public static final String ERROR_MESSAGE_ADD_MORE_500_ITEMS = "xpath=//li[@class='error-msg']";
	public static final String ERROR_MESSAGE_FOR_PRODUCTS = "xpath=//p[@class='item-msg error']";
	public static final String EMPTY_CART_LINK = "xpath=//span[text()='Empty Cart']";
	public static final String ADD_TO_COMPARE_SUCCESS_MESSAGE = "css=li.success-msg span";
	public static final String ADD_TO_COMPARE_FIRST_PRODUCT = "xpath=//li[@class='item last']//a[@title='Xperia']/..//a[@class='link-compare']";
	public static final String ADD_TO_COMPARE_SECOND_PRODUCT = "xpath=//li[@class='item last']//a[@title='IPhone']/..//a[@class='link-compare']";
	public static final String COMPARE_BUTTON = "xpath=//span[text()='Compare']";
	public static final String TITLE_COMPARE_PAGE = "xpath=//title";
	public static final String WISHLIST_LINK = "xpath=//li[@class='item last']//a[@title='LG LCD' and text()='LG LCD']/../..//div[@class='actions']//a[text()='Add to Wishlist']";
	public static final String SHARED_WISHLIST_BUTTON = "xpath=//button[@title='Share Wishlist']";
	public static final String EMAIL_ADDREDD_TEXT_AREA = "xpath=//label[@for='email_address']/..//textarea";
	public static final String WISHLIST_DISPLAYED = "xpath=//div[@class='my-wishlist']//a[text()='LG LCD']";
	public static final String DETAIL_SAMSUNG = "xpath=//li[@class='item last']//a[@title='Samsung LCD' and text()='Samsung LCD']";
	public static final String ADD_YOUR_REVIEW_LINK = "xpath=//a[text()='Add Your Review']";
	public static final String QUALITY_LEVEL_RADIO = "xpath=//tr[@class='first last odd']//input[@value='4']";
	public static final String YOUR_THOUGHTS_TEXTBOX = "xpath=//label[text()='Let us know your thoughts']/following-sibling::div//textarea";
	public static final String YOUR_REVIEW_TEXTBOX = "xpath=//label[text()='Summary of Your Review']/following-sibling::div//input";
	public static final String SUBMIT_REVIEW_BUTTON = "xpath=//button[@title='Submit Review']";
	public static final String FROM_PRICE_TEXTBOX = "xpath=//div[@class='input-range']//input[@name='price[from]']";
	public static final String TO_PRICE_TEXTBOX = "xpath=//div[@class='input-range']//input[@name='price[to]']";
	public static final String SEARCH_BUTTON = "xpath=//button[@title='Search' and @class='button']";
	public static final String PRICE_SEARCH_RESULTS = "xpath=//div[@class='advanced-search-summary']//li";
}
