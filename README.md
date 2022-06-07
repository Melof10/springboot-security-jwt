## Módulo para proyecto Java Web & Spring Boot implementando Spring Security y JWT

Se creó este proyecto con el fin de desarrollar tanto el proceso de autenticación como el de autorización.
El propósito de este módulo es poder implementar las librerías de Spring Security y JWT para poder generar el proceso de
autenticación (devolviendo un token) y el de autorización (restringiendo el acceso a ciertos endpoints dependiendo el rol de cada usuario).

## Pasos a seguir

1) Copiar y Pegar el paquete [`security`](https://github.com/Melof10/springboot-security-jwt/tree/main/src/main/java/com/melof10/auth/security) 
   que se encuentra dentro del siguiente path de este proyecto [`/src/main/java/com/melof10/auth`](https://github.com/Melof10/springboot-security-jwt/tree/main/src/main/java/com/melof10/auth) 
   a su proyecto de Spring Boot.
   
   
2) Colocar las properties para JWT en [`aplication.properties`](https://github.com/Melof10/springboot-security-jwt/blob/main/src/main/resources/application.properties) 
   que se encuentra en el siguiente path [`/src/main/resources`](https://github.com/Melof10/springboot-security-jwt/tree/main/src/main/resources) 
   de este proyecto.
   
   ``` properties
   # Security
   jwt.secret=secret
   jwt.expiration=604800
   ```
   
   Puede cambiar el valor de esas properties, lo importante es que existan.


3) Agregar al [`pom.xml`](https://github.com/Melof10/springboot-security-jwt/blob/main/pom.xml) las siguientes dependencias
   
   ``` xml
   <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-security -->
   <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
   </dependency>
   <!-- https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt -->
   <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt</artifactId>
        <version>0.9.1</version>
   </dependency>
   <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
   </dependency>
   <!-- https://mvnrepository.com/artifact/com.nimbusds/nimbus-jose-jwt -->
   <dependency>
        <groupId>com.nimbusds</groupId>
        <artifactId>nimbus-jose-jwt</artifactId>
        <version>9.23</version>
   </dependency>
   ```

   
4) Vamos a levantar nuestra aplicación para que se creen `tres` tablas nuevas en nuestra Base de Datos, siempre y cuando nuestro proyecto esté conectado a la DB. 
   Para corroborar la conexión, puede inspeccionar el archivo [`application.properties`](https://github.com/Melof10/springboot-security-jwt/blob/main/src/main/resources/application.properties) 
   de este proyecto, en mi caso mi base de datos se llama `auth`

    ![Image text](https://github.com/Melof10/springboot-security-jwt/blob/main/docs/database.png)


5) Hacer los siguientes `INSERT` en la tabla `roles`

    ``` mysql
    INSERT INTO roles VALUES(NULL, 'ROLE_ADMIN');    
    ```
    ``` mysql    
    INSERT INTO roles VALUES(NULL, 'ROLE_USER');
    ```
   
    ![Image text](https://github.com/Melof10/springboot-security-jwt/blob/main/docs/roles.png)


Ya tenemos todo listo comenzar a utilizar nuestra aplicación.


## Resultados

* Registro de usuario con rol `Admin` y `User`
  
    ![Image Text](https://github.com/Melof10/springboot-security-jwt/blob/main/docs/res-register-admin.png)
  

* Inicio de Sesión con rol `Admin` y `User`, identificándome con él `email` y `password`
  
    ![Image Text](https://github.com/Melof10/springboot-security-jwt/blob/main/docs/res-login-admin.png)
  

* Registro de usuario con rol `User`

    ![Image Text](https://github.com/Melof10/springboot-security-jwt/blob/main/docs/res-register-user.png)


* Inicio de Sesión con rol `User`, identificándome con él `username` y `password`

    ![Image Text](https://github.com/Melof10/springboot-security-jwt/blob/main/docs/res-login-user.png)


* Refresh token. Recibe en el body un token para actualizarlo y darle una nueva fecha de caducidad

    ![Image Text](https://github.com/Melof10/springboot-security-jwt/blob/main/docs/res-refresh-token.png)
   

* Así quedarán nuestras tablas `users` y `role_user` después de registrar a dos usuarios diferentes con sus respectivos roles

    ![Image Text](https://github.com/Melof10/springboot-security-jwt/blob/main/docs/table-users.png)
  
    ![Image Text](https://github.com/Melof10/springboot-security-jwt/blob/main/docs/table-role_user.png)


Como verán tendremos dos formas de iniciar sesión, con el email ó username (uno u otro) y una contraseña.

Lógicamente el código es totalmente modificable, solo se hizo para dar el puntapié inicial con el fin de implementar todo lo relacionado
ál proceso de Autenticación y Autorización.
