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
import org.openqa.selenium.support.ui.Select;

public class CheckoutGuestAccounTest {
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
	// Mục đích của hàm: Kiểm tra chức năng thanh toán với tài khoản khách hàng
	public void testCheckoutWithGuestAccount() {
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000);

	    WebElement addToCartBtn = driver.findElement(By.cssSelector(
	            "#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > form > div > button:nth-child(1)"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
	    sleep(1000);

	    addToCartBtn.click();
	    sleep(2000);

	    addToCartBtn.click();
	    sleep(5000);

	    WebElement checkoutLink = driver.findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(5) > a"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutLink);
	    sleep(1000);
	    checkoutLink.click();

	    WebElement inputGuest = driver.findElement(By.cssSelector("#input-guest"));
	    inputGuest.click();
	    sleep(1000);

	    String firstName = "Qui";
	    String lastName = "Nguyen";
	    String email = "nguyenddqui@gmail.com";
	    String company = "Company ABC";
	    String address1 = "Quan 1";
	    String address2 = "Quan 5";
	    String city = "Ho Chi Minh City";
	    String postCode = "700000";
	    String country = "Viet Nam";
	    String region = "Ho Chi Minh City";

	    WebElement inputFirstName = driver.findElement(By.cssSelector("#input-firstname"));
	    inputFirstName.sendKeys(firstName);
	    sleep(1000);

	    WebElement inputLastName = driver.findElement(By.cssSelector("#input-lastname"));
	    inputLastName.sendKeys(lastName);
	    sleep(1000);

	    WebElement inputEmail = driver.findElement(By.cssSelector("#input-email"));
	    inputEmail.sendKeys(email);
	    sleep(1000);

	    WebElement inputCompany = driver.findElement(By.cssSelector("#input-shipping-company"));
	    inputCompany.sendKeys(company);
	    sleep(1000);

	    WebElement inputAddress1 = driver.findElement(By.cssSelector("#input-shipping-address-1"));
	    inputAddress1.sendKeys(address1);
	    sleep(1000);

	    WebElement inputAddress2 = driver.findElement(By.cssSelector("#input-shipping-address-2"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputAddress2);
	    sleep(1000);
	    inputAddress2.sendKeys(address2);

	    WebElement inputCity = driver.findElement(By.cssSelector("#input-shipping-city"));
	    inputCity.sendKeys(city);
	    sleep(1000);

	    WebElement inputPostCode = driver.findElement(By.cssSelector("#input-shipping-postcode"));
	    inputPostCode.clear();
	    inputPostCode.sendKeys(postCode);
	    sleep(1000);

	    WebElement inputCountry = driver.findElement(By.cssSelector("#input-shipping-country"));
	    Select selectionCountry = new Select(inputCountry);
	    selectionCountry.selectByVisibleText(country);
	    sleep(1000);

	    WebElement inputRegion = driver.findElement(By.cssSelector("#input-shipping-zone"));
	    Select selectionRegion = new Select(inputRegion);
	    selectionRegion.selectByVisibleText(region);
	    sleep(1000);

	    WebElement continueBtn = driver.findElement(By.cssSelector("#button-register"));
	    continueBtn.click();
	    sleep(5000);

	    WebElement shippingMethod = driver.findElement(By.cssSelector("#button-shipping-methods"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", shippingMethod);
	    sleep(1000);
	    shippingMethod.click();
	    sleep(1000);

	    WebElement methodFlat = driver.findElement(By.cssSelector("#input-shipping-method-flat-flat"));
	    methodFlat.click();
	    sleep(1000);

	    WebElement continue_1 = driver.findElement(By.cssSelector("#button-shipping-method"));
	    continue_1.click();
	    sleep(1000);

	    WebElement paymentMethod = driver.findElement(By.cssSelector("#button-payment-methods"));
	    paymentMethod.click();
	    sleep(1000);

	    WebElement cashMethod = driver.findElement(By.cssSelector("#input-payment-method-cod-cod"));
	    cashMethod.click();
	    sleep(1000);

	    WebElement continue_2 = driver.findElement(By.cssSelector("#button-payment-method"));
	    continue_2.click();
	    sleep(1000);

	    WebElement confirmOrder = driver.findElement(By.cssSelector("#button-confirm"));
	    confirmOrder.click();
	    sleep(1000);

	    WebElement notification = driver.findElement(By.cssSelector("#content > h1"));
	    String notificationActual = notification.getText();

	    String notificationExpected = "Your order has been placed!";

	    Assert.assertEquals("Đơn hàng không được đặt thành công", notificationExpected, notificationActual);
	}



	// Kiểm thử tài khoản khách với thông tin đầu vào bắt buộc để trống.
	@Test
	public void testGuestAccountEmptyRequiredInput() {
	    // Mở trang chính
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000);

	    // Thêm sản phẩm vào giỏ hàng
	    WebElement addToCartBtn = driver.findElement(By.cssSelector(
	            "#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > form > div > button:nth-child(1)"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
	    sleep(1000);
	    addToCartBtn.click();
	    sleep(2000);
	    addToCartBtn.click();
	    sleep(5000);

	    // Điều hướng đến trang thanh toán
	    WebElement checkoutLink = driver.findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(5) > a"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutLink);
	    sleep(1000);
	    checkoutLink.click();

	    // Nhập thông tin khách hàng (để trống các trường bắt buộc)
	    WebElement inputGuest = driver.findElement(By.cssSelector("#input-guest"));
	    inputGuest.click();
	    sleep(1000);

	    String firstName = ""; // Họ
	    String lastName = "";  // Tên
	    String email = "";     // Email
	    String company = "Company ABC"; // Công ty
	    String address1 = "";  // Địa chỉ 1
	    String address2 = "Quan 5"; // Địa chỉ 2
	    String city = "";      // Thành phố
	    String postCode = "700000"; // Mã bưu điện
	    String country = " --- Please Select --- "; // Quốc gia
	    String region = "--- Please Select --- ";   // Khu vực

	    // Điền thông tin vào các trường
	    driver.findElement(By.cssSelector("#input-firstname")).sendKeys(firstName);
	    sleep(1000);
	    driver.findElement(By.cssSelector("#input-lastname")).sendKeys(lastName);
	    sleep(1000);
	    driver.findElement(By.cssSelector("#input-email")).sendKeys(email);
	    sleep(1000);
	    driver.findElement(By.cssSelector("#input-shipping-company")).sendKeys(company);
	    sleep(1000);
	    driver.findElement(By.cssSelector("#input-shipping-address-1")).sendKeys(address1);
	    sleep(1000);
	    driver.findElement(By.cssSelector("#input-shipping-address-2")).sendKeys(address2);
	    sleep(1000);
	    driver.findElement(By.cssSelector("#input-shipping-city")).sendKeys(city);
	    sleep(1000);
	    driver.findElement(By.cssSelector("#input-shipping-postcode")).clear();
	    driver.findElement(By.cssSelector("#input-shipping-postcode")).sendKeys(postCode);
	    sleep(1000);

	    // Chọn quốc gia và khu vực (để trống)
	    Select selectionCountry = new Select(driver.findElement(By.cssSelector("#input-shipping-country")));
	    selectionCountry.selectByVisibleText(country);
	    sleep(1000);
	    Select selectionRegion = new Select(driver.findElement(By.cssSelector("#input-shipping-zone")));
	    selectionRegion.selectByVisibleText(region);
	    sleep(1000);

	    // Nhấn nút tiếp tục để kiểm tra cảnh báo
	    driver.findElement(By.cssSelector("#button-register")).click();
	    sleep(3000);

	    // Kiểm tra xem các thông báo cảnh báo có hiển thị hay không
	    WebElement warningFirstName = driver.findElement(By.cssSelector("#error-firstname"));
	    Assert.assertTrue("Không hiển thị warning First Name", warningFirstName.isDisplayed());

	    WebElement warningLastName = driver.findElement(By.cssSelector("#error-lastname"));
	    Assert.assertTrue("Không hiển thị warning Last Name", warningLastName.isDisplayed());

	    WebElement warningEmail = driver.findElement(By.cssSelector("#error-email"));
	    Assert.assertTrue("Không hiển thị warning Email", warningEmail.isDisplayed());

	    WebElement warningAddress_1 = driver.findElement(By.cssSelector("#error-shipping-address-1"));
	    Assert.assertTrue("Không hiển thị warning Address 1", warningAddress_1.isDisplayed());

	    WebElement warningCity = driver.findElement(By.cssSelector("#error-shipping-city"));
	    Assert.assertTrue("Không hiển thị warning City", warningCity.isDisplayed());

	    WebElement warningCountry = driver.findElement(By.cssSelector("#error-shipping-country"));
	    Assert.assertTrue("Không hiển thị warning Country", warningCountry.isDisplayed());

	    WebElement warningShippingZone = driver.findElement(By.cssSelector("#error-shipping-zone"));
	    Assert.assertTrue("Không hiển thị warning Shipping Zone", warningShippingZone.isDisplayed());
	}

	
	// Kiểm thử tài khoản khách với thông tin đầu vào vượt quá giới hạn cho phép.
	@Test
	public void testGuestAccountAboveUpperBoundary() {
	    // Mở trang chính
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000);

	    // Thêm sản phẩm vào giỏ hàng
	    WebElement addToCartBtn = driver.findElement(By.cssSelector(
	            "#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > form > div > button:nth-child(1)"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
	    sleep(1000);
	    addToCartBtn.click();
	    sleep(2000);
	    addToCartBtn.click();
	    sleep(5000);

	    // Nhập thông tin khách hàng (vượt quá giới hạn)
	    String firstName = "AlexandriaCatherineElizabethMarieAnn"; // Tên quá dài
	    String lastName = "MontgomeryWilliamsonMacAllisterBrown";   // Họ quá dài
	    String email = "sdnkkdsfk"; // Email không hợp lệ
	    String company = "Company ABC"; // Công ty
	    String address1 = "234 Elm Street, Apartment 56B, Greenfield, Ho Chi Minh City, Vietnam, 700000, Near Central Park, District 1"; // Địa chỉ quá dài
	    String address2 = "Quan 5"; // Địa chỉ 2
	    String city = "Ho Chi Minh City, a bustling metropolis in southern Vietnam known for its vibrant culture, delicious street food, and historical landmarks"; // Thành phố quá dài
	    String postCode = "700000"; // Mã bưu điện
	    String country = " --- Please Select --- "; // Quốc gia
	    String region = "--- Please Select --- "; // Khu vực

	    // Điều hướng đến trang thanh toán
	    WebElement checkoutLink = driver.findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(5) > a"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutLink);
	    sleep(1000);
	    checkoutLink.click();

	    // Nhập thông tin vào các trường
	    WebElement inputGuest = driver.findElement(By.cssSelector("#input-guest"));
	    inputGuest.click();
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

	    WebElement inputCompany = driver.findElement(By.cssSelector("#input-shipping-company"));
	    inputCompany.sendKeys(company);
	    sleep(1000);

	    WebElement inputAddress1 = driver.findElement(By.cssSelector("#input-shipping-address-1"));
	    inputAddress1.sendKeys(address1);
	    sleep(1000);

	    WebElement inputAddress2 = driver.findElement(By.cssSelector("#input-shipping-address-2"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputAddress2);
	    sleep(1000);
	    inputAddress2.sendKeys(address2);

	    WebElement inputCity = driver.findElement(By.cssSelector("#input-shipping-city"));
	    inputCity.sendKeys(city);
	    sleep(1000);

	    WebElement inputPostCode = driver.findElement(By.cssSelector("#input-shipping-postcode"));
	    inputPostCode.clear();
	    inputPostCode.sendKeys(postCode);
	    sleep(1000);

	    // Chọn quốc gia và khu vực (để trống)
	    WebElement inputCountry = driver.findElement(By.cssSelector("#input-shipping-country"));
	    Select selectionCountry = new Select(inputCountry);
	    selectionCountry.selectByVisibleText(country);
	    sleep(1000);

	    WebElement inputRegion = driver.findElement(By.cssSelector("#input-shipping-zone"));
	    Select selectionRegion = new Select(inputRegion);
	    selectionRegion.selectByVisibleText(region);
	    sleep(1000);

	    // Nhấn nút tiếp tục để kiểm tra cảnh báo
	    WebElement continueBtn = driver.findElement(By.cssSelector("#button-register"));
	    continueBtn.click();
	    sleep(3000);

	    // Kiểm tra xem các thông báo cảnh báo có hiển thị hay không
	    WebElement warningFirstName = driver.findElement(By.cssSelector("#error-firstname"));
	    Assert.assertTrue("Không hiển thị warning First Name", warningFirstName.isDisplayed());

	    WebElement warningLastName = driver.findElement(By.cssSelector("#error-lastname"));
	    Assert.assertTrue("Không hiển thị warning Last Name", warningLastName.isDisplayed());

	    WebElement warningEmail = driver.findElement(By.cssSelector("#error-email"));
	    Assert.assertTrue("Không hiển thị warning Email", warningEmail.isDisplayed());

	    WebElement warningAddress_1 = driver.findElement(By.cssSelector("#error-shipping-address-1"));
	    Assert.assertTrue("Không hiển thị warning Address 1", warningAddress_1.isDisplayed());

	    WebElement warningCity = driver.findElement(By.cssSelector("#error-shipping-city"));
	    Assert.assertTrue("Không hiển thị warning City", warningCity.isDisplayed());

	    WebElement warningCountry = driver.findElement(By.cssSelector("#error-shipping-country"));
	    Assert.assertTrue("Không hiển thị warning Country", warningCountry.isDisplayed());

	    WebElement warningShippingZone = driver.findElement(By.cssSelector("#error-shipping-zone"));
	    Assert.assertTrue("Không hiển thị warning Shipping Zone", warningShippingZone.isDisplayed());
	}

	
	@Test
	public void testGuestAccountUpperBoundary() {
	    // Mở trang chính của OpenCart
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000);

	    // Tìm và nhấp vào nút thêm vào giỏ hàng
	    WebElement addToCartBtn = driver.findElement(By.cssSelector(
	            "#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > form > div > button:nth-child(1)"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
	    sleep(1000);

	    addToCartBtn.click(); // Nhấp để thêm sản phẩm vào giỏ hàng
	    sleep(2000);
	    addToCartBtn.click(); // Nhấp lần nữa để thêm sản phẩm
	    sleep(5000);

	    // Nhập thông tin khách hàng (đảm bảo nằm trong giới hạn)
	    String firstName = "TranThiKimHoaNguyen"; // Tên
	    String lastName = "NguyenVanThanhBinh"; // Họ
	    String email = "sdnkkdsfk"; // Email không hợp lệ
	    String company = "Company ABC"; // Công ty
	    String address1 = "1234 Nguyen Thi Minh Khai Street, District 3, Ho Chi Minh City, Vietnam, 700000, located near the famous Ben Thanh Market."; // Địa chỉ 1
	    String address2 = "Quan 5"; // Địa chỉ 2
	    String city = "Ho Chi Minh City, a vibrant metropolis known for its rich culture, delicious street food, and historical landmarks."; // Thành phố
	    String postCode = "700000"; // Mã bưu điện
	    String country = " --- Please Select --- "; // Quốc gia
	    String region = "--- Please Select --- "; // Khu vực

	    // Điều hướng đến trang thanh toán
	    WebElement checkoutLink = driver.findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(5) > a"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutLink);
	    sleep(1000);
	    checkoutLink.click();

	    // Nhập thông tin vào các trường
	    WebElement inputGuest = driver.findElement(By.cssSelector("#input-guest"));
	    inputGuest.click();
	    sleep(1000);

	    WebElement inputFirstName = driver.findElement(By.cssSelector("#input-firstname"));
	    inputFirstName.sendKeys(firstName);
	    sleep(1000);

	    WebElement inputLastName = driver.findElement(By.cssSelector("#input-lastname"));
	    inputLastName.sendKeys(lastName);
	    sleep(1000);

	    WebElement inputEmail = driver.findElement(By.cssSelector("#input-email"));
	    inputEmail.sendKeys(email); // Nhập email không hợp lệ
	    sleep(1000);

	    WebElement inputCompany = driver.findElement(By.cssSelector("#input-shipping-company"));
	    inputCompany.sendKeys(company);
	    sleep(1000);

	    WebElement inputAddress1 = driver.findElement(By.cssSelector("#input-shipping-address-1"));
	    inputAddress1.sendKeys(address1);
	    sleep(1000);

	    WebElement inputAddress2 = driver.findElement(By.cssSelector("#input-shipping-address-2"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputAddress2);
	    sleep(1000);
	    inputAddress2.sendKeys(address2);

	    WebElement inputCity = driver.findElement(By.cssSelector("#input-shipping-city"));
	    inputCity.sendKeys(city);
	    sleep(1000);

	    WebElement inputPostCode = driver.findElement(By.cssSelector("#input-shipping-postcode"));
	    inputPostCode.clear();
	    inputPostCode.sendKeys(postCode);
	    sleep(1000);

	    // Chọn quốc gia và khu vực (để trống)
	    WebElement inputCountry = driver.findElement(By.cssSelector("#input-shipping-country"));
	    Select selectionCountry = new Select(inputCountry);
	    selectionCountry.selectByVisibleText(country);
	    sleep(1000);

	    WebElement inputRegion = driver.findElement(By.cssSelector("#input-shipping-zone"));
	    Select selectionRegion = new Select(inputRegion);
	    selectionRegion.selectByVisibleText(region);
	    sleep(1000);

	    // Nhấn nút tiếp tục để kiểm tra cảnh báo
	    WebElement continueBtn = driver.findElement(By.cssSelector("#button-register"));
	    continueBtn.click();
	    sleep(3000);

	    // Kiểm tra xem các thông báo cảnh báo có hiển thị hay không
	    // Kiểm tra các cảnh báo cho trường thông tin hợp lệ
	    WebElement warningFirstName = driver.findElement(By.cssSelector("#error-firstname"));
	    Assert.assertTrue("Không hiển thị warning First Name", !warningFirstName.isDisplayed());

	    WebElement warningLastName = driver.findElement(By.cssSelector("#error-lastname"));
	    Assert.assertTrue("Không hiển thị warning Last Name", !warningLastName.isDisplayed());

	    WebElement warningEmail = driver.findElement(By.cssSelector("#error-email"));
	    Assert.assertTrue("Không hiển thị warning Email", warningEmail.isDisplayed());

	    WebElement warningAddress_1 = driver.findElement(By.cssSelector("#error-shipping-address-1"));
	    Assert.assertTrue("Không hiển thị warning Address 1", !warningAddress_1.isDisplayed());

	    WebElement warningCity = driver.findElement(By.cssSelector("#error-shipping-city"));
	    Assert.assertTrue("Không hiển thị warning City", !warningCity.isDisplayed());

	    WebElement warningCountry = driver.findElement(By.cssSelector("#error-shipping-country"));
	    Assert.assertTrue("Không hiển thị warning Country", warningCountry.isDisplayed());

	    WebElement warningShippingZone = driver.findElement(By.cssSelector("#error-shipping-zone"));
	    Assert.assertTrue("Không hiển thị warning Shipping Zone", warningShippingZone.isDisplayed());
	}

	
	@Test
	public void testGuestAccountLowerBoundary() {
	    // Mục tiêu: Kiểm tra khả năng tạo tài khoản khách hàng với các thông tin ở giới hạn dưới.
	    // Đảm bảo rằng:
	    // - Tên và họ có thể được nhập tối thiểu (1 ký tự).
	    // - Email không hợp lệ sẽ hiển thị cảnh báo.
	    // - Địa chỉ, thành phố, và khu vực không bắt buộc phải có thông tin nhưng không có cảnh báo xuất hiện nếu để trống.
	    
	    // Mở trang chính của OpenCart
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000); // Chờ 1 giây để trang tải

	    // Tìm và nhấp vào nút thêm vào giỏ hàng
	    WebElement addToCartBtn = driver.findElement(By.cssSelector(
	            "#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > form > div > button:nth-child(1)"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn); // Cuộn trang để nút hiển thị
	    sleep(1000); // Chờ 1 giây

	    addToCartBtn.click(); // Nhấp để thêm sản phẩm vào giỏ hàng
	    sleep(2000); // Chờ 2 giây
	    addToCartBtn.click(); // Nhấp lần nữa để thêm sản phẩm
	    sleep(5000); // Chờ 5 giây để xử lý thêm vào giỏ hàng

	    // Nhập thông tin khách hàng (đảm bảo nằm trong giới hạn)
	    String firstName = "A"; // Tên (giới hạn dưới)
	    String lastName = "B"; // Họ (giới hạn dưới)
	    String email = "sdnkkdsfk"; // Email không hợp lệ
	    String company = "Company ABC"; // Công ty
	    String address1 = "Q.1"; // Địa chỉ 1 (giới hạn dưới)
	    String address2 = "Quan 5"; // Địa chỉ 2
	    String city = "SG"; // Thành phố (giới hạn dưới)
	    String postCode = "700000"; // Mã bưu điện
	    String country = " --- Please Select --- "; // Quốc gia
	    String region = "--- Please Select --- "; // Khu vực

	    // Điều hướng đến trang thanh toán
	    WebElement checkoutLink = driver.findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(5) > a"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutLink); // Cuộn trang
	    sleep(1000); // Chờ 1 giây
	    checkoutLink.click(); // Nhấp vào liên kết thanh toán

	    // Nhập thông tin vào các trường
	    WebElement inputGuest = driver.findElement(By.cssSelector("#input-guest"));
	    inputGuest.click(); // Nhấp vào ô nhập thông tin khách
	    sleep(1000); // Chờ 1 giây

	    // Nhập tên
	    WebElement inputFirstName = driver.findElement(By.cssSelector("#input-firstname"));
	    inputFirstName.sendKeys(firstName); // Nhập tên
	    sleep(1000); // Chờ 1 giây

	    // Nhập họ
	    WebElement inputLastName = driver.findElement(By.cssSelector("#input-lastname"));
	    inputLastName.sendKeys(lastName); // Nhập họ
	    sleep(1000); // Chờ 1 giây

	    // Nhập email
	    WebElement inputEmail = driver.findElement(By.cssSelector("#input-email"));
	    inputEmail.sendKeys(email); // Nhập email không hợp lệ
	    sleep(1000); // Chờ 1 giây

	    // Nhập tên công ty
	    WebElement inputCompany = driver.findElement(By.cssSelector("#input-shipping-company"));
	    inputCompany.sendKeys(company); // Nhập tên công ty
	    sleep(1000); // Chờ 1 giây

	    // Nhập địa chỉ 1
	    WebElement inputAddress1 = driver.findElement(By.cssSelector("#input-shipping-address-1"));
	    inputAddress1.sendKeys(address1); // Nhập địa chỉ 1 (giới hạn dưới)
	    sleep(1000); // Chờ 1 giây

	    // Nhập địa chỉ 2
	    WebElement inputAddress2 = driver.findElement(By.cssSelector("#input-shipping-address-2"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputAddress2); // Cuộn để hiển thị
	    sleep(1000); // Chờ 1 giây
	    inputAddress2.sendKeys(address2); // Nhập địa chỉ 2

	    // Nhập thành phố
	    WebElement inputCity = driver.findElement(By.cssSelector("#input-shipping-city"));
	    inputCity.sendKeys(city); // Nhập thành phố (giới hạn dưới)
	    sleep(1000); // Chờ 1 giây

	    // Nhập mã bưu điện
	    WebElement inputPostCode = driver.findElement(By.cssSelector("#input-shipping-postcode"));
	    inputPostCode.clear(); // Xóa trường mã bưu điện
	    inputPostCode.sendKeys(postCode); // Nhập mã bưu điện
	    sleep(1000); // Chờ 1 giây

	    // Chọn quốc gia
	    WebElement inputCountry = driver.findElement(By.cssSelector("#input-shipping-country"));
	    Select selectionCountry = new Select(inputCountry);
	    selectionCountry.selectByVisibleText(country); // Chọn quốc gia từ danh sách
	    sleep(1000); // Chờ 1 giây

	    // Chọn khu vực
	    WebElement inputRegion = driver.findElement(By.cssSelector("#input-shipping-zone"));
	    Select selectionRegion = new Select(inputRegion);
	    selectionRegion.selectByVisibleText(region); // Chọn khu vực từ danh sách
	    sleep(1000); // Chờ 1 giây

	    // Nhấn nút tiếp tục để kiểm tra cảnh báo
	    WebElement continueBtn = driver.findElement(By.cssSelector("#button-register"));
	    continueBtn.click(); // Nhấp vào nút tiếp tục
	    sleep(3000); // Chờ 3 giây để xử lý

	    // Kiểm tra xem các thông báo cảnh báo có hiển thị hay không
	    // Kiểm tra các cảnh báo cho trường thông tin hợp lệ
	    WebElement warningFirstName = driver.findElement(By.cssSelector("#error-firstname"));
	    Assert.assertTrue("Không hiển thị warning First Name", !warningFirstName.isDisplayed()); // Kiểm tra không có cảnh báo tên

	    WebElement warningLastName = driver.findElement(By.cssSelector("#error-lastname"));
	    Assert.assertTrue("Không hiển thị warning Last Name", !warningLastName.isDisplayed()); // Kiểm tra không có cảnh báo họ

	    WebElement warningEmail = driver.findElement(By.cssSelector("#error-email"));
	    Assert.assertTrue("Không hiển thị warning Email", warningEmail.isDisplayed()); // Kiểm tra hiển thị cảnh báo email

	    WebElement warningAddress_1 = driver.findElement(By.cssSelector("#error-shipping-address-1"));
	    Assert.assertTrue("Không hiển thị warning Address 1", !warningAddress_1.isDisplayed()); // Kiểm tra không có cảnh báo địa chỉ 1

	    WebElement warningCity = driver.findElement(By.cssSelector("#error-shipping-city"));
	    Assert.assertTrue("Không hiển thị warning City", !warningCity.isDisplayed()); // Kiểm tra không có cảnh báo thành phố

	    WebElement warningCountry = driver.findElement(By.cssSelector("#error-shipping-country"));
	    Assert.assertTrue("Không hiển thị warning Country", warningCountry.isDisplayed()); // Kiểm tra hiển thị cảnh báo quốc gia

	    WebElement warningShippingZone = driver.findElement(By.cssSelector("#error-shipping-zone"));
	    Assert.assertTrue("Không hiển thị warning Shipping Zone", warningShippingZone.isDisplayed()); // Kiểm tra hiển thị cảnh báo khu vực
	}

	
	@Test
	public void testGuestAccountAboveLowerBoundary() {
	    // Mục tiêu: Kiểm tra khả năng tạo tài khoản khách hàng với các thông tin vượt qua giới hạn dưới.
	    // Đảm bảo rằng:
	    // - Tên và họ có thể được nhập với độ dài tối thiểu (2 ký tự).
	    // - Email không hợp lệ sẽ hiển thị cảnh báo.
	    // - Địa chỉ, thành phố, và khu vực không bắt buộc phải có thông tin nhưng không có cảnh báo xuất hiện nếu để trống.

	    // Mở trang chính của OpenCart
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000); // Chờ 1 giây để trang tải

	    // Tìm và nhấp vào nút thêm vào giỏ hàng
	    WebElement addToCartBtn = driver.findElement(By.cssSelector(
	            "#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > form > div > button:nth-child(1)"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn); // Cuộn để nút hiển thị
	    sleep(1000); // Chờ 1 giây

	    addToCartBtn.click(); // Nhấp để thêm sản phẩm vào giỏ hàng
	    sleep(2000); // Chờ 2 giây
	    addToCartBtn.click(); // Nhấp lần nữa để thêm sản phẩm
	    sleep(5000); // Chờ 5 giây để xử lý thêm vào giỏ hàng

	    // Nhập thông tin khách hàng (đảm bảo nằm trên giới hạn dưới)
	    String firstName = "AC"; // Tên (2 ký tự)
	    String lastName = "BC"; // Họ (2 ký tự)
	    String email = "sdnkkdsfk"; // Email không hợp lệ
	    String company = "Company ABC"; // Công ty
	    String address1 = "Q.12"; // Địa chỉ 1 (vượt qua giới hạn dưới)
	    String address2 = "Quan 5"; // Địa chỉ 2
	    String city = "SG."; // Thành phố (có ký tự)
	    String postCode = "700000"; // Mã bưu điện
	    String country = " --- Please Select --- "; // Quốc gia
	    String region = "--- Please Select --- "; // Khu vực

	    // Điều hướng đến trang thanh toán
	    WebElement checkoutLink = driver.findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(5) > a"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutLink); // Cuộn để hiển thị
	    sleep(1000); // Chờ 1 giây
	    checkoutLink.click(); // Nhấp vào liên kết thanh toán

	    // Nhập thông tin vào các trường
	    WebElement inputGuest = driver.findElement(By.cssSelector("#input-guest"));
	    inputGuest.click(); // Nhấp vào ô nhập thông tin khách
	    sleep(1000); // Chờ 1 giây

	    // Nhập tên
	    WebElement inputFirstName = driver.findElement(By.cssSelector("#input-firstname"));
	    inputFirstName.sendKeys(firstName); // Nhập tên
	    sleep(1000); // Chờ 1 giây

	    // Nhập họ
	    WebElement inputLastName = driver.findElement(By.cssSelector("#input-lastname"));
	    inputLastName.sendKeys(lastName); // Nhập họ
	    sleep(1000); // Chờ 1 giây

	    // Nhập email
	    WebElement inputEmail = driver.findElement(By.cssSelector("#input-email"));
	    inputEmail.sendKeys(email); // Nhập email không hợp lệ
	    sleep(1000); // Chờ 1 giây

	    // Nhập tên công ty
	    WebElement inputCompany = driver.findElement(By.cssSelector("#input-shipping-company"));
	    inputCompany.sendKeys(company); // Nhập tên công ty
	    sleep(1000); // Chờ 1 giây

	    // Nhập địa chỉ 1
	    WebElement inputAddress1 = driver.findElement(By.cssSelector("#input-shipping-address-1"));
	    inputAddress1.sendKeys(address1); // Nhập địa chỉ 1 (vượt qua giới hạn dưới)
	    sleep(1000); // Chờ 1 giây

	    // Nhập địa chỉ 2
	    WebElement inputAddress2 = driver.findElement(By.cssSelector("#input-shipping-address-2"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputAddress2); // Cuộn để hiển thị
	    sleep(1000); // Chờ 1 giây
	    inputAddress2.sendKeys(address2); // Nhập địa chỉ 2

	    // Nhập thành phố
	    WebElement inputCity = driver.findElement(By.cssSelector("#input-shipping-city"));
	    inputCity.sendKeys(city); // Nhập thành phố
	    sleep(1000); // Chờ 1 giây

	    // Nhập mã bưu điện
	    WebElement inputPostCode = driver.findElement(By.cssSelector("#input-shipping-postcode"));
	    inputPostCode.clear(); // Xóa trường mã bưu điện
	    inputPostCode.sendKeys(postCode); // Nhập mã bưu điện
	    sleep(1000); // Chờ 1 giây

	    // Chọn quốc gia
	    WebElement inputCountry = driver.findElement(By.cssSelector("#input-shipping-country"));
	    Select selectionCountry = new Select(inputCountry);
	    selectionCountry.selectByVisibleText(country); // Chọn quốc gia từ danh sách
	    sleep(1000); // Chờ 1 giây

	    // Chọn khu vực
	    WebElement inputRegion = driver.findElement(By.cssSelector("#input-shipping-zone"));
	    Select selectionRegion = new Select(inputRegion);
	    selectionRegion.selectByVisibleText(region); // Chọn khu vực từ danh sách
	    sleep(1000); // Chờ 1 giây

	    // Nhấn nút tiếp tục để kiểm tra cảnh báo
	    WebElement continueBtn = driver.findElement(By.cssSelector("#button-register"));
	    continueBtn.click(); // Nhấp vào nút tiếp tục
	    sleep(3000); // Chờ 3 giây để xử lý

	    // Kiểm tra xem các thông báo cảnh báo có hiển thị hay không
	    // Kiểm tra các cảnh báo cho trường thông tin hợp lệ
	    WebElement warningFirstName = driver.findElement(By.cssSelector("#error-firstname"));
	    Assert.assertTrue("Không hiển thị warning First Name", !warningFirstName.isDisplayed()); // Kiểm tra không có cảnh báo tên

	    WebElement warningLastName = driver.findElement(By.cssSelector("#error-lastname"));
	    Assert.assertTrue("Không hiển thị warning Last Name", !warningLastName.isDisplayed()); // Kiểm tra không có cảnh báo họ

	    WebElement warningEmail = driver.findElement(By.cssSelector("#error-email"));
	    Assert.assertTrue("Không hiển thị warning Email", warningEmail.isDisplayed()); // Kiểm tra hiển thị cảnh báo email

	    WebElement warningAddress_1 = driver.findElement(By.cssSelector("#error-shipping-address-1"));
	    Assert.assertTrue("Không hiển thị warning Address 1", !warningAddress_1.isDisplayed()); // Kiểm tra không có cảnh báo địa chỉ 1

	    WebElement warningCity = driver.findElement(By.cssSelector("#error-shipping-city"));
	    Assert.assertTrue("Không hiển thị warning City", !warningCity.isDisplayed()); // Kiểm tra không có cảnh báo thành phố

	    WebElement warningCountry = driver.findElement(By.cssSelector("#error-shipping-country"));
	    Assert.assertTrue("Không hiển thị warning Country", warningCountry.isDisplayed()); // Kiểm tra hiển thị cảnh báo quốc gia

	    WebElement warningShippingZone = driver.findElement(By.cssSelector("#error-shipping-zone"));
	    Assert.assertTrue("Không hiển thị warning Shipping Zone", warningShippingZone.isDisplayed()); // Kiểm tra hiển thị cảnh báo khu vực
	}

	
	@Test
	public void testGuestAccountUnderLowerBoundary() {
	    // Mục tiêu: Kiểm tra khả năng tạo tài khoản khách hàng với các thông tin dưới giới hạn tối thiểu.
	    // Đảm bảo rằng:
	    // - Tên và họ không được để trống sẽ hiển thị cảnh báo.
	    // - Email không hợp lệ sẽ hiển thị cảnh báo.
	    // - Địa chỉ, thành phố, và khu vực không bắt buộc phải có thông tin nhưng sẽ hiển thị cảnh báo nếu để trống.

	    // Mở trang chính của OpenCart
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000); // Chờ 1 giây để trang tải

	    // Tìm và nhấp vào nút thêm vào giỏ hàng
	    WebElement addToCartBtn = driver.findElement(By.cssSelector(
	            "#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > form > div > button:nth-child(1)"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn); // Cuộn để nút hiển thị
	    sleep(1000); // Chờ 1 giây

	    addToCartBtn.click(); // Nhấp để thêm sản phẩm vào giỏ hàng
	    sleep(2000); // Chờ 2 giây
	    addToCartBtn.click(); // Nhấp lần nữa để thêm sản phẩm
	    sleep(5000); // Chờ 5 giây để xử lý thêm vào giỏ hàng

	    // Nhập thông tin khách hàng (dưới giới hạn tối thiểu)
	    String firstName = ""; // Tên (rỗng)
	    String lastName = ""; // Họ (rỗng)
	    String email = "sdnkkdsfk"; // Email không hợp lệ
	    String company = "Company ABC"; // Công ty
	    String address1 = "Q1"; // Địa chỉ 1 (có ký tự)
	    String address2 = "Quan 5"; // Địa chỉ 2
	    String city = "S"; // Thành phố (1 ký tự)
	    String postCode = "700000"; // Mã bưu điện
	    String country = " --- Please Select --- "; // Quốc gia
	    String region = "--- Please Select --- "; // Khu vực

	    // Điều hướng đến trang thanh toán
	    WebElement checkoutLink = driver.findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(5) > a"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutLink); // Cuộn để hiển thị
	    sleep(1000); // Chờ 1 giây
	    checkoutLink.click(); // Nhấp vào liên kết thanh toán

	    // Nhập thông tin vào các trường
	    WebElement inputGuest = driver.findElement(By.cssSelector("#input-guest"));
	    inputGuest.click(); // Nhấp vào ô nhập thông tin khách
	    sleep(1000); // Chờ 1 giây

	    // Nhập tên
	    WebElement inputFirstName = driver.findElement(By.cssSelector("#input-firstname"));
	    inputFirstName.sendKeys(firstName); // Nhập tên rỗng
	    sleep(1000); // Chờ 1 giây

	    // Nhập họ
	    WebElement inputLastName = driver.findElement(By.cssSelector("#input-lastname"));
	    inputLastName.sendKeys(lastName); // Nhập họ rỗng
	    sleep(1000); // Chờ 1 giây

	    // Nhập email
	    WebElement inputEmail = driver.findElement(By.cssSelector("#input-email"));
	    inputEmail.sendKeys(email); // Nhập email không hợp lệ
	    sleep(1000); // Chờ 1 giây

	    // Nhập tên công ty
	    WebElement inputCompany = driver.findElement(By.cssSelector("#input-shipping-company"));
	    inputCompany.sendKeys(company); // Nhập tên công ty
	    sleep(1000); // Chờ 1 giây

	    // Nhập địa chỉ 1
	    WebElement inputAddress1 = driver.findElement(By.cssSelector("#input-shipping-address-1"));
	    inputAddress1.sendKeys(address1); // Nhập địa chỉ 1
	    sleep(1000); // Chờ 1 giây

	    // Nhập địa chỉ 2
	    WebElement inputAddress2 = driver.findElement(By.cssSelector("#input-shipping-address-2"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputAddress2); // Cuộn để hiển thị
	    sleep(1000); // Chờ 1 giây
	    inputAddress2.sendKeys(address2); // Nhập địa chỉ 2

	    // Nhập thành phố
	    WebElement inputCity = driver.findElement(By.cssSelector("#input-shipping-city"));
	    inputCity.sendKeys(city); // Nhập thành phố (1 ký tự)
	    sleep(1000); // Chờ 1 giây

	    // Nhập mã bưu điện
	    WebElement inputPostCode = driver.findElement(By.cssSelector("#input-shipping-postcode"));
	    inputPostCode.clear(); // Xóa trường mã bưu điện
	    inputPostCode.sendKeys(postCode); // Nhập mã bưu điện
	    sleep(1000); // Chờ 1 giây

	    // Chọn quốc gia
	    WebElement inputCountry = driver.findElement(By.cssSelector("#input-shipping-country"));
	    Select selectionCountry = new Select(inputCountry);
	    selectionCountry.selectByVisibleText(country); // Chọn quốc gia từ danh sách
	    sleep(1000); // Chờ 1 giây

	    // Chọn khu vực
	    WebElement inputRegion = driver.findElement(By.cssSelector("#input-shipping-zone"));
	    Select selectionRegion = new Select(inputRegion);
	    selectionRegion.selectByVisibleText(region); // Chọn khu vực từ danh sách
	    sleep(1000); // Chờ 1 giây

	    // Nhấn nút tiếp tục để kiểm tra cảnh báo
	    WebElement continueBtn = driver.findElement(By.cssSelector("#button-register"));
	    continueBtn.click(); // Nhấp vào nút tiếp tục
	    sleep(3000); // Chờ 3 giây để xử lý

	    // Kiểm tra xem các thông báo cảnh báo có hiển thị hay không
	    // Kiểm tra các cảnh báo cho trường thông tin không hợp lệ
	    WebElement warningFirstName = driver.findElement(By.cssSelector("#error-firstname"));
	    Assert.assertTrue("Không hiển thị warning First Name", warningFirstName.isDisplayed()); // Kiểm tra hiển thị cảnh báo tên

	    WebElement warningLastName = driver.findElement(By.cssSelector("#error-lastname"));
	    Assert.assertTrue("Không hiển thị warning Last Name", warningLastName.isDisplayed()); // Kiểm tra hiển thị cảnh báo họ

	    WebElement warningEmail = driver.findElement(By.cssSelector("#error-email"));
	    Assert.assertTrue("Không hiển thị warning Email", warningEmail.isDisplayed()); // Kiểm tra hiển thị cảnh báo email

	    WebElement warningAddress_1 = driver.findElement(By.cssSelector("#error-shipping-address-1"));
	    Assert.assertTrue("Không hiển thị warning Address 1", warningAddress_1.isDisplayed()); // Kiểm tra hiển thị cảnh báo địa chỉ 1

	    WebElement warningCity = driver.findElement(By.cssSelector("#error-shipping-city"));
	    Assert.assertTrue("Không hiển thị warning City", warningCity.isDisplayed()); // Kiểm tra hiển thị cảnh báo thành phố

	    WebElement warningCountry = driver.findElement(By.cssSelector("#error-shipping-country"));
	    Assert.assertTrue("Không hiển thị warning Country", warningCountry.isDisplayed()); // Kiểm tra hiển thị cảnh báo quốc gia

	    WebElement warningShippingZone = driver.findElement(By.cssSelector("#error-shipping-zone"));
	    Assert.assertTrue("Không hiển thị warning Shipping Zone", warningShippingZone.isDisplayed()); // Kiểm tra hiển thị cảnh báo khu vực
	}

	
	@Test
	public void testGuestAccountInvalidMail() {
	    // Mục tiêu: Kiểm tra khả năng tạo tài khoản khách hàng với email không hợp lệ.
	    // Đảm bảo rằng:
	    // - Nếu email không hợp lệ, cảnh báo sẽ hiển thị.

	    // Mở trang chính của OpenCart
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000); // Chờ 1 giây để trang tải

	    // Tìm và nhấp vào nút thêm vào giỏ hàng
	    WebElement addToCartBtn = driver.findElement(By.cssSelector(
	            "#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > form > div > button:nth-child(1)"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn); // Cuộn để nút hiển thị
	    sleep(1000); // Chờ 1 giây

	    addToCartBtn.click(); // Nhấp để thêm sản phẩm vào giỏ hàng
	    sleep(2000); // Chờ 2 giây
	    addToCartBtn.click(); // Nhấp lần nữa để thêm sản phẩm
	    sleep(5000); // Chờ 5 giây để xử lý thêm vào giỏ hàng

	    // Điều hướng đến trang thanh toán
	    WebElement checkoutLink = driver.findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(5) > a"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutLink); // Cuộn để hiển thị
	    sleep(1000); // Chờ 1 giây
	    checkoutLink.click(); // Nhấp vào liên kết thanh toán

	    // Nhập thông tin khách hàng
	    WebElement inputGuest = driver.findElement(By.cssSelector("#input-guest"));
	    inputGuest.click(); // Nhấp vào ô nhập thông tin khách
	    sleep(1000); // Chờ 1 giây

	    String firstName = "Qui"; // Tên
	    String lastName = "Nguyen"; // Họ
	    String email = "dnfjsnfnsdnfk"; // Email không hợp lệ
	    String company = "Company ABC"; // Công ty
	    String address1 = "Quan 1"; // Địa chỉ 1
	    String address2 = "Quan 5"; // Địa chỉ 2
	    String city = "Ho Chi Minh City"; // Thành phố
	    String postCode = "700000"; // Mã bưu điện
	    String country = "Viet Nam"; // Quốc gia
	    String region = "Ho Chi Minh City"; // Khu vực

	    // Nhập tên
	    WebElement inputFirstName = driver.findElement(By.cssSelector("#input-firstname"));
	    inputFirstName.sendKeys(firstName);
	    sleep(1000); // Chờ 1 giây

	    // Nhập họ
	    WebElement inputLastName = driver.findElement(By.cssSelector("#input-lastname"));
	    inputLastName.sendKeys(lastName);
	    sleep(1000); // Chờ 1 giây

	    // Nhập email không hợp lệ
	    WebElement inputEmail = driver.findElement(By.cssSelector("#input-email"));
	    inputEmail.sendKeys(email);
	    sleep(1000); // Chờ 1 giây

	    // Nhập thông tin công ty
	    WebElement inputCompany = driver.findElement(By.cssSelector("#input-shipping-company"));
	    inputCompany.sendKeys(company);
	    sleep(1000); // Chờ 1 giây

	    // Nhập địa chỉ 1
	    WebElement inputAddress1 = driver.findElement(By.cssSelector("#input-shipping-address-1"));
	    inputAddress1.sendKeys(address1);
	    sleep(1000); // Chờ 1 giây

	    // Nhập địa chỉ 2
	    WebElement inputAddress2 = driver.findElement(By.cssSelector("#input-shipping-address-2"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputAddress2); // Cuộn để hiển thị
	    sleep(1000); // Chờ 1 giây
	    inputAddress2.sendKeys(address2); // Nhập địa chỉ 2

	    // Nhập thành phố
	    WebElement inputCity = driver.findElement(By.cssSelector("#input-shipping-city"));
	    inputCity.sendKeys(city);
	    sleep(1000); // Chờ 1 giây

	    // Nhập mã bưu điện
	    WebElement inputPostCode = driver.findElement(By.cssSelector("#input-shipping-postcode"));
	    inputPostCode.clear(); // Xóa trường mã bưu điện nếu có
	    inputPostCode.sendKeys(postCode); // Nhập mã bưu điện
	    sleep(1000); // Chờ 1 giây

	    // Chọn quốc gia
	    WebElement inputCountry = driver.findElement(By.cssSelector("#input-shipping-country"));
	    Select selectionCountry = new Select(inputCountry);
	    selectionCountry.selectByVisibleText(country); // Chọn quốc gia
	    sleep(1000); // Chờ 1 giây

	    // Chọn khu vực
	    WebElement inputRegion = driver.findElement(By.cssSelector("#input-shipping-zone"));
	    Select selectionRegion = new Select(inputRegion);
	    selectionRegion.selectByVisibleText(region); // Chọn khu vực
	    sleep(1000); // Chờ 1 giây

	    // Nhấn nút tiếp tục để kiểm tra cảnh báo
	    WebElement continueBtn = driver.findElement(By.cssSelector("#button-register"));
	    continueBtn.click(); // Nhấp vào nút tiếp tục
	    sleep(3000); // Chờ 3 giây để xử lý

	    // Kiểm tra xem cảnh báo email có hiển thị hay không
	    WebElement warningEmail = driver.findElement(By.cssSelector("#error-email"));
	    Assert.assertTrue("Không hiển thị warning Email", warningEmail.isDisplayed()); // Kiểm tra hiển thị cảnh báo email
	}

	@Test
	public void testGuestAccountNoChosePaymentandShipping() {
	    // Mục tiêu: Kiểm tra khả năng thanh toán khi chưa chọn phương thức vận chuyển và thanh toán.
	    // Đảm bảo rằng:
	    // - Nút xác nhận không hiển thị khi không chọn phương thức vận chuyển và thanh toán.

	    // Mở trang chính của OpenCart
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000); // Chờ 1 giây để trang tải

	    // Tìm và nhấp vào nút thêm vào giỏ hàng
	    WebElement addToCartBtn = driver.findElement(By.cssSelector(
	            "#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > form > div > button:nth-child(1)"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn); // Cuộn để nút hiển thị
	    sleep(1000); // Chờ 1 giây

	    addToCartBtn.click(); // Nhấp để thêm sản phẩm vào giỏ hàng
	    sleep(2000); // Chờ 2 giây
	    addToCartBtn.click(); // Nhấp lần nữa để thêm sản phẩm
	    sleep(5000); // Chờ 5 giây để xử lý thêm vào giỏ hàng

	    // Điều hướng đến trang thanh toán
	    WebElement checkoutLink = driver.findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(5) > a"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutLink); // Cuộn để hiển thị
	    sleep(1000); // Chờ 1 giây
	    checkoutLink.click(); // Nhấp vào liên kết thanh toán

	    // Nhập thông tin khách hàng
	    WebElement inputGuest = driver.findElement(By.cssSelector("#input-guest"));
	    inputGuest.click(); // Nhấp vào ô nhập thông tin khách
	    sleep(1000); // Chờ 1 giây

	    // Thông tin khách hàng
	    String firstName = "Qui"; // Tên
	    String lastName = "Nguyen"; // Họ
	    String email = "nguyenddqui@gmail.com"; // Email
	    String company = "Company ABC"; // Công ty
	    String address1 = "Quan 1"; // Địa chỉ 1
	    String address2 = "Quan 5"; // Địa chỉ 2
	    String city = "Ho Chi Minh City"; // Thành phố
	    String postCode = "700000"; // Mã bưu điện
	    String country = "Viet Nam"; // Quốc gia
	    String region = "Ho Chi Minh City"; // Khu vực

	    // Nhập dữ liệu vào các trường
	    WebElement inputFirstName = driver.findElement(By.cssSelector("#input-firstname"));
	    inputFirstName.sendKeys(firstName);
	    sleep(1000); // Chờ 1 giây

	    WebElement inputLastName = driver.findElement(By.cssSelector("#input-lastname"));
	    inputLastName.sendKeys(lastName);
	    sleep(1000); // Chờ 1 giây

	    WebElement inputEmail = driver.findElement(By.cssSelector("#input-email"));
	    inputEmail.sendKeys(email);
	    sleep(1000); // Chờ 1 giây

	    WebElement inputCompany = driver.findElement(By.cssSelector("#input-shipping-company"));
	    inputCompany.sendKeys(company);
	    sleep(1000); // Chờ 1 giây

	    WebElement inputAddress1 = driver.findElement(By.cssSelector("#input-shipping-address-1"));
	    inputAddress1.sendKeys(address1);
	    sleep(1000); // Chờ 1 giây

	    WebElement inputAddress2 = driver.findElement(By.cssSelector("#input-shipping-address-2"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputAddress2); // Cuộn để hiển thị
	    sleep(1000); // Chờ 1 giây
	    inputAddress2.sendKeys(address2); // Nhập địa chỉ 2

	    WebElement inputCity = driver.findElement(By.cssSelector("#input-shipping-city"));
	    inputCity.sendKeys(city);
	    sleep(1000); // Chờ 1 giây

	    WebElement inputPostCode = driver.findElement(By.cssSelector("#input-shipping-postcode"));
	    inputPostCode.clear(); // Xóa trường mã bưu điện nếu có
	    inputPostCode.sendKeys(postCode); // Nhập mã bưu điện
	    sleep(1000); // Chờ 1 giây

	    // Chọn quốc gia
	    WebElement inputCountry = driver.findElement(By.cssSelector("#input-shipping-country"));
	    Select selectionCountry = new Select(inputCountry);
	    selectionCountry.selectByVisibleText(country); // Chọn quốc gia
	    sleep(1000); // Chờ 1 giây

	    // Chọn khu vực
	    WebElement inputRegion = driver.findElement(By.cssSelector("#input-shipping-zone"));
	    Select selectionRegion = new Select(inputRegion);
	    selectionRegion.selectByVisibleText(region); // Chọn khu vực
	    sleep(1000); // Chờ 1 giây

	    // Nhấn nút tiếp tục mà không chọn phương thức thanh toán và vận chuyển
	    WebElement continueBtn = driver.findElement(By.cssSelector("#button-register"));
	    continueBtn.click(); // Nhấp vào nút tiếp tục
	    sleep(5000); // Chờ 5 giây để xử lý

	    // Kiểm tra xem nút xác nhận có hiển thị hay không
	    boolean isButtonPresent = driver.findElements(By.cssSelector("#button-confirm")).size() > 0;
	    Assert.assertTrue("Nút xác nhận không nên hiển thị khi chưa chọn phương thức thanh toán và vận chuyển", !isButtonPresent); // Kiểm tra nút xác nhận không hiển thị
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}

