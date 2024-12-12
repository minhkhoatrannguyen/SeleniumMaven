package automation.testsuite;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class DienMayNhapKhau_ZaloTest extends CommonBase {

	@BeforeMethod
	@Parameters("browser")
	public void openBrowser(String browserName) {
		setUpDriver(browserName);
		driver.get(CT_PageURL.DIENMAYNHAPKHAUGIARE);
	}
	
	@Test
	public void VerifyClickingOnZalo() {
		click(By.xpath("//a[contains(@href,'zalo')]"));
		assertFalse((driver.getCurrentUrl()).contains("id.zalo.me"),"id.zalo.me");
	}
}
