package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.page.LoginPage_Day14;

public class LoginTest_Day14 extends CommonBase{

	@BeforeMethod
	public void openFireFox() {
		driver = initFirefoxDriver(CT_PageURL.codeStarTestingURL);
	}
	
	@Test(priority = 1)
	public void LoginSuccessfully() {
		LoginPage_Day14 login = new LoginPage_Day14(driver);
		login.LoginFunction("admin@gmail.com", "12345678");
		assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Quản lý người dùng')]")).isDisplayed());
	}
	
}
