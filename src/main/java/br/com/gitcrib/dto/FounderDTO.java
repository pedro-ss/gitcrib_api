package br.com.gitcrib.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import br.com.gitcrib.utils.annotation.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FounderDTO {
	
	private Integer founderId;
	
	@NotBlank
    @NotEmpty
    @Size(max=255, min=2)
    private String userName;
	
	@NotBlank
    @NotEmpty
    @ValidPassword
    private String password;
	
	@NotBlank
    @NotEmpty
    @Size(max=255, min=2)
    private String email;
     
    @Nullable
    private Long points;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate since;
    
    @Nullable
    private Integer age;
}
