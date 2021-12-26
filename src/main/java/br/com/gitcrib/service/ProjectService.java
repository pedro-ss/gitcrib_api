package br.com.gitcrib.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gitcrib.dao.ProjectDao;
import br.com.gitcrib.model.Project;

@Service
public class ProjectService {

    @Autowired
    private ProjectDao projectDao;

    public Project cadastrarProject(Project project) {
        return projectDao.save(project);
    }

    public Optional<Project> consultarProject(Integer projectId) {
        return projectDao.findById(projectId);
    }

    public void deletarProject(Integer projectId) {
        projectDao.deleteById(projectId);
    }

    public List<Project> consultarProjects() {
        return projectDao.findAll();
    }

    public Project alterarProject(Project project) {
        return projectDao.save(project);
    }
}
