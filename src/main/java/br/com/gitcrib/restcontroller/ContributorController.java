package br.com.gitcrib.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gitcrib.model.Contributor;
import br.com.gitcrib.service.ContributorService;

@RestController
public class ContributorController {
    
    @Autowired
    private ContributorService contributorService;

    @PostMapping("/save-contributor")
    public Contributor cadastrarContributor(Contributor contributor) {
        return contributorService.cadastrarContributor(contributor);
    }

    @GetMapping("/find-contributor")
    public Optional<Contributor> consultarContributor(Integer contributorId) {
        return contributorService.consultarContributor(contributorId);
    }

    @GetMapping("/list-contributors")
    public List<Contributor> consultarContributors() {
        return contributorService.consultarContributors();
    }

    @DeleteMapping("/delete-contributor")
    public void deletarContributor(Integer contributorId) {
        contributorService.deletarContributor(contributorId);
    }

    @PutMapping("/update-contributor")
    public Contributor alterarContributor(Contributor contributor) {
        return contributorService.alterarContributor(contributor);
    }
}
