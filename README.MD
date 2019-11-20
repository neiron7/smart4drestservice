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

Find in resources folder application.properties file. Enter into the application.properties your MySQL8 database (next we will use DB) settings: DB name, username and password, so service can connect to your DB, which should have standard configuration:
```
spring.datasource.url=jdbc:mysql://localhost:3306/<YOUR DATABASE NAME>?useLegacyDatetimeCode=false&serverTimezone=UTC
spring.datasource.username= <YOUR USER NAME>
spring.datasource.password= <YOUR DATABASE PASSWORD>
```
If the DB is not locally running, then change localhost:3306 in ```.properties file``` accordingly:
```
spring.datasource.url=jdbc:mysql://<YOUR ADDRESS>:<YOUR PORT>/<YOUR DATABASE NAME>?useLegacyDatetimeCode=false&serverTimezone=UTC
```
Then build the project:
```
$ mvn install
```
and run it:
```
$ java -jar target/rest-service-1.0-SNAPSHOT.jar
```
When project running, enter in your browser address line:
```
http://localhost:8080/swagger-ui.html
```
Now you can play with specification.
Executing getAllHCPOffices GET method will give you result with already created from ```data.sql``` offices:
```
[
  {
    "id": 1,
    "name": "Office_1",
    "description": "first office",
    "xdevices": [
      {
        "id": 1,
        "name": "Device_1",
        "description": "first device"
      }
    ]
  },
  {
    "id": 2,
    "name": "Office_2",
    "description": "second office",
    "xdevices": [
      {
        "id": 2,
        "name": "Device_2",
        "description": "second device"
      },
      {
        "id": 3,
        "name": "Device_3",
        "description": "third device"
      }
    ]
  }
]
```
In registerHCPOffice POST method we can create new HCPOffice, with or without XDevices inside, later we can connect devices:
```
{
    "id": 4,
    "name": "Office_4",
    "description": "fourth office"
}
```
this will return us office without xdevice:
```
{
  "id": 3,
  "name": "Office_4",
  "description": "fourth office",
  "xdevices": []
}
```

Same works for XDevice Post method, but its enough to add id number in office object inside:
```
{
  "name": "new device",
  "description": "new device description",
  "hcpoffice": {    
    "id": 1    
  }    
}
```
this will create new device and will attach it to existing office with ```"id": 1```.

For deletion

## Built with

* [Spingboot](https://spring.io/projects/spring-boot) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Swagger UI](https://swagger.io/tools/swagger-ui/) - Specification generation and API testing

## Authors

* **Denis Fedorov** 