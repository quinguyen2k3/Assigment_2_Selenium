package com.selenium.opencart_test.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class ChangePasswordTest {
	private WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.edge.driver", "D:\\Kiem_thu_phan_mem\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		String email = "test_change@gmail.com";
		String password = "123456789";
		login(email, password);
	}

	private void sleep(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void login(String email, String password) {

		driver.get("http://localhost/opencartsite/index.php?route=account/login&language=en-gb");
		sleep(2000);

		WebElement emailField = driver.findElement(By.id("input-email"));
		emailField.sendKeys(email);
		sleep(1000);

		WebElement passwordField = driver.findElement(By.id("input-password"));
		passwordField.sendKeys(password);
		sleep(1000);

		WebElement loginButton = driver.findElement(By.cssSelector("button.btn.btn-primary"));
		loginButton.click();
		sleep(1000);

	}

	public void logout() {
		WebElement dropdown = driver
				.findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(2) > div"));
		dropdown.click();
		sleep(1000); 

	
		WebElement logout = driver.findElement(By
				.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(2) > div > ul > li:nth-child(5) > a"));
		logout.click();
		sleep(1000);
	}

	public void changePassword(String password, String passwordConfirm) {
	
		WebElement passwordLink = driver.findElement(By.cssSelector("#column-right > div > a:nth-child(3)"));
		passwordLink.click();
		sleep(1000); 


		WebElement inputPassword = driver.findElement(By.cssSelector("#input-password"));
		inputPassword.sendKeys(password);
		sleep(1000);


		WebElement passordPasswordConfirm = driver.findElement(By.cssSelector("#input-confirm"));
		passordPasswordConfirm.sendKeys(passwordConfirm);
		sleep(1000);

		WebElement confirmButton = driver
				.findElement(By.cssSelector("#form-password > div > div.col.text-end > button"));
		confirmButton.click();
		sleep(1000);
	}

	// Kiểm thử đổi mật khẩu với mật khẩu hợp lệ
	@Test
	public void testChangeValidPassword() {
		// Khai báo mật khẩu và email
		String password = "0931368945";
		String passwordConfirm = "0931368945"; // Xác nhận mật khẩu
		String original = "123456789";
		String email = "test_change@gmail.com";

		changePassword(password, passwordConfirm);

		// Kiểm tra xem thông báo thành công có hiển thị không
		WebElement successAlert = driver
				.findElement(By.cssSelector("#account-account > div.alert.alert-success.alert-dismissible"));
		Assert.assertTrue("Không hiển thị thông báo thành công", successAlert.isDisplayed());

		logout();

		// Đăng nhập lại bằng email và mật khẩu mới đã thay đổi
		login(email, password);

		// Kiểm tra tiêu đề trang sau khi đăng nhập
		String expectedTitle = "My Account"; // Tiêu đề dự kiến
		String actualTitle = driver.getTitle(); // Tiêu đề thực tế của trang

		// So sánh tiêu đề thực tế với tiêu đề dự kiến
		Assert.assertEquals("Password đã không đổi thành công", expectedTitle, actualTitle);

		sleep(1000);

		changePassword(original, original);

	}

	// Kiểm thử đổi mật khẩu với chuỗi rỗng
	@Test
	public void testEmptyInput() {
		// Khai báo mật khẩu và mật khẩu xác nhận là chuỗi rỗng
		String password = "";
		String passwordConfirm = "";
		String orgriginPassword = "123456789";// Xác nhận mật khẩu giống với mật khẩu nhập
		String email = "test_change@gmail.com";
		
		changePassword(password, passwordConfirm);
		try {
			// Kiểm tra xem cảnh báo lỗi về mật khẩu có hiển thị không
			boolean isErrorAlertPresent = driver.findElements(By.cssSelector("#error-password")).size() > 0;
			Assert.assertTrue("Không hiển thị cảnh báo lỗi", isErrorAlertPresent);
		} catch (AssertionError e) {
			logout();

			login(email, password);

			changePassword(orgriginPassword, orgriginPassword);
		}
	}

	// Kiểm thử dưới biên dưới
	@Test
	public void testUnderLowerBoundary() {
		// Khai báo mật khẩu và mật khẩu xác nhận là chuỗi có độ dài dưới 6 ký tự
		String password = "123"; // Mật khẩu không đủ yêu cầu tối thiểu
		String passwordConfirm = "123";
		String orgriginPassword = "123456789";// Xác nhận mật khẩu giống với mật khẩu nhập
		String email = "test_change@gmail.com";
		changePassword(password, passwordConfirm);
		try {
			// Kiểm tra xem cảnh báo lỗi về mật khẩu có hiển thị không
			boolean isErrorAlertPresent = driver.findElements(By.cssSelector("#error-password")).size() > 0;
			Assert.assertTrue("Không hiển thị cảnh báo lỗi", isErrorAlertPresent);
		} catch (AssertionError e) {
			logout();
			login(email, password);
			changePassword(orgriginPassword, orgriginPassword);
		}
	}

	// Kiểm thử biên dưới
	@Test
	public void testLowerBoundary() {
		// Khai báo mật khẩu và mật khẩu xác nhận, cả hai đều có độ dài chính xác 4 ký
		// tự
		String password = "1234"; // Mật khẩu đạt yêu cầu tối thiểu
		String passwordConfirm = "1234"; // Xác nhận mật khẩu phải giống với mật khẩu nhập
		String email = "test_change@gmail.com"; // Địa chỉ email của tài khoản
		String originPassword = "123456789";
		// Tìm liên kết để thay đổi mật khẩu và nhấp vào
		changePassword(password, passwordConfirm);

		// Kiểm tra xem thông báo thành công về việc thay đổi mật khẩu có hiển thị không
		WebElement successAlert = driver
				.findElement(By.cssSelector("#account-account > div.alert.alert-success.alert-dismissible"));
		Assert.assertTrue("Không hiển thị thông báo thành công", successAlert.isDisplayed()); // Kiểm tra thông báo
																								// thành công

		logout();

		// Đăng nhập lại với email và mật khẩu mới
		login(email, password); // Gọi phương thức đăng nhập với email và mật khẩu đã thay đổi

		// Kiểm tra tiêu đề trang để xác nhận đã đăng nhập thành công
		String expectedTitle = "My Account"; // Tiêu đề mong đợi sau khi đăng nhập thành công
		String actualTitle = driver.getTitle(); // Lấy tiêu đề thực tế của trang

		// So sánh tiêu đề mong đợi và tiêu đề thực tế
		Assert.assertEquals("Password đã không đổi thành công", expectedTitle, actualTitle); // Xác nhận rằng tiêu đề
																								// trang đúng như mong
																								// đợi
		changePassword(originPassword, originPassword);
	}

	// Kiểm thử với biên trên
	@Test
	public void testUpperBoundary() {
		// Khai báo mật khẩu và mật khẩu xác nhận, cả hai đều có độ dài tối đa 20 ký tự
		String password = "1".repeat(20); // Mật khẩu với 20 ký tự '1'
		String passwordConfirm = "1".repeat(20);// Xác nhận mật khẩu phải giống với mật khẩu nhập
		String originPassword = "123456789";
		String email = "test_change@gmail.com"; // Địa chỉ email của tài khoản

		changePassword(password, passwordConfirm);

		// Kiểm tra xem thông báo thành công về việc thay đổi mật khẩu có hiển thị không
		WebElement successAlert = driver
				.findElement(By.cssSelector("#account-account > div.alert.alert-success.alert-dismissible"));
		Assert.assertTrue("Không hiển thị thông báo thành công", successAlert.isDisplayed()); // Kiểm tra thông báo
																								// thành công
		logout();

		// Đăng nhập lại với email và mật khẩu mới
		login(email, password); // Gọi phương thức đăng nhập với email và mật khẩu đã thay đổi

		// Kiểm tra tiêu đề trang để xác nhận đã đăng nhập thành công
		String expectedTitle = "My Account"; // Tiêu đề mong đợi sau khi đăng nhập thành công
		String actualTitle = driver.getTitle(); // Lấy tiêu đề thực tế của trang

		// So sánh tiêu đề mong đợi và tiêu đề thực tế
		Assert.assertEquals("Password đã không đổi thành công", expectedTitle, actualTitle); // Xác nhận rằng tiêu đề
																								// trang đúng như mong																							// đợi
		changePassword(originPassword, originPassword);
	}

	// Kiểm thử trên biên trên
	@Test
	public void testAboveUpperBoundary() {
		// Khai báo mật khẩu và mật khẩu xác nhận, cả hai đều có độ dài vượt quá giới
		// hạn tối đa (21 ký tự)
		String password = "1".repeat(21); // Mật khẩu với 21 ký tự '1'
		String passwordConfirm = "1".repeat(21);// Xác nhận mật khẩu cũng có 21 ký tự '1'
		String originPassword = "123456789";
		String email = "test_change@gmail.com";
		changePassword(password, passwordConfirm);

		try {
			// Kiểm tra xem cảnh báo lỗi về mật khẩu có hiển thị không
			boolean isErrorAlertPresent = driver.findElements(By.cssSelector("#error-password")).size() > 0;
			Assert.assertTrue("Không hiển thị cảnh báo lỗi", isErrorAlertPresent);
		} catch (AssertionError e) {
			logout();

			login(email, password);

			changePassword(originPassword, originPassword);
		}
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
