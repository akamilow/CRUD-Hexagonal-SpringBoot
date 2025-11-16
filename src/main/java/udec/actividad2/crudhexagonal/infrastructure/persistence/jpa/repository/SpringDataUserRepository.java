package udec.actividad2.crudhexagonal.infrastructure.persistence.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import udec.actividad2.crudhexagonal.infrastructure.persistence.jpa.entity.UserEntity;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataUserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByUsername(String username);
    boolean existsByUsername(String username);
}
