package automation.testsuite;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Alada_Account;
import automation.constant.CT_CodeStarTestingPage_Account;
import automation.constant.CT_PageURL;
import automation.page.AddNewUserPage_Day14;
import automation.page.Alada_HomePage;
import automation.page.Alada_SignUpPage;
import automation.page.LoginPage_Day14;

public class Alada_SignUpTest extends CommonBase {

	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(CT_PageURL.aladaURL);
	}
	
	@Test(priority = 1)
	public void TC1_SignUpSuccessfully() {
		Alada_SignUpPage signUp = new Alada_SignUpPage(driver);
		signUp.SignUpFuction(CT_Alada_Account.hoTen, CT_Alada_Account.email, CT_Alada_Account.conFirmEmail, CT_Alada_Account.password, CT_Alada_Account.confirmPassword, CT_Alada_Account.phoneNumber);
		Alada_HomePage homePage = new Alada_HomePage(driver);
		homePage.hoverOnAccountInformation();
		Assert.assertEquals((driver.findElement(By.xpath("//ul[@id='subulmenu']//p[1]"))).getText(), CT_Alada_Account.hoTen);
	}
	
	@AfterMethod
	public void closeWebPage() {
		driver.close();
	}
}
