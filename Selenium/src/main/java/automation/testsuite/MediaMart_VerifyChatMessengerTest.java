package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class MediaMart_VerifyChatMessengerTest extends CommonBase {

	@BeforeMethod
	public void openBrowser() {
		driver = initChromeDriver(CT_PageURL.MEDIAMART);
	}
	
	@Test
	public void VerifyButtonBatDauChatShowing() {
		click(By.xpath("//div[contains(text(),'Gửi tin nhắn')]"));
		assertTrue(isElementPresent(By.xpath("//button[contains(text(),'Để lại tin nhắn')]")));
	}
	
	@AfterMethod
	public void closeWebPage() {
		driver.close();
	}

}
