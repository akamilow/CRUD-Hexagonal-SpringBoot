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

    public AuthController(CreateUserUseCase createUserUseCase, AuthenticateUserUseCase authenticateUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.authenticateUserUseCase = authenticateUserUseCase;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@Valid @RequestBody CreateUserRequestDTO request) {
        UserDTO created = createUserUseCase.execute(request);
        return ResponseEntity.ok(created);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody LoginRequestDTO request) {
        var user = authenticateUserUseCase.execute(request);
        return ResponseEntity.ok(new LoginResponseDTO("", user.getUsername(), user.getRoles()));
    }
}
