package br.com.gitcrib.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

import br.com.gitcrib.enums.StatusProjectEnum;
import br.com.gitcrib.model.Task;
import lombok.Data;

@Data
public class ProjectDTO {
	
	private Integer projectId;
	
	@NotEmpty
	@Size(max=255, min=2)
    private String description;
	
    private StatusProjectEnum projectStatus;
    
    @NotNull
    private Integer founderId;
    
    @Nullable
    private List<Task> tasks;
}
