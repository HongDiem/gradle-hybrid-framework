package EFDS;

public class LoginPageUI {
	public static final String ID_USER_TEXT = "xpath=//input[@placeholder = 'ユーザーID']";
	public static final String PASSWORD_TEXT = "xpath=//input[@placeholder = 'パスワード']";
	public static final String LOGIN_BUTTON = "xpath=//button[@type='submit']";
	public static final String ERROR_ID_USER_NAME = "xpath=//input[@placeholder = 'ユーザーID']/parent::div/../../following-sibling::div//mat-error";
	public static final String ERROR_PASSWORD = "xpath=//input[@autocomplete='password']/parent::div/../../following-sibling::div//mat-error";
	public static final String POPUP_ERROR = "xpath=//li[text()='ユーザーIDは、必ず指定してください。']/../../../..";
	public static final String OK_BUTTON_POPUP_ERROR = "xpath=//li[text()='ユーザーIDは、必ず指定してください。']/../../../..//span[text()=' OK ']";
	public static final String POPUP_ERROR_ID_OR_PASSWORD_INVALID = "xpath=//li[text()='ユーザーIDまたはパスワードが正しくありません。']/../../../..";
	public static final String OK_BUTTON_POPUP_ERROR_ID_OR_PASSWOD_INVALID = "xpath=//li[text()='ユーザーIDまたはパスワードが正しくありません。']/../../../..//span[text()=' OK ']/..";
}
