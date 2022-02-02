package br.com.gitcrib.restcontroller;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gitcrib.builder.UserSystemDTOBuilder;
import br.com.gitcrib.dto.ContributorDTO;
import br.com.gitcrib.dto.FounderDTO;
import br.com.gitcrib.dto.LoginUsuarioDTO;
import br.com.gitcrib.dto.UserSystemDTO;
import br.com.gitcrib.service.ContributorService;
import br.com.gitcrib.service.FounderService;

@RestController
@RequestMapping("/login")
public class LoginController {
    
    @Autowired
    private UserSystemDTOBuilder userSystenBuilder;
    
    @Autowired
    private ContributorService contributorService;
    
    @Autowired
    private FounderService founderService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<Optional<UserSystemDTO>> signin(@RequestBody @Valid LoginUsuarioDTO loginUsuarioDTO) throws Exception {
        Optional<UserSystemDTO> userSystemDTO = Optional.empty();
        try {
            Optional<ContributorDTO> contributor = contributorService.consultarContributor(loginUsuarioDTO.getEmail(), loginUsuarioDTO.getPassword());
            Optional<FounderDTO> founder = founderService.consultarFounder(loginUsuarioDTO.getEmail(), loginUsuarioDTO.getPassword());

            if(contributor.isPresent()) {
                userSystemDTO = userSystenBuilder.contributorBuilder(contributor.get());
            } else if(founder.isPresent()){
                userSystemDTO = userSystenBuilder.founderBuilder(founder.get());
            }

			return ResponseEntity.ok().body(userSystemDTO);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }
}
