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

public class LoggedCheckOutTest{
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.edge.driver", "D:\\Kiem_thu_phan_mem\\edgedriver_win64\\msedgedriver.exe");

		driver = new EdgeDriver();
		
		login();
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
	public void testCheckoutValidInfor() {
		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
		sleep(1000);
		
		WebElement amountProduct = driver.findElement(By.cssSelector("#header-cart > div > button"));
		String numberItem = amountProduct.getText();
		String zeroItem = "0 item(s)";
		if(numberItem.contains(zeroItem)) {
		
			WebElement addToCartBtn = driver.findElement(By.cssSelector(
					"#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > form > div > button:nth-child(1)"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
			sleep(1000);
			
			addToCartBtn.click();
			sleep(2000);

			addToCartBtn.click();
			sleep(5000);
			
		}

		WebElement checkoutLink = driver
				.findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(5) > a"));
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
		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
		sleep(1000);
		
		WebElement amountProduct = driver.findElement(By.cssSelector("#header-cart > div > button"));
		String numberItem = amountProduct.getText();
		String zeroItem = "0 item(s)";
		if(numberItem.contains(zeroItem)) {
		
			WebElement addToCartBtn = driver.findElement(By.cssSelector(
					"#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > form > div > button:nth-child(1)"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
			sleep(1000);
			
			addToCartBtn.click();
			sleep(2000);

			addToCartBtn.click();
			sleep(5000);
			
		}

		WebElement checkoutLink = driver
				.findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(5) > a"));
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

		
		boolean isButtonPresent = driver.findElements(By.cssSelector("#button-confirm")).size() > 0;

		Assert.assertTrue("Confirm button vẫn có thể sử dụng", !isButtonPresent);
	}
	
	@Test
	public void testCheckoutEmptyInput() {
		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
		sleep(1000);
		
		WebElement amountProduct = driver.findElement(By.cssSelector("#header-cart > div > button"));
		String numberItem = amountProduct.getText();
		String zeroItem = "0 item(s)";
		if(numberItem.contains(zeroItem)) {
		
			WebElement addToCartBtn = driver.findElement(By.cssSelector(
					"#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > form > div > button:nth-child(1)"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
			sleep(1000);
			
			addToCartBtn.click();
			sleep(2000);

			addToCartBtn.click();
			sleep(5000);
			
		}

		WebElement checkoutLink = driver
				.findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(5) > a"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutLink);
		sleep(1000);
		checkoutLink.click();
		
		sleep(1000);
		WebElement shippingNew = driver.findElement(By.cssSelector("#input-shipping-new"));
		shippingNew.click();
		sleep(1000);

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

		WebElement warningFirstName = driver.findElement(By.cssSelector("#error-shipping-firstname"));
		Assert.assertTrue("Không hiển thị waring First Name", warningFirstName.isDisplayed());

		WebElement warningLastName = driver.findElement(By.cssSelector("#error-shipping-lastname"));
		Assert.assertTrue("Không hiển thị waring Last Name", warningLastName.isDisplayed());

		WebElement warningAddress_1 = driver.findElement(By.cssSelector("#error-shipping-address-1"));
		Assert.assertTrue("Không hiển thị warning Address 1", warningAddress_1.isDisplayed());

		WebElement warningCity = driver.findElement(By.cssSelector("#error-shipping-city"));
		Assert.assertTrue("Không hiển thị warning City", warningCity.isDisplayed());

		WebElement warningCoutry = driver.findElement(By.cssSelector("#error-shipping-country"));
		Assert.assertTrue("Không hiển thi warning Country", warningCoutry.isDisplayed());

		WebElement warningShippingZone = driver.findElement(By.cssSelector("#error-shipping-zone"));
		Assert.assertTrue("Không hiển thi warning Shipping Zone", warningShippingZone.isDisplayed());
	}
	
	@Test
	public void testAboveUpperBoundary() {
		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
		sleep(1000);
		
		WebElement amountProduct = driver.findElement(By.cssSelector("#header-cart > div > button"));
		String numberItem = amountProduct.getText();
		String zeroItem = "0 item(s)";
		if(numberItem.contains(zeroItem)) {
		
			WebElement addToCartBtn = driver.findElement(By.cssSelector(
					"#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > form > div > button:nth-child(1)"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
			sleep(1000);
			
			addToCartBtn.click();
			sleep(2000);

			addToCartBtn.click();
			sleep(5000);
			
		}

		WebElement checkoutLink = driver
				.findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(5) > a"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutLink);
		sleep(1000);
		checkoutLink.click();
		
		sleep(1000);
		WebElement shippingNew = driver.findElement(By.cssSelector("#input-shipping-new"));
		shippingNew.click();
		sleep(1000);

		String firstName = "AlexandriaCatherineElizabethMarieAnn";
		String lastName = "MontgomeryWilliamsonMacAllisterBrown";
		String company = "Company ABC";
		String address1 = "234 Elm Street, Apartment 56B, Greenfield, Ho Chi Minh City, Vietnam, 700000, Near Central Park, District 1";
		String address2 = "Quan 5";
		String city = "Ho Chi Minh City, a bustling metropolis in southern Vietnam known for its vibrant culture, delicious street food, and historical landmarks";
		String postCode = "700000";
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

		WebElement warningFirstName = driver.findElement(By.cssSelector("#error-shipping-firstname"));
		Assert.assertTrue("Không hiển thị waring First Name", warningFirstName.isDisplayed());

		WebElement warningLastName = driver.findElement(By.cssSelector("#error-shipping-lastname"));
		Assert.assertTrue("Không hiển thị waring Last Name", warningLastName.isDisplayed());

		WebElement warningAddress_1 = driver.findElement(By.cssSelector("#error-shipping-address-1"));
		Assert.assertTrue("Không hiển thị warning Address 1", warningAddress_1.isDisplayed());

		WebElement warningCity = driver.findElement(By.cssSelector("#error-shipping-city"));
		Assert.assertTrue("Không hiển thị warning City", warningCity.isDisplayed());

		WebElement warningCoutry = driver.findElement(By.cssSelector("#error-shipping-country"));
		Assert.assertTrue("Không hiển thi warning Country", warningCoutry.isDisplayed());

		WebElement warningShippingZone = driver.findElement(By.cssSelector("#error-shipping-zone"));
		Assert.assertTrue("Không hiển thi warning Shipping Zone", warningShippingZone.isDisplayed());
	}
	
	@Test
	public void testUnderLowerBoundary() {
		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
		sleep(1000);
		
		WebElement amountProduct = driver.findElement(By.cssSelector("#header-cart > div > button"));
		String numberItem = amountProduct.getText();
		String zeroItem = "0 item(s)";
		if(numberItem.contains(zeroItem)) {
		
			WebElement addToCartBtn = driver.findElement(By.cssSelector(
					"#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > form > div > button:nth-child(1)"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
			sleep(1000);
			
			addToCartBtn.click();
			sleep(2000);

			addToCartBtn.click();
			sleep(5000);
			
		}

		WebElement checkoutLink = driver
				.findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(5) > a"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutLink);
		sleep(1000);
		checkoutLink.click();
		
		sleep(1000);
		WebElement shippingNew = driver.findElement(By.cssSelector("#input-shipping-new"));
		shippingNew.click();
		sleep(1000);
		
		String firstName = "";
		String lastName = "";
		String company = "Company ABC";
		String address1 = "Q1";
		String address2 = "Quan 5";
		String city = "S";
		String postCode = "700000";
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

		WebElement warningFirstName = driver.findElement(By.cssSelector("#error-shipping-firstname"));
		Assert.assertTrue("Không hiển thị waring First Name", warningFirstName.isDisplayed());

		WebElement warningLastName = driver.findElement(By.cssSelector("#error-shipping-lastname"));
		Assert.assertTrue("Không hiển thị waring Last Name", warningLastName.isDisplayed());

		WebElement warningAddress_1 = driver.findElement(By.cssSelector("#error-shipping-address-1"));
		Assert.assertTrue("Không hiển thị warning Address 1", warningAddress_1.isDisplayed());

		WebElement warningCity = driver.findElement(By.cssSelector("#error-shipping-city"));
		Assert.assertTrue("Không hiển thị warning City", warningCity.isDisplayed());

		WebElement warningCoutry = driver.findElement(By.cssSelector("#error-shipping-country"));
		Assert.assertTrue("Không hiển thi warning Country", warningCoutry.isDisplayed());

		WebElement warningShippingZone = driver.findElement(By.cssSelector("#error-shipping-zone"));
		Assert.assertTrue("Không hiển thi warning Shipping Zone", warningShippingZone.isDisplayed());
	}
	
	@Test
	public void testLowerBoundary() {
		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
		sleep(1000);
		
		WebElement amountProduct = driver.findElement(By.cssSelector("#header-cart > div > button"));
		String numberItem = amountProduct.getText();
		String zeroItem = "0 item(s)";
		if(numberItem.contains(zeroItem)) {
		
			WebElement addToCartBtn = driver.findElement(By.cssSelector(
					"#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > form > div > button:nth-child(1)"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
			sleep(1000);
			
			addToCartBtn.click();
			sleep(2000);

			addToCartBtn.click();
			sleep(5000);
			
		}

		WebElement checkoutLink = driver
				.findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(5) > a"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutLink);
		sleep(1000);
		checkoutLink.click();
		
		sleep(1000);
		WebElement shippingNew = driver.findElement(By.cssSelector("#input-shipping-new"));
		shippingNew.click();
		sleep(1000);
		
		String firstName = "A";
		String lastName = "B";
		String company = "Company ABC";
		String address1 = "Q.1";
		String address2 = "Quan 5";
		String city = "SG";
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

		WebElement warningFirstName = driver.findElement(By.cssSelector("#error-shipping-firstname"));
		Assert.assertTrue("Không hiển thị waring First Name", !warningFirstName.isDisplayed());

		WebElement warningLastName = driver.findElement(By.cssSelector("#error-shipping-lastname"));
		Assert.assertTrue("Không hiển thị waring Last Name", !warningLastName.isDisplayed());

		WebElement warningAddress_1 = driver.findElement(By.cssSelector("#error-shipping-address-1"));
		Assert.assertTrue("Không hiển thị warning Address 1", !warningAddress_1.isDisplayed());

		WebElement warningCity = driver.findElement(By.cssSelector("#error-shipping-city"));
		Assert.assertTrue("Không hiển thị warning City", !warningCity.isDisplayed());

		WebElement warningCoutry = driver.findElement(By.cssSelector("#error-shipping-country"));
		Assert.assertTrue("Không hiển thi warning Country", !warningCoutry.isDisplayed());

		WebElement warningShippingZone = driver.findElement(By.cssSelector("#error-shipping-zone"));
		Assert.assertTrue("Không hiển thi warning Shipping Zone", !warningShippingZone.isDisplayed());
	}
	
	@Test
	public void testUpperBoundary() {
		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
		sleep(1000);
		
		WebElement amountProduct = driver.findElement(By.cssSelector("#header-cart > div > button"));
		String numberItem = amountProduct.getText();
		String zeroItem = "0 item(s)";
		if(numberItem.contains(zeroItem)) {
		
			WebElement addToCartBtn = driver.findElement(By.cssSelector(
					"#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > form > div > button:nth-child(1)"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
			sleep(1000);
			
			addToCartBtn.click();
			sleep(2000);

			addToCartBtn.click();
			sleep(5000);
			
		}

		WebElement checkoutLink = driver
				.findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(5) > a"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutLink);
		sleep(1000);
		checkoutLink.click();
		
		sleep(1000);
		WebElement shippingNew = driver.findElement(By.cssSelector("#input-shipping-new"));
		shippingNew.click();
		sleep(1000);
		
		String firstName = "TranThiKimHoaNguyen";
		String lastName = "NguyenVanThanhBinh";
		String company = "Company ABC";
		String address1 = "1234 Nguyen Thi Minh Khai Street, District 3, Ho Chi Minh City, Vietnam, 700000, located near the famous Ben Thanh Market.";
		String address2 = "Quan 5";
		String city = "Ho Chi Minh City, a vibrant metropolis known for its rich culture, delicious street food, and historical landmarks.";
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

		WebElement warningFirstName = driver.findElement(By.cssSelector("#error-shipping-firstname"));
		Assert.assertTrue("Không hiển thị waring First Name", !warningFirstName.isDisplayed());

		WebElement warningLastName = driver.findElement(By.cssSelector("#error-shipping-lastname"));
		Assert.assertTrue("Không hiển thị waring Last Name", !warningLastName.isDisplayed());

		WebElement warningAddress_1 = driver.findElement(By.cssSelector("#error-shipping-address-1"));
		Assert.assertTrue("Không hiển thị warning Address 1", !warningAddress_1.isDisplayed());

		WebElement warningCity = driver.findElement(By.cssSelector("#error-shipping-city"));
		Assert.assertTrue("Không hiển thị warning City", !warningCity.isDisplayed());

		WebElement warningCoutry = driver.findElement(By.cssSelector("#error-shipping-country"));
		Assert.assertTrue("Không hiển thi warning Country", !warningCoutry.isDisplayed());

		WebElement warningShippingZone = driver.findElement(By.cssSelector("#error-shipping-zone"));
		Assert.assertTrue("Không hiển thi warning Shipping Zone", !warningShippingZone.isDisplayed());
	}
	
	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
