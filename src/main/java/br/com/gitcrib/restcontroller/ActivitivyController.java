package br.com.gitcrib.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gitcrib.model.Activity;
import br.com.gitcrib.service.ActivityService;

@RestController
@RequestMapping("/actvitivy")
@CrossOrigin(origins = "*")
public class ActivitivyController {

    @Autowired
    private ActivityService activityService;

    @PostMapping("/remove-activity/{idContributor}/{idTask}")
    @ResponseBody
    public ResponseEntity<Void> removeActivity(@PathVariable("idContributor") Integer idContributor, @PathVariable("idTask") Integer idTask) {
        
        Activity activity = activityService.findActivityByContributorTask(idContributor, idTask);
        activityService.deletarActivity(activity.getId());

        return ResponseEntity.ok().build();
    }
}
