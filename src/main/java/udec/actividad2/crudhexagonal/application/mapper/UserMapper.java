
// Clase utilitaria para convertir entidades de usuario en DTOs y viceversa.
package udec.actividad2.crudhexagonal.application.mapper;

import udec.actividad2.crudhexagonal.application.dto.UserDTO;
import udec.actividad2.crudhexagonal.domain.model.User;

// Mapper para transformar objetos User en UserDTO.
public class UserMapper {
    // Convierte un objeto User (entidad de dominio) en un UserDTO (transferencia de datos).
    public static UserDTO toDTO(User user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getEmail().getValue(), user.getRoles(), user.getCreatedAt());
    }
}
