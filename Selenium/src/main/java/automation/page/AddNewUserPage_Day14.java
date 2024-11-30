package automation.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewUserPage_Day14 {

	private WebDriver driver;

	@FindBy(xpath = "//button[contains(text(),'Thêm mới')]")
	WebElement btnAddNew;
	@FindBy(name = "username")
	WebElement textHoVaTen;
	@FindBy(name = "email")
	WebElement textEmail;
	@FindBy(name = "phone_number")
	WebElement textPhoneNumber;
	@FindBy(name = "department_id")
	WebElement dropdownListPhongBan;
	@FindBy(name = "role_id")
	WebElement dropdownListChucDanh;
	@FindBy(name = "workarea_id")
	WebElement dropdownListKhuLamViec;
	@FindBy(name = "code_user")
	WebElement textMaNguoiDung;
	@FindBy(xpath = "//button[contains(text(),'Lưu')]")
	WebElement btnLuu;

	public AddNewUserPage_Day14(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void AddNewUserFunction(String hoten, String email, String sdt, String phongban, String chucdanh,
			String khulamviec, String usercode) {
		btnAddNew.click();
		;
		textHoVaTen.sendKeys(hoten);
		textEmail.sendKeys(email);
		textPhoneNumber.sendKeys(sdt);
		Select phongBanDropdownList = new Select(dropdownListPhongBan);
		phongBanDropdownList.selectByValue(phongban);
		Select chucDanhDropdownList = new Select(dropdownListChucDanh);
		chucDanhDropdownList.selectByValue(chucdanh);
		Select khuLamViecDropdownList = new Select(dropdownListKhuLamViec);
		khuLamViecDropdownList.selectByValue(khulamviec);
		textMaNguoiDung.sendKeys(usercode);
		btnLuu.click();
	}

	public void clickThemInConfirmPopUp() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement button = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@form='add_user']")));
		button.click();
	}

}
