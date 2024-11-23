package automation.testsuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day12_DropdownList extends CommonBase {

	@BeforeMethod
	public void openWebPage() {
		driver = initChromeDriver(CT_PageURL.codeStarAWS);
	}

	@Test
	public void chooseVietnamOption() {
		Select countryDropdownList = new Select(
				driver.findElement(By.xpath("//select[@id='product_categories_filter']")));
		countryDropdownList.selectByVisibleText(" Kiểm thử");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String text = countryDropdownList.getFirstSelectedOption().getText();
		System.out.println("Is Kiem Thu selected? " + text);

		countryDropdownList.selectByValue("https://codestar.vn/product-category/programming/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String text1 = countryDropdownList.getFirstSelectedOption().getText();
		System.out.println("Is Kiem Thu selected? " + text1);

		countryDropdownList.selectByIndex(0);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String text2 = countryDropdownList.getFirstSelectedOption().getText();
		System.out.println("Is Kiem Thu selected? " + text2);
	}

	@AfterMethod
	public void closeWebPage() {
		driver.close();
	}

}
