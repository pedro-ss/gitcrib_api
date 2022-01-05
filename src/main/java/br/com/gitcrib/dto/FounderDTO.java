package br.com.gitcrib.dto;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import br.com.gitcrib.utils.annotation.ValidPassword;
import lombok.Data;

@Data
public class FounderDTO {
	@NotNull
	private Integer founderId;
	
	@NotBlank
    @NotEmpty
    @Max(255)
    private String userName;
	
	@NotBlank
    @NotEmpty
    @ValidPassword
    private String password;
	
	@NotBlank
    @NotEmpty
    @Max(255)
    private String name;
     
    @Nullable
    private Long points;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate since;
    
    @Nullable
    private Integer age;
}
