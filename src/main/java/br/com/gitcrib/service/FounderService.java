package br.com.gitcrib.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gitcrib.dao.FounderDao;
import br.com.gitcrib.dto.FounderDTO;
import br.com.gitcrib.model.Founder;
import br.com.gitcrib.utils.PasswordEncoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
    
    public Optional<FounderDTO> consultarFounder(String email, String senha) throws Exception {
    	
    	Optional<Founder> founder = founderDao.findByEmailPassword(email.trim(), senha.trim());
    	if(founder.isPresent()) {
			return Optional.of(convertFounderToDTO(founder.get()));
    	} else {
        	log.info("Usuário não encontrado");
        }
        return Optional.empty();
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
    	founder.setPassword(PasswordEncoder.criptografarSenha(founder.getPassword()));
        return convertFounderToDTO(founderDao.save(convertDTOToFounder(founder)));
    }
    
    private FounderDTO convertFounderToDTO(Founder founder) {
    	FounderDTO founderDTO = new FounderDTO();
    	founderDTO.setFounderId(founder.getId());
    	founderDTO.setUserName(founder.getUserName());
    	founderDTO.setPassword(founder.getPassword());
    	founderDTO.setEmail(founder.getEmail());
    	founderDTO.setPoints(founder.getPoints());
    	founderDTO.setSince(founder.getSince());
    	return founderDTO;
    }
    
    private Founder convertDTOToFounder(FounderDTO founderDTO) {
    	Founder founder = new Founder();
    	founder.setId(founderDTO.getFounderId());
    	founder.setUserName(founderDTO.getUserName());
    	founder.setPassword(founderDTO.getPassword());
    	founder.setEmail(founderDTO.getEmail());
    	founder.setPoints(founderDTO.getPoints());
    	founder.setSince(founderDTO.getSince());
    	return founder;
    }
}
