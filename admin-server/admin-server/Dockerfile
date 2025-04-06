# Usa una imagen oficial de Java 17
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia SOLO el archivo JAR principal (usa el nombre exacto)
COPY target/admin-server-*.jar /app.jar

# Expone el puerto
EXPOSE 9090

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]