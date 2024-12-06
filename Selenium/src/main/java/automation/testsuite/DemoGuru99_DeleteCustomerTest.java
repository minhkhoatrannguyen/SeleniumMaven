package automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.page.DemoGuru99_DeleteCustomerPage;

public class DemoGuru99_DeleteCustomerTest extends CommonBase {

	@BeforeMethod
	public void openWebPage() {
		driver = initChromeDriver(CT_PageURL.deleteDemoGuru99);
	}

	@Test
	public void VerifyAlert() {
		DemoGuru99_DeleteCustomerPage deleteCustomer = new DemoGuru99_DeleteCustomerPage(driver);
		deleteCustomer.DeleteCustomer(deleteCustomer.generateRandomNumber(4));
		Alert firstAlert = driver.switchTo().alert();
		firstAlert.accept();
		Alert secondAlert = driver.switchTo().alert();
		assertEquals(secondAlert.getText(), "Customer Successfully Delete!");
		secondAlert.accept();
		assertEquals(driver.getCurrentUrl(), CT_PageURL.deleteDemoGuru99);
	}
	
	@AfterMethod
	public void closeWebPage() {
		driver.close();
	}
}
