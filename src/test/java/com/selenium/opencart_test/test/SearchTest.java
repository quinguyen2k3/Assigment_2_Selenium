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

	// Kiểm thử tìm kiếm với tên chính xác
	@Test
	public void testSearchWithExactKeyword() {
		// Khai báo tên sản phẩm cần tìm kiếm
		String productName = "Apple Cinema 30\"";

		// Mở trang chính của Open Cart
		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");

		sleep(2000); // Tạm dừng để đảm bảo trang tải đầy đủ

		// Nhập từ khóa tìm kiếm vào ô tìm kiếm
		WebElement inputSearch = driver.findElement(By.cssSelector("#search > input"));
		inputSearch.sendKeys(productName);

		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Nhấn nút tìm kiếm
		WebElement buttonSearch = driver.findElement(By.cssSelector("#search > button"));
		buttonSearch.click();

		sleep(2000); // Tạm dừng để chờ kết quả tìm kiếm

		// Lấy danh sách các sản phẩm từ kết quả tìm kiếm
		List<WebElement> products = driver.findElements(By.cssSelector("#product-list .product-thumb .content h4 a"));

		boolean productExists = false; // Biến để kiểm tra xem sản phẩm có tồn tại không
		for (WebElement product : products) {
			String foundProductName = product.getText(); // Lấy tên sản phẩm từ kết quả
			if (foundProductName.equals(productName)) {
				productExists = true; // Nếu tìm thấy sản phẩm, gán biến thành true
				break; // Dừng vòng lặp khi đã tìm thấy
			}
		}

		// Kiểm tra xem sản phẩm có tồn tại trong danh sách kết quả
		Assert.assertTrue("Sản phẩm " + productName + " không tồn tại trong danh sách", productExists);
	}
	
	@Test
	public void testSearchWithKeyword() {
		// Khai báo tên sản phẩm cần tìm kiếm
		String productName = "Apple";

		// Mở trang chính của Open Cart
		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");

		sleep(2000); // Tạm dừng để đảm bảo trang tải đầy đủ

		// Nhập từ khóa tìm kiếm vào ô tìm kiếm
		WebElement inputSearch = driver.findElement(By.cssSelector("#search > input"));
		inputSearch.sendKeys(productName);

		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Nhấn nút tìm kiếm
		WebElement buttonSearch = driver.findElement(By.cssSelector("#search > button"));
		buttonSearch.click();

		sleep(2000); // Tạm dừng để chờ kết quả tìm kiếm

		// Lấy danh sách các sản phẩm từ kết quả tìm kiếm
		List<WebElement> products = driver.findElements(By.cssSelector("#product-list .product-thumb .content h4 a"));

		boolean productExists = true; // Biến để kiểm tra xem danh sách sản phẩm liên quan tới từ khóa hay không
		for (WebElement product : products) {
			String foundProductName = product.getText(); // Lấy tên sản phẩm từ kết quả
			if (!foundProductName.toLowerCase().contains(productName.toLowerCase())) {
				productExists = false; // Nếu tìm thấy sản phẩm không liên quan, gán biến thành false
				break; // Dừng vòng lặp khi đã tìm thấy
			}
		}

		// Kiểm tra xem sản phẩm có tồn tại trong danh sách kết quả
		Assert.assertTrue("Danh sách chứa sản phẩm không liên quan tới " + productName, productExists);
	}

	// Kiểm thử tìm kiếm với chữ hoa
	@Test
	public void testSearchWithUppercaseKeyword() {
		// Khai báo tên sản phẩm cần tìm kiếm
		String productName = "Apple Cinema 30\"";

		// Mở trang chính của Open Cart
		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");

		sleep(2000); // Tạm dừng để đảm bảo trang tải đầy đủ

		// Nhập từ khóa tìm kiếm vào ô tìm kiếm (được chuyển thành chữ hoa)
		WebElement inputSearch = driver.findElement(By.cssSelector("#search > input"));
		inputSearch.sendKeys(productName.toUpperCase());

		sleep(1000); // Tạm dừng để đảm bảo thao tác nhập hoàn tất

		// Nhấn nút tìm kiếm
		WebElement buttonSearch = driver.findElement(By.cssSelector("#search > button"));
		buttonSearch.click();

		sleep(2000); // Tạm dừng để chờ kết quả tìm kiếm

		// Lấy danh sách các sản phẩm từ kết quả tìm kiếm
		List<WebElement> products = driver.findElements(By.cssSelector("#product-list .product-thumb .content h4 a"));

		boolean productExists = false; // Biến để kiểm tra xem sản phẩm có tồn tại không
		for (WebElement product : products) {
			String foundProductName = product.getText(); // Lấy tên sản phẩm từ kết quả
			if (foundProductName.equals(productName)) {
				productExists = true; // Nếu tìm thấy sản phẩm, gán biến thành true
				break; // Dừng vòng lặp khi đã tìm thấy
			}
		}

		// Kiểm tra xem sản phẩm có tồn tại trong danh sách kết quả
		Assert.assertTrue("Sản phẩm " + productName + " không tồn tại trong danh sách", productExists);
	}

	// Kiểm thử tìm kiếm với chữ thường
	@Test
	public void testSearchWithLowercaseKeyword() {
		// Khai báo tên sản phẩm cần tìm
		String productName = "Apple Cinema 30\"";

		// Mở trang chính của Open Cart
		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");

		// Tạm dừng 2 giây để trang tải hoàn tất
		sleep(2000);

		// Tìm kiếm ô nhập từ khóa sản phẩm
		WebElement inputSearch = driver.findElement(By.cssSelector("#search > input"));
		// Nhập tên sản phẩm đã chuyển sang chữ thường vào ô tìm kiếm
		inputSearch.sendKeys(productName.toLowerCase());

		// Tạm dừng 1 giây trước khi nhấn nút tìm kiếm
		sleep(1000);

		// Nhấn nút tìm kiếm để thực hiện tìm kiếm sản phẩm
		WebElement buttonSearch = driver.findElement(By.cssSelector("#search > button"));
		buttonSearch.click();

		// Tạm dừng 2 giây để chờ kết quả tìm kiếm xuất hiện
		sleep(2000);

		// Lấy danh sách sản phẩm từ kết quả tìm kiếm
		List<WebElement> products = driver.findElements(By.cssSelector("#product-list .product-thumb .content h4 a"));

		// Khởi tạo biến kiểm tra sự tồn tại của sản phẩm
		boolean productExists = false;
		// Duyệt qua từng sản phẩm trong danh sách
		for (WebElement product : products) {
			// Lấy tên sản phẩm hiện tại
			String foundProductName = product.getText();
			// So sánh tên sản phẩm tìm thấy với tên sản phẩm mong muốn
			if (foundProductName.equals(productName)) {
				// Nếu tìm thấy, cập nhật biến productExists và thoát khỏi vòng lặp
				productExists = true;
				break;
			}
		}

		// Kiểm tra xem sản phẩm có tồn tại trong danh sách không và đưa ra thông báo
		// nếu không
		Assert.assertTrue("Sản phẩm " + productName + " không tồn tại trong danh sách", productExists);
	}

	// Tìm kiếm tên sản phấm chứa ký tự đặc biệt
	@Test
	public void testSearchWithKeywordContainingSpecialCharacters() {
		// Khai báo tên sản phẩm cần tìm, bao gồm ký tự đặc biệt
		String productName = "Apple Cinema 30\"@!";

		// Mở trang chính của Open Cart
		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");

		// Tạm dừng 2 giây để trang tải hoàn tất
		sleep(2000);

		// Tìm kiếm ô nhập từ khóa sản phẩm
		WebElement inputSearch = driver.findElement(By.cssSelector("#search > input"));
		// Nhập tên sản phẩm vào ô tìm kiếm
		inputSearch.sendKeys(productName);

		// Tạm dừng 1 giây trước khi nhấn nút tìm kiếm
		sleep(1000);

		// Nhấn nút tìm kiếm để thực hiện tìm kiếm sản phẩm
		WebElement buttonSearch = driver.findElement(By.cssSelector("#search > button"));
		buttonSearch.click();

		// Tạm dừng 2 giây để chờ kết quả tìm kiếm xuất hiện
		sleep(2000);

		// Lấy danh sách sản phẩm từ kết quả tìm kiếm
		List<WebElement> products = driver.findElements(By.cssSelector("#product-list .product-thumb .content h4 a"));

		// Khởi tạo biến kiểm tra sự tồn tại của sản phẩm
		boolean productExists = false;
		// Duyệt qua từng sản phẩm trong danh sách
		for (WebElement product : products) {
			// Lấy tên sản phẩm hiện tại
			String foundProductName = product.getText();
			// Kiểm tra nếu tên sản phẩm hiện tại có chứa tên sản phẩm mong muốn
			if (productName.contains(foundProductName)) {
				// Nếu tìm thấy, cập nhật biến productExists và thoát khỏi vòng lặp
				productExists = true;
				break;
			}
		}

		// Kiểm tra xem sản phẩm có tồn tại trong danh sách không và đưa ra thông báo
		// nếu không
		Assert.assertTrue("Sản phẩm " + productName + " không tồn tại trong danh sách", productExists);
	}

	// Kiểm thử tìm kiếm tên sản phẩm được bao bởi khoảng trắng.
	@Test
	public void testSearchWithKeywordSurroundedByWhitespace() {
		// Khai báo tên sản phẩm cần tìm với khoảng trắng ở hai bên
		String productName = "  Apple Cinema 30\"  ";

		// Mở trang chính của Open Cart
		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");

		// Tạm dừng 2 giây để trang tải hoàn tất
		sleep(2000);

		// Tìm kiếm ô nhập từ khóa sản phẩm
		WebElement inputSearch = driver.findElement(By.cssSelector("#search > input"));
		// Nhập tên sản phẩm vào ô tìm kiếm
		inputSearch.sendKeys(productName);

		// Tạm dừng 1 giây trước khi nhấn nút tìm kiếm
		sleep(1000);

		// Nhấn nút tìm kiếm để thực hiện tìm kiếm sản phẩm
		WebElement buttonSearch = driver.findElement(By.cssSelector("#search > button"));
		buttonSearch.click();

		// Tạm dừng 2 giây để chờ kết quả tìm kiếm xuất hiện
		sleep(2000);

		// Lấy danh sách sản phẩm từ kết quả tìm kiếm
		List<WebElement> products = driver.findElements(By.cssSelector("#product-list .product-thumb .content h4 a"));

		// Khởi tạo biến kiểm tra sự tồn tại của sản phẩm
		boolean productExists = false;
		// Duyệt qua từng sản phẩm trong danh sách
		for (WebElement product : products) {
			// Lấy tên sản phẩm hiện tại
			String foundProductName = product.getText();
			// Kiểm tra nếu tên sản phẩm hiện tại có chứa tên sản phẩm mong muốn
			if (productName.contains(foundProductName)) {
				// Nếu tìm thấy, cập nhật biến productExists và thoát khỏi vòng lặp
				productExists = true;
				break;
			}
		}

		// Kiểm tra xem sản phẩm có tồn tại trong danh sách không và đưa ra thông báo
		// nếu không
		Assert.assertTrue("Sản phẩm " + productName + " không tồn tại trong danh sách", productExists);
	}

	// Kiểm thử tìm kiếm với chuỗi rỗng
	@Test
	public void testSearchEmptyCharacters() {
		// Khai báo tên sản phẩm là chuỗi rỗng
		String productName = "";

		// Dự kiến thông báo khi không có sản phẩm nào tìm thấy
		String notificationExpected = "There is no product that matches the search criteria.";

		// Mở trang chính của Open Cart
		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");

		// Tạm dừng 2 giây để trang tải hoàn tất
		sleep(2000);

		// Tìm kiếm ô nhập từ khóa sản phẩm
		WebElement inputSearch = driver.findElement(By.cssSelector("#search > input"));
		// Nhập tên sản phẩm (chuỗi rỗng) vào ô tìm kiếm
		inputSearch.sendKeys(productName);

		// Tạm dừng 1 giây trước khi nhấn nút tìm kiếm
		sleep(1000);

		// Nhấn nút tìm kiếm để thực hiện tìm kiếm sản phẩm
		WebElement buttonSearch = driver.findElement(By.cssSelector("#search > button"));
		buttonSearch.click();

		// Tạm dừng 2 giây để chờ kết quả tìm kiếm xuất hiện
		sleep(2000);

		// Lấy thông báo từ trang kết quả tìm kiếm
		boolean notificationElement = driver.findElements(By.cssSelector("#content > p")).size() > 0;

		Assert.assertTrue("Phần tử không xuất hiện", notificationElement);

		String notificationActual = "";
		if (notificationElement) {
			WebElement notificationText = driver.findElement(By.cssSelector("#content > p"));
			notificationActual = notificationText.getText();
		}

		// Lấy danh sách sản phẩm từ kết quả tìm kiếm
		List<WebElement> products = driver.findElements(By.cssSelector("#product-list .product-thumb .content h4 a"));
		// Kiểm tra xem có sản phẩm nào không
		boolean productsExits = products.isEmpty();

		// Kiểm tra xem không có sản phẩm nào trong danh sách và đưa ra thông báo nếu
		// không
		Assert.assertTrue("Lỗi tìm kiếm danh sách sản phẩm vẫn xuất hiện", productsExits);
		// Kiểm tra xem thông báo thực tế có khớp với thông báo dự kiến không
		Assert.assertEquals("Thông báo không được hiển thị", notificationExpected, notificationActual);
	}

	// Kiểm thử tìm kiếm với ký tự đặc biệt
	@Test
	public void testSearchSpecialCharacters() {
		// Khai báo tên sản phẩm là ký tự đặc biệt
		String productName = "%";

		// Dự kiến thông báo khi không có sản phẩm nào tìm thấy
		String notificationExpected = "There is no product that matches the search criteria.";

		// Mở trang chính của Open Cart
		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");

		// Tạm dừng 2 giây để trang tải hoàn tất
		sleep(2000);

		// Tìm kiếm ô nhập từ khóa sản phẩm
		WebElement inputSearch = driver.findElement(By.cssSelector("#search > input"));
		// Nhập tên sản phẩm (ký tự đặc biệt) vào ô tìm kiếm
		inputSearch.sendKeys(productName);

		// Tạm dừng 1 giây trước khi nhấn nút tìm kiếm
		sleep(1000);

		// Nhấn nút tìm kiếm để thực hiện tìm kiếm sản phẩm
		WebElement buttonSearch = driver.findElement(By.cssSelector("#search > button"));
		buttonSearch.click();

		// Tạm dừng 2 giây để chờ kết quả tìm kiếm xuất hiện
		sleep(2000);

		// Lấy thông báo từ trang kết quả tìm kiếm
		boolean notificationElement = driver.findElements(By.cssSelector("#content > p")).size() > 0;

		Assert.assertTrue("Phần tử không xuất hiện", notificationElement);

		String notificationActual = "";
		if (notificationElement) {
			WebElement notificationText = driver.findElement(By.cssSelector("#content > p"));
			notificationActual = notificationText.getText();
		}

		// Lấy danh sách sản phẩm từ kết quả tìm kiếm
		List<WebElement> products = driver.findElements(By.cssSelector("#product-list .product-thumb .content h4 a"));
		// Kiểm tra xem có sản phẩm nào không
		boolean productsExits = products.isEmpty();

		// Kiểm tra xem không có sản phẩm nào trong danh sách và đưa ra thông báo nếu
		// không
		Assert.assertTrue("Lỗi tìm kiếm danh sách sản phẩm vẫn xuất hiện", productsExits);
		// Kiểm tra xem thông báo thực tế có khớp với thông báo dự kiến không
		Assert.assertEquals("Thông báo không được hiển thị", notificationExpected, notificationActual);
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
