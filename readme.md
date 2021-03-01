**Description**

This is a test task that includes 2 test cases which check google.com

**Prerequisites**

- JDK8 installed
- Maven installed
- Cucumber used as framework
- Allure used as reporter

**How to run tests**

 - -mvn clean test  
 **run tests with default settings(Browser:chrome,browserWidth=1024,browserHeight=800)**
 
 - -mvn clean test allure:serve   
 **run test and generate report**
 - mvn test -DthreadCount= number       
 **where number = 1 or 2 and more if we have more tests run parallel execution**
 
 - -Dbrowser=
 - -DbrowserWidth=
 - -DbrowserHeight=




