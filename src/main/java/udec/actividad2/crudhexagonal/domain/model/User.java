package udec.actividad2.crudhexagonal.domain.model;

import udec.actividad2.crudhexagonal.domain.valueobject.Email;
import udec.actividad2.crudhexagonal.domain.valueobject.HashedPassword;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class User {
    private final UUID id;
    private String username;
    private Email email;
    private HashedPassword password;
    private final Set<String> roles;
    private final LocalDateTime createdAt;

    private User(UUID id, String username, Email email, HashedPassword password, Set<String> roles, LocalDateTime createdAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles == null ? new HashSet<>() : new HashSet<>(roles);
        this.createdAt = createdAt == null ? LocalDateTime.now() : createdAt;
    }

    public static User createNew(String username, Email email, HashedPassword password, Set<String> roles) {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username es requerido");
        }
        return new User(UUID.randomUUID(), username.trim(), email, password, roles, LocalDateTime.now());
    }

    public UUID getId() { return id; }
    public String getUsername() { return username; }
    public Email getEmail() { return email; }
    public HashedPassword getPassword() { return password; }
    public Set<String> getRoles() { return Collections.unmodifiableSet(roles); }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void changeEmail(Email newEmail) { this.email = newEmail; }
    public void changePassword(HashedPassword newPassword) { this.password = newPassword; }
    public void changeUsername(String newUsername) {
        if (newUsername == null || newUsername.isBlank()) throw new IllegalArgumentException("Username inválido");
        this.username = newUsername.trim();
    }
    public void setRoles(Set<String> newRoles) {
        roles.clear();
        if (newRoles != null) roles.addAll(newRoles);
    }

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
