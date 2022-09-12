FROM openjdk:8
EXPOSE 8080
ADD ./target/employee_crud-0.0.1-SNAPSHOT.jar employee_crud-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","employee_crud-0.0.1-SNAPSHOT.jar"]
