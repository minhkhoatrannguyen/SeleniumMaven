package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day16_Alert extends CommonBase {

	@BeforeMethod
	public void openWebPage() {
		driver = initFirefoxDriver(CT_PageURL.alert);
	}
	@Test
	public void thucHanh() {
		click(By.xpath("//a[contains(text(),'Alert with Textbox')]"));
		click(By.xpath("//button[contains(text(),'demonstrate the prompt box')]"));
		driver.switchTo().alert().sendKeys("Our great class");
		driver.switchTo().alert().accept();
		assertTrue(isElementPresent(By.xpath("//p[text()='Hello Our great class How are you today']")));
	}

}
