

Feature: Comprar Produto com Sucesso
          Escolher e validadar produto no carrinho

  Scenario: Comprar com Sucesso
        Dado que  estou na pagina de login do SauceDemo
        Quando eu faço login com usuario "standard_user" e senha "secret_sauce"
        E adiciono o produto "Sauce Labs Backpack" ao carrinho
        Entao o produto no carrinho deve ter o nome "Sauce Labs Backpack"
        Entao o preço deve ser "$29.99"

   

Scenario Outline: Comprar Produto com Sucesso DDT
      Dado que  estou na pagina de login do SauceDemo
      Quando eu faço login com usuario "<usuario>" e senha "<senha>"
      E adiciono o produto "<produto>" ao carrinho
      Entao o produto no carrinho deve ter o nome "<produto>"
      Entao o preço deve ser "<preco>"
   Examples:
      | usuario         | senha          | produto                | preco   |
      | standard_user   | secret_sauce   | Sauce Labs Backpack    | $29.99  |
      | standard_user   | secret_sauce   | Sauce Labs Bolt T-Shirt| $15.99  |
