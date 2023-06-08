package pet.todolist.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pet.todolist.entity.UserEntity;
import pet.todolist.service.UserService;

import java.util.List;

import static org.springframework.http.HttpStatus.*;


@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<UserEntity>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUser(@PathVariable(name = "id")int id) {
        return new ResponseEntity<>(userService.getUser(id), OK);
    }

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
        return new ResponseEntity<>(userService.createUser(user), OK);
    }

    @PutMapping
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity user) {
        return new ResponseEntity<>(userService.updateUser(user), OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteUser(@PathVariable int id) {
        userService.delete(id);
        return OK;
    }
}
