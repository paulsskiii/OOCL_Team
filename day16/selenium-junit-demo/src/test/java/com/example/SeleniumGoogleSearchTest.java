package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

class SeleniumGoogleSearchTest {

    private WebDriver driver;

    @BeforeAll
    static void setupClass() {
        // downloads matching chromedriver automatically
//        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
    }

    @BeforeEach
    void setupTest() {
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--start-maximized"); // optional
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
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

    /*TEST CASES
    User will have single order and checkout
    SC1: When a user logs in, they will browse the products
         Then user will filter by price from lowest to highest
         Then add an item to the cart and proceed to your cart
         And then checkout page
         The user will enter their information and redirected to the checkout overview for confirmation
         User clicks finish then redirected to successs page and then log out
    */

    /*
    Multiple orders
     SC2: When a user logs in, they will browse the products
         Then add an item to the cart and proceed to your cart
         And then continue shopping
         Then add an item to the cart and proceed to your cart
         And then checkout page
         The user will enter their information and redirected to the checkout overview for confirmation
         User clicks finish then redirected to successs page  and then log out

     Mutiple but remove one order
     SC3: When a user logs in, they will browse the products
         Then add multiple item to the cart and proceed to your cart
         Then will remove one item from cart before proceeding to checkout page
         The user will enter their information and redirected to the checkout overview for confirmation
         User clicks finish then redirected to successs page and then log out

      Mutiple but cancel
     SC4: When a user logs in, they will browse the products
         Then add multiple item to the cart and proceed to your cart
         Then proceed to checkout page
         The user will enter their information and redirected to the checkout overview for confirmation
         User will cancel and then log out

     Checkout with no item
     SC5: When a user logs in, they will browse the products
         Then proceed to your cart
         Then proceed to checkout page
         The user will enter their information and redirected to the checkout overview for confirmation
         User will confirm then redirected to successs page and then log out
    * */

}
