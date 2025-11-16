
// Caso de uso para autenticar a un usuario en el sistema.
package udec.actividad2.crudhexagonal.application.usecase;

import udec.actividad2.crudhexagonal.application.dto.LoginRequestDTO;
import udec.actividad2.crudhexagonal.domain.repository.UserRepository;
import udec.actividad2.crudhexagonal.domain.model.User;

// Clase que gestiona la autenticación de usuarios.
public class AuthenticateUserUseCase {
    // Repositorio de usuarios para acceder a los datos.
    private final UserRepository userRepository;

    // Constructor que recibe el repositorio de usuarios.
    public AuthenticateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Método principal que ejecuta la autenticación.
    // request: DTO con los datos de login.
    // Retorna el usuario autenticado o lanza excepción si las credenciales son inválidas.
    public User execute(LoginRequestDTO request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Credenciales inválidas"));
        if (!request.getPassword().equals(user.getPassword().getValue())) {
            throw new IllegalArgumentException("Credenciales inválidas");
        }
        return user;
    }
}
