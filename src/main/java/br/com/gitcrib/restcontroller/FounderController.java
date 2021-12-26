package br.com.gitcrib.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gitcrib.model.Founder;
import br.com.gitcrib.service.FounderService;

@RestController
public class FounderController {

    @Autowired
    private FounderService founderService;

    @PostMapping("/save-founder")
    public Founder cadastrarFounder(Founder founder) {
        return founderService.cadastrarFounder(founder);
    }

    @GetMapping("/find-founder")
    public Optional<Founder> consultarFounder(Integer founderId) {
        return founderService.consultarFounder(founderId);
    }

    @GetMapping("/list-founders")
    public List<Founder> consultarFounders() {
        return founderService.consultarFounders();
    }

    @DeleteMapping("/delete-founder")
    public void deletarFounder(Integer founderId) {
        founderService.deletarFounder(founderId);
    }

    @PutMapping("/update-founder")
    public Founder alterarFounder(Founder founder) {
        return founderService.alterarFounder(founder);
    }

}
