package pet.todolist.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pet.todolist.entity.UserEntity;
import pet.todolist.repository.UserRepository;

import java.util.List;


@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserEntity getUser(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    public UserEntity updateUser(UserEntity user) {
        return userRepository.save(user);
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
