package com.selenium.opencart_test.test;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FooterNavigationNoLoggedInTest {

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

	@Test
	public void testNavigationToAboutUs() {
	    // Mở trang chính của website OpenCart
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000);

	    // Tìm kiếm liên kết "About Us" và cuộn tới vị trí của nó
	    WebElement aboutUsLink = driver.findElement(By.linkText("About Us"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", aboutUsLink);
	    sleep(1000);
	    
	    // Nhấn vào liên kết "About Us"
	    wait.until(ExpectedConditions.elementToBeClickable(aboutUsLink)).click();

	    // Kiểm tra URL hiện tại có chứa "information"
	    String currentUrl = driver.getCurrentUrl();
	    Assert.assertTrue("URL không chứa 'information': " + currentUrl, currentUrl.contains("information"));

	    // Kiểm tra tiêu đề trang có chứa "About Us"
	    String pageTitle = driver.getTitle();
	    Assert.assertTrue("Tiêu đề không chứa 'About Us': " + pageTitle, pageTitle.contains("About Us"));

	    sleep(1000);
	}

	@Test
	public void testNavigationToPrivacyPolicy() {
	    // Mở trang chính của website OpenCart
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000);

	    // Tìm kiếm liên kết "Privacy Policy" và cuộn tới vị trí của nó
	    WebElement privacyPolicyLink = driver.findElement(By.linkText("Privacy Policy"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", privacyPolicyLink);
	    sleep(1000);
	    
	    // Nhấn vào liên kết "Privacy Policy"
	    wait.until(ExpectedConditions.elementToBeClickable(privacyPolicyLink)).click();

	    // Kiểm tra URL hiện tại có chứa "information"
	    String currentUrl = driver.getCurrentUrl();
	    Assert.assertTrue("URL không chứa 'information': " + currentUrl, currentUrl.contains("information"));

	    // Kiểm tra tiêu đề trang có chứa "Privacy Policy"
	    String pageTitle = driver.getTitle();
	    Assert.assertTrue("Tiêu đề không chứa 'Privacy Policy': " + pageTitle, pageTitle.contains("Privacy Policy"));

	    sleep(1000);
	}

	@Test
	public void testNavigationToTermsAndConditions() {
	    // Mở trang chính của website OpenCart
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000);

	    // Tìm kiếm liên kết "Terms & Conditions" và cuộn tới vị trí của nó
	    WebElement termsLink = driver.findElement(By.linkText("Terms & Conditions"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", termsLink);
	    sleep(1000);
	    
	    // Nhấn vào liên kết "Terms & Conditions"
	    wait.until(ExpectedConditions.elementToBeClickable(termsLink)).click();

	    // Kiểm tra URL hiện tại có chứa "information"
	    String currentUrl = driver.getCurrentUrl();
	    Assert.assertTrue("URL không chứa 'information': " + currentUrl, currentUrl.contains("information"));

	    // Kiểm tra tiêu đề trang có chứa "Terms & Conditions"
	    String pageTitle = driver.getTitle();
	    Assert.assertTrue("Tiêu đề không chứa 'Terms & Conditions': " + pageTitle, pageTitle.contains("Terms & Conditions"));

	    sleep(1000);
	}

	@Test
	public void testNavigationToSiteMap() {
	    // Mở trang chính của website OpenCart
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000);

	    // Tìm kiếm liên kết "Site Map" và cuộn tới vị trí của nó
	    WebElement siteMapLink = driver.findElement(By.linkText("Site Map"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", siteMapLink);
	    sleep(1000);
	    
	    // Nhấn vào liên kết "Site Map"
	    wait.until(ExpectedConditions.elementToBeClickable(siteMapLink)).click();

	    // Kiểm tra URL hiện tại có chứa "sitemap"
	    String currentUrl = driver.getCurrentUrl();
	    Assert.assertTrue("URL không chứa 'sitemap': " + currentUrl, currentUrl.contains("sitemap"));

	    // Kiểm tra tiêu đề trang có chứa "Site Map"
	    String pageTitle = driver.getTitle();
	    Assert.assertTrue("Tiêu đề không chứa 'Site Map': " + pageTitle, pageTitle.contains("Site Map"));

	    sleep(1000);
	}

	@Test
	public void testNavigationToContactUs() {
	    // Mở trang chính của website OpenCart
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000);

	    // Tìm kiếm liên kết "Contact Us" và cuộn tới vị trí của nó
	    WebElement contactUsLink = driver.findElement(By.linkText("Contact Us"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", contactUsLink);
	    sleep(1000);
	    
	    // Nhấn vào liên kết "Contact Us"
	    wait.until(ExpectedConditions.elementToBeClickable(contactUsLink)).click();

	    // Kiểm tra URL hiện tại có chứa "contact"
	    String currentUrl = driver.getCurrentUrl();
	    Assert.assertTrue("URL không chứa 'contact': " + currentUrl, currentUrl.contains("contact"));

	    // Kiểm tra tiêu đề trang có chứa "Contact Us"
	    String pageTitle = driver.getTitle();
	    Assert.assertTrue("Tiêu đề không chứa 'Contact Us': " + pageTitle, pageTitle.contains("Contact Us"));

	    sleep(1000);
	}

	@Test
	public void testNavigationToReturns() {
	    // Mở trang chính của website OpenCart
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000);

	    // Tìm kiếm liên kết "Returns" và cuộn tới vị trí của nó
	    WebElement returnsLink = driver.findElement(By.linkText("Returns"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", returnsLink);
	    sleep(1000);
	    
	    // Nhấn vào liên kết "Returns"
	    wait.until(ExpectedConditions.elementToBeClickable(returnsLink)).click();

	    // Kiểm tra URL hiện tại có chứa "returns"
	    String currentUrl = driver.getCurrentUrl();
	    Assert.assertTrue("URL không chứa 'returns': " + currentUrl, currentUrl.contains("returns"));

	    // Kiểm tra tiêu đề trang có chứa "Returns"
	    String pageTitle = driver.getTitle();
	    Assert.assertTrue("Tiêu đề không chứa 'Returns': " + pageTitle, pageTitle.contains("Returns"));

	    sleep(1000);
	}

	@Test
	public void testNavigationToDeliveryInformation() {
	    // Mở trang chính của website OpenCart
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000);

	    // Tìm kiếm liên kết "Delivery Information" và cuộn tới vị trí của nó
	    WebElement deliveryInfoLink = driver.findElement(By.linkText("Delivery Information"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deliveryInfoLink);
	    sleep(1000);
	    
	    // Nhấn vào liên kết "Delivery Information"
	    wait.until(ExpectedConditions.elementToBeClickable(deliveryInfoLink)).click();

	    // Kiểm tra URL hiện tại có chứa "information"
	    String currentUrl = driver.getCurrentUrl();
	    Assert.assertTrue("URL không chứa 'information': " + currentUrl, currentUrl.contains("information"));

	    // Kiểm tra tiêu đề trang có chứa "Delivery Information"
	    String pageTitle = driver.getTitle();
	    Assert.assertTrue("Tiêu đề không chứa 'Delivery Information': " + pageTitle, pageTitle.contains("Delivery Information"));

	    sleep(1000);
	}


	@Test
	public void testNavigationToBrands() {
	    // Điều hướng đến trang chính của OpenCart
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000); // Tạm dừng 1 giây để trang tải

	    // Tìm liên kết "Brands" và cuộn đến vị trí của nó
	    WebElement brandsLink = driver.findElement(By.linkText("Brands"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", brandsLink);
	    sleep(1000); // Tạm dừng 1 giây

	    // Chờ cho liên kết "Brands" có thể nhấn được và sau đó nhấn vào nó
	    wait.until(ExpectedConditions.elementToBeClickable(brandsLink)).click();

	    // Lấy URL hiện tại và kiểm tra xem nó có chứa "manufacturer" không
	    String currentUrl = driver.getCurrentUrl();
	    Assert.assertTrue("URL không chứa 'manufacturer': " + currentUrl, currentUrl.contains("manufacturer"));

	    // Lấy tiêu đề trang và kiểm tra xem nó có chứa "Find Your Favorite Brand" không
	    String pageTitle = driver.getTitle();
	    Assert.assertTrue("Tiêu đề không chứa 'Find Your Favorite Brand': " + pageTitle, pageTitle.contains("Find Your Favorite Brand"));

	    sleep(1000); // Tạm dừng 1 giây trước khi kết thúc phương thức
	}

	@Test
	public void testNavigationToGiftCertificates() {
	    // Điều hướng đến trang chính của OpenCart
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000); // Tạm dừng 1 giây để trang tải

	    // Tìm liên kết "Gift Certificates" và cuộn đến vị trí của nó
	    WebElement giftCertificatesLink = driver.findElement(By.linkText("Gift Certificates"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", giftCertificatesLink);
	    sleep(1000); // Tạm dừng 1 giây

	    // Chờ cho liên kết "Gift Certificates" có thể nhấn được và sau đó nhấn vào nó
	    wait.until(ExpectedConditions.elementToBeClickable(giftCertificatesLink)).click();

	    // Lấy URL hiện tại và kiểm tra xem nó có chứa "voucher" không
	    String currentUrl = driver.getCurrentUrl();
	    Assert.assertTrue("URL không chứa 'voucher': " + currentUrl, currentUrl.contains("voucher"));

	    // Lấy tiêu đề trang và kiểm tra xem nó có chứa "Purchase a Gift Certificate" không
	    String pageTitle = driver.getTitle();
	    Assert.assertTrue("Tiêu đề không chứa 'Purchase a Gift Certificate': " + pageTitle, pageTitle.contains("Purchase a Gift Certificate"));

	    sleep(1000); // Tạm dừng 1 giây trước khi kết thúc phương thức
	}

	@Test
	public void testNavigationToSpecials() {
	    // Điều hướng đến trang chính của OpenCart
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000); // Tạm dừng 1 giây để trang tải

	    // Tìm liên kết "Specials" và cuộn đến vị trí của nó
	    WebElement specialsLink = driver.findElement(By.linkText("Specials"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", specialsLink);
	    sleep(1000); // Tạm dừng 1 giây

	    // Chờ cho liên kết "Specials" có thể nhấn được và sau đó nhấn vào nó
	    wait.until(ExpectedConditions.elementToBeClickable(specialsLink)).click();

	    // Lấy URL hiện tại và kiểm tra xem nó có chứa "special" không
	    String currentUrl = driver.getCurrentUrl();
	    Assert.assertTrue("URL không chứa 'special': " + currentUrl, currentUrl.contains("special"));

	    // Lấy tiêu đề trang và kiểm tra xem nó có chứa "Special Offers" không
	    String pageTitle = driver.getTitle();
	    Assert.assertTrue("Tiêu đề không chứa 'Special Offers': " + pageTitle, pageTitle.contains("Special Offers"));

	    sleep(1000); // Tạm dừng 1 giây trước khi kết thúc phương thức
	}

	@Test
	public void testNavigationToAffiliateWithoutLogin() {
	    // Điều hướng đến trang chính của OpenCart
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000); // Tạm dừng 1 giây để trang tải

	    // Tìm liên kết "Affiliate" và cuộn đến vị trí của nó
	    WebElement affiliateLink = driver.findElement(By.linkText("Affiliate"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", affiliateLink);
	    sleep(1000); // Tạm dừng 1 giây

	    // Chờ cho liên kết "Affiliate" có thể nhấn được và sau đó nhấn vào nó
	    wait.until(ExpectedConditions.elementToBeClickable(affiliateLink)).click();

	    // Lấy URL hiện tại và kiểm tra xem nó có chứa "login" không
	    String currentUrl = driver.getCurrentUrl();
	    Assert.assertTrue("URL không chứa 'login': " + currentUrl, currentUrl.contains("login"));

	    // Lấy tiêu đề trang và kiểm tra xem nó có chứa "Login" không
	    String pageTitle = driver.getTitle();
	    Assert.assertTrue("Tiêu đề không chứa 'Login': " + pageTitle, pageTitle.contains("Login"));

	    sleep(1000); // Tạm dừng 1 giây trước khi kết thúc phương thức
	}

	@Test
	public void testNavigationToMyAccountWithoutLogin() {
	    // Điều hướng đến trang chính của OpenCart
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000); // Tạm dừng 1 giây để trang tải

	    // Tìm liên kết "My Account" và cuộn đến vị trí của nó
	    WebElement myAccountLink = driver.findElement(By.cssSelector("body > footer > div > div > div:nth-child(4) > ul > li:nth-child(1) > a")); // Tìm liên kết "My Account"
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", myAccountLink); // Cuộn đến liên kết
	    sleep(1000); // Chờ một chút

	    // Chờ cho liên kết "My Account" có thể nhấn được và sau đó nhấn vào nó
	    wait.until(ExpectedConditions.elementToBeClickable(myAccountLink)).click();

	    // Lấy URL hiện tại và kiểm tra xem nó có chứa "login" không
	    String currentUrl = driver.getCurrentUrl();
	    Assert.assertTrue("URL không chứa 'login': " + currentUrl, currentUrl.contains("account"));

	    // Lấy tiêu đề trang và kiểm tra xem nó có chứa "Login" không
	    String pageTitle = driver.getTitle();
	    Assert.assertTrue("Tiêu đề không chứa 'Login': " + pageTitle, pageTitle.contains("Login"));

	    sleep(1000); // Tạm dừng 1 giây trước khi kết thúc phương thức
	}

	@Test
	public void testNavigationToOrderHistoryWithoutLogin() {
	    // Điều hướng đến trang chính của OpenCart
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000); // Tạm dừng 1 giây để trang tải

	    // Tìm liên kết "Order History" và cuộn đến vị trí của nó
	    WebElement orderHistoryLink = driver.findElement(By.linkText("Order History"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", orderHistoryLink);
	    sleep(1000); // Tạm dừng 1 giây

	    // Chờ cho liên kết "Order History" có thể nhấn được và sau đó nhấn vào nó
	    wait.until(ExpectedConditions.elementToBeClickable(orderHistoryLink)).click();

	    // Lấy URL hiện tại và kiểm tra xem nó có chứa "login" không
	    String currentUrl = driver.getCurrentUrl();
	    Assert.assertTrue("URL không chứa 'login': " + currentUrl, currentUrl.contains("login"));

	    // Lấy tiêu đề trang và kiểm tra xem nó có chứa "Login" không
	    String pageTitle = driver.getTitle();
	    Assert.assertTrue("Tiêu đề không chứa 'Login': " + pageTitle, pageTitle.contains("Login"));

	    sleep(1000); // Tạm dừng 1 giây trước khi kết thúc phương thức
	}

	@Test
	public void testNavigationToWishListWithoutLogin() {
	    // Điều hướng đến trang chính của OpenCart
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000); // Tạm dừng 1 giây để trang tải

	    // Tìm liên kết "Wish List" và cuộn đến vị trí của nó
	    WebElement wishListLink = driver.findElement(By.linkText("Wish List"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", wishListLink);
	    sleep(1000); // Tạm dừng 1 giây

	    // Chờ cho liên kết "Wish List" có thể nhấn được và sau đó nhấn vào nó
	    wait.until(ExpectedConditions.elementToBeClickable(wishListLink)).click();

	    // Lấy URL hiện tại và kiểm tra xem nó có chứa "login" không
	    String currentUrl = driver.getCurrentUrl();
	    Assert.assertTrue("URL không chứa 'login': " + currentUrl, currentUrl.contains("login"));

	    // Lấy tiêu đề trang và kiểm tra xem nó có chứa "Login" không
	    String pageTitle = driver.getTitle();
	    Assert.assertTrue("Tiêu đề không chứa 'Login': " + pageTitle, pageTitle.contains("Login"));

	    sleep(1000); // Tạm dừng 1 giây trước khi kết thúc phương thức
	}

	@Test
	public void testNavigationToNewsletterWithoutLogin() {
	    // Điều hướng đến trang chính của OpenCart
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000); // Tạm dừng 1 giây để trang tải

	    // Tìm liên kết "Newsletter" và cuộn đến vị trí của nó
	    WebElement newsletterLink = driver.findElement(By.linkText("Newsletter"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", newsletterLink);
	    sleep(1000); // Tạm dừng 1 giây

	    // Chờ cho liên kết "Newsletter" có thể nhấn được và sau đó nhấn vào nó
	    wait.until(ExpectedConditions.elementToBeClickable(newsletterLink)).click();

	    // Lấy URL hiện tại và kiểm tra xem nó có chứa "login" không
	    String currentUrl = driver.getCurrentUrl();
	    Assert.assertTrue("URL không chứa 'login': " + currentUrl, currentUrl.contains("login"));

	    // Lấy tiêu đề trang và kiểm tra xem nó có chứa "Login" không
	    String pageTitle = driver.getTitle();
	    Assert.assertTrue("Tiêu đề không chứa 'Login': " + pageTitle, pageTitle.contains("Login"));

	    sleep(1000); // Tạm dừng 1 giây trước khi kết thúc phương thức
	}



	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
