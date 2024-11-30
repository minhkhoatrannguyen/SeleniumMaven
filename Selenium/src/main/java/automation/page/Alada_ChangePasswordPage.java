package automation.page;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alada_ChangePasswordPage {
	
	private WebDriver driver;

	@FindBy(id = "txtpassword") WebElement textCurrentPassword;
	@FindBy(id = "txtnewpass") WebElement textNewPassword;
	@FindBy(id = "txtrenewpass") WebElement textConfirmNewPassword;
	@FindBy(xpath = "//button[contains(text(),'Lưu mật khẩu mới')]") WebElement btnSave;
	
	public Alada_ChangePasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ChinhSuaThongTinFunction(String currentPassword, String newPassword, String confirmNewPassword) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", btnSave);
		textCurrentPassword.sendKeys(currentPassword);
		textNewPassword.sendKeys(newPassword);
		textConfirmNewPassword.sendKeys(confirmNewPassword);
		btnSave.click();
	}
	
	public void CloseTheAlert() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public String GetTheAlertText() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        return alertText;
	}
}
