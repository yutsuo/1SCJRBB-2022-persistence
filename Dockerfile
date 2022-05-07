# FROM mongo:latest

# COPY ./seed /
# COPY startup.sh /
# RUN chmod +x ./startup.sh

# CMD ./startup.sh

FROM openjdk:17

COPY ./app/target/ecommerce-0.0.1-SNAPSHOT.jar /usr/src/myapp/

WORKDIR /usr/src/myapp

ENTRYPOINT ["java","-jar","/usr/src/myapp/ecommerce-0.0.1-SNAPSHOT.jar"]

