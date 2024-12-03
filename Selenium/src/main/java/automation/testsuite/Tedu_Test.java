package automation.testsuite;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.constant.CT_TeduPage_Account;
import automation.page.Tedu_ChangePasswordPage;
import automation.page.Tedu_HomePage;

public class Tedu_Test extends CommonBase {
	
	public Tedu_ChangePasswordPage changePassword;
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(CT_PageURL.teduURL);
		changePassword = new Tedu_ChangePasswordPage(driver);
	}
	
	@Test(priority = 1)
	public void TC1_SignInSuccessfully() {
		changePassword.CloseNotification();
		changePassword.SignInFunction(CT_TeduPage_Account.email, CT_TeduPage_Account.password);
		assertTrue(driver.findElement(By.xpath("//a[@title='Tài khoản' and @data-toggle='dropdown']")).isDisplayed());
	}
	
	@Test(priority = 2)
	public void TC2_ChangePasswordSuccessfully() {
		changePassword.CloseNotification();
		changePassword.SignInFunction(CT_TeduPage_Account.email, CT_TeduPage_Account.password);
		changePassword.DirectToChangePasswordScreen();
		changePassword.ChangePasswordFunction(CT_TeduPage_Account.password, CT_TeduPage_Account.newPassword, CT_TeduPage_Account.newPassword);
		assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Đổi mật khẩu thành công. Mời bạn đăng nhập lại.')]")).isDisplayed());
		changePassword.SignInFunction(CT_TeduPage_Account.email, CT_TeduPage_Account.newPassword);
		assertTrue(driver.findElement(By.xpath("//a[@title='Tài khoản' and @data-toggle='dropdown']")).isDisplayed());
		changePassword.DirectToChangePasswordScreen();
		changePassword.ChangePasswordFunction(CT_TeduPage_Account.newPassword, CT_TeduPage_Account.password, CT_TeduPage_Account.password);
	}
	
	@Test(priority = 3)
	public void TC3_SearchASPNET() {
		changePassword.CloseNotification();
		Tedu_HomePage homePage = new Tedu_HomePage(driver);
		homePage.SearchByKeyword();
		List<WebElement> items = driver.findElements(By.cssSelector(".blog-list-content"));
		boolean isWordPresent = false;
		for (WebElement item : items) {
            if (item.getText().contains(homePage.inputKeyword())) {
                isWordPresent = true;
                break; 
            }
        }
		assertFalse(isWordPresent, "The word '" + homePage.inputKeyword() + "' was not found in the list!");
	}
	
	@Test(priority = 4)
	public void TC4_ChangePasswordUnsuccessfullyWhenLeavingAllRequiredFieldsWithBlank() {
		changePassword.CloseNotification();
		changePassword.SignInFunction(CT_TeduPage_Account.email, CT_TeduPage_Account.password);
		changePassword.DirectToChangePasswordScreen();
		changePassword.OnlyClickingCapNhatButton();
		assertTrue(driver.findElement(By.xpath("//span[contains(text(),'The Mật khẩu hiện tại field is required.')]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//span[contains(text(),'The Mật khẩu mới field is required.')]")).isDisplayed());
	}
	
	@Test(priority = 5)
	public void TC5_ChangePasswordUnsuccessfullyWhenInputtingWrongCurrentPassword() {
		changePassword.CloseNotification();
		changePassword.SignInFunction(CT_TeduPage_Account.email, CT_TeduPage_Account.password);
		changePassword.DirectToChangePasswordScreen();
		changePassword.ChangePasswordFunction(CT_TeduPage_Account.newPassword, CT_TeduPage_Account.newPassword, CT_TeduPage_Account.newPassword);
		assertTrue(driver.findElement(By.xpath("//li[contains(text(),'Có lỗi khi đổi mật khẩu. Liên hệ quản trị để được hỗ trợ.')]")).isDisplayed());
	}
	
	@Test(priority = 6)
	public void TC6_ChangePasswordUnsuccessfullyWhenInputtingWrongFormatNewPassword() {
		changePassword.CloseNotification();
		changePassword.SignInFunction(CT_TeduPage_Account.email, CT_TeduPage_Account.password);
		changePassword.DirectToChangePasswordScreen();
		changePassword.ChangePasswordFunction(CT_TeduPage_Account.password, CT_TeduPage_Account.invalidPassword, CT_TeduPage_Account.invalidPassword);
		assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Mật khẩu phải từ 6-40 ký tự.')]")).isDisplayed());
	}
	
	@Test(priority = 7)
	public void TC7_ChangePasswordUnsuccessfullyWhenInputtingNewPasswordAndConfirmPasswordNoMatching() {
		changePassword.CloseNotification();
		changePassword.SignInFunction(CT_TeduPage_Account.email, CT_TeduPage_Account.password);
		changePassword.DirectToChangePasswordScreen();
		changePassword.ChangePasswordFunction(CT_TeduPage_Account.password, CT_TeduPage_Account.newPassword, CT_TeduPage_Account.password);
		assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Xác nhận mật khẩu không đúng.')]")).isDisplayed());
	}
	
	@AfterMethod
	public void closeWebPage() {
		driver.close();
	}

}
