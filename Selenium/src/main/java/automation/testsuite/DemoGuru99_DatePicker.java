package automation.testsuite;

import static org.testng.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_CodeStarTestingPage_Account;
import automation.constant.CT_PageURL;
import automation.page.AddNewUserPage_Day14;
import automation.page.DemoGuru99_Page;
import automation.page.LoginPage_Day14;
import io.netty.util.internal.ThreadLocalRandom;

public class DemoGuru99_DatePicker extends CommonBase {

	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(CT_PageURL.demoGuru99);
	}
	
	@Test(priority = 1)
	public void TC1_PickBirthdayDate() {
		DemoGuru99_Page demoGuru = new DemoGuru99_Page(driver);
		LocalDateTime startDate = LocalDateTime.of(2000, 1, 1, 0, 0);
		LocalDateTime endDate = LocalDateTime.of(2024, 12, 31, 23, 59);
		long startEpochSecond = startDate.toEpochSecond(java.time.ZoneOffset.UTC);
        long endEpochSecond = endDate.toEpochSecond(java.time.ZoneOffset.UTC);
        long randomEpochSecond = ThreadLocalRandom.current().nextLong(startEpochSecond, endEpochSecond);
        LocalDateTime randomDateTime = LocalDateTime.ofEpochSecond(randomEpochSecond, 0, java.time.ZoneOffset.UTC);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
        String formattedDateTime = randomDateTime.format(formatter);
		demoGuru.pickDateTime(formattedDateTime);
		assertEquals(driver.findElement(By.xpath("//input[@name='bdaytime']")).getText(), formattedDateTime);
	}
	
	@AfterMethod
	public void closeWebPage() {
		driver.close();
	}

}
