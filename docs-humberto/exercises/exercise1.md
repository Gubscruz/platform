

Using FastAPI[^1] (or other framework) on Python :material-information-outline:{ title="Python is mandatory!" }, create a REST API that allows the user to convert between currencies. The API should have the following endpoints:

!!! info "GET /exchange/{from}/{to}"

    Get the current of a coin from one currency to another. E.g. `GET /coin/USD/EUR`.

    === "Response"

        ``` { .json .copy .select linenums='1' }
        {
            "sell": 0.82,
            "buy": 0.80,
            "date": "2021-09-01 14:23:42",
            "id-account": "0195ae95-5be7-7dd3-b35d-7a7d87c404fb"
        }
        ```
        ```bash
        Response code: 200 (ok)
        ```

The API should use a third-party API to get the exchange rates. You can use the free tier of the API, e.g.:

- [AwesomeAPI](https://github.com/awesomeapibrasil/economy-api){target="_blank"};
- [ExchangeRate-API](https://www.exchangerate-api.com/){target="_blank"};
- [Open Exchange Rates](https://openexchangerates.org/){target="_blank"};
- [CurrencyLayer](https://currencylayer.com/){target="_blank"};
- any other API.

Or, you can scrape the data from a website.

!!! tip "Hint"

    You can use the `requests` library to make HTTP requests to the third-party API.

!!! warning "Attention"

    **To consume the API, the user must be authenticated.**

!!! danger "Gateway"

    **This API should be consumed through the Gateway of the platform.**

    ``` mermaid
    flowchart LR
        subgraph api [Trusted Layer]
            direction TB
            gateway --> account
            gateway --> auth
            account --> db@{ shape: cyl, label: "Database" }
            auth --> account
            gateway e1@==> exchange:::red
            e1@{ animate: true }
        end
        exchange e2@==> 3partyapi@{label: "3rd-party API"}
        internet e3@==>|request| gateway
        e2@{ animate: true }
        e3@{ animate: true }
        classDef red fill:#fcc
        click exchange "#exchange-api" "Exchange API"
    ```

---

!!! danger "Entrega"

    Individualmente, cada aluno deve criar um repositório no GitHub, com a documentação em MkDocs dos exercícios realizados e também com o projeto e entrega o link via BlabkBoard. Na documentação publicada deve constar:

    - Nome do aluno e grupo;
    - Documentação das atividades realizadas;
    - Código fonte das atividades realizadas;
    - Documentação do projeto;
    - Código fonte do projeto;
    - Link para todos os repositórios utilizados;
    - Destaques para os bottlenecks implementados (ao menos 2 por indivíduo);
    - Apresentação do projeto;
    - Vídeo de apresentação do projeto (2-3 minutos);
    
    Um template de documentação pode ser encontrado em [Template de Documentação](https://hsandmann.github.io/documentation.template/){target="_blank"}.




[^1]: [FastAPI - First Steps](https://fastapi.tiangolo.com/tutorial/first-steps/){target="_blank"}.