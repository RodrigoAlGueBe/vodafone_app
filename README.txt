[SE RECOMIENDA ABRIR EL README.md CON INTELLIJ]
# README - Ejecución del Proyecto Java Spring Boot desde un Archivo .ZIP

Este proyecto es una aplicación Java Spring Boot que implementa una API CRUD (Crear, Leer, Actualizar, Eliminar) para gestionar usuarios en una base de datos MongoDB. A continuación, se detallan los pasos para ejecutar la aplicación desde un archivo .ZIP en tu entorno.

## Requisitos Previos

Asegúrate de tener los siguientes requisitos previos instalados en tu sistema:

- **Java Development Kit (JDK):** Debes tener Java 21 instalado en tu sistema. Puedes verificar la versión de Java instalada ejecutando el comando `java -version`.

- **Apache Maven:** Debes tener Apache Maven 3.9.4 instalado en tu sistema. Puedes verificar la versión de Maven instalada ejecutando el comando `mvn -version`.

- **MongoDB:** Debes tener MongoDB instalado y en funcionamiento. Asegúrate de que MongoDB esté escuchando en el puerto predeterminado (27017) o ajusta la configuración de la aplicación según sea necesario para conectarte a tu instancia de MongoDB.

## Configuración del Proyecto

1. **Descarga el Archivo .ZIP:** Descarga el archivo .ZIP que contiene el proyecto desde [enlace al archivo .ZIP](url_del_archivo_zip).

2. **Descomprime el Archivo:** Extrae el contenido del archivo .ZIP en una ubicación de tu elección.

3. **Configurar la Base de Datos:** Abre el archivo `application.properties` en la carpeta `src/main/resources` y ajusta la configuración de la base de datos MongoDB según sea necesario. Asegúrate de especificar la base de datos y el puerto de tu instancia de MongoDB.

   ```properties
   spring.data.mongodb.database=vodafone_db
   spring.data.mongodb.port=27017

## Compilación y Ejecución
Una vez configurado el proyecto, puedes compilarlo y ejecutarlo:

1. **Navegar al Directorio del Proyecto:** Abre una terminal o consola y navega al directorio raíz del proyecto:
   ```properties
   cd ruta/al/directorio/del/proyecto
2. **Compilar y Ejecutar la Aplicación con Maven:** Utiliza el siguiente comando Maven para compilar y ejecutar la aplicación Spring Boot:
    ```properties
       mvn spring-boot:run

La aplicación se iniciará y estará disponible en http://localhost:8080. Asegúrate de que MongoDB esté en funcionamiento antes de iniciar la aplicación.

## Uso de la API

La aplicación expone los siguientes endpoints para gestionar usuarios:

- **Crear un nuevo usuario:** Envía una solicitud POST a `http://localhost:8080/usuarios` con un JSON que contiene los datos del usuario.
    ```properties
       {
            "name": "Nombre_ejemplo",
            "lastName": "Apellidos_ejemplo",
            "age": 20,
            "pointQuantity": 12.56
        }

- **Recuperar un usuario por ID:** Realiza una solicitud GET a `http://localhost:8080/usuarios/{id}` para recuperar un usuario por su ID.

- **Actualizar un usuario por ID:** Envía una solicitud PUT a `http://localhost:8080/usuarios/{id}` con un JSON que contiene los datos actualizados del usuario.
    ```properties
           {
                "name": null,
                "lastName": "Apellidos_a_cambiar",
                "age": 0,
                "pointQuantity": 5
            }

- **Eliminar un usuario por ID:** Realiza una solicitud DELETE a `http://localhost:8080/usuarios/{id}` para eliminar un usuario por su ID.

## Detener la Aplicación

Para detener la aplicación, simplemente presiona `Ctrl+C` en la terminal o consola donde se está ejecutando la aplicación.

Espero que estas instrucciones ayuden a ejecutar y utilizar el proyecto de manera efectiva. Si encuentras problemas o tienes preguntas adicionales, no dudes en contactar conmigo. ¡Un saludo y hasta pronto!

**Autor:** Rodrigo Alberto Guerrero Bermúdez

**Mail del autor:** rodguebe@gmail.com