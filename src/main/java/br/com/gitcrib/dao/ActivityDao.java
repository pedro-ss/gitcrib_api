package br.com.gitcrib.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.gitcrib.model.Activity;

public interface ActivityDao extends JpaRepository<Activity,Integer>{
	
	@Query(value = "SELECT AC.* FROM ACTIVITY AS AC LEFT JOIN TASK AS TA ON TA.ID = AC.TASK WHERE AC.CONTRIBUTOR = ?1 AND TA.status = 'ACTIVE'", nativeQuery = true)
	List<Activity>  getAllActivatedActivitiesByContributor(Integer CONTRIBUTOR);
}
