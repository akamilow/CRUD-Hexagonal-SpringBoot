
// Caso de uso para listar todos los usuarios del sistema.
package udec.actividad2.crudhexagonal.application.usecase;

import udec.actividad2.crudhexagonal.application.dto.UserDTO;
import udec.actividad2.crudhexagonal.application.mapper.UserMapper;
import udec.actividad2.crudhexagonal.domain.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

// Clase que gestiona la lógica para listar usuarios.
public class ListUsersUseCase {
    // Repositorio de usuarios para acceder a los datos.
    private final UserRepository userRepository;

    // Constructor que recibe el repositorio de usuarios.
    public ListUsersUseCase(UserRepository userRepository) { this.userRepository = userRepository; }

    // Método principal que ejecuta la consulta de todos los usuarios.
    // Retorna una lista de UserDTO con la información de cada usuario.
    public List<UserDTO> execute() {
        // Obtiene todos los usuarios, los transforma en DTO y los retorna como lista.
        return userRepository.findAll().stream().map(UserMapper::toDTO).collect(Collectors.toList());
    }
}
