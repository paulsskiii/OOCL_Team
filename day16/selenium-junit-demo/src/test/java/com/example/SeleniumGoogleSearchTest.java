package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;

import java.beans.Transient;
import java.time.Duration;

import org.openqa.selenium.edge.EdgeDriver;

class SeleniumGoogleSearchTest {

    private WebDriver driver;

    @BeforeAll
    static void setupClass() {
        // downloads matching chromedriver automatically
        // WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.edge.driver", "C://msedgedriver.exe");
    }

    @BeforeEach
    void setupTest() {
        // ChromeOptions options = new ChromeOptions();
        // options.addArguments("--start-maximized"); // optional
        // driver = new ChromeDriver(options);
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver = new EdgeDriver();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    void login() throws InterruptedException {
        driver.get("https://www.saucedemo.com/v1/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='user-name']")));

        WebElement usernameBox = driver.findElement(By.xpath("//input[@id='user-name']"));
        usernameBox.sendKeys("standard_user");
        Thread.sleep(1000); // small pause as requested

        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='password']"));
        passwordBox.sendKeys("secret_sauce");
        Thread.sleep(1000); // small pause

        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product_label']")));

        Thread.sleep(5_000);
    }

    @Test
    @DisplayName("Login to SauceDemo and validate each action")
    void testSauceDemoLoginAndValidateEachAction() throws InterruptedException {
        // 1) Open SauceDemo (you gave /v1/)
        driver.get("https://www.saucedemo.com/v1/");

        // short explicit wait for the username field to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='user-name']")));

        // VALIDATION: URL contains saucedemo
        Assertions.assertTrue(driver.getCurrentUrl().contains("saucedemo"),
                "Page URL should contain 'saucedemo'");

        // 2) Enter username
        WebElement usernameBox = driver.findElement(By.xpath("//input[@id='user-name']"));
        usernameBox.sendKeys("standard_user");
        Thread.sleep(1000); // small pause as requested
        Assertions.assertEquals("standard_user", usernameBox.getAttribute("value"),
                "Username field should contain the entered username");

        // 3) Enter password
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='password']"));
        passwordBox.sendKeys("secret_sauce");
        Thread.sleep(1000); // small pause
        Assertions.assertEquals("secret_sauce", passwordBox.getAttribute("value"),
                "Password field should contain the entered password");

        // 4) Click login button
        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginBtn.click();

        // wait until the inventory/products page is visible: in /v1/ the header has class "product_label"
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product_label']")));

        // VALIDATION: page shows "Products"
        WebElement title = driver.findElement(By.className("product_label"));
        Assertions.assertEquals("Products", title.getText(),
                "After login, the page should show 'Products'");

        // WAIT 20 seconds (per your request) then test ends and @AfterEach will quit the browser
        Thread.sleep(5_000);
    }

    @Test
    @DisplayName("Add items to cart after login")
    void testSauceDemoAddItemsToCartAfterLogin() throws InterruptedException {
        login();
        
        WebElement addToCartBtn = driver.findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[3]//button[1]"));
        addToCartBtn.click();

        Thread.sleep(1_000);

        WebElement checkCartBtn = driver.findElement(By.xpath("//*[name()='path' and contains(@fill,'currentCol')]"));
        checkCartBtn.click();

        WebElement cartTitle = driver.findElement(By.xpath("//div[@class='subheader']"));
        Assertions.assertEquals("Your Cart", cartTitle.getText());
        Thread.sleep(5_000);
    }

    @Test
    @DisplayName("Checkout Items after adding to cart")
    void testSauceDemoCheckoutItemsAfterAddingtoCart() throws InterruptedException {
        login();

        WebElement addToCartBtn = driver.findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[3]//button[1]"));
        addToCartBtn.click();

        Thread.sleep(1_000);

        WebElement checkCartBtn = driver.findElement(By.xpath("//*[name()='path' and contains(@fill,'currentCol')]"));
        checkCartBtn.click();

        WebElement checkoutBtn = driver.findElement(By.xpath("//a[@class='btn_action checkout_button']"));
        checkoutBtn.click();

        Thread.sleep(1_000);
    }
    
    
    @Test
    @DisplayName("Place order for delivery")
    void testSauceDemoPlaceOrderForDelivery() throws InterruptedException {
        login();

        WebElement addToCartBtn = driver.findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[3]//button[1]"));
        addToCartBtn.click();

        Thread.sleep(1_000);

        WebElement checkCartBtn = driver.findElement(By.xpath("//*[name()='path' and contains(@fill,'currentCol')]"));
        checkCartBtn.click();

        WebElement checkoutBtn = driver.findElement(By.xpath("//a[@class='btn_action checkout_button']"));
        checkoutBtn.click();

        Thread.sleep(1_000);

        WebElement firstnameBox = driver.findElement(By.xpath("//input[@id='first-name']"));
        firstnameBox.sendKeys("group3");
        Thread.sleep(1000); 
        Assertions.assertEquals("group3", firstnameBox.getAttribute("value"));

        WebElement lastnameBox = driver.findElement(By.xpath("//input[@id='last-name']"));
        lastnameBox.sendKeys("week4");
        Thread.sleep(1000); 
        Assertions.assertEquals("week4", lastnameBox.getAttribute("value"));

        WebElement postalCodeBox = driver.findElement(By.xpath("//input[@id='postal-code']"));
        postalCodeBox.sendKeys("1600");
        Thread.sleep(1000); 
        Assertions.assertEquals("1600", postalCodeBox.getAttribute("value"));

        WebElement continueBtn = driver.findElement(By.xpath("//input[@value='CONTINUE']"));
        continueBtn.click();
        Thread.sleep(1_000);

        WebElement checkoutTitle = driver.findElement(By.xpath("//div[@class='subheader']"));
        Assertions.assertEquals("Checkout: Overview", checkoutTitle.getText());
        Thread.sleep(5_000);

        WebElement finishBtn = driver.findElement(By.xpath("//a[@class='btn_action cart_button']"));
        finishBtn.click();
        Thread.sleep(1_000);

        WebElement finishTitle = driver.findElement(By.xpath("//div[@class='subheader']"));
        Assertions.assertEquals("Finish", finishTitle.getText());
        Thread.sleep(5_000);

        driver.close();
    }


    // @Test
    // @DisplayName("Remove added item from Product page")
    // void testSauceDemoRemoveAddedItemFromProductPage() throws InterruptedException {
    //     testSauceDemoLoginAndValidateEachAction();

    //     WebElement addToCartBtn = driver.findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[3]//button[1]"));
    //     addToCartBtn.click();

    //     Thread.sleep(1_000);

    //     WebElement removeAddedToCartBtn = driver.findElement(By.xpath("//button[@class='btn_secondary btn_inventory']"));
    //     addToCartBtn.click();

    //     Thread.sleep(1_000);

    //     driver.close();
    // }

}
