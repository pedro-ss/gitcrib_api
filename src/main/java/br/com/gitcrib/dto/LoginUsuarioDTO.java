package br.com.gitcrib.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class LoginUsuarioDTO {
	
    @NotBlank
    @NotEmpty
    @Size(max=200, min=2)
    @Email
    private String email;
	
	@NotBlank
    @NotEmpty
    private String password;
	

}
