#language: pt;

Feature: Comprar Produto com Sucesso
          Escolher e validadar produto no carrinho

  Scenario: Comprar com Sucesso
        Dado que acesso o site "https://www.saucedemo.com/"
        Quando eu faço login com usuario "standard_user" e senha "secret_sauce"
        E adiciono o produto "Sauce Labs Backpack" ao carrinho
        Entao o produto no carrinho deve ter o nome "Sauce Labs Backpack"
        Entao o preço deve ser "$29.99"

   

Scenario Outline: Comprar Produto com Sucesso DDT
      Dado que acesso o site "https://www.saucedemo.com/"
      Quando eu faço login com "<usuario>" e "<senha>"
      E adiciono o  "<produto>" ao carrinho
      Entao o produto no carrinho deve ter o nome "<produto>"
      Entao o valor sera "<preco>"
   Examples:
      | usuario         | senha          | produto                | preco   |
      | standard_user   | secret_sauce   | Sauce Labs Backpack    | $29.99  |
      | standard_user   | secret_sauce   | Sauce Labs Bolt T-Shirt| $15.99  |
