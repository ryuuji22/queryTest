# Query Test API

A continuación se detalla la arquitectura de la aplicación

## Proceso de Construcción

Se utilizaron las siguientes herramientas:

 - SpringBoot con servidor tomcat por default
 - Arquitectura Hexagonal apoyado por DDD dividiendo la aplicación en Domain, Infraestructure y Application.
 - Uso del patrón de comportamiento **Mediator** para delegar la ejecución de los **Commands** desacoplando las capas.

## Proceso de ejecución
### Prerequisitos

 - Tener instalado Docker (docker compose)

### Instalación y Ejecución
 1. Clonar el repositorio.
 2. Abrir un terminal en la raíz del proyecto y ejecutar el comando `docker-compose up -d`
 3. Se incluye el dumpo de la base dentro la carpeta "scripts" el cual se ejecuta automáticamente en el contenedor.


## Documentación API
Una vez ejecutada la aplicación, se encontrará disponible un **Swagger** en la ruta http://localhost:8001/swagger-ui.html#/
A su vez el documento **RentalAPI.postman_collection.json** contiene una colección de ejemplo de las llamadas a cada endpoint para Postman. 
