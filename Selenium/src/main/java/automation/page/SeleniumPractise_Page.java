package automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import automation.common.CommonBase;

public class SeleniumPractise_Page extends CommonBase {

	private WebDriver driver;

	public SeleniumPractise_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	public void CheckTheAlert() {
		click(By.xpath("//button[contains(text(),'Try it')]"));
		waitForAlert(10);
	}
}
