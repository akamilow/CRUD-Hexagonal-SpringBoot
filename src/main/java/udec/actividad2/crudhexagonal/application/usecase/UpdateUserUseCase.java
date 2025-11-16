
// Caso de uso para actualizar la información de un usuario existente.
package udec.actividad2.crudhexagonal.application.usecase;

import udec.actividad2.crudhexagonal.application.dto.UpdateUserRequestDTO;
import udec.actividad2.crudhexagonal.application.dto.UserDTO;
import udec.actividad2.crudhexagonal.application.mapper.UserMapper;
import udec.actividad2.crudhexagonal.domain.repository.UserRepository;
import udec.actividad2.crudhexagonal.domain.valueobject.Email;
import udec.actividad2.crudhexagonal.domain.valueobject.HashedPassword;

import java.util.UUID;

// Clase que gestiona la lógica para actualizar usuarios.
public class UpdateUserUseCase {
    // Repositorio de usuarios para acceder y modificar datos.
    private final UserRepository userRepository;

    // Constructor que recibe el repositorio de usuarios.
    public UpdateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Método principal que ejecuta la actualización de usuario.
    // id: identificador único del usuario a actualizar.
    // request: DTO con los datos nuevos del usuario.
    // Retorna un UserDTO con la información actualizada.
    public UserDTO execute(UUID id, UpdateUserRequestDTO request) {
        // Busca el usuario por su ID, lanza excepción si no existe.
        var user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        // Actualiza el nombre de usuario.
        user.changeUsername(request.getUsername());
        // Actualiza el correo electrónico.
        user.changeEmail(new Email(request.getEmail()));
        // Si la contraseña no es nula ni vacía, la actualiza.
        if (request.getPassword() != null && !request.getPassword().isBlank()) {
            user.changePassword(new HashedPassword(request.getPassword()));
        }
        // Si los roles no son nulos, los actualiza.
        if (request.getRoles() != null) {
            user.setRoles(request.getRoles());
        }
        // Guarda el usuario actualizado y retorna el DTO correspondiente.
        return UserMapper.toDTO(userRepository.save(user));
    }
}
