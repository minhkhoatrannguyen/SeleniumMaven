package automation.testsuite;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_CodeStarTestingPage_Account;
import automation.constant.CT_PageURL;
import automation.page.CodeStar_LoginPage;
import automation.page.LoginPage;

public class CodeStar_LoginTest extends CommonBase {

	@BeforeMethod
	public void openWebPage() {
		driver = initFirefoxDriver(CT_PageURL.codeStarTestingURL);
	}

	@Test(priority = 1)
	public void TC1_LoginSuccessfully() {
		CodeStar_LoginPage loginPage = new CodeStar_LoginPage(driver);
		loginPage.loginFunction(CT_CodeStarTestingPage_Account.email, CT_CodeStarTestingPage_Account.password);
		loginPage.waitForSuccessfullyToastMessageShowing();
		assertEquals(true, driver.findElement(By.xpath("//div[contains(text(),'Đăng nhập thành công!')]")).isDisplayed());
	}

	@Test(priority = 2)
	public void TC2_LoginWithUnregisteredEmail() {
		CodeStar_LoginPage loginPage = new CodeStar_LoginPage(driver);
		loginPage.loginFunction(CT_CodeStarTestingPage_Account.incorrectEmail, CT_CodeStarTestingPage_Account.password);
		loginPage.waitForIncorrectEmailPasswordToastMessageShowing();
		assertEquals(true, driver.findElement(By.xpath("//span[contains(text(),'Email hoặc mật khẩu không đúng')]")).isDisplayed());
	}
	
	@Test(priority = 3)
	public void TC3_LoginWithIncorrectPassword() {
		CodeStar_LoginPage loginPage = new CodeStar_LoginPage(driver);
		loginPage.loginFunction(CT_CodeStarTestingPage_Account.email, CT_CodeStarTestingPage_Account.incorrectPassword);
		loginPage.waitForIncorrectEmailPasswordToastMessageShowing();
		assertEquals(true, driver.findElement(By.xpath("//span[contains(text(),'Email hoặc mật khẩu không đúng')]")).isDisplayed());
	}
	
	@Test(priority = 4)
	public void TC4_LoginWithIncorrectEmailPassword() {
		CodeStar_LoginPage loginPage = new CodeStar_LoginPage(driver);
		loginPage.loginFunction(CT_CodeStarTestingPage_Account.incorrectEmail, CT_CodeStarTestingPage_Account.incorrectPassword);
		loginPage.waitForIncorrectEmailPasswordToastMessageShowing();
		assertEquals(true, driver.findElement(By.xpath("//span[contains(text(),'Email hoặc mật khẩu không đúng')]")).isDisplayed());
	}
	
	@Test(priority = 5)
	public void TC5_Logout() {
		CodeStar_LoginPage loginPage = new CodeStar_LoginPage(driver);
		loginPage.loginFunction(CT_CodeStarTestingPage_Account.email, CT_CodeStarTestingPage_Account.password);
		loginPage.logoutFunction();
		assertEquals(true, driver.findElement(By.xpath("//h4[contains(text(),'Đăng nhập')]")).isDisplayed());
	}

	@AfterMethod
	public void closeWebPage() {
		driver.close();
	}
}
