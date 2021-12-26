package br.com.gitcrib.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.gitcrib.model.Project;
import br.com.gitcrib.service.ProjectService;

@RestControllerAdvice
public class ProjectController {
    
    @Autowired
    private ProjectService projectService;

    @PostMapping("/save-project")
    public Project cadastrarProject(Project project) {
        return projectService.cadastrarProject(project);
    }

    @GetMapping("/find-project")
    public Optional<Project> consultarProject(Integer projectId) {
        return projectService.consultarProject(projectId);
    }

    @GetMapping("/list-projects")
    public List<Project> consultarProjects() {
        return projectService.consultarProjects();
    }

    @DeleteMapping("/delete-project")
    public void deletarProject(Integer projectId) {
        projectService.deletarProject(projectId);
    }

    @PutMapping("/update-project")
    public Project alterarProject(Project project) {
        return projectService.alterarProject(project);
    }
}
