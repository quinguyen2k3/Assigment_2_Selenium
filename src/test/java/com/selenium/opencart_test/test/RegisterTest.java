package com.selenium.opencart_test.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class RegisterTest {
	private WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.edge.driver", "D:\\Kiem_thu_phan_mem\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
	}

	private void sleep(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Kiểm thử đăng ký với dữ liệu hợp lệ
	@Test
	public void testRegisterValidData() {
		// Khai báo thông tin hợp lệ cho người dùng mới
		String firstName = "Anna";
		String lastName = "Tran";
		String email = "test_register_01@gmail.com";
		String password = "123456789";

		// Thông báo mong đợi sau khi đăng ký thành công
		String notificationExpected = "Your Account Has Been Created!";

		// Mở trang đăng ký của Open Cart
		driver.get("http://localhost/opencartsite/index.php?route=account/register&language=en-gb");
		sleep(1000); // Tạm dừng để đảm bảo trang tải đầy đủ

		// Nhập thông tin tên
		WebElement inputFirstName = driver.findElement(By.cssSelector("#input-firstname"));
		inputFirstName.sendKeys(firstName);
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Nhập thông tin họ
		WebElement inputLastName = driver.findElement(By.cssSelector("#input-lastname"));
		inputLastName.sendKeys(lastName);
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Nhập địa chỉ email
		WebElement inputEmail = driver.findElement(By.cssSelector("#input-email"));
		inputEmail.sendKeys(email);
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Nhập mật khẩu
		WebElement inputPassword = driver.findElement(By.cssSelector("#input-password"));
		inputPassword.sendKeys(password);
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Cuộn trang để hiển thị checkbox chính sách quyền riêng tư
		WebElement privacyPolicy = driver.findElement(By.cssSelector("#form-register > div > div > input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", privacyPolicy);
		sleep(1000);
		privacyPolicy.click(); // Nhấp vào checkbox để chấp nhận chính sách quyền riêng tư
		sleep(1000);

		// Nhấp vào nút tiếp tục để hoàn tất đăng ký
		WebElement continueBtn = driver.findElement(By.cssSelector("#form-register > div > button"));
		continueBtn.click();
		sleep(2000); // Tạm dừng để đảm bảo quá trình đăng ký hoàn tất

		// Lấy thông báo sau khi đăng ký và kiểm tra xem nó có khớp với thông báo mong
		// đợi không
		WebElement notification = driver.findElement(By.cssSelector("#content > h1"));
		String notificationActual = notification.getText();
		Assert.assertEquals("Quá trình đăng ký không thành công", notificationExpected, notificationActual);
	}

	// Kiểm thử đăng ký với các input bắt buộc bị bỏ trống.
	@Test
	public void testRegisterEmptyRequiredInput() {
		// Khai báo thông tin rỗng cho các trường yêu cầu
		String firstName = "";
		String lastName = "";
		String email = "";
		String password = "";

		// Mở trang đăng ký của Open Cart
		driver.get("http://localhost/opencartsite/index.php?route=account/register&language=en-gb");
		sleep(1000); // Tạm dừng để đảm bảo trang tải đầy đủ

		// Nhập thông tin tên (rỗng)
		WebElement inputFirstName = driver.findElement(By.cssSelector("#input-firstname"));
		inputFirstName.sendKeys(firstName);
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Nhập thông tin họ (rỗng)
		WebElement inputLastName = driver.findElement(By.cssSelector("#input-lastname"));
		inputLastName.sendKeys(lastName);
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Nhập địa chỉ email (rỗng)
		WebElement inputEmail = driver.findElement(By.cssSelector("#input-email"));
		inputEmail.sendKeys(email);
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Nhập mật khẩu (rỗng)
		WebElement inputPassword = driver.findElement(By.cssSelector("#input-password"));
		inputPassword.sendKeys(password);
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Cuộn trang để hiển thị nút tiếp tục và nhấp vào nó
		WebElement continueBtn = driver.findElement(By.cssSelector("#form-register > div > button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueBtn);
		sleep(1000);
		continueBtn.click();
		sleep(2000); // Tạm dừng để đảm bảo quá trình xử lý hoàn tất

		// Lấy các thông báo lỗi cho các trường nhập rỗng
		boolean warningFirstName = driver.findElements(By.cssSelector("#error-firstname")).size() > 0;
		boolean warningLastName = driver.findElements(By.cssSelector("#error-lastname")).size() > 0;
		boolean warningPassword = driver.findElements(By.cssSelector("#error-password")).size() > 0;
		boolean warningEmail = driver.findElements(By.cssSelector("#error-email")).size() > 0;
		boolean warningPrivacyPolicy = driver.findElements(By.cssSelector("#alert > dirv")).size() > 0;
		// Kiểm tra các thông báo lỗi cho tên, họ và mật khẩu

		// Kiểm tra xem các thông báo lỗi có hiển thị không
		Assert.assertTrue("Khong hien thi warning FirstName", warningFirstName);
		Assert.assertTrue("Khong hien thi warning LastName", warningLastName);
		Assert.assertTrue("Khong hien thi warning Password", warningPassword);

		// Kiểm tra xem các thông báo lỗi có hiển thị không
		Assert.assertTrue("Khong hien thi warning FirstName", warningFirstName);
		Assert.assertTrue("Khong hien thi warning LastName", warningLastName);
		Assert.assertTrue("Khong hien thi warning Email", warningEmail);
		Assert.assertTrue("Khong hien thi warning Password", warningPassword);
		Assert.assertTrue("Khong hien thi warning Privacy Policy", warningPrivacyPolicy);
	}

	// Kiểm tra đăng ký với email không hợp lệ
	@Test
	public void testRegisterInvalidEmail() {
		// Khai báo thông tin cho người dùng mới với địa chỉ email không hợp lệ
		String firstName = "Anna";
		String lastName = "Tran";
		String email = "email.com"; // Email không hợp lệ (thiếu '@')
		String password = "123456789";

		// Mở trang đăng ký của Open Cart
		driver.get("http://localhost/opencartsite/index.php?route=account/register&language=en-gb");
		sleep(1000); // Tạm dừng để đảm bảo trang tải đầy đủ

		// Nhập thông tin tên
		WebElement inputFirstName = driver.findElement(By.cssSelector("#input-firstname"));
		inputFirstName.sendKeys(firstName);
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Nhập thông tin họ
		WebElement inputLastName = driver.findElement(By.cssSelector("#input-lastname"));
		inputLastName.sendKeys(lastName);
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Nhập địa chỉ email (không hợp lệ)
		WebElement inputEmail = driver.findElement(By.cssSelector("#input-email"));
		inputEmail.sendKeys(email);
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Nhập mật khẩu
		WebElement inputPassword = driver.findElement(By.cssSelector("#input-password"));
		inputPassword.sendKeys(password);
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Cuộn trang để hiển thị checkbox chính sách quyền riêng tư và nhấp vào
		WebElement privacyPolicy = driver.findElement(By.cssSelector("#form-register > div > div > input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", privacyPolicy);
		sleep(1000);
		privacyPolicy.click();
		sleep(1000);

		// Cuộn trang để hiển thị nút tiếp tục và nhấp vào
		WebElement continueBtn = driver.findElement(By.cssSelector("#form-register > div > button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueBtn);
		sleep(1000);
		continueBtn.click();
		sleep(2000); // Tạm dừng để đảm bảo quá trình xử lý hoàn tất

		// Kiểm tra tính hợp lệ của địa chỉ email
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Boolean isValid = (Boolean) js.executeScript("return arguments[0].checkValidity();", inputEmail);
		String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", inputEmail);

		// Kiểm tra xem không có thông báo lỗi và thông báo xác thực có chứa văn bản
		// mong đợi không
		Assert.assertTrue("Không có thông báo lỗi khi nhập email sai định dạng",
				!isValid && validationMessage.contains("Please include an '@' in the email address."));
	}

	// Kiểm tra đăng ký với email đã được đăng ký
	@Test
	public void testRegisterRegistedEmail() {
		// Khai báo thông tin cho người dùng mới với địa chỉ email đã được đăng ký
		String firstName = "Anna";
		String lastName = "Tran";
		String email = "bichqui1212@gmail.com"; // Email đã được đăng ký
		String password = "123456789";

		// Mở trang đăng ký của Open Cart
		driver.get("http://localhost/opencartsite/index.php?route=account/register&language=en-gb");
		sleep(1000); // Tạm dừng để đảm bảo trang tải đầy đủ

		// Nhập thông tin tên
		WebElement inputFirstName = driver.findElement(By.cssSelector("#input-firstname"));
		inputFirstName.sendKeys(firstName);
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Nhập thông tin họ
		WebElement inputLastName = driver.findElement(By.cssSelector("#input-lastname"));
		inputLastName.sendKeys(lastName);
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Nhập địa chỉ email (đã được đăng ký)
		WebElement inputEmail = driver.findElement(By.cssSelector("#input-email"));
		inputEmail.sendKeys(email);
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Nhập mật khẩu
		WebElement inputPassword = driver.findElement(By.cssSelector("#input-password"));
		inputPassword.sendKeys(password);
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Cuộn trang để hiển thị checkbox chính sách quyền riêng tư và nhấp vào
		WebElement privacyPolicy = driver.findElement(By.cssSelector("#form-register > div > div > input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", privacyPolicy);
		sleep(1000);
		privacyPolicy.click();
		sleep(1000);

		// Cuộn trang để hiển thị nút tiếp tục và nhấp vào
		WebElement continueBtn = driver.findElement(By.cssSelector("#form-register > div > button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueBtn);
		sleep(1000);
		continueBtn.click();
		sleep(2000); // Tạm dừng để đảm bảo quá trình
	}

	// Kiểm thử với biên trên
	@Test
	public void testRegisterUpperBoundary() {
		// Khai báo thông tin cho người dùng mới với độ dài thông tin ở ranh giới tối đa
		String firstName = "A".repeat(32); // Họ tên (32 ký tự)
		String lastName = "T".repeat(32); // Họ (32 ký tự)
		String email = "test_register_02@gmail.com"; // Địa chỉ email hợp lệ
		String password = "P".repeat(20); // Mật khẩu (20 ký tự)

		String notificationExpected = "Your Account Has Been Created!"; // Thông báo mong đợi sau khi đăng ký thành công

		// Mở trang đăng ký của Open Cart
		driver.get("http://localhost/opencartsite/index.php?route=account/register&language=en-gb");
		sleep(1000); // Tạm dừng để đảm bảo trang tải đầy đủ

		// Nhập thông tin tên
		WebElement inputFirstName = driver.findElement(By.cssSelector("#input-firstname"));
		inputFirstName.sendKeys(firstName);
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Nhập thông tin họ
		WebElement inputLastName = driver.findElement(By.cssSelector("#input-lastname"));
		inputLastName.sendKeys(lastName);
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Nhập địa chỉ email
		WebElement inputEmail = driver.findElement(By.cssSelector("#input-email"));
		inputEmail.sendKeys(email);
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Nhập mật khẩu
		WebElement inputPassword = driver.findElement(By.cssSelector("#input-password"));
		inputPassword.sendKeys(password);
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Cuộn trang để hiển thị checkbox chính sách quyền riêng tư và nhấp vào
		WebElement privacyPolicy = driver.findElement(By.cssSelector("#form-register > div > div > input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", privacyPolicy);
		sleep(1000);
		privacyPolicy.click();
		sleep(1000);

		// Nhấp vào nút tiếp tục để hoàn tất quá trình đăng ký
		WebElement continueBtn = driver.findElement(By.cssSelector("#form-register > div > button"));
		continueBtn.click();
		sleep(2000); // Tạm dừng để đảm bảo quá trình xử lý hoàn tất

		// Lấy thông báo để kiểm tra
		WebElement notification = driver.findElement(By.cssSelector("#content > h1"));
		String notificationActual = notification.getText();

		// Kiểm tra xem thông báo hiển thị có khớp với thông báo mong đợi không
		Assert.assertEquals("Quá trình đăng ký không thành công", notificationExpected, notificationActual);
	}

	// Kiểm thử với trên biên trên
	@Test
	public void testRegisterAboveUpperBoundary() {
		// Khai báo thông tin cho người dùng mới với độ dài thông tin vượt quá ranh giới
		// tối đa
		String firstName = "A".repeat(33); // Họ tên (33 ký tự)
		String lastName = "T".repeat(33); // Họ (33 ký tự)
		String email = "test_register_03@gmail.com"; // Địa chỉ email hợp lệ
		String password = "P".repeat(21); // Mật khẩu (21 ký tự)

		// Mở trang đăng ký của Open Cart
		driver.get("http://localhost/opencartsite/index.php?route=account/register&language=en-gb");
		sleep(1000); // Tạm dừng để đảm bảo trang tải đầy đủ

		// Nhập thông tin tên
		WebElement inputFirstName = driver.findElement(By.cssSelector("#input-firstname"));
		inputFirstName.sendKeys(firstName);
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Nhập thông tin họ
		WebElement inputLastName = driver.findElement(By.cssSelector("#input-lastname"));
		inputLastName.sendKeys(lastName);
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Nhập địa chỉ email
		WebElement inputEmail = driver.findElement(By.cssSelector("#input-email"));
		inputEmail.sendKeys(email);
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Nhập mật khẩu
		WebElement inputPassword = driver.findElement(By.cssSelector("#input-password"));
		inputPassword.sendKeys(password);
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Cuộn trang để hiển thị checkbox chính sách quyền riêng tư và nhấp vào
		WebElement privacyPolicy = driver.findElement(By.cssSelector("#form-register > div > div > input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", privacyPolicy);
		sleep(1000);
		privacyPolicy.click();
		sleep(1000);

		// Cuộn trang để hiển thị nút tiếp tục và nhấp vào
		WebElement continueBtn = driver.findElement(By.cssSelector("#form-register > div > button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueBtn);
		sleep(1000);
		continueBtn.click();
		sleep(2000); // Tạm dừng để đảm bảo quá trình xử lý hoàn tất

		// Kiểm tra các thông báo lỗi cho tên, họ và mật khẩu
		boolean warningFirstName = driver.findElements(By.cssSelector("#error-firstname")).size() > 0;
		boolean warningLastName = driver.findElements(By.cssSelector("#error-lastname")).size() > 0;
		boolean warningPassword = driver.findElements(By.cssSelector("#error-password")).size() > 0;

		// Kiểm tra xem các thông báo lỗi có hiển thị không
		Assert.assertTrue("Khong hien thi warning FirstName", warningFirstName);
		Assert.assertTrue("Khong hien thi warning LastName", warningLastName);
		Assert.assertTrue("Khong hien thi warning Password", warningPassword);
	}

	// Kiểm thử đăng ký với biên dưới
	@Test
	public void testRegisterLowerBoundary() {
		// Khai báo thông tin cho người dùng mới với độ dài thông tin ở ranh giới tối
		// thiểu
		String firstName = "A"; // Họ tên (1 ký tự)
		String lastName = "T"; // Họ (1 ký tự)
		String email = "test_register_04@gmail.com"; // Địa chỉ email hợp lệ
		String password = "P".repeat(4); // Mật khẩu (4 ký tự)

		String notificationExpected = "Your Account Has Been Created!"; // Thông báo mong đợi sau khi đăng ký thành công

		// Mở trang đăng ký của Open Cart
		driver.get("http://localhost/opencartsite/index.php?route=account/register&language=en-gb");
		sleep(1000); // Tạm dừng để đảm bảo trang tải đầy đủ

		// Nhập thông tin tên
		WebElement inputFirstName = driver.findElement(By.cssSelector("#input-firstname"));
		inputFirstName.sendKeys(firstName);
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Nhập thông tin họ
		WebElement inputLastName = driver.findElement(By.cssSelector("#input-lastname"));
		inputLastName.sendKeys(lastName);
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Nhập địa chỉ email
		WebElement inputEmail = driver.findElement(By.cssSelector("#input-email"));
		inputEmail.sendKeys(email);
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Nhập mật khẩu
		WebElement inputPassword = driver.findElement(By.cssSelector("#input-password"));
		inputPassword.sendKeys(password);
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Cuộn trang để hiển thị checkbox chính sách quyền riêng tư và nhấp vào
		WebElement privacyPolicy = driver.findElement(By.cssSelector("#form-register > div > div > input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", privacyPolicy);
		sleep(1000);
		privacyPolicy.click();
		sleep(1000);

		// Nhấp vào nút tiếp tục để hoàn tất quá trình đăng ký
		WebElement continueBtn = driver.findElement(By.cssSelector("#form-register > div > button"));
		continueBtn.click();
		sleep(2000); // Tạm dừng để đảm bảo quá trình xử lý hoàn tất

		// Lấy thông báo để kiểm tra
		WebElement notification = driver.findElement(By.cssSelector("#content > h1"));
		String notificationActual = notification.getText();

		// Kiểm tra xem thông báo hiển thị có khớp với thông báo mong đợi không
		Assert.assertEquals("Quá trình đăng ký không thành công", notificationExpected, notificationActual);
	}

	// Kiểm thử dưới biên dưới
	@Test
	public void testRegisterUnderLowerBoundary() {
		// Khai báo thông tin cho người dùng mới với độ dài thông tin dưới ranh giới tối
		// thiểu
		String firstName = ""; // Họ tên (không có ký tự)
		String lastName = ""; // Họ (không có ký tự)
		String email = "test_register_05@gmail.com"; // Địa chỉ email hợp lệ
		String password = "P".repeat(3); // Mật khẩu (3 ký tự)

		// Mở trang đăng ký của Open Cart
		driver.get("http://localhost/opencartsite/index.php?route=account/register&language=en-gb");
		sleep(1000); // Tạm dừng để đảm bảo trang tải đầy đủ

		// Nhập thông tin tên
		WebElement inputFirstName = driver.findElement(By.cssSelector("#input-firstname"));
		inputFirstName.sendKeys(firstName);
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Nhập thông tin họ
		WebElement inputLastName = driver.findElement(By.cssSelector("#input-lastname"));
		inputLastName.sendKeys(lastName);
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Nhập địa chỉ email
		WebElement inputEmail = driver.findElement(By.cssSelector("#input-email"));
		inputEmail.sendKeys(email);
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Nhập mật khẩu
		WebElement inputPassword = driver.findElement(By.cssSelector("#input-password"));
		inputPassword.sendKeys(password);
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Cuộn trang để hiển thị checkbox chính sách quyền riêng tư và nhấp vào
		WebElement privacyPolicy = driver.findElement(By.cssSelector("#form-register > div > div > input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", privacyPolicy);
		sleep(1000);
		privacyPolicy.click();
		sleep(1000);

		// Cuộn trang để hiển thị nút tiếp tục và nhấp vào
		WebElement continueBtn = driver.findElement(By.cssSelector("#form-register > div > button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueBtn);
		sleep(1000);
		continueBtn.click();
		sleep(2000); // Tạm dừng để đảm bảo quá trình xử lý hoàn tất

		// Kiểm tra các thông báo lỗi cho từng trường không hợp lệ
		// Kiểm tra các thông báo lỗi cho tên, họ và mật khẩu
		boolean warningFirstName = driver.findElements(By.cssSelector("#error-firstname")).size() > 0;
		boolean warningLastName = driver.findElements(By.cssSelector("#error-lastname")).size() > 0;
		boolean warningPassword = driver.findElements(By.cssSelector("#error-password")).size() > 0;

		// Kiểm tra xem các thông báo lỗi có hiển thị không
		Assert.assertTrue("Khong hien thi warning FirstName", warningFirstName);
		Assert.assertTrue("Khong hien thi warning LastName", warningLastName);
		Assert.assertTrue("Khong hien thi warning Password", warningPassword);
	}

	// Kiểm thử đăng ký với các ký tự đặc biệt
	@Test
	public void testRegisterSpecialCharactersinName() {
		// Khai báo thông tin cho người dùng mới với ký tự đặc biệt trong tên
		String firstName = "@Anna"; // Tên có ký tự đặc biệt ở đầu
		String lastName = "Tran!!@#"; // Họ có ký tự đặc biệt
		String email = "test_register_05@gmail.com"; // Địa chỉ email hợp lệ
		String password = "0931368945"; // Mật khẩu hợp lệ

		// Mở trang đăng ký của Open Cart
		driver.get("http://localhost/opencartsite/index.php?route=account/register&language=en-gb");
		sleep(1000); // Tạm dừng để đảm bảo trang tải đầy đủ

		// Nhập thông tin tên
		WebElement inputFirstName = driver.findElement(By.cssSelector("#input-firstname"));
		inputFirstName.sendKeys(firstName);
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Nhập thông tin họ
		WebElement inputLastName = driver.findElement(By.cssSelector("#input-lastname"));
		inputLastName.sendKeys(lastName);
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Nhập địa chỉ email
		WebElement inputEmail = driver.findElement(By.cssSelector("#input-email"));
		inputEmail.sendKeys(email);
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Nhập mật khẩu
		WebElement inputPassword = driver.findElement(By.cssSelector("#input-password"));
		inputPassword.sendKeys(password);
		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Cuộn trang để hiển thị checkbox chính sách quyền riêng tư và nhấp vào
		WebElement privacyPolicy = driver.findElement(By.cssSelector("#form-register > div > div > input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", privacyPolicy);
		sleep(1000);
		privacyPolicy.click();
		sleep(1000);

		// Cuộn trang để hiển thị nút tiếp tục và nhấp vào
		WebElement continueBtn = driver.findElement(By.cssSelector("#form-register > div > button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueBtn);
		sleep(1000);
		continueBtn.click();
		sleep(2000); // Tạm dừng để đảm bảo quá trình xử lý hoàn tất

		// Kiểm tra các thông báo lỗi cho tên, họ và mật khẩu
		boolean warningFirstName = driver.findElements(By.cssSelector("#error-firstname")).size() > 0;
		boolean warningLastName = driver.findElements(By.cssSelector("#error-lastname")).size() > 0;
		boolean warningPassword = driver.findElements(By.cssSelector("#error-password")).size() > 0;

		// Kiểm tra xem các thông báo lỗi có hiển thị không
		Assert.assertTrue("Khong hien thi warning FirstName", warningFirstName);
		Assert.assertTrue("Khong hien thi warning LastName", warningLastName);
		Assert.assertTrue("Khong hien thi warning Password", warningPassword);
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
