package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProdutoPage {
    private WebDriver driver;

    public ProdutoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void adicionarProdutoAoCarrinho(String produto) {
        // Implementation to add the product to the cart
        // Example:
        driver.findElement(By.xpath("//div[text()='" + produto + "']/following-sibling::button")).click();
    }

    // other methods
}