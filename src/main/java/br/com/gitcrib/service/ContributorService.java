package br.com.gitcrib.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gitcrib.dao.ContributorDao;
import br.com.gitcrib.dto.ContributorDTO;
import br.com.gitcrib.model.Contributor;
import br.com.gitcrib.utils.PasswordEncoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ContributorService {
 
    @Autowired
    private ContributorDao contributorDao;
    
    public ContributorDTO cadastrarContributor(ContributorDTO contributor) {
    	contributor.setPassword(PasswordEncoder.criptografarSenha(contributor.getPassword()));
    	return convertContributorToDTO(contributorDao.save(convertDtoToContributor(contributor)));
    }

    public Optional<ContributorDTO> consultarContributor(Integer contributorId) {
    	
    	return contributorDao.findById(contributorId).stream().map(this::convertContributorToDTO).findFirst();
    }
    
    public Optional<ContributorDTO> consultarContributor(String email, String senha) throws Exception {
    	
    	Optional<Contributor> contributorFound = contributorDao.findByEmail(email);
		
		if(contributorFound.isPresent()) {
    		if(PasswordEncoder.verificacaoSenha(contributorFound.get().getPassword(), senha))
            {
            	return Optional.of(convertContributorToDTO(contributorFound.get()));
            } else {
            	throw new Exception("Usuário não encontrado");
            }
    	} else {
        	log.info("Usuário não encontrado");
    	}
		return Optional.empty();
    }

    public void deletarContributor(Integer contributorId) {
        contributorDao.deleteById(contributorId);
    }

    public List<ContributorDTO> consultarContributors() {
        List<ContributorDTO> listaContribDto = new ArrayList<>();
		
		contributorDao.findAll().forEach(contrib -> {
			listaContribDto.add(convertContributorToDTO(contrib));
		});
		return listaContribDto;
	}

    public ContributorDTO alterarContributor(ContributorDTO contributor) {
    	contributor.setPassword(PasswordEncoder.criptografarSenha(contributor.getPassword()));
        return convertContributorToDTO(contributorDao.save(convertDtoToContributor(contributor)));
    }
    
    private ContributorDTO convertContributorToDTO(Contributor contributor) {
    	return ContributorDTO.builder()
			.contributorId(contributor.getId())
			.userName(contributor.getUserName())
			.password(contributor.getPassword())
			.email(contributor.getEmail())
			.age(contributor.getAge())
			.points(contributor.getPoints())
			.since(contributor.getSince())
			.build();
    }
    
    private Contributor convertDtoToContributor(ContributorDTO contributorDTO) {
		return Contributor.builder()
			.id(contributorDTO.getContributorId())
			.userName(contributorDTO.getUserName())
			.password(contributorDTO.getPassword())
			.email(contributorDTO.getEmail())
			.age(contributorDTO.getAge())
			.points(contributorDTO.getPoints())
			.since(contributorDTO.getSince())
			.build();
    }
}
