package automation.page;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.common.CommonBase;
import io.netty.util.internal.ThreadLocalRandom;

public class DemoGuru99_Page extends CommonBase {

	private WebDriver driver;
	
	@FindBy(name = "bdaytime") WebElement dateBox;
	@FindBy(xpath = "//input[@type='submit']") WebElement btnSubmit;

	public DemoGuru99_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	public void pickDateTime(String dateTime) {
//		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", dateBox);
//		dateBox.clear();
//		dateBox.sendKeys(dateTime);
		JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement inputElement = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//input[@name='bdaytime']"))));
        js.executeScript("arguments[0].value=arguments[1];", inputElement, dateTime);
	}

}
