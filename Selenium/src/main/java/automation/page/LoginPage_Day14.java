package automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_Day14 {

	private WebDriver driver;
	
	@FindBy(id="email") WebElement textEmail;
	@FindBy(id="password") WebElement textMatKhau;
	@FindBy(name="signin") WebElement btnDangNhap;
	public LoginPage_Day14(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void LoginFunction(String email, String matkhau) {
		textEmail.sendKeys(email);
		textMatKhau.sendKeys(matkhau);
		btnDangNhap.click();
	}

}
