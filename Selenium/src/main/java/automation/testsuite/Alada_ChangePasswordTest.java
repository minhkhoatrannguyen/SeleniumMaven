package automation.testsuite;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_Alada_Account;
import automation.constant.CT_PageURL;
import automation.page.Alada_ChangePasswordPage;
import automation.page.Alada_HomePage;
import automation.page.Alada_SignInPage;
import automation.page.Alada_SignUpPage;

public class Alada_ChangePasswordTest extends CommonBase {

	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(CT_PageURL.aladaURL);
	}
	
	@Test(priority = 1)
	public void TC1_ChangePasswordSuccessfully() {
		Alada_SignInPage signIn = new Alada_SignInPage(driver);
		signIn.SignInFunction(CT_Alada_Account.emailSignIn, CT_Alada_Account.passwordSignIn);
		Alada_HomePage homePage = new Alada_HomePage(driver);
		homePage.hoverOnAccountInformation();
		homePage.clickEditButton();
		Alada_ChangePasswordPage changePassword = new Alada_ChangePasswordPage(driver);
		changePassword.ChinhSuaThongTinFunction(CT_Alada_Account.passwordSignIn, CT_Alada_Account.newPassword, CT_Alada_Account.confirmNewPassword);
		Assert.assertEquals(changePassword.GetTheAlertText(), "Cập nhật mật khẩu mới thành công!");
		changePassword.CloseTheAlert();
		homePage.hoverOnAccountInformation();
		homePage.clickThoatButton();
		signIn.SignInFunction(CT_Alada_Account.emailSignIn, CT_Alada_Account.newPassword);
		homePage.hoverOnAccountInformation();
		Assert.assertEquals((driver.findElement(By.xpath("//ul[@id='subulmenu']//p[1]")).getText()), CT_Alada_Account.hoTen);
	}
	
	@AfterMethod
	public void ChangePasswordToTheOldOne() {
		Alada_HomePage homePage = new Alada_HomePage(driver);
		homePage.clickEditButton();
		Alada_ChangePasswordPage changePassword = new Alada_ChangePasswordPage(driver);
		changePassword.ChinhSuaThongTinFunction(CT_Alada_Account.newPassword, CT_Alada_Account.passwordSignIn, CT_Alada_Account.passwordSignIn);
	}
	
	@AfterClass
	public void closeWebSite() {
		driver.close();
	}

}
