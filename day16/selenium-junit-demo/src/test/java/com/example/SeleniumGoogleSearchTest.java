package com.example;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class SeleniumGoogleSearchTest {

    public void loginUser(String username, String password) throws InterruptedException{
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
        usernameBox.sendKeys(username);
        Thread.sleep(1000); // small pause as requested
        Assertions.assertEquals(username, usernameBox.getAttribute("value"),
                "Username field should contain the entered username");

        // 3) Enter password
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='password']"));
        passwordBox.sendKeys(password);
        Thread.sleep(1000); // small pause
        Assertions.assertEquals(password, passwordBox.getAttribute("value"),
                "Password field should contain the entered password");

        // 4) Click login button
        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginBtn.click();
    }

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeAll
    static void setupClass() {
        // downloads matching chromedriver automatically
        //WebDriverManager.chromedriver().setup();
        System.setProperty ("webdriver.edge.driver", "C://edgedriver_win64//msedgedriver.exe");
    }

    @BeforeEach
    void setupTest() {
        //ChromeOptions options = new ChromeOptions();
        // options.addArguments("--start-maximized"); // optional
        // driver = new ChromeDriver(options);
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        EdgeOptions options = new EdgeOptions();
        options.addArguments ("--start-maximized");
        driver = new EdgeDriver(options);
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

        loginUser("standard_user", "secret_sauce");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // wait until the inventory/products page is visible: in /v1/ the header has class "product_label"
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product_label']")));

        // VALIDATION: page shows "Products"
        WebElement title = driver.findElement(By.className("product_label"));
        Assertions.assertEquals("Products", title.getText(),
                "After login, the page should show 'Products'");

        // WAIT 20 seconds (per your request) then test ends and @AfterEach will quit the browser
        Thread.sleep(3_000);
    }

    @Test
    @DisplayName("Login locked out user")
    void given_locked_out_user_credentials_when_attempt_log_in_then_deny_login() throws InterruptedException {
        loginUser("locked_out_user", "secret_sauce");

        // VALIDATION: page shows "Epic sadface"
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/h3"));
        Assertions.assertEquals("Epic sadface: Sorry, this user has been locked out.", errorMessage.getText(),
                "After login attempt, the page should show error");

        Thread.sleep(3_000);
    }

    @Test
    @DisplayName ("Add to cart")
    void given_logged_in_when_add_item_to_cart_then_populate_cart () throws InterruptedException {
        loginUser("standard_user", "secret_sauce");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product_label']")));

        Thread.sleep(1_500);

        WebElement addToCartBtn = driver.findElement (By.xpath ("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button"));
        addToCartBtn.click ();

        Thread.sleep(500);
        
        WebElement cartCount = driver.findElement (By.xpath ("//*[@id=\"shopping_cart_container\"]/a/span"));
        assertEquals("1", cartCount.getText ());

        Thread.sleep(2_000);

        // WebElement cartHref = driver.findElement (By.xpath ("//*[@id=\"shopping_cart_container\"]/a"));
        // cartHref.click ();
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contents_wrapper\"]/div[2]")));
    }

    @Test
    @DisplayName ("Remove from cart")
    void given_logged_in_when_remove_item_from_cart_then_depopulate_cart () throws InterruptedException {
        loginUser("standard_user", "secret_sauce");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product_label']")));

        Thread.sleep(1_500);

        WebElement addToCartBtn = driver.findElement (By.xpath ("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button"));
        addToCartBtn.click ();

        Thread.sleep(1_000);

        WebElement removeFromCartBtn = driver.findElement (By.xpath ("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button"));
        removeFromCartBtn.click ();
        Thread.sleep(1_000);

        // WebElement cartCount = driver.findElement (By.xpath ("//*[@id=\"shopping_cart_container\"]/a/span"));
        // assertNull(cartCount.getText ());

        WebElement addToCartBtnAfter = driver.findElement (By.xpath ("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button"));
        assertEquals ("ADD TO CART", addToCartBtnAfter.getText (), "After removing, button display 'ADD TO CART' again");

        Thread.sleep(2_000);

        // WebElement cartHref = driver.findElement (By.xpath ("//*[@id=\"shopping_cart_container\"]/a"));
        // cartHref.click ();
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contents_wrapper\"]/div[2]")));
    }
 
    @Test
    @DisplayName("Sort items")
    void given_logged_in_and_sorted_by_name_desc() throws InterruptedException {
        loginUser("standard_user", "secret_sauce");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // wait until the inventory/products page is visible: in /v1/ the header has class "product_label"
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product_label']")));

        WebElement sort = driver.findElement(By.className("product_sort_container"));
        sort.click();
        Thread.sleep(2_000);

        WebElement descOrder = driver.findElement(By.xpath("//*[@id=\"inventory_filter_container\"]/select/option[2]"));
        descOrder.click();
        Thread.sleep(3_000);

        List<WebElement> productList = driver.findElements(By.className("inventory_item_label"));
        List<String> products = productList.stream()
                                .map(product -> product.getText())
                                .collect(Collectors.toList());

        List<String> sortedProducts = products;
        Collections.sort(sortedProducts);

        Assertions.assertEquals(sortedProducts, products);
    }
}

