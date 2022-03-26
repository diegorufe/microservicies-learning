# Api de usuarios para probar comunicación entre microservicios

## Annotations to date:

### 2022/03/26

#### Realizado:

- Estructura básica para poder simular una creación de usuario.
- Enviado comando de creación a Kafka, enviando evento y reciviendo evento en la misma api

#### Pendiente/deseable

- Conectar con una base de datos, aunque sea embebida
- Tener una api externa a poder ser otro lenguage de programación que consuma el evento de creación de usuario