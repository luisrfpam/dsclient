# dsclient - Desafio 1 - Bootcamp Devsuperior - Spring

Qual o objetivo deste Desafio?

Criar um projeto Spring Boot contendo um CRUD completo de web services REST para acessar um recurso de clientes, contendo cinco operações básicas conforme descrito abaixo:
* Busca paginada de recursos
* Busca de recurso por id
* Inserir novo recurso
* Atualizar recurso
* Deletar recurso

O projeto está configurado para acessar o banco de dados H2. E usando Maven como gerenciador de dependências e Java 11 como linguagem.

### Entidade desenvolvida:

Um cliente possui nome, CPF, renda, data de nascimento, e quantidade de filhos. A especificação da entidade Client é mostrada a seguir:

![image](https://user-images.githubusercontent.com/16855746/161449114-f1fbb85e-7893-4e51-89c8-08621f6cfab3.png)

## SQL para seed da base de dados de teste
O projeto está configurado com um seed de 15 clientes. O arquivo que contém o Seed do banco de dados pode ser acessado em: Resources.

```SQL
INSERT INTO tb_client (name, cpf, income, birth_date, children) VALUES ('Luis Carlos', '15638259023', 3000, TIMESTAMP WITH TIME ZONE '1986-07-11', 2);
INSERT INTO tb_client (name, cpf, income, birth_date, children) VALUES ('Augusto Henrique', '29373798006', 5000, TIMESTAMP WITH TIME ZONE '1985-02-10', 1);
INSERT INTO tb_client (name, cpf, income, birth_date, children) VALUES ('Paulo Brito', '72891796098', 3500, TIMESTAMP WITH TIME ZONE '1984-08-09', 0);
INSERT INTO tb_client (name, cpf, income, birth_date, children) VALUES ('Sebastian Caio', '15146824002', 2000, TIMESTAMP WITH TIME ZONE '1983-08-11', 1);
INSERT INTO tb_client (name, cpf, income, birth_date, children) VALUES ('Antonio Mesquita', '75065992010', 1500, TIMESTAMP WITH TIME ZONE '1982-12-07', 3);
INSERT INTO tb_client (name, cpf, income, birth_date, children) VALUES ('Aurelio Silva', '00658506021', 4500, TIMESTAMP WITH TIME ZONE '1981-11-06', 1);
INSERT INTO tb_client (name, cpf, income, birth_date, children) VALUES ('Tiago Alencar', '90720690056', 10000, TIMESTAMP WITH TIME ZONE'1980-01-05', 2);
INSERT INTO tb_client (name, cpf, income, birth_date, children) VALUES ('Maria Jose', '08104811037', 1000, TIMESTAMP WITH TIME ZONE '1979-11-04', 2);
INSERT INTO tb_client (name, cpf, income, birth_date, children) VALUES ('Luciana Souza', '87169380030', 1600, TIMESTAMP WITH TIME ZONE '1988-06-12', 1);
INSERT INTO tb_client (name, cpf, income, birth_date, children) VALUES ('Roberta Souza', '91497036097', 2400, TIMESTAMP WITH TIME ZONE '1988-03-13', 2);
INSERT INTO tb_client (name, cpf, income, birth_date, children) VALUES ('Priscila Alamo', '00978580052', 3400, TIMESTAMP WITH TIME ZONE '1990-04-14', 0);
INSERT INTO tb_client (name, cpf, income, birth_date, children) VALUES ('Paula Guimaraes', '79211324050', 2700, TIMESTAMP WITH TIME ZONE '1978-05-15', 0);
INSERT INTO tb_client (name, cpf, income, birth_date, children) VALUES ('Simone Francisca', '70037649035', 1500, TIMESTAMP WITH TIME ZONE '1986-08-16', 1);
INSERT INTO tb_client (name, cpf, income, birth_date, children) VALUES ('Neiriane de Paula', '21763619036', 4500, TIMESTAMP WITH TIME ZONE '1989-01-17', 1);
INSERT INTO tb_client (name, cpf, income, birth_date, children) VALUES ('Mario Jose', '55128554090', 3100, TIMESTAMP WITH TIME ZONE '1985-04-18', 2);
```

## Objetos JSON para inserir e atualizar um cliente

Para que você veja as operações de CRUD utilize o Postman e realize as requisições conforme abaixo:

### Busca paginada de clientes
* Retorna uma lista de clientes de acordo com os parâmetros: page, linesPerPage, direction e orderBy
```JSON
GET /clients?page=0&linesPerPage=6&direction=ASC&orderBy=name
```

### Busca de cliente por id
* Busca o cliente com Id 1
```JSON
GET /clients/1
```

### Inserção de novo cliente
```JSON
POST /clients
{
  "name": "Maria Silva",
  "cpf": "12345678901",
  "income": 6500.0,
  "birthDate": "1994-07-20T10:30:00Z",
  "children": 2
}
```

### Atualização de cliente
* Atualiza as informações do cliente de Id 1
```JSON
PUT /clients/1
{
  "name": "Maria Silvaaa",
  "cpf": "12345678901",
  "income": 6500.0,
  "birthDate": "1994-07-20T10:30:00Z",
  "children": 2
}
```

* Se você tentar atualizar um cliente com código que não existe o retorno virá com error de: "Resource not found"
```JSON
{
    "timestamp": "2022-04-03T21:30:33.338890500Z",
    "status": 404,
    "error": "Resource not found",
    "message": "Id not found 1",
    "path": "/clients/1"
}
```

### Deleção de cliente
```JSON
DELETE /clients/1
```
* Se você tentar deletar um cliente com código que não existe o retorno virá com error de: "Resource not found"

```JSON
{
    "timestamp": "2022-04-03T21:28:46.829150500Z",
    "status": 404,
    "error": "Resource not found",
    "message": "Id not found 1",
    "path": "/clients/1"
}
```

### Projeto desenvolvido em Spring Boot 2.6
### Caso tenham alguma dúvida referente a construção do CRUD pode me dá um ping :) 
### Observação: No spring boot 2.6 o método <>.getOne(id) está depreciado.
