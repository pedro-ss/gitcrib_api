package br.com.gitcrib.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gitcrib.model.Contributor;

public interface ContributorDao extends JpaRepository<Contributor,Integer>{

    Contributor save(Contributor contributor);

    Optional<Contributor> findById(Integer contributorId);
    
}
