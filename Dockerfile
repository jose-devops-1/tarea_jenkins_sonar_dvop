# Imagen base de Java
FROM openjdk:17-jdk-alpine

# Directorio de trabajo
WORKDIR /app

# Copiar el JAR generado al contenedor
COPY target/demo-sonar-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto interno (el que Spring Boot usará)
EXPOSE 8081

# Comando para ejecutar la app y definir el puerto
ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=8081"]