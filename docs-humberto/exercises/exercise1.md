

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
        subgraph api
            direction TB
            gateway --> account
            gateway --> auth
            gateway --> others
            account --> db@{ shape: cyl, label: "Database" }
            others --> db
            auth --> account
            gateway e1@==> exchange:::color
            e1@{ animate: true }
        end
        exchange e2@==> 3partyapi@{label: "3rd-party API"}
        internet e3@==>|request| gateway
        e2@{ animate: true }
        e3@{ animate: true }
        classDef color fill:#f22
        click exchange "#exchange-api" "Exchange API"
    ```

[^1]: [FastAPI - First Steps](https://fastapi.tiangolo.com/tutorial/first-steps/){target="_blank"}.