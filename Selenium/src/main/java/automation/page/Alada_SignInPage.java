package automation.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alada_SignInPage {

	private WebDriver driver;

	@FindBy(id = "txtLoginUsername") WebElement textEmail;
	@FindBy(id = "txtLoginPassword") WebElement textPassword;
	@FindBy(xpath = "//button[contains(text(),'ĐĂNG NHẬP') and @type='submit']") WebElement btnDangNhap;
	
	public Alada_SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void SignInFunction(String email, String password) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement btnSignIn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Đăng Nhập')]")));
		btnSignIn.click();
		textEmail.sendKeys(email);
		textPassword.sendKeys(password);
		btnDangNhap.click();
	}
	
}
