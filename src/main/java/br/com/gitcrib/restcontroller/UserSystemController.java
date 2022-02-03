package br.com.gitcrib.restcontroller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gitcrib.builder.UserSystemDTOBuilder;
import br.com.gitcrib.dto.UserSystemDTO;
import br.com.gitcrib.enums.UserTypeEnum;
import br.com.gitcrib.service.ContributorService;
import br.com.gitcrib.service.FounderService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserSystemController {
    
    @Autowired
    private UserSystemDTOBuilder userSystemBuilder;

    @Autowired
    private ContributorService contributorService;
    
    @Autowired
    private FounderService founderService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<UserSystemDTO> register(@RequestBody UserSystemDTO userSystemDTO) throws Exception {
        Integer userId = 0;
        try {
            userSystemDTO.setSince(LocalDate.now());
            userSystemDTO.setPoints(0L);
            if(userSystemDTO.getUserType().equals(UserTypeEnum.CONTRIBUTOR.getDescription())) {
                userId = contributorService.cadastrarContributor(userSystemBuilder.dtoContributorBuilder(userSystemDTO)).getContributorId();
            } else {
                userId = founderService.cadastrarFounder(userSystemBuilder.dtoFounderBuilder(userSystemDTO)).getFounderId();
            }
            userSystemDTO.setId(userId);
			return ResponseEntity.status(HttpStatus.CREATED).body(userSystemDTO);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }
}
