package automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Alada_SignUpPage {

	private WebDriver driver;

	@FindBy(xpath = "//a[contains(text(),'Đăng Ký')]") WebElement btnSignUp;
	@FindBy(id = "txtFirstname") WebElement textHoTen;
	@FindBy(id = "txtEmail") WebElement textEmail;
	@FindBy(id = "txtCEmail") WebElement textConfirmEmail;
	@FindBy(id = "txtPassword") WebElement textPassword;
	@FindBy(id = "txtCPassword") WebElement textConfirmPassword;
	@FindBy(id = "txtPhone") WebElement textPhoneNumber;
	@FindBy(id = "chkRight") WebElement checkBoxAgree;
	@FindBy(xpath = "//button[contains(text(),'ĐĂNG KÝ') and @type='submit']") WebElement btnDangKy;
	
	public Alada_SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void SignUpFuction(String hoTen, String email, String confirmEmail, String password, String confirmPassword,
			String phoneNumber) {
		btnSignUp.click();
		textHoTen.sendKeys(hoTen);
		textEmail.sendKeys(email);
		textConfirmEmail.sendKeys(confirmEmail);
		textPassword.sendKeys(password);
		textConfirmPassword.sendKeys(confirmPassword);
		textPhoneNumber.sendKeys(phoneNumber);
		if (checkBoxAgree.isSelected() == false) {
			checkBoxAgree.click();
		}
		btnDangKy.click();
	}

}
