package stepsPO;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SauceDemoTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        // WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Tempo máximo de espera
    }

    @Test
    public void loginSauceDemo() {
        driver.get("https://www.saucedemo.com/");

        // Esperar até que o campo de usuário esteja visível
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Esperar até que a página de produtos carregue
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-sauce-labs-backpack"))).click();

        driver.findElement(By.className("shopping_cart_link")).click();

        String productName = driver.findElement(By.className("inventory_item_name")).getText();
        String productPrice = driver.findElement(By.className("inventory_item_price")).getText();

        Assertions.assertEquals("Sauce Labs Backpack", productName);
        Assertions.assertEquals("$29.99", productPrice);
    }

    @AfterEach
    public void tearDown() {
            driver.quit();
        
    }
}
