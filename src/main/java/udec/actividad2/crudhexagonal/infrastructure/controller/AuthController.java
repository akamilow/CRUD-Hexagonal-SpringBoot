
// Controlador REST para la autenticación y registro de usuarios.
// Expone los endpoints para registrar y autenticar usuarios en la API.
package udec.actividad2.crudhexagonal.infrastructure.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udec.actividad2.crudhexagonal.application.dto.CreateUserRequestDTO;
import udec.actividad2.crudhexagonal.application.dto.LoginRequestDTO;
import udec.actividad2.crudhexagonal.application.dto.LoginResponseDTO;
import udec.actividad2.crudhexagonal.application.dto.UserDTO;
import udec.actividad2.crudhexagonal.application.usecase.AuthenticateUserUseCase;
import udec.actividad2.crudhexagonal.application.usecase.CreateUserUseCase;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final CreateUserUseCase createUserUseCase;
    private final AuthenticateUserUseCase authenticateUserUseCase;

        // Constructor que recibe los casos de uso necesarios.
    public AuthController(CreateUserUseCase createUserUseCase, AuthenticateUserUseCase authenticateUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.authenticateUserUseCase = authenticateUserUseCase;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@Valid @RequestBody CreateUserRequestDTO request) {
            // Endpoint para registrar un nuevo usuario.
            // Recibe los datos del usuario y retorna el usuario creado.
        UserDTO created = createUserUseCase.execute(request);
        return ResponseEntity.ok(created);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody LoginRequestDTO request) {
            // Endpoint para autenticar un usuario.
            // Recibe los datos de login y retorna la respuesta con el usuario autenticado.
        var user = authenticateUserUseCase.execute(request);
        return ResponseEntity.ok(new LoginResponseDTO("", user.getUsername(), user.getRoles()));
    }
}
