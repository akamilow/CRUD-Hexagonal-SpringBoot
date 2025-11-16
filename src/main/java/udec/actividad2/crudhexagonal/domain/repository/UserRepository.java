
// Interfaz del repositorio de usuarios.
// Define los métodos para acceder y manipular los datos de usuario en la capa de dominio.
package udec.actividad2.crudhexagonal.domain.repository;

import udec.actividad2.crudhexagonal.domain.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// Métodos CRUD y de consulta para la entidad User.
public interface UserRepository {
    // Busca un usuario por su ID.
    Optional<User> findById(UUID id);
    // Busca un usuario por su nombre de usuario.
    Optional<User> findByUsername(String username);
    // Obtiene la lista de todos los usuarios.
    List<User> findAll();
    // Guarda un usuario (nuevo o actualizado).
    User save(User user);
    // Elimina un usuario por su ID.
    void deleteById(UUID id);
    // Verifica si existe un usuario por su nombre de usuario.
    boolean existsByUsername(String username);
}
