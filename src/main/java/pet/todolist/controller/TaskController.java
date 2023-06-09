package pet.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pet.todolist.entity.TaskEntity;
import pet.todolist.service.TaskService;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> getTask(@PathVariable(name = "id")int id) {
        return new ResponseEntity<>(taskService.getTask(id), OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TaskEntity>> getAllTasks() {
        return new ResponseEntity<>(taskService.getAllTasks(), OK);
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<List<TaskEntity>> getUserTasks(@PathVariable(name = "id")int userId) {
        return new ResponseEntity<>(taskService.getUserTasks(userId), OK);
    }

    @PostMapping
    public ResponseEntity<TaskEntity> createTask(@RequestBody TaskEntity task, @RequestParam int ownerId) {
        return new ResponseEntity<>(taskService.createTask(task, ownerId), OK);
    }

    @PutMapping
    public ResponseEntity<TaskEntity> updateTask(@RequestBody TaskEntity task) {
        return new ResponseEntity<>(taskService.updateTask(task), OK);
    }

    @PutMapping("/complete/{taskId}")
    public ResponseEntity<TaskEntity> complete(@PathVariable(name = "taskId")int taskId) {
        return new ResponseEntity<>(taskService.completeTask(taskId), OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteTask(@PathVariable(name = "id")int id){
        taskService.deleteTask(id);
        return OK;
    }
}
