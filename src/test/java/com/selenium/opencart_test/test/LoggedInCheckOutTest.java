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

public class LoggedInCheckOutTest{
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.edge.driver", "D:\\Kiem_thu_phan_mem\\edgedriver_win64\\msedgedriver.exe");

		driver = new EdgeDriver();
		String email = "test_login@gmail.com";
		String password = "123456789";
		
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
	public void testCheckoutValidInfor() {
		// Mục đích của hàm: Kiểm tra chức năng thanh toán với thông tin hợp lệ
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000);
	    
	    WebElement amountProduct = driver.findElement(By.cssSelector("#header-cart > div > button"));
	    String numberItem = amountProduct.getText();
	    String zeroItem = "0 item(s)";
	    sleep(2000);
	    if (numberItem.contains(zeroItem)) {
	    	
	    	WebElement addToCartButton = driver.findElement(By.cssSelector(
		            "#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > form > div > button:nth-child(1)"));

		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton);
		    sleep(1000); 
	  
		    addToCartButton.click();
		    sleep(2000); 
	    }

	    WebElement checkoutLink = driver.findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(5) > a"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutLink);
	    sleep(1000);
	    checkoutLink.click();
	    
	    sleep(1000);
	    WebElement shippingNew = driver.findElement(By.cssSelector("#input-shipping-new"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", shippingNew);
	    shippingNew.click();
	    sleep(1000);

	    String firstName = "Qui";
	    String lastName = "Nguyen";
	    String company = "Company ABC";
	    String address1 = "Quan 1";
	    String address2 = "Quan 5";
	    String city = "Ho Chi Minh City";
	    String postCode = "700000";
	    String country = "Viet Nam";
	    String region = "Ho Chi Minh City";

	    WebElement inputFirstName = driver.findElement(By.cssSelector("#input-shipping-firstname"));
	    inputFirstName.sendKeys(firstName);
	    sleep(1000);

	    WebElement inputLastName = driver.findElement(By.cssSelector("#input-shipping-lastname"));
	    inputLastName.sendKeys(lastName);
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

	    WebElement continueBtn = driver.findElement(By.cssSelector("#button-shipping-address"));
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

	
	@Test
	public void testCheckoutNoChooseMethods() {
		// Mục đích của hàm: Kiểm tra trường hợp người dùng không chọn phương thức giao hàng và thanh toán
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000);
	    
	    WebElement amountProduct = driver.findElement(By.cssSelector("#header-cart > div > button"));
	    String numberItem = amountProduct.getText();
	    String zeroItem = "0 item(s)";
	    if (numberItem.contains(zeroItem)) {
	        WebElement addToCartBtn = driver.findElement(By.cssSelector(
	                "#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > form > div > button:nth-child(1)"));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
	        sleep(1000);
	        
	        addToCartBtn.click();
	        sleep(2000);

	        addToCartBtn.click();
	        sleep(5000);
	    }

	    WebElement checkoutLink = driver.findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(5) > a"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutLink);
	    sleep(1000);
	    checkoutLink.click();
	    
	    sleep(1000);
	    WebElement shippingNew = driver.findElement(By.cssSelector("#input-shipping-new"));
	    shippingNew.click();
	    sleep(1000);

	    String firstName = "Qui";
	    String lastName = "Nguyen";
	    String company = "Company ABC";
	    String address1 = "Quan 1";
	    String address2 = "Quan 5";
	    String city = "Ho Chi Minh City";
	    String postCode = "700000";
	    String country = "Viet Nam";
	    String region = "Ho Chi Minh City";

	    WebElement inputFirstName = driver.findElement(By.cssSelector("#input-shipping-firstname"));
	    inputFirstName.sendKeys(firstName);
	    sleep(1000);

	    WebElement inputLastName = driver.findElement(By.cssSelector("#input-shipping-lastname"));
	    inputLastName.sendKeys(lastName);
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

	    WebElement continueBtn = driver.findElement(By.cssSelector("#button-shipping-address"));
	    continueBtn.click();
	    sleep(5000);

	    // Kiểm tra xem nút xác nhận có hiển thị hay không
	    boolean isButtonPresent = driver.findElements(By.cssSelector("#button-confirm")).size() > 0;

	    Assert.assertTrue("Confirm button vẫn có thể sử dụng", !isButtonPresent);
	}

	
	@Test
	public void testCheckoutEmptyInput() {
		// Mục đích của hàm: Kiểm tra trường hợp người dùng để trống tất cả các thông tin trong quá trình đặt hàng
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000);
	    
	    WebElement amountProduct = driver.findElement(By.cssSelector("#header-cart > div > button"));
	    String numberItem = amountProduct.getText();
	    String zeroItem = "0 item(s)";
	    if (numberItem.contains(zeroItem)) {
	        WebElement addToCartBtn = driver.findElement(By.cssSelector(
	                "#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > form > div > button:nth-child(1)"));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
	        sleep(1000);
	        
	        addToCartBtn.click();
	        sleep(2000);

	        addToCartBtn.click();
	        sleep(5000);
	    }

	    WebElement checkoutLink = driver.findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(5) > a"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutLink);
	    sleep(1000);
	    checkoutLink.click();
	    
	    sleep(1000);
	    WebElement shippingNew = driver.findElement(By.cssSelector("#input-shipping-new"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", shippingNew);
	    sleep(1000);
	    shippingNew.click();
	    sleep(1000);

	    // Để trống tất cả các trường thông tin
	    String firstName = "";
	    String lastName = "";
	    String company = "";
	    String address1 = "";
	    String address2 = "";
	    String city = "";
	    String postCode = "";
	    String country = " --- Please Select --- ";
	    String region = "--- Please Select --- ";

	    WebElement inputFirstName = driver.findElement(By.cssSelector("#input-shipping-firstname"));
	    inputFirstName.sendKeys(firstName);
	    sleep(1000);

	    WebElement inputLastName = driver.findElement(By.cssSelector("#input-shipping-lastname"));
	    inputLastName.sendKeys(lastName);
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

	    WebElement continueBtn = driver.findElement(By.cssSelector("#button-shipping-address"));
	    continueBtn.click();
	    sleep(5000);

	    // Kiểm tra các thông báo lỗi hiển thị đúng
	    WebElement warningFirstName = driver.findElement(By.cssSelector("#error-shipping-firstname"));
	    Assert.assertTrue("Không hiển thị warning First Name", warningFirstName.isDisplayed());

	    WebElement warningLastName = driver.findElement(By.cssSelector("#error-shipping-lastname"));
	    Assert.assertTrue("Không hiển thị warning Last Name", warningLastName.isDisplayed());

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
	public void testAboveUpperBoundary() {
		// Mục đích của hàm: Kiểm tra trường hợp người dùng nhập thông tin vượt quá giới hạn cho phép trong quá trình đặt hàng
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000);
	    
	    WebElement amountProduct = driver.findElement(By.cssSelector("#header-cart > div > button"));
	    String numberItem = amountProduct.getText();
	    String zeroItem = "0 item(s)";
	    if (numberItem.contains(zeroItem)) {
	        WebElement addToCartBtn = driver.findElement(By.cssSelector(
	                "#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > form > div > button:nth-child(1)"));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
	        sleep(1000);
	        
	        addToCartBtn.click();
	        sleep(2000);

	        addToCartBtn.click();
	        sleep(5000);
	    }

	    WebElement checkoutLink = driver.findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(5) > a"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutLink);
	    sleep(1000);
	    checkoutLink.click();
	    
	    sleep(1000);
	    WebElement shippingNew = driver.findElement(By.cssSelector("#input-shipping-new"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", shippingNew);
	    sleep(1000);
	    shippingNew.click();
	    sleep(1000);

	    // Nhập thông tin vượt quá giới hạn cho phép
	    String firstName = "AlexandriaCatherineElizabethMarieAnn"; // Giới hạn tối đa cho First Name
	    String lastName = "MontgomeryWilliamsonMacAllisterBrown"; // Giới hạn tối đa cho Last Name
	    String company = "Company ABC"; // Thông tin công ty
	    String address1 = "234 Elm Street, Apartment 56B, Greenfield, Ho Chi Minh City, Vietnam, 700000, Near Central Park, District 1"; // Địa chỉ 1
	    String address2 = "Quan 5"; // Địa chỉ 2
	    String city = "Ho Chi Minh City, a bustling metropolis in southern Vietnam known for its vibrant culture, delicious street food, and historical landmarks"; // Thành phố
	    String postCode = "700000"; // Mã bưu chính
	    String country = " --- Please Select --- "; // Quốc gia
	    String region = "--- Please Select --- "; // Khu vực

	    WebElement inputFirstName = driver.findElement(By.cssSelector("#input-shipping-firstname"));
	    inputFirstName.sendKeys(firstName);
	    sleep(1000);

	    WebElement inputLastName = driver.findElement(By.cssSelector("#input-shipping-lastname"));
	    inputLastName.sendKeys(lastName);
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

	    WebElement continueBtn = driver.findElement(By.cssSelector("#button-shipping-address"));
	    continueBtn.click();
	    sleep(5000);

	    // Kiểm tra các thông báo lỗi hiển thị đúng
	    WebElement warningFirstName = driver.findElement(By.cssSelector("#error-shipping-firstname"));
	    Assert.assertTrue("Không hiển thị warning First Name", warningFirstName.isDisplayed());

	    WebElement warningLastName = driver.findElement(By.cssSelector("#error-shipping-lastname"));
	    Assert.assertTrue("Không hiển thị warning Last Name", warningLastName.isDisplayed());

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
	public void testUnderLowerBoundary() {
		// Mục đích của hàm: Kiểm tra trường hợp người dùng không nhập thông tin cần thiết (dưới giới hạn tối thiểu) trong quá trình đặt hàng
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000);
	    
	    WebElement amountProduct = driver.findElement(By.cssSelector("#header-cart > div > button"));
	    String numberItem = amountProduct.getText();
	    String zeroItem = "0 item(s)";
	    if (numberItem.contains(zeroItem)) {
	        WebElement addToCartBtn = driver.findElement(By.cssSelector(
	                "#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > form > div > button:nth-child(1)"));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
	        sleep(1000);
	        
	        addToCartBtn.click();
	        sleep(2000);

	        addToCartBtn.click();
	        sleep(5000);
	    }

	    WebElement checkoutLink = driver.findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(5) > a"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutLink);
	    sleep(1000);
	    checkoutLink.click();
	    
	    sleep(1000);
	    WebElement shippingNew = driver.findElement(By.cssSelector("#input-shipping-new"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", shippingNew);
	    sleep(1000);
	    
	    shippingNew.click();
	    sleep(1000);
	    
	    // Nhập thông tin dưới giới hạn tối thiểu
	    String firstName = ""; // Không nhập tên
	    String lastName = ""; // Không nhập họ
	    String company = "Company ABC";
	    String address1 = "Q1"; // Địa chỉ 1 quá ngắn
	    String address2 = "Quan 5"; // Địa chỉ 2
	    String city = "S"; // Tên thành phố quá ngắn
	    String postCode = "700000"; // Mã bưu chính
	    String country = " --- Please Select --- "; // Quốc gia
	    String region = "--- Please Select --- "; // Khu vực

	    WebElement inputFirstName = driver.findElement(By.cssSelector("#input-shipping-firstname"));
	    inputFirstName.sendKeys(firstName);
	    sleep(1000);

	    WebElement inputLastName = driver.findElement(By.cssSelector("#input-shipping-lastname"));
	    inputLastName.sendKeys(lastName);
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

	    WebElement continueBtn = driver.findElement(By.cssSelector("#button-shipping-address"));
	    continueBtn.click();
	    sleep(5000);

	    // Kiểm tra các thông báo lỗi hiển thị đúng
	    WebElement warningFirstName = driver.findElement(By.cssSelector("#error-shipping-firstname"));
	    Assert.assertTrue("Không hiển thị warning First Name", warningFirstName.isDisplayed());

	    WebElement warningLastName = driver.findElement(By.cssSelector("#error-shipping-lastname"));
	    Assert.assertTrue("Không hiển thị warning Last Name", warningLastName.isDisplayed());

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
	public void testLowerBoundary() {
		// Mục đích của hàm: Kiểm tra trường hợp người dùng nhập thông tin hợp lệ (trên giới hạn tối thiểu) trong quá trình đặt hàng
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000);
	    
	    WebElement amountProduct = driver.findElement(By.cssSelector("#header-cart > div > button"));
	    String numberItem = amountProduct.getText();
	    String zeroItem = "0 item(s)";
	    if (numberItem.contains(zeroItem)) {
	        WebElement addToCartBtn = driver.findElement(By.cssSelector(
	                "#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > form > div > button:nth-child(1)"));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
	        sleep(1000);
	        
	        addToCartBtn.click();
	        sleep(2000);

	        addToCartBtn.click();
	        sleep(5000);
	    }

	    WebElement checkoutLink = driver.findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(5) > a"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutLink);
	    sleep(1000);
	    checkoutLink.click();
	    
	    sleep(1000);
	    WebElement shippingNew = driver.findElement(By.cssSelector("#input-shipping-new"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", shippingNew);
	    sleep(1000);
	    shippingNew.click();
	    
	    // Nhập thông tin hợp lệ (trên giới hạn tối thiểu)
	    String firstName = "A"; // Nhập tên hợp lệ
	    String lastName = "B"; // Nhập họ hợp lệ
	    String company = "Company ABC";
	    String address1 = "Q.1"; // Địa chỉ 1 hợp lệ
	    String address2 = "Quan 5"; // Địa chỉ 2
	    String city = "SG"; // Tên thành phố hợp lệ
	    String postCode = "700000"; // Mã bưu chính hợp lệ
	    String country = "Viet Nam"; // Quốc gia hợp lệ
	    String region = "Ho Chi Minh City"; // Khu vực hợp lệ

	    WebElement inputFirstName = driver.findElement(By.cssSelector("#input-shipping-firstname"));
	    inputFirstName.sendKeys(firstName);
	    sleep(1000);

	    WebElement inputLastName = driver.findElement(By.cssSelector("#input-shipping-lastname"));
	    inputLastName.sendKeys(lastName);
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

	    WebElement continueBtn = driver.findElement(By.cssSelector("#button-shipping-address"));
	    continueBtn.click();
	    sleep(5000);

	    // Kiểm tra không có thông báo lỗi hiển thị
	    WebElement warningFirstName = driver.findElement(By.cssSelector("#error-shipping-firstname"));
	    Assert.assertTrue("Không hiển thị warning First Name", !warningFirstName.isDisplayed());

	    WebElement warningLastName = driver.findElement(By.cssSelector("#error-shipping-lastname"));
	    Assert.assertTrue("Không hiển thị warning Last Name", !warningLastName.isDisplayed());

	    WebElement warningAddress_1 = driver.findElement(By.cssSelector("#error-shipping-address-1"));
	    Assert.assertTrue("Không hiển thị warning Address 1", !warningAddress_1.isDisplayed());

	    WebElement warningCity = driver.findElement(By.cssSelector("#error-shipping-city"));
	    Assert.assertTrue("Không hiển thị warning City", !warningCity.isDisplayed());

	    WebElement warningCountry = driver.findElement(By.cssSelector("#error-shipping-country"));
	    Assert.assertTrue("Không hiển thị warning Country", !warningCountry.isDisplayed());

	    WebElement warningShippingZone = driver.findElement(By.cssSelector("#error-shipping-zone"));
	    Assert.assertTrue("Không hiển thị warning Shipping Zone", !warningShippingZone.isDisplayed());
	}

	@Test
	public void testUpperBoundary() {
		// Mục đích của hàm: Kiểm tra trường hợp người dùng nhập thông tin vượt quá giới hạn tối đa trong quá trình đặt hàng
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000);
	    
	    WebElement amountProduct = driver.findElement(By.cssSelector("#header-cart > div > button"));
	    String numberItem = amountProduct.getText();
	    String zeroItem = "0 item(s)";
	    if (numberItem.contains(zeroItem)) {
	        WebElement addToCartBtn = driver.findElement(By.cssSelector(
	                "#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > form > div > button:nth-child(1)"));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
	        sleep(1000);
	        
	        addToCartBtn.click();
	        sleep(2000);

	        addToCartBtn.click();
	        sleep(5000);
	    }

	    WebElement checkoutLink = driver.findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(5) > a"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutLink);
	    sleep(1000);
	    checkoutLink.click();
	    
	    sleep(1000);
	    WebElement shippingNew = driver.findElement(By.cssSelector("#input-shipping-new"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", shippingNew);
	    sleep(1000);
	    shippingNew.click();
	    sleep(1000);
	    
	    // Nhập thông tin vượt quá giới hạn tối đa
	    String firstName = "TranThiKimHoaNguyen"; // Tên vượt quá giới hạn tối đa
	    String lastName = "NguyenVanThanhBinh"; // Họ vượt quá giới hạn tối đa
	    String company = "Company ABC";
	    String address1 = "1234 Nguyen Thi Minh Khai Street, District 3, Ho Chi Minh City, Vietnam, 700000, located near the famous Ben Thanh Market."; // Địa chỉ vượt quá giới hạn tối đa
	    String address2 = "Quan 5";
	    String city = "Ho Chi Minh City, a vibrant metropolis known for its rich culture, delicious street food, and historical landmarks."; // Thành phố vượt quá giới hạn tối đa
	    String postCode = "700000"; // Mã bưu chính hợp lệ
	    String country = "Viet Nam"; // Quốc gia hợp lệ
	    String region = "Ho Chi Minh City"; // Khu vực hợp lệ

	    WebElement inputFirstName = driver.findElement(By.cssSelector("#input-shipping-firstname"));
	    inputFirstName.sendKeys(firstName);
	    sleep(1000);

	    WebElement inputLastName = driver.findElement(By.cssSelector("#input-shipping-lastname"));
	    inputLastName.sendKeys(lastName);
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

	    WebElement continueBtn = driver.findElement(By.cssSelector("#button-shipping-address"));
	    continueBtn.click();
	    sleep(5000);

	    // Kiểm tra có thông báo lỗi hiển thị cho các trường vượt quá giới hạn
	    WebElement warningFirstName = driver.findElement(By.cssSelector("#error-shipping-firstname"));
	    Assert.assertTrue("Không hiển thị warning First Name", !warningFirstName.isDisplayed());

	    WebElement warningLastName = driver.findElement(By.cssSelector("#error-shipping-lastname"));
	    Assert.assertTrue("Không hiển thị warning Last Name", !warningLastName.isDisplayed());

	    WebElement warningAddress_1 = driver.findElement(By.cssSelector("#error-shipping-address-1"));
	    Assert.assertTrue("Không hiển thị warning Address 1", !warningAddress_1.isDisplayed());

	    WebElement warningCity = driver.findElement(By.cssSelector("#error-shipping-city"));
	    Assert.assertTrue("Không hiển thị warning City", !warningCity.isDisplayed());

	    WebElement warningCountry = driver.findElement(By.cssSelector("#error-shipping-country"));
	    Assert.assertTrue("Không hiển thị warning Country", !warningCountry.isDisplayed());

	    WebElement warningShippingZone = driver.findElement(By.cssSelector("#error-shipping-zone"));
	    Assert.assertTrue("Không hiển thị warning Shipping Zone", !warningShippingZone.isDisplayed());
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
