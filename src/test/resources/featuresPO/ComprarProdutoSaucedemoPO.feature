# language: pt;

Feature: Adicionar produto ao carrinho e validar nome e preço PO
         Escolher e validar produto no site SauceDemo


  Scenario Outline: Comprar com Sucesso PO
    Dado que estou na pagina de login do SauceDemo PO
    Quando eu faço login com usuario "<usuario>" e senha "<senha>" PO
    E adiciono o produto "<produto>" ao carrinho PO
    Entao o produto no carrinho deve ter o nome "<produto>" PO
    Entao o preço deve ser "<preco>" PO

   Examples:
      | usuario         | senha          | produto                | preco   |
      | standard_user   | secret_sauce   | Sauce Labs Backpack    | $29.99  |
      | standard_user   | secret_sauce   | Sauce Labs Bolt T-Shirt| $15.99  |
