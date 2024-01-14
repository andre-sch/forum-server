# Forum Server

## Config

### Prerequisites

- Connect to MySQL database

### ORM with Hibernate

- Using JPA standard, you must replace `persistence.example.xml` in `resources/META-INF/`
  by removing .example extension and changing connection properties – url, user and password – to your own.

### Migrations with Flyway

- Replace `flyway.example.conf` in root using the same process listed in the previous section.
- To get the current state of the database, run `mvn flyway:migrate` on terminal.
