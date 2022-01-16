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

@Service
public class ContributorService {
 
    @Autowired
    private ContributorDao contributorDao;
    
    public ContributorDTO cadastrarContributor(ContributorDTO contributor) {
    	
    	return convertContributorToDTO(contributorDao.save(convertDtoToContributor(contributor)));
    }

    public Optional<ContributorDTO> consultarContributor(Integer contributorId) {
    	
    	return contributorDao.findById(contributorId).stream().map(this::convertContributorToDTO).findFirst();
    }
    
    public Optional<ContributorDTO> consultarContributor(String email, String senha) {
    	
    	String usuario = email;
    	String criptografada = PasswordEncoder.criptografarSenha(senha);
        return contributorDao.findByUserNameAndPassword(email, criptografada).stream().map(this::convertContributorToDTO).findFirst();
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
        return convertContributorToDTO(contributorDao.save(convertDtoToContributor(contributor)));
    }
    
    private ContributorDTO convertContributorToDTO(Contributor contributor) {
    	ContributorDTO contributorDTO = new ContributorDTO();
    	contributorDTO.setContributorId(contributor.getId());
    	contributorDTO.setUserName(contributor.getUserName());
    	contributorDTO.setName(contributor.getName());
    	contributorDTO.setAge(contributor.getAge());
    	contributorDTO.setPoints(contributor.getPoints());
    	contributorDTO.setSince(contributor.getSince());
    	return contributorDTO;
    }
    
    private Contributor convertDtoToContributor(ContributorDTO contributorDTO) {
    	Contributor contributor = new Contributor();
		contributor.setId(contributorDTO.getContributorId());
		contributor.setUserName(contributorDTO.getUserName());
		contributor.setPassword(PasswordEncoder.criptografarSenha(contributorDTO.getPassword()));
		contributor.setName(contributorDTO.getName());
		contributor.setAge(contributorDTO.getAge());
		contributor.setPoints(contributorDTO.getPoints());
		contributor.setSince(contributorDTO.getSince());
		return contributor;
    }
}
