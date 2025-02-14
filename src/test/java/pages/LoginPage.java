package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By campoUsuario = By.id("user-name");
    private By campoSenha = By.id("password");
    private By botaoLogin = By.id("login-button");

    public LoginPage(WebDriver driver) {
         }

    public void fazerLogin(String usuario, String senha) {
        driver.findElement(campoUsuario).sendKeys(usuario);
        driver.findElement(campoSenha).sendKeys(senha);
        driver.findElement(botaoLogin).click();
    }
}
