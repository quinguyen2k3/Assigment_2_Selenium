package com.selenium.opencart_test.test;

import java.time.Duration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FooterNavigationLoggedInTest {

	private WebDriver driver;
	private WebDriverWait wait;

	@Before
	public void setUp() {
		System.setProperty("webdriver.edge.driver", "D:\\Kiem_thu_phan_mem\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	private void sleep(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void login() {

		driver.get("http://localhost/opencartsite/index.php?route=account/login&language=en-gb");
		sleep(2000);

		WebElement emailField = driver.findElement(By.id("input-email"));
		emailField.sendKeys("test_login@gmail.com");
		sleep(1000);

		WebElement passwordField = driver.findElement(By.id("input-password"));
		passwordField.sendKeys("123456789");
		sleep(1000);

		WebElement loginButton = driver.findElement(By.cssSelector("button.btn.btn-primary"));
		loginButton.click();
		sleep(1000);

	}
	
	//Chuyển sang trang About Us
	@Test
	public void testNavigationToAboutUs() {
	    // Đăng nhập vào hệ thống
	    login();
	    // Điều hướng đến trang chủ OpenCart
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000); // Chờ trang tải xong

	    // Tìm liên kết "About Us" và cuộn đến nó
	    WebElement aboutUsLink = driver.findElement(By.linkText("About Us"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", aboutUsLink);
	    sleep(1000);
	    
	    // Chờ cho liên kết có thể nhấp được và nhấp vào nó
	    wait.until(ExpectedConditions.elementToBeClickable(aboutUsLink)).click();

	    // Lấy URL hiện tại và kiểm tra xem nó có chứa 'information' không
	    String currentUrl = driver.getCurrentUrl();
	    Assert.assertTrue("URL không chứa 'information': " + currentUrl, currentUrl.contains("information"));

	    // Lấy tiêu đề trang và kiểm tra xem nó có chứa 'About Us' không
	    String pageTitle = driver.getTitle();
	    Assert.assertTrue("Tiêu đề không chứa 'About Us': " + pageTitle, pageTitle.contains("About Us"));

	    sleep(1000); // Chờ trước khi kết thúc kiểm thử
	}

	//Chuyển sang trang Privacy Policy
	@Test
	public void testNavigationToPrivacyPolicy() {
	    // Đăng nhập vào hệ thống
	    login();
	    // Điều hướng đến trang chủ OpenCart
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000); // Chờ trang tải xong

	    // Tìm liên kết "Privacy Policy" và cuộn đến nó
	    WebElement privacyPolicyLink = driver.findElement(By.linkText("Privacy Policy"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", privacyPolicyLink);
	    sleep(1000);
	    
	    // Chờ cho liên kết có thể nhấp được và nhấp vào nó
	    wait.until(ExpectedConditions.elementToBeClickable(privacyPolicyLink)).click();

	    // Lấy URL hiện tại và kiểm tra xem nó có chứa 'information' không
	    String currentUrl = driver.getCurrentUrl();
	    Assert.assertTrue("URL không chứa 'information': " + currentUrl, currentUrl.contains("information"));

	    // Lấy tiêu đề trang và kiểm tra xem nó có chứa 'Privacy Policy' không
	    String pageTitle = driver.getTitle();
	    Assert.assertTrue("Tiêu đề không chứa 'Privacy Policy': " + pageTitle, pageTitle.contains("Privacy Policy"));

	    sleep(1000); // Chờ trước khi kết thúc kiểm thử
	}
	
	//Chuyển sang trang Terms And Conditions
	@Test
	public void testNavigationToTermsAndConditions() {
	    // Đăng nhập vào hệ thống
	    login();
	    // Điều hướng đến trang chủ OpenCart
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000); // Chờ trang tải xong

	    // Tìm liên kết "Terms & Conditions" và cuộn đến nó
	    WebElement termsLink = driver.findElement(By.linkText("Terms & Conditions"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", termsLink);
	    sleep(1000);
	    
	    // Chờ cho liên kết có thể nhấp được và nhấp vào nó
	    wait.until(ExpectedConditions.elementToBeClickable(termsLink)).click();

	    // Lấy URL hiện tại và kiểm tra xem nó có chứa 'information' không
	    String currentUrl = driver.getCurrentUrl();
	    Assert.assertTrue("URL không chứa 'information': " + currentUrl, currentUrl.contains("information"));

	    // Lấy tiêu đề trang và kiểm tra xem nó có chứa 'Terms & Conditions' không
	    String pageTitle = driver.getTitle();
	    Assert.assertTrue("Tiêu đề không chứa 'Terms & Conditions': " + pageTitle,
	            pageTitle.contains("Terms & Conditions"));

	    sleep(1000); // Chờ trước khi kết thúc kiểm thử
	}
	
	//Chuyển sang trang Site Map
	@Test
	public void testNavigationToSiteMap() {
	    // Đăng nhập vào hệ thống
	    login();
	    // Điều hướng đến trang chủ OpenCart
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000); // Chờ trang tải xong

	    // Tìm liên kết "Site Map" và cuộn đến nó
	    WebElement siteMapLink = driver.findElement(By.linkText("Site Map"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", siteMapLink);
	    sleep(1000);
	    
	    // Chờ cho liên kết có thể nhấp được và nhấp vào nó
	    wait.until(ExpectedConditions.elementToBeClickable(siteMapLink)).click();

	    // Lấy URL hiện tại và kiểm tra xem nó có chứa 'sitemap' không
	    String currentUrl = driver.getCurrentUrl();
	    Assert.assertTrue("URL không chứa 'sitemap': " + currentUrl, currentUrl.contains("sitemap"));

	    // Lấy tiêu đề trang và kiểm tra xem nó có chứa 'Site Map' không
	    String pageTitle = driver.getTitle();
	    Assert.assertTrue("Tiêu đề không chứa 'Site Map': " + pageTitle, pageTitle.contains("Site Map"));

	    sleep(1000); // Chờ trước khi kết thúc kiểm thử
	}

	@Test
	public void testNavigationToContactUs() {
	    // Kiểm tra điều hướng đến trang "Contact Us"
	    login(); // Đăng nhập vào hệ thống
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb"); // Điều hướng đến trang chủ
	    sleep(1000); // Chờ trang tải xong

	    WebElement contactUsLink = driver.findElement(By.linkText("Contact Us")); // Tìm liên kết "Contact Us"
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", contactUsLink); // Cuộn đến liên kết
	    sleep(1000); // Chờ một chút

	    wait.until(ExpectedConditions.elementToBeClickable(contactUsLink)).click(); // Chờ cho liên kết có thể nhấp được và nhấp vào

	    String currentUrl = driver.getCurrentUrl(); // Lấy URL hiện tại
	    Assert.assertTrue("URL không chứa 'contact': " + currentUrl, currentUrl.contains("contact")); // Kiểm tra URL

	    String pageTitle = driver.getTitle(); // Lấy tiêu đề trang
	    Assert.assertTrue("Tiêu đề không chứa 'Contact Us': " + pageTitle, pageTitle.contains("Contact Us")); // Kiểm tra tiêu đề

	    sleep(1000); // Chờ trước khi kết thúc kiểm thử
	}

	@Test
	public void testNavigationToReturns() {
	    // Kiểm tra điều hướng đến trang "Returns"
	    login(); // Đăng nhập vào hệ thống
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb"); // Điều hướng đến trang chủ
	    sleep(1000); // Chờ trang tải xong

	    WebElement returnsLink = driver.findElement(By.linkText("Returns")); // Tìm liên kết "Returns"
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", returnsLink); // Cuộn đến liên kết
	    sleep(1000); // Chờ một chút

	    wait.until(ExpectedConditions.elementToBeClickable(returnsLink)).click(); // Chờ cho liên kết có thể nhấp được và nhấp vào

	    String currentUrl = driver.getCurrentUrl(); // Lấy URL hiện tại
	    Assert.assertTrue("URL không chứa 'returns': " + currentUrl, currentUrl.contains("returns")); // Kiểm tra URL

	    String pageTitle = driver.getTitle(); // Lấy tiêu đề trang
	    Assert.assertTrue("Tiêu đề không chứa 'Returns': " + pageTitle, pageTitle.contains("Returns")); // Kiểm tra tiêu đề

	    sleep(1000); // Chờ trước khi kết thúc kiểm thử
	}

	@Test
	public void testNavigationToDeliveryInformation() {
	    // Kiểm tra điều hướng đến trang "Delivery Information"
	    login(); // Đăng nhập vào hệ thống
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb"); // Điều hướng đến trang chủ
	    sleep(1000); // Chờ trang tải xong

	    WebElement deliveryInfoLink = driver.findElement(By.linkText("Delivery Information")); // Tìm liên kết "Delivery Information"
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deliveryInfoLink); // Cuộn đến liên kết
	    sleep(1000); // Chờ một chút

	    wait.until(ExpectedConditions.elementToBeClickable(deliveryInfoLink)).click(); // Chờ cho liên kết có thể nhấp được và nhấp vào

	    String currentUrl = driver.getCurrentUrl(); // Lấy URL hiện tại
	    Assert.assertTrue("URL không chứa 'information': " + currentUrl, currentUrl.contains("information")); // Kiểm tra URL

	    String pageTitle = driver.getTitle(); // Lấy tiêu đề trang
	    Assert.assertTrue("Tiêu đề không chứa 'Delivery Information': " + pageTitle, pageTitle.contains("Delivery Information")); // Kiểm tra tiêu đề

	    sleep(1000); // Chờ trước khi kết thúc kiểm thử
	}

	@Test
	public void testNavigationToBrands() {
	    // Kiểm tra điều hướng đến trang "Brands"
	    login(); // Đăng nhập vào hệ thống
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb"); // Điều hướng đến trang chủ
	    sleep(1000); // Chờ trang tải xong

	    WebElement brandsLink = driver.findElement(By.linkText("Brands")); // Tìm liên kết "Brands"
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", brandsLink); // Cuộn đến liên kết
	    sleep(1000); // Chờ một chút

	    wait.until(ExpectedConditions.elementToBeClickable(brandsLink)).click(); // Chờ cho liên kết có thể nhấp được và nhấp vào

	    String currentUrl = driver.getCurrentUrl(); // Lấy URL hiện tại
	    Assert.assertTrue("URL không chứa 'manufacturer': " + currentUrl, currentUrl.contains("manufacturer")); // Kiểm tra URL

	    String pageTitle = driver.getTitle(); // Lấy tiêu đề trang
	    Assert.assertTrue("Tiêu đề không chứa 'Find Your Favorite Brand': " + pageTitle, pageTitle.contains("Find Your Favorite Brand")); // Kiểm tra tiêu đề

	    sleep(1000); // Chờ trước khi kết thúc kiểm thử
	}


	@Test
	public void testNavigationToGiftCertificates() {
	    // Kiểm tra điều hướng đến trang "Gift Certificates"
	    login(); // Đăng nhập vào hệ thống
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb"); // Điều hướng đến trang chủ
	    sleep(1000); // Chờ trang tải xong

	    WebElement giftCertificatesLink = driver.findElement(By.linkText("Gift Certificates")); // Tìm liên kết "Gift Certificates"
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", giftCertificatesLink); // Cuộn đến liên kết
	    sleep(1000); // Chờ một chút

	    wait.until(ExpectedConditions.elementToBeClickable(giftCertificatesLink)).click(); // Chờ cho liên kết có thể nhấp được và nhấp vào

	    String currentUrl = driver.getCurrentUrl(); // Lấy URL hiện tại
	    Assert.assertTrue("URL không chứa 'voucher': " + currentUrl, currentUrl.contains("voucher")); // Kiểm tra URL

	    String pageTitle = driver.getTitle(); // Lấy tiêu đề trang
	    Assert.assertTrue("Tiêu đề không chứa 'Purchase a Gift Certificate': " + pageTitle, pageTitle.contains("Purchase a Gift Certificate")); // Kiểm tra tiêu đề

	    sleep(1000); // Chờ trước khi kết thúc kiểm thử
	}

	@Test
	public void testNavigationToSpecials() {
	    // Kiểm tra điều hướng đến trang "Specials"
	    login(); // Đăng nhập vào hệ thống
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb"); // Điều hướng đến trang chủ
	    sleep(1000); // Chờ trang tải xong

	    WebElement specialsLink = driver.findElement(By.linkText("Specials")); // Tìm liên kết "Specials"
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", specialsLink); // Cuộn đến liên kết
	    sleep(1000); // Chờ một chút

	    wait.until(ExpectedConditions.elementToBeClickable(specialsLink)).click(); // Chờ cho liên kết có thể nhấp được và nhấp vào

	    String currentUrl = driver.getCurrentUrl(); // Lấy URL hiện tại
	    Assert.assertTrue("URL không chứa 'special': " + currentUrl, currentUrl.contains("special")); // Kiểm tra URL

	    String pageTitle = driver.getTitle(); // Lấy tiêu đề trang
	    Assert.assertTrue("Tiêu đề không chứa 'Special Offers': " + pageTitle, pageTitle.contains("Special Offers")); // Kiểm tra tiêu đề

	    sleep(1000); // Chờ trước khi kết thúc kiểm thử
	}

	@Test
	public void testNavigationToAffiliate() {
	    // Kiểm tra điều hướng đến trang "Affiliate"
	    login(); // Đăng nhập vào hệ thống
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb"); // Điều hướng đến trang chủ
	    sleep(1000); // Chờ trang tải xong

	    WebElement affiliateLink = driver.findElement(By.linkText("Affiliate")); // Tìm liên kết "Affiliate"
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", affiliateLink); // Cuộn đến liên kết
	    sleep(1000); // Chờ một chút

	    affiliateLink.click(); // Nhấp vào liên kết

	    String currentUrl = driver.getCurrentUrl(); // Lấy URL hiện tại
	    Assert.assertTrue("URL không chứa 'affiliate': " + currentUrl, currentUrl.contains("affiliate")); // Kiểm tra URL

	    String pageTitle = driver.getTitle(); // Lấy tiêu đề trang
	    Assert.assertTrue("Tiêu đề không chứa 'Affiliate': " + pageTitle, pageTitle.contains("Your Affiliate Information")); // Kiểm tra tiêu đề

	    sleep(1000); // Chờ trước khi kết thúc kiểm thử
	}

	@Test
	public void testNavigationToMyAccount() {
	    // Kiểm tra điều hướng đến trang "My Account"
	    login(); // Đăng nhập vào hệ thống
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb"); // Điều hướng đến trang chủ
	    sleep(1000); // Chờ trang tải xong

	    WebElement myAccountLink = driver.findElement(By.cssSelector("body > footer > div > div > div:nth-child(4) > ul > li:nth-child(1) > a")); // Tìm liên kết "My Account"
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", myAccountLink); // Cuộn đến liên kết
	    sleep(1000); // Chờ một chút

	    myAccountLink.click(); // Nhấp vào liên kết

	    sleep(3000); // Chờ trang tải xong

	    String currentUrl = driver.getCurrentUrl(); // Lấy URL hiện tại
	    Assert.assertTrue("URL không chứa 'account': " + currentUrl, currentUrl.contains("account")); // Kiểm tra URL

	    String pageTitle = driver.getTitle(); // Lấy tiêu đề trang
	    Assert.assertTrue("Tiêu đề không chứa 'My Account': " + pageTitle, pageTitle.contains("My Account")); // Kiểm tra tiêu đề

	    sleep(1000); // Chờ trước khi kết thúc kiểm thử
	}

	@Test
	public void testNavigationToOrderHistory() {
	    // Kiểm tra điều hướng đến trang "Order History"
	    login(); // Đăng nhập vào hệ thống
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb"); // Điều hướng đến trang chủ
	    sleep(1000); // Chờ trang tải xong

	    WebElement orderHistoryLink = driver.findElement(By.linkText("Order History")); // Tìm liên kết "Order History"
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", orderHistoryLink); // Cuộn đến liên kết
	    sleep(1000); // Chờ một chút

	    orderHistoryLink.click(); // Nhấp vào liên kết

	    String currentUrl = driver.getCurrentUrl(); // Lấy URL hiện tại
	    Assert.assertTrue("URL không chứa 'order': " + currentUrl, currentUrl.contains("order")); // Kiểm tra URL

	    String pageTitle = driver.getTitle(); // Lấy tiêu đề trang
	    Assert.assertTrue("Tiêu đề không chứa 'Order History': " + pageTitle, pageTitle.contains("Orders")); // Kiểm tra tiêu đề

	    sleep(1000); // Chờ trước khi kết thúc kiểm thử
	}

	@Test
	public void testNavigationToWishList() {
	    // Kiểm tra điều hướng đến trang "Wish List"
	    login(); // Đăng nhập vào hệ thống
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb"); // Điều hướng đến trang chủ
	    sleep(1000); // Chờ trang tải xong

	    WebElement wishListLink = driver.findElement(By.linkText("Wish List")); // Tìm liên kết "Wish List"
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", wishListLink); // Cuộn đến liên kết
	    sleep(1000); // Chờ một chút

	    wishListLink.click(); // Nhấp vào liên kết

	    String currentUrl = driver.getCurrentUrl(); // Lấy URL hiện tại
	    Assert.assertTrue("URL không chứa 'wishlist': " + currentUrl, currentUrl.contains("wishlist")); // Kiểm tra URL

	    String pageTitle = driver.getTitle(); // Lấy tiêu đề trang
	    Assert.assertTrue("Tiêu đề không chứa 'Wish List': " + pageTitle, pageTitle.contains("My Wishlist")); // Kiểm tra tiêu đề

	    sleep(1000); // Chờ trước khi kết thúc kiểm thử
	}


	@Test
	public void testNavigationToNewsletter() {
	    // Kiểm tra điều hướng đến trang "Newsletter"
	    login();  // Đăng nhập vào hệ thống
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb"); // Điều hướng đến trang chủ
	    sleep(1000); // Chờ trang tải xong

	    WebElement newsletterLink = driver.findElement(By.linkText("Newsletter")); // Tìm liên kết "Newsletter"
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", newsletterLink); // Cuộn đến liên kết
	    sleep(1000); // Chờ một chút

	    newsletterLink.click(); // Nhấp vào liên kết "Newsletter"

	    String currentUrl = driver.getCurrentUrl(); // Lấy URL hiện tại
	    Assert.assertTrue("URL không chứa 'newsletter': " + currentUrl, currentUrl.contains("newsletter")); // Kiểm tra URL

	    String pageTitle = driver.getTitle(); // Lấy tiêu đề trang
	    Assert.assertTrue("Tiêu đề không chứa 'Newsletter': " + pageTitle, pageTitle.contains("Newsletter Subscription")); // Kiểm tra tiêu đề

	    sleep(1000); // Chờ trước khi kết thúc kiểm thử
	}

	
	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}


}
