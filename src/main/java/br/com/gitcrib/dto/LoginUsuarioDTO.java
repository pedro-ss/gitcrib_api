package br.com.gitcrib.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class LoginUsuarioDTO {
	@NotBlank
    @NotEmpty
    @Size(max=255, min=2)
    private String userName;
	
	@NotBlank
    @NotEmpty
    private String password;
	

}
