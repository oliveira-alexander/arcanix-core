# Arcanix Core ERP
Backend de um ERP Financeiro desenvolvido em Java 21 e Spring Boot 3, com foco em boas práticas e arquitetura limpa.

# 🎯 Objetivo
O Arcanix Core é o backend de um sistema financeiro criado com o objetivo de estudar e aplicar tecnologias do ecossistema Java.

Este projeto reproduz boas práticas e padrões encontrados em aplicações corporativas, como:
<br><br>
• Baixo acoplamento<br>
• Testabilidade<br>
• SOLID<br>
• Código limpo<br>
• Arquitetura organizada<br>

# ⚙️ Tecnologias
• Java 21<br>
• Spring Boot 3<br>
• Spring Data JPA <br>
• Hibernate<br>
• PostgreSQL<br>
• H2 Database<br>
• Maven<br>
• MapStruct<br>
• Bean Validation<br>
• Lombok<br>
• Swagger / OpenAPI<br>
• JUnit 5<br>
• Mockito<br>

# 📂 Arquitetura do projeto
Ele utiliza a estratégia de <strong>Package By Feature</strong>- separação de pacotes por features, organizando cada domínio da aplicação de forma independente.

<img width="350" height="613" alt="image" src="https://github.com/user-attachments/assets/009350e9-7227-4a4e-bf5d-0de750d15db6" />

Desta forma a manutenção e melhorias futuras são facilmente aplicáveis.

# 🏛️ Arquitetura da aplicação
Na arquitetura da aplicação é utilizada arquitetura em camadas, separando as responsabilidades de processamento das requisições e mantendo o baixo acoplamento através das abstrações.

As camadas sendo utilizadas no momento são:

### Controllers: <br>
Responsável pela comunicação externa à API, recebendo e enviando requisições e respostas HTTP.

### Services: <br>
Processa dados das requisições e valida regras de negócio. Pode delegar a validação das regras de negócio para classes intermediárias Validators, que através das abstrações tornam o service mais limpo.

### Repositories: <br>
Comunicação direta com os bancos de dados H2 (Testes e desenvolvimento) e Postgres (Produção). Pela separação de responsabilidades, permite ao Service ser especialista nas regras de negócio e validações.

### Entities: <br>
Entidades que refletem os domínios do negócio salvos nos bancos de dados. Além disso são os próprios domínios do negócio, como Pessas, Produtos e afins.

### DTOs: <br>
Data Transference Objects ou DTOs são records para trafegar apenas as informações necessárias com base em entidades de negócio pelas camadas da aplicação, além de ocultar informações desnecessárias de serem processadas ou apresentadas em dado momento.

### Mappers: <br>
Object Mappers são classes que mapeiam ou convertem DTOs em entidades ou vice-versa. Para isso está sendo utilizado o MapStruct, que torna o processo simples através de abstrações


Além disso o uso das injeções de dependência do Spring Boot aliados ao uso da inversão de controle, geram um desacoplamento no código que o tornam manutenível e extensível.

# 💡 Funcionalidades implementadas:

## 👤 Pessoa
* Cadastro
* Atualização
* Exclusão
* Consulta por todos os registros
* Separação de Tipos de Pessoa (Pessoa Física, Pessoa Jurídica, Estrangeiros)
* Cadastros de múltiplos telefones
* Separação por Tipos de Parceiro (Cliente, Fornecedor, Funcionário)
* Bean Validations
* DTOs
* Mapper (MapStruct)
* Testes unitários

# 🧪 Testes
O projeto possui testes unitários utilizando:

* JUnit 5
* Mockito

Os testes contemplam a camada de serviço, isolando dependências através de mocks de repositório e mapper.

# ▶️ Como executar

## Clonar o Repositório:

<code> git clone https://github.com/oliveira-alexander/arcanix-core.git </code> <br>
<code> cd arcanix-core </code>

## Executar

* Windows cmd / PowerShell: <br>
<code> .\mvnw.cmd spring-boot:run -Dspring-boot.run.profiles=dev </code>

* Linux / macOS / Git Bash <br>
<code> ./mvnw spring-boot:run -Dspring-boot.run.profiles=dev </code>

## 📚 Documentação da API:

Após iniciar a aplicação:

<code> http://localhost:3001/swagger-ui/index.html </code>
