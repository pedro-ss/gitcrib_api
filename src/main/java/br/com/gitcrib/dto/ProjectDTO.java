package br.com.gitcrib.dto;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import br.com.gitcrib.enums.StatusProjectEnum;
import br.com.gitcrib.model.Founder;
import br.com.gitcrib.model.Task;
import lombok.Data;

@Data
public class ProjectDTO {
	@NotNull
	private Integer projectId;
	
	@NotEmpty
	@Max(255)
    private String description;
	
    private StatusProjectEnum projectStatus;
    
    @NotNull
    private Integer founderId;
    
    @Nullable
    private Founder founder;
    
    @Nullable
    private List<Task> tasks;
}
