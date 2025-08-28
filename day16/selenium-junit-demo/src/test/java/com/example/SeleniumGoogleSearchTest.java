package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

class SeleniumGoogleSearchTest {

    private WebDriverWait wait;

    private WebDriver driver;
    // = new EdgeDriver();

    @BeforeAll
    static void setupClass() {
        // downloads matching chromedriver automatically
        // WebDriverManager.chromedriver().setup();
        // System.setProperty("webdriver.chrome.driver", "C://chromedriver");
        System.setProperty("webdriver.edge.driver", "C://msedgedriver.exe");
    }

    @BeforeEach
    void setupTest() {

        
        // ChromeOptions options = new ChromeOptions();
        // options.addArguments("--user-data-dir=" +
        // System.getProperty("java.io.tmpdir"));
        // // options.addArguments("--start-maximized"); // optional
        // driver = new ChromeDriver(options);
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver = new EdgeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

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

        // wait until the inventory/products page is visible: in /v1/ the header has
        // class "product_label"
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product_label']")));

        // VALIDATION: page shows "Products"
        // WebElement title = driver.findElement(By.className("product_label"));
        // Assertions.assertEquals("Products", title.getText(),
        //         "After login, the page should show 'Products'");
        // wait.until(ExpectedConditions
        //         .visibilityOfElementLocated(By.xpath("//div[@class='inventory_list']//div[1]//div[3]//button[1]")));
        // Thread.sleep(1_000);

        // // --------------------------------------------------------------
        // // OPEN MENU (burger) //button[normalize-space()='Open Menu']
        // WebElement menuBtn = driver.findElement(By.xpath("//button[normalize-space()='Open Menu']"));
        // menuBtn.click();
        // Thread.sleep(1_000);

        // WebElement allItemsBtn = driver.findElement(By.xpath("//a[@id='inventory_sidebar_link']"));
        // allItemsBtn.click();
        // Thread.sleep(1_000);

        // // ------------------------------------------------------
        // WebElement addToCartBtn = driver
        //         .findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[3]//button[1]"));
        // addToCartBtn.click();
        // Thread.sleep(1_000);

        // WebElement addToCartBtn2 = driver.findElement(By.xpath(
        //         "//body//div[@id='page_wrapper']//div[@id='inventory_container']//div[@id='inventory_container']//div[2]//div[3]//button[1]"));
        // addToCartBtn2.click();
        // Thread.sleep(1_000);

        // WebElement viewCartBtn = driver
        //         .findElement(By.xpath("//a[@class='shopping_cart_link fa-layers fa-fw']//*[name()='svg']"));
        // viewCartBtn.click();
        // Thread.sleep(1_000);

        // // remove
        // WebElement removeCheckoutItemBtn = driver
        //         .findElement(By.xpath("//div[@id='cart_contents_container']//div[3]//div[2]//div[2]//button[1]"));
        // removeCheckoutItemBtn.click();
        // Thread.sleep(1_000);

        // // continue shopping
        // WebElement continueShoppingBtn = driver.findElement(By.xpath("//a[@class='btn_secondary']"));
        // continueShoppingBtn.click();
        // Thread.sleep(1_000);

        // // addbutton3
        // WebElement addToCartBtn3 = driver.findElement(By.xpath("//div[3]//div[3]//button[1]"));
        // addToCartBtn3.click();
        // Thread.sleep(1_000);

        // viewCartBtn = driver.findElement(By.xpath("//a[@class='shopping_cart_link fa-layers fa-fw']//*[name()='svg']"));
        // viewCartBtn.click();
        // Thread.sleep(1_000);

        // // checkout
        // WebElement checkoutBtn = driver.findElement(By.xpath("//a[@class='btn_action checkout_button']"));
        // checkoutBtn.click();
        // Thread.sleep(1_000);

        // WebElement firstNameBox = driver.findElement(By.xpath("//input[@id='first-name']"));
        // firstNameBox.sendKeys("Juan Gab");
        // Thread.sleep(1_000);

        // WebElement lastNameBox = driver.findElement(By.xpath("//input[@id='last-name']"));
        // lastNameBox.sendKeys("Icarus");
        // Thread.sleep(1_000);

        // WebElement postalCodeBox = driver.findElement(By.xpath("//input[@id='postal-code']"));
        // postalCodeBox.sendKeys("1101");
        // Thread.sleep(1_000);

        // WebElement continueBtn = driver.findElement(By.xpath("//input[@value='CONTINUE']"));
        // continueBtn.click();
        // Thread.sleep(1_000);

        // // a[@class='btn_action cart_button']

        // WebElement finishBtn = driver.findElement(By.xpath("//a[@class='btn_action cart_button']"));
        // finishBtn.click();
        // Thread.sleep(1_000);
        // // ---------------------------------------------------------

        // // LOGOUT MENU
        // menuBtn = driver.findElement(By.xpath("//button[normalize-space()='Open Menu']"));
        // menuBtn.click();
        // Thread.sleep(1_000);

        // WebElement logoutBtn = driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
        // logoutBtn.click();
        // Thread.sleep(2_000);

        // // WAIT 20 seconds (per your request) then test ends and @AfterEach will quit
        // // the browser
        // Thread.sleep(15_000);
    }

