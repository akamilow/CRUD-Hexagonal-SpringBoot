package udec.actividad2.crudhexagonal.domain.repository;

import udec.actividad2.crudhexagonal.domain.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    Optional<User> findById(UUID id);
    Optional<User> findByUsername(String username);
    List<User> findAll();
    User save(User user);
    void deleteById(UUID id);
    boolean existsByUsername(String username);
}
