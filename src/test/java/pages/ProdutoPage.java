package pages;

import org.openqa.selenium.By;

public class ProdutoPage extends BasePage {

    public void adicionarProdutoAoCarrinho(String nomeProduto) {
        String xpathProduto = "//div[text()='" + nomeProduto + "']/ancestor::div[@class='inventory_item']//button";
        driver.findElement(By.xpath(xpathProduto)).click();
    }
}
