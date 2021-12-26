package br.com.gitcrib.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gitcrib.model.Founder;

public interface FounderDao extends JpaRepository<Founder, Integer>{
    
}
