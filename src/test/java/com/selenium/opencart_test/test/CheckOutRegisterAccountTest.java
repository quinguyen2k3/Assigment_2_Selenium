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

public class CheckOutRegisterAccountTest {
	
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
	public void testCheckoutWithRegisterAccount() {
		//Kiểm thử với tài khoản đăng ký
	    // Mở trang chính của OpenCart để bắt đầu quy trình mua hàng
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000); // Đợi một chút để trang tải hoàn toàn

	    // Tìm nút "Thêm vào giỏ hàng" của sản phẩm thứ hai và cuộn đến nó
	    WebElement addToCartBtn = driver.findElement(By.cssSelector(
	            "#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > form > div > button:nth-child(1)"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
	    sleep(1000); // Đợi để tránh lỗi khi nhấp vào

	    // Nhấp vào nút "Thêm vào giỏ hàng" để thêm sản phẩm vào giỏ
	    addToCartBtn.click();
	    sleep(2000); // Đợi để đảm bảo sản phẩm đã được thêm vào giỏ hàng

	    // Nhấp vào nút "Thêm vào giỏ hàng" lần nữa (có thể không cần thiết)
	    addToCartBtn.click();
	    sleep(5000); // Đợi để đảm bảo giỏ hàng đã cập nhật

	    // Tìm liên kết "Thanh toán" và cuộn đến nó
	    WebElement checkoutLink = driver
	            .findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(5) > a"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutLink);
	    sleep(1000); // Đợi để tránh lỗi khi nhấp vào

	    // Nhấp vào liên kết "Thanh toán" để đi đến trang đăng ký
	    checkoutLink.click();

	    // Tìm nút đăng ký tài khoản và nhấp vào nó
	    WebElement inputGuest = driver.findElement(By.cssSelector("#input-register"));
	    inputGuest.click();
	    sleep(1000); // Đợi một chút để trang tải

	    // Khai báo thông tin cần thiết cho việc đăng ký tài khoản
	    String firstName = "Qui";
	    String lastName = "Nguyen";
	    String email = "test_ck4_011@gmail.com";
	    String company = "Company ABC";
	    String address1 = "Quan 1";
	    String address2 = "Quan 5";
	    String city = "Ho Chi Minh City";
	    String postCode = "700000";
	    String country = "Viet Nam";
	    String region = "Ho Chi Minh City";
	    String password = "0931368945";

	    // Nhập thông tin vào các trường tương ứng trên trang đăng ký
	    WebElement inputFirstName = driver.findElement(By.cssSelector("#input-firstname"));
	    inputFirstName.sendKeys(firstName);
	    sleep(1000); // Đợi để đảm bảo thông tin được nhập chính xác

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
	    inputPostCode.clear(); // Xóa nếu có giá trị cũ
	    inputPostCode.sendKeys(postCode);
	    sleep(1000);

	    // Chọn quốc gia từ danh sách
	    WebElement inputCountry = driver.findElement(By.cssSelector("#input-shipping-country"));
	    Select selectionCountry = new Select(inputCountry);
	    selectionCountry.selectByVisibleText(country);
	    sleep(1000); // Đợi để đảm bảo lựa chọn đã được thực hiện

	    // Chọn vùng từ danh sách
	    WebElement inputRegion = driver.findElement(By.cssSelector("#input-shipping-zone"));
	    Select selectionRegion = new Select(inputRegion);
	    selectionRegion.selectByVisibleText(region);
	    sleep(1000); // Đợi

	    // Nhập mật khẩu
	    WebElement inputPassword = driver.findElement(By.cssSelector("#input-password"));
	    inputPassword.clear(); // Xóa nếu có giá trị cũ
	    inputPassword.sendKeys(password);
	    sleep(1000); // Đợi

	    // Đồng ý với điều khoản sử dụng và nhấp nút "Tiếp tục"
	    WebElement policy = driver.findElement(By.cssSelector("#input-register-agree"));
	    policy.click();
	    sleep(1000);

	    WebElement continueBtn = driver.findElement(By.cssSelector("#button-register"));
	    continueBtn.click();
	    sleep(5000); // Đợi để tài khoản được tạo

	    // Chọn phương thức giao hàng
	    WebElement shippingMethod = driver.findElement(By.cssSelector("#button-shipping-methods"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", shippingMethod);
	    sleep(1000);
	    shippingMethod.click();
	    sleep(1000);

	    // Chọn phương thức giao hàng cụ thể
	    WebElement methodFlat = driver.findElement(By.cssSelector("#input-shipping-method-flat-flat"));
	    methodFlat.click();
	    sleep(1000);

	    // Nhấp "Tiếp tục" để xác nhận phương thức giao hàng
	    WebElement continue_1 = driver.findElement(By.cssSelector("#button-shipping-method"));
	    continue_1.click();
	    sleep(1000);

	    // Chọn phương thức thanh toán
	    WebElement paymentMethod = driver.findElement(By.cssSelector("#button-payment-methods"));
	    paymentMethod.click();
	    sleep(1000);

	    // Chọn phương thức thanh toán cụ thể (COD)
	    WebElement cashMethod = driver.findElement(By.cssSelector("#input-payment-method-cod-cod"));
	    cashMethod.click();
	    sleep(1000);

	    // Nhấp "Tiếp tục" để xác nhận phương thức thanh toán
	    WebElement continue_2 = driver.findElement(By.cssSelector("#button-payment-method"));
	    continue_2.click();
	    sleep(1000);

	    // Xác nhận đơn hàng
	    WebElement confirmOrder = driver.findElement(By.cssSelector("#button-confirm"));
	    confirmOrder.click();
	    sleep(1000);

	    // Kiểm tra thông báo xác nhận đơn hàng
	    WebElement notification = driver.findElement(By.cssSelector("#content > h1"));
	    String notificationActual = notification.getText();

	    // Thông báo mong đợi
	    String notificationExpected = "Your order has been placed!";

	    // Kiểm tra xem thông báo xác nhận đơn hàng có đúng không
	    Assert.assertEquals("Đơn hàng không được đặt thành công", notificationExpected, notificationActual);
	}

	@Test
	public void testRegisterAccountNoChosePaymentandShipping() {
		//Kiểm thử với tài khoản đăng ký không chọn Payment và Shipping Method
	    // Mở trang chính của OpenCart để bắt đầu quy trình mua hàng
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000); // Đợi một chút để trang tải hoàn toàn

	    // Tìm nút "Thêm vào giỏ hàng" của sản phẩm thứ hai và cuộn đến nó
	    WebElement addToCartBtn = driver.findElement(By.cssSelector(
	            "#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > form > div > button:nth-child(1)"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
	    sleep(1000); // Đợi để tránh lỗi khi nhấp vào

	    // Nhấp vào nút "Thêm vào giỏ hàng" để thêm sản phẩm vào giỏ
	    addToCartBtn.click();
	    sleep(2000); // Đợi để đảm bảo sản phẩm đã được thêm vào giỏ hàng

	    // Nhấp vào nút "Thêm vào giỏ hàng" lần nữa (có thể không cần thiết)
	    addToCartBtn.click();
	    sleep(5000); // Đợi để đảm bảo giỏ hàng đã cập nhật

	    // Tìm liên kết "Thanh toán" và cuộn đến nó
	    WebElement checkoutLink = driver
	            .findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(5) > a"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutLink);
	    sleep(1000); // Đợi để tránh lỗi khi nhấp vào

	    // Nhấp vào liên kết "Thanh toán" để đi đến trang đăng ký
	    checkoutLink.click();

	    // Tìm nút đăng ký tài khoản và nhấp vào nó
	    WebElement inputGuest = driver.findElement(By.cssSelector("#input-register"));
	    inputGuest.click();
	    sleep(1000); // Đợi một chút để trang tải

	    // Nhập thông tin cá nhân cần thiết để đăng ký tài khoản
	    WebElement inputFirstName = driver.findElement(By.cssSelector("#input-firstname"));
	    inputFirstName.sendKeys("Qui");
	    sleep(1000); // Đợi để đảm bảo thông tin được nhập chính xác

	    WebElement inputLastName = driver.findElement(By.cssSelector("#input-lastname"));
	    inputLastName.sendKeys("Nguyen");
	    sleep(1000);

	    WebElement inputEmail = driver.findElement(By.cssSelector("#input-email"));
	    inputEmail.sendKeys("test1@gmail.com");
	    sleep(1000);

	    WebElement inputCompany = driver.findElement(By.cssSelector("#input-shipping-company"));
	    inputCompany.sendKeys("Company ABC");
	    sleep(1000);

	    WebElement inputAdress1 = driver.findElement(By.cssSelector("#input-shipping-address-1"));
	    inputAdress1.sendKeys("Quan 1");
	    sleep(1000);

	    WebElement inputAdress2 = driver.findElement(By.cssSelector("#input-shipping-address-2"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputAdress2);
	    sleep(1000);
	    inputAdress2.sendKeys("Quan 5");

	    WebElement inputCity = driver.findElement(By.cssSelector("#input-shipping-city"));
	    inputCity.sendKeys("Ho Chi Minh City");
	    sleep(1000);

	    WebElement inputPostCost = driver.findElement(By.cssSelector("#input-shipping-postcode"));
	    inputPostCost.clear(); // Xóa nếu có giá trị cũ
	    inputPostCost.sendKeys("700000");
	    sleep(1000);

	    // Chọn quốc gia từ danh sách
	    WebElement inputCountry = driver.findElement(By.cssSelector("#input-shipping-country"));
	    Select selectionCountry = new Select(inputCountry);
	    selectionCountry.selectByVisibleText("Viet Nam");
	    sleep(1000); // Đợi để đảm bảo lựa chọn đã được thực hiện

	    // Chọn vùng từ danh sách
	    WebElement inputRegion = driver.findElement(By.cssSelector("#input-shipping-zone"));
	    Select selectionRegion = new Select(inputRegion);
	    selectionRegion.selectByVisibleText("Ho Chi Minh City");
	    sleep(1000); // Đợi

	    // Nhập mật khẩu
	    WebElement inputPassword = driver.findElement(By.cssSelector("#input-password"));
	    inputPassword.clear(); // Xóa nếu có giá trị cũ
	    inputPassword.sendKeys("0931368945");
	    sleep(1000); // Đợi

	    // Đồng ý với điều khoản sử dụng và nhấp nút "Tiếp tục"
	    WebElement policy = driver.findElement(By.cssSelector("#input-register-agree"));
	    policy.click();
	    sleep(1000);

	    // Nhấp vào nút "Đăng ký" để hoàn thành quy trình đăng ký
	    WebElement continueBtn = driver.findElement(By.cssSelector("#button-register"));
	    continueBtn.click();
	    sleep(5000); // Đợi để tài khoản được tạo

	    // Kiểm tra xem nút xác nhận có còn khả dụng hay không
	    boolean isButtonPresent = driver.findElements(By.cssSelector("#button-confirm")).size() > 0;

	    // Xác nhận rằng nút xác nhận không nên xuất hiện nếu chưa chọn phương thức giao hàng và thanh toán
	    Assert.assertTrue("Confirm button vẫn có thể sử dụng", !isButtonPresent);
	}

	@Test
	public void testRegisterAccountAboveUpperBoundary() {
		//Kiểm thử tài khoản đăng ký với input trên biên trên.
	    // Mở trang chính của OpenCart
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000); // Đợi một chút để trang tải hoàn toàn

	    // Tìm nút "Thêm vào giỏ hàng" của sản phẩm thứ hai và cuộn đến nó
	    WebElement addToCartBtn = driver.findElement(By.cssSelector(
	            "#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > form > div > button:nth-child(1)"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
	    sleep(1000); // Đợi để tránh lỗi khi nhấp vào

	    // Nhấp vào nút "Thêm vào giỏ hàng" để thêm sản phẩm vào giỏ
	    addToCartBtn.click();
	    sleep(2000); // Đợi để đảm bảo sản phẩm đã được thêm vào giỏ hàng

	    // Khai báo các thông tin cần nhập với dữ liệu vượt quá giới hạn cho phép
	    String firstName = "AlexandriaCatherineElizabethMarieAnn"; // Tên dài
	    String lastName = "MontgomeryWilliamsonMacAllisterBrown"; // Họ dài
	    String email = "sdnkkdsfk"; // Email không hợp lệ
	    String company = "Company ABC"; 
	    String address1 = "234 Elm Street, Apartment 56B, Greenfield, Ho Chi Minh City, Vietnam, 700000, Near Central Park, District 1"; // Địa chỉ dài
	    String address2 = "Quan 5"; 
	    String city = "Ho Chi Minh City, a bustling metropolis in southern Vietnam known for its vibrant culture, delicious street food, and historical landmarks"; // Tên thành phố dài
	    String postCode = "700000"; 
	    String country = " --- Please Select --- "; // Quốc gia chưa được chọn
	    String region = "--- Please Select --- "; // Khu vực chưa được chọn
	    String password = "ThisIsAStrongPassw0rd!"; // Mật khẩu hợp lệ nhưng không liên quan đến giới hạn

	    // Nhấp vào liên kết "Thanh toán" để đi đến trang đăng ký
	    WebElement checkoutLink = driver.findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(5) > a"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutLink);
	    sleep(5000); // Đợi

	    checkoutLink.click(); // Nhấp vào liên kết "Thanh toán"

	    // Tìm nút đăng ký tài khoản và nhấp vào nó
	    WebElement inputGuest = driver.findElement(By.cssSelector("#input-register"));
	    inputGuest.click();
	    sleep(1000); // Đợi để trang tải

	    // Nhập thông tin cá nhân
	    WebElement inputFirstName = driver.findElement(By.cssSelector("#input-firstname"));
	    inputFirstName.sendKeys(firstName); // Nhập tên
	    sleep(1000);

	    WebElement inputLastName = driver.findElement(By.cssSelector("#input-lastname"));
	    inputLastName.sendKeys(lastName); // Nhập họ
	    sleep(1000);

	    WebElement inputEmail = driver.findElement(By.cssSelector("#input-email"));
	    inputEmail.sendKeys(email); // Nhập email không hợp lệ
	    sleep(1000);

	    WebElement inputCompany = driver.findElement(By.cssSelector("#input-shipping-company"));
	    inputCompany.sendKeys(company); // Nhập tên công ty
	    sleep(1000);

	    WebElement inputAddress1 = driver.findElement(By.cssSelector("#input-shipping-address-1"));
	    inputAddress1.sendKeys(address1); // Nhập địa chỉ dài
	    sleep(1000);

	    WebElement inputAddress2 = driver.findElement(By.cssSelector("#input-shipping-address-2"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputAddress2);
	    sleep(1000);
	    inputAddress2.sendKeys(address2); // Nhập địa chỉ thứ hai

	    WebElement inputCity = driver.findElement(By.cssSelector("#input-shipping-city"));
	    inputCity.sendKeys(city); // Nhập tên thành phố dài
	    sleep(1000);

	    WebElement inputPostCode = driver.findElement(By.cssSelector("#input-shipping-postcode"));
	    inputPostCode.clear(); // Xóa nếu có giá trị cũ
	    inputPostCode.sendKeys(postCode); // Nhập mã bưu điện
	    sleep(1000);

	    // Chọn quốc gia từ danh sách
	    WebElement inputCountry = driver.findElement(By.cssSelector("#input-shipping-country"));
	    Select selectionCountry = new Select(inputCountry);
	    selectionCountry.selectByVisibleText(country); // Chọn quốc gia chưa xác định
	    sleep(1000);

	    // Chọn khu vực từ danh sách
	    WebElement inputRegion = driver.findElement(By.cssSelector("#input-shipping-zone"));
	    Select selectionRegion = new Select(inputRegion);
	    selectionRegion.selectByVisibleText(region); // Chọn khu vực chưa xác định
	    sleep(1000);
	    
	    // Nhập mật khẩu
	    WebElement inputPassword = driver.findElement(By.cssSelector("#input-password"));
	    inputPassword.clear(); // Xóa nếu có giá trị cũ
	    inputPassword.sendKeys(password); // Nhập mật khẩu
	    sleep(1000);

	    // Đồng ý với điều khoản sử dụng
	    WebElement policy = driver.findElement(By.cssSelector("#input-register-agree"));
	    policy.click();
	    sleep(1000);

	    // Nhấp vào nút "Đăng ký" để hoàn thành quy trình đăng ký
	    WebElement continueBtn = driver.findElement(By.cssSelector("#button-register"));
	    continueBtn.click();
	    sleep(3000); // Đợi để tài khoản được tạo

	    // Kiểm tra xem có các thông báo lỗi xuất hiện hay không
	    WebElement warningFirstName = driver.findElement(By.cssSelector("#error-firstname"));
	    Assert.assertTrue("Không hiển thị warning First Name", warningFirstName.isDisplayed()); // Kiểm tra cảnh báo tên

	    WebElement warningLastName = driver.findElement(By.cssSelector("#error-lastname"));
	    Assert.assertTrue("Không hiển thị warning Last Name", warningLastName.isDisplayed()); // Kiểm tra cảnh báo họ

	    WebElement warningEmail = driver.findElement(By.cssSelector("#error-email"));
	    Assert.assertTrue("Không hiển thị warning Email", warningEmail.isDisplayed()); // Kiểm tra cảnh báo email

	    WebElement warningAddress_1 = driver.findElement(By.cssSelector("#error-shipping-address-1"));
	    Assert.assertTrue("Không hiển thị warning Address 1", warningAddress_1.isDisplayed()); // Kiểm tra cảnh báo địa chỉ 1

	    WebElement warningCity = driver.findElement(By.cssSelector("#error-shipping-city"));
	    Assert.assertTrue("Không hiển thị warning City", warningCity.isDisplayed()); // Kiểm tra cảnh báo thành phố

	    WebElement warningCountry = driver.findElement(By.cssSelector("#error-shipping-country"));
	    Assert.assertTrue("Không hiển thị warning Country", warningCountry.isDisplayed()); // Kiểm tra cảnh báo quốc gia

	    WebElement warningShippingZone = driver.findElement(By.cssSelector("#error-shipping-zone"));
	    Assert.assertTrue("Không hiển thị warning Shipping Zone", warningShippingZone.isDisplayed()); // Kiểm tra cảnh báo khu vực giao hàng
	    
	    WebElement warningPassword = driver.findElement(By.cssSelector("#error-password"));
	    Assert.assertTrue("Không hiển thị warning Password", warningPassword.isDisplayed()); // Kiểm tra cảnh báo mật khẩu
	}

	
	@Test
	public void testRegisterAccountUpperBoundary() {
		//Kiểm thử thanh toán với tài khoản đăng ký với input nhập liệu độ dài ở giới hạn
	    // Mở trang chủ của website OpenCart
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000); // Đợi 1 giây để trang tải hoàn tất

	    // Tìm và cuộn đến nút "Thêm vào giỏ hàng" cho sản phẩm
	    WebElement addToCartBtn = driver.findElement(By.cssSelector(
	            "#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > form > div > button:nth-child(1)"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
	    sleep(1000); // Đợi 1 giây

	    // Nhấp vào nút "Thêm vào giỏ hàng" hai lần
	    addToCartBtn.click();
	    sleep(2000); // Đợi 2 giây
	    addToCartBtn.click();
	    sleep(5000); // Đợi 5 giây

	    // Khởi tạo thông tin người dùng với các giá trị lớn
	    String firstName = "TranThiKimHoaNguyen"; // Tên
	    String lastName = "NguyenVanThanhBinh"; // Họ
	    String email = "sdnkkdsfk"; // Email không hợp lệ
	    String company = "Company ABC"; // Tên công ty
	    String address1 = "1234 Nguyen Thi Minh Khai Street, District 3, Ho Chi Minh City, Vietnam, 700000, located near the famous Ben Thanh Market."; // Địa chỉ 1
	    String address2 = "Quan 5"; // Địa chỉ 2
	    String city = "Ho Chi Minh City, a vibrant metropolis known for its rich culture, delicious street food, and historical landmarks."; // Thành phố
	    String postCode = "700000"; // Mã bưu điện
	    String country = " --- Please Select --- "; // Quốc gia
	    String region = "--- Please Select --- "; // Khu vực
	    String password = "StrongPassword123456!"; // Mật khẩu mạnh

	    // Tìm và nhấp vào liên kết thanh toán
	    WebElement checkoutLink = driver.findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(5) > a"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutLink);
	    sleep(1000);
	    checkoutLink.click(); // Nhấp vào liên kết thanh toán

	    // Nhấp vào ô đăng ký cho khách hàng
	    WebElement inputGuest = driver.findElement(By.cssSelector("#input-register"));
	    inputGuest.click();
	    sleep(1000);

	    // Nhập thông tin người dùng vào các trường tương ứng
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

	    // Chọn quốc gia và khu vực
	    WebElement inputCountry = driver.findElement(By.cssSelector("#input-shipping-country"));
	    Select selectionCountry = new Select(inputCountry);
	    selectionCountry.selectByVisibleText(country);
	    sleep(1000);

	    WebElement inputRegion = driver.findElement(By.cssSelector("#input-shipping-zone"));
	    Select selectionRegion = new Select(inputRegion);
	    selectionRegion.selectByVisibleText(region);
	    sleep(1000);

	    // Nhập mật khẩu
	    WebElement inputPassword = driver.findElement(By.cssSelector("#input-password"));
	    inputPassword.clear();
	    inputPassword.sendKeys(password);
	    sleep(1000);

	    // Đồng ý với chính sách
	    WebElement policy = driver.findElement(By.cssSelector("#input-register-agree"));
	    policy.click();
	    sleep(1000);

	    // Nhấn nút tiếp tục
	    WebElement continueBtn = driver.findElement(By.cssSelector("#button-register"));
	    continueBtn.click();
	    sleep(3000); // Đợi 3 giây

	    // Kiểm tra các cảnh báo cho các trường đầu vào
	    WebElement warningFirstName = driver.findElement(By.cssSelector("#error-firstname"));
	    Assert.assertTrue("Không hiển thị warning First Name", !warningFirstName.isDisplayed()); // Kiểm tra không có cảnh báo tên

	    WebElement warningLastName = driver.findElement(By.cssSelector("#error-lastname"));
	    Assert.assertTrue("Không hiển thị warning Last Name", !warningLastName.isDisplayed()); // Kiểm tra không có cảnh báo họ

	    WebElement warningEmail = driver.findElement(By.cssSelector("#error-email"));
	    Assert.assertTrue("Không hiển thị warning Email", warningEmail.isDisplayed()); // Kiểm tra có cảnh báo email

	    WebElement warningAddress_1 = driver.findElement(By.cssSelector("#error-shipping-address-1"));
	    Assert.assertTrue("Không hiển thị warning Address 1", !warningAddress_1.isDisplayed()); // Kiểm tra không có cảnh báo địa chỉ 1

	    WebElement warningCity = driver.findElement(By.cssSelector("#error-shipping-city"));
	    Assert.assertTrue("Không hiển thị warning City", !warningCity.isDisplayed()); // Kiểm tra không có cảnh báo thành phố

	    WebElement warningCoutry = driver.findElement(By.cssSelector("#error-shipping-country"));
	    Assert.assertTrue("Không hiển thị warning Country", warningCoutry.isDisplayed()); // Kiểm tra có cảnh báo quốc gia

	    WebElement warningShippingZone = driver.findElement(By.cssSelector("#error-shipping-zone"));
	    Assert.assertTrue("Không hiển thị warning Shipping Zone", warningShippingZone.isDisplayed()); // Kiểm tra có cảnh báo khu vực

	    WebElement warningPassword = driver.findElement(By.cssSelector("#error-password"));
	    Assert.assertTrue("Không hiển thị warning Password", !warningPassword.isDisplayed()); // Kiểm tra không có cảnh báo mật khẩu
	}

	
	@Test
	public void testRegisterAccountLowerBoundary() {
		//Kiểm tra chức năng đăng ký tài khoản với các thông tin ở giới hạn tối thiểu cho phép
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

	    String firstName = "A"; // Tên ngắn nhất
	    String lastName = "B"; // Họ ngắn nhất
	    String email = "sdnkkdsfk"; // Email không hợp lệ
	    String company = "Company ABC";
	    String address1 = "Q.1"; // Địa chỉ ngắn nhất
	    String address2 = "Quan 5";
	    String city = "SG"; // Tên thành phố ngắn nhất
	    String postCode = "700000";
	    String country = " --- Please Select --- ";
	    String region = "--- Please Select --- ";
	    String password = "1234"; // Mật khẩu ngắn

	    WebElement checkoutLink = driver.findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(5) > a"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutLink);
	    sleep(1000);
	    checkoutLink.click();

	    WebElement inputGuest = driver.findElement(By.cssSelector("#input-register"));
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

	    WebElement inputCountry = driver.findElement(By.cssSelector("#input-shipping-country"));
	    Select selectionCountry = new Select(inputCountry);
	    selectionCountry.selectByVisibleText(country);
	    sleep(1000);

	    WebElement inputRegion = driver.findElement(By.cssSelector("#input-shipping-zone"));
	    Select selectionRegion = new Select(inputRegion);
	    selectionRegion.selectByVisibleText(region);
	    sleep(1000);
	    
	    WebElement inputPassword = driver.findElement(By.cssSelector("#input-password"));
	    inputPassword.clear();
	    inputPassword.sendKeys(password);
	    sleep(1000);

	    WebElement policy = driver.findElement(By.cssSelector("#input-register-agree"));
	    policy.click();
	    sleep(1000);

	    WebElement continueBtn = driver.findElement(By.cssSelector("#button-register"));
	    continueBtn.click();
	    sleep(3000);

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
	    
	    WebElement warningPassword = driver.findElement(By.cssSelector("#error-password"));
	    Assert.assertTrue("Không hiển thị warning Password", !warningPassword.isDisplayed());
	}

	
	@Test
	public void testRegisterAccountUnderLowerBoundary() {
		//Kiểm thử thanh toán khi người dùng nhập liệu các thông tin có độ dài dưới của giới han dưới
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

		String firstName = "";
		String lastName = "";
		String email = "sdnkkdsfk";
		String company = "Company ABC";
		String address1 = "Q1";
		String address2 = "Quan 5";
		String city = "S";
		String postCode = "700000";
		String country = " --- Please Select --- ";
		String region = "--- Please Select --- ";
		String password = "123"; 

		WebElement checkoutLink = driver.findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(5) > a"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutLink);
		sleep(1000);
		checkoutLink.click();

		WebElement inputGuest = driver.findElement(By.cssSelector("#input-register"));
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

		WebElement inputCountry = driver.findElement(By.cssSelector("#input-shipping-country"));
		Select selectionCountry = new Select(inputCountry);
		selectionCountry.selectByVisibleText(country);
		sleep(1000);

		WebElement inputRegion = driver.findElement(By.cssSelector("#input-shipping-zone"));
		Select selectionRegion = new Select(inputRegion);
		selectionRegion.selectByVisibleText(region);
		sleep(1000);
		
		WebElement inputPassword = driver.findElement(By.cssSelector("#input-password"));
		inputPassword.clear();
		inputPassword.sendKeys(password);
		sleep(1000);

		WebElement policy = driver.findElement(By.cssSelector("#input-register-agree"));
		policy.click();
		sleep(1000);

		WebElement continueBtn = driver.findElement(By.cssSelector("#button-register"));
		continueBtn.click();
		sleep(3000);

		WebElement warningFirstName = driver.findElement(By.cssSelector("#error-firstname"));
		Assert.assertTrue("Không hiển thị waring First Name", warningFirstName.isDisplayed());

		WebElement warningLastName = driver.findElement(By.cssSelector("#error-lastname"));
		Assert.assertTrue("Không hiển thị waring Last Name", warningLastName.isDisplayed());

		WebElement warningEmail = driver.findElement(By.cssSelector("#error-email"));
		Assert.assertTrue("Không hiển thị warning Email", warningEmail.isDisplayed());

		WebElement warningAddress_1 = driver.findElement(By.cssSelector("#error-shipping-address-1"));
		Assert.assertTrue("Không hiển thị warning Address 1", warningAddress_1.isDisplayed());

		WebElement warningCity = driver.findElement(By.cssSelector("#error-shipping-city"));
		Assert.assertTrue("Không hiển thị warning City", warningCity.isDisplayed());

		WebElement warningCoutry = driver.findElement(By.cssSelector("#error-shipping-country"));
		Assert.assertTrue("Không hiển thi warning Country", warningCoutry.isDisplayed());

		WebElement warningShippingZone = driver.findElement(By.cssSelector("#error-shipping-zone"));
		Assert.assertTrue("Không hiển thi warning Shipping Zone", warningShippingZone.isDisplayed());
		
		WebElement warningPassword = driver.findElement(By.cssSelector("#error-password"));
		Assert.assertTrue("Không hiển thi warning Password", warningPassword.isDisplayed());
	}
	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
