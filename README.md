# PruebaAVLA-BackEnd
## Prueba de admisión AVLA BackEnd

### Se da comienzo al Back-end con un registro de usuarios implementando Spring boot, JPA, Spring security y JWT.

  Se pueden registrar usuarios e iniciar sesion con ellos. El inicio de sesion o el registro entregará un bearer token que se tendrá que utilizar al momento de querer ingresar
  a otras urls del controlador.
  
  Si queremos registrar un usuario, basta con enviar una petición POST a la url **localhost:5000/api/v1/signUp** y enviar un objeto de esta forma:
  ```
{
    "name": "Stefano marin",
    "username": "stefano00",
    "password": "admin",
    "email": "stefano.marin.quintana@gmail.com",
    "role": "ADMIN"
            
}
```
  

   Si usamos Postman y vamos a la direccion **localhost:5000/api/v1/home** no se tendrá el acceso, ya que necesito un token. Si enviamos una petición POST a 
**localhost:8080/api/v1/signIn**  para
iniciar sesión, nos devolverá un token que deberemos ingresar para poder ver nuestro "Hola mundo"

## Ejemplo: Si enviamos esta petición POST en Postman a la direccion **localhost:5000/api/v1/signIn** nos debería devolver el token
```
{
    "username": "stefano00",
    "password": "admin"
}
```

## Luego con ese token, podemos ingresar a **localhost:8080/api/v1/home** mediante una petición GET sin argumentos y se debería ver nuestro "Hola mundo"

### Esto se hace para probar las configuraciones de Spring security y comenzar con la lógica del back-end.
