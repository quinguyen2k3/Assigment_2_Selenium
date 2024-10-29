package com.selenium.opencart_test.test;

import java.time.Duration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResponsiveTest {
	private WebDriver driver;
    private WebDriverWait wait;

    private int[][] screenSizes = {
    	    {1920, 1080},  // Desktop Full HD
    	    {2560, 1440},  // Quad HD Desktop
    	    {1366, 768},   // Laptop phổ biến HD
    	    {1536, 864},   // Laptop phổ thông
    	    {768, 1024},   // iPad Mini portrait
    	    {1024, 768},   // iPad Mini landscape
    	    {834, 1112},   // iPad Air portrait
    	    {1112, 834},   // iPad Air landscape
    	    {375, 667},    // iPhone 6/7/8 portrait
    	    {414, 896},    // iPhone XR/11 portrait
    	    {390, 844},    // iPhone 12/13 portrait
    	    {360, 640}     // Samsung Galaxy S10 portrait
    	};

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
    public void testResponsiveDesign() {
        for (int[] screenSize : screenSizes) {
            int width = screenSize[0];
            int height = screenSize[1];

            driver.manage().window().setSize(new Dimension(width, height));
            driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
            
            sleep(2000);

            try {
                WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("header")));
                Assert.assertTrue("Header không hiển thị tại kích thước " + width + "x" + height, header.isDisplayed());

                WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search")));
                Assert.assertTrue("Search box không hiển thị tại kích thước " + width + "x" + height, searchBox.isDisplayed());

                WebElement menuToggle = driver.findElement(By.cssSelector("button.navbar-toggler"));
                if (width < 768) {
                    Assert.assertTrue("Menu không hiển thị dưới dạng mobile toggle tại kích thước " + width + "x" + height,
                        menuToggle.isDisplayed());
                } else {
                    Assert.assertFalse("Menu toggle hiển thị ở kích thước desktop " + width + "x" + height,
                        menuToggle.isDisplayed());
                }

            } catch (Exception e) {
                Assert.fail("Test thất bại tại kích thước " + width + "x" + height + ": " + e.getMessage());
            }
        }
    }
    
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
