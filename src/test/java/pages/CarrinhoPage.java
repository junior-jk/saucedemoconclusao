package pages;

import org.openqa.selenium.By;

public class CarrinhoPage extends BasePage {
    private By botaoCarrinho = By.className("shopping_cart_link");

    public void abrirCarrinho() {
        driver.findElement(botaoCarrinho).click();
    }

    public boolean verificarProdutoNoCarrinho(String nomeProduto) {
        String xpathProduto = "//div[@class='cart_item']//div[text()='" + nomeProduto + "']";
        return driver.findElements(By.xpath(xpathProduto)).size() > 0;
    }

    public String obterPrecoDoProduto() {
        return driver.findElement(By.className("inventory_item_price")).getText();
    }
}
