FROM openjdk:12-alpine

COPY target/dkatalis.jar /opt/dkatalis/
EXPOSE 8080
WORKDIR /opt/dkatalis/
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-Xms512m", "-Xmx1g", "-jar", "dkatalis.jar"]
