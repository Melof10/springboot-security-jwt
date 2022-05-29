## Módulo para proyecto Java Web & Spring Boot implementando Spring Security y JWT

Se creó este proyecto con el fin de desarrollar tanto el proceso de autenticación como el de autorización.
El propósito de este módulo es poder implementar las librerías de Spring Security y JWT para poder generar el proceso de
autenticación (devolviendo un token) y el de autorización (restringiendo el acceso a ciertos endpoints).

Para eso siga los siguientes pasos.

1) Copiar y Pegar el paquete `security` que se encuentra dentro del siguiente path de este proyecto `/src/main/java/com/melof10/auth` a su 
proyecto de Spring Boot.
   
   
2) Colocar las properties para JWT en `aplication.properties` que se encuentra en el siguiente path `/src/main/resources` de este proyecto.
   
   ![Image text](https://github.com/Melof10/springboot-security-jwt/blob/main/docs/properties.png)
   
   Puede cambiar el valor de esas properties, lo importante es que existan.


3) Agregar al `pom.xml` las siguientes dependencias
   
   ![Image text](https://github.com/Melof10/springboot-security-jwt/blob/main/docs/dependencias.png)

   
4) Vamos a levantar nuestra aplicación para que se creen `tres` tablas nuevas en nuestra Base de Datos, siempre y cuando nuestro proyecto esté conectado a la DB.

    ![Image text](https://github.com/Melof10/springboot-security-jwt/blob/main/docs/database.png)


5) Hacer dos `INSERT` en la tabla `roles`
   
   ![Image text](https://github.com/Melof10/springboot-security-jwt/blob/main/docs/insert.png)
   
   ![Image text](https://github.com/Melof10/springboot-security-jwt/blob/main/docs/roles.png)


Ya tenemos todo listo para lanzar nuestra aplicación, al iniciar la aplicación las tablas se crearán en su base de datos.


## Resultados

* Registro de usuario con rol `Admin`
  
   ![Image Text](https://github.com/Melof10/springboot-security-jwt/blob/main/docs/res-register-admin.png)
  

* Inicio de Sesión con rol `Admin` y `email`
  
   ![Image Text](https://github.com/Melof10/springboot-security-jwt/blob/main/docs/res-login-admin.png)
  

* Registro de usuario con rol `User`

  ![Image Text](https://github.com/Melof10/springboot-security-jwt/blob/main/docs/res-register-user.png)


* Inicio de Sesión con rol `User` y `username`

   ![Image Text](https://github.com/Melof10/springboot-security-jwt/blob/main/docs/res-login-user.png)
   

Como verán tendremos dos formas de iniciar sesión, con el email ó username (uno u otro) y una contraseña.