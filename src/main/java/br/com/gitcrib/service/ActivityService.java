package br.com.gitcrib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gitcrib.dao.ActivityDao;
import br.com.gitcrib.dto.ActivityDTO;
import br.com.gitcrib.model.Activity;
import br.com.gitcrib.model.Contributor;
import br.com.gitcrib.model.Task;


@Service
public class ActivityService {
	
	@Autowired
	private ActivityDao activityDao;
	@Autowired
	private ContributorService contributorService;
	
	public void vincularContributorComTask(ActivityDTO activityDTO) throws Exception 
	{
		if(this.buscarAcivitiviesPorContributor(activityDTO.getContributorId()).size() < 2) {
			Task task = new Task(activityDTO.getTaskId());
			Contributor contributor = new Contributor(activityDTO.getContributorId());
			Activity activity = new Activity(0, contributor, task);
			activityDao.save(activity);
		} else {
			throw new Exception("Contribuidor não pode possuir mais de 2 atividades ativas.");
		}
	}
	
	public List<Activity> buscarAcivitiviesPorContributor(Integer idContributor) 
	{
		return activityDao.getAllActivatedActivitiesByContributor(idContributor);
	}

}
