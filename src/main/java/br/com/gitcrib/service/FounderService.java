package br.com.gitcrib.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gitcrib.dao.FounderDao;
import br.com.gitcrib.dto.ContributorDTO;
import br.com.gitcrib.dto.FounderDTO;
import br.com.gitcrib.model.Contributor;
import br.com.gitcrib.model.Founder;
import br.com.gitcrib.utils.PasswordEncoder;

@Service
public class FounderService {
    
    @Autowired
    private FounderDao founderDao;
    
    public FounderDTO cadastrarFounder(FounderDTO founder) {
        return convertFounderToDTO(founderDao.save(convertDTOToFounder(founder)));
    }

    public Optional<FounderDTO> consultarFounder(Integer founderId) {
        return  founderDao.findById(founderId).stream().map(this::convertFounderToDTO).findFirst();
    }
    
    public Optional<FounderDTO> consultarFounder(String email, String senha) {
        return  founderDao.findByUserNameAndPassword(email, PasswordEncoder.criptografarSenha(senha)).stream().map(this::convertFounderToDTO).findFirst();
    }

    public void deletarFounder(Integer founderId) {
        founderDao.deleteById(founderId);
    }

    public List<FounderDTO> consultarFounders() {
        List<FounderDTO> listaFoundeDto = new ArrayList<>();
		
		founderDao.findAll().forEach(founder -> {
			listaFoundeDto.add(convertFounderToDTO(founder));
		});
		return listaFoundeDto;
    }

    public FounderDTO alterarFounder(FounderDTO founder) {
        return convertFounderToDTO(founderDao.save(convertDTOToFounder(founder)));
    }
    
    private FounderDTO convertFounderToDTO(Founder founder) {
    	FounderDTO founderDTO = new FounderDTO();
    	founderDTO.setFounderId(founder.getId());
    	founderDTO.setUserName(founder.getUserName());
    	founderDTO.setName(founder.getName());
    	founderDTO.setPoints(founder.getPoints());
    	founderDTO.setSince(founder.getSince());
    	return founderDTO;
    }
    
    private Founder convertDTOToFounder(FounderDTO founderDTO) {
    	Founder founder = new Founder();
    	founder.setId(founderDTO.getFounderId());
    	founder.setUserName(founderDTO.getUserName());
    	founder.setPassword(PasswordEncoder.criptografarSenha(founderDTO.getPassword()));
    	founder.setName(founderDTO.getName());
    	founder.setPoints(founderDTO.getPoints());
    	founder.setSince(founderDTO.getSince());
    	return founder;
    }
}
