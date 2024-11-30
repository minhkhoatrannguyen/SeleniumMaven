package automation.constant;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.openqa.selenium.By;

public class CT_Alada_Account {

	static LocalDateTime currentDateTime = LocalDateTime.now();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    static String formattedDateTime = currentDateTime.format(formatter);
	public static String hoTen = "Khoa Tran";
	public static String email = "khoatran" + formattedDateTime  + "@gmail.com";
	public static String emailSignIn = "khoatran@gmail.com";
	public static String conFirmEmail = email;
	public static String password = "Abc@123";
	public static String passwordSignIn = "abc@123";
	public static String confirmPassword = password;
	public static String phoneNumber = "0123456789";
	public static String newPassword = "abc@1234";
	public static String confirmNewPassword = newPassword;

}
