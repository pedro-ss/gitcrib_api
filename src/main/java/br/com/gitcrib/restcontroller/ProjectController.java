package br.com.gitcrib.restcontroller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.gitcrib.dto.ProjectDTO;
import br.com.gitcrib.service.ProjectService;

@RestControllerAdvice
@RequestMapping("/project")
public class ProjectController {
    
    @Autowired
    private ProjectService projectService;

    @PostMapping("/save-project")
    @ResponseBody
    public ResponseEntity<ProjectDTO> cadastrarProject(@Valid @RequestBody ProjectDTO project) {
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.cadastrarProject(project));
    }

    @GetMapping("/find-project")
    @ResponseBody
    public ResponseEntity<Optional<ProjectDTO>> consultarProject(@RequestBody ProjectDTO project) {
        return ResponseEntity.ok(projectService.consultarProject(project.getProjectId()));
    }

    @GetMapping("/list-projects")
    @ResponseBody
    public ResponseEntity<List<ProjectDTO>> consultarProjects() {
        return ResponseEntity.ok().body(projectService.consultarProjects());
    }

    @DeleteMapping("/delete-project")
    public ResponseEntity<Void> deletarProject(@RequestBody ProjectDTO project) {
        projectService.deletarProject(project.getProjectId());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update-project")
    @ResponseBody
    public ResponseEntity<ProjectDTO> alterarProject(@Valid @RequestBody ProjectDTO project) {
        return ResponseEntity.ok(projectService.alterarProject(project));
    }
}
