
// Entidad JPA que representa la tabla de usuarios en la base de datos.
// Permite mapear los datos persistentes a objetos Java.
package udec.actividad2.crudhexagonal.infrastructure.persistence.jpa.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @Column(columnDefinition = "BINARY(16)")
        // Identificador único del usuario (UUID).
    private UUID id;

    @Column(nullable = false, unique = true, length = 50)
        // Nombre de usuario, único y no nulo.
    private String username;

    @Column(nullable = false, unique = true, length = 120)
        // Correo electrónico, único y no nulo.
    private String email;

    @Column(name = "password_hash", nullable = false, length = 200)
        // Contraseña hasheada del usuario.
    private String passwordHash;

    @Column(nullable = false, length = 300)
        // Roles del usuario, almacenados como cadena separada por comas.
    private String roles; // almacenadas separadas por coma

    @Column(nullable = false)
        // Fecha de creación del usuario.
    private LocalDateTime createdAt;

    protected UserEntity() {}

    public UserEntity(UUID id, String username, String email, String passwordHash, Set<String> roles, LocalDateTime createdAt) {
            // Constructor que inicializa todos los atributos de la entidad.
        this.id = id;
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        // Si roles es nulo, asigna un rol por defecto "USER"
        if (roles == null || roles.isEmpty()) {
            this.roles = "USER";
        } else {
            this.roles = String.join(",", roles);
        }
        this.createdAt = createdAt;
    }

    public UUID getId() { return id; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getPasswordHash() { return passwordHash; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public Set<String> getRoles() {
            // Convierte la cadena de roles en un Set de Strings.
        if (roles == null || roles.isBlank()) return Set.of();
        return Stream.of(roles.split(",")).map(String::trim).filter(s -> !s.isBlank()).collect(Collectors.toSet());
    }

    public void setUsername(String username) { this.username = username; }
    public void setEmail(String email) { this.email = email; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    public void setRoles(Set<String> roles) {
            // Asigna los roles, si es nulo o vacío asigna "USER" por defecto.
        if (roles == null || roles.isEmpty()) {
            this.roles = "USER";
        } else {
            this.roles = String.join(",", roles);
        }
    }
}
