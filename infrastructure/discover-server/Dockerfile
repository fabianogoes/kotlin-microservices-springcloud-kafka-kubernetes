FROM adoptopenjdk:11-jre-hotspot
EXPOSE 8761
ARG JAR_FILE=target/discover-server*.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]