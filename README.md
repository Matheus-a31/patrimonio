# API de Controle de Patrimônio

API RESTful desenvolvida para o gerenciamento de equipamentos e patrimônios de uma empresa. O sistema permite cadastrar, listar, buscar por filtros específicos, atualizar e excluir equipamentos, com validações de regra de negócio para evitar duplicidade de números de série.

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3**
- **Spring Data JPA** (Hibernate)
- **PostgreSQL** (Banco de dados)
- **Maven** (Gerenciador de dependências)
- **Bean Validation** (Validação de dados)

## Pré-requisitos

Antes de começar, você precisa ter instalado em sua máquina:
- [Java JDK 17+](https://www.oracle.com/java/technologies/downloads/)
- [Maven](https://maven.apache.org/)
- [PostgreSQL](https://www.postgresql.org/)
- Um cliente para testar rotas (Ex: [Postman](https://www.postman.com/))

## Configuração

### 1. Banco de Dados
Crie um banco de dados no PostgreSQL com o nome `propriedades` (ou altere conforme sua preferência no arquivo de configuração):

```sql
CREATE DATABASE propriedades;

```

### 2. Variáveis de Ambiente

O projeto utiliza um arquivo `.env` na raiz para configurar o banco de dados de forma segura.

Crie um arquivo `.env` na raiz do projeto com o seguinte conteúdo:

```properties
DB_URL=postgresql://localhost:5432/propriedades
DB_USERNAME=postgres
DB_PASSWORD=sua_senha_aqui

```

*Observação: O sistema trata automaticamente a string de conexão, adicionando o prefixo `jdbc:` se necessário.*

## Como Rodar

1. Clone o repositório:
```bash
git clone https://github.com/Matheus-a31/patrimonio.git

```


2. Entre na pasta do projeto:
```bash
cd patrimonio

```


3. Instale as dependências e compile:
```bash
mvn clean install

```


4. Execute a aplicação:
```bash
mvn spring-boot:run

```


A API estará rodando em: `http://localhost:8080`

## Endpoints da API

Aqui estão as principais rotas disponíveis:

### Equipamentos

| Método | Rota | Descrição |
| --- | --- | --- |
| **GET** | `/api/equipamentos/` | Lista todos os equipamentos |
| **GET** | `/api/equipamentos/{id}` | Busca um equipamento pelo ID |
| **GET** | `/api/equipamentos/tipo/{tipo}` | Busca equipamentos por Tipo (ex: Monitor) |
| **GET** | `/api/equipamentos/serial/{serial}` | Busca equipamento pelo Número de Série |
| **POST** | `/api/equipamentos/` | Cadastra um novo equipamento |
| **PUT** | `/api/equipamentos/{id}` | Atualiza os dados de um equipamento |
| **DELETE** | `/api/equipamentos/{id}` | Remove um equipamento |

### Exemplo de JSON (Corpo da Requisição)

**Para Criar (POST) ou Atualizar (PUT):**

```json
{
  "nome": "Notebook Dell Latitude",
  "tipo": "Notebook",
  "numeroSerie": "SN123456",
  "descricao": "Notebook do setor de desenvolvimento"
}

```

##  Testando com Postman

Na pasta raiz do projeto, você pode encontrar o arquivo `equipamentos.json`. Importe este arquivo no Postman para ter acesso a todas as requisições pré-configuradas.


Desenvolvido por **Matheus de Assis**

```
