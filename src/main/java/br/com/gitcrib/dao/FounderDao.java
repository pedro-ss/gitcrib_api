package br.com.gitcrib.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gitcrib.dto.FounderDTO;
import br.com.gitcrib.model.Founder;

public interface FounderDao extends JpaRepository<Founder, Integer>{
	
	Optional<Founder> findByUserName(String userName);
    
}
