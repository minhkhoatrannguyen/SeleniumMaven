package automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automation.common.CommonBase;
import automation.constant.CT_Account;

public class LoginPage extends CommonBase {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void loginFunction(String email, String password) {
		WebElement textEmail = driver.findElement(CT_Account.TEXT_EMAIL);
		WebElement textPassword = driver.findElement(CT_Account.TEXT_PASSWORD);
		WebElement btnLogin = driver.findElement(CT_Account.BUTTON_LOGIN);
		if (textEmail.isDisplayed()) {
			textEmail.clear();
			textEmail.sendKeys(email);
		}
		if (textPassword.isDisplayed()) {
			textPassword.clear();
			textPassword.sendKeys(password);
		}
		if (btnLogin.isDisplayed()) {
			btnLogin.click();
		}
	}
}
