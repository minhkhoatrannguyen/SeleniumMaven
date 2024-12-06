package automation.page;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import automation.common.CommonBase;

public class DemoGuru99_DeleteCustomerPage extends CommonBase {

	private WebDriver driver;

	public DemoGuru99_DeleteCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void DeleteCustomer(String customerID) {
		type(By.xpath("//input[@name='cusid']"), customerID);
		click(By.xpath("//input[@name='submit']"));		
	}
	
	public String generateRandomNumber(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than 0");
        }

        Random random = new Random();
        StringBuilder result = new StringBuilder();

        // Generate 'length' number of random digits
        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(10); // Random digit between 0-9
            result.append(digit);
        }

        return result.toString();
    }

}
