package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Account;
import automation.constant.CT_CodeStarTestingPage_Account;
import automation.constant.CT_PageURL;
import automation.page.AddNewUserPage_Day14;
import automation.page.LoginPage_Day14;

public class AddNewUserTest_Day14 extends CommonBase {

	@BeforeMethod
	public void openFireFox() {
		driver = initFirefoxDriver(CT_PageURL.codeStarTestingURL);
	}

	@Test(priority = 1)
	public void TC1_FailToAddNewUser() {
		LoginPage_Day14 login = new LoginPage_Day14(driver);
		login.LoginFunction(CT_CodeStarTestingPage_Account.email, CT_CodeStarTestingPage_Account.password);
		AddNewUserPage_Day14 addNewUser = new AddNewUserPage_Day14(driver);
		addNewUser.AddNewUserFunction("Khoa Trần", "1", "1", "3", "1", "7", "abc123");
		List<WebElement> elements = driver
				.findElements(By.xpath("//div[contains(text(),'Dữ liệu nhập vào sai định dạng')]"));
		for (WebElement element : elements) {
			Assert.assertTrue(element.isDisplayed(), "Element is not visible.");
		}
	}

	@Test(priority = 2)
	public void TC2_AddNewUserSuccessfully() {
		LoginPage_Day14 login = new LoginPage_Day14(driver);
		login.LoginFunction(CT_CodeStarTestingPage_Account.email, CT_CodeStarTestingPage_Account.password);
		AddNewUserPage_Day14 addNewUser = new AddNewUserPage_Day14(driver);
		addNewUser.AddNewUserFunction(CT_CodeStarTestingPage_Account.hoTen, CT_CodeStarTestingPage_Account.userEmail,
				CT_CodeStarTestingPage_Account.phoneNumber, CT_CodeStarTestingPage_Account.phongBan,
				CT_CodeStarTestingPage_Account.chucDanh, CT_CodeStarTestingPage_Account.khuLamViec,
				CT_CodeStarTestingPage_Account.userCode);
		addNewUser.clickThemInConfirmPopUp();
		assertTrue(
				driver.findElement(By.xpath("//div[contains(text(),'Thêm mới người dùng thành công')]")).isDisplayed());
	}

	@AfterMethod
	public void closeWebPage() {
		driver.close();
	}
}
