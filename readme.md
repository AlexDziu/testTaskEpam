# **Description**

This is a test task project which created with framework includes 2 automation tests

# **Requirements**

- JDK8 installed
- Maven installed
- Cucumber used as framework
- Allure used as reporter
- Browsers: Chrome, Opera, FireFox installed

# **How to run tests**

**Tests run with default settings: 
Browser=chrome, browserWidth=1024, browserHeight=768, threadCount=2**

 - mvn clean test allure:serve   
 **run test and generate report**

 - mvn clean test -DthreadCount=1       
 **we can pass quantity of numbers for run parallel execution**
 
 - mvn clean test -Dbrowser=opera    
**we can choose Browser: chrome, opera or fireFOx**
 
 - mvn clean test -DbrowserWidth=1600 -DbrowserHeight=1024    
 **we can set parameters for window browser**
 




