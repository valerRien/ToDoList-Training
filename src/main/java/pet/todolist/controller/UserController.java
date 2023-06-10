package pet.todolist.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pet.todolist.entity.UserEntity;
import pet.todolist.service.UserService;

import java.util.List;

import static org.springframework.http.HttpStatus.*;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    @Operation(description = "Show all users")
    public ResponseEntity<List<UserEntity>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), OK);
    }

    @GetMapping("/{id}")
    @Operation(description = "Show one user Info")
    public ResponseEntity<UserEntity> getUser(@PathVariable(name = "id")int id) {
        return new ResponseEntity<>(userService.getUser(id), OK);
    }

    @PostMapping
    @Operation(description = "Create new user")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
        return new ResponseEntity<>(userService.createUser(user), OK);
    }

    @PutMapping
    @Operation(description = "Update user info")
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity user) {
        return new ResponseEntity<>(userService.updateUser(user), OK);
    }

    @DeleteMapping("/{id}")
    @Operation(description = "Delete user")
    public HttpStatus deleteUser(@PathVariable int id) {
        userService.delete(id);
        return OK;
    }
}
