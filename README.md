# PruebaAVLA-BackEnd
## Prueba de admisión AVLA BackEnd

### Se da comienzo al Back-end con un registro de usuarios implementando Spring boot, JPA, Spring security y JWT.

  Hay que destacar que el registro (SignUp) y el SignIn no están comunicados, es decir, funcionan de forma independiente 
(Cuango agrego un nuevo usuario no puedo logear con este mismo aunque ya se haya guardado en la base de datos. Se va a mejorar), por lo que para iniciar sesión se deberá
usar un usuario ya guardado en la configuración de Spring security.

   Por ejemplo si usamos Postman y vamos a la direccion **localhost:8080/api/v1/home** no se tendrá el acceso, ya que necesito un token. Si enviamos una petición POST a 
**localhost:8080/api/v1/signIn**  para
iniciar sesión, nos devolverá un token que deberemos ingresar para poder ver nuestro "Hola mundo"

## Ejemplo: Si enviamos esta petición POST en Postman a la direccion **localhost:8080/api/v1/signIn** nos debería devolver el token
```
{
    "username": "stefano02",
    "password": "stefano00"
}
```

## Luego con ese token, podemos ingresar a **localhost:8080/api/v1/home** mediante una petición GET sin argumentos y se debería ver nuestro "Hola mundo"

### Esto se hace para probar las configuraciones (Todavía faltan) de Spring security y comenzar con la lógica del back-end.
