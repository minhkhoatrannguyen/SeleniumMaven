package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;

public class LocatorPractice extends CommonBase {

	@BeforeMethod
	public void openChrome() {
		// driver = initChromeDriver("https://selectorshub.com/xpath-practice-page/");
		//driver = initChromeDriver("https://bepantoan.vn/");
		driver = initChromeDriver("https://automationfc.github.io/basic-form/index.html");
	}

	@Test
	public void getLocatorSelectorHub() {
		WebElement username = driver.findElement(By.name("email"));
		System.out.println("username is: " + username);

		WebElement password = driver.findElement(By.xpath("//input[@title='Password']"));
		System.out.println("password is: " + password);

		WebElement company = driver.findElement(By.xpath("//div[@class='element-companyId']//input[@name='company']"));
		System.out.println("company is: " + company);

		WebElement mobileNumber = driver
				.findElement(By.xpath("//div[@class='element-companyId']//input[@name='mobile number']"));
		System.out.println("mobile number is: " + mobileNumber);
	}

	@Test
	public void getLocatorWebAnToan() {
		WebElement linkBepTu = driver.findElement(By.linkText("Bếp Từ"));
		System.out.println("link Bep Tu is: " + linkBepTu);
		
		WebElement linkMayHutMui = driver.findElement(By.linkText("Máy Hút Mùi"));
		System.out.println("link May Hut Mui is: " + linkMayHutMui);
		
		WebElement linkMayRuaChenBat = driver.findElement(By.partialLinkText("Máy Rửa Chén"));
		System.out.println("link May Rua Chen Bat is: " + linkMayRuaChenBat);
	}
	

	@Test
	public void getLocatorAutomationfc() {
		WebElement nameTxtBox = driver.findElement(By.id("name"));
		System.out.println("Text box name is: " + nameTxtBox);
		
		WebElement addressTxtArea = driver.findElement(By.id("address"));
		System.out.println("Text area address is: " + addressTxtArea);
		
		WebElement emailTxtBox = driver.findElement(By.name("email"));
		System.out.println("Text box email is: " + emailTxtBox);
		
		WebElement passwordTxtBox = driver.findElement(By.name("password"));
		System.out.println("Text box password is: " + passwordTxtBox);
	}
}
