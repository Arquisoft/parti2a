[![Codacy Badge](https://api.codacy.com/project/badge/Grade/56939749694d403083de20f8a7e2b056)](https://www.codacy.com/app/Fuegon/parti2a?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Arquisoft/parti2a&amp;utm_campaign=Badge_Grade)
[![Build Status](https://travis-ci.org/Arquisoft/parti2a.svg?branch=master)](https://travis-ci.org/Arquisoft/parti2a)
[![codecov](https://codecov.io/gh/Arquisoft/parti2a/branch/master/graph/badge.svg)](https://codecov.io/gh/Arquisoft/parti2a)


# parti2a

[![Join the chat at https://gitter.im/Arquisoft/parti2a](https://badges.gitter.im/Arquisoft/parti2a.svg)](https://gitter.im/Arquisoft/parti2a?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://parti2a.herokuapp.com/)

Skeleton of participants module

# Authors

- Herminio García González (@herminiogg)
- Jose Emilio Labra Gayo (@labra)
- Sergio Flórez Vallina (@zerolfer)
- Rubén García Ruiz (@RubenGarciaR)
- Sonia Gestal Huelga (@sonia94)
- Luis Irazusta Lorenzo (@Fuegon)

# Funcionamiento:
## Interfaz HTML
1. Escribir en el navegador: http://localhost:8090/
2. Proporcionar los datos de login para los usuarios disponibles:
 * Login: user1, user2, ... , user10
 * Password: 1234
3. Aparecerá la pantalla que muestra los datos del usuario
 * Se puede modificar el email (se comprueba si el email es valido)
 * Se puede ir a la pantalla de cambio de contraseña
4. Cambio de contraseña:
 * Escribir la contreseña antigua
 * Escribir la nueva contraseña

## Servicio REST
   El punto de entrada se encuentra en http://localhost:8090/user.
   
   Acepta peticiones POST en formato JSON con el contenido:
   ``{"login":"login_usuario", "password":"contraseña_usuario"}``
   
   Devuelve la informacion del usuario si las credenciales en formato 
   JSON o XML segun se indique en la cabecera de la petición.
   
   Si los datos no son correctos se devuelve un error HTTP 404.
   Si los parametros no son correctos se devuelve un codigo de error HTTP 406.
   
### Formato de retorn JSON
   ```json
   {
     "firstName": "nombre",
     "lastName": "apellidos",
     "edad": edad(int),
     "id": id_usuario(long),
     "email": "email",
     "address": "direccion",
     "nationality": "nacionalidad"
   }
   ```
### Formato retorno XML
   ```xml
   <CitizenMin>
       <firstName>nombre</firstName>
       <lastName>apellidos</lastName>
       <edad>edad</edad>
       <id>id_usuario</id>
       <email>email</email>
       <address>direccion</address>
       <nationality>nacionalidad</nationality>
   </CitizenMin>
   ```
## Dashboard
1. Escribir en el navegador: http://localhost:8090/
2. Proporcionar los datos de login para los políticos disponibles:
 * Login: alcalde, concejal1, concejal2, concejal3, concejal4
 * Password: 1234
3. Aparecerá la pantalla que muestra el dashboard con las vistas disponibles para ese usuario
 * Se puede ver en detalle una sugerencia. Para ello pinchamos en el título.
 * Se puede ver en detalle un comentario. Para ello pinchamos en su contenido.
4. Los datos se actualizan automáticamente.


