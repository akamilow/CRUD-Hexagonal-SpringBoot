
// DTO para la creación de un nuevo usuario.
// Contiene los datos necesarios para registrar un usuario en el sistema.
package udec.actividad2.crudhexagonal.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

// Clase que representa la solicitud de creación de usuario.
public class CreateUserRequestDTO {
    // Nombre de usuario, no puede estar vacío.
    @NotBlank
    private String username;
    // Correo electrónico, debe ser válido y no vacío.
    @Email
    @NotBlank
    private String email;
    // Contraseña del usuario, no puede estar vacía.
    @NotBlank
    private String password;
    // Roles asignados al usuario.
    private Set<String> roles;

    // Métodos getter y setter para acceder y modificar los atributos.
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Set<String> getRoles() { return roles; }
    public void setRoles(Set<String> roles) { this.roles = roles; }
}
