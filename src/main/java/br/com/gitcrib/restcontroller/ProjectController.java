package br.com.gitcrib.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
    public ProjectDTO cadastrarProject(@RequestBody ProjectDTO project) {
        return projectService.cadastrarProject(project);
    }

    @GetMapping("/find-project")
    @ResponseBody
    public Optional<ProjectDTO> consultarProject(@RequestBody ProjectDTO project) {
        return projectService.consultarProject(project.getProjectId());
    }

    @GetMapping("/list-projects")
    @ResponseBody
    public List<ProjectDTO> consultarProjects() {
        return projectService.consultarProjects();
    }

    @DeleteMapping("/delete-project")
    public void deletarProject(@RequestBody ProjectDTO project) {
        projectService.deletarProject(project.getProjectId());
    }

    @PutMapping("/update-project")
    @ResponseBody
    public ProjectDTO alterarProject(@RequestBody ProjectDTO project) {
        return projectService.alterarProject(project);
    }
}
