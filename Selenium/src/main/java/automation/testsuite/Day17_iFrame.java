package automation.testsuite;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day17_iFrame extends CommonBase {

	@BeforeMethod
	@Parameters("browser")
	public void openBrowser(String browserName) {
		setUpDriver(browserName);
		driver.get(CT_PageURL.CODESTAR);
	}

	@Test
	public void DangKyNhanTuVanLoTrinh_ThatBai_ThieuEmail() {
		scrollToElement(By.xpath("//h2[contains(text(),'AWS/Kiểm thử/Lập trình web')]"));
		driver.switchTo().frame(1);
		type(By.name("name"),"autotest user");
		type(By.id("phone_number"),"123456");
		click(By.xpath("//button[normalize-space()='Gửi ngay']"));
		assertTrue(isElementPresent(By.xpath("//button[normalize-space()='Gửi ngay']")));
	}
}
