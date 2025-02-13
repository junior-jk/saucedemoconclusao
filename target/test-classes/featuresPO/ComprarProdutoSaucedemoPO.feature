# language: pt;

Feature: Comprar Produto com Sucesso PO
         Escolher e validar produto no site SauceDemo


  Scenario Outline: Comprar com Sucesso PO
    Dado que acesso o site "https://www.saucedemo.com/" PO
    Quando eu faço login com "<usuario>" e "<senha>" PO
    E adiciono o "<produto>" ao carrinho PO
    Entao no carrinho deve ter o nome do item escolhido "<produto>" PO
    Entao o valor sera "<preco>" PO

   Examples:
      | usuario         | senha          | produto                | preco   |
      | standard_user   | secret_sauce   | Sauce Labs Backpack    | $29.99  |
      | standard_user   | secret_sauce   | Sauce Labs Bolt T-Shirt| $15.99  |
