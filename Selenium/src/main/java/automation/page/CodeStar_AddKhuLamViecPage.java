package automation.page;

import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import automation.common.CommonBase;

public class CodeStar_AddKhuLamViecPage extends CommonBase {

	private WebDriver driver;

	public CodeStar_AddKhuLamViecPage(WebDriver driver) {
		this.driver = driver;
	}

	public void ThemKhuLamViec(String maKLV, String tenKLV) {
		click(By.xpath("//a[normalize-space()='Quản lý khu làm việc']"));
		click(By.xpath("//button[text()='Thêm mới']"));
		type(By.name("work_areas_code"), maKLV);
		type(By.name("name"), tenKLV);
		click(By.xpath("//button[contains(text(),'Lưu')]"));
		click(By.xpath("//button[contains(text(),'Thêm')]"));
	}
	
	public void ThemKhuLamViecInvalid(String maKLV, String tenKLV) {
		click(By.xpath("//a[normalize-space()='Quản lý khu làm việc']"));
		click(By.xpath("//button[text()='Thêm mới']"));
		type(By.name("work_areas_code"), maKLV);
		type(By.name("name"), tenKLV);
		click(By.xpath("//button[contains(text(),'Lưu')]"));
	}
	
	public void ClickNutLuuWithoutInputting() {
		click(By.xpath("//a[normalize-space()='Quản lý khu làm việc']"));
		click(By.xpath("//button[text()='Thêm mới']"));
		click(By.xpath("//button[contains(text(),'Lưu')]"));
	}
	
	public void ClickNutHuy() {
		click(By.xpath("//a[contains(text(),'Hủy')]"));
	}

	public void XoaKhuLamViecVuaThem(String maKLV, String tenKLV) {
		type(By.xpath("//input[@type='text']"), tenKLV);
		click(By.xpath("//button[contains(text(),'Tìm kiếm')]"));
		click(By.xpath("//td[text()='" + maKLV + "']/following-sibling::td/descendant::a[contains(text(),'Xóa')]"));
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public String generateRandomString(int length, int minCaps) {
		if (length < minCaps) {
			throw new IllegalArgumentException(
					"String length must be at least as long as the number of required capital letters.");
		}

		Random random = new Random();
		StringBuilder result = new StringBuilder(length);

		// Define the character pools
		String lower = "abcdefghijklmnopqrstuvwxyz";
		String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String allChars = lower + upper;

		// Add the minimum required capital letters
		for (int i = 0; i < minCaps; i++) {
			result.append(upper.charAt(random.nextInt(upper.length())));
		}

		// Fill the remaining characters randomly from all character pools
		for (int i = minCaps; i < length; i++) {
			result.append(allChars.charAt(random.nextInt(allChars.length())));
		}

		// Shuffle the result to mix capital letters
		return shuffleString(result.toString(), random);
	}

	// Utility method to shuffle a string
	private String shuffleString(String input, Random random) {
		char[] characters = input.toCharArray();
		for (int i = characters.length - 1; i > 0; i--) {
			int j = random.nextInt(i + 1);
			char temp = characters[i];
			characters[i] = characters[j];
			characters[j] = temp;
		}
		return new String(characters);
	}

}
