package udec.actividad2.crudhexagonal.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import eliminado: PasswordService
import udec.actividad2.crudhexagonal.application.usecase.*;
import udec.actividad2.crudhexagonal.domain.repository.UserRepository;
import udec.actividad2.crudhexagonal.domain.service.UserDomainService;

@Configuration
public class AppConfig {

    @Bean
    public UserDomainService userDomainService(UserRepository userRepository) {
        return new UserDomainService(userRepository);
    }

    @Bean
    public CreateUserUseCase createUserUseCase(UserRepository repo, UserDomainService ds) {
        return new CreateUserUseCase(repo, ds);
    }

    @Bean
    public GetUserUseCase getUserUseCase(UserRepository repo) { return new GetUserUseCase(repo); }

    @Bean
    public ListUsersUseCase listUsersUseCase(UserRepository repo) { return new ListUsersUseCase(repo); }

    @Bean
    public UpdateUserUseCase updateUserUseCase(UserRepository repo) { return new UpdateUserUseCase(repo); }

    @Bean
    public DeleteUserUseCase deleteUserUseCase(UserRepository repo) { return new DeleteUserUseCase(repo); }

    // Bean de AuthenticateUserUseCase eliminado
    @Bean
    public AuthenticateUserUseCase authenticateUserUseCase(UserRepository repo) {
        return new AuthenticateUserUseCase(repo);
    }
}
