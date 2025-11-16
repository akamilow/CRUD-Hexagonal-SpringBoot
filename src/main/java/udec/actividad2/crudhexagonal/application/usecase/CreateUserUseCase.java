package udec.actividad2.crudhexagonal.application.usecase;

import udec.actividad2.crudhexagonal.application.dto.CreateUserRequestDTO;
import udec.actividad2.crudhexagonal.application.dto.UserDTO;
import udec.actividad2.crudhexagonal.application.mapper.UserMapper;
import udec.actividad2.crudhexagonal.domain.model.User;
import udec.actividad2.crudhexagonal.domain.repository.UserRepository;
import udec.actividad2.crudhexagonal.domain.service.UserDomainService;
import udec.actividad2.crudhexagonal.domain.valueobject.Email;
import udec.actividad2.crudhexagonal.domain.valueobject.HashedPassword;

public class CreateUserUseCase {
    private final UserRepository userRepository;
    private final UserDomainService domainService;

    public CreateUserUseCase(UserRepository userRepository, UserDomainService domainService) {
        this.userRepository = userRepository;
        this.domainService = domainService;
    }

    public UserDTO execute(CreateUserRequestDTO request) {
        var hashed = new HashedPassword(request.getPassword());
        User user = domainService.createUser(request.getUsername(), new Email(request.getEmail()), hashed, request.getRoles());
        User saved = userRepository.save(user);
        return UserMapper.toDTO(saved);
    }
}
