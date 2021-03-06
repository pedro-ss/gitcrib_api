package br.com.gitcrib.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.gitcrib.enums.StatusTasksEnum;
import lombok.Data;
@Data
public class TaskDTO {
	
    private Integer taskId;
	
	@NotBlank
    @NotEmpty
    @Size(max=255, min=2)
    private String title;
	
    private StatusTasksEnum status;
    
    @NotEmpty
    @NotBlank
    @Size(max=255, min=2)
    private String description;
    
    @NotNull
    private Integer projectId;
}
