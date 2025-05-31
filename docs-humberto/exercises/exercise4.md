Now, it is time to create a pipeline to deploy the application to a cloud provider. You can use any cloud provider you prefer, such as AWS, Azure, or Google Cloud Platform. The pipeline should include the following steps:

1. SCM
1. Dependencies
1. Build
1. Push to Docker Hub
1. Deploy to K8s

!!! warning "TO DO"

    All microservices should be deployed in the same cluster, to do this, it is mandatory to user Jenkinsfile in each microservice. The pipeline should be created in the root of the project, and it should include all microservices:
    
    - `account-service`;
    - `auth-service`;
    - `gateway-service`;
    - `product-service`, and;
    - `order-service`.

A basic directory structure for the project is as follows:

``` { .bash }
.
├── account-service
│   ├── Jenkinsfile
│   └── ...
```

Example of a Jenkinsfile for the `account-service`:

=== "Jenkinsfile"

    ``` { .groovy .copy .select linenums="1" }
    --8<-- "https://raw.githubusercontent.com/hsandmann/insper.store.account-service/refs/heads/main/Jenkinsfile"
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
