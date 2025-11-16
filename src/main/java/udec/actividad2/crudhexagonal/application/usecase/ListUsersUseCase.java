package udec.actividad2.crudhexagonal.application.usecase;

import udec.actividad2.crudhexagonal.application.dto.UserDTO;
import udec.actividad2.crudhexagonal.application.mapper.UserMapper;
import udec.actividad2.crudhexagonal.domain.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ListUsersUseCase {
    private final UserRepository userRepository;

    public ListUsersUseCase(UserRepository userRepository) { this.userRepository = userRepository; }

    public List<UserDTO> execute() {
        return userRepository.findAll().stream().map(UserMapper::toDTO).collect(Collectors.toList());
    }
}
