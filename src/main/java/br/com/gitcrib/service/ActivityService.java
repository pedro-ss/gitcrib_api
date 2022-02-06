package br.com.gitcrib.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gitcrib.dao.ActivityDao;
import br.com.gitcrib.dao.TaskDao;
import br.com.gitcrib.dao.ContributorDao;
import br.com.gitcrib.dto.ActivityDTO;
import br.com.gitcrib.model.Activity;
import br.com.gitcrib.model.Contributor;
import br.com.gitcrib.model.Task;


@Service
public class ActivityService {
	
	@Autowired
	private ActivityDao activityDao;

	@Autowired
	private ContributorDao contributorDao;
	
	@Autowired
	private TaskDao taskDao;

	public void vincularContributorComTask(ActivityDTO activityDTO) throws Exception 
	{
		if(this.buscarAcivitiviesPorContributor(activityDTO.getContributorId()).size() < 2) {
			Optional<Task> task = taskDao.findById(activityDTO.getTaskId());
			Optional<Contributor> contributor = contributorDao.findById(activityDTO.getContributorId());
			Activity activity = Activity.builder().contributor(contributor.get()).task(task.get()).build();
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
