
// DTO para la transferencia de datos de usuario.
// Representa la información de un usuario que se envía entre capas de la aplicación.
package udec.actividad2.crudhexagonal.application.dto;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

// Clase que representa los datos de un usuario.
public class UserDTO {
    // Identificador único del usuario.
    private UUID id;
    // Nombre de usuario.
    private String username;
    // Correo electrónico del usuario.
    private String email;
    // Roles asignados al usuario.
    private Set<String> roles;
    // Fecha de creación del usuario.
    private LocalDateTime createdAt;

    // Constructor para inicializar los atributos del usuario.
    public UserDTO(UUID id, String username, String email, Set<String> roles, LocalDateTime createdAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.createdAt = createdAt;
    }

    // Métodos getter para acceder a los atributos.
    public UUID getId() { return id; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public Set<String> getRoles() { return roles; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
