# Spring Boot Environment Conversion Bug Demo

Demonstrates the Spring Boot environment conversion bug

## How to Reproduce

1. Clone this repository

    `git clone https://github.com/EthanRubinson/SpringBootEnvConversionBugDemo`
  
2. Navigate to the project

    `cd SpringBootEnvConversionBugDemo`
  
3. Build it

    `mvn clean install`
  
4. Run it

    `java -jar target/demo-0.0.1-SNAPSHOT.jar`
  
App startup will fail because our custom conversion service is no longer associated with the environemnt and, consequently, there is no way to convert our custom String value to a URL.

## To See the Expected Behavior

1. Remove the entry from the application.properties file (or just remove the whole file)

    `rm src/main/resources/application.properties`
  
2. Build it

    `mvn clean install`
  
3. Run it

    `java -jar target/demo-0.0.1-SNAPSHOT.jar`
  
The app will startup successfully and you will see "http://spring.io" printed in the console.
