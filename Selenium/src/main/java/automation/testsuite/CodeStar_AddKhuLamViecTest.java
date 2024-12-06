package automation.testsuite;

import static org.testng.Assert.*;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_CodeStarTestingPage_Account;
import automation.constant.CT_PageURL;
import automation.page.CodeStar_AddKhuLamViecPage;
import automation.page.CodeStar_LoginPage;

public class CodeStar_AddKhuLamViecTest extends CommonBase {
	public CodeStar_LoginPage loginPage;
	public CodeStar_AddKhuLamViecPage addKhuLamViec;

	@BeforeMethod
	public void openWebPage() {
		driver = initFirefoxDriver(CT_PageURL.codeStarTestingURL);
		loginPage = new CodeStar_LoginPage(driver);
		addKhuLamViec = new CodeStar_AddKhuLamViecPage(driver);
	}

	@Test(priority = 1)
	public void TC1_AddVaXoaKhuLamViecSuccessfully() {
		loginPage.loginFunction(CT_CodeStarTestingPage_Account.email, CT_CodeStarTestingPage_Account.password);
		loginPage.waitForSuccessfullyToastMessageShowing();
		assertEquals(true, isElementPresent(By.xpath("//div[contains(text(),'Đăng nhập thành công!')]")));
		String randomString = addKhuLamViec.generateRandomString(4, 4);
		addKhuLamViec.ThemKhuLamViec(randomString, randomString);
		assertTrue(isElementPresent(By.xpath("//div[contains(text(),'Thêm mới khu vực làm việc thành công')]")));
		addKhuLamViec.XoaKhuLamViecVuaThem(randomString, randomString);
		assertTrue(isElementPresent(By.xpath("//div[contains(text(),'Xóa khu vực làm việc thành công')]")));
	}

	@Test(priority = 2)
	public void TC2_LeaveMandatoryFieldsWithBlankWhenAddKhuLamViec() {
		loginPage.loginFunction(CT_CodeStarTestingPage_Account.email, CT_CodeStarTestingPage_Account.password);
		loginPage.waitForSuccessfullyToastMessageShowing();
		assertEquals(true, isElementPresent(By.xpath("//div[contains(text(),'Đăng nhập thành công!')]")));
		addKhuLamViec.ClickNutLuuWithoutInputting();
		List<WebElement> elements = getElementSPresentDOM(
				By.xpath("//div[contains(text(),'Không được để trống trường này')]"));
		for (WebElement element : elements) {
			assertTrue(element.isDisplayed(), "Element is not displayed: " + element);
        }
	}
	
	@Test(priority = 3)
	public void TC3_InputAnExistedMaKLVWhenAddKhuLamViec() {
		loginPage.loginFunction(CT_CodeStarTestingPage_Account.email, CT_CodeStarTestingPage_Account.password);
		loginPage.waitForSuccessfullyToastMessageShowing();
		assertEquals(true, isElementPresent(By.xpath("//div[contains(text(),'Đăng nhập thành công!')]")));
		String randomString = addKhuLamViec.generateRandomString(4, 4);
		addKhuLamViec.ThemKhuLamViec(randomString, randomString);
		addKhuLamViec.ThemKhuLamViec(randomString, randomString);
		assertTrue(isElementPresent(By.xpath("//span[contains(text(),'Mã khu vực đã tồn tại')]")));
		addKhuLamViec.ClickNutHuy();
		addKhuLamViec.XoaKhuLamViecVuaThem(randomString, randomString);
	}
	
	@Test(priority = 4)
	public void TC4_InputInvalidMaKLVAndTenKLVWhenAddKhuLamViec() {
		loginPage.loginFunction(CT_CodeStarTestingPage_Account.email, CT_CodeStarTestingPage_Account.password);
		loginPage.waitForSuccessfullyToastMessageShowing();
		assertEquals(true, isElementPresent(By.xpath("//div[contains(text(),'Đăng nhập thành công!')]")));
		addKhuLamViec.ThemKhuLamViecInvalid(".......", ".......");
		List<WebElement> elements = getElementSPresentDOM(
				By.xpath("//div[contains(text(),'Dữ liệu nhập vào sai định dạng')]"));
		for (WebElement element : elements) {
			assertTrue(element.isDisplayed(), "Element is not displayed: " + element);
        }
	}

	@AfterMethod
	public void closeWebPage() {
		driver.close();
	}

}
