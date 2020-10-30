FROM openjdk:14-alpine
COPY target/graphql-cat-api-*.jar graphql-cat-api.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "graphql-cat-api.jar"]