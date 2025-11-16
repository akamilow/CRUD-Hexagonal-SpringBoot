
// Servicio de dominio para la gestión de reglas de negocio relacionadas con usuarios.
package udec.actividad2.crudhexagonal.domain.service;

import udec.actividad2.crudhexagonal.domain.model.User;
import udec.actividad2.crudhexagonal.domain.repository.UserRepository;
import udec.actividad2.crudhexagonal.domain.valueobject.Email;
import udec.actividad2.crudhexagonal.domain.valueobject.HashedPassword;

import java.util.Set;

// Clase que contiene la lógica de negocio para la creación de usuarios.
public class UserDomainService {
    // Repositorio de usuarios para validar reglas de negocio.
    private final UserRepository userRepository;

    // Constructor que recibe el repositorio de usuarios.
    public UserDomainService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Método para crear un usuario aplicando reglas de negocio.
    // Verifica que el nombre de usuario no exista antes de crear el usuario.
    public User createUser(String username, Email email, HashedPassword hashedPassword, Set<String> roles) {
        if (userRepository.existsByUsername(username)) {
            throw new IllegalArgumentException("Username ya existe");
        }
        return User.createNew(username, email, hashedPassword, roles);
    }
}
