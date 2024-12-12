package automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day17_BepAnToan extends CommonBase {

	@BeforeMethod
	@Parameters("browser")
	public void openBrowser(String browserName) {
		setUpDriver(browserName);
		driver.get(CT_PageURL.BEPANTOAN);
	}

	@Test
	public void Click_ChatVoiChungToi() {
		String mainWindow = null;
		if (isElementPresent(By.xpath("//a[contains(@href,'m.me')]//span[contains(text(),'Chat với chúng tôi')]"))) {
			mainWindow = driver.getWindowHandle();
			click(By.xpath("//a[contains(@href,'m.me')]//span[contains(text(),'Chat với chúng tôi')]"));
		}
		Set<String> listWindows = driver.getWindowHandles();
		for (String window : listWindows) {
			if(!window.equals(mainWindow)) {
				driver.switchTo().window(window);
				assertEquals(driver.getCurrentUrl(),"https://www.messenger.com/login.php?next=https%3A%2F%2Fwww.messenger.com%2Ft%2F1463299120624512%2F%3Fmessaging_source%3Dsource%253Apages%253Amessage_shortlink%26source_id%3D1441792%26recurring_notification%3D0");
				type(By.id("email"),"test@gmail.com");
				type(By.id("pass"),"abcbabc");
				click(By.name("login"));
				assertTrue(isElementPresent(By.xpath("//div[text()=\"You can't use this feature at the moment\"]")));
				driver.close();
			}
		}		
	}
}
