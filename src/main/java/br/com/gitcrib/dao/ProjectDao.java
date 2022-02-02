package br.com.gitcrib.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gitcrib.model.Project;

public interface ProjectDao extends JpaRepository<Project, Integer>{
    
}
