# soa-example
Service-Oriented Architecture (SOA) with Spring Cloud


### Este repositório contém: 

* Eureka -> Service Discovery
* Zuul -> Api Gateway
* Api Composition -> Pattern de comunicação entre os microserviços
* Tests no microservice de autenticação


### Como executar

Iniciar primeiro o `eureka-server` e `api-gateway`, o eureka-server vai ser responsável por registrar seus microserviços para saber seu status (UP, DOWN) e seu endereço (sem precisar ta passando ip fixo), o api-gateway vai funcionar como um `proxy-reverso` ele recebe a request e delega ao micro serviço certo.

Depois iniciar os demais micro serviços.


## Documentação das Rotas.

#### Gerar Token com JWT 

------------

  ##### POST
  ```localhost:8080/api/auth/```
  
  Body
  ```json
  {
    "email": "josevieira@gmail.com",
    "password": "1231231"
  }
  ```
  Response
  
  401:
  
    Não autorizado.
  
  200:
  
    eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqb3NldmllaXJhLmRldkBnbWFpbC5jb20ifQ.wZnGBhc6lcGVSypCt3RO9efCXXMdn-h-gqIqEIB7fz12rmZvwGCxstcRi1-Cj9STJA51JlJd7yJw4Ycu9Ejnew
  


#### Cadastrar Produto

---------
    
  #### POST
  ```localhost:8080/api/products/```
  
  Body
  ```json
    {
      "description": "produto 2"
    }
  
  ```
  
  Response
  
  201:
  
  ```json
    {
      "id": 16,
      "createdAt": "2018-05-20T12:21:58.865+0000",
      "updatedAt": null,
      "description": "produto 2"
    }
  ```
  #### Buscar Produto
  -------
  #### GET
  ```localhost:8080/api/products/16```
  
  Response
  
  200:
  
  ```json
    {
      "id": 16,
      "createdAt": "2018-05-20T03:00:00.000+0000",
      "updatedAt": null,
      "description": "produto 2"
    }
  ```
  
  #### Cadastrar Cliente

---------
    
  #### POST
  ```localhost:8080/api/customers/```
  
  Body
  ```json
    {
	    "name": "josé Vieira"
    }
  ```
  
  Response
  
  201:
  
  ```json
    {
      "id": 17,
      "name": "josé Vieira"
    }
  ```
  #### Buscar Cliente
  -------
  #### GET
  ```localhost:8080/api/customers/17```
  
  Response
  
  200:
  
  ```json
    {
      "id": 17,
      "name": "josé Vieira"
    }
  ```
  
 #### Cadastrar Categoria

---------
    
  #### POST
  ```localhost:8080/api/categories/```
  
  Body
  ```json
    {
      "description": "categoria de erro"
    }
  
  ```
  
  Response
  
  201:
  
  ```json
    {
      "id": 18,
      "description": "categoria de erro"
    }
  ```
  #### Buscar Categoria
  -------
  #### GET
  ```localhost:8080/api/categories/18```
  
  Response
  
  200:
  
  ```json
    {
      "id": 18,
      "description": "ERRO"
    }
  ```
  
  #### Cadastrar Logger

---------
    
  #### POST
  ```localhost:8080/api/loggers/```
  
  Body
  ```json
    {
	    "category_id": 18,
	    "product_id": 16,
	    "client_id": 17,
	    "register": "{'error': 'problema com conexão', 'novo_valor': 'valor3'}"	
    }
  
  ```
  
  Response
  
  201:
  
  ```json
    {
      "id": 19,
      "createdAt": "2018-05-20T12:31:46.354+0000",
      "updatedAt": null,
      "category_id": 18,
      "product_id": 16,
      "client_id": 17,
      "register": "{'error': 'problema com conexão', 'novo_valor': 'valor3'}"
    }
  ```
  
  #### Demais operações de CRUD...
  
  
   #### Buscar Logger por categorias

---------
    
  #### GET
  ```localhost:8080/api/loggers/categories/15```
  
  Response
  
  200:
  
  ```json
{
  "id": 19,
  "category": {
 	"id": 15,
	"description": "categoria de erro"
  },
  "product": {
	"id": 16,
	"description": "produto 2"
  },
  "cliente": {
	"id": 17,
	"name": "josé vieira"
  },
  "register": "{'error': 'problema com conexão', 'novo_valor': 'valor3'}"
}
  ```

  
  #### Buscar Logger por clientes

---------
    
  
  #### GET
  ```localhost:8080/api/loggers/customers/17```
  
  Response
  
  200:
  
 ```json
{
  "id": 19,
  "category": {
 	"id": 15,
	"description": "categoria de erro"
  },
  "product": {
	"id": 16,
	"description": "produto 2"
  },
  "cliente": {
	"id": 17,
	"name": "josé vieira"
  },
  "register": "{'error': 'problema com conexão', 'novo_valor': 'valor3'}"
}
  ```

  #### Buscar Logger por produtos

---------
    
  
  #### GET
  ```localhost:8080/api/loggers/products/16```
  
  Response
  
  200:
 ```json
{
  "id": 19,
  "category": {
 	"id": 15,
	"description": "categoria de erro"
  },
  "product": {
	"id": 16,
	"description": "produto 2"
  },
  "cliente": {
	"id": 17,
	"name": "josé vieira"
  },
  "register": "{'error': 'problema com conexão', 'novo_valor': 'valor3'}"
}
  ```







