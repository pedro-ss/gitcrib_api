FROM maven:3-openjdk-11 as build
ADD pom.xml /build/pom.xml
WORKDIR /build/
RUN mvn verify clean --fail-never

ADD . /build/
RUN mvn clean package 

EXPOSE 9001
  
COPY --from=build /build/target/gitcrib_api.jar /app/app.jar
WORKDIR /app
ENTRYPOINT ["java","-jar","app.jar"]