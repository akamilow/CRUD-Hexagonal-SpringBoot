
// Entidad de dominio que representa a un usuario en el sistema.
// Contiene la información y lógica relacionada con el usuario.
package udec.actividad2.crudhexagonal.domain.model;

import udec.actividad2.crudhexagonal.domain.valueobject.Email;
import udec.actividad2.crudhexagonal.domain.valueobject.HashedPassword;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

// Clase principal del modelo de usuario.
public class User {
    // Identificador único del usuario.
    private final UUID id;
    // Nombre de usuario.
    private String username;
    // Correo electrónico del usuario (value object).
    private Email email;
    // Contraseña hasheada del usuario (value object).
    private HashedPassword password;
    // Roles asignados al usuario.
    private final Set<String> roles;
    // Fecha de creación del usuario.
    private final LocalDateTime createdAt;

    // Constructor privado, usado internamente para crear instancias.
    private User(UUID id, String username, Email email, HashedPassword password, Set<String> roles, LocalDateTime createdAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles == null ? new HashSet<>() : new HashSet<>(roles);
        this.createdAt = createdAt == null ? LocalDateTime.now() : createdAt;
    }

    // Método de fábrica para crear un nuevo usuario.
    // Valida que el nombre de usuario no sea nulo ni vacío.
    public static User createNew(String username, Email email, HashedPassword password, Set<String> roles) {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username es requerido");
        }
        return new User(UUID.randomUUID(), username.trim(), email, password, roles, LocalDateTime.now());
    }

    // Métodos getter para acceder a los atributos del usuario.
    public UUID getId() { return id; }
    public String getUsername() { return username; }
    public Email getEmail() { return email; }
    public HashedPassword getPassword() { return password; }
    public Set<String> getRoles() { return Collections.unmodifiableSet(roles); }
    public LocalDateTime getCreatedAt() { return createdAt; }

    // Métodos para modificar atributos del usuario.
    // Cambia el correo electrónico.
    public void changeEmail(Email newEmail) { this.email = newEmail; }
    // Cambia la contraseña.
    public void changePassword(HashedPassword newPassword) { this.password = newPassword; }
    // Cambia el nombre de usuario, validando que no sea nulo ni vacío.
    public void changeUsername(String newUsername) {
        if (newUsername == null || newUsername.isBlank()) throw new IllegalArgumentException("Username inválido");
        this.username = newUsername.trim();
    }
    // Cambia los roles asignados al usuario.
    public void setRoles(Set<String> newRoles) {
        roles.clear();
        if (newRoles != null) roles.addAll(newRoles);
    }

    // Métodos para comparar usuarios por su ID.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
