# Gambit-Location-Services
Microservice in the Gambit ecosystem to manange Locations, Buildings, and Rooms for batch classroom assignment.
Intergration with existing services Janus portal web application to increase existing application functionality.

### Running Application for Dev
* Make sure the yml is configured for your database (default is H2 / commented out is PostgreSQL)
* For H2: make sure that your local H2 is running when App is started to avoid connection being refused
* Right click on 'gambit-location-service

### Rest Assured Test notes
To execute the Rest Assured Test script:
* Right click on gambit-location-service
* Select 'Spring Boot App' under 'Run As' 
* Select 'RestAssuredLauncher' to run populate and connect to a testing H2 database
* Open src/test/java -> gambitLocationControllerTest
* Right click on controller to test and 'Run As' a 'JUnit test'

In order to see the automatically generated database:
* Go to http://localhost:8090/h2-console/ in your web browser
* Enter jdbc:h2:mem:jdbc:h2:mem:TEST;MVCC=true;DB_CLOSE_DELAY=-1;MODE=PostgreSQL as the JDBC URL
* Hit Connect, the pre populated tables should show up in the H2 database

### Built with
* [Spring](https://spring.io/)
* [Angular](https://angular.io/)
* [Spring Cloud Netflix](https://cloud.spring.io/spring-cloud-netflix/)
* [Kafka](https://kafka.apache.org/)
* [PostgreSql](https://www.postgresql.org/)
* [H2](http://h2database.com/html/main.html)

### Tested with
* [REST-Assured](http://rest-assured.io/)
* [JUnit](https://junit.org/junit5/)

### 1803-USF-MAR05
