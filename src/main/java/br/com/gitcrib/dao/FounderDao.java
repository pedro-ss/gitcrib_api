package br.com.gitcrib.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.gitcrib.dto.FounderDTO;
import br.com.gitcrib.model.Founder;

public interface FounderDao extends JpaRepository<Founder, Integer>{
	
	@Query(value = "select * from founder f where f.email like :email and f.password like :password", nativeQuery = true)
	Optional<Founder> findByEmailPassword(@Param("email") String email, @Param("password") String password);
    
	Optional<Founder> findById(Integer founderId);
}
