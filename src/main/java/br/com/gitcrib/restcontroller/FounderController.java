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

import br.com.gitcrib.dto.FounderDTO;
import br.com.gitcrib.service.FounderService;

@RestController
@RequestMapping("/founder")
public class FounderController {

    @Autowired
    private FounderService founderService;

    @PostMapping("/save-founder")
    @ResponseBody
    public FounderDTO cadastrarFounder(@Valid @RequestBody FounderDTO founder) {
        return founderService.cadastrarFounder(founder);
    }

    @GetMapping("/find-founder")
    @ResponseBody
    public Optional<FounderDTO> consultarFounder( @Valid@RequestBody FounderDTO founder) {
        return founderService.consultarFounder(founder.getFounderId());
    }

    @GetMapping("/list-founders")
    @ResponseBody
    public List<FounderDTO> consultarFounders() {
        return founderService.consultarFounders();
    }

    @DeleteMapping("/delete-founder")
    @ResponseBody
    public void deletarFounder(@Valid @RequestBody FounderDTO founder) {
        founderService.deletarFounder(founder.getFounderId());
    }

    @PutMapping("/update-founder")
    @ResponseBody
    public FounderDTO alterarFounder(@Valid @RequestBody FounderDTO founder) {
        return founderService.alterarFounder(founder);
    }

}
