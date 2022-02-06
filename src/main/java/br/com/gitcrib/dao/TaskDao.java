package br.com.gitcrib.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.gitcrib.model.Task;

public interface TaskDao extends JpaRepository<Task, Integer>{

    @Query(value = "select * from task t where t.project = :idProject", nativeQuery = true)
    public List<Task> findProjectTasks(@Param("idProject") Integer projectId);

    public Optional<Task> findById(Integer taskId);
}
