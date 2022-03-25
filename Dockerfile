FROM openjdk:8-jdk-alpine

RUN mkdir /numaqa

COPY ./target/numaqa-0.1.0-SNAPSHOT.jar /numaqa/  
COPY ./src/main/resources/empleados.csv /numaqa/
COPY ./docker /docker 

RUN chmod 777 /docker/docker-entrypoint.sh

ENTRYPOINT ["/docker/docker-entrypoint.sh"]
