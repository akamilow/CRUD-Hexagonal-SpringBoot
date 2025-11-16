package udec.actividad2.crudhexagonal.application.dto;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public class UserDTO {
    private UUID id;
    private String username;
    private String email;
    private Set<String> roles;
    private LocalDateTime createdAt;

    public UserDTO(UUID id, String username, String email, Set<String> roles, LocalDateTime createdAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.createdAt = createdAt;
    }

    public UUID getId() { return id; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public Set<String> getRoles() { return roles; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
