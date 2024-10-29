package com.selenium.opencart_test.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class ChangeInformationTest {
	private WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.edge.driver", "D:\\Kiem_thu_phan_mem\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		String email = "bichqui1212@gmail.com";
		String password = "1".repeat(20);
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

	@Test
	public void testChangeValidPassword() {
		String password = "0931368945";
		String passwordConfirm = "0931368945";
		String email = "bichqui1212@gmail.com";

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

		WebElement successAlert = driver
				.findElement(By.cssSelector("#account-account > div.alert.alert-success.alert-dismissible"));

		Assert.assertTrue("Không hiển thị thông báo thành công", successAlert.isDisplayed());

		WebElement dropdown = driver
				.findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(2) > div"));
		dropdown.click();
		sleep(1000);

		WebElement logout = driver.findElement(By
				.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(2) > div > ul > li:nth-child(5) > a"));
		logout.click();
		sleep(1000);

		login(email, password);

		String expectedTitle = "My Account";
		String actualTitle = driver.getTitle();

		Assert.assertEquals("Password đã không đổi thành công", expectedTitle, actualTitle);
	}

	@Test
	public void testEmptyInput() {
		String password = "";
		String passwordConfirm = "";
		// String email = "bichqui1212@gmail.com";

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

		WebElement warningPassword = driver.findElement(By.cssSelector("#error-password"));
		Assert.assertTrue("Không hiển thị cảnh báo lỗi", warningPassword.isDisplayed());
	}

	@Test
	public void testUnderLowerBoundary() {
		String password = "123";
		String passwordConfirm = "123";
		// String email = "bichqui1212@gmail.com";

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

		WebElement warningPassword = driver.findElement(By.cssSelector("#error-password"));
		Assert.assertTrue("Không hiển thị cảnh báo lỗi", warningPassword.isDisplayed());
	}

	@Test
	public void testLowerBoundary() {
		String password = "1234";
		String passwordConfirm = "1234";
		String email = "bichqui1212@gmail.com";

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

		WebElement successAlert = driver
				.findElement(By.cssSelector("#account-account > div.alert.alert-success.alert-dismissible"));

		Assert.assertTrue("Không hiển thị thông báo thành công", successAlert.isDisplayed());

		WebElement dropdown = driver
				.findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(2) > div"));
		dropdown.click();
		sleep(1000);

		WebElement logout = driver.findElement(By
				.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(2) > div > ul > li:nth-child(5) > a"));
		logout.click();
		sleep(1000);

		login(email, password);

		String expectedTitle = "My Account";
		String actualTitle = driver.getTitle();

		Assert.assertEquals("Password đã không đổi thành công", expectedTitle, actualTitle);
	}
	
	@Test
	public void testUpperBoundary() {
		String password = "1".repeat(20);
		String passwordConfirm = "1".repeat(20);
		String email = "bichqui1212@gmail.com";

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

		WebElement successAlert = driver
				.findElement(By.cssSelector("#account-account > div.alert.alert-success.alert-dismissible"));

		Assert.assertTrue("Không hiển thị thông báo thành công", successAlert.isDisplayed());

		WebElement dropdown = driver
				.findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(2) > div"));
		dropdown.click();
		sleep(1000);

		WebElement logout = driver.findElement(By
				.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(2) > div > ul > li:nth-child(5) > a"));
		logout.click();
		sleep(1000);

		login(email, password);

		String expectedTitle = "My Account";
		String actualTitle = driver.getTitle();

		Assert.assertEquals("Password đã không đổi thành công", expectedTitle, actualTitle);
	}
	
	@Test
	public void testAboveUpperBoundary() {
		String password = "1".repeat(21);
		String passwordConfirm = "1".repeat(21);
		// String email = "bichqui1212@gmail.com";

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

		WebElement warningPassword = driver.findElement(By.cssSelector("#error-password"));
		Assert.assertTrue("Không hiển thị cảnh báo lỗi", warningPassword.isDisplayed());
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
