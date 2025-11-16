package udec.actividad2.crudhexagonal.domain.service;

import udec.actividad2.crudhexagonal.domain.model.User;
import udec.actividad2.crudhexagonal.domain.repository.UserRepository;
import udec.actividad2.crudhexagonal.domain.valueobject.Email;
import udec.actividad2.crudhexagonal.domain.valueobject.HashedPassword;

import java.util.Set;

public class UserDomainService {
    private final UserRepository userRepository;

    public UserDomainService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String username, Email email, HashedPassword hashedPassword, Set<String> roles) {
        if (userRepository.existsByUsername(username)) {
            throw new IllegalArgumentException("Username ya existe");
        }
        return User.createNew(username, email, hashedPassword, roles);
    }
}
