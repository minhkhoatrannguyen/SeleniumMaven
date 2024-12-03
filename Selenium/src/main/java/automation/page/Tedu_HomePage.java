package automation.page;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tedu_HomePage {

	private WebDriver driver;
	
	@FindBy(name = "keyword") WebElement textSearchBar;
	@FindBy(xpath = "//button[@type='submit']") WebElement btnSearch;
	
	public Tedu_HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void SearchByKeyword() {
		textSearchBar.sendKeys(inputKeyword());
		btnSearch.click();
	}
	
	public String inputKeyword() {
		String[] options = {"ASP", "ASP.Net", "asp.net", "asp"};
		Random random = new Random();
        int randomIndex = random.nextInt(options.length);
        String randomInput = options[randomIndex];
        return randomInput;
	}

}
