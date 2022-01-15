package br.com.gitcrib.restcontroller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gitcrib.dto.TaskDTO;
import br.com.gitcrib.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/save-task")
    @ResponseBody
    public ResponseEntity<TaskDTO> cadastrarTask(@Valid @RequestBody TaskDTO task) {
        return ResponseEntity.ok(taskService.cadastrarTask(task));
    }

    @GetMapping("/find-task")
    @ResponseBody
    public ResponseEntity<Optional<TaskDTO>> consultarTask(@Valid @RequestBody TaskDTO task) {
        return ResponseEntity.ok(taskService.consultarTask(task.getTaskId()));
    }

    @GetMapping("/list-tasks")
    @ResponseBody
    public ResponseEntity<List<TaskDTO>> consultarTasks() {
        return ResponseEntity.ok(taskService.consultarTasks());
    }

    @DeleteMapping("/delete-task")
    @ResponseBody
    public ResponseEntity<Void> deletarTask(@Valid @RequestBody TaskDTO task) {
        taskService.deletarTask(task.getTaskId());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update-task")
    @ResponseBody
    public ResponseEntity<TaskDTO> alterarTask(@Valid @RequestBody TaskDTO task) {
        return ResponseEntity.ok().body(taskService.alterarTask(task));
    }
}
