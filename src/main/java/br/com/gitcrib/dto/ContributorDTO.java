package br.com.gitcrib.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import br.com.gitcrib.utils.annotation.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContributorDTO {
	@NotNull
    private Integer contributorId;
	
    @NotBlank
    @NotEmpty
    @Size(max=255, min=2)
    private String userName;
    
    @NotEmpty
    @NotBlank
    @ValidPassword
    private String password;
    
    @NotEmpty
    @NotBlank
    @Size(max=255, min=2)
    @Email
    private String email;

    @Nullable
    private Long points;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate since;
    
    @Nullable
    private Integer age;
}
