FROM openjdk:12-alpine

COPY target/dkatalis.jar /opt/dkatalis/
EXPOSE 8080
WORKDIR /opt/dkatalis/
CMD ["java", "-jar", "dkatalis.jar"]
