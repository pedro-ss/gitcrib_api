package br.com.gitcrib.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gitcrib.dao.TaskDao;
import br.com.gitcrib.dto.TaskDTO;
import br.com.gitcrib.model.Task;

@Service
public class TaskService {
 
    @Autowired
    private TaskDao taskDao;

    public TaskDTO cadastrarTask(TaskDTO task) {
        return convertTaskToDTO(taskDao.save(convertDTOToTask(task)));
    }

    public Optional<TaskDTO> consultarTask(Integer taskId) {
        return taskDao.findById(taskId).stream().map(this::convertTaskToDTO).findFirst();
    }

    public void deletarTask(Integer taskId) {
        taskDao.deleteById(taskId);
    }

    public List<TaskDTO> consultarTasks() {
        List<TaskDTO> listTaskDto = new ArrayList<>();
        taskDao.findAll().forEach(taskItem ->{
            listTaskDto.add(convertTaskToDTO(taskItem));
        });
        return listTaskDto;
    }

    public TaskDTO alterarTask(TaskDTO task) {
        return convertTaskToDTO(taskDao.save(convertDTOToTask(task)));
    }
    
    private TaskDTO convertTaskToDTO(Task task) {
    	TaskDTO taskDTO = new TaskDTO();
    	taskDTO.setTaskId(task.getId());
    	taskDTO.setTitle(task.getTitle());
    	taskDTO.setDescription(task.getDescription());
    	if(task.getProject() != null) {
    		taskDTO.setProject(task.getProject());
    		taskDTO.setProjectId(task.getProject().getId());
    	}
    	taskDTO.setStatus(task.getStatus());
    	return taskDTO;
    }
    
    private Task convertDTOToTask(TaskDTO taskDTO) {
    	Task task = new Task();
    	task.setId(taskDTO.getTaskId());
    	task.setTitle(taskDTO.getTitle());
    	task.setDescription(taskDTO.getDescription());
    	task.setProject(taskDTO.getProject());
    	task.setStatus(taskDTO.getStatus());
		return task;
    }
}
