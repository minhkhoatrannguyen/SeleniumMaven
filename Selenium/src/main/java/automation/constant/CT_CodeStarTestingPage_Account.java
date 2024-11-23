package automation.constant;

import org.openqa.selenium.By;

public class CT_CodeStarTestingPage_Account {

	public static By EMAIL_TEXTBOX = By.id("email");
	public static By PASSWORD_TEXTBOX = By.id("password");
	public static By DANGNHAP_BUTTON = By.xpath("//button[@name='signin']");
	public static By USERNAME_BUTTON = By.id("dropdownMenuLink");
	public static By LOGOUT_BUTTON = By.xpath("//button[contains(text(),'Đăng xuất') and @type='button']");
	public static By LOGOUTCONFIRM_BUTTON = By.xpath("//button[contains(text(),'Đăng xuất') and @type='submit']");
	public static String email = "admin@gmail.com";
	public static String incorrectEmail = "khoaminhtran1999@gmail.com";
	public static String password = "12345678";
	public static String incorrectPassword = "abcabc@";

}
