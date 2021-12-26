package br.com.gitcrib.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gitcrib.model.Task;
import br.com.gitcrib.service.TaskService;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/save-task")
    public Task cadastrarTask(Task task) {
        return taskService.cadastrarTask(task);
    }

    @GetMapping("/find-task")
    public Optional<Task> consultarTask(Integer taskId) {
        return taskService.consultarTask(taskId);
    }

    @GetMapping("/list-tasks")
    public List<Task> consultarTasks() {
        return taskService.consultarTasks();
    }

    @DeleteMapping("/delete-task")
    public void deletarTask(Integer taskId) {
        taskService.deletarTask(taskId);
    }

    @PutMapping("/update-task")
    public Task alterarTask(Task task) {
        return taskService.alterarTask(task);
    }
}
