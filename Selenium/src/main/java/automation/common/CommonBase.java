package automation.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonBase {

	public static WebDriver driver;
	public int initWaitTime = 40;

	public WebDriver initChromeDriver(String URL) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		System.out.println("user.dir is: " + System.getProperty("user.dir"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		return driver;
	}
}
