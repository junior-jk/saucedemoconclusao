package stepsPO;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.LoginPage;
import pages.CarrinhoPage;


public class ComprarProdutoSaucedemoPO {
    WebDriver driver;
    LoginPage loginPage;
    CarrinhoPage carrinhoPage;

    
    @Dado("que estou na pagina de login do SauceDemo PO")
    public void que_estou_na_pagina_de_login_do_sauce_demo() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Quando("eu faço login com usuario {string} e senha {string} PO")
    public void eu_faco_login_com_usuario_e_senha(String usuario, String senha) {
        driver.findElement(By.id("user-name")).sendKeys(usuario);
        driver.findElement(By.id("password")).sendKeys(senha);
        driver.findElement(By.id("login-button")).click();
    }

    @E("adiciono o produto {string} ao carrinho PO")
    public void adiciono_o_produto_ao_carrinho(String produto) {
        String xpath = "//div[text()='" + produto + "']/ancestor::div[@class='inventory_item']//button";
        driver.findElement(By.xpath(xpath)).click();
    }

    @Entao("o produto no carrinho deve ter o nome {string} PO")
    public void o_produto_no_carrinho_deve_ter_o_nome(String produto) {
        driver.findElement(By.className("shopping_cart_link")).click();
        WebElement produtoNoCarrinho = driver.findElement(By.className("inventory_item_name"));
        Assert.assertEquals(produto, produtoNoCarrinho.getText());
    }

    @Entao("o preço deve ser {string} PO")
    public void o_preco_deve_ser(String preco) {
        WebElement precoElemento = driver.findElement(By.className("inventory_item_price"));
        Assert.assertEquals(preco, precoElemento.getText());
        driver.quit();
    }
}
