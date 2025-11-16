
// Repositorio Spring Data JPA para la entidad UserEntity.
// Permite realizar operaciones CRUD y consultas personalizadas sobre la tabla de usuarios.
package udec.actividad2.crudhexagonal.infrastructure.persistence.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import udec.actividad2.crudhexagonal.infrastructure.persistence.jpa.entity.UserEntity;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataUserRepository extends JpaRepository<UserEntity, UUID> {
    // Busca un usuario por su nombre de usuario.
    Optional<UserEntity> findByUsername(String username);
    // Verifica si existe un usuario por su nombre de usuario.
    boolean existsByUsername(String username);
}
