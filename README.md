# Ejercicios Track API Testing

## Generar jar
mvn clean package 

## Ejecutar jar
java -DcsvFile=./src/main/resources/empleados.csv jar numaqa-0.1.0-SNAPSHOT.jar

## URL API
http://localhost:8080/getEmpleados

## Crear docker
docker build -t stratio/numaqa:0.1.0-SNAPSHOT .

## Lanzar docker 
docker run -dit --name=numaqa stratio/numaqa:0.1.0-SNAPSHOT

## URL API en docker
http://<docker-ip>:8080/getEmpleados
