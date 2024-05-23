# SkillSwap

SkillSwap es una plataforma de intercambio de habilidades donde los usuarios pueden crear un perfil para demostrar las habilidades que pueden enseñar y buscar habilidades que necesiten aprender. Este proyecto utiliza una arquitectura basada en microservicios con tecnologías modernas.

## Tecnologías Utilizadas

- **Frontend:** Angular
- **Backend:** Java, Spring Boot
- **Base de Datos:** MySQL
- **Autenticación y Autorización:** Spring Security
- **API REST:** Spring MVC
- **ORM:** Hibernate
- **Gestión de Dependencias:** Maven
- **Control de Versiones:** Git

## Características

- Creación y gestión de perfiles de usuario.
- Publicación y búsqueda de habilidades para enseñar y aprender.
- Sistema de coincidencias para emparejar usuarios basados en habilidades.
- Sistema de mensajería para la comunicación entre usuarios.
- Panel de administración para la gestión de usuarios y habilidades.

## Instalación

### Prerrequisitos

Asegúrate de tener instalados los siguientes programas:

- [Node.js](https://nodejs.org/)
- [Angular CLI](https://angular.io/cli)
- [Java JDK 11+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/)
- [MySQL](https://www.mysql.com/)

### Backend

1. Clona el repositorio:

   ```bash
   git clone https://github.com/tu-usuario/skillswap.git
   cd skillswap/backend

2. Configura la base de datos MySQL:

3. Configura application.properties:

4. Construye y ejecuta la aplicación Spring Boot:
   ```bash
    mvn clean install
    mvn spring-boot:run

## Uso
1. Regístrate y crea tu perfil.
2. Publica las habilidades que puedes enseñar.
3. Busca habilidades que quieres aprender.
4. Conéctate con otros usuarios y empieza a intercambiar conocimientos.

## Contribución
¡Las contribuciones son bienvenidas! Sigue estos pasos para contribuir:

1. Haz un fork del repositorio.
2. Crea una nueva rama (git checkout -b feature-nueva-caracteristica).
3. Realiza tus cambios y haz commit (git commit -m 'Añadir nueva característica').
4. Sube tus cambios (git push origin feature-nueva-caracteristica).
5. Abre un Pull Request.

## Licencia
Este proyecto está bajo la licencia MIT. Consulta el archivo LICENSE para obtener más detalles.