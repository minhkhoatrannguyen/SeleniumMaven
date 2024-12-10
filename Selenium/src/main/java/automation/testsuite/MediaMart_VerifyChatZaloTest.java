package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class MediaMart_VerifyChatZaloTest extends CommonBase {

	@BeforeMethod
	public void openBrowser() {
		driver = initChromeDriver(CT_PageURL.MEDIAMART);
	}
	
	@Test
	public void VerifyButtonBatDauChatShowing() {
		click(By.xpath("//div[contains(@class,'btn-close')]"));
		driver.switchTo().frame(getElementPresentDOM(By.xpath("//iframe[@frameborder='0']")));
		click(By.xpath("//div[@class='logo']"));
		click(By.xpath("//div[contains(text(),'Chat nhanh')]"));
		assertTrue(isElementPresent(By.xpath("//div[contains(text(),'Xin chào! Siêu thị điện máy MediaMart rất vui được hỗ trợ bạn.')]")));
	}
	
	@AfterMethod
	public void closeWebPage() {
		driver.close();
	}

}
