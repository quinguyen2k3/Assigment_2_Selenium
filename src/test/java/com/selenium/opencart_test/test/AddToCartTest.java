package com.selenium.opencart_test.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.edge.EdgeDriver;

public class AddToCartTest {

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
	
	//Thêm một sản phẩm vào giỏ
	@Test
	public void testAddOneToCart() {
	    // Mở trang chính của cửa hàng
	    driver.get("http://localhost/opencartsite/");
	    sleep(2000); // Tạm dừng 2 giây để trang tải hoàn tất

	    // Tìm nút "Thêm vào giỏ hàng" cho sản phẩm thứ hai
	    WebElement addToCartButton = driver.findElement(By.cssSelector(
	            "#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > form > div > button:nth-child(1)"));

	    // Cuộn xuống để nút "Thêm vào giỏ hàng" hiển thị
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton);
	    sleep(1000); // Tạm dừng 1 giây

	    // Nhấp vào nút "Thêm vào giỏ hàng"
	    addToCartButton.click();
	    sleep(2000); // Tạm dừng 2 giây để chờ thông báo thành công

	    // Kiểm tra xem thông báo thành công có hiển thị không
	    WebElement successMessage = driver.findElement(By.cssSelector("#alert > div"));
	    Assert.assertTrue("Thông báo thành công không hiển thị!", successMessage.isDisplayed());
	    // Kiểm tra xem thông báo có chứa tên sản phẩm không
	    Assert.assertTrue("Không tìm thấy thông báo chứa tên sản phẩm!", successMessage.getText().contains("iPhone"));
	}
	
	//Thêm một sản phẩm nhiều lần
	@Test
	public void testAddMultiToCart() {
	    // Mở trang chính của cửa hàng
	    driver.get("http://localhost/opencartsite/");
	    sleep(2000); // Tạm dừng 2 giây để trang tải hoàn tất

	    // Tìm nút "Thêm vào giỏ hàng" cho sản phẩm thứ hai
	    WebElement addToCartButton = driver.findElement(By.cssSelector(
	            "#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > form > div > button:nth-child(1)"));

	    // Cuộn xuống để nút "Thêm vào giỏ hàng" hiển thị
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton);
	    sleep(1000); // Tạm dừng 1 giây

	    // Nhấp vào nút "Thêm vào giỏ hàng" lần đầu
	    addToCartButton.click();
	    sleep(5000); // Tạm dừng 2 giây

	    // Nhấp vào nút "Thêm vào giỏ hàng" lần thứ hai
	    addToCartButton.click();
	    sleep(5000); // Tạm dừng 5 giây để đảm bảo sản phẩm đã được thêm vào giỏ

	    // Tìm nút giỏ hàng để xem sản phẩm đã thêm
	    WebElement cartButton = driver.findElement(By.cssSelector("#header-cart > div > button"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartButton);
	    sleep(1000); // Tạm dừng 1 giây

	    // Nhấp vào nút giỏ hàng để mở giỏ hàng
	    cartButton.click();
	    sleep(2000); // Tạm dừng 2 giây để trang giỏ hàng tải hoàn tất

	    // Kiểm tra tên sản phẩm trong giỏ hàng
	    WebElement productName = driver.findElement(
	            By.cssSelector("#header-cart > div > ul > li > table > tbody > tr:nth-child(1) > td.text-start > a"));
	    String nameActual = productName.getText(); // Lấy tên sản phẩm thực tế từ giỏ hàng

	    // Kiểm tra số lượng sản phẩm trong giỏ hàng
	    WebElement productQuantity = driver.findElement(
	            By.cssSelector("#header-cart > div > ul > li > table > tbody > tr:nth-child(1) > td:nth-child(3)"));
	    int quantityActual = Integer.parseInt(productQuantity.getText().replace("x", "").trim()); // Lấy số lượng sản phẩm

	    String nameExpected = "iPhone"; // Tên sản phẩm dự kiến
	    int quantityExpected = 2; // Số lượng sản phẩm dự kiến

	    // So sánh số lượng sản phẩm thực tế với số lượng dự kiến
	    Assert.assertEquals("Khác nhau số lượng", quantityExpected, quantityActual);
	    // So sánh tên sản phẩm thực tế với tên sản phẩm dự kiến
	    Assert.assertEquals("Khác nhau về tên sản phẩm", nameExpected, nameActual);
	}

	//Thêm hai sản phẩm khác nhau hoàn toàn
	@Test
	public void testAddDifferentProductToCart() throws AWTException {
	    // Navigate to the OpenCart site
	    driver.get("http://localhost/opencartsite/");
	    sleep(2000); // Wait for the page to load

	    // Find and click the 'Add to Cart' button for the first product (iPhone)
	    WebElement addToCartButton_1 = driver.findElement(By.cssSelector(
	        "#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > form > div > button:nth-child(1)"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton_1);
	    sleep(1000);
	    addToCartButton_1.click(); // Click to add the iPhone to the cart
	    sleep(5000); // Wait for the action to complete

	    // Find and click the 'Add to Cart' button for the second product (Apple Cinema)
	    WebElement addToCartButton_2 = driver.findElement(By.cssSelector(
	        "#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(3) > div > div.content > form > div > button:nth-child(1)"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton_2);
	    sleep(2000);
	    addToCartButton_2.click(); // Click to add the Apple Cinema to the cart
	    sleep(5000); // Wait for the action to complete

	    // Select size option for the Apple Cinema product
	    WebElement size = driver.findElement(By.cssSelector("#input-option-value-5"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", size);
	    sleep(1000);
	    size.click(); // Click to select the size option
	    sleep(1000);

	    // Select an additional option for the Apple Cinema product
	    WebElement checkbox_1 = driver.findElement(By.cssSelector("#input-option-value-9"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox_1);
	    sleep(1000);
	    checkbox_1.click(); // Click to select the additional checkbox option
	    sleep(1000);

	    // Input custom text for the Apple Cinema product
	    WebElement text = driver.findElement(By.cssSelector("#input-option-208"));
	    text.sendKeys("TEST OPTION"); // Enter custom text

	    sleep(1000); // Wait for the action to complete

	    // Select a color option from the dropdown
	    WebElement dropdown = driver.findElement(By.cssSelector("#input-option-217"));
	    Select selection = new Select(dropdown);
	    selection.selectByVisibleText("Red (+$6.80)"); // Choose color option

	    sleep(1000); // Wait for the action to complete

	    // Input text in a textarea for the Apple Cinema product
	    WebElement textarea = driver.findElement(By.cssSelector("#input-option-209"));
	    textarea.sendKeys("TEST TEST AREA"); // Enter text in the textarea

	    sleep(1000); // Wait for the action to complete

	    // Specify the path for the image to upload
	    String filePath = "C:" + File.separator + "Users" + File.separator + "ADMIN" + File.separator + "Pictures"
	        + File.separator + "Saved Pictures" + File.separator + "tomato.jpg";

	    // Find and click the upload button
	    WebElement uploadButton = driver.findElement(By.cssSelector("#button-upload-222"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", uploadButton);
	    sleep(1000);
	    uploadButton.click(); // Click to open the upload dialog

	    // Use the Robot class to upload a file from the clipboard
	    StringSelection stringSelection = new StringSelection(filePath);
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	    Robot robot = new Robot();

	    sleep(2000); // Wait before pasting the file path
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V); // Paste the file path
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);

	    sleep(2000); // Wait before confirming the upload
	    robot.keyPress(KeyEvent.VK_ENTER); // Confirm the upload
	    robot.keyRelease(KeyEvent.VK_ENTER);

	    sleep(1000); // Wait for the upload to complete

	    // Accept the alert that appears after uploading the file
	    Alert alert = driver.switchTo().alert();
	    alert.accept(); // Accept the alert
	    sleep(1000); // Wait for the alert to close

	    // Submit the cart
	    WebElement submit = driver.findElement(By.cssSelector("#button-cart"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submit);
	    sleep(2000);
	    submit.click(); // Click to submit the cart

	    sleep(1000); // Wait for the action to complete

	    // Open the cart to verify the products added
	    WebElement cartButton = driver.findElement(By.cssSelector("#header-cart > div > button"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartButton);
	    sleep(5000);
	    cartButton.click(); // Click to view the cart

	    sleep(5000); // Wait for the cart to load

	    // Verify the first product (iPhone) is correctly added to the cart
	    WebElement productIphoneName = driver.findElement(
	        By.cssSelector("#header-cart > div > ul > li > table > tbody > tr:nth-child(1) > td.text-start > a"));
	    String iphoneNameActual = productIphoneName.getText(); // Get the actual name of the iPhone

	    WebElement productIphoneQuantity = driver.findElement(
	        By.cssSelector("#header-cart > div > ul > li > table > tbody > tr:nth-child(1) > td:nth-child(3)"));
	    int iphoneQuantityActual = Integer.parseInt(productIphoneQuantity.getText().replace("x", "").trim()); // Get the actual quantity of iPhone

	    String iphoneNameExpected = "iPhone"; // Expected name for the iPhone
	    int iphoneQuantityExpected = 1; // Expected quantity for the iPhone

	    // Verify the second product (Apple Cinema) is correctly added to the cart
	    WebElement productAppleName = driver.findElement(
	        By.cssSelector("#header-cart > div > ul > li > table > tbody > tr:nth-child(2) > td.text-start > a"));
	    String appleNameActual = productAppleName.getText(); // Get the actual name of the Apple Cinema

	    WebElement productAppleQuantity = driver.findElement(
	        By.cssSelector("#header-cart > div > ul > li > table > tbody > tr:nth-child(2) > td:nth-child(3)"));
	    int appleQuantityActual = Integer.parseInt(productAppleQuantity.getText().replace("x", "").trim()); // Get the actual quantity of Apple Cinema

	    String appleNameExpected = "Apple Cinema 30\""; // Expected name for the Apple Cinema
	    int appleQuantityExpected = 2; // Expected quantity for the Apple Cinema

	    // Assert that the actual quantities and names match the expected values for both products
	    Assert.assertEquals("Khác nhau số lượng", iphoneQuantityExpected, iphoneQuantityActual);
	    Assert.assertEquals("Khác nhau về tên sản phẩm", iphoneNameExpected, iphoneNameActual);
	    Assert.assertEquals("Khác nhau số lượng", appleQuantityExpected, appleQuantityActual);
	    Assert.assertEquals("Khác nhau về tên sản phẩm", appleNameExpected, appleNameActual);
	}

	//Kiểm thử khi thêm vào giỏ hàng với số lượng không hợp lệ
	@Test
	public void testAddToCartWithInvalidQuantity() {
	    // Điều hướng đến trang chính của OpenCart
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(2000); // Chờ cho trang tải xong

	    // Tìm và nhấp vào liên kết của sản phẩm thứ hai
	    WebElement productLink = driver.findElement(By.cssSelector(
	        "#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > div > h4 > a"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productLink); // Cuộn đến liên kết sản phẩm
	    sleep(1000); // Chờ cho việc cuộn hoàn tất
	    productLink.click(); // Nhấp vào liên kết sản phẩm
	    sleep(1000); // Chờ cho trang sản phẩm tải xong

	    // Tìm trường nhập số lượng và đặt một số lượng không hợp lệ
	    WebElement inputQuantity = driver.findElement(By.cssSelector("#input-quantity"));
	    inputQuantity.clear(); // Xóa bất kỳ số lượng nào đã nhập
	    inputQuantity.sendKeys("1000"); // Nhập số lượng quá cao
	    sleep(1000); // Chờ cho việc nhập số lượng hoàn tất

	    // Tìm và nhấp vào nút 'Thêm vào giỏ hàng'
	    WebElement addToCartBtn = driver.findElement(By.cssSelector("#button-cart"));
	    addToCartBtn.click(); // Nhấp để thêm sản phẩm vào giỏ hàng
	    sleep(1000);
	    // Xác minh rằng thông báo lỗi được hiển thị cho số lượng không hợp lệ
	    boolean errorMessageDisplayed = driver.findElements(By.cssSelector(".alert-danger")).size() > 0;
	    Assert.assertTrue("Thông báo lỗi không hiển thị khi nhập số lượng quá lớn", errorMessageDisplayed);
	    if(errorMessageDisplayed) {
	    	WebElement errorContent = driver.findElement(By.cssSelector(".alert-danger"));
	    	Assert.assertEquals("Warning: Quantity is too large", errorContent.getText()); // Kiểm tra nội dung thông báo lỗi
	    }
	    
	    sleep(5000); // Chờ một chút để xem thông báo lỗi

	    // Kiểm tra trường hợp nhập số lượng không hợp lệ là chữ
	    inputQuantity.clear(); // Xóa số lượng đã nhập
	    inputQuantity.sendKeys("abc"); // Nhập số lượng không hợp lệ
	    addToCartBtn.click(); // Nhấp để thêm sản phẩm vào giỏ hàng

	    // Xác minh rằng thông báo lỗi được hiển thị cho số lượng không hợp lệ
	    errorMessageDisplayed = driver.findElements(By.cssSelector(".alert-danger")).size() > 0;
	    Assert.assertTrue("Thông báo lỗi sai định dạng không thông báo", errorMessageDisplayed);
	    if(errorMessageDisplayed) {
	    	WebElement errorContent = driver.findElement(By.cssSelector(".alert-danger"));
	    	Assert.assertEquals("Warning: Quantity invalid", errorContent.getText()); // Kiểm tra nội dung thông báo lỗi
	    }
	}

	//Kiểm tra tổng đơn có sau khi nhiều sản phẩm khác nhau
	@Test
	public void testTotalAfterAddMulti() {
	    // Điều hướng đến trang chính của OpenCart
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(2000); // Chờ cho trang tải xong

	    // Tìm và nhấp vào liên kết của sản phẩm iPhone
	    WebElement linkIphone = driver.findElement(By.cssSelector(
	        "#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > div > h4 > a"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkIphone); // Cuộn đến liên kết sản phẩm iPhone
	    sleep(1000); // Chờ cho việc cuộn hoàn tất
	    linkIphone.click(); // Nhấp vào liên kết sản phẩm iPhone
	    sleep(1000); // Chờ cho trang sản phẩm tải xong

	    // Tìm trường nhập số lượng cho iPhone và đặt số lượng
	    WebElement inputIphone = driver.findElement(By.cssSelector("#input-quantity"));
	    inputIphone.clear(); // Xóa bất kỳ số lượng nào đã nhập
	    inputIphone.sendKeys("100"); // Nhập số lượng iPhone là 100
	    sleep(1000); // Chờ cho việc nhập số lượng hoàn tất

	    // Tìm và nhấp vào nút 'Thêm vào giỏ hàng' cho iPhone
	    WebElement addToCartIphone = driver.findElement(By.cssSelector("#button-cart"));
	    addToCartIphone.click(); // Nhấp để thêm sản phẩm iPhone vào giỏ hàng
	    sleep(2000); // Chờ cho sản phẩm được thêm vào giỏ hàng

	    // Quay lại trang chính
	    WebElement homeBtn = driver.findElement(By.cssSelector("#logo"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homeBtn); // Cuộn đến nút trang chính
	    sleep(1000); // Chờ cho việc cuộn hoàn tất
	    homeBtn.click(); // Nhấp để quay lại trang chính
	    sleep(2000); // Chờ cho trang tải xong

	    // Tìm và nhấp vào liên kết của sản phẩm MacBook
	    WebElement macbookLink = driver.findElement(By.cssSelector(
	        "#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(1) > div > div.content > div > h4 > a"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", macbookLink); // Cuộn đến liên kết sản phẩm MacBook
	    sleep(1000); // Chờ cho việc cuộn hoàn tất
	    macbookLink.click(); // Nhấp vào liên kết sản phẩm MacBook
	    sleep(1000); // Chờ cho trang sản phẩm tải xong

	    // Tìm trường nhập số lượng cho MacBook và đặt số lượng
	    WebElement inputMacbook = driver.findElement(By.cssSelector("#input-quantity"));
	    inputMacbook.clear(); // Xóa bất kỳ số lượng nào đã nhập
	    inputMacbook.sendKeys("100"); // Nhập số lượng MacBook là 100
	    sleep(1000); // Chờ cho việc nhập số lượng hoàn tất

	    // Tìm và nhấp vào nút 'Thêm vào giỏ hàng' cho MacBook
	    WebElement addToCartMacbook = driver.findElement(By.cssSelector("#button-cart"));
	    addToCartMacbook.click(); // Nhấp để thêm sản phẩm MacBook vào giỏ hàng
	    sleep(5000); // Chờ cho sản phẩm được thêm vào giỏ hàng

	    // Tìm và nhấp vào liên kết giỏ hàng
	    WebElement cartLink = driver.findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(4) > a"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartLink); // Cuộn đến liên kết giỏ hàng
	    sleep(1000); // Chờ cho việc cuộn hoàn tất
	    cartLink.click(); // Nhấp để vào giỏ hàng
	    sleep(5000); // Chờ cho trang giỏ hàng tải xong

	    // Đặt các giá trị mong đợi cho các sản phẩm
	    double iphoneTotalExpected = 12320; // Tổng giá trị mong đợi cho iPhone
	    double macbookTotalExpected = 60200; // Tổng giá trị mong đợi cho MacBook

	    double subTotalExpected = iphoneTotalExpected + macbookTotalExpected; // Tổng phụ mong đợi
	    double ecoTaxExpected = 2.00 * 200.00; // Thuế sinh thái mong đợi

	    double vatExpected = 0.2 * subTotalExpected; // VAT mong đợi

	    double totalExpected = subTotalExpected + ecoTaxExpected + vatExpected; // Tổng giá trị mong đợi

	    // Lấy tổng giá trị thực tế cho iPhone từ giỏ hàng
	    WebElement totalIphone = driver.findElement(
	        By.cssSelector("#shopping-cart > div > table > tbody > tr:nth-child(1) > td:nth-child(6)"));
	    double totalIphoneActual = Double.parseDouble(totalIphone.getText().replace("$", "").replace(",", "")); // Chuyển đổi giá trị sang kiểu double

	    // Lấy tổng giá trị thực tế cho MacBook từ giỏ hàng
	    WebElement totalMacBook = driver.findElement(
	        By.cssSelector("#shopping-cart > div > table > tbody > tr:nth-child(2) > td:nth-child(6)"));
	    double totalMacBookActual = Double.parseDouble(totalMacBook.getText().replace("$", "").replace(",", "")); // Chuyển đổi giá trị sang kiểu double

	    // Lấy tổng phụ thực tế từ giỏ hàng
	    WebElement subTotal = driver.findElement(By.cssSelector("#checkout-total > tr:nth-child(1) > td:nth-child(2)"));
	    double subTotalActual = Double.parseDouble(subTotal.getText().replace("$", "").replace(",", "")); // Chuyển đổi giá trị sang kiểu double

	    // Lấy thuế sinh thái thực tế từ giỏ hàng
	    WebElement ecoTax = driver.findElement(By.cssSelector("#checkout-total > tr:nth-child(2) > td:nth-child(2)"));
	    double ecoTaxActual = Double.parseDouble(ecoTax.getText().replace("$", "").replace(",", "")); // Chuyển đổi giá trị sang kiểu double

	    // Lấy VAT thực tế từ giỏ hàng
	    WebElement vat = driver.findElement(By.cssSelector("#checkout-total > tr:nth-child(3) > td:nth-child(2)"));
	    double vatActual = Double.parseDouble(vat.getText().replace("$", "").replace(",", "")); // Chuyển đổi giá trị sang kiểu double

	    // Lấy tổng thực tế từ giỏ hàng
	    WebElement total = driver.findElement(By.cssSelector("#checkout-total > tr:nth-child(4) > td:nth-child(2)"));
	    double totalActual = Double.parseDouble(total.getText().replace("$", "").replace(",", "")); // Chuyển đổi giá trị sang kiểu double

	    // Xác minh rằng tổng giá trị thực tế cho iPhone khớp với mong đợi
	    Assert.assertEquals("Giá trị tổng iPhone không khớp", iphoneTotalExpected, totalIphoneActual, 0.001);

	    // Xác minh rằng tổng giá trị thực tế cho MacBook khớp với mong đợi
	    Assert.assertEquals("Giá trị tổng MacBook không khớp", macbookTotalExpected, totalMacBookActual, 0.001);

	    // Xác minh rằng tổng phụ thực tế khớp với mong đợi
	    Assert.assertEquals("Giá trị tổng phụ không khớp", subTotalExpected, subTotalActual, 0.001);

	    // Xác minh rằng thuế sinh thái thực tế khớp với mong đợi
	    Assert.assertEquals("Giá trị Eco Tax không khớp", ecoTaxExpected, ecoTaxActual, 0.001);

	    // Xác minh rằng VAT thực tế khớp với mong đợi
	    Assert.assertEquals("Giá trị VAT không khớp", vatExpected, vatActual, 0.001);

	    // Xác minh rằng tổng thực tế khớp với mong đợi
	    Assert.assertEquals("Giá trị tổng không khớp", totalExpected, totalActual, 0.001);
	}

	//Kiểm thử thao tác sửa và xóa sau khi thêm
	@Test
	public void testUpdateAndDeleteProduct() {
	    // Điều hướng đến trang chủ OpenCart
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(2000); // Chờ trang tải xong

	    // Tìm kiếm và nhấp vào liên kết iPhone
	    WebElement linkIphone = driver.findElement(By.cssSelector(
	            "#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > div > h4 > a"));

	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkIphone); // Cuộn đến liên kết iPhone
	    sleep(1000);
	    linkIphone.click(); // Nhấp vào liên kết iPhone
	    sleep(5000);

	    // Đặt số lượng iPhone là 100 và thêm vào giỏ hàng
	    WebElement inputIphone = driver.findElement(By.cssSelector("#input-quantity"));
	    inputIphone.clear();
	    inputIphone.sendKeys("100");
	    sleep(1000);
	    
	    WebElement addToCartIphone = driver.findElement(By.cssSelector("#button-cart"));
	    addToCartIphone.click(); // Thêm iPhone vào giỏ hàng
	    sleep(5000);

	    // Điều hướng trở lại trang chủ
	    WebElement homeBtn = driver.findElement(By.cssSelector("#logo"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homeBtn);
	    sleep(1000);
	    homeBtn.click(); // Nhấp vào logo để quay lại trang chủ
	    sleep(2000);

	    // Tìm kiếm và nhấp vào liên kết MacBook
	    WebElement macbookLink = driver.findElement(By.cssSelector(
	            "#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(1) > div > div.content > div > h4 > a"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", macbookLink);
	    sleep(1000);
	    macbookLink.click(); // Nhấp vào liên kết MacBook
	    sleep(1000);

	    // Đặt số lượng MacBook là 100 và thêm vào giỏ hàng
	    WebElement inputMacbook = driver.findElement(By.cssSelector("#input-quantity"));
	    inputMacbook.clear();
	    inputMacbook.sendKeys("100");
	    sleep(1000);
	    
	    WebElement addToCartMacbook = driver.findElement(By.cssSelector("#button-cart"));
	    addToCartMacbook.click(); // Thêm MacBook vào giỏ hàng
	    sleep(5000);

	    // Điều hướng đến giỏ hàng
	    WebElement cartLink = driver
	            .findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(4) > a"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartLink);
	    sleep(1000);
	    cartLink.click(); // Nhấp vào liên kết giỏ hàng
	    sleep(2000);

	    // Tìm nút xóa sản phẩm và nhấp vào
	    WebElement deleteBtn = driver.findElement(By.cssSelector(
	            "#shopping-cart > div > table > tbody > tr:nth-child(2) > td:nth-child(4) > form > div > button.btn.btn-danger"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deleteBtn);
	    sleep(1000);
	    deleteBtn.click(); // Nhấp vào nút xóa
	    sleep(1000);

	    // Kiểm tra thông báo xóa thành công
	    WebElement deleteAlert = driver.findElement(By.cssSelector("#alert > div"));
	    Assert.assertTrue("Thông báo thành công không hiển thị", deleteAlert.isDisplayed());
	    
	    sleep(2000);

	    // Lấy danh sách các sản phẩm còn lại trong giỏ hàng
	    List<WebElement> rows = driver.findElements(By.cssSelector("#shopping-cart > div > table > tbody > tr > td.text-start.text-wrap"));
	    
	    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
	    sleep(5000);
	    
	    // Kiểm tra xem sản phẩm 'MacBook' đã bị xóa hay chưa
	    boolean productExists = true;
	    for (WebElement row : rows) {
	        String productName = row.findElement(By.cssSelector("a")).getText();
	        if (productName.equals("MacBook")) {
	            productExists = false; // Nếu vẫn còn sản phẩm, đặt flag là false
	            break;
	        }
	    }
	    
	    Assert.assertTrue("Sản phẩm 'MacBook' không được xóa thành công", productExists);
	    
	    sleep(1000);
	    
	    // Cập nhật số lượng iPhone còn lại
	    WebElement updateQuantity = driver.findElement(By.cssSelector(
	            "#shopping-cart > div > table > tbody > tr:nth-child(1) > td:nth-child(4) > form > div > input.form-control"));
	    updateQuantity.clear();
	    sleep(1000);
	    updateQuantity.sendKeys("50"); // Đặt số lượng iPhone là 50
	    sleep(1000);
	    
	    // Nhấp vào nút cập nhật
	    WebElement updateBtn = driver.findElement(By.cssSelector("#shopping-cart > div > table > tbody > tr > td:nth-child(4) > form > div > button.btn.btn-primary"));
	    updateBtn.click(); // Cập nhật giỏ hàng
	    sleep(2000);
	    
	    // Kiểm tra thông báo cập nhật thành công
	    WebElement updateAlert = driver.findElement(By.cssSelector("#alert > div"));
	    Assert.assertTrue("Thông báo thành công không hiển thị", updateAlert.isDisplayed());
	    
	    sleep(5000);
	    
	    // Tính toán giá trị dự kiến
	    double iphoneTotalExpected = 123.20 * 50;
	    double subTotalExpected = iphoneTotalExpected;
	    double ecoTaxExpected = 2.00 * 50;
	    double vatExpected = 0.2 * subTotalExpected;
	    double totalExpected = subTotalExpected + ecoTaxExpected + vatExpected;

	    // Kiểm tra tổng giá trị iPhone
	    WebElement totalIphone = driver.findElement(
	            By.cssSelector("#shopping-cart > div > table > tbody > tr > td:nth-child(6)"));
	    double totalIphoneActual = Double.parseDouble(totalIphone.getText().replace("$", "").replace(",", ""));
	    
	    // Kiểm tra tổng phụ
	    WebElement subTotal = driver.findElement(By.cssSelector("#checkout-total > tr:nth-child(1) > td:nth-child(2)"));
	    double subTotalActual = Double.parseDouble(subTotal.getText().replace("$", "").replace(",", ""));

	    // Kiểm tra thuế Eco
	    WebElement ecoTax = driver.findElement(By.cssSelector("#checkout-total > tr:nth-child(2) > td:nth-child(2)"));
	    double ecoTaxActual = Double.parseDouble(ecoTax.getText().replace("$", "").replace(",", ""));

	    // Kiểm tra VAT
	    WebElement vat = driver.findElement(By.cssSelector("#checkout-total > tr:nth-child(3) > td:nth-child(2)"));
	    double vatActual = Double.parseDouble(vat.getText().replace("$", "").replace(",", ""));

	    // Kiểm tra tổng
	    WebElement total = driver.findElement(By.cssSelector("#checkout-total > tr:nth-child(4) > td:nth-child(2)"));
	    double totalActual = Double.parseDouble(total.getText().replace("$", "").replace(",", ""));

	    // So sánh các giá trị thực tế và dự kiến
	    Assert.assertEquals("Giá trị tổng iPhone không khớp", iphoneTotalExpected, totalIphoneActual, 0.001);
	    Assert.assertEquals("Giá trị tổng phụ không khớp", subTotalExpected, subTotalActual, 0.001);
	    Assert.assertEquals("Giá trị Eco Tax không khớp", ecoTaxExpected, ecoTaxActual, 0.001);
	    Assert.assertEquals("Giá trị VAT không khớp", vatExpected, vatActual, 0.001);
	    Assert.assertEquals("Giá trị tổng không khớp", totalExpected, totalActual, 0.001);
	}


	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
