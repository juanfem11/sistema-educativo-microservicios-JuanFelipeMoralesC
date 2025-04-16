# sistema-educativo-microservicios-JuanFelipeMoralesC
Parcial 2 Programación avanzada 2

Este proyecto es una implementación de un sistema educativo basado en arquitectura de microservicios utilizando Spring Boot, Spring Cloud, Docker y otras tecnologías modernas. Está compuesto por varios servicios que se comunican entre sí y se gestionan de forma independiente.

Arquitectura del Proyecto


*Microservicios*

1. usuarios-servicio: Gestión de usuarios del sistema (registro, autenticación JWT, roles).

2. asignaturas-servicio: Administración de las asignaturas disponibles.

3. matriculas-servicio: Permite registrar la inscripción de usuarios a asignaturas.



*Servicios de soporte*

1. config-server: Centraliza la configuración externa de todos los microservicios desde un repositorio Git.

2. eureka-server: Registro y descubrimiento de servicios para facilitar la comunicación entre microservicios.

3. admin-server: Consola web de monitorización para visualizar el estado de los microservicios.



*Configuración externa*

sistema-educativo-config: Repositorio con los archivos .properties de configuración para cada microservicio.



*Tecnologías utilizadas*

- Java 17

- Spring Boot

- Spring Cloud (Eureka, Config, OpenFeign)

- Spring Security + JWT

- Docker y Docker Compose

- MongoDB 

- Spring Boot Admin

- Ejecución del Proyecto

*Pasos para ejecutar:*

1. Clonar el repositorio y navegar a la raíz

en bash o terminal que permita git:
*git clone https://github.com/juanfem11/sistema-educativo-microservicios-JuanFelipeMoralesC.git

*cd sistema-educativo-microservicios-JuanFelipeMoralesC



2. Levantar la solución completa con Docker

(en la terminal de la raíz del proyecto)
*docker-compose up --build*

Esto levantará:

MongoDB

config-server

eureka-server

usuarios-servicio

asignaturas-servicio

matriculas-servicio

admin-server



3. Endpoints importantes

Spring Boot Admin Dashboard: http://localhost:8081

Eureka Dashboard: http://localhost:8761

API de usuarios : http://localhost:8001/api/usuarios

API de asignaturas: http://localhost:8002/api/asignaturas

API de matrículas: http://localhost:8003/api/matriculas



*Seguridad y Autenticación*

- Se implementó autenticación y autorización con Spring Security y JWT en el microservicio de usuarios.

- El usuario se autentica con un endpoint /api/usuarios/login enviando credenciales.

- El sistema responde con un token JWT válido.

- Los roles están definidos en el payload del token.



*Configuración y descubrimiento*

Todos los microservicios se conectan al config-server para obtener su configuración externa. Estos, a su vez, se registran automáticamente en eureka-server, lo que permite que se descubran mutuamente por nombre de servicio, no por IP.



*Monitorización*

admin-server proporciona una interfaz web para monitorear el estado, salud y métricas de todos los microservicios conectados. Para que los servicios se registren correctamente en admin-server, deben tener habilitados los endpoints de Actuator y configurada su URL de administración.



*Pruebas*

Se implementaron pruebas unitarias con Mockito y pruebas de integración con WebTestClient.

Para ejecutarlas:

(Ejecutar dentro de la carpeta de cada microservicio)
mvn clean package



*Posibles Errores y Soluciones*

No se encuentra mongoTemplate: Asegurasre de que MongoDB esté levantado o correctamente configurado en el archivo application.properties o en el archivo del config-server.

Fallo de autenticación: Verificar que el JWT se esté enviando correctamente en el header y que no haya expirado.

Microservicios no aparecen en Eureka o Admin: Se debe confirmar que eureka.client.enabled=true y management.endpoints.web.exposure.include=* estén correctamente configurados.




Texto de prueba Pipeline Github Action