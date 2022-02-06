package br.com.gitcrib.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.gitcrib.model.Contributor;

public interface ContributorDao extends JpaRepository<Contributor,Integer>{

    Contributor save(Contributor contributor);

    Optional<Contributor> findById(Integer contributorId);
    
    Optional<Contributor> findByUserName(String userName);

    @Query(value = "select * from contributor c where c.email like :email and c.password like :password", nativeQuery = true)
    Optional<Contributor> findByEmailPassword(@Param("email") String email, @Param("password") String password);
    
}
