package automation.constant;

import org.openqa.selenium.By;

public class CT_Account {
	public static By TEXT_EMAIL = By.id("txtLoginUsername");
	public static By TEXT_PASSWORD = By.id("txtLoginPassword");
	public static By BUTTON_LOGIN = By.xpath("//button[@type='submit']");
	public static String email = "khoaminhtran1999@gmail.com";
	public static String incorrectEmail = "khoaminhtran1999+1111111@gmail.com";
	public static String password = "Welcome2024!";
	public static String incorrectPassword = "abcabc@";
}
