## Módulo para proyecto Java Web & Spring Boot implementando Spring Security y JWT

Se creó este proyecto con el fin de implementar tanto el proceso de autenticación como el de autorización.
El propósito de este módulo es poder implementar las librerías de Spring Security y JWT para poder generar el proceso de
autenticación (devolviendo un token) y el de autorización.

Para eso siga los siguientes pasos.

1) Copiar y Pegar el paquete "security" que se encuentra dentro del siguiente path de este proyecto "/src/main/java/com/melof10/auth" a su 
proyecto de Spring Boot.
   
   
2) Colocar las properties para JWT en "application.properties" que se encuentra en el siguiente path "/src/main/resources".
   
   ![Image text](https://github.com/Melof10/springboot-security-jwt/blob/main/docs/properties.png)
   
   Puede cambiar el valor de esas properties, lo importante es que existan.


3) Agregar al pom.xml las siguientes dependencias
   
   ![Image text]()
   

4) Hacer dos insert en la tabla roles
   
   ![Image text]()
   
   ![Image text]()


Ya tenemos listo para lanzar nuestra aplicación


## Resultados

* Registro de usuario con rol "Admin"
  
   ![Image Text]()
  

* Login de usuariocon rol "Admin" y logueandose con el email
  
   ![Image Text]()
  

* Registro de usuario con rol "User"

  ![Image Text]()


* Login de usuario con rol "User" y logueandose con el username

   ![Image Text]()
   