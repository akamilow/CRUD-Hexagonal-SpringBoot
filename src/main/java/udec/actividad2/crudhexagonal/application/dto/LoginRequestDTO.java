
// DTO para la solicitud de inicio de sesión.
// Contiene los datos necesarios para autenticar a un usuario.
package udec.actividad2.crudhexagonal.application.dto;

import jakarta.validation.constraints.NotBlank;

// Clase que representa la solicitud de login.
public class LoginRequestDTO {
    // Nombre de usuario, no puede estar vacío.
    @NotBlank
    private String username;
    // Contraseña del usuario, no puede estar vacía.
    @NotBlank
    private String password;

    // Métodos getter y setter para acceder y modificar los atributos.
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
