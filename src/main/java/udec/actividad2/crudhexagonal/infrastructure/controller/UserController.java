package udec.actividad2.crudhexagonal.infrastructure.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
// import eliminado: org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import udec.actividad2.crudhexagonal.application.dto.CreateUserRequestDTO;
import udec.actividad2.crudhexagonal.application.dto.UpdateUserRequestDTO;
import udec.actividad2.crudhexagonal.application.dto.UserDTO;
import udec.actividad2.crudhexagonal.application.usecase.*;

import java.util.List;
import java.util.UUID;

import java.util.Collections;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final GetUserUseCase getUserUseCase;
    private final ListUsersUseCase listUsersUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase, GetUserUseCase getUserUseCase, ListUsersUseCase listUsersUseCase, UpdateUserUseCase updateUserUseCase, DeleteUserUseCase deleteUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.getUserUseCase = getUserUseCase;
        this.listUsersUseCase = listUsersUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> list() {
        return ResponseEntity.ok(listUsersUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> get(@PathVariable UUID id) {
        return ResponseEntity.ok(getUserUseCase.execute(id));
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@Valid @RequestBody CreateUserRequestDTO request) {
        return ResponseEntity.ok(createUserUseCase.execute(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable UUID id, @Valid @RequestBody UpdateUserRequestDTO request) {
        return ResponseEntity.ok(updateUserUseCase.execute(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<java.util.Map<String, String>> delete(@PathVariable UUID id) {
        deleteUserUseCase.execute(id);
        return ResponseEntity.ok(Collections.singletonMap("mensaje", "se ha eliminado usuario correctamente"));
    }
}
