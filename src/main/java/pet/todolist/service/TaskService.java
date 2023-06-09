package pet.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.todolist.entity.TaskEntity;
import pet.todolist.entity.UserEntity;
import pet.todolist.model.Task;
import pet.todolist.repository.TaskRepository;
import pet.todolist.repository.UserRepository;

import java.util.List;


@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository, UserService userService, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public TaskEntity getTask(int id) {
        TaskEntity task = taskRepository.findById(id).orElse(null);
        UserEntity user = userRepository.findById(task.getOwner().getId()).get();
        task.setOwner(user);
        return task;
    }

    public List<TaskEntity> getUserTasks(int id) {
        return taskRepository.findAllByOwnerId(id);
    }

    public TaskEntity createTask(TaskEntity task, int ownerId) {
        UserEntity user = userRepository.findById(ownerId).get();
        task.setOwner(user);
        return taskRepository.save(task);
    }

    public TaskEntity updateTask(TaskEntity task) {
        return taskRepository.save(task);
    }

    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }

    public TaskEntity completeTask(int taskId) {
        TaskEntity task = taskRepository.findById(taskId).get();
        task.setDone(true);
        return taskRepository.save(task);
    }

    public List<TaskEntity> getAllTasks() {
        return taskRepository.findAll();
    }
}
