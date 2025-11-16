package udec.actividad2.crudhexagonal.application.usecase;

import udec.actividad2.crudhexagonal.domain.repository.UserRepository;

import java.util.UUID;

public class DeleteUserUseCase {
    private final UserRepository userRepository;

    public DeleteUserUseCase(UserRepository userRepository) { this.userRepository = userRepository; }

    public void execute(UUID id) {
        userRepository.deleteById(id);
    }
}
