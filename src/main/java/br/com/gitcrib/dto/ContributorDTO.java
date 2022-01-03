package br.com.gitcrib.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ContributorDTO {
    private Integer contributorId;
    private String userName;
    private String password;
    private String name;
    private Long points;
    private LocalDate since;
    private Integer age;
}
