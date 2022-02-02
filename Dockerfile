FROM maven:3-openjdk-11 as build
ADD pom.xml /build/pom.xml
WORKDIR /build/
RUN mvn verify clean --fail-never

ADD . /build/
RUN mvn clean package 

EXPOSE 8080
  
COPY /target/gitcrib_api-0.0.1-SNAPSHOT.jar /app/app.jar
WORKDIR /app
ENTRYPOINT ["java","-jar","app.jar"]