package automation.page;

import java.time.Clock;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.common.CommonBase;
import automation.constant.CT_CodeStarTestingPage_Account;

public class CodeStar_LoginPage extends CommonBase {

	private WebDriver driver;

	public CodeStar_LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void loginFunction(String email, String password) {
		WebElement textEmail = driver.findElement(CT_CodeStarTestingPage_Account.EMAIL_TEXTBOX);
		WebElement textPassword = driver.findElement(CT_CodeStarTestingPage_Account.PASSWORD_TEXTBOX);
		WebElement btnLogin = driver.findElement(CT_CodeStarTestingPage_Account.DANGNHAP_BUTTON);
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
	
	public void waitForSuccessfullyToastMessageShowing() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Đăng nhập thành công!')]")));
	}
	
	public void waitForIncorrectEmailPasswordToastMessageShowing() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Email hoặc mật khẩu không đúng')]")));
	}
	
	public void logoutFunction() {
        WebElement btnAdmin = driver.findElement(CT_CodeStarTestingPage_Account.USERNAME_BUTTON);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isToastGone = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'Đăng nhập thành công!')]")));
        if (isToastGone) {
        	btnAdmin.click();
		}
        WebElement btnLogout = driver.findElement(CT_CodeStarTestingPage_Account.LOGOUT_BUTTON);
        if (btnLogout.isDisplayed()) {
        	btnLogout.click();
		}
        WebElement btnLogoutConfirm = driver.findElement(CT_CodeStarTestingPage_Account.LOGOUTCONFIRM_BUTTON);
        if (btnLogoutConfirm.isDisplayed()) {
        	btnLogoutConfirm.click();
		}
	}
}
