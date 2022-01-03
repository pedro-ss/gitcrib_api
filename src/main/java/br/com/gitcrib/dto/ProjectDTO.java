package br.com.gitcrib.dto;

import java.util.List;

import br.com.gitcrib.enums.StatusProjectEnum;
import br.com.gitcrib.model.Founder;
import br.com.gitcrib.model.Task;
import lombok.Data;

@Data
public class ProjectDTO {
	private Integer projectId;
    private String description;
    private StatusProjectEnum projectStatus;
    private Integer founderId;
    private Founder founder;
    private List<Task> tasks;
}
