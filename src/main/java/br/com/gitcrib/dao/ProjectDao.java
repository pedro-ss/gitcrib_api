package br.com.gitcrib.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.gitcrib.model.Project;

public interface ProjectDao extends JpaRepository<Project, Integer>{

    @Query(value ="select * from project p where p.founder = :idFounder", nativeQuery = true)
    public List<Project> listFounderProjects(@Param("idFounder") Integer idFounder);
}
