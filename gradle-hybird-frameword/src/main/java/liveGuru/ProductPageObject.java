package liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import liveGuruUI.ProductPageUI;

public class ProductPageObject extends BasePage{
	private WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getElementText() {
		waitForAllElementVisible(driver, ProductPageUI.COST_OF_PRODUCT);
		return getElementText(driver, ProductPageUI.COST_OF_PRODUCT);
	}

	public void clickToDetailProduct() {
		waitForAllElementVisible(driver, ProductPageUI.DETAIL_PRODUCT_LINK);
		clickToElement(driver, ProductPageUI.DETAIL_PRODUCT_LINK);
		
	}

	public String getElementTextDetail() {
		waitForAllElementVisible(driver, ProductPageUI.COST_OF_PRODUCT_DETAIL);
		return getElementText(driver, ProductPageUI.COST_OF_PRODUCT_DETAIL);
	}

	public void clickToAddToCart() {
		waitForElementClickable(driver, ProductPageUI.ADD_TO_CART);
		clickToElement(driver, ProductPageUI.ADD_TO_CART);
	}

	public void enterToQTYOfProduct(String qtyOfProduct) {
		waitForAllElementVisible(driver, ProductPageUI.QTY_OF_PRODUCT);
		sendkeyToElement(driver, ProductPageUI.QTY_OF_PRODUCT, qtyOfProduct);
	}

	public void clickToUpdateButtonQTY() {
		waitForElementClickable(driver, ProductPageUI.UPDATE_BUTTON_QTY);
		clickToElement(driver, ProductPageUI.UPDATE_BUTTON_QTY);
	}

	public String getErrorMessageAddMore500Items() {
		waitForElementVisible(driver, ProductPageUI.ERROR_MESSAGE_ADD_MORE_500_ITEMS);
		return getElementText(driver, ProductPageUI.ERROR_MESSAGE_ADD_MORE_500_ITEMS);
	}

	public String getErrorMessageForProduct() {
		waitForElementVisible(driver, ProductPageUI.ERROR_MESSAGE_FOR_PRODUCTS);
		return getElementText(driver, ProductPageUI.ERROR_MESSAGE_FOR_PRODUCTS);
	}

	public void clickToEmptyCartLink() {
		waitForElementClickable(driver, ProductPageUI.EMPTY_CART_LINK);
		clickToElement(driver, ProductPageUI.EMPTY_CART_LINK);
	}

	public String getEmptyCartMessage() {
		waitForElementVisible(driver, ProductPageUI.EMPTY_CART_LINK);
		return getElementText(driver, ProductPageUI.EMPTY_CART_LINK);
	}

	public void clickToCompareFirstProduct() {
		waitForElementClickable(driver, ProductPageUI.ADD_TO_COMPARE_FIRST_PRODUCT);
		clickToElement(driver, ProductPageUI.ADD_TO_COMPARE_FIRST_PRODUCT);
	}

	public void clickToCompareSecondProduct() {
		waitForElementClickable(driver, ProductPageUI.ADD_TO_COMPARE_SECOND_PRODUCT);
		clickToElement(driver, ProductPageUI.ADD_TO_COMPARE_SECOND_PRODUCT);		
	}

	public ComparePageObject clickToCompareButton() {
		waitForElementClickable(driver, ProductPageUI.COMPARE_BUTTON);
		clickToElement(driver, ProductPageUI.COMPARE_BUTTON);
		return PageGeneratorManager.getComparePage(driver);
	}

	public String getCompareFirstProductSucessMessage() {
		waitForElementVisible(driver, ProductPageUI.ADD_TO_COMPARE_SUCCESS_MESSAGE);
		return getElementText(driver, ProductPageUI.ADD_TO_COMPARE_SUCCESS_MESSAGE);
	}

	public ComparePageObject switchToWindowByPageTitle(String string) {
		switchToWindowByPageTitle(driver, ProductPageUI.TITLE_COMPARE_PAGE);
		return PageGeneratorManager.getComparePage(driver);
	}

