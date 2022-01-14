FROM openjdk:11-oracle
VOLUME /tmp
EXPOSE 8000
ARG JAR_FILE=backend-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
