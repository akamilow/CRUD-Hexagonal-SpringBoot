
// Caso de uso para la creación de un nuevo usuario en el sistema.
package udec.actividad2.crudhexagonal.application.usecase;

import udec.actividad2.crudhexagonal.application.dto.CreateUserRequestDTO;
import udec.actividad2.crudhexagonal.application.dto.UserDTO;
import udec.actividad2.crudhexagonal.application.mapper.UserMapper;
import udec.actividad2.crudhexagonal.domain.model.User;
import udec.actividad2.crudhexagonal.domain.repository.UserRepository;
import udec.actividad2.crudhexagonal.domain.service.UserDomainService;
import udec.actividad2.crudhexagonal.domain.valueobject.Email;
import udec.actividad2.crudhexagonal.domain.valueobject.HashedPassword;

// Clase que gestiona la lógica para crear usuarios.
public class CreateUserUseCase {
    // Repositorio de usuarios para acceder y guardar datos.
    private final UserRepository userRepository;
    // Servicio de dominio para aplicar reglas de negocio.
    private final UserDomainService domainService;

    // Constructor que recibe el repositorio y el servicio de dominio.
    public CreateUserUseCase(UserRepository userRepository, UserDomainService domainService) {
        this.userRepository = userRepository;
        this.domainService = domainService;
    }

    // Método principal que ejecuta la creación de usuario.
    // request: DTO con los datos necesarios para crear el usuario.
    // Retorna un UserDTO con la información del usuario creado.
    public UserDTO execute(CreateUserRequestDTO request) {
        // Se crea la contraseña hasheada a partir de la recibida.
        var hashed = new HashedPassword(request.getPassword());
        // Se crea el usuario aplicando las reglas de negocio.
        User user = domainService.createUser(request.getUsername(), new Email(request.getEmail()), hashed, request.getRoles());
        // Se guarda el usuario en el repositorio.
        User saved = userRepository.save(user);
        // Se transforma el usuario guardado en un DTO para retornar.
        return UserMapper.toDTO(saved);
    }
}