	public void closeWindowWithoutParent(String parentID) {
		closeAllWindowWithoutParent(driver, parentID);
		
	}

	public void clickToWishlistProduct() {
		waitForElementVisible(driver, ProductPageUI.WISHLIST_LINK);
		clickToElement(driver, ProductPageUI.WISHLIST_LINK);
		
	}

	public String getWishListSucessMessage() {
		waitForElementVisible(driver, ProductPageUI.ADD_TO_COMPARE_SUCCESS_MESSAGE);
		return getElementText(driver, ProductPageUI.ADD_TO_COMPARE_SUCCESS_MESSAGE);
	}

	public void clickToSharedWishListButton() {
		waitForElementVisible(driver, ProductPageUI.SHARED_WISHLIST_BUTTON);
		clickToElement(driver, ProductPageUI.SHARED_WISHLIST_BUTTON);
	}

	public void enterToEmailTextArea(String emailAddress) {
		waitForElementVisible(driver, ProductPageUI.EMAIL_ADDREDD_TEXT_AREA);
		sendkeyToElement(driver, ProductPageUI.EMAIL_ADDREDD_TEXT_AREA, emailAddress);
	}

	public boolean isWishListDisplayed() {
		waitForElementVisible(driver, ProductPageUI.WISHLIST_DISPLAYED);
		return isElementDisplayed(driver, ProductPageUI.WISHLIST_DISPLAYED);
	}

	public void clickToDetailProductSamSung() {
		waitForElementClickable(driver, ProductPageUI.DETAIL_SAMSUNG);
		clickToElement(driver, ProductPageUI.DETAIL_SAMSUNG);
	}

	public void clickToAddYourReview() {
		waitForElementClickable(driver, ProductPageUI.ADD_YOUR_REVIEW_LINK);
		clickToElement(driver, ProductPageUI.ADD_YOUR_REVIEW_LINK);
	}

	public void clickToQualityLevel4() {
		waitForElementClickable(driver, ProductPageUI.QUALITY_LEVEL_RADIO);
		checkToDefaultCheckboxOrRadio(driver, ProductPageUI.QUALITY_LEVEL_RADIO);
	}

	public void enterToYourThoughts(String yourthoughts) {
		waitForElementVisible(driver, ProductPageUI.YOUR_THOUGHTS_TEXTBOX);
		sendkeyToElement(driver, ProductPageUI.YOUR_THOUGHTS_TEXTBOX, yourthoughts);
	}

	
	public void enterToYourReview(String review) {
		waitForElementVisible(driver, ProductPageUI.YOUR_REVIEW_TEXTBOX);
		sendkeyToElement(driver, ProductPageUI.YOUR_REVIEW_TEXTBOX, review);
	}

	public void clickToSubmitReview() {
		waitForElementClickable(driver, ProductPageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, ProductPageUI.SUBMIT_REVIEW_BUTTON);
	}

	public void enterToPriceFrom(String fromPrice) {
		waitForElementVisible(driver, ProductPageUI.FROM_PRICE_TEXTBOX);
		sendkeyToElement(driver, ProductPageUI.FROM_PRICE_TEXTBOX, fromPrice);
	}

	public void enterToPriceTo(String toPrice) {
		waitForElementVisible(driver, ProductPageUI.TO_PRICE_TEXTBOX);
		sendkeyToElement(driver, ProductPageUI.TO_PRICE_TEXTBOX, toPrice);
		
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, ProductPageUI.SEARCH_BUTTON);
		clickToElement(driver, ProductPageUI.SEARCH_BUTTON);
	}

	public String getPriceSearch() {
		waitForElementVisible(driver, ProductPageUI.PRICE_SEARCH_RESULTS);
		return getElementText(driver, ProductPageUI.PRICE_SEARCH_RESULTS);
	}

		
	

}
