package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

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

        // Click Add to Cart Button
        List<WebElement> buttons = driver.findElements(By.className("btn_primary"));

        for (WebElement btn : buttons) {
            btn.click();
            Thread.sleep(2000);
        }

        // Click Cart
        WebElement cartIcon = driver.findElement(By.id("shopping_cart_container"));
        cartIcon.click();

        Thread.sleep(2000);

        // Click Checkout
        WebElement checkoutBtn = driver.findElement(By.className("checkout_button"));
        checkoutBtn.click();

        Thread.sleep(3000);

        // Click Cancel
        WebElement cancelBtn = driver.findElement(By.className("cart_cancel_link"));
        cancelBtn.click();

        Thread.sleep(3000);

        // Click Burger Menu
        WebElement menuBtn = driver.findElement(By.className("bm-burger-button"));
        menuBtn.click();

        Thread.sleep(2000);

        // Click Logout
        WebElement logoutBtn = driver.findElement(By.id("logout_sidebar_link"));
        logoutBtn.click();
    }

    @Test
    @DisplayName("Login to SauceDemo and checkout with no item")
    void testSauceDemoLoginAndCheckoutWithNoItem() throws InterruptedException {
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

        // Click Cart
        WebElement cartIcon = driver.findElement(By.id("shopping_cart_container"));
        cartIcon.click();

        Thread.sleep(3000);

        // Click Checkout
        WebElement checkoutBtn = driver.findElement(By.className("checkout_button"));
        checkoutBtn.click();

        Thread.sleep(2000);

        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.sendKeys("Russ");
        Thread.sleep(1000); // small pause as requested
        Assertions.assertEquals("Russ", firstName.getAttribute("value"),
                "First Name field should contain the entered First name");

        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.sendKeys("Paul");
        Thread.sleep(1000); // small pause as requested
        Assertions.assertEquals("Paul", lastName.getAttribute("value"),
                "Last Name field should contain the entered last name");

        WebElement zip = driver.findElement(By.id("postal-code"));
        zip.sendKeys("1700");
        Thread.sleep(1000); // small pause as requested
        Assertions.assertEquals("1700", zip.getAttribute("value"),
                "Zip Code field should contain the entered zip code");

        // Click Cancel
        WebElement continueBtn = driver.findElement(By.className("cart_button"));
        continueBtn.click();

        Thread.sleep(2000);

        // Click Cancel
        WebElement finishBtn = driver.findElement(By.className("cart_button"));
        finishBtn.click();

        Thread.sleep(2000);

        // Click Burger Menu
        WebElement menuBtn = driver.findElement(By.className("bm-burger-button"));
        menuBtn.click();

        Thread.sleep(2000);

        // Click Logout
        WebElement logoutBtn = driver.findElement(By.id("logout_sidebar_link"));
        logoutBtn.click();

    }

    @Test
    @DisplayName("Single Order and Checkout")
    void testSingleOrderAndCheckout() throws InterruptedException {
        //Select Filter
        WebElement filterBtn = driver.findElement(By.xpath("//select[@class='product_sort_container']"));

        Select select = new Select(filterBtn);
        select.selectByValue("lohi");
        Thread.sleep(2000);

        // Select item
        clickButton("//div[@class='inventory_list']//div[1]//div[3]//button[1]", 2000);

        //go to your cart
        clickButton("//*[name()='path' and contains(@fill,'currentCol')]", 1000);

        //user reviews
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cart_contents_container")));
        Thread.sleep(2000);

        // go to checkout
        clickButton("//a[@class='btn_action checkout_button']", 1_000);


        // input credentials
        WebElement firstName = inputField("first-name","Jan Russel");
        Assertions.assertEquals("Jan Russel", firstName.getAttribute("value"),
                "First name field should be 'Jan Russel'");

        WebElement lastName = inputField("last-name","Derpoja");
        Assertions.assertEquals("Jan Russel", lastName.getAttribute("value"),
                "Last name field should be 'Derpoja'");

        WebElement postalCode = inputField("postal-code","Tiga laguna");
        Assertions.assertEquals("Jan Russel", postalCode.getAttribute("value"),
                "Postal code field should be 'Tiga laguna'");


        clickButton("//input[@value='CONTINUE']", 1_000);

        //user reviews checkout
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout_summary_container")));
        Thread.sleep(3000);

        //user confirms checkout
        clickButton("//a[@class='btn_action cart_button']", 2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout_complete_container")));
        Thread.sleep(3000);

        //User opens sidebar
        clickButton("//button[normalize-space()='Open Menu']", 2000);

        //User Logs out
        clickButton("//a[@id='logout_sidebar_link']", 3000);
        Thread.sleep(5_000);
    }

    private WebElement inputField(String id, String value) throws InterruptedException {
        WebElement element = driver.findElement(By.id(id));
        element.sendKeys(value);
        Thread.sleep(1000);

        return element;
    }

    private void clickButton(String xpathExpression, int millis) throws InterruptedException {
        WebElement button = driver.findElement(By.xpath(xpathExpression));
        button.click();
        Thread.sleep(millis);
    }

    private void login() throws InterruptedException {
        // 1) Open SauceDemo (you gave /v1/)
        driver.get("https://www.saucedemo.com/v1/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='user-name']")));

        // VALIDATION: URL contains saucedemo
        Assertions.assertTrue(driver.getCurrentUrl().contains("saucedemo"),
                "Page URL should contain 'saucedemo'");

        Thread.sleep(2000);
        // 2) Enter username
        WebElement usernameBox = driver.findElement(By.xpath("//input[@id='user-name']"));
        usernameBox.sendKeys("standard_user");
        Thread.sleep(1000); // small pause as requested

        // 3) Enter password
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='password']"));
        passwordBox.sendKeys("secret_sauce");
        Thread.sleep(1000); // small pause

        // 4) Click login button
        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginBtn.click();

        // wait until the inventory/products page is visible: in /v1/ the header has class "product_label"
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product_label']")));

        // VALIDATION: page shows "Products"
        WebElement title = driver.findElement(By.className("product_label"));
        Thread.sleep(3000);
    }

}
