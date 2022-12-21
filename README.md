# Check service

## Description
Microservice for check

### Build tool
This project uses such build tool as gradle.<br/>
Use "./gradlew bootRun" to run project.

### CSV Files Path
src\main\resources\csv\

### Manual
To start the project you need:

- Have postgresql, pgAdmin
- Create empty database in pgAdmin
- inapplication.yml set the necessary data to connect to the database:
  url, username, password.
- data in the database is filled in automatically when starting the project from csv files

## REST-services:
### GET http://localhost:8080/check/?itemId={itemId}&itemId={itemId}
##### getting products on ids
        where:
        {itemId} - id product

### DOC
JSON format:<br/>
http://localhost:8082/base/v3/api-docs/<br/>
YAML format:<br/>
http://localhost:8082/base/v3/api-docs.yaml<br/>
SWAGGER:<br/>
http://localhost:8082/base/swagger-ui/index.html<br/>



