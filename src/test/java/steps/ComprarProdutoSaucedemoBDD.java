package steps;

import io.cucumber.java.pt.Dado;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertTrue;

import pages.LoginPage;
import pages.ProdutoPage;
import pages.CarrinhoPage;

public class ComprarProdutoSaucedemoBDD {
 
    WebDriver driver;

    LoginPage loginPage;
    ProdutoPage produtoPage = new ProdutoPage();
    CarrinhoPage carrinhoPage = new CarrinhoPage();

    
    @Dado("que acesso o site {string}")
    public void que_acesso_o_site(String url) {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.get(url);
    }

    @Quando("eu faço login com usuario {string} e senha {string}")
    @Quando("eu faço login com {string} e {string}")
    public void eu_faco_login_com_usuario_e_senha(String usuario, String senha) {
        driver.findElement(By.id("user-name")).sendKeys(usuario);
        driver.findElement(By.id("password")).sendKeys(senha);
        driver.findElement(By.id("login-button")).click();
    }

    @Quando("adiciono o produto {string} ao carrinho")
    @Quando("adiciono o {string} ao carrinho")
    public void adiciono_o_produto_ao_carrinho(String produto) {
        driver.findElement(By.xpath("//div[text()='" + produto + "']")).click();
        driver.findElement(By.cssSelector(".btn_inventory")).click();
    }

    @Entao("o produto no carrinho deve ter o nome {string}")
    public void o_produto_no_carrinho_deve_ter_o_nome(String produto) {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='cart_item']//div[text()='" + produto + "']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//div[@class='cart_item']//div[text()='" + produto + "']")).isDisplayed());
    }

    @Entao("o preço deve ser {string}")
    @Entao("o valor sera {string}")
    public void o_preco_deve_ser(String preco) {
        assertTrue(driver.findElement(By.xpath("//div[@class='cart_item']//div[text()='" + preco + "']")).isDisplayed());
        driver.quit();
    }
}