    @Test
    @DisplayName("Navigate to All Items using in Menu")
    void testSauceDemoNavigateToAllItems() throws InterruptedException {
        driver.get("https://www.saucedemo.com/v1/inventory.html");
        WebElement menuBtn = driver.findElement(By.xpath("//button[normalize-space()='Open Menu']"));
        menuBtn.click();
        Thread.sleep(1_000);

        WebElement allItemsBtn = driver.findElement(By.xpath("//a[@id='inventory_sidebar_link']"));
        allItemsBtn.click();
        Thread.sleep(1_000);

        WebElement title = driver.findElement(By.className("product_label"));
        Assertions.assertEquals("Products", title.getText(),
                "After login, the page should show 'Products'");
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='inventory_list']//div[1]//div[3]//button[1]")));
        Thread.sleep(1_000);
        // div[@class='product_label']
    }

    
    @Test
    @DisplayName("Add to cart button")
    void testSauceDemoAddToCartButton() throws InterruptedException {
        driver.get("https://www.saucedemo.com/v1/inventory.html");

        WebElement addToCartBtn = driver
                .findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[3]//button[1]"));
        addToCartBtn.click();
        Thread.sleep(1_000);

        WebElement addToCartBtn2 = driver.findElement(By.xpath(
                "//body//div[@id='page_wrapper']//div[@id='inventory_container']//div[@id='inventory_container']//div[2]//div[3]//button[1]"));
        addToCartBtn2.click();
        Thread.sleep(1_000);

        WebElement removeItemBtn1 = driver.findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[3]//button[1]"));
        WebElement removeItemBtn2 = driver.findElement(By.xpath("//body//div[@id='page_wrapper']//div[@id='inventory_container']//div[@id='inventory_container']//div[2]//div[3]//button[1]"));
        
        Assertions.assertEquals("REMOVE", removeItemBtn1.getText(),
                 "After pressing ADD TO CART, should convert to REMOVE");
        Assertions.assertEquals("REMOVE", removeItemBtn2.getText(),
                 "After pressing ADD TO CART, should convert to REMOVE");
    }

    @Test
    @DisplayName("View cart button after adding to cart")
    void testSauceDemoViewCartButton() throws InterruptedException {
        driver.get("https://www.saucedemo.com/v1/inventory.html");

        WebElement addToCartBtn = driver
                .findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[3]//button[1]"));
        addToCartBtn.click();
        Thread.sleep(1_000);

        WebElement addToCartBtn2 = driver.findElement(By.xpath(
                "//body//div[@id='page_wrapper']//div[@id='inventory_container']//div[@id='inventory_container']//div[2]//div[3]//button[1]"));
        addToCartBtn2.click();
        Thread.sleep(1_000);

        WebElement viewCartBtn = driver.findElement(By.xpath("//a[@class='shopping_cart_link fa-layers fa-fw']//*[name()='svg']"));
        viewCartBtn.click();
        Thread.sleep(1_000);

        WebElement viewCartTitle = driver.findElement(By.xpath("//div[@class='subheader']"));
        Assertions.assertEquals("Your Cart", viewCartTitle.getText(),
                 "After pressing VIEW CART icon, should show Your Cart page");
    }

    @Test
    @DisplayName("View cart button after adding to cart")
    void testSauceDemoCheckoutItems() throws InterruptedException{
        navigateToCart();
        WebElement checkoutBtn = driver.findElement(By.xpath("//a[@class='btn_action checkout_button']"));
        checkoutBtn.click();
        Thread.sleep(1_000);

        WebElement checkoutTitle = driver.findElement(By.xpath("//div[@class='subheader']"));
        Assertions.assertEquals("Checkout: Your Information", checkoutTitle.getText(),
                 "After pressing Checkout, should show Checkout: Your Information page");
    }

    @Test
    @DisplayName("View cart button after adding to cart")
    void testSauceDemoToCheckYourInfo() throws InterruptedException{
        navigateToInformationInputs();
        WebElement firstNameBox = driver.findElement(By.xpath("//input[@id='first-name']"));
        firstNameBox.sendKeys("Juan Gab");
        Thread.sleep(1_000);

        WebElement lastNameBox = driver.findElement(By.xpath("//input[@id='last-name']"));
        lastNameBox.sendKeys("Icarus");
        Thread.sleep(1_000);

        WebElement postalCodeBox = driver.findElement(By.xpath("//input[@id='postal-code']"));
        postalCodeBox.sendKeys("1101");
        Thread.sleep(1_000);

        WebElement continueBtn = driver.findElement(By.xpath("//input[@value='CONTINUE']"));
        continueBtn.click();
        Thread.sleep(1_000);

        WebElement checkoutTitle = driver.findElement(By.xpath("//div[@class='subheader']"));
        Assertions.assertEquals("Checkout: Overview", checkoutTitle.getText(),
                 "After pressing Continue, should show Checkout: Overview");
    }

    @Test
    @DisplayName("View cart button after adding to cart")
    void testSauceDemoNavigateToHome() throws InterruptedException{
        navigateToCheckoutOverview();
       WebElement finishBtn = driver.findElement(By.xpath("//a[@class='btn_action cart_button']"));
        finishBtn.click();
        Thread.sleep(1_000);

        WebElement checkoutTitle = driver.findElement(By.xpath("//div[@class='subheader']"));
        Assertions.assertEquals("Finish", checkoutTitle.getText(),
                 "After pressing Finish, should show gratitude page");
    }

    private void navigateToCart() throws InterruptedException {
        driver.get("https://www.saucedemo.com/v1/inventory.html");

        WebElement addToCartBtn = driver
                .findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[3]//button[1]"));
        addToCartBtn.click();
        Thread.sleep(1_000);

        WebElement addToCartBtn2 = driver.findElement(By.xpath(
                "//body//div[@id='page_wrapper']//div[@id='inventory_container']//div[@id='inventory_container']//div[2]//div[3]//button[1]"));
        addToCartBtn2.click();
        Thread.sleep(1_000);

        WebElement viewCartBtn = driver.findElement(By.xpath("//a[@class='shopping_cart_link fa-layers fa-fw']//*[name()='svg']"));
        viewCartBtn.click();
        Thread.sleep(1_000);
    }

    private void navigateToInformationInputs ()throws InterruptedException{
        navigateToCart();
        WebElement checkoutBtn = driver.findElement(By.xpath("//a[@class='btn_action checkout_button']"));
        checkoutBtn.click();
        Thread.sleep(1_000);
    }

    private void navigateToCheckoutOverview() throws InterruptedException{
        navigateToInformationInputs();
        WebElement firstNameBox = driver.findElement(By.xpath("//input[@id='first-name']"));
        firstNameBox.sendKeys("Juan Gab");
        Thread.sleep(1_000);

        WebElement lastNameBox = driver.findElement(By.xpath("//input[@id='last-name']"));
        lastNameBox.sendKeys("Icarus");
        Thread.sleep(1_000);

        WebElement postalCodeBox = driver.findElement(By.xpath("//input[@id='postal-code']"));
        postalCodeBox.sendKeys("1101");
        Thread.sleep(1_000);

        WebElement continueBtn = driver.findElement(By.xpath("//input[@value='CONTINUE']"));
        continueBtn.click();
        Thread.sleep(1_000);
    }
}
