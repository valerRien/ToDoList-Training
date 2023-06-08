package pet.todolist.model;

import lombok.Data;
import lombok.ToString;
import pet.todolist.entity.UserEntity;


@Data
public class User {

    @ToString.Exclude
    private int id;
    private String name;
    private String surname;

    public static User entityToModel(UserEntity entity) {
        User user = new User();
        user.setId(entity.getId());
        user.setName(entity.getName());
        user.setSurname(entity.getSurname());

        return user;
    }
}
