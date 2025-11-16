
// Adaptador que implementa el repositorio de usuarios usando JPA y Spring Data.
// Permite la comunicación entre la capa de dominio y la persistencia de datos.
package udec.actividad2.crudhexagonal.infrastructure.persistence.adapter;

import org.springframework.stereotype.Component;
import udec.actividad2.crudhexagonal.domain.model.User;
import udec.actividad2.crudhexagonal.domain.repository.UserRepository;
import udec.actividad2.crudhexagonal.domain.valueobject.Email;
import udec.actividad2.crudhexagonal.domain.valueobject.HashedPassword;
import udec.actividad2.crudhexagonal.infrastructure.persistence.jpa.entity.UserEntity;
import udec.actividad2.crudhexagonal.infrastructure.persistence.jpa.repository.SpringDataUserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
// ...existing code...
import java.util.stream.Collectors;

@Component
public class UserRepositoryAdapter implements UserRepository {

    private final SpringDataUserRepository springDataUserRepository;

        // Constructor que recibe el repositorio de Spring Data.
    public UserRepositoryAdapter(SpringDataUserRepository springDataUserRepository) {
        this.springDataUserRepository = springDataUserRepository;
    }

    @Override
    public Optional<User> findById(UUID id) {
            // Busca un usuario por su ID en la base de datos.
        if (id == null) {
            return Optional.empty();
        }
        return springDataUserRepository.findById(id).map(this::toDomain);
    }

    @Override
    public Optional<User> findByUsername(String username) {
            // Busca un usuario por su nombre de usuario.
        return springDataUserRepository.findByUsername(username).map(this::toDomain);
    }

    @Override
    public List<User> findAll() {
            // Obtiene todos los usuarios y los transforma a entidades de dominio.
        return springDataUserRepository.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    @SuppressWarnings("null")
    public User save(User user) {
            // Guarda un usuario en la base de datos.
        java.util.Objects.requireNonNull(user, "user must not be null");
        UserEntity entity = toEntity(user);
        UserEntity saved = springDataUserRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public void deleteById(UUID id) {
            // Elimina un usuario por su ID.
        if (id == null) {
            throw new IllegalArgumentException("id must not be null");
        }
        springDataUserRepository.deleteById(id);
    }

    @Override
    public boolean existsByUsername(String username) {
            // Verifica si existe un usuario por su nombre de usuario.
        return springDataUserRepository.existsByUsername(username);
    }

    private User toDomain(UserEntity entity) {
            // Transforma una entidad JPA en una entidad de dominio User.
        if (entity == null) {
            throw new IllegalArgumentException("UserEntity must not be null");
        }
        return new UserReflectiveBuilder()
            .withId(entity.getId())
            .withUsername(entity.getUsername())
            .withEmail(new Email(entity.getEmail()))
            .withPassword(new HashedPassword(entity.getPasswordHash()))
            .withRoles(entity.getRoles())
            .withCreatedAt(entity.getCreatedAt())
            .build();
    }

    private UserEntity toEntity(User user) {
            // Transforma una entidad de dominio User en una entidad JPA.
        if (user == null) {
            throw new IllegalArgumentException("User must not be null");
        }
        return new UserEntity(user.getId(), user.getUsername(), user.getEmail().getValue(), user.getPassword().getValue(), user.getRoles(), user.getCreatedAt());
    }

    /**
     * Builder interno para reconstruir el agregado User preservando encapsulamiento.
     */
    private static class UserReflectiveBuilder {
        private UUID id; private String username; private Email email; private HashedPassword password; private java.util.Set<String> roles; private java.time.LocalDateTime createdAt;
        public UserReflectiveBuilder withId(UUID id){this.id=id;return this;}
        public UserReflectiveBuilder withUsername(String u){this.username=u;return this;}
        public UserReflectiveBuilder withEmail(Email e){this.email=e;return this;}
        public UserReflectiveBuilder withPassword(HashedPassword p){this.password=p;return this;}
        public UserReflectiveBuilder withRoles(java.util.Set<String> r){this.roles=r;return this;}
        public UserReflectiveBuilder withCreatedAt(java.time.LocalDateTime t){this.createdAt=t;return this;}
        public User build(){
                // Utiliza reflexión para crear una instancia de User con todos sus atributos.
            try {
                java.lang.reflect.Constructor<User> c = User.class.getDeclaredConstructor(java.util.UUID.class,String.class,Email.class,HashedPassword.class,java.util.Set.class,java.time.LocalDateTime.class);
                c.setAccessible(true);
                return c.newInstance(id, username, email, password, roles, createdAt);
            } catch (Exception e) { throw new RuntimeException("Error creando User", e); }
        }
    }
}
