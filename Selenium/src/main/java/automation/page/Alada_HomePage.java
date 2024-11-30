package automation.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alada_HomePage {

	private WebDriver driver;
	
	@FindBy(xpath = "//a[contains(text(),'Chỉnh sửa thông tin')]") WebElement btnEdit;
	@FindBy(xpath = "//a[contains(text(),'Thoát')]") WebElement btnThoat;
	
	public Alada_HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void hoverOnAccountInformation() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement dropdownListAccountInformation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='showsub']/a")));
		Actions actions = new Actions(driver);
		actions.moveToElement(dropdownListAccountInformation).click().perform();
	}
	
	public void clickEditButton() {
		btnEdit.click();
	}
	
	public void clickThoatButton() {
		btnThoat.click();
	}
}
