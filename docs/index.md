# Store Platform

A **store backend** built as a university project by  
[Gustavo Barroso Souza Cruz](https://github.com/Gubscruz).  
The platform showcases modern micro-services, CI/CD and DevOps practices on top of **Spring Boot 3**, **PostgreSQL**, **Redis**, **Docker / Kubernetes**, **Jenkins** and **MkDocs**.

---

## Key Features
| Layer        | Highlights                                                                      |
|--------------|---------------------------------------------------------------------------------|
| **Data**     | PostgreSQL schemas per service • Redis cache for hot products and orders        |
| **Security** | Bearer token auth & role-based access control                                   |
| **CI/CD**    | Jenkins declarative pipelines → Docker Hub → Minikube/​Kubernetes                |
| **Docs**     | Auto-published with **MkDocs-Material** + live Mermaid diagrams                  |

---

## Repository Map

| Domain            | “Contract” module                                                           | Implementation (Spring Boot service)                                                 |
|-------------------|------------------------------------------------------------------------------|--------------------------------------------------------------------------------------|
| Authentication    | [`auth`](https://github.com/Gubscruz/auth)                                   | [`auth-service`](https://github.com/Gubscruz/auth-service)                            |
| Accounts          | [`account`](https://github.com/Gubscruz/account)                             | [`account-service`](https://github.com/Gubscruz/account-service)                      |
| Products          | [`product`](https://github.com/Gubscruz/product)                             | [`product-service`](https://github.com/Gubscruz/product-service)                      |
| Orders            | [`order`](https://github.com/Gubscruz/order)                                 | [`order-service`](https://github.com/Gubscruz/order-service)                          |
| Gateway           | [`gateway`](https://github.com/Gubscruz/gateway)                             | [`gateway-service`](https://github.com/Gubscruz/gateway-service)                      |
| Exchange Rates    | n/a                                                                          | [`exchange-service`](https://github.com/Gubscruz/exchange-service) – Python           |

> **Tip:** Cada pasta `*-service` inclui seu próprio Dockerfile,  
> manifests Kubernetes (`k8s/*.yaml`) e Jenkinsfile.

---

## High-Level Architecture

```mermaid
flowchart TB
    subgraph "Clients"
        Web["Web UI"]:::external
    end

    Web --> Gateway

    Gateway["API Gateway\n(Spring Boot)"]:::gateway

    subgraph "Kubernetes Cluster"
        style Kubernetes Cluster stroke-dasharray: 5 5
        subgraph "Services"
            Auth["auth-service\n(Spring Boot)"]:::service
            Account["account-service\n(Spring Boot)"]:::service
            Product["product-service\n(Spring Boot)"]:::service
            Order["order-service\n(Spring Boot)"]:::service
            Exchange["exchange-service\n(Python)"]:::service
        end
        subgraph "Databases"
            AuthDB["auth-db\n(PostgreSQL)"]:::db
            AccountDB["account-db\n(PostgreSQL)"]:::db
            ProductDB["product-db\n(PostgreSQL)"]:::db
            OrderDB["order-db\n(PostgreSQL)"]:::db
        end
    end

    Gateway --> Auth
    Gateway --> Account
    Gateway --> Product
    Gateway --> Order
    Gateway --> Exchange

    Auth --> AuthDB
    Account --> AccountDB
    Product --> ProductDB
    Order --> OrderDB

    Order --> Product
    Order --> Exchange

    subgraph "CI/CD & Deployment"
        Jenkins["Jenkins"]:::external
        Registry["Docker Registry"]:::external
        K8s["Kubernetes"]:::external
        Jenkins --> Registry
        Registry --> K8s
    end

    subgraph "Documentation"
        MkDocs["MkDocs"]:::external
        GHPages["GitHub Pages"]:::external
        MkDocs --> GHPages
    end

    click Gateway "https://github.com/gubscruz/platform/tree/main/api/gateway-service"
    click Auth "https://github.com/gubscruz/platform/tree/main/api/auth-service"
    click Account "https://github.com/gubscruz/platform/tree/main/api/account-service"
    click Product "https://github.com/gubscruz/platform/tree/main/api/product-service"
    click Order "https://github.com/gubscruz/platform/tree/main/api/order-service"
    click Exchange "https://github.com/gubscruz/platform/tree/main/api/exchange-service"
    click Jenkins "https://github.com/gubscruz/platform/blob/main/jenkins/compose.yaml"
    click MkDocs "https://github.com/gubscruz/platform/blob/main/mkdocs.yml"
    click GHPages "https://github.com/gubscruz/platform/tree/main/docs/"

    classDef gateway fill:#FFA500,stroke:#333,stroke-width:1px;
    classDef service fill:#ADD8E6,stroke:#333,stroke-width:1px;
    classDef db fill:#90EE90,stroke:#333,stroke-width:1px;
    classDef external fill:#D3D3D3,stroke:#333,stroke-width:1px;
```

## Videos

### Personal Video
<iframe
  width="100%"
  height="470"
  src="https://www.youtube.com/embed/BYBv1UoPAew"
  title="Personal Project Video"
  frameborder="0"
  allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
  allowfullscreen>
</iframe>

<iframe
  width="100%"
  height="470"
  src="https://youtube.com/embed/Gse2Vfrhvho"
  title="Horizontal Pod Autoscaling"
  frameborder="0"
  allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
  allowfullscreen>
</iframe>


> This MkDocs was created by [Gustavo Barroso Souza Cruz](https://github.com/Gubscruz)