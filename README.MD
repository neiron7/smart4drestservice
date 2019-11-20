# Smart4d REST Service

This is a test task for Smart4Diagnostics company

## Getting Started

### Prerequisites

For the service up and running, you will need a MySQL8 server running locally, Java 8, IntelliJ IDE, MAVEN 3 and any Browser.

### Installing

First, git clone the project into a directory of your wish:
```
$ git clone https://github.com/neiron7/smart4drestservice.git
```
Then start it in your IDE and build the project.

Enter into the application.properties file your database(next we will use DB) settings, like DB name, username and password, so service can connect to your DB:
```
spring.datasource.url=jdbc:mysql://localhost:3306/<YOUR DATABASE NAME>?useLegacyDatetimeCode=false&serverTimezone=UTC
spring.datasource.username= <YOUR USER NAME>
spring.datasource.password= <YOUR DATABASE PASSWORD>
```
If the DB is not locally running, then change localhost:3306 in .properties file accordingly:
```
spring.datasource.url=jdbc:mysql://<YOUR ADDRESS>:<YOUR PORT>/<YOUR DATABASE NAME>?useLegacyDatetimeCode=false&serverTimezone=UTC
```
## Built with

* [Spingboot](https://spring.io/projects/spring-boot) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Swagger UI](https://swagger.io/tools/swagger-ui/) - Specification generation and API testing

## Authors

* **Denis Fedorov** 