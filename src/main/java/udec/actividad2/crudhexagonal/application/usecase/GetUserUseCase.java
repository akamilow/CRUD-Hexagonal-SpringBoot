
// Caso de uso para obtener la información de un usuario por su ID.
package udec.actividad2.crudhexagonal.application.usecase;

import udec.actividad2.crudhexagonal.application.dto.UserDTO;
import udec.actividad2.crudhexagonal.application.mapper.UserMapper;
import udec.actividad2.crudhexagonal.domain.repository.UserRepository;

import java.util.UUID;

// Clase que gestiona la lógica para consultar usuarios.
public class GetUserUseCase {
    // Repositorio de usuarios para acceder a los datos.
    private final UserRepository userRepository;

    // Constructor que recibe el repositorio de usuarios.
    public GetUserUseCase(UserRepository userRepository) { this.userRepository = userRepository; }

    // Método principal que ejecuta la consulta de usuario.
    // id: identificador único del usuario a consultar.
    // Retorna un UserDTO con la información del usuario encontrado o lanza excepción si no existe.
    public UserDTO execute(UUID id) {
        return userRepository.findById(id).map(UserMapper::toDTO)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
    }
}
