package br.com.gitcrib.builder;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.gitcrib.dto.ContributorDTO;
import br.com.gitcrib.dto.FounderDTO;
import br.com.gitcrib.dto.UserSystemDTO;
import br.com.gitcrib.enums.UserTypeEnum;

@Component
public class UserSystemDTOBuilder {
    
    public Optional<UserSystemDTO> contributorBuilder(ContributorDTO contributorDTO) {
        return Optional.of(UserSystemDTO.builder()
        .id(contributorDTO.getContributorId())
        .email(contributorDTO.getEmail())
        .password(contributorDTO.getPassword())
        .points(contributorDTO.getPoints())
        .since(contributorDTO.getSince())
        .userName(contributorDTO.getUserName())
        .userType(UserTypeEnum.CONTRIBUTOR.getDescription())
        .build());
    }

    public Optional<UserSystemDTO> founderBuilder(FounderDTO founderDTO) {
        return Optional.of(UserSystemDTO.builder()
        .id(founderDTO.getFounderId())
        .email(founderDTO.getEmail())
        .password(founderDTO.getPassword())
        .points(founderDTO.getPoints())
        .since(founderDTO.getSince())
        .userName(founderDTO.getUserName())
        .userType(UserTypeEnum.FOUNDER.getDescription())
        .build());
    }

    public FounderDTO dtoFounderBuilder(UserSystemDTO userSystemDTO) {
        return FounderDTO.builder()
        .founderId(userSystemDTO.getId())
        .userName(userSystemDTO.getUserName())
        .email(userSystemDTO.getEmail())
        .password(userSystemDTO.getPassword())
        .points(userSystemDTO.getPoints())
        .since(userSystemDTO.getSince())
        .build();
    }

    public ContributorDTO dtoContributorBuilder(UserSystemDTO userSystemDTO) {
        return ContributorDTO.builder()
        .contributorId(userSystemDTO.getId())
        .userName(userSystemDTO.getUserName())
        .email(userSystemDTO.getEmail())
        .password(userSystemDTO.getPassword())
        .points(userSystemDTO.getPoints())
        .since(userSystemDTO.getSince())
        .build();
    }
}
