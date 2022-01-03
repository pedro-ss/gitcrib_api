package br.com.gitcrib.dto;

import br.com.gitcrib.enums.StatusTasksEnum;
import br.com.gitcrib.model.Project;
import lombok.Data;
@Data
public class TaskDTO {
    private Integer taskId;
    private String title;
    private StatusTasksEnum status;
    private String description;
    private Integer projectId;
    private Project project;
}
