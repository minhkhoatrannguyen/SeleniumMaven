package automation.testsuite;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_Account;
import automation.constant.CT_PageURL;
import automation.page.LoginPage;

public class LoginTest extends CommonBase {
	
	@BeforeMethod
	public void openWebPage() {
		driver = initChromeDriver(CT_PageURL.aladaURL);
	}

	@Test(priority = 1)
	public void TC1_LoginSuccessfully() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginFunction(CT_Account.email, CT_Account.password);
		assertEquals(true, driver.findElement(By.xpath("//a[text()='Khóa học của tôi' and @class='fleft martop20 khct']")).isDisplayed());
	}

	@Test(priority = 2)
	public void TC2_LoginWithUnregisteredEmail() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginFunction(CT_Account.incorrectEmail, CT_Account.password);
		assertEquals(true, driver.findElement(By.xpath("//p[contains(text(),'Email này chưa được đăng ký.')]")).isDisplayed());
	}
	
	@Test(priority = 3)
	public void TC2_LoginWithIncorrectPassword() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginFunction(CT_Account.email, CT_Account.incorrectPassword);
		assertEquals(true, driver.findElement(By.xpath("//p[contains(text(),'Mật khẩu sai.')]")).isDisplayed());
	}

	@AfterMethod
	public void closeWebPage() {
		driver.close();
	}

}
