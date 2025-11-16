# CRUD Hexagonal DDD (Spring Boot) - API Pública


## Descripción
API CRUD de usuarios con arquitectura hexagonal/DDD. Sin autenticación ni roles. Base de datos embebida H2.


## Endpoints principales
Base URL: `http://localhost:8080`

### Usuarios
1. `POST /api/auth/register` - Regsitrar usuario
  
  - Body JSON ejemplo:
```json
{
  "username":"camilo",
  "email":"camilo@gmail.com",
  "password":"camilo123",
  "roles":["ADMIN"]
}
```
2. `GET /api/users` - Lista todos los usuarios

3. `GET /api/users/{id}` - Obtiene usuario por ID

4. `POST /api/users` - Crea usuario

   - Body JSON ejemplo:
```json
{
  "username": "maria",
  "email": "maria@gmail.com",
  "password": "maria",
  "roles": ["USER"]
}
```

4. `PUT /api/users/{id}` - Actualiza usuario
   - Body JSON ejemplo:

```json
{
  "username": "maria",
  "email": "maria@gmail.com",
  "password": "maria12345",
  "roles": ["USER"]
}

```
5. `DELETE /api/users/{id}` - Elimina usuario


## Configuración
La base de datos H2 se configura automáticamente. No requiere instalación externa.
Archivo principal: `src/main/resources/application.properties`


## Compilación y ejecución
Windows:
```powershell
./mvnw.cmd clean spring-boot:run
```

## Pruebas rápidas
1. Crear usuario y verificar en la lista.
2. Actualizar y eliminar usuario.
3. Todos los endpoints son públicos, no requieren autenticación y tampoco validacion de roles.

