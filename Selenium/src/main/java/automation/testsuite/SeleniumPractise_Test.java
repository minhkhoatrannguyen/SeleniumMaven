package automation.testsuite;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.page.SeleniumPractise_Page;

public class SeleniumPractise_Test extends CommonBase {

	@BeforeMethod
	public void openWebPage() {
		driver = initChromeDriver(CT_PageURL.seleniumPractise);
	}

	@Test
	public void TestingAlert() {
		SeleniumPractise_Page verifyAlert = new SeleniumPractise_Page(driver);
		verifyAlert.CheckTheAlert();
		assertEquals(getTextOfAlert(), "Welcome to Selenium WebDriver Tutorials");
	}

	@AfterMethod
	public void closeWebPage() {
		driver.close();
	}

}
