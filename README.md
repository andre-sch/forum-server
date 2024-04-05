# Forum-server

- Confira a [documentação da API](https://andre-sch.notion.site/Forum-Server-API-6d8c15c6681e45ecb77f13a79bf458cb)
- Acesse o [deploy do servidor](https://forum-deploy.onrender.com/)

## Conceitos

O Forum providencia um ambiente para discussões entre membros de uma comunidade.  
A comunicação acontece por meio de postagens e comentários.

- Postagens podem ser agrupadas por categorias.
- Comentários formam uma estrutura hierárquica e recursiva.

Ambas podem ainda ser ranqueadas por membros.  
O voto é positivo ou negativo, exclusivamente.

O sistema controla a autenticação e autorização de usuários.

## Arquitetura

O sistema é baseado no modelo proposto por Robert C. Martin, conhecido como _Clean Architecture_.  
Segundo este paradigma, organiza-se o servidor da seguinte forma:

```text
forum/
├─── entities/
├─── features/
│    ├─── createPost/
│    │    ├─── CreatePost.java
│    │    ├─── CreatePostController.java
│    │    └─── CreatePostService.java
│    ...
├─── repositories/
├─── Main.java
...
```

O núcleo do projeto é composto por entidades – `entities/` e funcionalidades – `features/`.  
Cada funcionalidade abrange serviços, controladores e injeções de dependência.

O domínio do sistema é isolado do meio externo com o uso de interfaces e adaptadores.  
E.g. a unidade de persistência é acessada por intermédio de repositórios – `repositories/`.  
Como base nesta interface, implementa-se uma conexão com mapeamento objeto-relacional (ORM).

## Ambiente de Desenvolvimento

### Pré-requisitos

- Estabeleça uma conexão MySQL
- Instale Maven e Java Development Kit 17

### Configuração

- Informe os dados da conexão MySQL – _url_, _user_ e _password_ – na unidade
  de persistência `META-INF/` `persistence.xml` e no versionamento do banco
  `forum/flyway.conf`, substituindo os arquivos `.example`

### Execução

1. Atualize o estado do banco

   ```bash
   mvn flyway:migrate
   ```

2. Compile com o plugin `maven-assembly`

   ```bash
   mvn compile assembly:single
   ```

3. Execute o pacote

   ```bash
   java -jar target/server-1.0-jar-with-dependencies.jar
   ```
