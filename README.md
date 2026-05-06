# 📦 Inventory App

> **API REST de controle de estoque desenvolvida em Spring Boot — projeto-base do curso "Do Zero ao Deploy".**

Esta aplicação é o case de estudo que usaremos ao longo das 5 aulas do treinamento para aplicar, na prática, todos os conceitos de **DevOps e DevSecOps**: containerização com Docker, pipelines de CI/CD com GitHub Actions, deploy em VPS e, por fim, uma esteira completa na AWS.

---

## 🎯 Sobre o projeto

O **Inventory App** é uma API REST simples e funcional para gerenciamento de estoque de produtos. A simplicidade é proposital: o foco do curso **não é a complexidade do código**, mas sim **tudo que envolve tirar esse código do repositório e colocá-lo rodando de forma profissional em produção**.

### Funcionalidades

- Cadastrar produtos no estoque
- Consultar produtos individualmente ou em lote
- Adicionar ou remover unidades de um produto
- Validação de estoque (não permite valores negativos)
- Persistência em banco de dados PostgreSQL
- Documentação automática via Swagger/OpenAPI

---

## 🛠️ Stack Técnica

| Camada | Tecnologia |
|--------|------------|
| Linguagem | **Java 17** |
| Framework | **Spring Boot 4** |
| Persistência | **Spring Data JPA** + **Hibernate** |
| Banco de dados | **PostgreSQL** |
| Documentação | **SpringDoc OpenAPI (Swagger UI)** |
| Build | **Maven** (Maven Wrapper incluso) |
| Produtividade | **Lombok** |
| Testes | **JUnit 5** + **Spring Boot Test** |

---

## 📚 Contexto do curso — Do Zero ao Deploy

Este repositório evolui **aula após aula**. A cada etapa do curso, novos arquivos e configurações são adicionados, transformando uma aplicação local em um produto em produção.

| Aula | Tema | O que adicionamos ao projeto |
|------|------|------------------------------|
| **1** | Princípios de DevOps, DevSecOps e Mercado | Visão geral — nenhum código adicionado |
| **2** | Containers + Docker na prática | `Dockerfile`, `docker-compose.yml`, containerização da app + banco |
| **3** | Git + CI/CD com GitHub Actions | `.github/workflows/` com build, testes automatizados e scan de segurança |
| **4** | Princípios de Nuvem e VPS | Deploy manual em VPS, configuração de servidor e Nginx |
| **5** | Deploy completo na AWS | Infraestrutura com ECR, ECS e pipeline de deploy automatizado |

> 💡 Acompanhe as **branches** do repositório (`aula-2`, `aula-3`, etc.) para ver a evolução passo a passo.

---

## 🚀 Como executar localmente

### Pré-requisitos

- Java 17+
- Maven 3.9+ (ou use o `mvnw` incluso)
- PostgreSQL rodando (ou via Docker — veremos na Aula 2)

### Subindo o banco com Docker (opcional — Aula 2+)

```bash
docker run --name inventory-db \
  -e POSTGRES_DB=inventory_db \
  -e POSTGRES_USER=user \
  -e POSTGRES_PASSWORD=password \
  -p 5432:5432 \
  -d postgres:16
```

### Rodando a aplicação

```bash
# Clone o repositório
git clone https://github.com/Luanderson-Dev/inventory-app.git
cd inventory-app

# Execute com o Maven Wrapper
./mvnw spring-boot:run
```

A API estará disponível em **http://localhost:8080**.

### Variáveis de ambiente (opcional)

A aplicação aceita as seguintes variáveis para customizar a conexão com o banco:

```bash
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/inventory_db
SPRING_DATASOURCE_USERNAME=user
SPRING_DATASOURCE_PASSWORD=password
```

---

## 📖 Endpoints da API

Após subir a aplicação, acesse a documentação interativa em:

**http://localhost:8080/swagger-ui.html**

### Resumo dos endpoints

| Método | Rota | Descrição |
|--------|------|-----------|
| `POST` | `/inventory/add?name={nome}&quantity={qtd}` | Adiciona um novo produto ao estoque |
| `POST` | `/inventory/remove?name={nome}&quantity={qtd}` | Remove unidades de um produto existente |
| `GET` | `/inventory/{name}` | Consulta um produto pelo nome |
| `GET` | `/inventory` | Lista todos os produtos cadastrados |

### Exemplos de uso

```bash
# Adicionar um produto
curl -X POST "http://localhost:8080/inventory/add?name=Notebook&quantity=10"

# Consultar um produto
curl "http://localhost:8080/inventory/Notebook"

# Listar todos os produtos
curl "http://localhost:8080/inventory"

# Remover unidades
curl -X POST "http://localhost:8080/inventory/remove?name=Notebook&quantity=3"
```

---

## 🧪 Rodando os testes

```bash
./mvnw test
```

O projeto já inclui testes de integração validando:
- Persistência correta dos produtos
- Regra de negócio que impede estoque negativo

---

## 📂 Estrutura do projeto

```
inventory-app/
├── src/
│   ├── main/
│   │   ├── java/br/dev/luanderson/inventoryapp/
│   │   │   ├── InventoryAppApplication.java    # Ponto de entrada
│   │   │   ├── controller/                      # Endpoints REST
│   │   │   ├── services/                        # Regras de negócio
│   │   │   ├── repositories/                    # Acesso a dados (JPA)
│   │   │   └── entities/                        # Modelos JPA
│   │   └── resources/
│   │       └── application.yaml                 # Configurações
│   └── test/                                     # Testes automatizados
├── pom.xml                                       # Dependências Maven
├── mvnw / mvnw.cmd                               # Maven Wrapper
└── README.md
```

## 👨‍💻 Autor

**Luanderson Mendes**
DevOps Expert & Software Engineer

- 🔗 LinkedIn: [in/luanmendes-dev](https://linkedin.com/in/luanmendes-dev)
- 💻 GitHub: [github.com/Luanderson-Dev](https://github.com/Luanderson-Dev)

---

## 📄 Licença

Este projeto é disponibilizado para fins educacionais como material de apoio ao curso **Do Zero ao Deploy**. Sinta-se à vontade para clonar, estudar e adaptar.

---

<p align="center">
  <i>Um projeto feito para ensinar. Uma aplicação pensada para aprender.</i>
</p>
