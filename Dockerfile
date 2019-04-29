FROM openjdk:8-alpine

COPY target/uberjar/luminus-mongodb-evaluation.jar /luminus-mongodb-evaluation/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/luminus-mongodb-evaluation/app.jar"]
