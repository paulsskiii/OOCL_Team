package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

class SeleniumGoogleSearchTest {

    private static final Logger log = LoggerFactory.getLogger(SeleniumGoogleSearchTest.class);
    private WebDriver driver;

    @BeforeAll
    static void setupClass() {
        // downloads matching chromedriver automatically
//        System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
        System.setProperty("webdriver.edge.driver", "D://msedgedriver.exe");
        // "D:\chromedriver.exe"

//        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--start-maximized"); // optional
//        driver = new ChromeDriver();
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        if (driver != null) {
            driver.quit();
        }
    }

    void loginToSauceDemo() throws InterruptedException {
        driver.get("https://www.saucedemo.com/v1/");

        WebElement usernameBox = driver.findElement(By.xpath("//input[@id='user-name']"));
        Thread.sleep(1000);
        usernameBox.sendKeys("standard_user");
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='password']"));
        passwordBox.sendKeys("secret_sauce");
        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginBtn.click();
    }

    void findElementAndClick(String xpath) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath(xpath));
        Thread.sleep(1000);
        element.click();
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
    @DisplayName("Login to SauceDemo and add to cart multiple items and then remove 1 then proceed to checkout")
    void testSauceDemoLoginAndAddToCardMultipleItemsAndThenProceedToCheckout() throws InterruptedException {
        driver.get("https://www.saucedemo.com/v1/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginToSauceDemo();

        Thread.sleep(2000);
        driver.findElement(By.)
        findElementAndClick("/html/body/div/div[2]/div[2]/div/div[2]/div/div[5]/div[3]/button");
        Thread.sleep(1000);
        findElementAndClick("/html/body/div/div[2]/div[2]/div/div[2]/div/div[4]/div[3]/button");
        Thread.sleep(1000);
        findElementAndClick("/html/body/div/div[2]/div[2]/div/div[2]/div/div[6]/div[3]/button");
        Thread.sleep(1000);

        findElementAndClick("/html/body/div/div[2]/div[1]/div[2]/a");
        findElementAndClick("/html/body/div/div[2]/div[3]/div/div[1]/div[5]/div[2]/div[2]/button");
        findElementAndClick("/html/body/div/div[2]/div[3]/div/div[2]/a[2]");

        Thread.sleep(3000);

        WebElement FirstName = driver.findElement(By.xpath("//input[@id='first-name']"));
        FirstName.sendKeys("John");
        Thread.sleep(1000);
        WebElement LastName = driver.findElement(By.xpath("//input[@id='last-name']"));
        LastName.sendKeys("Doe");
        Thread.sleep(1000);
        WebElement PostalCode = driver.findElement(By.xpath("//input[@id='postal-code']"));
        PostalCode.sendKeys("12345");
        Thread.sleep(1000);

        findElementAndClick("/html/body/div/div[2]/div[3]/div/form/div[2]/input");
        Thread.sleep(2000);
        findElementAndClick("/html/body/div/div[2]/div[3]/div/div[2]/div[8]/a[2]");
        Thread.sleep(1000);
        findElementAndClick("/html/body/div/div[1]/div/div[3]/div/button");
        Thread.sleep(2000);
        findElementAndClick("/html/body/div/div[1]/div/div[2]/div[1]/nav/a[3]");
    }
}
