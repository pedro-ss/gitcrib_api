package br.com.gitcrib.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserSystemDTO {
    
	private Integer id;
	
    private String userName;
	
    private String password;
	
    private String email;
     
    private Long points;
    
    private LocalDate since;

    private String userType;
}
