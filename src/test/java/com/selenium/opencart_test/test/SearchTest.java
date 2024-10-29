package com.selenium.opencart_test.test;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class SearchTest {

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
	public void testSearchWithExactKeyword() {
		String productName = "Apple Cinema 30\"";

		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");

		sleep(2000);

		WebElement inputSearch = driver.findElement(By.cssSelector("#search > input"));
		inputSearch.sendKeys(productName);

		sleep(1000);

		WebElement buttonSearch = driver.findElement(By.cssSelector("#search > button"));
		buttonSearch.click();

		sleep(2000);

		List<WebElement> products = driver.findElements(By.cssSelector("#product-list .product-thumb .content h4 a"));

		boolean productExists = false;
		for (WebElement product : products) {
			String foundProductName = product.getText();
			if (foundProductName.equals(productName)) {
				productExists = true;
				break;
			}
		}

		Assert.assertTrue("Sản phẩm " + productName + " không tồn tại trong danh sách", productExists);
	}

	@Test
	public void testSearchWithNonexistentKeyword() {
		String productName = "xyz123";

		String notificationExpected = "There is no product that matches the search criteria.";

		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");

		sleep(2000);

		WebElement inputSearch = driver.findElement(By.cssSelector("#search > input"));
		inputSearch.sendKeys(productName);

		sleep(1000);

		WebElement buttonSearch = driver.findElement(By.cssSelector("#search > button"));
		buttonSearch.click();

		sleep(2000);

		WebElement notificationElement = driver.findElement(By.cssSelector("#content > p"));
		String notificationActual = notificationElement.getText();

		List<WebElement> products = driver.findElements(By.cssSelector("#product-list .product-thumb .content h4 a"));
		boolean productsExits = products.isEmpty();

		Assert.assertTrue("Lỗi tìm kiếm danh sách sản phẩm vẫn xuất hiện", productsExits);
		Assert.assertEquals("Thông báo không được hiển thị", notificationExpected, notificationActual);
	}

	@Test
	public void testSearchWithUppercaseKeyword() {
		String productName = "Apple Cinema 30\"";

		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");

		sleep(2000);

		WebElement inputSearch = driver.findElement(By.cssSelector("#search > input"));
		inputSearch.sendKeys(productName.toUpperCase());

		sleep(1000);

		WebElement buttonSearch = driver.findElement(By.cssSelector("#search > button"));
		buttonSearch.click();

		sleep(2000);

		List<WebElement> products = driver.findElements(By.cssSelector("#product-list .product-thumb .content h4 a"));

		boolean productExists = false;
		for (WebElement product : products) {
			String foundProductName = product.getText();
			if (foundProductName.equals(productName)) {
				productExists = true;
				break;
			}
		}

		Assert.assertTrue("Sản phẩm " + productName + " không tồn tại trong danh sách", productExists);
	}
	@Test
	public void testSearchWithLowercaseKeyword() {
		String productName = "Apple Cinema 30\"";

		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");

		sleep(2000);

		WebElement inputSearch = driver.findElement(By.cssSelector("#search > input"));
		inputSearch.sendKeys(productName.toLowerCase());

		sleep(1000);

		WebElement buttonSearch = driver.findElement(By.cssSelector("#search > button"));
		buttonSearch.click();

		sleep(2000);

		List<WebElement> products = driver.findElements(By.cssSelector("#product-list .product-thumb .content h4 a"));

		boolean productExists = false;
		for (WebElement product : products) {
			String foundProductName = product.getText();
			if (foundProductName.equals(productName)) {
				productExists = true;
				break;
			}
		}

		Assert.assertTrue("Sản phẩm " + productName + " không tồn tại trong danh sách", productExists);
	}
	
	@Test
	public void testSearchWithKeywordContainingSpecialCharacters() {
		String productName = "Apple Cinema 30\"@!";

		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");

		sleep(2000);

		WebElement inputSearch = driver.findElement(By.cssSelector("#search > input"));
		inputSearch.sendKeys(productName);

		sleep(1000);

		WebElement buttonSearch = driver.findElement(By.cssSelector("#search > button"));
		buttonSearch.click();

		sleep(2000);

		List<WebElement> products = driver.findElements(By.cssSelector("#product-list .product-thumb .content h4 a"));

		boolean productExists = false;
		for (WebElement product : products) {
			String foundProductName = product.getText();
			if (productName.contains(foundProductName )) {
				productExists = true;
				break;
			}
		}

		Assert.assertTrue("Sản phẩm " + productName + " không tồn tại trong danh sách", productExists);
	}
	
	@Test
	public void testSearchWithKeywordSurroundedByWhitespace() {
		String productName = "  Apple Cinema 30\"  ";

		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");

		sleep(2000);

		WebElement inputSearch = driver.findElement(By.cssSelector("#search > input"));
		inputSearch.sendKeys(productName);

		sleep(1000);

		WebElement buttonSearch = driver.findElement(By.cssSelector("#search > button"));
		buttonSearch.click();

		sleep(2000);

		List<WebElement> products = driver.findElements(By.cssSelector("#product-list .product-thumb .content h4 a"));

		boolean productExists = false;
		for (WebElement product : products) {
			String foundProductName = product.getText();
			if (productName.contains(foundProductName )) {
				productExists = true;
				break;
			}
		}

		Assert.assertTrue("Sản phẩm " + productName + " không tồn tại trong danh sách", productExists);
	}
	
	@Test
	public void testSearchEmptyCharacters() {
		String productName = "";

		String notificationExpected = "There is no product that matches the search criteria.";

		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");

		sleep(2000);

		WebElement inputSearch = driver.findElement(By.cssSelector("#search > input"));
		inputSearch.sendKeys(productName);

		sleep(1000);

		WebElement buttonSearch = driver.findElement(By.cssSelector("#search > button"));
		buttonSearch.click();

		sleep(2000);

		WebElement notificationElement = driver.findElement(By.cssSelector("#content > p"));
		String notificationActual = notificationElement.getText();

		List<WebElement> products = driver.findElements(By.cssSelector("#product-list .product-thumb .content h4 a"));
		boolean productsExits = products.isEmpty();

		Assert.assertTrue("Lỗi tìm kiếm danh sách sản phẩm vẫn xuất hiện", productsExits);
		Assert.assertEquals("Thông báo không được hiển thị", notificationExpected, notificationActual);
	}
	
	@Test
	public void testSearchSpecialCharacters() {
		String productName = "%";

		String notificationExpected = "There is no product that matches the search criteria.";

		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");

		sleep(2000);

		WebElement inputSearch = driver.findElement(By.cssSelector("#search > input"));
		inputSearch.sendKeys(productName);

		sleep(1000);

		WebElement buttonSearch = driver.findElement(By.cssSelector("#search > button"));
		buttonSearch.click();

		sleep(2000);

		WebElement notificationElement = driver.findElement(By.cssSelector("#content > p"));
		String notificationActual = notificationElement.getText();

		List<WebElement> products = driver.findElements(By.cssSelector("#product-list .product-thumb .content h4 a"));
		boolean productsExits = products.isEmpty();

		Assert.assertTrue("Lỗi tìm kiếm danh sách sản phẩm vẫn xuất hiện", productsExits);
		Assert.assertEquals("Thông báo không được hiển thị", notificationExpected, notificationActual);
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
