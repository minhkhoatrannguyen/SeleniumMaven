package automation.testsuite;

import static org.testng.Assert.*;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day17_Windows extends CommonBase {

	@BeforeMethod
	@Parameters("browser")
	public void openBrowser(String browserName) {
//		driver = initChromeDriver(CT_PageURL.GURUWINDOWS);
		setUpDriver(browserName);
		driver.get(CT_PageURL.GURUWINDOWS);
	}

	@Test
	public void HandleWindows() {
		String mainWindow = null;
		if (isElementPresent(By.xpath("//a[text()='Click Here']"))) {
			mainWindow = driver.getWindowHandle();
			click(By.xpath("//a[text()='Click Here']"));
		}
		Set<String> listWindows = driver.getWindowHandles();
		for (String window : listWindows) {
			if(!window.equals(mainWindow)) {
				driver.switchTo().window(window);
				pause(3000);
				assertEquals(driver.getCurrentUrl(),"https://demo.guru99.com/articles_popup.php");
				type(By.name("emailid"),"test@gmail.com");
				click(By.name("btnLogin"));
				assertTrue(isElementPresent(By.xpath("//h2[text()='Access details to demo site.']")));
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		System.out.println("Đã chuyển qua mainwindow thành công!");
	}
}
