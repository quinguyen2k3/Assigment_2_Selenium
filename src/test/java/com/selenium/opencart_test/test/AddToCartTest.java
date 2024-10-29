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

	@Test
	public void testAddOneToCart() {

		driver.get("http://localhost/opencartsite/");

		sleep(5000);

		WebElement addToCartButton = driver.findElement(By.cssSelector(
				"#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > form > div > button:nth-child(1)"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton);
		sleep(1000);

		addToCartButton.click();

		sleep(5000);

		WebElement successMessage = driver.findElement(By.cssSelector("#alert > div"));
		Assert.assertTrue("Thông báo thành công không hiển thị!", successMessage.isDisplayed());
		Assert.assertTrue("Không tìm thấy thông báo chứa tên sản phẩm!", successMessage.getText().contains("iPhone"));

	}

	@Test
	public void testAddMultiToCart() {

		driver.get("http://localhost/opencartsite/");

		sleep(5000);

		WebElement addToCartButton = driver.findElement(By.cssSelector(
				"#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > form > div > button:nth-child(1)"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton);
		sleep(1000);

		addToCartButton.click();

		sleep(5000);

		addToCartButton.click();

		sleep(5000);

		WebElement cartButton = driver.findElement(By.cssSelector("#header-cart > div > button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartButton);
		sleep(1000);

		cartButton.click();

		sleep(5000);

		WebElement productName = driver.findElement(
				By.cssSelector("#header-cart > div > ul > li > table > tbody > tr:nth-child(1) > td.text-start > a"));
		String nameActual = productName.getText();

		WebElement productQuantity = driver.findElement(
				By.cssSelector("#header-cart > div > ul > li > table > tbody > tr:nth-child(1) > td:nth-child(3)"));
		int quantityActual = Integer.parseInt(productQuantity.getText().replace("x", "").trim());

		String nameExpected = "iPhone";
		int quantityExpected = 2;

		Assert.assertEquals("Khác nhau số lượng", quantityExpected, quantityActual);
		Assert.assertEquals("Khác nhau về tên sản phẩm", nameExpected, nameActual);

	}

	@Test
	public void testAddDifferentProductToCart() throws AWTException {

		driver.get("http://localhost/opencartsite/");

		sleep(3000);

		WebElement addToCartButton_1 = driver.findElement(By.cssSelector(
				"#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > form > div > button:nth-child(1)"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton_1);
		sleep(1000);

		addToCartButton_1.click();

		sleep(5000);

		WebElement addToCartButton_2 = driver.findElement(By.cssSelector(
				"#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(3) > div > div.content > form > div > button:nth-child(1)"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton_2);
		sleep(000);

		addToCartButton_2.click();

		sleep(3000);

		WebElement size = driver.findElement(By.cssSelector("#input-option-value-5"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", size);
		sleep(1000);

		size.click();

		sleep(1000);

		WebElement checkbox_1 = driver.findElement(By.cssSelector("#input-option-value-9"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox_1);
		sleep(1000);
		checkbox_1.click();

		sleep(1000);

		WebElement text = driver.findElement(By.cssSelector("#input-option-208"));
		text.sendKeys("TEST OPTION");

		sleep(1000);

		WebElement dropdown = driver.findElement(By.cssSelector("#input-option-217"));
		Select selection = new Select(dropdown);

		selection.selectByVisibleText("Red (+$6.80)");

		sleep(1000);

		WebElement textarea = driver.findElement(By.cssSelector("#input-option-209"));
		textarea.sendKeys("TEST TEST AREA");

		sleep(1000);

		String filePath = "C:" + File.separator + "Users" + File.separator + "ADMIN" + File.separator + "Pictures"
				+ File.separator + "Saved Pictures" + File.separator + "tomato.jpg";

		WebElement uploadButton = driver.findElement(By.cssSelector("#button-upload-222"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", uploadButton);
		sleep(1000);

		uploadButton.click();

		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		Robot robot = new Robot();

		sleep(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		sleep(2000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		sleep(1000);

		Alert alert = driver.switchTo().alert();
		alert.accept();

		sleep(1000);

		WebElement submit = driver.findElement(By.cssSelector("#button-cart"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submit);
		sleep(2000);

		submit.click();

		sleep(1000);

		WebElement cartButton = driver.findElement(By.cssSelector("#header-cart > div > button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartButton);
		sleep(5000);

		cartButton.click();

		sleep(5000);

		WebElement productIphoneName = driver.findElement(
				By.cssSelector("#header-cart > div > ul > li > table > tbody > tr:nth-child(1) > td.text-start > a"));
		String iphoneNameActual = productIphoneName.getText();

		WebElement productIphoneQuantity = driver.findElement(
				By.cssSelector("#header-cart > div > ul > li > table > tbody > tr:nth-child(1) > td:nth-child(3)"));
		int iphoneQuantityActual = Integer.parseInt(productIphoneQuantity.getText().replace("x", "").trim());

		String iphoneNameExpected = "iPhone";
		int iphoneQuantityExpected = 1;

		WebElement productAppleName = driver.findElement(
				By.cssSelector("#header-cart > div > ul > li > table > tbody > tr:nth-child(2) > td.text-start > a"));
		String appleNameActual = productAppleName.getText();

		WebElement productAppleQuantity = driver.findElement(
				By.cssSelector("#header-cart > div > ul > li > table > tbody > tr:nth-child(2) > td:nth-child(3)"));
		int appleQuantityActual = Integer.parseInt(productAppleQuantity.getText().replace("x", "").trim());

		String appleNameExpected = "Apple Cinema 30\"";
		int appleQuantityExpected = 2;

		Assert.assertEquals("Khác nhau số lượng", iphoneQuantityExpected, iphoneQuantityActual);
		Assert.assertEquals("Khác nhau về tên sản phẩm", iphoneNameExpected, iphoneNameActual);

		Assert.assertEquals("Khác nhau số lượng", appleQuantityExpected, appleQuantityActual);
		Assert.assertEquals("Khác nhau về tên sản phẩm", appleNameExpected, appleNameActual);

	}

	@Test
	public void testAddToCartWithInvalidQuantity() {
		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
		sleep(2000);

		WebElement productLink = driver.findElement(By.cssSelector(
				"#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > div > h4 > a"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productLink);
		sleep(1000);

		productLink.click();
		sleep(1000);

		WebElement inputQuantity = driver.findElement(By.cssSelector("#input-quantity"));

		inputQuantity.clear();
		inputQuantity.sendKeys("1000");

		sleep(1000);

		WebElement addToCartBtn = driver.findElement(By.cssSelector("#button-cart"));
		addToCartBtn.click();

		WebElement errorMessage = driver.findElement(By.className("alert-danger"));
		Assert.assertTrue("Thông báo lỗi không hiển thị khi nhập số lượng âm", errorMessage.isDisplayed());
		Assert.assertEquals("Expected error message here", errorMessage.getText());

		sleep(5000);

		inputQuantity.clear();
		inputQuantity.sendKeys("abc");
		addToCartBtn.click();

		errorMessage = driver.findElement(By.className("alert-danger"));
		Assert.assertTrue("Thông báo lỗi không hiển thị khi nhập số lượng không hợp lệ", errorMessage.isDisplayed());
		Assert.assertEquals("Expected error message here", errorMessage.getText());

	}

	@Test
	public void testTotalAfterAddMulti() {
		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
		sleep(2000);

		WebElement linkIphone = driver.findElement(By.cssSelector(
				"#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > div > h4 > a"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkIphone);
		sleep(1000);

		linkIphone.click();
		sleep(1000);

		WebElement inputIphone = driver.findElement(By.cssSelector("#input-quantity"));

		inputIphone.clear();
		inputIphone.sendKeys("100");

		sleep(1000);

		WebElement addToCartIphone = driver.findElement(By.cssSelector("#button-cart"));
		addToCartIphone.click();

		sleep(2000);

		WebElement homeBtn = driver.findElement(By.cssSelector("#logo"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homeBtn);
		sleep(1000);

		homeBtn.click();

		sleep(2000);

		WebElement macbookLink = driver.findElement(By.cssSelector(
				"#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(1) > div > div.content > div > h4 > a"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", macbookLink);
		sleep(1000);

		macbookLink.click();
		sleep(1000);

		WebElement inputMacbook = driver.findElement(By.cssSelector("#input-quantity"));

		inputMacbook.clear();
		inputMacbook.sendKeys("100");

		sleep(1000);

		WebElement addToCartMacbook = driver.findElement(By.cssSelector("#button-cart"));
		addToCartMacbook.click();

		sleep(5000);

		WebElement cartLink = driver
				.findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(4) > a"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartLink);
		sleep(1000);

		cartLink.click();

		sleep(5000);

		double iphoneTotalExpected = 12320;
		double macbookTotalExpected = 60200;

		double subTotalExpected = iphoneTotalExpected + macbookTotalExpected;
		double ecoTaxExpected = 2.00 * 200.00;

		double vatExpected = 0.2 * subTotalExpected;

		double totalExpected = subTotalExpected + ecoTaxExpected + vatExpected;

		WebElement totalIphone = driver.findElement(
				By.cssSelector("#shopping-cart > div > table > tbody > tr:nth-child(1) > td:nth-child(6)"));
		double totalIphoneActual = Double.parseDouble(totalIphone.getText().replace("$", "").replace(",", ""));

		WebElement totalMacBook = driver.findElement(
				By.cssSelector("#shopping-cart > div > table > tbody > tr:nth-child(2) > td:nth-child(6)"));
		double totalMacBookActual = Double.parseDouble(totalMacBook.getText().replace("$", "").replace(",", ""));

		WebElement subTotal = driver.findElement(By.cssSelector("#checkout-total > tr:nth-child(1) > td:nth-child(2)"));
		double subTotalActual = Double.parseDouble(subTotal.getText().replace("$", "").replace(",", ""));

		WebElement ecoTax = driver.findElement(By.cssSelector("#checkout-total > tr:nth-child(2) > td:nth-child(2)"));
		double ecoTaxActual = Double.parseDouble(ecoTax.getText().replace("$", "").replace(",", ""));

		WebElement vat = driver.findElement(By.cssSelector("#checkout-total > tr:nth-child(3) > td:nth-child(2)"));
		double vatActual = Double.parseDouble(vat.getText().replace("$", "").replace(",", ""));

		WebElement total = driver.findElement(By.cssSelector("#checkout-total > tr:nth-child(4) > td:nth-child(2)"));
		double totalActual = Double.parseDouble(total.getText().replace("$", "").replace(",", ""));

		Assert.assertEquals("Giá trị tổng iPhone không khớp", iphoneTotalExpected, totalIphoneActual, 0.001);

		Assert.assertEquals("Giá trị tổng MacBook không khớp", macbookTotalExpected, totalMacBookActual, 0.001);

		Assert.assertEquals("Giá trị tổng phụ không khớp", subTotalExpected, subTotalActual, 0.001);

		Assert.assertEquals("Giá trị Eco Tax không khớp", ecoTaxExpected, ecoTaxActual, 0.001);

		Assert.assertEquals("Giá trị VAT không khớp", vatExpected, vatActual, 0.001);

		Assert.assertEquals("Giá trị tổng không khớp", totalExpected, totalActual, 0.001);

	}

	@Test
	public void testUpdateAndDeleteProduct() {
		driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
		sleep(2000);

		WebElement linkIphone = driver.findElement(By.cssSelector(
				"#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > div > h4 > a"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkIphone);
		sleep(1000);

		linkIphone.click();
		sleep(1000);

		WebElement inputIphone = driver.findElement(By.cssSelector("#input-quantity"));

		inputIphone.clear();
		inputIphone.sendKeys("100");

		sleep(1000);

		WebElement addToCartIphone = driver.findElement(By.cssSelector("#button-cart"));
		addToCartIphone.click();

		sleep(2000);

		WebElement homeBtn = driver.findElement(By.cssSelector("#logo"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homeBtn);
		sleep(1000);

		homeBtn.click();

		sleep(2000);

		WebElement macbookLink = driver.findElement(By.cssSelector(
				"#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(1) > div > div.content > div > h4 > a"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", macbookLink);
		sleep(1000);

		macbookLink.click();
		sleep(1000);

		WebElement inputMacbook = driver.findElement(By.cssSelector("#input-quantity"));

		inputMacbook.clear();
		inputMacbook.sendKeys("100");

		sleep(1000);

		WebElement addToCartMacbook = driver.findElement(By.cssSelector("#button-cart"));
		addToCartMacbook.click();

		sleep(5000);

		WebElement cartLink = driver
				.findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(4) > a"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartLink);
		sleep(1000);

		cartLink.click();	

		sleep(2000);

		WebElement deleteBtn = driver.findElement(By.cssSelector(
				"#shopping-cart > div > table > tbody > tr:nth-child(2) > td:nth-child(4) > form > div > button.btn.btn-danger"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deleteBtn);
		sleep(1000);

		deleteBtn.click();

		sleep(1000);

		WebElement deleteAlert = driver.findElement(By.cssSelector("#alert > div"));
		
		
		Assert.assertTrue("Thông báo thành công không hiển thị", deleteAlert.isDisplayed());
		
		sleep(2000);

		List<WebElement> rows = driver.findElements(By.cssSelector("#shopping-cart > div > table > tbody > tr > td.text-start.text-wrap"));
		
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
	
		sleep(5000);
		
		boolean productExists = true;
		for (WebElement row : rows) {
			String productName = row.findElement(By.cssSelector("a")).getText();
			if (productName.equals("MacBook")) {
				productExists = false;
				break;
			}
		}
		
		Assert.assertTrue("Sản phẩm 'MacBook' không được xóa thành công", productExists);
		
		sleep(1000);
		
		WebElement updateQuantity = driver.findElement(By.cssSelector(
				"#shopping-cart > div > table > tbody > tr:nth-child(1) > td:nth-child(4) > form > div > input.form-control"));
		updateQuantity.clear();

		sleep(1000);

		updateQuantity.sendKeys("50");
		
		sleep(1000);
		
		WebElement updateBtn =driver.findElement(By.cssSelector("#shopping-cart > div > table > tbody > tr > td:nth-child(4) > form > div > button.btn.btn-primary"));		
		updateBtn.click();
		
		sleep(2000);
		
		WebElement updateAlert = driver.findElement(By.cssSelector("#alert > div"));
		
		Assert.assertTrue("Thông báo thành công không hiển thị", updateAlert.isDisplayed());
		
		sleep(5000);
		
		double iphoneTotalExpected = 123.20 * 50;
		

		double subTotalExpected = iphoneTotalExpected ;
		
		double ecoTaxExpected = 2.00 * 50;

		double vatExpected = 0.2 * subTotalExpected;

		double totalExpected = subTotalExpected + ecoTaxExpected + vatExpected;

		WebElement totalIphone = driver.findElement(
				By.cssSelector("#shopping-cart > div > table > tbody > tr > td:nth-child(6)"));
		double totalIphoneActual = Double.parseDouble(totalIphone.getText().replace("$", "").replace(",", ""));
	

		WebElement subTotal = driver.findElement(By.cssSelector("#checkout-total > tr:nth-child(1) > td:nth-child(2)"));
		double subTotalActual = Double.parseDouble(subTotal.getText().replace("$", "").replace(",", ""));

		WebElement ecoTax = driver.findElement(By.cssSelector("#checkout-total > tr:nth-child(2) > td:nth-child(2)"));
		double ecoTaxActual = Double.parseDouble(ecoTax.getText().replace("$", "").replace(",", ""));

		WebElement vat = driver.findElement(By.cssSelector("#checkout-total > tr:nth-child(3) > td:nth-child(2)"));
		double vatActual = Double.parseDouble(vat.getText().replace("$", "").replace(",", ""));

		WebElement total = driver.findElement(By.cssSelector("#checkout-total > tr:nth-child(4) > td:nth-child(2)"));
		double totalActual = Double.parseDouble(total.getText().replace("$", "").replace(",", ""));

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
