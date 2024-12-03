package automation.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tedu_ChangePasswordPage {

	private WebDriver driver;

	@FindBy(xpath = "//a[contains(text(),'Đăng nhập')]") WebElement btnDirectToDangNhap;
	@FindBy(id = "UserName") WebElement textUsername;
	@FindBy(id = "Password") WebElement textPassword;
	@FindBy(xpath = "//button[contains(text(),'Đăng nhập')]") WebElement btnDangNhap;
	@FindBy(xpath = "//a[@title='Tài khoản' and @data-toggle='dropdown']") WebElement btnUsername;
	@FindBy(xpath = "//a[@title='Đổi mật khẩu']") WebElement btnDoiMatKhau;
	@FindBy(id = "OldPassword") WebElement textOldPassword;
	@FindBy(id = "NewPassword") WebElement textNewPassword;
	@FindBy(id = "ConfirmNewPassword") WebElement textConfirmNewPassword;
	@FindBy(xpath = "//input[@value='Cập nhật']") WebElement btnCapNhat;
	
	public Tedu_ChangePasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void SignInFunction(String username, String password) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btnDirectToDangNhap);
		textUsername.sendKeys(username);
		textPassword.sendKeys(password);
		btnDangNhap.click();
	}
	
	public void CloseNotification() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement btnLater = wait.until(ExpectedConditions.elementToBeClickable(By.id("onesignal-slidedown-cancel-button")));
		btnLater.click();
	}
	
	public void DirectToChangePasswordScreen() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btnUsername);
		btnDoiMatKhau.click();
	}
	
	public void ChangePasswordFunction(String currentPassword, String newPassword, String confirmNewPassword) {
		textOldPassword.sendKeys(currentPassword);
		textNewPassword.sendKeys(newPassword);
		textConfirmNewPassword.sendKeys(confirmNewPassword);
		btnCapNhat.click();
	}
	
	public void OnlyClickingCapNhatButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement btnCapNhat = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Cập nhật']")));
		btnCapNhat.click();
	}

}
