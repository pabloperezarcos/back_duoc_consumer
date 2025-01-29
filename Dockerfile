# Usa una imagen base de Java
FROM openjdk:17-jdk-alpine

# Establece el directorio de trabajo en el contenedor
WORKDIR /app

# Argumento para el JAR generado por Maven
ARG JAR_FILE=target/back_duoc_consumer-0.0.1-SNAPSHOT.jar

# Copia el archivo JAR al contenedor
COPY ${JAR_FILE} app.jar

# Copia el wallet al contenedor
COPY src/main/resources/wallet /app/wallet

# Expone el puerto 8081
EXPOSE 8081

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
