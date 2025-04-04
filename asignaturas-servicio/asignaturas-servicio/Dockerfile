# Usa una imagen oficial de Java 17
FROM openjdk:17-jdk-slim

# Copia SOLO el archivo JAR principal (usa el nombre exacto)
COPY target/asignaturas-servicio-*.jar /app.jar

# Expone el puerto
EXPOSE 8082

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]