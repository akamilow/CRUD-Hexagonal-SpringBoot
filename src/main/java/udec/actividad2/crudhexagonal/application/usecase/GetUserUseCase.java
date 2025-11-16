package udec.actividad2.crudhexagonal.application.usecase;

import udec.actividad2.crudhexagonal.application.dto.UserDTO;
import udec.actividad2.crudhexagonal.application.mapper.UserMapper;
import udec.actividad2.crudhexagonal.domain.repository.UserRepository;

import java.util.UUID;

public class GetUserUseCase {
    private final UserRepository userRepository;

    public GetUserUseCase(UserRepository userRepository) { this.userRepository = userRepository; }

    public UserDTO execute(UUID id) {
        return userRepository.findById(id).map(UserMapper::toDTO)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
    }
}
