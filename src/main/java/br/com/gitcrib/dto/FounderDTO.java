package br.com.gitcrib.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class FounderDTO {
	private Integer founderId;
    private String userName;
    private String password;
    private String name;
    private Long points;
    private LocalDate since;
}
