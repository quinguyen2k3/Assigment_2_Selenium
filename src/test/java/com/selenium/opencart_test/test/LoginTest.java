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

	@Test
	public void testValidLogin() {

		driver.get("http://localhost/opencartsite/index.php?route=account/login&language=en-gb");
		
		sleep(4000);
		
		WebElement emailField = driver.findElement(By.id("input-email"));
		emailField.sendKeys("bichqui1212@gmail.com");

		sleep(1000);

		WebElement passwordField = driver.findElement(By.id("input-password"));
		passwordField.sendKeys("123456789");

		sleep(1000);

		WebElement loginButton = driver.findElement(By.cssSelector("button.btn.btn-primary"));
		loginButton.click();

		sleep(1000);

		String expectedTitle = "My Account";
		String actualTitle = driver.getTitle();

		Assert.assertEquals("Lỗi quá trình đăng nhập", expectedTitle, actualTitle);
	}

	@Test
	public void testInvalidEmailLogin() {

		driver.get("http://localhost/opencartsite/index.php?route=account/login&language=en-gb");
		
		sleep(2000);
		
		WebElement emailField = driver.findElement(By.id("input-email"));
		emailField.sendKeys("invalidemail");
		sleep(1000);

		WebElement passwordField = driver.findElement(By.id("input-password"));
		passwordField.sendKeys("123456789");
		sleep(1000);

		WebElement loginButton = driver.findElement(By.cssSelector("button.btn.btn-primary"));
		loginButton.click();
		sleep(1000);

		WebElement errorMessage = driver.findElement(By.className("alert-danger"));
		Assert.assertTrue("Thông báo lỗi không hiển thị", errorMessage.isDisplayed());
		Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", errorMessage.getText());
		
	}
	
	@Test
	public void testInvalidPasswordlLogin() {

		driver.get("http://localhost/opencartsite/index.php?route=account/login&language=en-gb");
		
		sleep(2000);

		WebElement emailField = driver.findElement(By.id("input-email"));
		emailField.sendKeys("bichqui1212@gmail.com");
		sleep(1000);

		WebElement passwordField = driver.findElement(By.id("input-password"));
		passwordField.sendKeys("dnsandkjdf");
		sleep(1000);

		WebElement loginButton = driver.findElement(By.cssSelector("button.btn.btn-primary"));
		loginButton.click();
		sleep(1000);

		WebElement errorMessage = driver.findElement(By.className("alert-danger"));
		Assert.assertTrue("Thông báo lỗi không hiển thị", errorMessage.isDisplayed());
		Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", errorMessage.getText());
	}
	
	@Test
	public void testEmptyPasswordlLogin() {

		driver.get("http://localhost/opencartsite/index.php?route=account/login&language=en-gb");
		
		sleep(2000);

		WebElement emailField = driver.findElement(By.id("input-email"));
		emailField.sendKeys("bichqui1212@gmail.com");
		sleep(1000);

		WebElement passwordField = driver.findElement(By.id("input-password"));
		passwordField.sendKeys("");
		sleep(1000);

		WebElement loginButton = driver.findElement(By.cssSelector("button.btn.btn-primary"));
		loginButton.click();
		sleep(1000);

		WebElement errorMessage = driver.findElement(By.className("alert-danger"));
		Assert.assertTrue("Thông báo lỗi không hiển thị", errorMessage.isDisplayed());
		Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", errorMessage.getText());
	}
	
	@Test
	public void testEmptyEmaillLogin() {

		driver.get("http://localhost/opencartsite/index.php?route=account/login&language=en-gb");
		
		sleep(2000);

		WebElement emailField = driver.findElement(By.id("input-email"));
		emailField.sendKeys("");
		sleep(1000);

		WebElement passwordField = driver.findElement(By.id("input-password"));
		passwordField.sendKeys("123456789");
		sleep(1000);

		WebElement loginButton = driver.findElement(By.cssSelector("button.btn.btn-primary"));
		loginButton.click();
		sleep(1000);

		WebElement errorMessage = driver.findElement(By.className("alert-danger"));
		Assert.assertTrue("Thông báo lỗi không hiển thị", errorMessage.isDisplayed());
		Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", errorMessage.getText());
	}
	
	@Test
	public void testSpecialCharacterLogin() {


	    driver.get("http://localhost/opencartsite/index.php?route=account/login&language=en-gb");
	    sleep(2000);


	    WebElement emailField = driver.findElement(By.id("input-email"));
	    emailField.sendKeys("!@#$%^&*()<>?");
	    sleep(1000);

	    WebElement passwordField = driver.findElement(By.id("input-password"));
	    passwordField.sendKeys("!@#$%^&*()");
	    sleep(1000);

	    WebElement loginButton = driver.findElement(By.cssSelector("button.btn.btn-primary"));
	    loginButton.click();
	    sleep(1000);

	    WebElement errorMessage = driver.findElement(By.className("alert-danger"));
	    Assert.assertTrue("Thông báo lỗi không hiển thị", errorMessage.isDisplayed());
	    Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", errorMessage.getText());
	}
	
	@Test
	public void testSQLInjectionAttempt() {

	    driver.get("http://localhost/opencartsite/index.php?route=account/login&language=en-gb");
	    sleep(2000);

	    WebElement emailField = driver.findElement(By.id("input-email"));
	    emailField.sendKeys("admin' OR '1'='1");
	    sleep(1000);

	    WebElement passwordField = driver.findElement(By.id("input-password"));
	    passwordField.sendKeys("password' OR '1'='1");
	    sleep(1000);

	    WebElement loginButton = driver.findElement(By.cssSelector("button.btn.btn-primary"));
	    loginButton.click();
	    sleep(1000);

	    WebElement errorMessage = driver.findElement(By.className("alert-danger"));
	    Assert.assertTrue("Thông báo lỗi không hiển thị", errorMessage.isDisplayed());
	    Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", errorMessage.getText());
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
