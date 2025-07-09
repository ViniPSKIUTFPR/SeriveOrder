# 📝 Order Service Management

Um sistema de gerenciamento de ordens de serviço desenvolvido com Java e Spring Boot.

## 🚀 Sobre o Projeto

O **Order Service Management** é uma aplicação desenvolvida em Java com o framework Spring Boot, projetada para gerenciar ordens de serviço e seus serviços associados. A aplicação permite o cadastro, edição, exclusão e visualização de ordens de serviço, utilizando PostgreSQL como banco de dados e Thymeleaf para a renderização das interfaces web.

## ✨ Funcionalidades

-   **Cadastro de Ordens de Serviço**: Inclui informações do cliente, status e os serviços que compõem a ordem.
-   **Gerenciamento de Serviços**: Permite criar, editar e remover serviços, especificando nome, descrição, preço e horas estimadas.
-   **Listagem Completa**: Visualização de todas as ordens de serviço e serviços cadastrados no sistema.
-   **Operações CRUD**: Funcionalidades completas de edição e exclusão para ordens de serviço e serviços.

## 🛠️ Tecnologias Utilizadas

-   **Backend**: Java 21, Spring Boot
-   **Banco de Dados**: PostgreSQL
-   **Frontend**: Thymeleaf, HTML/CSS
-   **Mensageria**: RabbitMQ
-   **Build**: Maven
-   **Containerização**: Docker, Docker Compose

---

## 🏁 Começando

Para executar o projeto localmente, você pode seguir o guia de execução manual ou utilizar o Docker para uma configuração mais rápida e isolada.

**ATENÇÃO:** Para executar em conjunto com o microsserviço de envio de email, utilize o formato de execução Docker, pois o mesmo já está corretamente configurado.

### 1. Execução Manual

Siga os passos abaixo para configurar e rodar a aplicação manualmente na sua máquina.

#### Pré-requisitos

1.  **Java 21**: Certifique-se de que o Java Development Kit (JDK) 21 está instalado.
    * Verifique a versão com o comando:
        ```bash
        java -version
        ```
    * Caso não tenha, faça o download em: [https://jdk.java.net/21/](https://jdk.java.net/21/).

2.  **Maven**: Certifique-se de que o Apache Maven está instalado.
    * Verifique a versão com o comando:
        ```bash
        mvn -version
        ```
    * Caso não tenha, faça o download em: [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi).

3.  **PostgreSQL**: Instale o PostgreSQL e crie um banco de dados para a aplicação.

4.  **Configuração do Banco de Dados**:
    * Abra o arquivo `src/main/resources/application.properties`.
    * Certifique-se de que as propriedades de conexão com o banco de dados estão corretas.

    ```properties
    # Exemplo de configuração
    spring.datasource.url=jdbc:postgresql://localhost:5432/orderServiceManagement
    spring.datasource.username=postgres
    spring.datasource.password=postgres
    spring.jpa.hibernate.ddl-auto=update
    ```

5. **Configuração do RabbitMQ**
   * Abra o arquivo `src/main/resources/application.properties`.
   * Certifique-se de que as propriedades de conexão com o serviço de mensageria estão corretas.

   ```properties
   # Exemplo de configuração
   spring.rabbitmq.host=rabbitmq
   spring.rabbitmq.port=5672
   spring.rabbitmq.username=guest
   spring.rabbitmq.password=guest
   broker.queue.email.name=default.email
   ```

#### Execução do Order Service Management

1.  **Navegue até o diretório raiz** do projeto.

2.  **Compile o projeto** e gere o arquivo `.jar` (pulando os testes):
    ```bash
    mvn clean package -DskipTests
    ```

3.  **Execute a aplicação**:
    ```bash
    java -jar target/Order-Serivce-management-0.0.1-SNAPSHOT.jar
    ```

4.  **Acesse a aplicação** no seu navegador. Por padrão, ela estará disponível em:
    * [http://localhost:8080/](http://localhost:8080/)

#### Execução do serviço Email

1.  **Navegue até o diretório raiz** do projeto.

2.  **Compile o projeto** e gere o arquivo `.jar` (pulando os testes):
    ```bash
    mvn clean package -DskipTests
    ```

3.  **Execute o RabbitMQ**:
    Certifique-se que o RabbitMQ esteja rodando corretamente de acordo com suas configurações.

4.  **Execute a aplicação**:
    ```bash
    java -jar target/email-0.0.1-SNAPSHOT.jar
    ```

5.  **Aplicação rodando**: Ao ser executada, a mesma ficará aguardando um mensagem da fila.
    
---

### 2. Execução com Docker

Utilize o Docker e o Docker Compose para uma inicialização rápida e padronizada do ambiente.

#### Pré-requisitos

1.  **Docker**: Certifique-se de que o Docker Engine está instalado e em execução.
    * Verifique a instalação com:
        ```bash
        docker --version
        ```
    * Caso não tenha, faça o download em: [https://www.docker.com/products/docker-desktop/](https://www.docker.com/products/docker-desktop/).

2.  **Docker Compose**: Certifique-se de que o Docker Compose (geralmente incluído no Docker Desktop) está instalado.
    * Verifique a instalação com:
        ```bash
        docker compose version
        ```

#### Execução com Docker Compose

1.  **Navegue até a pasta raiz do projeto**, onde o arquivo `docker-compose.yml` está localizado.

2.  **Construa as imagens e inicie os containers** em modo "detached" (-d):
    ```bash
    docker compose up --build -d
    ```

    > **⚠️ Observação Importante**: O arquivo `docker-compose.yml` irá iniciar um container para o PostgreSQL. Se você já possui uma instância do PostgreSQL rodando localmente na porta padrão (5432), desative-a antes de executar o comando acima ou altere a porta no arquivo de configuração do Docker Compose para evitar conflitos.

3.  **Acesse a aplicação** no seu navegador. A aplicação estará disponível em:
    * [http://localhost:8080/](http://localhost:8080/)