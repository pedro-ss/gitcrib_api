package br.com.gitcrib.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gitcrib.dao.ProjectDao;
import br.com.gitcrib.dto.FounderDTO;
import br.com.gitcrib.dto.ProjectDTO;
import br.com.gitcrib.model.Founder;
import br.com.gitcrib.model.Project;

@Service
public class ProjectService {

    @Autowired
    private ProjectDao projectDao;

    public ProjectDTO cadastrarProject(ProjectDTO project) {
        return convertProjectToDTO(projectDao.save(convertDTOToProject(project)));
    }

    public Optional<ProjectDTO> consultarProject(Integer projectId) {
        return  projectDao.findById(projectId).stream().map(this::convertProjectToDTO).findFirst();
    }

    public void deletarProject(Integer projectId) {
        projectDao.deleteById(projectId);
    }

    public List<ProjectDTO> consultarProjects() {
        List<ProjectDTO> listaProjectDto = new ArrayList<>();
		
		projectDao.findAll().forEach(founder -> {
			listaProjectDto.add(convertProjectToDTO(founder));
		});
		return listaProjectDto;
    }

    public ProjectDTO alterarProject(ProjectDTO project) {
        return convertProjectToDTO(projectDao.save(convertDTOToProject(project)));
    }
    
    private ProjectDTO convertProjectToDTO(Project project) {
    	ProjectDTO projectDTO = new ProjectDTO();
    	projectDTO.setProjectId(project.getId());
    	projectDTO.setDescription(project.getDescription());
    	if(project.getFounder() != null) {
    		projectDTO.setFounder(project.getFounder());
        	projectDTO.setFounderId(project.getFounder().getId());
    	}
    	projectDTO.setProjectStatus(project.getProjectStatus());
    	projectDTO.setTasks(project.getTasks());
    	return projectDTO;
    }
    
    private Project convertDTOToProject(ProjectDTO projectDTO) {
    	Project project = new Project();
    	project.setId(projectDTO.getProjectId());
    	project.setDescription(projectDTO.getDescription());
    	project.setFounder(projectDTO.getFounder());
    	project.setProjectStatus(projectDTO.getProjectStatus());
    	project.setTasks(projectDTO.getTasks());
    	return project;
    }
}
