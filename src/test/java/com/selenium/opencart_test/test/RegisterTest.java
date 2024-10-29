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

	@Test
	public void testRegisterValidData() {
		String firstName = "Anna";
		String lastName = "Tran";
		String email = "test_1@gmail.com";
		String password = "123456789";

		String notificationExpected = "Your Account Has Been Created!";

		driver.get("http://localhost/opencartsite/index.php?route=account/register&language=en-gb");
		sleep(1000);

		WebElement inputFirstName = driver.findElement(By.cssSelector("#input-firstname"));
		inputFirstName.sendKeys(firstName);
		sleep(1000);

		WebElement inputLastName = driver.findElement(By.cssSelector("#input-lastname"));
		inputLastName.sendKeys(lastName);
		sleep(1000);

		WebElement inputEmail = driver.findElement(By.cssSelector("#input-email"));
		inputEmail.sendKeys(email);
		sleep(1000);

		WebElement inputPassword = driver.findElement(By.cssSelector("#input-password"));
		inputPassword.sendKeys(password);
		sleep(1000);

		WebElement privacyPolicy = driver.findElement(By.cssSelector("#form-register > div > div > input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", privacyPolicy);
		sleep(1000);
		privacyPolicy.click();
		sleep(1000);

		WebElement continueBtn = driver.findElement(By.cssSelector("#form-register > div > button"));
		continueBtn.click();
		sleep(2000);

		WebElement notification = driver.findElement(By.cssSelector("#content > h1"));
		String notificationActual = notification.getText();

		Assert.assertEquals("Quá trình đăng ký không thành công", notificationExpected, notificationActual);
	}

	@Test
	public void testRegisterEmptyRequiredInput() {
		String firstName = "";
		String lastName = "";
		String email = "";
		String password = "";

		// String notificationExpected = "Your Account Has Been Created!";

		driver.get("http://localhost/opencartsite/index.php?route=account/register&language=en-gb");
		sleep(1000);

		WebElement inputFirstName = driver.findElement(By.cssSelector("#input-firstname"));
		inputFirstName.sendKeys(firstName);
		sleep(1000);

		WebElement inputLastName = driver.findElement(By.cssSelector("#input-lastname"));
		inputLastName.sendKeys(lastName);
		sleep(1000);

		WebElement inputEmail = driver.findElement(By.cssSelector("#input-email"));
		inputEmail.sendKeys(email);
		sleep(1000);

		WebElement inputPassword = driver.findElement(By.cssSelector("#input-password"));
		inputPassword.sendKeys(password);
		sleep(1000);

		WebElement continueBtn = driver.findElement(By.cssSelector("#form-register > div > button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueBtn);
		sleep(1000);
		continueBtn.click();
		sleep(2000);

		WebElement warningFirstName = driver.findElement(By.cssSelector("#error-firstname"));
		WebElement warningLastName = driver.findElement(By.cssSelector("#error-lastname"));
		WebElement warningEmail = driver.findElement(By.cssSelector("#error-email"));
		WebElement warningPassword = driver.findElement(By.cssSelector("#error-password"));
		WebElement warningPrivacyPolicy = driver.findElement(By.cssSelector("#alert > dirv"));

		Assert.assertTrue("Khong hien thi warning FirstName", warningFirstName.isDisplayed());
		Assert.assertTrue("Khong hine thi warning LastName", warningLastName.isDisplayed());
		Assert.assertTrue("Khong hien thi warning Email", warningEmail.isDisplayed());
		Assert.assertTrue("Khong hien thi warning Password", warningPassword.isDisplayed());
		Assert.assertTrue("Khong hien thi warning Privacy Policy", warningPrivacyPolicy.isDisplayed());

	}

	@Test
	public void testRegisterInvalidEmail() {
		String firstName = "Anna";
		String lastName = "Tran";
		String email = "email.com";
		String password = "123456789";

		driver.get("http://localhost/opencartsite/index.php?route=account/register&language=en-gb");
		sleep(1000);

		WebElement inputFirstName = driver.findElement(By.cssSelector("#input-firstname"));
		inputFirstName.sendKeys(firstName);
		sleep(1000);

		WebElement inputLastName = driver.findElement(By.cssSelector("#input-lastname"));
		inputLastName.sendKeys(lastName);
		sleep(1000);

		WebElement inputEmail = driver.findElement(By.cssSelector("#input-email"));
		inputEmail.sendKeys(email);
		sleep(1000);

		WebElement inputPassword = driver.findElement(By.cssSelector("#input-password"));
		inputPassword.sendKeys(password);
		sleep(1000);

		WebElement privacyPolicy = driver.findElement(By.cssSelector("#form-register > div > div > input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", privacyPolicy);
		sleep(1000);
		privacyPolicy.click();
		sleep(1000);

		WebElement continueBtn = driver.findElement(By.cssSelector("#form-register > div > button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueBtn);
		sleep(1000);
		continueBtn.click();
		sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Boolean isValid = (Boolean) js.executeScript("return arguments[0].checkValidity();", inputEmail);
		String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", inputEmail);

		Assert.assertTrue("Không có thông báo lỗi khi nhập email sai định dạng",
				!isValid && validationMessage.contains("Please include an '@' in the email address."));
	}

	@Test
	public void testRegisterRegistedEmail() {
		String firstName = "Anna";
		String lastName = "Tran";
		String email = "bichqui1212@gmail.com";
		String password = "123456789";

		driver.get("http://localhost/opencartsite/index.php?route=account/register&language=en-gb");
		sleep(1000);

		WebElement inputFirstName = driver.findElement(By.cssSelector("#input-firstname"));
		inputFirstName.sendKeys(firstName);
		sleep(1000);

		WebElement inputLastName = driver.findElement(By.cssSelector("#input-lastname"));
		inputLastName.sendKeys(lastName);
		sleep(1000);

		WebElement inputEmail = driver.findElement(By.cssSelector("#input-email"));
		inputEmail.sendKeys(email);
		sleep(1000);

		WebElement inputPassword = driver.findElement(By.cssSelector("#input-password"));
		inputPassword.sendKeys(password);
		sleep(1000);

		WebElement privacyPolicy = driver.findElement(By.cssSelector("#form-register > div > div > input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", privacyPolicy);
		sleep(1000);
		privacyPolicy.click();
		sleep(1000);

		WebElement continueBtn = driver.findElement(By.cssSelector("#form-register > div > button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueBtn);
		sleep(1000);
		continueBtn.click();
		sleep(2000);

		WebElement warningEmail = driver.findElement(By.cssSelector("#alert > dirv"));

		Assert.assertTrue("Khong hien thi warning Email", warningEmail.isDisplayed());
	}

	@Test
	public void testRegisterUpperBoundary() {
		String firstName = "A".repeat(32);
		String lastName = "T".repeat(32);
		String email = "test_2@gmail.com";
		String password = "P".repeat(20);

		String notificationExpected = "Your Account Has Been Created!";

		driver.get("http://localhost/opencartsite/index.php?route=account/register&language=en-gb");
		sleep(1000);

		WebElement inputFirstName = driver.findElement(By.cssSelector("#input-firstname"));
		inputFirstName.sendKeys(firstName);
		sleep(1000);

		WebElement inputLastName = driver.findElement(By.cssSelector("#input-lastname"));
		inputLastName.sendKeys(lastName);
		sleep(1000);

		WebElement inputEmail = driver.findElement(By.cssSelector("#input-email"));
		inputEmail.sendKeys(email);
		sleep(1000);

		WebElement inputPassword = driver.findElement(By.cssSelector("#input-password"));
		inputPassword.sendKeys(password);
		sleep(1000);

		WebElement privacyPolicy = driver.findElement(By.cssSelector("#form-register > div > div > input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", privacyPolicy);
		sleep(1000);
		privacyPolicy.click();
		sleep(1000);

		WebElement continueBtn = driver.findElement(By.cssSelector("#form-register > div > button"));
		continueBtn.click();
		sleep(2000);

		WebElement notification = driver.findElement(By.cssSelector("#content > h1"));
		String notificationActual = notification.getText();

		Assert.assertEquals("Quá trình đăng ký không thành công", notificationExpected, notificationActual);
	}
	
	@Test
	public void testRegisterAboveUpperBoundary() {
		String firstName = "A".repeat(33);
		String lastName = "T".repeat(33);
		String email = "test_3@gmail.com";
		String password = "P".repeat(21);

		// String notificationExpected = "Your Account Has Been Created!";

		driver.get("http://localhost/opencartsite/index.php?route=account/register&language=en-gb");
		sleep(1000);

		WebElement inputFirstName = driver.findElement(By.cssSelector("#input-firstname"));
		inputFirstName.sendKeys(firstName);
		sleep(1000);

		WebElement inputLastName = driver.findElement(By.cssSelector("#input-lastname"));
		inputLastName.sendKeys(lastName);
		sleep(1000);

		WebElement inputEmail = driver.findElement(By.cssSelector("#input-email"));
		inputEmail.sendKeys(email);
		sleep(1000);

		WebElement inputPassword = driver.findElement(By.cssSelector("#input-password"));
		inputPassword.sendKeys(password);
		sleep(1000);
		
		WebElement privacyPolicy = driver.findElement(By.cssSelector("#form-register > div > div > input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", privacyPolicy);
		sleep(1000);
		privacyPolicy.click();
		sleep(1000);

		WebElement continueBtn = driver.findElement(By.cssSelector("#form-register > div > button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueBtn);
		sleep(1000);
		continueBtn.click();
		sleep(2000);

		WebElement warningFirstName = driver.findElement(By.cssSelector("#error-firstname"));
		WebElement warningLastName = driver.findElement(By.cssSelector("#error-lastname"));
		WebElement warningPassword = driver.findElement(By.cssSelector("#error-password"));
		

		Assert.assertTrue("Khong hien thi warning FirstName", warningFirstName.isDisplayed());
		Assert.assertTrue("Khong hine thi warning LastName", warningLastName.isDisplayed());
		Assert.assertTrue("Khong hien thi warning Password", warningPassword.isDisplayed());
	
	}
	
	@Test
	public void testRegisterLowerBoundary() {
		String firstName = "A";
		String lastName = "T";
		String email = "test_4@gmail.com";
		String password = "P".repeat(4);

		String notificationExpected = "Your Account Has Been Created!";

		driver.get("http://localhost/opencartsite/index.php?route=account/register&language=en-gb");
		sleep(1000);

		WebElement inputFirstName = driver.findElement(By.cssSelector("#input-firstname"));
		inputFirstName.sendKeys(firstName);
		sleep(1000);

		WebElement inputLastName = driver.findElement(By.cssSelector("#input-lastname"));
		inputLastName.sendKeys(lastName);
		sleep(1000);

		WebElement inputEmail = driver.findElement(By.cssSelector("#input-email"));
		inputEmail.sendKeys(email);
		sleep(1000);

		WebElement inputPassword = driver.findElement(By.cssSelector("#input-password"));
		inputPassword.sendKeys(password);
		sleep(1000);

		WebElement privacyPolicy = driver.findElement(By.cssSelector("#form-register > div > div > input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", privacyPolicy);
		sleep(1000);
		privacyPolicy.click();
		sleep(1000);

		WebElement continueBtn = driver.findElement(By.cssSelector("#form-register > div > button"));
		continueBtn.click();
		sleep(2000);

		WebElement notification = driver.findElement(By.cssSelector("#content > h1"));
		String notificationActual = notification.getText();

		Assert.assertEquals("Quá trình đăng ký không thành công", notificationExpected, notificationActual);
	}
	
	@Test
	public void testRegisterUnderLowerBoundary() {
		String firstName = "";
		String lastName = "";
		String email = "test_5@gmail.com";
		String password = "P".repeat(3);

		driver.get("http://localhost/opencartsite/index.php?route=account/register&language=en-gb");
		sleep(1000);

		WebElement inputFirstName = driver.findElement(By.cssSelector("#input-firstname"));
		inputFirstName.sendKeys(firstName);
		sleep(1000);

		WebElement inputLastName = driver.findElement(By.cssSelector("#input-lastname"));
		inputLastName.sendKeys(lastName);
		sleep(1000);

		WebElement inputEmail = driver.findElement(By.cssSelector("#input-email"));
		inputEmail.sendKeys(email);
		sleep(1000);

		WebElement inputPassword = driver.findElement(By.cssSelector("#input-password"));
		inputPassword.sendKeys(password);
		sleep(1000);
		
		WebElement privacyPolicy = driver.findElement(By.cssSelector("#form-register > div > div > input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", privacyPolicy);
		sleep(1000);
		privacyPolicy.click();
		sleep(1000);

		WebElement continueBtn = driver.findElement(By.cssSelector("#form-register > div > button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueBtn);
		sleep(1000);
		continueBtn.click();
		sleep(2000);

		WebElement warningFirstName = driver.findElement(By.cssSelector("#error-firstname"));
		WebElement warningLastName = driver.findElement(By.cssSelector("#error-lastname"));
		WebElement warningPassword = driver.findElement(By.cssSelector("#error-password"));
		
		Assert.assertTrue("Khong hien thi warning FirstName", warningFirstName.isDisplayed());
		Assert.assertTrue("Khong hine thi warning LastName", warningLastName.isDisplayed());
		Assert.assertTrue("Khong hien thi warning Password", warningPassword.isDisplayed());
	}
	
	@Test
	public void testRegisterSpecialCharactersinName() {
		String firstName = "@Anna";
		String lastName = "Tran!!@#";
		String email = "test_5@gmail.com";
		String password = "0931368945";

		driver.get("http://localhost/opencartsite/index.php?route=account/register&language=en-gb");
		sleep(1000);

		WebElement inputFirstName = driver.findElement(By.cssSelector("#input-firstname"));
		inputFirstName.sendKeys(firstName);
		sleep(1000);

		WebElement inputLastName = driver.findElement(By.cssSelector("#input-lastname"));
		inputLastName.sendKeys(lastName);
		sleep(1000);

		WebElement inputEmail = driver.findElement(By.cssSelector("#input-email"));
		inputEmail.sendKeys(email);
		sleep(1000);

		WebElement inputPassword = driver.findElement(By.cssSelector("#input-password"));
		inputPassword.sendKeys(password);
		sleep(1000);
		
		WebElement privacyPolicy = driver.findElement(By.cssSelector("#form-register > div > div > input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", privacyPolicy);
		sleep(1000);
		privacyPolicy.click();
		sleep(1000);

		WebElement continueBtn = driver.findElement(By.cssSelector("#form-register > div > button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueBtn);
		sleep(1000);
		continueBtn.click();
		sleep(2000);

		WebElement warningFirstName = driver.findElement(By.cssSelector("#error-firstname"));
		WebElement warningLastName = driver.findElement(By.cssSelector("#error-lastname"));
		WebElement warningPassword = driver.findElement(By.cssSelector("#error-password"));
		
		Assert.assertTrue("Khong hien thi warning FirstName", warningFirstName.isDisplayed());
		Assert.assertTrue("Khong hine thi warning LastName", warningLastName.isDisplayed());
		Assert.assertTrue("Khong hien thi warning Password", warningPassword.isDisplayed());
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
