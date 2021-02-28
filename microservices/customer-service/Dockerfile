FROM adoptopenjdk:11-jre-hotspot
EXPOSE 9092
ARG JAR_FILE=target/customer-service*.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]