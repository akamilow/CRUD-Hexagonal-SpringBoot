
// Caso de uso para eliminar un usuario del sistema.
package udec.actividad2.crudhexagonal.application.usecase;

import udec.actividad2.crudhexagonal.domain.repository.UserRepository;

import java.util.UUID;

// Clase que gestiona la lógica para eliminar usuarios.
public class DeleteUserUseCase {
    // Repositorio de usuarios para acceder y modificar datos.
    private final UserRepository userRepository;

    // Constructor que recibe el repositorio de usuarios.
    public DeleteUserUseCase(UserRepository userRepository) { this.userRepository = userRepository; }

    // Método principal que ejecuta la eliminación de usuario.
    // id: identificador único del usuario a eliminar.
    public void execute(UUID id) {
        // Elimina el usuario del repositorio por su ID.
        userRepository.deleteById(id);
    }
}
