
Create a RESTful API for a store. The API should have two main resources: `product` and `order`.


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
        gateway --> exchange
        gateway e5@==> product:::color
        gateway e6@==> order:::color
        product e2@==> db
        order e3@==> db
        order e4@==> product
    end
    exchange --> 3partyapi@{label: "3rd-party API"}
    internet e1@==>|request| gateway
    e1@{ animate: true }
    e2@{ animate: true }
    e3@{ animate: true }
    e4@{ animate: true }
    e5@{ animate: true }
    e6@{ animate: true }
    classDef color fill:#f22
    click product "#product-api" "Product API"
    click order "#order-api" "Order API"
```

!!! warning "Attention"

    **To consume the API, the user must be authenticated.**

## Product API

The API should have the following endpoints:

!!! info "POST /product"

    Create a new product.

    === "Request"

        ``` { .json .copy .select linenums='1' }
        {
            "name": "Tomato",
            "price": 10.12,
            "unit": "kg"
        }
        ```

    === "Response"

        ``` { .json .copy .select linenums='1' }
        {
            "id": "0195abfb-7074-73a9-9d26-b4b9fbaab0a8",
            "name": "Tomato",
            "price": 10.12,
            "unit": "kg"
        }
        ```
        ```bash
        Response code: 201 (created)
        ```

!!! info "GET /product"

    Get all products.

    === "Response"

        ``` { .json .copy .select linenums='1' }
        [
            {
                "id": "0195abfb-7074-73a9-9d26-b4b9fbaab0a8",
                "name": "Tomato",
                "price": 10.12,
                "unit": "kg"
            },
            {
                "id": "0195abfe-e416-7052-be3b-27cdaf12a984",
                "name": "Cheese",
                "price": 0.62,
                "unit": "slice"
            }
        ]
        ```
        ```bash
        Response code: 200 (ok)
        ```

!!! info "GET /product/{id}"

    Get a product by its ID.

    === "Response"

        ``` { .json .copy .select linenums='1' }
        {
            "id": "0195abfb-7074-73a9-9d26-b4b9fbaab0a8",
            "name": "Tomato",
            "price": 10.12,
            "unit": "kg"
        }
        ```
        ```bash
        Response code: 200 (ok)
        ```

!!! info "DELETE /product/{id}"

    Delete a product by its ID.

    ```bash
    Response code: 204 (no content)
    ```

## Order API

!!! info "POST /order"

    Create a new order **for the current user**.

    === "Request"

        ``` { .json .copy .select linenums='1' }
        {
            "items": [
                {
                    "id": "0195abfb-7074-73a9-9d26-b4b9fbaab0a8",
                    "quantity": 2
                },
                {
                    "id": "0195abfe-e416-7052-be3b-27cdaf12a984",
                    "quantity": 1
                }
            ]
        }
        ```

    === "Response"

        ``` { .json .copy .select linenums='1' }
        {
            "id": "0195ac33-73e5-7cb3-90ca-7b5e7e549569",
            "date": "2025-09-01T12:30:00",
            "items": [
                {
                    "id": "0195abfb-7074-73a9-9d26-b4b9fbaab0a8",
                    "quantity": 2,
                    "total": 20.24
                },
                {
                    "id": "0195abfe-e416-7052-be3b-27cdaf12a984",
                    "quantity": 10,
                    "total": 6.2
                }
            ],
            "total": 26.44
        }
        ```
        ```bash
        Response code: 201 (created)
        Response code: 400 (bad request), if the product does not exist.
        ```

!!! info "GET /order"

    Get all orders **for the current user**.

    === "Response"

        ``` { .json .copy .select linenums='1' }
        [
            {
                "id": "0195ac33-73e5-7cb3-90ca-7b5e7e549569",
                "date": "2025-09-01T12:30:00",
                "total": 26.44
            },
            {
                "id": "0195ac33-cbbd-7a6e-a15b-b85402cf143f",
                "date": "2025-10-09T03:21:57",
                "total": 18.6
            }
            
        ]
        ```
        ```bash
        Response code: 200 (ok)
        ```

!!! info "GET /order/{id}"

    Get the order details by its ID. **The order must belong to the current user.**, otherwise, return a `404`.

    === "Response"

        ``` { .json .copy .select linenums='1' }
        {
            "id": "0195ac33-73e5-7cb3-90ca-7b5e7e549569",
            "date": "2025-09-01T12:30:00",
            "items": [
                {
                    "id": "0195abfb-7074-73a9-9d26-b4b9fbaab0a8",
                    "quantity": 2,
                    "total": 20.24
                },
                {
                    "id": "0195abfe-e416-7052-be3b-27cdaf12a984",
                    "quantity": 10,
                    "total": 6.2
                }
            ],
            "total": 26.44
        }
        ```
        ```bash
        Response code: 200 (ok)
        Response code: 404 (not found), if the order does not belong to the current user.
        ```

## Additionals

Additional features are welcome, such as:

- Search products by "like" name;
- Authorization by role (admin, user):
    * Admin can create, update, and delete products;
    * User can only create orders;
- Input validations;
- Error handling.

## Nice to have

- Observability (metrics, logs), see [Prometheus](https://prometheus.io/){target="_blank"} and [Grafana](https://grafana.com/){target="_blank"};
- Database In-Memory (suggestion: Product microservice), see [Redis](https://redis.io/){target="_blank"};
- Swagger documentation, see [SpringDoc](https://springdoc.org/){target="_blank"}.