package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day12_Checkbox extends CommonBase {

	@BeforeMethod
	public void openWebPage() {
		driver = initChromeDriver(CT_PageURL.demoQA);
	}

//	@Test
//	public void clickOneCheckBox() {
//		WebElement sportsCheckBox = driver
//				.findElement(By.xpath("//label[contains(text(),'Sports')]/preceding-sibling::input"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sportsCheckBox);
//		try {
//			if (sportsCheckBox.isSelected() == false) {
//				sportsCheckBox.click();
//				System.out.println("Checked on Sports");
//			} else {
//				System.out.println("Checked on before");
//			}
//		} catch (Exception ex) {
//			WebElement labelCheckBoxSports = driver.findElement(By.xpath("//label[contains(text(),'Sports')]"));
//			labelCheckBoxSports.click();
//		}
//	}

	@Test
	public void clickOnRadioButton() {
		WebElement maleRadioBtn = driver
				.findElement(By.xpath("//label[contains(text(),'Male')]/preceding-sibling::input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", maleRadioBtn);
		try {
		maleRadioBtn.click();
	    System.out.println("Checked on Male");
		} catch (Exception ex) {
			WebElement labelMaleRadioBtn = driver.findElement(By.xpath("//label[contains(text(),'Male')]"));
			labelMaleRadioBtn.click();
		}
	}
	
	@Test
	public void checkDefaultRadioButton() {
		WebElement maleRadioBtn = driver
				.findElement(By.xpath("//label[contains(text(),'Male')]/preceding-sibling::input"));
		WebElement femaleRadioBtn = driver
				.findElement(By.xpath("//label[contains(text(),'Female')]/preceding-sibling::input"));
		WebElement otherRadioBtn = driver
				.findElement(By.xpath("//label[contains(text(),'Other')]/preceding-sibling::input"));
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", maleRadioBtn);
	    System.out.println("Is male radio button selected ? " + maleRadioBtn.isSelected());
	    System.out.println("Is male radio button selected ? " + femaleRadioBtn.isSelected());
	    System.out.println("Is male radio button selected ? " + otherRadioBtn.isSelected());
	}
	
}
