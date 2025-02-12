package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");

    public void fazerLogin(String usuario, String senha) {
        driver.findElement(usernameField).sendKeys(usuario);
        driver.findElement(passwordField).sendKeys(senha);
        driver.findElement(loginButton).click();
    }
}
