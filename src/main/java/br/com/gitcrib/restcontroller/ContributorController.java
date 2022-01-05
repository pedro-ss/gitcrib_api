package br.com.gitcrib.restcontroller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gitcrib.dto.ContributorDTO;
import br.com.gitcrib.service.ContributorService;

@RestController
@RequestMapping("/contributor")
public class ContributorController {
    
    @Autowired
    private ContributorService contributorService;

    @PostMapping("/save-contributor")
    @ResponseBody
    public ContributorDTO cadastrarContributor(@Valid @RequestBody ContributorDTO ContributorDTO) {
        return contributorService.cadastrarContributor(ContributorDTO);
    }

    @GetMapping("/find-contributor")
    @ResponseBody
    public Optional<ContributorDTO> consultarContributor(@Valid @RequestBody ContributorDTO ContributorDTO) {
        return contributorService.consultarContributor(ContributorDTO.getContributorId());
    }

    @GetMapping("/list-contributors")
    @ResponseBody
    public List<ContributorDTO> consultarContributors() {
        return contributorService.consultarContributors();
    }

    @DeleteMapping("/delete-contributor")
    public void deletarContributorDTO(@Valid @RequestBody ContributorDTO contributorDTO) {
        contributorService.deletarContributor(contributorDTO.getContributorId());
    }

    @PutMapping("/update-contributor")
    @ResponseBody
    public ContributorDTO alterarContributorDTO(@Valid @RequestBody ContributorDTO ContributorDTO) {
        return contributorService.alterarContributor(ContributorDTO);
    }
}
