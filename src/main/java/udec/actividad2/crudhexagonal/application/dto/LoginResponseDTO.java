
// DTO para la respuesta de inicio de sesión.
// Contiene la información devuelta tras autenticar al usuario, como el token y los roles.
package udec.actividad2.crudhexagonal.application.dto;

import java.util.Set;

// Clase que representa la respuesta de login.
public class LoginResponseDTO {
    // Token JWT generado tras la autenticación.
    private String token;
    // Nombre de usuario autenticado.
    private String username;
    // Roles asignados al usuario.
    private Set<String> roles;

    // Constructor para inicializar los atributos.
    public LoginResponseDTO(String token, String username, Set<String> roles) {
        this.token = token;
        this.username = username;
        this.roles = roles;
    }

    // Métodos getter para acceder a los atributos.
    public String getToken() { return token; }
    public String getUsername() { return username; }
    public Set<String> getRoles() { return roles; }
}
