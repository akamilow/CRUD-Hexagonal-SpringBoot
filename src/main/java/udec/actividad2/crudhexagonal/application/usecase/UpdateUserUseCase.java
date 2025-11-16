package udec.actividad2.crudhexagonal.application.usecase;

import udec.actividad2.crudhexagonal.application.dto.UpdateUserRequestDTO;
import udec.actividad2.crudhexagonal.application.dto.UserDTO;
import udec.actividad2.crudhexagonal.application.mapper.UserMapper;
import udec.actividad2.crudhexagonal.domain.repository.UserRepository;
import udec.actividad2.crudhexagonal.domain.valueobject.Email;
import udec.actividad2.crudhexagonal.domain.valueobject.HashedPassword;

import java.util.UUID;

public class UpdateUserUseCase {
    private final UserRepository userRepository;

    public UpdateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO execute(UUID id, UpdateUserRequestDTO request) {
        var user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        user.changeUsername(request.getUsername());
        user.changeEmail(new Email(request.getEmail()));
        if (request.getPassword() != null && !request.getPassword().isBlank()) {
            user.changePassword(new HashedPassword(request.getPassword()));
        }
        if (request.getRoles() != null) {
            user.setRoles(request.getRoles());
        }
        return UserMapper.toDTO(userRepository.save(user));
    }
}
