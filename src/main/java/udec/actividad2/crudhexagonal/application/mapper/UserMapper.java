package udec.actividad2.crudhexagonal.application.mapper;

import udec.actividad2.crudhexagonal.application.dto.UserDTO;
import udec.actividad2.crudhexagonal.domain.model.User;

public class UserMapper {
    public static UserDTO toDTO(User user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getEmail().getValue(), user.getRoles(), user.getCreatedAt());
    }
}
