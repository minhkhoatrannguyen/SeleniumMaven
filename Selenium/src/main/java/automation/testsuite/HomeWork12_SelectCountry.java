package automation.testsuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class HomeWork12_SelectCountry extends CommonBase {

	@BeforeMethod
	public void openWebPage() {
		driver = initChromeDriver(CT_PageURL.globalsQA);
	}
	
	@Test
	public void selectAnyCountries() {
		Select selectCountryDropdownList = new Select(driver.findElement(By.xpath("//select")));
		selectCountryDropdownList.selectByVisibleText("Viet Nam");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String text = selectCountryDropdownList.getFirstSelectedOption().getText();
		System.out.println("What is selected? " + text);
	}
}
