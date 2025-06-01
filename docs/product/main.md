RESTful API for a store's `product`.


``` mermaid
flowchart LR
    subgraph api [Trusted Layer]
        direction TB
        gateway --> account
        gateway --> auth
        account --> db@{ shape: cyl, label: "Database" }
        auth --> account
        gateway --> exchange
        gateway e5@==> product:::red
        product e2@==> db

    end
    exchange --> 3partyapi@{label: "3rd-party API"}
    internet e1@==>|request| gateway
    e1@{ animate: true }
    e2@{ animate: true }
    e5@{ animate: true }
    classDef red fill:#fcc
    click product "#product-api" "Product API"
```

!!! warning "Attention"

    **To consume the API, the user must be authenticated.**

## Product Service

Github repository: [Product Service](https://github.com/Gubscruz/product-service)

```bash
product/
├── Product.java
├── ProductApplication.java
├── ProductModel.java
├── ProductRepository.java
├── ProductResource.java
├── ProductService.java
```

## Product (contract)

Github repository: [Product](https://github.com/Gubscruz/product)

```bash
product/
├── ProductController.java
├── ProductIn.java
├── ProductOut.java
```

!!! info "Diagrams"

    === "Request Flow"
        ![](./img/fluxo.png){ width=100% }

    === "Architecture"
        ![](./img/service.png){ width=100% }

    === "Entity Model"
        ![](./img/schema.png){ width=100% }


## Product API

The API has the following endpoints:

!!! info "POST /product"

    Create a new product.

    === "Request"

        ``` { .json .copy .select linenums='1' }
        {
            "name": "Feijão",
            "price": 7,
            "description": "Dona Ana",
            "category": "Cat I"
        }
        ```

    === "Response"

        ``` { .json .copy .select linenums='1' }
        {
            "idProduct": "b292bc8b-4c31-4d5e-8d18-032fdfd1c9d7",
            "name": "Feijão",
            "category": "Cat I",
            "description": "Dona Ana",
            "price": 7.0
        }
        ```
        ```bash
        Response code: 200 (OK)
        ```
    === "Postman"
        ![](./img/post-product.png){ width=100% }


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
    === "Postman"
        ![](./img/get-products.png){ width=100% }

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

    === "Response"

        ```bash
        Response code: 204 (no content)
        ```

    === "Postman"
        ![](./img/delete-product.png){ width=100% }
