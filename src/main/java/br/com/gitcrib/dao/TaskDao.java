package br.com.gitcrib.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gitcrib.model.Task;

public interface TaskDao extends JpaRepository<Task, Integer>{
    
}
