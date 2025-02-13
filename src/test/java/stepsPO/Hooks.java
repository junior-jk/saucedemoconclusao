package stepsPO;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
// import io.github.bonigarcia.wdm.WebDriverManager;
import pages.BasePage;

public class Hooks {
    BasePage base;

    // constructor
    public Hooks(BasePage base){
        this.base = base;
    }

    @Before
    public void iniciarPO(){
        // WebDriverManager.chromedriver().setup();
        BasePage.driver = new ChromeDriver();
        BasePage.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(60000));
        BasePage.driver.manage().window().maximize();
    }
    
    @After
    public void finalizarPO(){
        BasePage.driver.quit();
    }
}