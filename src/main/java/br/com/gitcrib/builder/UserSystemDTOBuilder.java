package br.com.gitcrib.builder;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.gitcrib.dto.ContributorDTO;
import br.com.gitcrib.dto.FounderDTO;
import br.com.gitcrib.dto.UserSystemDTO;

@Component
public class UserSystemDTOBuilder {
    
    public Optional<UserSystemDTO> contributorBuilder(ContributorDTO contributorDTO) {
        return Optional.of(UserSystemDTO.builder()
        .id(contributorDTO.getContributorId())
        .email(contributorDTO.getEmail())
        .password(contributorDTO.getPassword())
        .points(contributorDTO.getPoints())
        .since(contributorDTO.getSince())
        .build());
    }

    public Optional<UserSystemDTO> founderBuilder(FounderDTO founderDTO) {
        return Optional.of(UserSystemDTO.builder()
        .id(founderDTO.getFounderId())
        .email(founderDTO.getEmail())
        .password(founderDTO.getPassword())
        .points(founderDTO.getPoints())
        .since(founderDTO.getSince())
        .build());
    }
}
