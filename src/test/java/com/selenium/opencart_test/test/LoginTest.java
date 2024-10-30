package com.selenium.opencart_test.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginTest {
	private WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.edge.driver",
				"D:\\Kiem_thu_phan_mem\\edgedriver_win64\\msedgedriver.exe");
		
		driver = new EdgeDriver();
		

	}

	private void sleep(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//Test trường hợp các dữ liệu đầu vào là hợp lệ
	@Test
	public void testValidLogin() {

		// Mở trang đăng nhập của Open Cart
		driver.get("http://localhost/opencartsite/index.php?route=account/login&language=en-gb");
		
		sleep(2000); // Tạm dừng để đảm bảo trang tải đầy đủ

		// Lấy trường nhập email và nhập địa chỉ email hợp lệ
		WebElement emailField = driver.findElement(By.id("input-email"));
		emailField.sendKeys("test_login@gmail.com");

		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập email hoàn tất

		// Lấy trường nhập mật khẩu và nhập mật khẩu hợp lệ
		WebElement passwordField = driver.findElement(By.id("input-password"));
		passwordField.sendKeys("123456789");

		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập mật khẩu hoàn tất

		// Lấy và nhấp vào nút đăng nhập
		WebElement loginButton = driver.findElement(By.cssSelector("button.btn.btn-primary"));
		loginButton.click();

		sleep(1000); // Tạm dừng để đảm bảo quá trình đăng nhập hoàn tất

		// Xác minh tiêu đề trang sau khi đăng nhập thành công
		String expectedTitle = "My Account";
		String actualTitle = driver.getTitle();

		// Kiểm tra xem tiêu đề trang có khớp với tiêu đề mong đợi không
		Assert.assertEquals("Lỗi quá trình đăng nhập", expectedTitle, actualTitle);
	}
	
	//Kiểm tra đăng nhập với email không hợp lệ
	@Test
	public void testInvalidEmailLogin() {

		// Mở trang đăng nhập của Open Cart
		driver.get("http://localhost/opencartsite/index.php?route=account/login&language=en-gb");
		
		sleep(2000); // Tạm dừng để đảm bảo trang tải đầy đủ

		// Lấy trường nhập email và nhập email không hợp lệ
		WebElement emailField = driver.findElement(By.id("input-email"));
		emailField.sendKeys("invalidemail");
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập email hoàn tất

		// Lấy trường nhập mật khẩu và nhập mật khẩu hợp lệ
		WebElement passwordField = driver.findElement(By.id("input-password"));
		passwordField.sendKeys("123456789");
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập mật khẩu hoàn tất

		// Lấy và nhấp vào nút đăng nhập
		WebElement loginButton = driver.findElement(By.cssSelector("button.btn.btn-primary"));
		loginButton.click();
		sleep(1000); // Tạm dừng để đảm bảo quá trình đăng nhập hoàn tất

		// Kiểm tra xem thông báo lỗi có hiển thị không
		WebElement errorMessage = driver.findElement(By.className("alert-danger"));
		Assert.assertTrue("Thông báo lỗi không hiển thị", errorMessage.isDisplayed());

		// Kiểm tra nội dung của thông báo lỗi khớp với thông báo mong đợi
		Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", errorMessage.getText());
	}
	
	//Kiểm thử với trường hợp mật khẩu không đúng
	
	@Test
	public void testInvalidPasswordLogin() {

		// Mở trang đăng nhập của Open Cart
		driver.get("http://localhost/opencartsite/index.php?route=account/login&language=en-gb");
		
		sleep(2000); // Tạm dừng để đảm bảo trang tải đầy đủ

		// Lấy trường nhập email và nhập email hợp lệ
		WebElement emailField = driver.findElement(By.id("input-email"));
		emailField.sendKeys("test_login@gmail.com");
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập email hoàn tất

		// Lấy trường nhập mật khẩu và nhập mật khẩu không hợp lệ
		WebElement passwordField = driver.findElement(By.id("input-password"));
		passwordField.sendKeys("dnsandkjdf");
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập mật khẩu hoàn tất

		// Lấy và nhấp vào nút đăng nhập
		WebElement loginButton = driver.findElement(By.cssSelector("button.btn.btn-primary"));
		loginButton.click();
		sleep(1000); // Tạm dừng để đảm bảo quá trình đăng nhập hoàn tất

		// Kiểm tra xem thông báo lỗi có hiển thị không
		WebElement errorMessage = driver.findElement(By.className("alert-danger"));
		Assert.assertTrue("Thông báo lỗi không hiển thị", errorMessage.isDisplayed());

		// Kiểm tra nội dung của thông báo lỗi khớp với thông báo mong đợi
		Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", errorMessage.getText());
	}
	
	
	//Kiểm thử đăng nhập với mật khẩu để trống
	@Test
	public void testEmptyPasswordLogin() {

		// Mở trang đăng nhập của Open Cart
		driver.get("http://localhost/opencartsite/index.php?route=account/login&language=en-gb");
		
		sleep(2000); // Tạm dừng để đảm bảo trang tải đầy đủ

		// Lấy trường nhập email và nhập email hợp lệ
		WebElement emailField = driver.findElement(By.id("input-email"));
		emailField.sendKeys("test_login@gmail.com");
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập email hoàn tất

		// Lấy trường nhập mật khẩu và để trống trường này
		WebElement passwordField = driver.findElement(By.id("input-password"));
		passwordField.sendKeys("");
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập mật khẩu hoàn tất

		// Lấy và nhấp vào nút đăng nhập
		WebElement loginButton = driver.findElement(By.cssSelector("button.btn.btn-primary"));
		loginButton.click();
		sleep(1000); // Tạm dừng để đảm bảo quá trình đăng nhập hoàn tất

		// Kiểm tra xem thông báo lỗi có hiển thị không
		WebElement errorMessage = driver.findElement(By.className("alert-danger"));
		Assert.assertTrue("Thông báo lỗi không hiển thị", errorMessage.isDisplayed());

		// Kiểm tra nội dung của thông báo lỗi khớp với thông báo mong đợi
		Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", errorMessage.getText());
	}
	
	// Kiểm tra với email để trống
	@Test
	public void testEmptyEmailLogin() {

		// Mở trang đăng nhập của Open Cart
		driver.get("http://localhost/opencartsite/index.php?route=account/login&language=en-gb");
		
		sleep(2000); // Tạm dừng để đảm bảo trang tải đầy đủ

		// Lấy trường nhập email và để trống trường này
		WebElement emailField = driver.findElement(By.id("input-email"));
		emailField.sendKeys("");
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Lấy trường nhập mật khẩu và nhập mật khẩu hợp lệ
		WebElement passwordField = driver.findElement(By.id("input-password"));
		passwordField.sendKeys("123456789");
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập mật khẩu hoàn tất

		// Lấy và nhấp vào nút đăng nhập
		WebElement loginButton = driver.findElement(By.cssSelector("button.btn.btn-primary"));
		loginButton.click();
		sleep(1000); // Tạm dừng để đảm bảo quá trình đăng nhập hoàn tất

		// Kiểm tra xem thông báo lỗi có hiển thị không
		WebElement errorMessage = driver.findElement(By.className("alert-danger"));
		Assert.assertTrue("Thông báo lỗi không hiển thị", errorMessage.isDisplayed());

		// Kiểm tra nội dung của thông báo lỗi khớp với thông báo mong đợi
		Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", errorMessage.getText());
	}
	
	//Kiểm tra đăng nhập với các ký tự đặc biệt
	@Test
	public void testSpecialCharacterLogin() {

		// Mở trang đăng nhập của Open Cart
		driver.get("http://localhost/opencartsite/index.php?route=account/login&language=en-gb");
		
		sleep(2000); // Tạm dừng để đảm bảo trang tải đầy đủ

		// Lấy trường nhập email và nhập chuỗi ký tự đặc biệt
		WebElement emailField = driver.findElement(By.id("input-email"));
		emailField.sendKeys("!@#$%^&*()<>?");
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập email hoàn tất

		// Lấy trường nhập mật khẩu và nhập chuỗi ký tự đặc biệt
		WebElement passwordField = driver.findElement(By.id("input-password"));
		passwordField.sendKeys("!@#$%^&*()");
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập mật khẩu hoàn tất

		// Lấy và nhấp vào nút đăng nhập
		WebElement loginButton = driver.findElement(By.cssSelector("button.btn.btn-primary"));
		loginButton.click();
		sleep(1000); // Tạm dừng để đảm bảo quá trình đăng nhập hoàn tất

		// Kiểm tra xem thông báo lỗi có hiển thị không
		WebElement errorMessage = driver.findElement(By.className("alert-danger"));
		Assert.assertTrue("Thông báo lỗi không hiển thị", errorMessage.isDisplayed());

		// Kiểm tra nội dung của thông báo lỗi khớp với thông báo mong đợi
		Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", errorMessage.getText());
	}
	
	//Kiểm tra đăng nhập với SQL Injection
	@Test
	public void testSQLInjectionAttempt() {

		// Mở trang đăng nhập của Open Cart
		driver.get("http://localhost/opencartsite/index.php?route=account/login&language=en-gb");
		
		sleep(2000); // Tạm dừng để đảm bảo trang tải đầy đủ

		// Lấy trường nhập email và thực hiện thử nghiệm tấn công SQL Injection với chuỗi đặc biệt
		WebElement emailField = driver.findElement(By.id("input-email"));
		emailField.sendKeys("admin' OR '1'='1");
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập email hoàn tất

		// Lấy trường nhập mật khẩu và thực hiện thử nghiệm tấn công SQL Injection với chuỗi đặc biệt
		WebElement passwordField = driver.findElement(By.id("input-password"));
		passwordField.sendKeys("password' OR '1'='1");
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập mật khẩu hoàn tất

		// Lấy và nhấp vào nút đăng nhập
		WebElement loginButton = driver.findElement(By.cssSelector("button.btn.btn-primary"));
		loginButton.click();
		sleep(1000); // Tạm dừng để đảm bảo quá trình đăng nhập hoàn tất

		// Kiểm tra xem thông báo lỗi có hiển thị không, xác nhận hệ thống ngăn chặn SQL Injection
		WebElement errorMessage = driver.findElement(By.className("alert-danger"));
		Assert.assertTrue("Thông báo lỗi không hiển thị", errorMessage.isDisplayed());

		// Kiểm tra nội dung của thông báo lỗi khớp với thông báo mong đợi
		Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", errorMessage.getText());
	}


	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
