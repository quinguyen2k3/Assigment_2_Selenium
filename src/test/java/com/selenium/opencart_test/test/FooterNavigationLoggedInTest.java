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
		emailField.sendKeys("bichqui1212@gmail.com");
		sleep(1000);

		WebElement passwordField = driver.findElement(By.id("input-password"));
		passwordField.sendKeys("123456789");
		sleep(1000);

		WebElement loginButton = driver.findElement(By.cssSelector("button.btn.btn-primary"));
		loginButton.click();
		sleep(1000);

	}

	@Test
	public void testNavigationToAboutUs() {
		login();
		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
		sleep(1000);

		WebElement aboutUsLink = driver.findElement(By.linkText("About Us"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", aboutUsLink);
		sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(aboutUsLink)).click();

		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue("URL không chứa 'information': " + currentUrl, currentUrl.contains("information"));

		String pageTitle = driver.getTitle();
		Assert.assertTrue("Tiêu đề không chứa 'About Us': " + pageTitle, pageTitle.contains("About Us"));

		sleep(1000);
	}

	@Test
	public void testNavigationToPrivacyPolicy() {
		login();
		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
		sleep(1000);

		WebElement privacyPolicyLink = driver.findElement(By.linkText("Privacy Policy"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", privacyPolicyLink);
		sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(privacyPolicyLink)).click();

		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue("URL không chứa 'information': " + currentUrl, currentUrl.contains("information"));

		String pageTitle = driver.getTitle();
		Assert.assertTrue("Tiêu đề không chứa 'Privacy Policy': " + pageTitle, pageTitle.contains("Privacy Policy"));

		sleep(1000);
	}

	@Test
	public void testNavigationToTermsAndConditions() {
		login();
		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
		sleep(1000);

		WebElement termsLink = driver.findElement(By.linkText("Terms & Conditions"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", termsLink);
		sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(termsLink)).click();

		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue("URL không chứa 'information': " + currentUrl, currentUrl.contains("information"));

		String pageTitle = driver.getTitle();
		Assert.assertTrue("Tiêu đề không chứa 'Terms & Conditions': " + pageTitle,
				pageTitle.contains("Terms & Conditions"));

		sleep(1000);
	}

	@Test
	public void testNavigationToSiteMap() {
		login();
		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
		sleep(1000);

		WebElement siteMapLink = driver.findElement(By.linkText("Site Map"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", siteMapLink);
		sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(siteMapLink)).click();

		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue("URL không chứa 'sitemap': " + currentUrl, currentUrl.contains("sitemap"));

		String pageTitle = driver.getTitle();
		Assert.assertTrue("Tiêu đề không chứa 'Site Map': " + pageTitle, pageTitle.contains("Site Map"));

		sleep(1000);
	}

	@Test
	public void testNavigationToContactUs() {
		login();
		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
		sleep(1000);

		WebElement contactUsLink = driver.findElement(By.linkText("Contact Us"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", contactUsLink);
		sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(contactUsLink)).click();

		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue("URL không chứa 'contact': " + currentUrl, currentUrl.contains("contact"));

		String pageTitle = driver.getTitle();
		Assert.assertTrue("Tiêu đề không chứa 'Contact Us': " + pageTitle, pageTitle.contains("Contact Us"));

		sleep(1000);
	}

	@Test
	public void testNavigationToReturns() {
		login();
		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
		sleep(1000);

		WebElement returnsLink = driver.findElement(By.linkText("Returns"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", returnsLink);
		sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(returnsLink)).click();

		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue("URL không chứa 'returns': " + currentUrl, currentUrl.contains("returns"));

		String pageTitle = driver.getTitle();
		Assert.assertTrue("Tiêu đề không chứa 'Returns': " + pageTitle, pageTitle.contains("Returns"));

		sleep(1000);
	}

	@Test
	public void testNavigationToDeliveryInformation() {
		login();
		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
		sleep(1000);

		WebElement deliveryInfoLink = driver.findElement(By.linkText("Delivery Information"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deliveryInfoLink);
		sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(deliveryInfoLink)).click();

		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue("URL không chứa 'information': " + currentUrl, currentUrl.contains("information"));

		String pageTitle = driver.getTitle();
		Assert.assertTrue("Tiêu đề không chứa 'Delivery Information': " + pageTitle,
				pageTitle.contains("Delivery Information"));

		sleep(1000);
	}

	@Test
	public void testNavigationToBrands() {
		login();
		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
		sleep(1000);

		WebElement brandsLink = driver.findElement(By.linkText("Brands"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", brandsLink);
		sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(brandsLink)).click();

		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue("URL không chứa 'manufacturer': " + currentUrl, currentUrl.contains("manufacturer"));

		String pageTitle = driver.getTitle();
		Assert.assertTrue("Tiêu đề không chứa 'Find Your Favorite Brand': " + pageTitle,
				pageTitle.contains("Find Your Favorite Brand"));

		sleep(1000);
	}

	@Test
	public void testNavigationToGiftCertificates() {
		login();
		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
		sleep(1000);

		WebElement giftCertificatesLink = driver.findElement(By.linkText("Gift Certificates"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", giftCertificatesLink);
		sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(giftCertificatesLink)).click();

		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue("URL không chứa 'voucher': " + currentUrl, currentUrl.contains("voucher"));

		String pageTitle = driver.getTitle();
		Assert.assertTrue("Tiêu đề không chứa 'Purchase a Gift Certificate': " + pageTitle,
				pageTitle.contains("Purchase a Gift Certificate"));

		sleep(1000);
	}

	@Test
	public void testNavigationToSpecials() {
		login();
		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
		sleep(1000);

		WebElement specialsLink = driver.findElement(By.linkText("Specials"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", specialsLink);
		sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(specialsLink)).click();

		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue("URL không chứa 'special': " + currentUrl, currentUrl.contains("special"));

		String pageTitle = driver.getTitle();
		Assert.assertTrue("Tiêu đề không chứa 'Special Offers': " + pageTitle, pageTitle.contains("Special Offers"));

		sleep(1000);
	}
	
	@Test
	public void testNavigationToAffiliate() {
	    login();  
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000);
	    
	    WebElement affiliateLink = driver.findElement(By.linkText("Affiliate"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", affiliateLink);
	    sleep(1000);
	    affiliateLink.click();

	    String currentUrl = driver.getCurrentUrl();
	    Assert.assertTrue("URL không chứa 'affiliate': " + currentUrl, currentUrl.contains("affiliate"));

	    String pageTitle = driver.getTitle();
	    Assert.assertTrue("Tiêu đề không chứa 'Affiliate': " + pageTitle, pageTitle.contains("Your Affiliate Information"));
	    
	    sleep(1000);
	}
	
	@Test
	public void testNavigationToMyAccount() {
	    login();  
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000);
	    
	    WebElement myAccountLink = driver.findElement(By.cssSelector("body > footer > div > div > div:nth-child(4) > ul > li:nth-child(1) > a"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", myAccountLink);
	    sleep(1000);
	    myAccountLink.click();
	    
	    sleep(3000);

	    String currentUrl = driver.getCurrentUrl();
	    Assert.assertTrue("URL không chứa 'account': " + currentUrl, currentUrl.contains("account"));

	    String pageTitle = driver.getTitle();
	    Assert.assertTrue("Tiêu đề không chứa 'My Account': " + pageTitle, pageTitle.contains("My Account"));
	    
	    sleep(1000);
	}

	@Test
	public void testNavigationToOrderHistory() {
	    login();  
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000);
	    
	    WebElement orderHistoryLink = driver.findElement(By.linkText("Order History"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", orderHistoryLink);
	    sleep(1000);
	    orderHistoryLink.click();

	    String currentUrl = driver.getCurrentUrl();
	    Assert.assertTrue("URL không chứa 'order': " + currentUrl, currentUrl.contains("order"));

	    String pageTitle = driver.getTitle();
	    Assert.assertTrue("Tiêu đề không chứa 'Order History': " + pageTitle, pageTitle.contains("Orders"));
	    
	    sleep(1000);
	}

	@Test
	public void testNavigationToWishList() {
	    login();  
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000);
	    
	    WebElement wishListLink = driver.findElement(By.linkText("Wish List"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", wishListLink);
	    sleep(1000);
	    wishListLink.click();

	    String currentUrl = driver.getCurrentUrl();
	    Assert.assertTrue("URL không chứa 'wishlist': " + currentUrl, currentUrl.contains("wishlist"));

	    String pageTitle = driver.getTitle();
	    Assert.assertTrue("Tiêu đề không chứa 'Wish List': " + pageTitle, pageTitle.contains("My Wishlist"));
	    
	    sleep(1000);
	}

	@Test
	public void testNavigationToNewsletter() {
	    login();  
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000);
	    
	    WebElement newsletterLink = driver.findElement(By.linkText("Newsletter"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", newsletterLink);
	    sleep(1000);
	    newsletterLink.click();

	    String currentUrl = driver.getCurrentUrl();
	    Assert.assertTrue("URL không chứa 'newsletter': " + currentUrl, currentUrl.contains("newsletter"));

	    String pageTitle = driver.getTitle();
	    Assert.assertTrue("Tiêu đề không chứa 'Newsletter': " + pageTitle, pageTitle.contains("Newsletter Subscription"));
	    
	    sleep(1000);
	}
	
	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}


}
