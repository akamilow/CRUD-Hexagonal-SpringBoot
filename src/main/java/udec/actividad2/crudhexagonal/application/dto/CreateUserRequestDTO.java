package udec.actividad2.crudhexagonal.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public class CreateUserRequestDTO {
    @NotBlank
    private String username;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    private Set<String> roles;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Set<String> getRoles() { return roles; }
    public void setRoles(Set<String> roles) { this.roles = roles; }
}
