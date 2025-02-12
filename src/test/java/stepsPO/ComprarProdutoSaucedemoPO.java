package stepsPO;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.CarrinhoPage;


public class ComprarProdutoSaucedemoPO {
    WebDriver driver;
    LoginPage loginPage;
    CarrinhoPage carrinhoPage;

    

    @Dado("que o usuario esta logado no site")
    public void que_o_usuario_esta_logado_no_site() {
        driver.get("https://www.saucedemo.com/");
        loginPage.fazerLogin("standard_user", "secret_sauce");
    }

    @Quando("o usuario adiciona o produto {string} ao carrinho")
    public void o_usuario_adiciona_o_produto_ao_carrinho(String produto) {
        driver.findElement(By.id("add-to-cart-" + produto.replaceAll(" ", "-").toLowerCase())).click();
    }

    @Entao("o nome do produto no carrinho deve ser {string}")
    public void o_nome_do_produto_no_carrinho_deve_ser(String nomeProduto) {
        driver.findElement(By.className("shopping_cart_link")).click();
        carrinhoPage.validarNomeProduto(nomeProduto);
    }

    @Entao("o preco do produto no carrinho deve ser {string}")
    public void o_preco_do_produto_no_carrinho_deve_ser(String precoProduto) {
        carrinhoPage.validarPrecoProduto(precoProduto);
    }
}
