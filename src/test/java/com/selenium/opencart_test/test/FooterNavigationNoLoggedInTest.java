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
		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
		sleep(1000);

		WebElement brandsLink = driver.findElement(By.linkText("Brands"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", brandsLink);
		sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(brandsLink)).click();

		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue("URL không chứa 'manufacturer': " + currentUrl, currentUrl.contains("manufacturer"));

		String pageTitle = driver.getTitle();
		Assert.assertTrue("Tiêu đề không chứa 'Find Your Favorite Brand': " + pageTitle, pageTitle.contains("Find Your Favorite Brand"));

		sleep(1000);
	}

	@Test
	public void testNavigationToGiftCertificates() {
		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
		sleep(1000);

		WebElement giftCertificatesLink = driver.findElement(By.linkText("Gift Certificates"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", giftCertificatesLink);
		sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(giftCertificatesLink)).click();

		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue("URL không chứa 'voucher': " + currentUrl,
				currentUrl.contains("voucher"));

		String pageTitle = driver.getTitle();
		Assert.assertTrue("Tiêu đề không chứa 'Purchase a Gift Certificate': " + pageTitle,
				pageTitle.contains("Purchase a Gift Certificate"));

		sleep(1000);
	}

	@Test
	public void testNavigationToSpecials() {
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
	public void testNavigationToAffiliateWithoutLogin() {
	   
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000);

	    WebElement affiliateLink = driver.findElement(By.linkText("Affiliate"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", affiliateLink);
	    sleep(1000);
	    wait.until(ExpectedConditions.elementToBeClickable(affiliateLink)).click();

	    String currentUrl = driver.getCurrentUrl();
	    Assert.assertTrue("URL không chứa 'login': " + currentUrl, currentUrl.contains("login"));

	    String pageTitle = driver.getTitle();
	    Assert.assertTrue("Tiêu đề không chứa 'Login': " + pageTitle, pageTitle.contains("Login"));

	    sleep(1000);
	}
	
	@Test
	public void testNavigationToMyAccountWithoutLogin() {

	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000);

	    WebElement myAccountLink = driver.findElement(By.linkText("My Account"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", myAccountLink);
	    sleep(1000);
	    wait.until(ExpectedConditions.elementToBeClickable(myAccountLink)).click();

	    String currentUrl = driver.getCurrentUrl();
	    Assert.assertTrue("URL không chứa 'login': " + currentUrl, currentUrl.contains("login"));

	    String pageTitle = driver.getTitle();
	    Assert.assertTrue("Tiêu đề không chứa 'Login': " + pageTitle, pageTitle.contains("Login"));

	    sleep(1000);
	}

	@Test
	public void testNavigationToOrderHistoryWithoutLogin() {
	
	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000);

	    WebElement orderHistoryLink = driver.findElement(By.linkText("Order History"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", orderHistoryLink);
	    sleep(1000);
	    wait.until(ExpectedConditions.elementToBeClickable(orderHistoryLink)).click();

	    String currentUrl = driver.getCurrentUrl();
	    Assert.assertTrue("URL không chứa 'login': " + currentUrl, currentUrl.contains("login"));

	    String pageTitle = driver.getTitle();
	    Assert.assertTrue("Tiêu đề không chứa 'Login': " + pageTitle, pageTitle.contains("Login"));

	    sleep(1000);
	}

	@Test
	public void testNavigationToWishListWithoutLogin() {

	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000);

	    WebElement wishListLink = driver.findElement(By.linkText("Wish List"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", wishListLink);
	    sleep(1000);
	    wait.until(ExpectedConditions.elementToBeClickable(wishListLink)).click();

	    String currentUrl = driver.getCurrentUrl();
	    Assert.assertTrue("URL không chứa 'login': " + currentUrl, currentUrl.contains("login"));

	    String pageTitle = driver.getTitle();
	    Assert.assertTrue("Tiêu đề không chứa 'Login': " + pageTitle, pageTitle.contains("Login"));

	    sleep(1000);
	}

	@Test
	public void testNavigationToNewsletterWithoutLogin() {

	    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	    sleep(1000);

	    WebElement newsletterLink = driver.findElement(By.linkText("Newsletter"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", newsletterLink);
	    sleep(1000);
	    wait.until(ExpectedConditions.elementToBeClickable(newsletterLink)).click();

	    String currentUrl = driver.getCurrentUrl();
	    Assert.assertTrue("URL không chứa 'login': " + currentUrl, currentUrl.contains("login"));

	    String pageTitle = driver.getTitle();
	    Assert.assertTrue("Tiêu đề không chứa 'Login': " + pageTitle, pageTitle.contains("Login"));

	    sleep(1000);
	}


	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
