package br.com.gitcrib.restcontroller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<ContributorDTO> cadastrarContributor(@Valid @RequestBody ContributorDTO ContributorDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contributorService.cadastrarContributor(ContributorDTO));
    }

    @GetMapping("/find-contributor")
    @ResponseBody
    public ResponseEntity<Optional<ContributorDTO>> consultarContributor(@Valid @RequestBody ContributorDTO ContributorDTO) {
        return ResponseEntity.ok().body(contributorService.consultarContributor(ContributorDTO.getContributorId()));
    }

    @GetMapping("/list-contributors")
    @ResponseBody
    public ResponseEntity<List<ContributorDTO>> consultarContributors() {
        return ResponseEntity.ok().body(contributorService.consultarContributors());
    }

    @DeleteMapping("/delete-contributor")
    public ResponseEntity<Void> deletarContributorDTO(@Valid @RequestBody ContributorDTO contributorDTO) {
        contributorService.deletarContributor(contributorDTO.getContributorId());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update-contributor")
    @ResponseBody
    public ResponseEntity<ContributorDTO> alterarContributorDTO(@Valid @RequestBody ContributorDTO ContributorDTO) {
        return ResponseEntity.ok().body(contributorService.alterarContributor(ContributorDTO));
    }
    
    @PostMapping("/login-contributor")
    @ResponseBody
    public ResponseEntity<Optional<ContributorDTO>> login(@RequestBody String userName, @RequestBody String password) {
        return ResponseEntity.ok().body(contributorService.consultarContributor(userName, password));
    }
    
    
}
