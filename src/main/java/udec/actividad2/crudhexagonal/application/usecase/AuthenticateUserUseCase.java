package udec.actividad2.crudhexagonal.application.usecase;

import udec.actividad2.crudhexagonal.application.dto.LoginRequestDTO;
import udec.actividad2.crudhexagonal.domain.repository.UserRepository;
import udec.actividad2.crudhexagonal.domain.model.User;

public class AuthenticateUserUseCase {
    private final UserRepository userRepository;

    public AuthenticateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(LoginRequestDTO request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Credenciales inválidas"));
        if (!request.getPassword().equals(user.getPassword().getValue())) {
            throw new IllegalArgumentException("Credenciales inválidas");
        }
        return user;
    }
}
