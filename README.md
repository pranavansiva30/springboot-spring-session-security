Deployment:

       go inside springboot-spring-session-security 
    Method 1:
    needed sofware(maven ,java 1.8)

     run the command 
     
     local(default):
     mvn spring-boot:run
     
     
               
         
     
    type localhost:8181 in browser (localhost is host host name)

    method 2:

     needed sofware(maven ,java 1.8)

    run the command mvn clean install
    go inside springboot-spring-session-security/target
    
    local(default):
    java -jar springboot-spring-session-security-0.0.1-SNAPSHOT.jar
    
   
    
    
    type localhost:8181 in browser (localhost is host host name)

for stop service:
 ps -ef|grep springboot-spring-session-security-0.0.1-SNAPSHOT
 kill -9 <PID>


User Details
username:admin
password:123456
username:user
password:123456


