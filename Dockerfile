FROM openjdk:latest
COPY ./target/smMethods-1.0-SNAPSHOT-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "smMethods-1.0-SNAPSHOT-jar-with-dependencies.jar"]
