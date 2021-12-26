package br.com.gitcrib.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gitcrib.dao.TaskDao;
import br.com.gitcrib.model.Task;

@Service
public class TaskService {
 
    @Autowired
    private TaskDao taskDao;

    public Task cadastrarTask(Task task) {
        return taskDao.save(task);
    }

    public Optional<Task> consultarTask(Integer taskId) {
        return taskDao.findById(taskId);
    }

    public void deletarTask(Integer taskId) {
        taskDao.deleteById(taskId);
    }

    public List<Task> consultarTasks() {
        return taskDao.findAll();
    }

    public Task alterarTask(Task task) {
        return taskDao.save(task);
    }
}
