package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.Assertions;

public class CarrinhoPage {
    private WebDriver driver;

    public CarrinhoPage(WebDriver driver) {
        this.driver = driver;
    }

    private By nomeProduto = By.className("inventory_item_name");
    private By precoProduto = By.className("inventory_item_price");

    public void validarNomeProduto(String produtoEsperado) {
        String nomeNoCarrinho = driver.findElement(nomeProduto).getText();
        Assertions.assertEquals(produtoEsperado, nomeNoCarrinho);
    }

    public void validarPrecoProduto(String precoEsperado) {
        String precoNoCarrinho = driver.findElement(precoProduto).getText();
        Assertions.assertEquals(precoEsperado, precoNoCarrinho);
    }
}
